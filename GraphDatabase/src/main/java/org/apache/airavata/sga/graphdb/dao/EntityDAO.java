package org.apache.airavata.sga.graphdb.dao;

/**
 * Created by Amruta on 3/23/2017.
 */

import org.apache.airavata.sga.graphdb.entity.ExperimentEntity;
import org.apache.airavata.sga.graphdb.entity.State;
import org.apache.airavata.sga.graphdb.entity.TaskStateEntity;

import java.util.List;

public interface EntityDAO {

    public void saveEntity(Object entity) throws Exception;

    public int updateState(State State) throws Exception;

    public State getState(String StateId) throws Exception;

    public ExperimentEntity getExperimentEntity(String experimentId) throws Exception;

    public TaskStateEntity getTaskStateEntity(String taskId) throws Exception;

    public List<TaskStateEntity> getTaskListForExperiment(String experimentId) throws Exception;

    public List<ExperimentEntity> getExperimentList() throws Exception;
}
