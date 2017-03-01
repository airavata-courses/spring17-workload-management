package org.apache.airavata.sga.graphdb.impl;
import static java.lang.Math.max;
import static java.lang.System.currentTimeMillis;

import java.io.File;
import java.sql.Connection;
import java.util.Random;

import org.neo4j.cypher.internal.javacompat.ExecutionResult;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

public class Neo4JJavaDbOperation {

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
		File f = new File("C:\\TPNeo4jDBTest");
		GraphDatabaseFactory dbFactory = new GraphDatabaseFactory();
		GraphDatabaseService db = dbFactory.newEmbeddedDatabase(f);

		try (Transaction tx = db.beginTx()) {

			db.execute("MATCH (n) DETACH DELETE n");

			Node taskA = db.createNode(Tasks.TASKA);
			Node taskB = db.createNode(Tasks.TASKB);
			Node taskC = db.createNode(Tasks.TASKC);
			Node taskD = db.createNode(Tasks.TASKD);

			taskB.setProperty("prop", "aaa");
			taskA.setProperty("test","test");
		

			taskA.createRelationshipTo(taskB, TaskRelationships.SENDS_DATA);
			taskB.createRelationshipTo(taskC, TaskRelationships.SENDS_DATA);
			Result execResult = db.execute("MATCH path= (a:TASKA)-[:SENDS_DATA*]-(root:TASKC) RETURN path");
			String results = ((ExecutionResult) execResult).dumpToString();
			System.out.println(results);
			tx.success();
		}

		System.out.println("Done successfully");

	}

}
