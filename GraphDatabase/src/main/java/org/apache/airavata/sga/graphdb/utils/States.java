package org.apache.airavata.sga.graphdb.utils;

import org.neo4j.graphdb.Label;

public enum States implements Label {

	ENV_SETUP("ENV_SETUP", "queue.environmentsetup"),
	INPUT_DATA_STAGING("INPUT_DATA_STAGING", "queue.datastaging"),
	JOB_SUBMISSION("JOB_SUBMISSION", "queue.jobsubmission"),
	MONITORING("MONITORING", "monitoring"),
	OUTPUT_DATA_STAGING("OUTPUT_DATA_STAGING", "queue.datastaging");

	private String name;
	private String queueName;

	States(String name, String queueName){
		this.name = name;
		this.queueName = queueName;
	}

	public String getName() {
		return name;
	}

	public String getQueueName() {
		return queueName;
	}

	@Override
	public String toString() {
		return name;
	}
}