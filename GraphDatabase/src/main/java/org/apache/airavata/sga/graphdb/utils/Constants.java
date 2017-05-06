package org.apache.airavata.sga.graphdb.utils;

import java.io.IOException;
import java.util.Properties;

import org.apache.airavata.sga.commons.model.DataStagingDirection;
import org.apache.airavata.sga.commons.scheduler.RabbitMQConstants;
import org.apache.airavata.sga.messaging.service.util.RabbitMQProperties;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Constants {
	private static final Logger logger = LogManager.getLogger(Constants.class);
	
	public static final String ORCHESTRATOR_PROP_FILE = "orchestrator.properties";
    public static final String SCHEDULER_MESSAGE_EXCHANGE_NAME = "scheduler.message.exchange.name";
    public static final String SCHEDULER_MESSAGE_QUEUE = "scheduler.message.queue";
    public static final String SCHEDULER_MESSAGE_ROUTING_KEY = "scheduler.message.routing.key";

    public static final String ORCHESTRATOR_RESPONSE_EXCHANGE_NAME = "orchestrator.response.exchange.name";
    public static final String ORCHESTRATOR_RESPONSE_QUEUE = "orchestrator.response.queue";
    public static final String ORCHESTRATOR_RESPONSE_ROUTING_KEY = "orchestrator.response.routing.key";

    public static final RabbitMQProperties SCHEDULER_MESSAGE_RABBITMQ_PROPERTIES;
    public static final RabbitMQProperties ORCHESTRATOR_RESPONSE_RABBITMQ_PROPERTIES;
    public static final String GRAPH_DB_LOCATION_KEY = "graphdb.location";
    public static final String GRAPH_DB_LOCATION;

    public static final String ZOOKEEPER_SERVER_CONNECTION = "zookeeper.server.connection";
    public static final String ZOOKEEPER_SERVER;

    public static final String RUNNING_EXP_DIR = "running-exp-dir";

    public static final String MYSQL_JDBC_DB = "mysql.jdbc.db";
    public static final String MYSQL_JDBC_CONNECTION = "mysql.jdbc.connection";
    public static final String MYSQL_JDBC_USER = "mysql.jdbc.user";
    public static final String MYSQL_JDBC_PASSWORD = "mysql.jdbc.password";

    public static final String ORCHESTRATOR_SERVER_HOST;
    public static final String ORCHESTRATOR_SERVER_PORT;

    public static final Properties properties;

    public enum ExperimentStatus {
        RUNNING,
        COMPLETE,
        FAILED;

        @Override
        public String toString() {
            return name();
        }
    }

    static{
        properties = new Properties();
        try {
            properties.load(Constants.class.getClassLoader().getResourceAsStream(ORCHESTRATOR_PROP_FILE));
        } catch (IOException ex) {
            logger.error("Error loading properties: " + ex.getMessage(), ex);
        }
        ORCHESTRATOR_SERVER_HOST = properties.getProperty("orchestrator.server.host");
        ORCHESTRATOR_SERVER_PORT = properties.getProperty("orchestrator.server.port");

        ZOOKEEPER_SERVER = properties.getProperty(ZOOKEEPER_SERVER_CONNECTION);
        GRAPH_DB_LOCATION = properties.getProperty(GRAPH_DB_LOCATION_KEY);
        SCHEDULER_MESSAGE_RABBITMQ_PROPERTIES = getSchedulerMessageRabbitMQProperties();
        ORCHESTRATOR_RESPONSE_RABBITMQ_PROPERTIES = getOrchestratorResponseRabbitMQProperties();
    }

    public static String getMysqlJdbcConnection() {
        return properties.getProperty(MYSQL_JDBC_CONNECTION);
    }

    public static String getMysqlJdbcUser() {
        return properties.getProperty(MYSQL_JDBC_USER);
    }

    public static String getMysqlJdbcPassword() {
        return properties.getProperty(MYSQL_JDBC_PASSWORD);
    }

    public static String getMysqlJdbcDb() {
        return properties.getProperty(MYSQL_JDBC_DB);
    }
    
    private static RabbitMQProperties getSchedulerMessageRabbitMQProperties() {
        RabbitMQProperties rabbitMQProperties = getProperties();
        rabbitMQProperties.setRoutingKey(properties.getProperty(SCHEDULER_MESSAGE_ROUTING_KEY));
        rabbitMQProperties.setExchangeName(properties.getProperty(SCHEDULER_MESSAGE_EXCHANGE_NAME));
        rabbitMQProperties.setQueueName(properties.getProperty(SCHEDULER_MESSAGE_QUEUE));
        return rabbitMQProperties;
    }
    
    private static RabbitMQProperties getOrchestratorResponseRabbitMQProperties() {
        RabbitMQProperties rabbitMQProperties = getProperties();
        rabbitMQProperties.setRoutingKey(properties.getProperty(ORCHESTRATOR_RESPONSE_ROUTING_KEY));
        rabbitMQProperties.setExchangeName(properties.getProperty(ORCHESTRATOR_RESPONSE_EXCHANGE_NAME));
        rabbitMQProperties.setQueueName(properties.getProperty(ORCHESTRATOR_RESPONSE_QUEUE));
        return rabbitMQProperties;
    }
    
    public static RabbitMQProperties getProperties() {
        return new RabbitMQProperties().setBrokerUrl(RabbitMQConstants.AMQP_URI)
                .setDurable(Boolean.parseBoolean(RabbitMQConstants.IS_DURABLE_QUEUE))
                .setPrefetchCount(Integer.parseInt(RabbitMQConstants.PREFETCH_COUT)).setAutoRecoveryEnable(true)
                .setAutoAck(Boolean.parseBoolean(RabbitMQConstants.IS_AUTO_ACK))
                .setConsumerTag(RabbitMQConstants.CONSUMER_TAG)
                .setExchangeType(RabbitMQProperties.EXCHANGE_TYPE.TOPIC);
    }

    public static States fromString(String text) {
        for (States b : States.values()) {
            if (b.name().equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }

    public static States getTaskFromQueueName(String queueName, DataStagingDirection dataStagingDirection) {
        for (States b : States.values()) {
            if (b.getQueueName().equalsIgnoreCase(queueName)) {
                if (b.getDataStagingDirection() == null) {
                    return b;
                } else if (b.getDataStagingDirection().equals(dataStagingDirection)){
                    return b;
                }
            }
        }
        return null;
    }

}
