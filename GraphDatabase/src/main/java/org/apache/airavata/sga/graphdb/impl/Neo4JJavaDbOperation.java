package org.apache.airavata.sga.graphdb.impl;

import org.apache.airavata.sga.commons.model.SchedulingRequest;
import org.apache.airavata.sga.graphdb.dao.EntityDAO;
import org.apache.airavata.sga.graphdb.dao.impl.EntityDAOImpl;
import org.apache.airavata.sga.graphdb.messaging.OrchestratorMessagePublisher;
import org.apache.airavata.sga.graphdb.utils.Constants;
import org.apache.airavata.sga.graphdb.utils.SerializationUtils;
import org.neo4j.cypher.internal.ExecutionEngine;
import org.neo4j.cypher.internal.javacompat.ExecutionResult;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static java.lang.Math.max;
import static java.lang.System.currentTimeMillis;

public class Neo4JJavaDbOperation {

	private static Connection conn = null;
	private static final Random RANDOM = new Random();
	private static final EntityDAO DAO = new EntityDAOImpl();
	private static OrchestratorMessagePublisher orchestratorMessagePublisher = new OrchestratorMessagePublisher();

	public String getIncompleteNode(){

		File f = new File(Constants.GRAPH_DB_LOCATION);
		GraphDatabaseFactory dbFactory = new GraphDatabaseFactory();
		GraphDatabaseService db = dbFactory.newEmbeddedDatabase(f);
		Map<String, Object> results = null;
		Map.Entry<String,Object> dag = null;

		try (Transaction tx = db.beginTx()) {

			Result execResult = db.execute("MATCH (n{flag:\"false\"}) \n" +
					"return labels(n) LIMIT 1");
			results = ((ExecutionResult) execResult).next();
			dag=results.entrySet().iterator().next();

			tx.success();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.shutdown();
		}
		return dag.getValue().toString().substring(1,dag.getValue().toString().length()-1);
	}

	public SchedulingRequest getSchedulingRequestFromNode(String expType){
		// TODO Auto-generated method stub
		File f = new File(Constants.GRAPH_DB_LOCATION);
		GraphDatabaseFactory dbFactory = new GraphDatabaseFactory();
		GraphDatabaseService db = dbFactory.newEmbeddedDatabase(f);
		//ExecutionEngine execEngine = new ExecutionEngine(db);
		Map<String, Object> results = null;
		Map.Entry<String,Object> dag = null;
		Node resultNode = null;
		SchedulingRequest schedulingRequest = null;
		try (Transaction tx = db.beginTx()) {

			Result execResult = db.execute("MATCH path= (a)-[:" + expType +"*]-(b) RETURN collect(distinct (b))[0] AS n");
			ResourceIterator<Node> resultIterator=execResult.columnAs("n");
			if(resultIterator.hasNext()){
				resultNode = resultIterator.next();
			}
			for (String key : resultNode.getPropertyKeys()) {
				System.out.println("Key: " + key + ", Value: " +  resultNode.getProperty(key));
				if(key.equals("schedulingRequest"))
				schedulingRequest = (SchedulingRequest) SerializationUtils.convertFromBytes((byte[]) resultNode.getProperty(key));
			}
			tx.success();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.shutdown();
		}

		return schedulingRequest;
	}

	public Node getDagNode(String state, String expType){
		// TODO Auto-generated method stub
		File f = new File(Constants.GRAPH_DB_LOCATION);
		GraphDatabaseFactory dbFactory = new GraphDatabaseFactory();
		GraphDatabaseService db = dbFactory.newEmbeddedDatabase(f);
		//ExecutionEngine execEngine = new ExecutionEngine(db);
		Map<String, Object> results = null;
		Map.Entry<String,Object> dag = null;
		Node resultNode = null;
		SchedulingRequest schedulingRequest = null;
		try (Transaction tx = db.beginTx()) {

			Result execResult = db.execute("MATCH path= (a:"+state+")-[:"+expType+"*1]->(b) RETURN collect(distinct (b)) AS n");
			ResourceIterator<Node> resultIterator=execResult.columnAs("n");
			if(resultIterator.hasNext()){
				resultNode = resultIterator.next();
			}
			tx.success();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.shutdown();
		}

		return resultNode;
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
			results = ((ExecutionResult) execResult).next();
			dag=results.entrySet().iterator().next();
			tx.success();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.shutdown();
		}
		return dag.getValue().toString().substring(1,dag.getValue().toString().length()-1);
	}

	public List<String> getCompleteDag(String expType){
		// TODO Auto-generated method stub
		File f = new File(Constants.GRAPH_DB_LOCATION);
		GraphDatabaseFactory dbFactory = new GraphDatabaseFactory();
		GraphDatabaseService db = dbFactory.newEmbeddedDatabase(f);
		Map<String, Object> results = null;
		Map.Entry<String,Object> dag = null;
		List<String> nodesList = new ArrayList<>();
		try (Transaction tx = db.beginTx()) {

			Result execResult = db.execute("MATCH path= (a)-[:" + expType +"*]-(b) RETURN collect(distinct labels(b))");
			results = ((ExecutionResult) execResult).next();
			dag=results.entrySet().iterator().next();
			String[] nodes = dag.getValue().toString().split(", ");
			nodesList.add(nodes[0].substring(2,nodes[0].length()-1));
			for(int i = 1; i < nodes.length-1; i++){
				nodesList.add(nodes[i].substring(1,nodes[i].length()-1));
			}
			nodesList.add(nodes[nodes.length-1].substring(1,nodes[nodes.length-1].length()-2));

			tx.success();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.shutdown();
		}
		return nodesList;
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
			results = ((ExecutionResult) execResult).next();
			dag=results.entrySet().iterator().next();

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
