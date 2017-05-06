namespace java org.apache.airavata.sga.graphdb.cpi

include "./common_data_models.thrift"

service OrchestratorService{
    /**
    * <p>Submit a job with specified type</p>
    **/
    string submitJob(1: required string experimentType)

    /**
    * <p>Get list of all experiments</p>
    **/
    list<common_data_models.ExperimentEntity> getExperimentList();

    /**
    * <p>Get experiment object</p>
    **/
    common_data_models.ExperimentEntity getExperiment (1:required string experimentId)

    /**
    * <p>Get task for specified experiment</p>
    **/
    list<common_data_models.TaskStateEntity> getTasksForExperiment(1:required string experimentId);
}