package org.apache.airavata.sga.graphdb.impl;
import static java.lang.Math.max;
import static java.lang.System.currentTimeMillis;

import java.io.File;
import java.sql.Connection;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.mysql.cj.core.util.TestUtils;
import org.apache.airavata.sga.commons.model.SchedulingRequest;
import org.apache.airavata.sga.graphdb.dao.EntityDAO;
import org.apache.airavata.sga.graphdb.dao.impl.EntityDAOImpl;
import org.apache.airavata.sga.graphdb.entity.State;
import org.apache.airavata.sga.graphdb.messaging.OrchestratorMessagePublisher;
import org.apache.airavata.sga.graphdb.messaging.OrchestratorMessagingFactory;
import org.apache.airavata.sga.graphdb.utils.Constants;
import org.apache.airavata.sga.graphdb.utils.DummySchedulingRequest;
import org.apache.airavata.sga.graphdb.utils.TaskRelationships;
import org.apache.airavata.sga.graphdb.utils.Tasks;
import org.apache.airavata.sga.messaging.service.core.Publisher;
import org.apache.airavata.sga.messaging.service.util.MessageContext;
import org.neo4j.cypher.internal.javacompat.ExecutionResult;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

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
		File f = new File("C:\\Neo4j");
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
		}
		return dag.getValue().toString();
	}

	public String getNextNode(String state, String expType){
		// TODO Auto-generated method stub
		File f = new File("C:\\Neo4j");
		GraphDatabaseFactory dbFactory = new GraphDatabaseFactory();
		GraphDatabaseService db = dbFactory.newEmbeddedDatabase(f);
		Map<String, Object> results = null;
		Map.Entry<String,Object> dag = null;
		try (Transaction tx = db.beginTx()) {

			Result execResult = db.execute("MATCH path= (a:"+state+")-[:"+expType+"*1]-(b) RETURN collect(distinct labels(b))");
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
		}
		return dag.getValue().toString();
	}

	public static void main(String[] args) {

		Neo4JJavaDbOperation neo4JJavaDbOperation = new Neo4JJavaDbOperation();
		SchedulingRequest schedulingRequest = null;

		try {
			String results = neo4JJavaDbOperation.getDag(TaskRelationships.BIOLOGY.toString());

			schedulingRequest = DummySchedulingRequest.getSchedulingRequest(Constants.fromString(results));
			State state = new State();
			state.setID(1);
			state.setState(Tasks.ENV_SETUP.toString());
			state.setExpType(TaskRelationships.BIOLOGY.toString());
			orchestratorMessagePublisher.publishSchedulingRequest(state, schedulingRequest);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
