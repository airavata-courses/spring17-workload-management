package org.apache.airavata.sga.graphdb.utils;

import static java.lang.Math.max;
import static java.lang.System.currentTimeMillis;

import java.io.File;
import java.sql.Connection;
import java.util.Random;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

public class DagCreation {


	private static Connection conn = null;
	private static final Random RANDOM = new Random();

	private static byte[] randomBigByteArray() {
		byte[] array = new byte[max(248, RANDOM.nextInt(248 * 1024))];
		for (int i = 0; i < array.length; i++)
			array[i] = (byte) (currentTimeMillis() % 255);
		return array;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("C:\\Neo4j");
		GraphDatabaseFactory dbFactory = new GraphDatabaseFactory();
		GraphDatabaseService db = dbFactory.newEmbeddedDatabase(f);

		try (Transaction tx = db.beginTx()) {

			db.execute("MATCH (n) OPTIONAL MATCH (n)-[r]-() DELETE n,r");

			Node taskA = db.createNode(States.ENV_SETUP);
			Node taskB = db.createNode(States.DATA_STAGING);
			Node taskC = db.createNode(States.JOB_SUBMISSION);
			Node taskD = db.createNode(States.MONITORING);

			taskA.setProperty("name","taskA");
			taskB.setProperty("name", "taskB");
			taskC.setProperty("name", "taskC");
			taskD.setProperty("name","taskD");
		

			taskA.createRelationshipTo(taskB, ExpTypes.BIOLOGY);
			taskB.createRelationshipTo(taskC, ExpTypes.BIOLOGY);
			
			taskA.createRelationshipTo(taskB, ExpTypes.CHEMISTRY);
			taskB.createRelationshipTo(taskD, ExpTypes.CHEMISTRY);
			
			taskB.createRelationshipTo(taskC, ExpTypes.PHYSICS);
			taskC.createRelationshipTo(taskD, ExpTypes.PHYSICS);
			
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
