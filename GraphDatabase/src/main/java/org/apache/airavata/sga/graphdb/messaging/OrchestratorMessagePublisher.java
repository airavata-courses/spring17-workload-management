package org.apache.airavata.sga.graphdb.messaging;

import org.apache.airavata.sga.commons.model.Response;
import org.apache.airavata.sga.commons.model.SchedulingRequest;
import org.apache.airavata.sga.commons.model.Status;
import org.apache.airavata.sga.graphdb.dao.EntityDAO;
import org.apache.airavata.sga.graphdb.dao.impl.EntityDAOImpl;
import org.apache.airavata.sga.graphdb.entity.State;
import org.apache.airavata.sga.graphdb.utils.Constants;
import org.apache.airavata.sga.messaging.service.core.MessagingFactory;
import org.apache.airavata.sga.messaging.service.core.Publisher;
import org.apache.airavata.sga.messaging.service.util.MessageContext;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import static org.apache.airavata.sga.commons.scheduler.RabbitMQConstants.logger;

/**
 * Created by Amruta on 3/23/2017.
 */
public class OrchestratorMessagePublisher {

    private static final Logger logger = LogManager.getLogger(OrchestratorMessagePublisher.class);

    private static final EntityDAO DAO = new EntityDAOImpl();
    private static Publisher orchestratorResponsePublisher;

    public static Publisher getOrchestratorResponsePublisher(){

        if (orchestratorResponsePublisher == null) {
            logger.info("Initializing Environment Setup subscriber");
            orchestratorResponsePublisher = MessagingFactory.getPublisher(Constants.ORCHESTRATOR_RESPONSE_RABBITMQ_PROPERTIES);
        }
        return orchestratorResponsePublisher;
    }

    public void publishSchedulingRequest(State state, SchedulingRequest schedulingRequest){
        try{
            DAO.saveEntity(state);
            MessageContext messageContext = new MessageContext(schedulingRequest,
                    schedulingRequest.getTaskContext().getExperiment().getExperimentId());
            OrchestratorMessagingFactory.getOrchestratorMessagePublisher().publish(messageContext);

            Response response = new Response();
            response.setExperimentId("1");

            response.setStatus(Status.OK);
            response.setMessage("File staged successfully.");
            logger.info("publishSchedulingRequest() -> Sending response back to orchestrator. Response : " + response.toString()+ ", Experiment Id : " +  response.getExperimentId());

            MessageContext responseMsg = new MessageContext(response, response.getExperimentId());
            OrchestratorMessagePublisher.getOrchestratorResponsePublisher().publish(responseMsg);

            logger.info("publishSchedulingRequest() -> Response sent. Response : " + response.toString());

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
