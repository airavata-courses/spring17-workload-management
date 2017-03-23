package org.apache.airavata.sga.graphdb.utils;
import org.neo4j.graphdb.Label;
public enum Tasks implements Label {
	ENV_SETUP("ENV_SETUP"),DATA_STAGING("DATA_STAGING"),JOB_SUBMISSION("JOB_SUBMISSION"),MONITORING("MONITORING");
	private String name;

	Tasks(String name){
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
}