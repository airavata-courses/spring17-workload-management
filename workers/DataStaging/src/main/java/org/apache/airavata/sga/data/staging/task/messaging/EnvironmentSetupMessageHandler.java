package org.apache.airavata.sga.data.staging.task.messaging;

import org.apache.airavata.sga.commons.model.Response;
import org.apache.airavata.sga.commons.model.TaskContext;
import org.apache.airavata.sga.commons.task.CommonTask;
import org.apache.airavata.sga.data.staging.task.handler.impl.EnvironmentSetupTaskImpl;
import org.apache.airavata.sga.messaging.service.core.MessageHandler;
import org.apache.airavata.sga.messaging.service.model.Message;
import org.apache.airavata.sga.messaging.service.util.MessageContext;
import org.apache.airavata.sga.messaging.service.util.ThriftUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.thrift.TBase;
import org.apache.thrift.TException;

import java.io.IOException;

/**
 * Created by Ajinkya on 2/22/17.
 */
public class EnvironmentSetupMessageHandler implements MessageHandler {

    /** The Constant logger. */
    private static final Logger logger = LogManager.getLogger(EnvironmentSetupMessageHandler.class);

    @Override
    public void onMessage(MessageContext messageContext) {
        try {

            logger.info("onMessage() -> New message received. Message Id : " + messageContext.getMessageId());

            TBase event = messageContext.getEvent();
            byte[] bytes = ThriftUtils.serializeThriftObject(event);

            Message message = new Message();
            ThriftUtils.createThriftFromBytes(bytes, message);

            TaskContext taskContext = new TaskContext();
            ThriftUtils.createThriftFromBytes(message.getEvent(), taskContext);

            logger.info("onMessage() -> Handling environment setup task. Message Id : " + messageContext.getMessageId()
                    + ", taskId: " + taskContext.getTaskId()
                    + ", Experiment Id : " +  taskContext.getExperiment().getExperimentId());

            CommonTask task = new EnvironmentSetupTaskImpl();
            Response response = task.execute(taskContext);
            logger.debug("onMessage() -> Environment setup completed. Message Id : " + messageContext.getMessageId()
                    + ", taskId: " + taskContext.getTaskId()
                    + ", Experiment Id : " +  taskContext.getExperiment().getExperimentId());

            logger.info("onMessage() -> Sending response back [EnvSetup -> Scheduler] for expId: " +  taskContext.getExperiment().getExperimentId());
            MessageContext responseMsg = new MessageContext(response, taskContext.getExperiment().getExperimentId());
            SchedulerMessageFactory.getSchedulerPublisher().publish(responseMsg);

            logger.info("onMessage() -> Sending ack for message. Message Id : " + messageContext.getMessageId() + ", Delivery Tag : " + messageContext.getDeliveryTag());
            EnvironmentSetupTaskMessagingFactory.getSubscriber().sendAck(messageContext.getDeliveryTag());
            logger.debug("onMessage() -> Ack sent. Message Id : " + messageContext.getMessageId() + ", Experiment Id : " +  taskContext.getExperiment().getExperimentId());

        } catch (TException e) {
            logger.error("onMessage() -> Error processing message. Message Id : " + messageContext.getMessageId(), e);
        } catch (IOException e) {
            logger.error("onMessage() -> Error acknowledging to message. Message Id : " + messageContext.getMessageId() + ", Delivery Tag : " + messageContext.getDeliveryTag(), e);
        } catch (Exception e) {
            logger.error("onMessage() -> Error sending response back to scheduler. Message Id : " + messageContext.getMessageId() + ", Delivery Tag : " + messageContext.getDeliveryTag(), e);
        }
    }
}
