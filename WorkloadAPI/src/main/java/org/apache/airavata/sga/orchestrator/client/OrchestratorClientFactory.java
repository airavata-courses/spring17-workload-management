package org.apache.airavata.sga.orchestrator.client;

import org.apache.airavata.sga.orchestrator.sdk.OrchestratorService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrchestratorClientFactory {

	private static final Logger logger = LoggerFactory.getLogger(OrchestratorClientFactory.class);
	
	public static OrchestratorService.Client getOrchestratorClient() throws Exception {
		TTransport transport = new TSocket("workloadorchestrator.marathon.l4lb.thisdcos.directory", 9090);
		transport.open();
		TProtocol protocol = new TBinaryProtocol(transport);
		return new OrchestratorService.Client(protocol);
	}
}
