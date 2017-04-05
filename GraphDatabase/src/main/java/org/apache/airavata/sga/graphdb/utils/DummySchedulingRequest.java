package org.apache.airavata.sga.graphdb.utils;

import org.apache.airavata.sga.commons.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Amruta on 3/23/2017.
 */
public class DummySchedulingRequest {
    private static boolean isInputTask = true;
    public static TaskContext getEnvironmentSetupTaskContext() {
        // create experiment
        Experiment exp = new Experiment();
        exp.setExperimentId("experiment-" + ThreadLocalRandom.current().nextInt(5000));
        exp.setDiskMB(10);
        exp.setRamMB(128);
        exp.setNumCPU(0.1);
        exp.setWorkingDir("wordir");

        // create application
        Application app = new Application();
        List<String> commands = new ArrayList<>();
        commands.add("ping sga-mesos-master -c 4");
        commands.add("ping sga-mesos-slave -c 4");
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
        target.setHostname("iris.ils.indiana.edu");
        target.setPort(22);
        target.setLoginId("adhamnas");
        target.setMachineType(MachineType.CLOUD);
        target.setScratchDir("/home/adhamnas/www/test4/test/");
        target.setDtProtocol(DataTransferProtocol.SCP);
        // create taskcontext
        TaskContext taskContext = new TaskContext();
        taskContext.setApplication(app);
        taskContext.setExperiment(exp);
        taskContext.setTargetMachine(target);
        taskContext.setQueueName("queue.environmentsetup");

        return taskContext;
    }

    public static TaskContext getTaskContextForJobSubmission() {
        // create experiment
        Experiment exp = new Experiment();
        exp.setExperimentId("experiment-" + ThreadLocalRandom.current().nextInt(5000));
        exp.setDiskMB(10);
        exp.setRamMB(128);
        exp.setNumCPU(0.1);

        // create application
        Application app = new Application();
        List<String> commands = new ArrayList<>();
        commands.add("ping sga-mesos-master -c 4");
        commands.add("ping sga-mesos-slave -c 4");
        app.setCommands(commands);

        // create target machine
        TargetMachine target = new TargetMachine();
        target.setHostname("sga-mesos-master");
        target.setPort(8081);
        target.setLoginId("centos");
        target.setMachineType(MachineType.CLOUD);

        // create taskcontext
        TaskContext taskContext = new TaskContext();
        taskContext.setApplication(app);
        taskContext.setExperiment(exp);
        taskContext.setTargetMachine(target);
        taskContext.setQueueName("queue.jobsubmission");

        return taskContext;
    }

    public static TaskContext getTaskContextForInputDataStaging() {
        // create experiment
        Experiment exp = new Experiment();
        exp.setExperimentId("experiment-" + ThreadLocalRandom.current().nextInt(5000));
        exp.setDiskMB(10);
        exp.setRamMB(128);
        exp.setNumCPU(0.1);

        // create application
        Application app = new Application();
        List<String> commands = new ArrayList<>();
        commands.add("ping sga-mesos-master -c 4");
        commands.add("ping sga-mesos-slave -c 4");
        app.setCommands(commands);

        // create target machine
        TargetMachine target = new TargetMachine();
        target.setHostname("sga-mesos-master");
        target.setPort(8081);
        target.setLoginId("centos");
        target.setMachineType(MachineType.CLOUD);

        // create taskcontext
        TaskContext taskContext = new TaskContext();
        taskContext.setApplication(app);
        taskContext.setExperiment(exp);
        taskContext.setTargetMachine(target);
        taskContext.setQueueName("queue.datastaging");

        return taskContext;
    }

    public static TaskContext getTaskContextForOutputDataStaging() {
        // create experiment
        Experiment exp = new Experiment();
        exp.setExperimentId("experiment-" + ThreadLocalRandom.current().nextInt(5000));
        exp.setDiskMB(10);
        exp.setRamMB(128);
        exp.setNumCPU(0.1);

        // create application
        Application app = new Application();
        List<String> commands = new ArrayList<>();
        commands.add("ping sga-mesos-master -c 4");
        commands.add("ping sga-mesos-slave -c 4");
        app.setCommands(commands);

        // create target machine
        TargetMachine target = new TargetMachine();
        target.setHostname("sga-mesos-master");
        target.setPort(8081);
        target.setLoginId("centos");
        target.setMachineType(MachineType.CLOUD);

        // create taskcontext
        TaskContext taskContext = new TaskContext();
        taskContext.setApplication(app);
        taskContext.setExperiment(exp);
        taskContext.setTargetMachine(target);
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
            case DATA_STAGING:
                if(isInputTask) {
                    isInputTask = false;
                    return getDataStagingInputSchedulingRequest();
                }
                else {
                    isInputTask = true;
                    return getDataStagingOutputSchedulingRequest();
                }
            case JOB_SUBMISSION:return getJobSubmissionSchedulingRequest();
            default: return null;
        }

    }
}
