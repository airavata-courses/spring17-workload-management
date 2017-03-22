package org.apache.airavata.sga.graphdb.impl;

import org.neo4j.graphdb.RelationshipType;
public enum TaskRelationships implements RelationshipType{
	PHYSICS, CHEMISTRY, MATHS, BIOLOGY;
}