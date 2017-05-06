package org.apache.airavata.sga.graphdb.utils;

import org.apache.airavata.sga.commons.model.DataStagingDirection;
import org.neo4j.graphdb.Label;

public enum States implements Label {

	ENV_SETUP("ENV_SETUP", "queue.environmentsetup", null),
	INPUT_DATA_STAGING("INPUT_DATA_STAGING", "queue.datastaging", DataStagingDirection.INPUT),
	JOB_SUBMISSION("JOB_SUBMISSION", "queue.jobsubmission", null),
	MONITORING("MONITORING", "queue.monitoring", null),
	OUTPUT_DATA_STAGING("OUTPUT_DATA_STAGING", "queue.datastaging", DataStagingDirection.OUTPUT);

	private String name;
	private String queueName;
	private DataStagingDirection dataStagingDirection;

	States(String name, String queueName, DataStagingDirection dataStagingDirection){
		this.name = name;
		this.queueName = queueName;
		this.dataStagingDirection = dataStagingDirection;
	}

	public String getName() {
		return name;
	}

	public String getQueueName() {
		return queueName;
	}

	public DataStagingDirection getDataStagingDirection() {
		return dataStagingDirection;
	}

	@Override
	public String toString() {
		return name;
	}
}