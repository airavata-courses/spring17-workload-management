package org.apache.airavata.sga.data.staging.task.handler.impl;

import org.apache.airavata.sga.commons.model.*;
import org.apache.airavata.sga.commons.task.CommonTask;
import org.apache.airavata.sga.data.staging.task.cluster.RemoteCluster;
import org.apache.airavata.sga.data.staging.task.cluster.impl.RemoteClusterImpl;
import org.apache.airavata.sga.data.staging.task.entity.ServerInfo;
import org.apache.airavata.sga.data.staging.task.exception.RemoteClusterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Ajinkya on 2/21/17.
 */
public class DataStagingTaskImpl implements CommonTask {

    private static final Logger logger = LoggerFactory.getLogger(DataStagingTaskImpl.class);

    @Override
    public void init() throws OperationFailedException {

    }

    @Override
    public Response execute(TaskContext taskContext) throws OperationFailedException {

        logger.info("execute() -> Staging file. Experiment Id : " + taskContext.getExperiment().getExperimentId());

        Response response = new Response();
        response.setExperimentId(taskContext.getExperiment().getExperimentId());
        response.setTaskId(taskContext.getTaskId());

        try {

            if(taskContext.getTargetMachine().getDtProtocol() != taskContext.getLocalStorage().getDtProtocol()){
                throw new RemoteClusterException("We do not support cross protocol transfer yet.");
            }

            ServerInfo targetMachine = new ServerInfo(taskContext.getTargetMachine().getLoginId(), taskContext.getTargetMachine().getHostname(), "", taskContext.getTargetMachine().getPort());
            ServerInfo localMachine = new ServerInfo(taskContext.getLocalStorage().getLoginId(), taskContext.getLocalStorage().getHostname(), "", taskContext.getLocalStorage().getPort());
            ServerInfo serverFrom;
            ServerInfo serverTo;
            String sourceFilePath;
            String destFilePath;
            if(taskContext.getDataStagingDirection() == DataStagingDirection.OUTPUT){
                serverFrom = targetMachine;
                serverTo = localMachine;
                sourceFilePath = taskContext.getTargetMachine().getScratchDir();
                destFilePath = taskContext.getLocalStorage().getScratchDir();
            }else{
                serverFrom = localMachine;
                serverTo = targetMachine;
                sourceFilePath = taskContext.getLocalStorage().getScratchDir();
                destFilePath = taskContext.getTargetMachine().getScratchDir();
            }

            RemoteCluster remoteCluster = new RemoteClusterImpl(serverFrom, serverTo, taskContext.getTargetMachine().getDtProtocol());
            remoteCluster.thirdPartyTransfer(sourceFilePath, destFilePath, true);

            logger.info("execute() -> File transferred successfully. Experiment Id : " + taskContext.getExperiment().getExperimentId() + ", Source : " + taskContext.getLocalStorage().getScratchDir() + ", Destination : " + taskContext.getTargetMachine().getScratchDir());
            response.setStatus(Status.OK);
            response.setMessage("File staged successfully.");

        } catch (RemoteClusterException e) {

            logger.error("execute() ->Error staging file. Experiment Id : " + taskContext.getExperiment().getExperimentId(), e);

            response.setStatus(Status.FAILED);
            response.setMessage("Error staging file. Reason: " + e.getMessage());
        }
        return response;
    }

    @Override
    public void postExecute() throws OperationFailedException {

    }
}
