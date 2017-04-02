package org.apache.airavata.sga.graphdb.messaging;

import org.apache.airavata.sga.commons.model.Response;
import org.apache.airavata.sga.graphdb.dao.EntityDAO;
import org.apache.airavata.sga.graphdb.dao.impl.EntityDAOImpl;
import org.apache.airavata.sga.graphdb.entity.State;
import org.apache.airavata.sga.graphdb.impl.Neo4JJavaDbOperation;
import org.apache.airavata.sga.graphdb.utils.Constants;
import org.apache.airavata.sga.graphdb.utils.DummySchedulingRequest;
import org.apache.airavata.sga.messaging.service.core.MessageHandler;
import org.apache.airavata.sga.messaging.service.model.Message;
import org.apache.airavata.sga.messaging.service.util.MessageContext;
import org.apache.airavata.sga.messaging.service.util.ThriftUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.thrift.TBase;

public class OrchestratorResponseHandler implements MessageHandler{
	 /** The Constant logger. */
    private static final Logger logger = LogManager.getLogger(OrchestratorResponseHandler.class);
    private static final EntityDAO DAO = new EntityDAOImpl();
    private Neo4JJavaDbOperation neo4JJavaDbOperation = new Neo4JJavaDbOperation();
    private OrchestratorMessagePublisher orchestratorMessagePublisher = new OrchestratorMessagePublisher();

    @Override
    public void onMessage(MessageContext messageContext) {
        try {
            // get the message
            logger.info("onMessage() -> New message received. Message Id : " + messageContext.getMessageId());
            TBase<?, ?> event = messageContext.getEvent();
            byte[] bytes = ThriftUtils.serializeThriftObject(event);

            Message message = new Message();
            ThriftUtils.createThriftFromBytes(bytes, message);

            // get response from message
            Response response = new Response();
            ThriftUtils.createThriftFromBytes(message.getEvent(), response);
            State currentState = DAO.getState(Integer.parseInt(response.getExperimentId()));
            String nextNode = neo4JJavaDbOperation.getNextNode(currentState.getState(),currentState.getExpType());

            if(nextNode == null){
                return;
            }
            State state = new State();
            state.setID(currentState.getID());
            state.setState(nextNode);
            state.setExpType(currentState.getExpType());
            orchestratorMessagePublisher.publishSchedulingRequest(state,DummySchedulingRequest.getSchedulingRequest(Constants.fromString(nextNode)));
            logger.info("onMessage() -> Received response from scheduler: " + response);
        } catch (Exception ex) {
            logger.error("Error receiving response from task, ex: " + ex, ex);
        }
    }
}
