package org.apache.airavata.sga.monitoring.task.impl;

import org.apache.airavata.sga.commons.model.OperationFailedException;
import org.apache.airavata.sga.commons.model.Response;
import org.apache.airavata.sga.commons.model.Status;
import org.apache.airavata.sga.commons.model.TaskContext;
import org.apache.airavata.sga.commons.task.CommonTask;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Created by goshenoy on 4/19/17.
 */
public class MonitoringTaskImpl implements CommonTask {

    /** The Constant logger. */
    private static final Logger logger = LogManager.getLogger(MonitoringTaskImpl.class);

    @Override
    public void init() throws OperationFailedException {
        // TODO Auto-generated method stub
    }

    @Override
    public Response execute(TaskContext taskContext) throws OperationFailedException {
        Response response = new Response();
        response.setExperimentId(taskContext.getExperiment().getExperimentId());
        try {

        } catch (Exception ex) {
            logger.error("MonitoringTask failed, reason: " + ex.getMessage(), ex);
            response.setStatus(Status.FAILED);
            response.setMessage("MonitoringTask failed, reason: " + ex.getMessage());
        }
        return response;
    }

    @Override
    public void postExecute() throws OperationFailedException {
        // TODO Auto-generated method stub
    }
}
