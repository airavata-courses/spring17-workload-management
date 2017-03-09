package org.apache.airavata.sga.graphdb.runner;

import org.apache.airavata.sga.graphdb.messaging.OrchestratorMessagingFactory;
import org.apache.airavata.sga.messaging.service.core.Subscriber;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class OrchestratorRunner {
	 /** The Constant logger. */
    private static final Logger logger = LogManager.getLogger(OrchestratorRunner.class);

    private Subscriber subscriber;

    private void startOrchestratorRunner() {

        try {
            logger.info("Initializing orchestrator message subscriber");
            subscriber = OrchestratorMessagingFactory.getOrchestratorResponseSubscriber();
            logger.info("Orchestrator Response subscriber now listening: " + subscriber);

        } catch (Exception ex) {
            logger.error("Something went wrong starting subscriber. Error: " + ex, ex);
        }
    }

    public static void main(String[] args) {
        try {
            Runnable runner = new Runnable() {
                @Override
                public void run() {
                	OrchestratorRunner orchestratorRunner = new OrchestratorRunner();
                	orchestratorRunner.startOrchestratorRunner();
                }
            };

            // start the worker thread
            logger.info("Starting the Orchestrator.");
            new Thread(runner).start();
        } catch (Exception ex) {
            logger.error("Something went wrong with the Orchestrator runner. Error: " + ex, ex);
        }
    }
}
