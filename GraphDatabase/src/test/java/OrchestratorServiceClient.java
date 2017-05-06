import org.apache.airavata.sga.graphdb.cpi.OrchestratorService;
import org.apache.airavata.sga.graphdb.utils.Constants;
import org.apache.airavata.sga.graphdb.utils.ExpTypes;
import org.apache.airavata.sga.graphdb.utils.OrchestratorServerFactory;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by Ajinkya on 4/27/17.
 */
public class OrchestratorServiceClient {

    public void test() throws TException {
        String serverHost = Constants.ORCHESTRATOR_SERVER_HOST;
        int serverPort = Integer.parseInt(Constants.ORCHESTRATOR_SERVER_PORT);
        OrchestratorService.Client orchestratorClient = OrchestratorServerFactory.createOrchestratorClient(serverHost, serverPort);

        String expId = orchestratorClient.submitJob(ExpTypes.BIOLOGY.toString());

        System.out.println("Experiment Id : " + expId);

        System.out.println("Get experiment" + orchestratorClient.getExperiment(expId));

        System.out.println("Task list" + orchestratorClient.getTasksForExperiment(expId));

        System.out.println("Experiment list" + orchestratorClient.getExperimentList());;

    }

    public static void main(String ...args){
        OrchestratorServiceClient orchestratorServiceClient = new OrchestratorServiceClient();
        try {
            orchestratorServiceClient.test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
