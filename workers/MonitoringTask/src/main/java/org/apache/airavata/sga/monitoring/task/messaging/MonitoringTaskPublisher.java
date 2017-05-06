package org.apache.airavata.sga.monitoring.task.messaging;

import org.apache.airavata.sga.messaging.service.core.MessagingFactory;
import org.apache.airavata.sga.messaging.service.core.Publisher;
import org.apache.airavata.sga.monitoring.task.util.Constants;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Created by goshenoy on 4/19/17.
 */
public class MonitoringTaskPublisher {

    private static final Logger logger = LogManager.getLogger(MonitoringTaskPublisher.class);

    /** The publisher. */
    private static Publisher publisher;

    /** The scheduler publisher. */
    private static Publisher schedulerPublisher;

    /**
     * Gets the publisher.
     *
     * @return the publisher
     */
    public static Publisher getPublisher() {
        if (publisher == null) {
            logger.info("Initializing MonitoringTask publisher");
            publisher = MessagingFactory.getPublisher(Constants.MONITORING_RABBITMQ_PROPERTIES);
        }
        return publisher;
    }

    /**
     * Gets the scheduler publisher.
     *
     * @return the scheduler publisher
     */
    public static Publisher getSchedulerPublisher() {
        if (schedulerPublisher == null) {
            logger.info("Initializing Scheduler publisher");
            schedulerPublisher = MessagingFactory.getPublisher(Constants.SCHEDULER_RABBITMQ_PROPERTIES);
        }
        return schedulerPublisher;
    }

}
