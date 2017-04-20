package org.apache.airavata.sga.graphdb.utils;

import static java.lang.Math.max;
import static java.lang.System.currentTimeMillis;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.airavata.sga.commons.model.*;
import org.apache.airavata.sga.graphdb.impl.Neo4JJavaDbOperation;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

public class DagCreation {


	private static Connection conn = null;
	private static final Random RANDOM = new Random();
	public static String EXP_ID;
	private static DummySchedulingRequest dummy = new DummySchedulingRequest();

	private static byte[] randomBigByteArray() {
		byte[] array = new byte[max(248, RANDOM.nextInt(248 * 1024))];
		for (int i = 0; i < array.length; i++)
			array[i] = (byte) (currentTimeMillis() % 255);
		return array;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File(Constants.GRAPH_DB_LOCATION);
		GraphDatabaseFactory dbFactory = new GraphDatabaseFactory();
		GraphDatabaseService db = dbFactory.newEmbeddedDatabase(f);
		Neo4JJavaDbOperation neo4JJavaDbOperation = new Neo4JJavaDbOperation();

		try (Transaction tx = db.beginTx()) {

			db.execute("MATCH (n) OPTIONAL MATCH (n)-[r]-() DELETE n,r");

			Node ENV_SETUP = db.createNode(States.ENV_SETUP);
			Node INPUT_DATA_STAGING = db.createNode(States.INPUT_DATA_STAGING);
			Node JOB_SUBMISSION = db.createNode(States.JOB_SUBMISSION);
			Node MONITORING = db.createNode(States.MONITORING);
			Node OUTPUT_DATA_STAGING = db.createNode(States.OUTPUT_DATA_STAGING);

			ENV_SETUP.createRelationshipTo(INPUT_DATA_STAGING, ExpTypes.BIOLOGY);
			INPUT_DATA_STAGING.createRelationshipTo(JOB_SUBMISSION, ExpTypes.BIOLOGY);
			JOB_SUBMISSION.createRelationshipTo(MONITORING, ExpTypes.BIOLOGY);
			MONITORING.createRelationshipTo(OUTPUT_DATA_STAGING, ExpTypes.BIOLOGY);

			ENV_SETUP.createRelationshipTo(INPUT_DATA_STAGING, ExpTypes.CHEMISTRY);
			INPUT_DATA_STAGING.createRelationshipTo(JOB_SUBMISSION, ExpTypes.CHEMISTRY);
			JOB_SUBMISSION.createRelationshipTo(MONITORING, ExpTypes.CHEMISTRY);
			MONITORING.createRelationshipTo(OUTPUT_DATA_STAGING, ExpTypes.CHEMISTRY);

			ENV_SETUP.createRelationshipTo(INPUT_DATA_STAGING, ExpTypes.MATHS);
			INPUT_DATA_STAGING.createRelationshipTo(JOB_SUBMISSION, ExpTypes.MATHS);
			JOB_SUBMISSION.createRelationshipTo(MONITORING, ExpTypes.MATHS);
			MONITORING.createRelationshipTo(OUTPUT_DATA_STAGING, ExpTypes.MATHS);


			ENV_SETUP.createRelationshipTo(INPUT_DATA_STAGING, ExpTypes.PHYSICS);
			INPUT_DATA_STAGING.createRelationshipTo(JOB_SUBMISSION, ExpTypes.PHYSICS);
			JOB_SUBMISSION.createRelationshipTo(MONITORING, ExpTypes.PHYSICS);
			MONITORING.createRelationshipTo(OUTPUT_DATA_STAGING, ExpTypes.PHYSICS);

//			Result execResult = db.execute("MATCH path= (a)-[:BIOLOGY*]-(b) RETURN collect(distinct labels(b))");
//			Result exec = db.execute("MATCH path= (a:DATA_STAGING)-[:BIOLOGY*]->(b) RETURN collect(distinct labels(b))");
//			db.execute("MATCH path= (a:ENV_SETUP)-[:BIOLOGY*1]-(b) RETURN collect(distinct labels(b))");
//
//
//			Map<String, Object> results = ((ExecutionResult) execResult).next();
//			String dag = null;
//
//			for (Entry<String, Object> string : results.entrySet()) {
//				dag = string.getValue().toString();
//			}
//			List<String> nodes = Arrays.asList(dag.substring(1, dag.length()-1).split(", "));
//			for (String string : nodes) {
//				System.out.println(string);
//			}


			/*
			 * TODO:
			 * Crate scheduler message context based on task and publish it to queue
			 * Identify what data a node can accommodate
			 * How orchestrator gets the data
			 */
			tx.success();
		}

		System.out.println("Done successfully");

	}


}
