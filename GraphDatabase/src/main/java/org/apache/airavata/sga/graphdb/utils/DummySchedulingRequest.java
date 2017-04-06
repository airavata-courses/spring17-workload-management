package org.apache.airavata.sga.graphdb.utils;

import org.apache.airavata.sga.commons.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Amruta on 3/23/2017.
 */
public class DummySchedulingRequest {
    public static final String INPUT_FILE = "/home/ubuntu/workdir/input.txt";

    public static TaskContext getCommonTaskContext(){

        Experiment exp = new Experiment();
        exp.setExperimentId("experiment-4675");
        //exp.setExperimentId("experiment-" + ThreadLocalRandom.current().nextInt(5000));
        exp.setDiskMB(10);
        exp.setRamMB(128);
        exp.setNumCPU(0.1);
        exp.setWorkingDir("wordir");

        // create application
        Application app = new Application();
        List<String> commands = new ArrayList<>();

        app.setCommands(commands);

        Data data = new Data();
        data.setName("name1");
        data.setValue("value1");
        data.setType(DataType.STRING);
        List<Data> inputs = new ArrayList<>();
        inputs.add(data);

        app.setInputs(inputs);
        app.setOutputs(inputs);


        // create target machine
        TargetMachine target = new TargetMachine();
        target.setHostname("54.152.106.52");
        target.setPort(22);
        target.setLoginId("centos");
        target.setMachineType(MachineType.CLOUD);
        target.setScratchDir("/home/centos/"+exp.getWorkingDir()+"/"+exp.getExperimentId());
        commands.add("cat " + INPUT_FILE + " >> " + target.getScratchDir() + "/output.txt");
        commands.add("echo " + "Job executed " + " >> " + target.getScratchDir() + "/output.txt");
        target.setDtProtocol(DataTransferProtocol.SCP);

        LocalStorage localStorage = new LocalStorage();
        localStorage.setLoginId("ubuntu");
        localStorage.setDtProtocol(DataTransferProtocol.SCP);
        localStorage.setHostname("54.245.78.146");
        localStorage.setScratchDir("/home/ubuntu/workdir/input.txt");
        localStorage.setPort(22);
        // create taskcontext
        TaskContext taskContext = new TaskContext();
        taskContext.setApplication(app);
        taskContext.setExperiment(exp);
        taskContext.setTargetMachine(target);
        taskContext.setLocalStorage(localStorage);

        return taskContext;
    }

    public static TaskContext getEnvironmentSetupTaskContext() {

        TaskContext taskContext = getCommonTaskContext();
        taskContext.setQueueName("queue.environmentsetup");

        return taskContext;
    }

    public static TaskContext getTaskContextForJobSubmission() {
        TaskContext taskContext = getCommonTaskContext();
        taskContext.setQueueName("queue.jobsubmission");

        return taskContext;
    }

    public static TaskContext getTaskContextForInputDataStaging() {
        // create taskcontext
        TaskContext taskContext = getCommonTaskContext();
        taskContext.setQueueName("queue.datastaging");

        return taskContext;
    }

    public static TaskContext getTaskContextForOutputDataStaging() {
        TaskContext taskContext = getCommonTaskContext();
        taskContext.setQueueName("queue.datastaging");
        return taskContext;
    }


    public static SchedulingRequest getJobSubmissionSchedulingRequest() {
        SchedulingRequest request = new SchedulingRequest();
        request.setTaskContext(getTaskContextForJobSubmission());
        request.setExperimentPriority(ExperimentPriority.NORMAL);
        request.setScheduleTime("2017-24-02");
        return request;
    }

    public static SchedulingRequest getDataStagingInputSchedulingRequest() {
        SchedulingRequest request = new SchedulingRequest();
        request.setTaskContext(getTaskContextForInputDataStaging());
        request.setExperimentPriority(ExperimentPriority.NORMAL);
        request.setScheduleTime("2017-24-02");
        return request;
    }

    public static SchedulingRequest getDataStagingOutputSchedulingRequest() {
        SchedulingRequest request = new SchedulingRequest();
        request.setTaskContext(getTaskContextForOutputDataStaging());
        request.setExperimentPriority(ExperimentPriority.NORMAL);
        request.setScheduleTime("2017-24-02");
        return request;
    }

    public static SchedulingRequest getEnvironmentSetupSchedulingRequest() {
        SchedulingRequest request = new SchedulingRequest();
        request.setTaskContext(getEnvironmentSetupTaskContext());
        request.setExperimentPriority(ExperimentPriority.NORMAL);
        request.setScheduleTime("2017-24-02");
        return request;
    }

    public static SchedulingRequest getSchedulingRequest(States task){
        switch (task){
            case ENV_SETUP:return getEnvironmentSetupSchedulingRequest();
            case INPUT_DATA_STAGING:return getDataStagingInputSchedulingRequest();
            case OUTPUT_DATA_STAGING:return getDataStagingOutputSchedulingRequest();
            case JOB_SUBMISSION:return getJobSubmissionSchedulingRequest();
            default: return null;
        }

    }
}