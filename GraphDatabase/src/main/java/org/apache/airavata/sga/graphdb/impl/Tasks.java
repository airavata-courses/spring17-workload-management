package org.apache.airavata.sga.graphdb.impl;
import org.neo4j.graphdb.Label;
public enum Tasks implements Label {
	ENV_SETUP,DATA_STAGING,JOB_SUBMISSION,MONITORING;
}