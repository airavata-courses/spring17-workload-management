package org.apache.airavata.sga.graphdb.utils;

import org.apache.airavata.sga.commons.model.SchedulingRequest;
import org.apache.airavata.sga.graphdb.dao.EntityDAO;
import org.apache.airavata.sga.graphdb.dao.impl.EntityDAOImpl;
import org.apache.airavata.sga.graphdb.entity.ExperimentEntity;
import org.apache.airavata.sga.graphdb.entity.TaskStateEntity;
import org.apache.airavata.sga.graphdb.impl.Neo4JJavaDbOperation;
import org.apache.airavata.sga.graphdb.messaging.OrchestratorMessagePublisher;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by goshenoy on 4/20/17.
 */
public class OrchestratorUtil {

    private static final Logger logger = LoggerFactory.getLogger(OrchestratorUtil.class);
    private static OrchestratorMessagePublisher orchestratorMessagePublisher = new OrchestratorMessagePublisher();
    private static final EntityDAO DAO = new EntityDAOImpl();

    public static String submitJob(String experimentType) throws Exception {
        String experimentId = "exp" + UUID.randomUUID().toString().replaceAll("-", "");
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
                    arrNode[i].createRelationshipTo(arrNode[i+1], RelationshipType.withName(experimentId));
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

            // return experimentId
            return experimentId;
        } catch (Exception ex) {
            logger.error("Error running OrchestratorMock, reason: " + ex, ex);
            throw ex;
        }
    }

    public static ExperimentEntity getExperiment(String experimentId) throws Exception {
        return DAO.getExperimentEntity(experimentId);
    }

    public static TaskStateEntity getTaskStateEntity(String taskId) throws Exception {
        return DAO.getTaskStateEntity(taskId);
    }

    public static List<TaskStateEntity> getTasksForExperiment(String experimentId) throws Exception {
        return DAO.getTaskListForExperiment(experimentId);
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
}
