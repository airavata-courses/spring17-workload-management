import org.apache.airavata.sga.commons.model.SchedulingRequest;
import org.apache.airavata.sga.graphdb.entity.State;
import org.apache.airavata.sga.graphdb.impl.Neo4JJavaDbOperation;
import org.apache.airavata.sga.graphdb.messaging.OrchestratorMessagePublisher;
import org.apache.airavata.sga.graphdb.utils.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import java.io.File;
import java.util.*;

/**
 * Created by goshenoy on 4/14/17.
 */
public class OrchestratorMock {
    private static final Logger logger = LogManager.getLogger(OrchestratorMock.class);
    private static OrchestratorMessagePublisher orchestratorMessagePublisher = new OrchestratorMessagePublisher();

    public static void main(String[] args) {

        // increase count here to control number of JOB-SUBMISSIONS
        for (int i=0; i<1; i++) {
            new Thread() {
                @Override
                public void run() {
                    System.out.println("Thread: " + Thread.currentThread().getId() + " | Running Now...");
                    recoverJobs();
                    submitJob("exp" + UUID.randomUUID().toString().replaceAll("-", ""), getRandomExperimentType());
                    stop();
                }

                @Override
                protected void finalize() throws Throwable {
                    super.finalize();
                    System.out.println("[" + Thread.currentThread().getId() + "] Terminating...");
                }
            }.start();
        }
    }

    private static void recoverJobs(){
        logger.info("Retrieving incomplete jobs from zookeeper");
        Neo4JJavaDbOperation neo4JJavaDbOperation = new Neo4JJavaDbOperation();
        try {
            List<String> expIds = ZKUtils.getExpZKNodes(ZKUtils.getCuratorClient());
            logger.info("Retrieved incomplete jobs from zookeeper : " + expIds);

            for(String expId : expIds){
                logger.info("Recovering exp : " + expIds);
                SchedulingRequest schedulingRequest = neo4JJavaDbOperation.getSchedulingRequestFromNode(expId);
                orchestratorMessagePublisher.publishSchedulingRequest(null, schedulingRequest);
            }

        } catch (Exception e) {
            logger.error("Error recovering jobs", e);
        }
    }

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
                    //arrNode[i].setProperty("schedulingRequest",Constants.fromString(nodesList.get(i)).toString());
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

            logger.info("creating zookeeper node for exp : " + experimentId);
            ZKUtils.createExpZKNode(ZKUtils.getCuratorClient(), experimentId);

            System.out.println("[" + Thread.currentThread().getId() + "] Submitting Orchestrator Request for ExperimentType: " + experimentType + ", experimentId: " + experimentId);
            schedulingRequest = neo4JJavaDbOperation.getSchedulingRequestFromNode(experimentId);
//            for (String key : resultNode.getPropertyKeys()) {
//                System.out.println("Key: " + key + ", Value: " +  resultNode.getProperty(key));
//            }
           // schedulingRequest = DummySchedulingRequest.getSchedulingRequest(Constants.fromString(results), experimentId);

            // save the state in db
//            State state = new State();
//            state.setID(experimentId);
//            //state.setState(results);
//            state.setExpType(experimentType);

            // submit orchestrator request
            orchestratorMessagePublisher.publishSchedulingRequest(null, schedulingRequest);
            System.exit(0);
        } catch (Exception ex) {
            logger.error("Error running OrchestratorMock, reason: " + ex, ex);
        }
    }

    private static String getRandomExperimentType() {
        List<ExpTypes> expTypesList = new ArrayList<ExpTypes>(Arrays.asList(ExpTypes.values()));
        return expTypesList.get(
                new Random().nextInt(expTypesList.size())
        ).toString();
    }
}
