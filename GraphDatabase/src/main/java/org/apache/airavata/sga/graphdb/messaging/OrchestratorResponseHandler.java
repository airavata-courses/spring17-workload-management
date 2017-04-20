package org.apache.airavata.sga.graphdb.messaging;

import org.apache.airavata.sga.commons.model.Response;
import org.apache.airavata.sga.commons.model.SchedulingRequest;
import org.apache.airavata.sga.commons.model.Status;
import org.apache.airavata.sga.graphdb.dao.EntityDAO;
import org.apache.airavata.sga.graphdb.dao.impl.EntityDAOImpl;
import org.apache.airavata.sga.graphdb.entity.State;
import org.apache.airavata.sga.graphdb.impl.Neo4JJavaDbOperation;
import org.apache.airavata.sga.graphdb.utils.Constants;
import org.apache.airavata.sga.graphdb.utils.DummySchedulingRequest;
import org.apache.airavata.sga.graphdb.utils.States;
import org.apache.airavata.sga.graphdb.utils.ZKUtils;
import org.apache.airavata.sga.messaging.service.core.MessageHandler;
import org.apache.airavata.sga.messaging.service.model.Message;
import org.apache.airavata.sga.messaging.service.util.MessageContext;
import org.apache.airavata.sga.messaging.service.util.ThriftUtils;
import org.apache.thrift.TBase;
import org.neo4j.graphdb.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrchestratorResponseHandler implements MessageHandler{
	 /** The Constant logger. */
    private static final Logger logger = LoggerFactory.getLogger(OrchestratorResponseHandler.class);
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
            logger.info("onMessage() -> Received response from scheduler: " + response);

            //State currentState = DAO.getState(response.getExperimentId());
            if (response.getStatus().equals(Status.FAILED)) {
                logger.error("onMessage() -> ExperimentEntity: {} has failed!");
                //FIXME: handle FAILED status gracefully
            }
            else if (response.getStatus().equals(Status.ACCEPTED)) {
                // task is still executing, just log and continue
                logger.info("onMessage() -> ExperimentEntity: {} is currently performing task: {}. Waiting for this task to complete!",
                        response.getExperimentId(), "MONITORING");
                // FIXME: currently only monitoring sends ACCEPTED
            }
            else {
                SchedulingRequest schedulingRequest = neo4JJavaDbOperation.setExecutedAndGetNextNode(response.getExperimentId());
                if (null != schedulingRequest) {
                    orchestratorMessagePublisher.publishSchedulingRequest(schedulingRequest);
                } else {
                    logger.info("deleting zookeeper node for exp : " + response.getExperimentId());
                    ZKUtils.deleteZKNode(ZKUtils.getCuratorClient(), response.getExperimentId());
                }
            }
        } catch (Exception ex) {
            logger.error("Error receiving response from task, ex: " + ex, ex);
        }
    }
}
