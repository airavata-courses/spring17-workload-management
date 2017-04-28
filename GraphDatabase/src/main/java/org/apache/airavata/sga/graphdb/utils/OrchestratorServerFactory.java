package org.apache.airavata.sga.graphdb.utils;

import org.apache.airavata.sga.graphdb.cpi.OrchestratorService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by Ajinkya on 4/27/17.
 */
public class OrchestratorServerFactory {
    public static OrchestratorService.Client createOrchestratorClient(String serverHost, int serverPort)  {
        try {
            TTransport transport = new TSocket(serverHost, serverPort);
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            return new OrchestratorService.Client(protocol);
        } catch (TTransportException e) {
            e.printStackTrace();
            return null;
        }
    }
}
