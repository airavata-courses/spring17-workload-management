import org.apache.airavata.sga.commons.model.SchedulingRequest;
import org.apache.airavata.sga.graphdb.dao.EntityDAO;
import org.apache.airavata.sga.graphdb.dao.impl.EntityDAOImpl;
import org.apache.airavata.sga.graphdb.entity.ExperimentEntity;
import org.apache.airavata.sga.graphdb.impl.Neo4JJavaDbOperation;
import org.apache.airavata.sga.graphdb.messaging.OrchestratorMessagePublisher;
import org.apache.airavata.sga.graphdb.utils.*;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.*;

/**
 * Created by goshenoy on 4/14/17.
 */
public class OrchestratorMock {
    private static final Logger logger = LoggerFactory.getLogger(OrchestratorMock.class);
    private static OrchestratorMessagePublisher orchestratorMessagePublisher = new OrchestratorMessagePublisher();
    private static final EntityDAO DAO = new EntityDAOImpl();
    private static final int ATTEMPTS = 5;
    private static final int SLEEP_TIME = 4000;
    private static final int NO_OF_EXP = 1;

    @DataProvider(name = "ExpDataProvider")
    public static Object[][] expData() {
        Object[][] expData = new Object[NO_OF_EXP][2];
        for(int i=0; i<NO_OF_EXP; i++){
            expData[i][0] =  "exp" + UUID.randomUUID().toString().replaceAll("-", "");
            expData[i][1] = getRandomExperimentType();
        }
        return expData;

    }

//    public static void main(String[] args) {
//
//        // increase count here to control number of JOB-SUBMISSIONS
//        for (int i=0; i<1; i++) {
//            new Thread() {
//                @Override
//                public void run() {
//                    System.out.println("Thread: " + Thread.currentThread().getId() + " | Running Now...");
//                    //recoverJobs();
//                    submitJob("exp" + UUID.randomUUID().toString().replaceAll("-", ""), getRandomExperimentType());
//                    stop();
//                }
//
//                @Override
//                protected void finalize() throws Throwable {
//                    super.finalize();
//                    System.out.println("[" + Thread.currentThread().getId() + "] Terminating...");
//                }
//            }.start();
//        }
//    }

    private static void recoverJobs(){
        logger.info("Retrieving incomplete jobs from zookeeper");
        Neo4JJavaDbOperation neo4JJavaDbOperation = new Neo4JJavaDbOperation();
        try {
            List<String> expIds = ZKUtils.getExpZKNodes(ZKUtils.getCuratorClient());
            logger.info("Retrieved incomplete jobs from zookeeper : " + expIds);

            for(String expId : expIds){
                logger.info("Recovering exp : " + expIds);
                SchedulingRequest schedulingRequest = neo4JJavaDbOperation.getSchedulingRequestFromNode(expId);
                orchestratorMessagePublisher.publishSchedulingRequest(schedulingRequest);
            }

        } catch (Exception e) {
            logger.error("Error recovering jobs", e);
        }
    }

    @Test(invocationCount = 1, threadPoolSize = 1, description = "Test Job Submission", suiteName = "Suit1", dataProvider = "ExpDataProvider", groups = { "Exp" })
    private static void submitJob(String experimentId, String experimentType) {
        try {
            Neo4JJavaDbOperation neo4JJavaDbOperation = new Neo4JJavaDbOperation();
            SchedulingRequest schedulingRequest = null;
            List<String> nodesList = null;
            // get scheduling request
            System.out.println("[" + Thread.currentThread().getId() + "] Getting DAG for ExperimentType: " + experimentType);

            nodesList = neo4JJavaDbOperation.getCompleteDag(experimentType);

            Node[] arrNode = new Node[nodesList.size()];
            File f = new File(Constants.GRAPH_DB_LOCATION);
            GraphDatabaseFactory dbFactory = new GraphDatabaseFactory();
            GraphDatabaseService db = dbFactory.newEmbeddedDatabase(f);
            try (Transaction tx = db.beginTx()){
                for(int i = 0; i < nodesList.size(); i++){
                    arrNode[i] = db.createNode(Label.label(nodesList.get(i)));
                    schedulingRequest = DummySchedulingRequest.getSchedulingRequest(Constants.fromString(nodesList.get(i)), experimentId);
                    byte[] schdReq = SerializationUtils.convertToBytes(schedulingRequest);
                    arrNode[i].setProperty("schedulingRequest",schdReq);
                    arrNode[i].setProperty("taskType",Constants.fromString(nodesList.get(i)).toString());
                    arrNode[i].setProperty("isExecuted","false");
                }
                for(int i = 0; i < arrNode.length-1; i++){
                    arrNode[i].createRelationshipTo(arrNode[i+1],RelationshipType.withName(experimentId));
                }
                tx.success();
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                db.shutdown();
            }

            logger.info("creating zookeeper node for experiment : " + experimentId);
            ZKUtils.createExpZKNode(ZKUtils.getCuratorClient(), experimentId);

            logger.info("Get scheduling request for experiment : " +experimentId );
            schedulingRequest = neo4JJavaDbOperation.getSchedulingRequestFromNode(experimentId);

            logger.info("Creating record in database for experimentId: {} and type: {}", experimentId, experimentType);
            createExperimentRecord(experimentId, experimentType);

            // submit orchestrator request
            logger.info("[" + Thread.currentThread().getId() + "] Submitting Orchestrator Request for ExperimentType: " + experimentType + ", experimentId: " + experimentId);
            orchestratorMessagePublisher.publishSchedulingRequest(schedulingRequest);

            ExperimentEntity experimentEntity;
            int cnt = ATTEMPTS;
            boolean isExecutedSuccessfully = false;
            while(cnt>0){
                Thread.sleep(SLEEP_TIME);
                experimentEntity = DAO.getExperimentEntity(experimentId);
                if(experimentEntity.getExperimentStatus().equals(Constants.ExperimentStatus.COMPLETE) ||
                        experimentEntity.getExperimentStatus().equals(Constants.ExperimentStatus.FAILED)){
                    isExecutedSuccessfully = true;
                    break;
                }
                cnt --;
            }
            if(cnt == 0){
                logger.error("Failed to execute in dedicated time. Exp : " + experimentId + ", Time : " + SLEEP_TIME/1000*ATTEMPTS + " seconds");
                Assert.fail("Failed to execute in dedicated time. Exp : " + experimentId + ", Time : " + SLEEP_TIME/1000*ATTEMPTS + " seconds");
            }
            Assert.assertEquals(isExecutedSuccessfully, true);
        } catch (Exception ex) {
            logger.error("Error running OrchestratorMock",  ex);
            Assert.fail("Error executing experiment : " + experimentId);
        }
    }

    private static void createExperimentRecord(String experimentId, String experimentType) throws Exception {
        ExperimentEntity experimentEntity = new ExperimentEntity();
        experimentEntity.setExperimentId(experimentId);
        experimentEntity.setExperimentType(experimentType);
        experimentEntity.setExperimentName("EXP_" + experimentId);
        experimentEntity.setExperimentStatus(Constants.ExperimentStatus.RUNNING.name());
        experimentEntity.setExperimentStartTime(new Date());
        DAO.saveEntity(experimentEntity);
        logger.info("Created new experiment record for ExperimentEntity: {}", experimentEntity);
    }

    private static String getRandomExperimentType() {
        List<ExpTypes> expTypesList = new ArrayList<ExpTypes>(Arrays.asList(ExpTypes.values()));
        return expTypesList.get(
                new Random().nextInt(expTypesList.size())
        ).toString();
    }
}
