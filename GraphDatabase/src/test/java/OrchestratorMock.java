import org.apache.airavata.sga.commons.model.SchedulingRequest;
import org.apache.airavata.sga.graphdb.entity.State;
import org.apache.airavata.sga.graphdb.impl.Neo4JJavaDbOperation;
import org.apache.airavata.sga.graphdb.messaging.OrchestratorMessagePublisher;
import org.apache.airavata.sga.graphdb.utils.Constants;
import org.apache.airavata.sga.graphdb.utils.DummySchedulingRequest;
import org.apache.airavata.sga.graphdb.utils.ExpTypes;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.*;

/**
 * Created by goshenoy on 4/14/17.
 */
public class OrchestratorMock {
    private static final Logger logger = LogManager.getLogger(OrchestratorMock.class);
    private static OrchestratorMessagePublisher orchestratorMessagePublisher = new OrchestratorMessagePublisher();

    public static void main(String[] args) {

        // increase count here to control number of JOB-SUBMISSIONS
        for (int i=0; i<1; i++) {
            new Thread() {
                @Override
                public void run() {
                    System.out.println("Thread: " + Thread.currentThread().getId() + " | Running Now...");
                    submitJob(UUID.randomUUID().toString(), getRandomExperimentType());
                    stop();
                }

                @Override
                protected void finalize() throws Throwable {
                    super.finalize();
                    System.out.println("[" + Thread.currentThread().getId() + "] Terminating...");
                }
            }.start();
        }
    }

    private static void submitJob(String experimentId, String experimentType) {
        try {
            Neo4JJavaDbOperation neo4JJavaDbOperation = new Neo4JJavaDbOperation();
            SchedulingRequest schedulingRequest = null;

            // get scheduling request
            System.out.println("[" + Thread.currentThread().getId() + "] Getting DAG for ExperimentType: " + experimentType);
            String results = neo4JJavaDbOperation.getDag(experimentType);
            System.out.println("[" + Thread.currentThread().getId() + "] Submitting Orchestrator Request for ExperimentType: " + experimentType + ", experimentId: " + experimentId);
            schedulingRequest = DummySchedulingRequest.getSchedulingRequest(Constants.fromString(results), experimentId);

            // save the state in db
            State state = new State();
            state.setID(experimentId);
            state.setState(results);
            state.setExpType(experimentType);

            // submit orchestrator request
            orchestratorMessagePublisher.publishSchedulingRequest(state, schedulingRequest);
            System.exit(0);
        } catch (Exception ex) {
            logger.error("Error running OrchestratorMock, reason: " + ex, ex);
        }
    }

    private static String getRandomExperimentType() {
        List<ExpTypes> expTypesList = new ArrayList<ExpTypes>(Arrays.asList(ExpTypes.values()));
        return expTypesList.get(
                new Random().nextInt(expTypesList.size())
        ).toString();
    }
}
