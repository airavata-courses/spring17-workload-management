package org.apache.airavata.sga.monitoring.task.messaging;

import org.apache.airavata.sga.commons.model.Response;
import org.apache.airavata.sga.commons.model.TaskContext;
import org.apache.airavata.sga.commons.task.CommonTask;
import org.apache.airavata.sga.messaging.service.core.MessageHandler;
import org.apache.airavata.sga.messaging.service.core.Publisher;
import org.apache.airavata.sga.messaging.service.model.Message;
import org.apache.airavata.sga.messaging.service.util.MessageContext;
import org.apache.airavata.sga.messaging.service.util.ThriftUtils;
import org.apache.airavata.sga.monitoring.task.impl.MonitoringTaskImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.thrift.TBase;

/**
 * Created by goshenoy on 4/19/17.
 */
public class MonitoringMessageHandler implements MessageHandler {

    private static final Logger logger = LogManager.getLogger(MonitoringMessageHandler.class);

    @Override
    public void onMessage(MessageContext messageContext) {
        try {
            // get the message
            TBase<?, ?> event = messageContext.getEvent();
            byte[] bytes = ThriftUtils.serializeThriftObject(event);

            Message message = new Message();
            ThriftUtils.createThriftFromBytes(bytes, message);

            // get taskcontext from message
            TaskContext taskContext = new TaskContext();
            ThriftUtils.createThriftFromBytes(message.getEvent(), taskContext);

            // fetch experimentId from taskcontext
            logger.info("Received monitoring task, with taskContext: " + taskContext);
            String experimentId = taskContext.getExperiment().getExperimentId();

            // execute the task
            CommonTask task = new MonitoringTaskImpl();
            Response response = task.execute(taskContext);
            logger.info("MonitoringTask Response | expId: " + experimentId
                    + ", response: " + response);

            // publish message back to scheduler
            logger.info("Sending response [Monitoring -> Scheduler], for expId: " + experimentId);
            Publisher publisher = MonitoringTaskPublisher.getSchedulerPublisher();
            logger.info("publisher: " + publisher);
            if (publisher != null) {
                MessageContext responseMsg = new MessageContext(response, experimentId);
                publisher.publish(responseMsg);
            }
        } catch (Exception ex) {
            logger.error("Error performing monitoring task, ex: " + ex, ex);
        }
    }
}
