package org.apache.airavata.sga.graphdb.utils;

import org.neo4j.graphdb.Label;

public enum States implements Label {

	ENV_SETUP("ENV_SETUP"),
	INPUT_DATA_STAGING("INPUT_DATA_STAGING"),
	JOB_SUBMISSION("JOB_SUBMISSION"),
	MONITORING("MONITORING"),
	OUTPUT_DATA_STAGING("OUTPUT_DATA_STAGING"),
	COMPLETED("COMPLETED"),
	FAILED("FAILED");

	private String name;

	States(String name){
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
}