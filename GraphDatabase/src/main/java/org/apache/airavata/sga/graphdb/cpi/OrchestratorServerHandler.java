package org.apache.airavata.sga.graphdb.cpi;

import org.apache.airavata.sga.commons.model.ExperimentEntity;
import org.apache.airavata.sga.commons.model.TaskStateEntity;
import org.apache.airavata.sga.graphdb.utils.OrchestratorUtil;
import org.apache.airavata.sga.graphdb.utils.ThriftDataModelConversion;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Ajinkya on 4/27/17.
 */
public class OrchestratorServerHandler implements OrchestratorService.Iface {

    private final static Logger logger = LoggerFactory.getLogger(OrchestratorServerHandler.class);

    @Override
    public String submitJob(String experimentType) throws TException {
        try {
            logger.info("Submitting experiment. Experiment Type : " + experimentType);
            return OrchestratorUtil.submitJob(experimentType);
        } catch (Exception e) {
            logger.error("Error submitting job. Experiment Type : " + experimentType, e);
            throw new TException("Error submitting job. Experiment Type : " + experimentType);
        }
    }

    @Override
    public List<ExperimentEntity> getExperimentList() throws TException {
        logger.info("Fetching experiment list.");
        try {
            return ThriftDataModelConversion.getExperimentList(OrchestratorUtil.getExperimentList());
        } catch (Exception e) {
            logger.error("Error fetching experiments.", e);
            throw new TException("Error fetching experiments.");
        }
    }

    @Override
    public ExperimentEntity getExperiment(String experimentId) throws TException {
        logger.info("Get experiment. Experiment Id : " + experimentId);
        try {
            return ThriftDataModelConversion.getExperimentEntity(OrchestratorUtil.getExperiment(experimentId));
        } catch (Exception e) {
            logger.error("Error fetching experiments.", e);
            throw new TException("Error fetching experiment.");
        }
    }

    @Override
    public List<TaskStateEntity> getTasksForExperiment(String experimentId) throws TException {
        logger.info("Get task list. Experiment Id : " + experimentId);
        try {
            return ThriftDataModelConversion.getTaskList(OrchestratorUtil.getTasksForExperiment(experimentId));
        } catch (Exception e) {
            logger.error("Error fetching task list. Experiment Id : " + experimentId, e);
            throw new TException("Error fetching task list. Experiment Id : " + experimentId);
        }
    }
}
