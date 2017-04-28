package org.apache.airavata.sga.orchestrator.client;

import java.util.List;

import org.apache.airavata.sga.commons.db.model.ExperimentEntity;
import org.apache.airavata.sga.commons.db.model.TaskStateEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrchestratorServiceClient {

	private final static Logger logger = LoggerFactory.getLogger(OrchestratorServiceClient.class);
	
	public static ExperimentEntity getExperiment(String experimentId) throws Exception {
		try {
			logger.info("Getting experiment from OrchestratorService, expId: {}", experimentId);
			return OrchestratorClientFactory.getOrchestratorClient().getExperiment(experimentId);
		} catch (Exception ex) {
			logger.error("Failed to get experiment, reason: {}", ex.getMessage(), ex);
			throw ex;
		} finally {
			OrchestratorClientFactory.closeTransport();
		}
	}
	
	public static String submitJob(String experimentType) throws Exception {
		try {
			logger.info("Submitting job to OrchestratorService, expType: {}", experimentType);
			return OrchestratorClientFactory.getOrchestratorClient().submitJob(experimentType);
		} catch (Exception ex) {
			logger.error("Failed to submit job, reason: {}", ex.getMessage(), ex);
			throw ex;
		} finally {
			OrchestratorClientFactory.closeTransport();
		}
	}
	
	public static TaskStateEntity getTaskStateEntity(String taskId) throws Exception {
		try {
			logger.info("Getting task from OrchestratorService, taskId: {}", taskId);
			return OrchestratorClientFactory.getOrchestratorClient().getTaskDetails(taskId);
		} catch (Exception ex) {
			logger.error("Failed to get task, reason: {}", ex.getMessage(), ex);
			throw ex;
		} finally {
			OrchestratorClientFactory.closeTransport();
		}
	}
	
	public static List<ExperimentEntity> getExperiments() throws Exception {
		try {
			logger.info("Getting experiments from OrchestratorService");
			return OrchestratorClientFactory.getOrchestratorClient().getExperiments();
		} catch (Exception ex) {
			logger.error("Failed to get experiments, reason: {}", ex.getMessage(), ex);
			throw ex;
		} finally {
			OrchestratorClientFactory.closeTransport();
		}
	}
	
	public static List<TaskStateEntity> getTasksForExperiment(String experimentId) throws Exception {
		try {
			logger.info("Getting tasks for experiment from OrchestratorService, expId: {}", experimentId);
			return OrchestratorClientFactory.getOrchestratorClient().getTasksForExperiment(experimentId);
		} catch (Exception ex) {
			logger.error("Failed to get tasks for experiment, reason: {}", ex.getMessage(), ex);
			throw ex;
		} finally {
			OrchestratorClientFactory.closeTransport();
		}
	}
}
