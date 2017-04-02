package org.apache.airavata.sga.graphdb.utils;

import org.neo4j.graphdb.RelationshipType;
public enum ExpTypes implements RelationshipType{
	PHYSICS("PHYSICS"), CHEMISTRY("CHEMISTRY"), MATHS("MATHS"), BIOLOGY("BIOLOGY");
	private String name;

	ExpTypes(String name){
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
}