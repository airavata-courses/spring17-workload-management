package org.apache.airavata.sga.graphdb.utils;

import org.apache.airavata.sga.commons.model.ExperimentEntity;
import org.apache.airavata.sga.commons.model.TaskStateEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ajinkya on 4/27/17.
 */
public class ThriftDataModelConversion {

    public static ExperimentEntity getExperimentEntity(org.apache.airavata.sga.graphdb.entity.ExperimentEntity experimentDAO){
        ExperimentEntity experimentEntity = new ExperimentEntity();
        experimentEntity.setExperimentId(experimentDAO.getExperimentId());
        experimentEntity.setExperimentName(experimentDAO.getExperimentName());
        experimentEntity.setExperimentStatus(experimentDAO.getExperimentStatus());
        experimentEntity.setExperimentType(experimentDAO.getExperimentType());
        experimentEntity.setExperimentStartTime(experimentDAO.getExperimentStartTime().toString());
        if(null !=experimentDAO.getExperimentLastUpdatedTime()){
            experimentEntity.setExperimentLastUpdatedTime(experimentDAO.getExperimentLastUpdatedTime().toString());
        }
        if(null != experimentDAO.getExperimentEndTime()){
            experimentEntity.setExperimentEndTime(experimentDAO.getExperimentEndTime().toString());
        }
        return experimentEntity;
    }

    public static TaskStateEntity getExperimentEntity(org.apache.airavata.sga.graphdb.entity.TaskStateEntity taskDAO){
        TaskStateEntity taskStateEntity = new TaskStateEntity();
        taskStateEntity.setTaskId(taskDAO.getTaskId());
        taskStateEntity.setTaskName(taskDAO.getTaskName());
        taskStateEntity.setExperiment(getExperimentEntity(taskDAO.getExperiment()));
        taskStateEntity.setTaskStartTime(taskDAO.getTaskStartTime().toString());
        if(null != taskDAO.getTaskLastUpdatedTime()){
            taskStateEntity.setTaskLastUpdatedTime(taskDAO.getTaskLastUpdatedTime().toString());
        }
        if(null != taskDAO.getTaskEndTime()){
            taskStateEntity.setTaskEndTime(taskDAO.getTaskEndTime().toString());
        }
        return taskStateEntity;
    }

    public static List<ExperimentEntity> getExperimentList(List<org.apache.airavata.sga.graphdb.entity.ExperimentEntity> experimentDAOs){
        List<ExperimentEntity> experimentList = new ArrayList<>();
        for( org.apache.airavata.sga.graphdb.entity.ExperimentEntity experimentDao : experimentDAOs){
            experimentList.add(getExperimentEntity(experimentDao));
        }
        return experimentList;
    }

    public static List<TaskStateEntity> getTaskList(List<org.apache.airavata.sga.graphdb.entity.TaskStateEntity> taskDAOs){
        List<TaskStateEntity> taskList = new ArrayList<>();
        for( org.apache.airavata.sga.graphdb.entity.TaskStateEntity taskDAO : taskDAOs){
            taskList.add(getExperimentEntity(taskDAO));
        }
        return taskList;
    }
}
