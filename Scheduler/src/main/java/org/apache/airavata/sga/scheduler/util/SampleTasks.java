package org.apache.airavata.sga.scheduler.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.airavata.sga.commons.model.Application;
import org.apache.airavata.sga.commons.model.Data;
import org.apache.airavata.sga.commons.model.DataTransferProtocol;
import org.apache.airavata.sga.commons.model.DataType;
import org.apache.airavata.sga.commons.model.Experiment;
import org.apache.airavata.sga.commons.model.ExperimentPriority;
import org.apache.airavata.sga.commons.model.MachineType;
import org.apache.airavata.sga.commons.model.SchedulingRequest;
import org.apache.airavata.sga.commons.model.TargetMachine;
import org.apache.airavata.sga.commons.model.TaskContext;
import org.apache.airavata.sga.messaging.service.core.MessagingFactory;
import org.apache.airavata.sga.messaging.service.core.Publisher;
import org.apache.airavata.sga.messaging.service.core.Subscriber;

public class SampleTasks {
	
	public static TaskContext getTaskContext() {
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
	    
	    public static SchedulingRequest getSchedulingRequest() {
	    	SchedulingRequest request = new SchedulingRequest();
	    	request.setTaskContext(getTaskContext());
	    	request.setExperimentPriority(ExperimentPriority.NORMAL);
	    	request.setScheduleTime("2017-24-02");
	    	return request;
	    }
	    
	    public static SchedulingRequest getJobSubmissionSchedulingRequest() {
	    	SchedulingRequest request = new SchedulingRequest();
	    	request.setTaskContext(getTaskContextForJobSubmission());
	    	request.setExperimentPriority(ExperimentPriority.NORMAL);
	    	request.setScheduleTime("2017-24-02");
	    	return request;
	    }

	    public static Publisher getSchedulerMessagePublisher(){
	        return MessagingFactory.getPublisher(Constants.SCHEDULER_MESSAGE_RABBITMQ_PROPERTIES);
	    }

}
