package org.apache.airavata.sga.graphdb.messaging;

import org.apache.airavata.sga.commons.model.DataStagingDirection;
import org.apache.airavata.sga.commons.model.SchedulingRequest;
import org.apache.airavata.sga.graphdb.dao.EntityDAO;
import org.apache.airavata.sga.graphdb.dao.impl.EntityDAOImpl;
import org.apache.airavata.sga.graphdb.entity.ExperimentEntity;
import org.apache.airavata.sga.graphdb.entity.TaskStateEntity;
import org.apache.airavata.sga.graphdb.utils.Constants;
import org.apache.airavata.sga.graphdb.utils.States;
import org.apache.airavata.sga.messaging.service.core.MessagingFactory;
import org.apache.airavata.sga.messaging.service.core.Publisher;
import org.apache.airavata.sga.messaging.service.util.MessageContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.UUID;

import static org.apache.airavata.sga.commons.scheduler.RabbitMQConstants.logger;

/**
 * Created by Amruta on 3/23/2017.
 */
public class OrchestratorMessagePublisher {

    private static final Logger logger = LoggerFactory.getLogger(OrchestratorMessagePublisher.class);

    private static final EntityDAO DAO = new EntityDAOImpl();
    private static Publisher orchestratorResponsePublisher;

    public static Publisher getOrchestratorResponsePublisher(){

        if (orchestratorResponsePublisher == null) {
            logger.info("Initializing Environment Setup subscriber");
            orchestratorResponsePublisher = MessagingFactory.getPublisher(Constants.ORCHESTRATOR_RESPONSE_RABBITMQ_PROPERTIES);
        }
        return orchestratorResponsePublisher;
    }

    public void publishSchedulingRequest(SchedulingRequest schedulingRequest){
        try{
            String experimentId = schedulingRequest.getTaskContext().getExperiment().getExperimentId();
            String taskId = schedulingRequest.getTaskContext().getTaskId();

            // create task record for experiment
            logger.info("Logging start of Task activity for TaskId: {}, ExperimentId: {}", taskId, experimentId);
            logTaskStartActivity(experimentId, taskId,
                    schedulingRequest.getTaskContext().getQueueName(),
                    schedulingRequest.getTaskContext().getDataStagingDirection());

            // send SchedulingRequest message to scheduler
            MessageContext messageContext = new MessageContext(schedulingRequest, experimentId);
            OrchestratorMessagingFactory.getOrchestratorMessagePublisher().publish(messageContext);
        }catch (Exception ex) {
            logger.error("Failed to publish [Orchestrator -> Scheduler]. Reason: " + ex.getMessage(), ex);
        }

    }

    private void logTaskStartActivity(String experimentId, String taskId, String taskQueueName, DataStagingDirection dataStagingDirection) throws Exception {
        ExperimentEntity experimentEntity = DAO.getExperimentEntity(experimentId);
        if (experimentEntity != null) {
            TaskStateEntity taskStateEntity = new TaskStateEntity();
            taskStateEntity.setExperiment(experimentEntity);
            taskStateEntity.setTaskId(taskId);
            taskStateEntity.setTaskStartTime(new Date());
            States states = Constants.getTaskFromQueueName(taskQueueName, dataStagingDirection);
            if (states != null) {
                taskStateEntity.setTaskName(states.getName());
            } else {
                throw new Exception("Invalid taskQueueName: " + taskQueueName + ", unable to get TaskName!");
            }
            DAO.saveEntity(taskStateEntity);
        } else {
            throw new Exception("Cannot find Experiment with ID: " + experimentId);
        }
    }
}
