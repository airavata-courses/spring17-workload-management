package org.apache.airavata.sga.graphdb.runner;

import org.apache.airavata.sga.commons.model.SchedulingRequest;
import org.apache.airavata.sga.graphdb.entity.State;
import org.apache.airavata.sga.graphdb.impl.Neo4JJavaDbOperation;
import org.apache.airavata.sga.graphdb.messaging.OrchestratorMessagePublisher;
import org.apache.airavata.sga.graphdb.messaging.OrchestratorMessagingFactory;
import org.apache.airavata.sga.graphdb.utils.Constants;
import org.apache.airavata.sga.graphdb.utils.DummySchedulingRequest;
import org.apache.airavata.sga.graphdb.utils.ExpTypes;
import org.apache.airavata.sga.messaging.service.core.Subscriber;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class OrchestratorRunner {
	 /** The Constant logger. */
    private static final Logger logger = LogManager.getLogger(OrchestratorRunner.class);
    private static OrchestratorMessagePublisher orchestratorMessagePublisher = new OrchestratorMessagePublisher();
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
        Neo4JJavaDbOperation neo4JJavaDbOperation = new Neo4JJavaDbOperation();
        SchedulingRequest schedulingRequest = null;

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

            String results = neo4JJavaDbOperation.getDag(ExpTypes.BIOLOGY.toString());
            String expId = "exp-11";
            schedulingRequest = DummySchedulingRequest.getSchedulingRequest(Constants.fromString(results), expId);
            State state = new State();
            state.setID(expId);
            state.setState(results);
            state.setExpType(ExpTypes.BIOLOGY.toString());
            orchestratorMessagePublisher.publishSchedulingRequest(state, schedulingRequest);

        } catch (Exception ex) {
            logger.error("Something went wrong with the Orchestrator runner. Error: " + ex, ex);
        }
    }
}
