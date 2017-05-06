package org.apache.airavata.sga.graphdb.messaging;

import org.apache.airavata.sga.commons.model.Response;
import org.apache.airavata.sga.commons.model.SchedulingRequest;
import org.apache.airavata.sga.commons.model.Status;
import org.apache.airavata.sga.graphdb.dao.EntityDAO;
import org.apache.airavata.sga.graphdb.dao.impl.EntityDAOImpl;
import org.apache.airavata.sga.graphdb.entity.ExperimentEntity;
import org.apache.airavata.sga.graphdb.entity.State;
import org.apache.airavata.sga.graphdb.entity.TaskStateEntity;
import org.apache.airavata.sga.graphdb.impl.Neo4JJavaDbOperation;
import org.apache.airavata.sga.graphdb.utils.Constants;
import org.apache.airavata.sga.graphdb.utils.DummySchedulingRequest;
import org.apache.airavata.sga.graphdb.utils.States;
import org.apache.airavata.sga.graphdb.utils.ZKUtils;
import org.apache.airavata.sga.messaging.service.core.MessageHandler;
import org.apache.airavata.sga.messaging.service.model.Message;
import org.apache.airavata.sga.messaging.service.util.MessageContext;
import org.apache.airavata.sga.messaging.service.util.ThriftUtils;
import org.apache.thrift.TBase;
import org.neo4j.graphdb.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class OrchestratorResponseHandler implements MessageHandler{
	 /** The Constant logger. */
    private static final Logger logger = LoggerFactory.getLogger(OrchestratorResponseHandler.class);
    private static final EntityDAO DAO = new EntityDAOImpl();
    private Neo4JJavaDbOperation neo4JJavaDbOperation = new Neo4JJavaDbOperation();
    private OrchestratorMessagePublisher orchestratorMessagePublisher = new OrchestratorMessagePublisher();

    @Override
    public void onMessage(MessageContext messageContext) {
        try {
            // get the message
            logger.info("onMessage() -> New message received. Message Id : " + messageContext.getMessageId());
            TBase<?, ?> event = messageContext.getEvent();
            byte[] bytes = ThriftUtils.serializeThriftObject(event);

            Message message = new Message();
            ThriftUtils.createThriftFromBytes(bytes, message);

            // get response from message
            Response response = new Response();
            ThriftUtils.createThriftFromBytes(message.getEvent(), response);
            logger.info("onMessage() -> Received response from scheduler: " + response);

            // if response status is not ACCEPTED, then TASK has finished
            if (!response.getStatus().equals(Status.ACCEPTED)) {
                logger.info("Task with TaskId: {}, for ExperimentID: {} is now complete.", response.getTaskId(), response.getExperimentId());
                logEndOfTaskActivity(response.getTaskId());
            }

            //State currentState = DAO.getState(response.getExperimentId());
            if (response.getStatus().equals(Status.FAILED)) {
                logger.error("onMessage() -> ExperimentEntity: {} has failed!");
                // update experiment status in db
                changeExperimentStatus(response.getExperimentId(), Constants.ExperimentStatus.FAILED);
                //FIXME: handle FAILED status gracefully
                //FIXME: should we delete zk-node for this exp??
            }
            else if (response.getStatus().equals(Status.ACCEPTED)) {
                // task is still executing, just log and continue
                logger.info("onMessage() -> ExperimentEntity: {} is currently performing task: {}. Waiting for this task to complete!",
                        response.getExperimentId(), "MONITORING");
                // FIXME: currently only monitoring sends ACCEPTED
            }
            else {
                SchedulingRequest schedulingRequest = neo4JJavaDbOperation.setExecutedAndGetNextNode(response.getExperimentId());
                if (null != schedulingRequest) {
                    orchestratorMessagePublisher.publishSchedulingRequest(schedulingRequest);
                } else {
                    // update experiment status in db
                    logger.info("Experiment with Id: {} is now COMPLETE!", response.getExperimentId());
                    changeExperimentStatus(response.getExperimentId(), Constants.ExperimentStatus.COMPLETE);
                    // delete exp zk-node to avoid restart during recovery
                    logger.info("deleting zookeeper node for exp : " + response.getExperimentId());
                    ZKUtils.deleteZKNode(ZKUtils.getCuratorClient(), response.getExperimentId());
                }
            }
        } catch (Exception ex) {
            logger.error("Error receiving response from task, ex: " + ex, ex);
        }
    }

    private void changeExperimentStatus(String experimentId, Constants.ExperimentStatus experimentStatus) throws Exception {
        ExperimentEntity experimentEntity = DAO.getExperimentEntity(experimentId);
        if (experimentEntity != null) {
            experimentEntity.setExperimentStatus(experimentStatus.name());
            experimentEntity.setExperimentLastUpdatedTime(new Date());

            if (experimentStatus.equals(Constants.ExperimentStatus.COMPLETE) ||
                    experimentStatus.equals(Constants.ExperimentStatus.FAILED)) {
                experimentEntity.setExperimentEndTime(new Date());
            }
            logger.info("Updating the status to: {}, for ExperimentId: {} ", experimentStatus, experimentId);
            DAO.saveEntity(experimentEntity);
        } else {
            throw new Exception("Could not find ExperimentEntity with Id: " + experimentId);
        }
    }

    private void logEndOfTaskActivity(String taskId) throws Exception {
        TaskStateEntity taskStateEntity = DAO.getTaskStateEntity(taskId);
        if (taskStateEntity != null) {
            taskStateEntity.setTaskEndTime(new Date());
            logger.info("Setting endTime for task: {} ", taskId);
            DAO.saveEntity(taskStateEntity);
        } else {
            throw new Exception("Could not find TaskStateEntity with Id: " + taskId);
        }
    }
}
