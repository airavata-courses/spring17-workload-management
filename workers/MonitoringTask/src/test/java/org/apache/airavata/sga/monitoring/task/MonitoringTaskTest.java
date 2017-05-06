package org.apache.airavata.sga.monitoring.task;

import org.apache.airavata.sga.commons.model.*;
import org.apache.airavata.sga.messaging.service.util.MessageContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by goshenoy on 4/19/17.
 */
public class MonitoringTaskTest {

    private static final Logger logger = LoggerFactory.getLogger(MonitoringTaskTest.class);

    public static void main(String[] args) {
        MonitoringTaskTest test = new MonitoringTaskTest();
        test.submitMockMonitoringRequest();
        test.submitMockMonitoringRequest();
        System.exit(0);
    }

    private void submitMockMonitoringRequest() {
        TaskContext taskContext = getCommonTaskContext();
        String expId = taskContext.getExperiment().getExperimentId();
        MessageContext messageContext = new MessageContext(taskContext, expId);
        try {
            logger.info("Submitting monitoring request for experimentId: {}", expId);
            MonitoringMessagingFactory.getMonitoringPublisher().publish(messageContext);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }
    }

    private static TaskContext getCommonTaskContext(){
        Experiment exp = new Experiment();
        exp.setExperimentId("test-exp-" + ThreadLocalRandom.current().nextInt(100));
        //exp.setExperimentId("experiment-" + ThreadLocalRandom.current().nextInt(5000));
        exp.setDiskMB(10);
        exp.setRamMB(128);
        exp.setNumCPU(0.1);
        exp.setWorkingDir("workdir");

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
        target.setHostname("54.172.180.210");
        target.setPort(22);
        target.setLoginId("centos");
        target.setMachineType(MachineType.CLOUD);
        target.setScratchDir("/home/centos/"+exp.getWorkingDir()+"/"+exp.getExperimentId());
        commands.add("cat " + target.getScratchDir() + "/input.txt" + " >> " + target.getScratchDir() + "/"+exp.getExperimentId()+"-output.txt");
        commands.add("echo " + "'Jobexecuted'" + " >> " + target.getScratchDir() + "/"+exp.getExperimentId()+"-output.txt");
        commands.add("ping -c 1000 localhost");
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
}
