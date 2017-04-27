package org.apache.airavata.sga.graphdb.runner;

import org.apache.airavata.sga.commons.model.SchedulingRequest;
import org.apache.airavata.sga.graphdb.impl.Neo4JJavaDbOperation;
import org.apache.airavata.sga.graphdb.messaging.OrchestratorMessagePublisher;
import org.apache.airavata.sga.graphdb.messaging.OrchestratorMessagingFactory;
import org.apache.airavata.sga.graphdb.utils.DagCreation;
import org.apache.airavata.sga.graphdb.utils.ZKUtils;
import org.apache.airavata.sga.messaging.service.core.Subscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class OrchestratorRunner {
	 /** The Constant logger. */
    private static final Logger logger = LoggerFactory.getLogger(OrchestratorRunner.class);
    private static OrchestratorMessagePublisher orchestratorMessagePublisher = new OrchestratorMessagePublisher();
    private Subscriber subscriber;

    private void startOrchestratorRunner() {

        try {
            logger.info("Creating DAG for WorkloadMgr at: ");
            DagCreation.main(new String[] {});
            logger.info("Successfully created DAG");

            logger.info("Initializing orchestrator message subscriber");
            subscriber = OrchestratorMessagingFactory.getOrchestratorResponseSubscriber();
            logger.info("Orchestrator Response subscriber now listening: " + subscriber);

        } catch (Exception ex) {
            logger.error("Something went wrong starting subscriber. Error: " + ex, ex);
        }
    }

    private void recoverJobs() {
        logger.info("Retrieving incomplete jobs from zookeeper.");
        Neo4JJavaDbOperation neo4JJavaDbOperation = new Neo4JJavaDbOperation();
        List<String> expIds = new ArrayList<>();
        try {
            ZKUtils.getExpZKNodes(ZKUtils.getCuratorClient());
            logger.info("Retrieved incomplete jobs from zookeeper: " + expIds);
        } catch (Exception e) {
            logger.error("Error recovering jobs. Reason: " + e.getMessage(), e);
        }

        for(String expId : expIds){
            logger.info("Resuming job: {} from where it left off.", expId);
            SchedulingRequest schedulingRequest = neo4JJavaDbOperation.getSchedulingRequestFromNode(expId);
            orchestratorMessagePublisher.publishSchedulingRequest(schedulingRequest);
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

            Runnable recovery = new Runnable() {
                @Override
                public void run() {
                    OrchestratorRunner orchestratorRunner = new OrchestratorRunner();
                    orchestratorRunner.recoverJobs();
                }
            };

            // start the worker thread
            logger.info("Starting the Orchestrator.");
            new Thread(runner).start();

            // recover existing jobs
            logger.info("Recovering lost jobs.");
//            new Thread(recovery).start();

            // Moved below logic to OrchestratorMock in src/test/java
            /*
            String results = neo4JJavaDbOperation.getDag(ExpTypes.BIOLOGY.toString());
            String expId = "exp-12";
            schedulingRequest = DummySchedulingRequest.getSchedulingRequest(Constants.fromString(results), expId);
            State state = new State();
            state.setID(expId);
            state.setState(results);
            state.setExpType(ExpTypes.BIOLOGY.toString());

            orchestratorMessagePublisher.publishSchedulingRequest(state, schedulingRequest);
            */

        } catch (Exception ex) {
            logger.error("Something went wrong with the Orchestrator runner. Error: " + ex, ex);
        }
    }
}
