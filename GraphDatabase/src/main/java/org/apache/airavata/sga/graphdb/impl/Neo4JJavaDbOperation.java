package org.apache.airavata.sga.graphdb.impl;

import org.apache.airavata.sga.graphdb.dao.EntityDAO;
import org.apache.airavata.sga.graphdb.dao.impl.EntityDAOImpl;
import org.apache.airavata.sga.graphdb.messaging.OrchestratorMessagePublisher;
import org.apache.airavata.sga.graphdb.utils.Constants;
import org.neo4j.cypher.internal.javacompat.ExecutionResult;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import java.io.File;
import java.sql.Connection;
import java.util.Map;
import java.util.Random;

import static java.lang.Math.max;
import static java.lang.System.currentTimeMillis;

public class Neo4JJavaDbOperation {

	private static Connection conn = null;
	private static final Random RANDOM = new Random();
	private static final EntityDAO DAO = new EntityDAOImpl();
	private static OrchestratorMessagePublisher orchestratorMessagePublisher = new OrchestratorMessagePublisher();

	private static byte[] randomBigByteArray() {
		byte[] array = new byte[max(248, RANDOM.nextInt(248 * 1024))];
		for (int i = 0; i < array.length; i++)
			array[i] = (byte) (currentTimeMillis() % 255);
		return array;
	}

	public String getDag(String expType){
		// TODO Auto-generated method stub
		File f = new File(Constants.GRAPH_DB_LOCATION);
		GraphDatabaseFactory dbFactory = new GraphDatabaseFactory();
		GraphDatabaseService db = dbFactory.newEmbeddedDatabase(f);
		Map<String, Object> results = null;
		Map.Entry<String,Object> dag = null;

		try (Transaction tx = db.beginTx()) {

			Result execResult = db.execute("MATCH path= (a)-[:" + expType +"*]-(b) RETURN collect(distinct labels(b))[0]");
			//Result exec = db.execute("MATCH path= (a:DATA_STAGING)-[:BIOLOGY*]->(b) RETURN collect(distinct labels(b))");
			//db.execute("MATCH path= (a:ENV_SETUP)-[:BIOLOGY*1]-(b) RETURN collect(distinct labels(b))");
			results = ((ExecutionResult) execResult).next();
			dag=results.entrySet().iterator().next();

			/*
			 * TODO:
			 * Crate scheduler message context based on task and publish it to queue
			 * Identify what data a node can accommodate
			 * How orchestrator gets the data
			 */
			tx.success();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.shutdown();
		}
		return dag.getValue().toString().substring(1,dag.getValue().toString().length()-1);
	}

	public String getNextNode(String state, String expType){
		// TODO Auto-generated method stub
		File f = new File(Constants.GRAPH_DB_LOCATION);
		GraphDatabaseFactory dbFactory = new GraphDatabaseFactory();
		GraphDatabaseService db = dbFactory.newEmbeddedDatabase(f);
		Map<String, Object> results = null;
		Map.Entry<String,Object> dag = null;
		try (Transaction tx = db.beginTx()) {

			Result execResult = db.execute("MATCH path= (a:"+state+")-[:"+expType+"*1]->(b) RETURN collect(distinct labels(b))");
			//Result exec = db.execute("MATCH path= (a:DATA_STAGING)-[:BIOLOGY*]->(b) RETURN collect(distinct labels(b))");
			//db.execute("MATCH path= (a:ENV_SETUP)-[:BIOLOGY*1]-(b) RETURN collect(distinct labels(b))");


			results = ((ExecutionResult) execResult).next();
			dag=results.entrySet().iterator().next();

			/*
			 * TODO:
			 * Crate scheduler message context based on task and publish it to queue
			 * Identify what data a node can accommodate
			 * How orchestrator gets the data
			 */
			tx.success();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.shutdown();
		}
		if(dag.getValue().toString().equals("[]")){
			return null;
		}
		return dag.getValue().toString().substring(2,dag.getValue().toString().length()-2);
	}



}
