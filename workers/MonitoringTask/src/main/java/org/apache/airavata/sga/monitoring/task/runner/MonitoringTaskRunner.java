package org.apache.airavata.sga.monitoring.task.runner;

import org.apache.airavata.sga.messaging.service.core.MessagingFactory;
import org.apache.airavata.sga.messaging.service.core.Subscriber;
import org.apache.airavata.sga.monitoring.task.messaging.MonitoringMessageHandler;
import org.apache.airavata.sga.monitoring.task.util.Constants;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Created by goshenoy on 4/19/17.
 */
public class MonitoringTaskRunner {
    private static final Logger logger = LogManager.getLogger(MonitoringTaskRunner.class);
    private Subscriber monitoringSubscriber;

    /**
     * Start job monitoring task runner.
     */
    public void startMonitoringTaskRunner() {
        try {
            logger.info("Initializing MonitoringTask subscriber");
            monitoringSubscriber = MessagingFactory.getSubscriber(new MonitoringMessageHandler(),
                    Constants.MONITORING_RABBITMQ_PROPERTIES);
            logger.info("MonitoringTask subscriber now listening: " + monitoringSubscriber);
        } catch (Exception ex) {
            logger.error("Something went wrong starting MonitoringTask subscriber. Error: " + ex, ex);
        }
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        try {
            Runnable runner = new Runnable() {
                @Override
                public void run() {
                    MonitoringTaskRunner monitoringTaskRunner = new MonitoringTaskRunner();
                    monitoringTaskRunner.startMonitoringTaskRunner();
                }
            };

            // start the worker thread
            logger.info("Starting the MonitoringTask worker.");
            new Thread(runner).start();
        } catch (Exception ex) {
            logger.error("Something went wrong with the MonitoringTask runner. Error: " + ex, ex);
        }
    }
}
