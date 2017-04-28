package org.apache.airavata.sga.graphdb.handler;

import javafx.concurrent.Task;
import org.apache.airavata.sga.commons.db.model.ExperimentEntity;
import org.apache.airavata.sga.commons.db.model.TaskStateEntity;
import org.apache.airavata.sga.graphdb.service.OrchestratorService;
import org.apache.airavata.sga.graphdb.service.OrchestratorServiceException;
import org.apache.airavata.sga.graphdb.utils.OrchestratorUtil;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by goshenoy on 4/27/17.
 */
public class OrchestratorServerHandler implements OrchestratorService.Iface {

    private final static Logger logger = LoggerFactory.getLogger(OrchestratorServerHandler.class);

    @Override
    public String submitJob(String experimentId) throws OrchestratorServiceException, TException {
        try {
            logger.info("OrchestratorServerHandler.submitJob | experimentId: " + experimentId);
            return OrchestratorUtil.submitJob(experimentId);
        } catch (Exception ex) {
            logger.error("OrchestratorServerHandler.submitJob | Failed to submit Job. Reason: " + ex.getMessage(), ex);
            OrchestratorServiceException ose = new OrchestratorServiceException();
            ose.setMessage(ex.getMessage());
            throw ose;
        }
    }

    @Override
    public ExperimentEntity getExperiment(String experimentId) throws OrchestratorServiceException, TException {
        try {
            logger.info("OrchestratorServerHandler.getExperiment | experimentId: " + experimentId);
            return mapToExperimentEntity(OrchestratorUtil.getExperiment(experimentId));
        } catch (Exception ex) {
            logger.error("OrchestratorServerHandler.getExperiment | Failed to getExperiment. Reason: " + ex.getMessage(), ex);
            OrchestratorServiceException ose = new OrchestratorServiceException();
            ose.setMessage(ex.getMessage());
            throw ose;
        }
    }

    @Override
    public TaskStateEntity getTaskDetails(String taskId) throws OrchestratorServiceException, TException {
        try {
            logger.info("OrchestratorServerHandler.getTaskDetails | taskId: " + taskId);
            return mapToTaskStateEntity(OrchestratorUtil.getTaskStateEntity(taskId));
        } catch (Exception ex) {
            logger.error("OrchestratorServerHandler.getTaskDetails | Failed to getTaskDetails. Reason: " + ex.getMessage(), ex);
            OrchestratorServiceException ose = new OrchestratorServiceException();
            ose.setMessage(ex.getMessage());
            throw ose;
        }
    }

    @Override
    public List<ExperimentEntity> getExperiments() throws OrchestratorServiceException, TException {
        List<ExperimentEntity> experimentEntities = new ArrayList<>();
        try {
            logger.info("OrchestratorServerHandler.getExperiments");
            for (org.apache.airavata.sga.graphdb.entity.ExperimentEntity experimentEntity : OrchestratorUtil.getExperimentList()) {
                experimentEntities.add(mapToExperimentEntity(experimentEntity));
            }
        } catch (Exception ex) {
            logger.error("OrchestratorServerHandler.getExperiments | Failed to getExperiments. Reason: " + ex.getMessage(), ex);
            OrchestratorServiceException ose = new OrchestratorServiceException();
            ose.setMessage(ex.getMessage());
            throw ose;
        }
        return experimentEntities;
    }

    @Override
    public List<TaskStateEntity> getTasksForExperiment(String experimentId) throws OrchestratorServiceException, TException {
        List<TaskStateEntity> taskStateEntities = new ArrayList<>();
        try {
            logger.info("OrchestratorServerHandler.getTasksForExperiment | experimentId: " + experimentId);
            for (org.apache.airavata.sga.graphdb.entity.TaskStateEntity taskStateEntity : OrchestratorUtil.getTasksForExperiment(experimentId)) {
                taskStateEntities.add(mapToTaskStateEntity(taskStateEntity));
            }
        } catch (Exception ex) {
            logger.error("OrchestratorServerHandler.getTasksForExperiment | Failed to getTasksForExperiment. Reason: " + ex.getMessage(), ex);
            OrchestratorServiceException ose = new OrchestratorServiceException();
            ose.setMessage(ex.getMessage());
            throw ose;
        }
        return taskStateEntities;
    }

    private ExperimentEntity mapToExperimentEntity(org.apache.airavata.sga.graphdb.entity.ExperimentEntity experimentEntity) {
        ExperimentEntity entity = null;
        logger.info("OrchestratorServerHandler.mapToExperimentEntity | ExperimentEntity: " + experimentEntity);
        if (experimentEntity != null) {
            entity = new ExperimentEntity();
            entity.setExperimentId(experimentEntity.getExperimentId());
            entity.setExperimentName(experimentEntity.getExperimentName());
            entity.setExperimentStatus(experimentEntity.getExperimentStatus());
            if (experimentEntity.getExperimentStartTime() != null) {
                entity.setExperimentStartTime(experimentEntity.getExperimentStartTime().getTime());
            }
            if (experimentEntity.getExperimentEndTime() != null) {
                entity.setExperimentEndTime(experimentEntity.getExperimentEndTime().getTime());
            }
            if (experimentEntity.getExperimentLastUpdatedTime() != null) {
                entity.setExperimentLastUpdatedTime(experimentEntity.getExperimentLastUpdatedTime().getTime());
            }
        }
        return entity;
    }

    private TaskStateEntity mapToTaskStateEntity(org.apache.airavata.sga.graphdb.entity.TaskStateEntity taskStateEntity) {
        TaskStateEntity entity = null;
        logger.info("OrchestratorServerHandler.mapToTaskStateEntity | taskStateEntity: " + taskStateEntity);
        if (taskStateEntity != null) {
            entity = new TaskStateEntity();
            entity.setTaskId(taskStateEntity.getTaskId());
            entity.setTaskName(taskStateEntity.getTaskName());
            entity.setExperiment(mapToExperimentEntity(taskStateEntity.getExperiment()));
            if (taskStateEntity.getTaskStartTime() != null) {
                entity.setTaskStartTime(taskStateEntity.getTaskStartTime().getTime());
            }
            if (taskStateEntity.getTaskEndTime() != null) {
                entity.setTaskEndTime(taskStateEntity.getTaskEndTime().getTime());
            }
            if (taskStateEntity.getTaskLastUpdatedTime() != null) {
                entity.setTaskLastUpdatedTime(taskStateEntity.getTaskLastUpdatedTime().getTime());
            }
        }
        return entity;
    }
}
