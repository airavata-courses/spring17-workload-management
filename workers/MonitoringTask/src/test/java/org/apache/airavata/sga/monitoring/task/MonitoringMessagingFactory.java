package org.apache.airavata.sga.monitoring.task;

import org.apache.airavata.sga.messaging.service.core.MessagingFactory;
import org.apache.airavata.sga.messaging.service.core.Publisher;
import org.apache.airavata.sga.monitoring.task.util.Constants;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Created by goshenoy on 4/19/17.
 */
public class MonitoringMessagingFactory {

    private static final Logger logger = LogManager.getLogger(MonitoringMessagingFactory.class);

    private static Publisher monitoringPublisher;

    public static Publisher getMonitoringPublisher() {
        logger.info("Getting monitoring publisher!");
        if (monitoringPublisher == null) {
            logger.info("Initializing Monitoring Publisher");
            monitoringPublisher = MessagingFactory.getPublisher(Constants.MONITORING_RABBITMQ_PROPERTIES);
        }
        return monitoringPublisher;
    }
}
