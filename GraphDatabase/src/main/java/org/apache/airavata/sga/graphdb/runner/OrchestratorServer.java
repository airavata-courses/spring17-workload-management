package org.apache.airavata.sga.graphdb.runner;

import org.apache.airavata.sga.commons.utils.IServer;
import org.apache.airavata.sga.graphdb.handler.OrchestratorServerHandler;
import org.apache.airavata.sga.graphdb.service.OrchestratorService;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;

/**
 * Created by goshenoy on 4/28/17.
 */
public class OrchestratorServer {
    private final static Logger logger = LoggerFactory.getLogger(OrchestratorServer.class);

    private final static String SERVER_NAME = "Orchestrator Service Server";
    private final static String SERVER_VERSION = "1.0";

    private IServer.ServerStatus status;
    private TServer server;

    public  OrchestratorServer () {
        setStatus(IServer.ServerStatus.STOPPED);
    }

    public void start() throws Exception {
        try {
            setStatus(IServer.ServerStatus.STARTING);
            OrchestratorService.Processor<OrchestratorService.Iface> processor =
                    new OrchestratorService.Processor<OrchestratorService.Iface>(new OrchestratorServerHandler());

            TServerTransport transport = new TServerSocket(9090);
            TThreadPoolServer.Args options = new TThreadPoolServer.Args(transport);
            options.minWorkerThreads = 30;
            server = new TThreadPoolServer(options.processor(processor));

            new Thread() {
                public void run() {
                    server.serve();
                    setStatus(IServer.ServerStatus.STOPPED);
                    logger.info("User Profile Server Stopped.");
                }
            }.start();
            new Thread() {
                public void run() {
                    while (!server.isServing()) {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            break;
                        }
                    }
                    if (server.isServing()) {
                        setStatus(IServer.ServerStatus.STARTED);
                        logger.info("Starting User Profile Server on Port: 9090. Listening to Orchestrator server clients...");
                        logger.info("");
                    }
                }
            }.start();
        } catch (TTransportException e) {
            setStatus(IServer.ServerStatus.FAILED);
            throw new Exception("Error while starting the Orchestrator service", e);
        }
    }

    public String getName() {
        return SERVER_NAME;
    }

    public String getVersion() {
        return SERVER_VERSION;
    }

    public IServer.ServerStatus getStatus() throws Exception {
        return status;
    }

    private void setStatus(IServer.ServerStatus stat) {
        status = stat;
        status.updateTime();
    }
}
