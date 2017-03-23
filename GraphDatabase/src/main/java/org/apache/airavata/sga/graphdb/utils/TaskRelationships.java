package org.apache.airavata.sga.graphdb.utils;

import org.neo4j.graphdb.RelationshipType;
public enum TaskRelationships implements RelationshipType{
	PHYSICS("PHYSICS"), CHEMISTRY("CHEMISTRY"), MATHS("MATHS"), BIOLOGY("BIOLOGY");
	private String name;

	TaskRelationships(String name){
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
}