package org.apache.airavata.sga.monitoring.task.impl;

import org.apache.airavata.cloud.aurora.client.bean.JobKeyBean;
import org.apache.airavata.sga.commons.model.OperationFailedException;
import org.apache.airavata.sga.commons.model.Response;
import org.apache.airavata.sga.commons.model.Status;
import org.apache.airavata.sga.commons.model.TaskContext;
import org.apache.airavata.sga.commons.task.CommonTask;
import org.apache.airavata.sga.monitoring.task.util.AuroraUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by goshenoy on 4/19/17.
 */
public class MonitoringTaskImpl implements CommonTask {

    /** The Constant logger. */
    private static final Logger logger = LoggerFactory.getLogger(MonitoringTaskImpl.class);

    @Override
    public void init() throws OperationFailedException {
        // TODO Auto-generated method stub
    }

    @Override
    public Response execute(TaskContext taskContext) throws OperationFailedException {
        Response response = new Response();
        response.setExperimentId(taskContext.getExperiment().getExperimentId());
        try {
//            Thread thread = new Thread(
//                    new JobMonitor(
//                            new JobKeyBean(
//                                    AuroraUtils.ENVIRONMENT, taskContext.getTargetMachine().getLoginId(), taskContext.getExperiment().getExperimentId()
//                            ),
//                            taskContext.getTargetMachine().getHostname(),
//                            0
//                    )
//            );
//            thread.start();
            logger.info("[STARTING] monitoring task for experiment {}", taskContext.getExperiment().getExperimentId());
            new JobMonitor(
                    new JobKeyBean(
                            AuroraUtils.ENVIRONMENT, taskContext.getTargetMachine().getLoginId(), taskContext.getExperiment().getExperimentId()
                    ),
                    taskContext.getTargetMachine().getHostname(),
                    0
            ).runTest();
            logger.info("[STARTED] monitoring task for experiment {}", taskContext.getExperiment().getExperimentId());
            response.setStatus(Status.OK);
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