package org.apache.airavata.sga.graphdb.messaging;

import org.apache.airavata.sga.graphdb.utils.Constants;
import org.apache.airavata.sga.messaging.service.core.MessagingFactory;
import org.apache.airavata.sga.messaging.service.core.Publisher;
import org.apache.airavata.sga.messaging.service.core.Subscriber;


public class OrchestratorMessagingFactory {

	public static Publisher getOrchestratorMessagePublisher(){
        return MessagingFactory.getPublisher(Constants.SCHEDULER_MESSAGE_RABBITMQ_PROPERTIES);
    }
	
	public static Subscriber getOrchestratorResponseSubscriber(){
        return MessagingFactory.getSubscriber(new OrchestratorResponseHandler(), Constants.ORCHESTRATOR_RESPONSE_RABBITMQ_PROPERTIES);
    }
}
