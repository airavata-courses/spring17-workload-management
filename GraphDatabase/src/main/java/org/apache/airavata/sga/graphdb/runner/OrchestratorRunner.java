package org.apache.airavata.sga.graphdb.runner;

import org.apache.airavata.sga.commons.model.SchedulingRequest;
import org.apache.airavata.sga.graphdb.handler.OrchestratorServerHandler;
import org.apache.airavata.sga.graphdb.impl.Neo4JJavaDbOperation;
import org.apache.airavata.sga.graphdb.messaging.OrchestratorMessagePublisher;
import org.apache.airavata.sga.graphdb.messaging.OrchestratorMessagingFactory;
import org.apache.airavata.sga.graphdb.service.OrchestratorService;
import org.apache.airavata.sga.graphdb.service.OrchestratorService.Iface;
import org.apache.airavata.sga.graphdb.utils.DagCreation;
import org.apache.airavata.sga.graphdb.utils.ZKUtils;
import org.apache.airavata.sga.messaging.service.core.Subscriber;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class OrchestratorRunner {
	 /** The Constant logger. */
    private static final Logger logger = LoggerFactory.getLogger(OrchestratorRunner.class);
    private static OrchestratorMessagePublisher orchestratorMessagePublisher = new OrchestratorMessagePublisher();
    private Subscriber subscriber;

    private static OrchestratorService.Processor<Iface> processor;
    private static OrchestratorServerHandler handler;

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

    private static void startOrchestratorServer(OrchestratorService.Processor<Iface> processor) {
        try {
            logger.info("OrchestratorService starting simple-server listening to port 9090");
            TServerTransport serverTransport = new TServerSocket(9090);
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));
            server.serve();
        } catch (Exception ex) {
            logger.error("Something went wrong starting Orchestrator Server. Error: " + ex.getMessage(), ex);
        } finally {
            logger.info("OrchestratorService stopped!");
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

        handler = new OrchestratorServerHandler();
        processor = new OrchestratorService.Processor<Iface>(handler);

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

            Runnable thriftServer = new Runnable() {
                @Override
                public void run() {
                    startOrchestratorServer(processor);
                }
            };

            // start the worker thread
            logger.info("Starting the Orchestrator.");
            new Thread(runner).start();

            // recover existing jobs
            logger.info("Recovering lost jobs.");
            new Thread(recovery).start();

            // start thrift server
            logger.info("Starting Orchestrator Thrift Server.");
            new Thread(thriftServer).start();
        } catch (Exception ex) {
            logger.error("Something went wrong with the Orchestrator runner. Error: " + ex, ex);
        }
    }
}
