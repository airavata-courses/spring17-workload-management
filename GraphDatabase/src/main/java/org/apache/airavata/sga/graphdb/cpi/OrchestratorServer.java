package org.apache.airavata.sga.graphdb.cpi;

import org.apache.airavata.sga.graphdb.utils.Constants;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;

/**
 * Created by Ajinkya on 4/27/17.
 */
public class OrchestratorServer{

    private final static Logger logger = LoggerFactory.getLogger(OrchestratorServer.class);
    private TServer server;

    public void start() throws Exception {
        final int serverPort = Integer.parseInt(Constants.ORCHESTRATOR_SERVER_PORT);
        final String serverHost = Constants.ORCHESTRATOR_SERVER_HOST;
        OrchestratorService.Processor processor = new OrchestratorService.Processor(new OrchestratorServerHandler());

        TServerTransport serverTransport;
        InetSocketAddress inetSocketAddress = new InetSocketAddress(serverHost, serverPort);
        serverTransport = new TServerSocket(inetSocketAddress);

        TThreadPoolServer.Args options = new TThreadPoolServer.Args(serverTransport);
        options.minWorkerThreads = 30;
        server = new TThreadPoolServer(options.processor(processor));

        new Thread() {
            public void run() {
                server.serve();
                logger.info("Orchestrator Server Stopped.");
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
                    logger.info("Starting Orchestrator Server on Port " + serverPort);
                    logger.info("Listening to Orchestrator server clients ....");
                }
            }
        }.start();
    }

    public static void main(String ...args){
        OrchestratorServer orchestratorServer = new OrchestratorServer();
        try {
            orchestratorServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
