include 'db_data_models.thrift'

namespace java org.apache.airavata.sga.graphdb.service

exception OrchestratorServiceException {
    1: required string message
}

service OrchestratorService {
    string submitJob(1: required string experimentId)
                throws (1: OrchestratorServiceException ose);

    db_data_models.ExperimentEntity getExperiment(1: required string experimentId)
                throws (1: OrchestratorServiceException ose);

    db_data_models.TaskStateEntity getTaskForExperiment(1: required string experimentId)
                throws (1: OrchestratorServiceException ose);

    list<db_data_models.ExperimentEntity> getExperiments()
                throws (1: OrchestratorServiceException ose);

    list<db_data_models.TaskStateEntity> getTasksForExperiment(1: required string experimentId)
               throws (1: OrchestratorServiceException ose);
}