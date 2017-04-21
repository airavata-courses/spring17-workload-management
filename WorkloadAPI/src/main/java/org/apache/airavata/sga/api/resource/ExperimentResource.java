package org.apache.airavata.sga.api.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.airavata.sga.graphdb.entity.ExperimentEntity;
import org.apache.airavata.sga.graphdb.entity.TaskStateEntity;
import org.apache.airavata.sga.graphdb.utils.OrchestratorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

@Path("experiment")
public class ExperimentResource {

	private final static Logger logger = LoggerFactory.getLogger(ExperimentResource.class);
	private ObjectMapper mapper = new ObjectMapper();
	
	@POST
	@Path("launch")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	public Response launchExperiment(String experimentType) {
		ResponseBuilder response = null;
		try {		
			logger.info("Submitting experiment with type: {}", experimentType);
			String experimentId = OrchestratorUtil.submitJob(experimentType);
			logger.info("Launched experiment with Id: {}, type: {}", experimentId, experimentType);
			response = Response.ok("{ \"experimentId\": \"" + experimentId + "\" }");
		} catch (Exception ex) {
			response = Response.serverError().entity("Failed to launch Experiment. Reason: " + ex.getMessage());
		}
		return response.build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getExperiments() {
		ResponseBuilder response = null;
		try {		
			logger.info("Getting experiment list");
			List<ExperimentEntity> experimentList = OrchestratorUtil.getExperimentList();
			
			String expJSON = mapper.writeValueAsString(experimentList);
			logger.info("Retrieved experiment list: {}", expJSON);
			response = Response.ok(expJSON);
		} catch (Exception ex) {
			response = Response.serverError().entity("Failed to get experiment list. Reason: " + ex.getMessage());
		}
		return response.build();
	}
	
	@GET
	@Path("{experimentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getExperiment(@PathParam("experimentId") String experimentId) {
		ResponseBuilder response = null;
		try {		
			logger.info("Getting experiment with Id: {}", experimentId);
			ExperimentEntity experiment = OrchestratorUtil.getExperiment(experimentId);
			
			String expJSON = mapper.writeValueAsString(experiment);
			logger.info("Retrieved experiment: {}", expJSON);
			response = Response.ok(expJSON);
		} catch (Exception ex) {
			response = Response.serverError().entity("Failed to get Experiment. Reason: " + ex.getMessage());
		}
		return response.build();
	}
	
	@GET
	@Path("{experimentId}/tasks")
	public Response getTasksForExperiment(@PathParam("experimentId") String experimentId) {
		ResponseBuilder response = null;
		try {		
			logger.info("Getting task-list for experiment with Id: {}", experimentId);
			List<TaskStateEntity> taskList = OrchestratorUtil.getTasksForExperiment(experimentId);
			
			String taskListJSON = mapper.writeValueAsString(taskList);
			logger.info("Retrieved task-list: {}", taskListJSON);
			response = Response.ok(taskListJSON);
		} catch (Exception ex) {
			response = Response.serverError().entity("Failed to get tasks. Reason: " + ex.getMessage());
		}
		return response.build();
	}
}
