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
        try {
            Neo4JJavaDbOperation neo4JJavaDbOperation = new Neo4JJavaDbOperation();
            SchedulingRequest schedulingRequest = null;

            String experimentType = getRandomExperimentType();
            String results = neo4JJavaDbOperation.getDag(experimentType);
            String expId = UUID.randomUUID().toString();

            // get scheduiling request
            System.out.println("Submitting Orchestrator Request for ExperimentType: " + experimentType + ", experimentId: " + expId);
            schedulingRequest = DummySchedulingRequest.getSchedulingRequest(Constants.fromString(results), expId);

            State state = new State();
            state.setID(expId);
            state.setState(results);
            state.setExpType(experimentType);

            // submit orchestrator request
            orchestratorMessagePublisher.publishSchedulingRequest(state, schedulingRequest);
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
