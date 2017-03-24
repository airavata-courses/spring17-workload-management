package org.apache.airavata.sga.graphdb.messaging;

import org.apache.airavata.sga.commons.model.SchedulingRequest;
import org.apache.airavata.sga.graphdb.dao.EntityDAO;
import org.apache.airavata.sga.graphdb.dao.impl.EntityDAOImpl;
import org.apache.airavata.sga.graphdb.entity.State;
import org.apache.airavata.sga.messaging.service.util.MessageContext;

/**
 * Created by Amruta on 3/23/2017.
 */
public class OrchestratorMessagePublisher {

    private static final EntityDAO DAO = new EntityDAOImpl();

    public void publishSchedulingRequest(State state, SchedulingRequest schedulingRequest){
        try{
            DAO.saveEntity(state);
            MessageContext messageContext = new MessageContext(schedulingRequest,
                    schedulingRequest.getTaskContext().getExperiment().getExperimentId());
            OrchestratorMessagingFactory.getOrchestratorMessagePublisher().publish(messageContext);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
