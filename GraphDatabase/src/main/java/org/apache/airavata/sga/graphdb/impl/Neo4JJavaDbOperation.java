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

	private static final Random RANDOM = new Random();
	public static GraphDatabaseService GRAPH_DB = null;
	static {getGraphDatabaseService();}
	public static GraphDatabaseService getGraphDatabaseService(){
		if(null == GRAPH_DB){
			synchronized (Neo4JJavaDbOperation.class){
				if(null == GRAPH_DB){
					File f = new File(Constants.GRAPH_DB_LOCATION);
					GraphDatabaseFactory dbFactory = new GraphDatabaseFactory();
					GRAPH_DB = dbFactory.newEmbeddedDatabase(f);
				}
			}
		}
		return GRAPH_DB;
	}

	private static byte[] randomBigByteArray() {
		byte[] array = new byte[max(248, RANDOM.nextInt(248 * 1024))];
		for (int i = 0; i < array.length; i++)
			array[i] = (byte) (currentTimeMillis() % 255);
		return array;
	}

	public SchedulingRequest getSchedulingRequestFromNode(String expType){
		Map<String, Object> results = null;
		Map.Entry<String,Object> dag = null;
		Node resultNode = null;
		SchedulingRequest schedulingRequest = null;
		try (Transaction tx = GRAPH_DB.beginTx()) {
			Result execResult = GRAPH_DB.execute("MATCH (a)-[:"+expType+"*]->(b) WHERE a.isExecuted='false' RETURN (collect (a))[0] AS n");
			ResourceIterator<Node> resultIterator=execResult.columnAs("n");
			if(resultIterator.hasNext()){
				resultNode = resultIterator.next();
				for (String key : resultNode.getPropertyKeys()) {
					System.out.println("Key: " + key + ", Value: " +  resultNode.getProperty(key));
					if(key.equals("schedulingRequest"))
						schedulingRequest = (SchedulingRequest) SerializationUtils.convertFromBytes((byte[]) resultNode.getProperty(key));
				}
			}
			tx.success();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//GRAPH_DB.shutdown();
		}

		return schedulingRequest;
	}

	public SchedulingRequest setExecutedAndGetNextNode(String expType){

		Map<String, Object> results = null;
		Map.Entry<String,Object> dag = null;
		Node resultNode = null;
		SchedulingRequest schedulingRequest = null;
		try (Transaction tx = GRAPH_DB.beginTx()) {
			Result execResult = GRAPH_DB.execute("MATCH (a)-[:"+expType+"*]->(b) WHERE a.isExecuted='false' RETURN (collect (a))[0] AS n");
			ResourceIterator<Node> resultIterator=execResult.columnAs("n");

			if(resultIterator.hasNext()){
				resultNode = resultIterator.next();
			}
			boolean isLastNode = false;
			if(null == resultNode) {
				execResult = GRAPH_DB.execute("MATCH (a)-[:" + expType + "*]->(b) WHERE not((b)-->()) RETURN b AS n");
				resultIterator = execResult.columnAs("n");
				resultNode = resultIterator.next();
				isLastNode = true;
			}
			resultNode.setProperty("isExecuted","true");

			if(isLastNode) return null;

			execResult = GRAPH_DB.execute("MATCH (a)-[:"+expType+"*]->(b) WHERE b.isExecuted='false' RETURN (collect (b))[0] AS n");
			resultIterator=execResult.columnAs("n");
			if(resultIterator.hasNext()){
				resultNode = resultIterator.next();
				for (String key : resultNode.getPropertyKeys()) {
					System.out.println("Key: " + key + ", Value: " +  resultNode.getProperty(key));
					if(key.equals("schedulingRequest"))
						schedulingRequest = (SchedulingRequest) SerializationUtils.convertFromBytes((byte[]) resultNode.getProperty(key));
				}
			}
			tx.success();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//GRAPH_DB.shutdown();
		}

		return schedulingRequest;
	}

	public List<String> getCompleteDag(String expType){
		Map<String, Object> results = null;
		Map.Entry<String,Object> dag = null;
		List<String> nodesList = new ArrayList<>();

		try (Transaction tx = GRAPH_DB.beginTx()) {
			Result execResult = GRAPH_DB.execute("MATCH path= (a)-[:" + expType +"*]-(b) RETURN collect(distinct labels(b))");
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
			//GRAPH_DB.shutdown();
		}
		return nodesList;
	}
}
