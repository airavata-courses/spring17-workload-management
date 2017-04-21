package org.apache.airavata.sga.monitoring.task.impl;

import org.apache.airavata.cloud.aurora.client.AuroraThriftClient;
import org.apache.airavata.cloud.aurora.client.bean.JobDetailsResponseBean;
import org.apache.airavata.cloud.aurora.client.bean.JobKeyBean;
import org.apache.airavata.cloud.aurora.client.bean.PendingJobReasonBean;
import org.apache.airavata.cloud.aurora.client.sdk.ScheduleStatus;
import org.apache.airavata.cloud.aurora.client.sdk.ScheduledTask;
import org.apache.airavata.sga.commons.model.Response;
import org.apache.airavata.sga.commons.model.Status;
import org.apache.airavata.sga.messaging.service.util.MessageContext;
import org.apache.airavata.sga.monitoring.task.messaging.MonitoringTaskPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by goshenoy on 4/19/17.
 */
public class JobMonitor implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(JobMonitor.class);
    private Timer timer;
    private JobKeyBean jobKeyBean;
    private String auroraHost;
    private int auroraPort;
    private String taskId;

    JobMonitor(JobKeyBean jobKeyBean, String taskId, String auroraHost, int auroraPort) {
        timer = new Timer("Aurora Job Status Poller", true);
        this.jobKeyBean = jobKeyBean;
        this.auroraHost = auroraHost;
        this.auroraPort = auroraPort;
        this.taskId = taskId;
    }

    @Override
    public void run() {
        try {
            if (this.jobKeyBean != null) {
                logger.info("Monitoring Aurora Job with ID: " + jobKeyBean.getName());
                AuroraTimer auroraTimer = new AuroraTimer();
                timer.schedule(auroraTimer, 0);
            } else {
                throw new Exception("JobKeyBean not set, cannot monitor aurora-job!");
            }
        } catch (Exception ex) {
            logger.error("JobMonitor Exception: " + ex.getMessage(), ex);
        }
    }

    private void handleMonitoringComplete(ScheduleStatus scheduleStatus) {
        logger.info("Monitoring for experiment: {} has completed with status '{}'. Sending message [Monitoring -> Scheduler]",
                jobKeyBean.getName(), scheduleStatus);
        Status status = (scheduleStatus.equals(ScheduleStatus.FINISHED) ? Status.OK : Status.FAILED);
        Response response = new Response(jobKeyBean.getName(), taskId, status);
        MessageContext messageContext = new MessageContext(response, jobKeyBean.getName());
        try {
            MonitoringTaskPublisher.getSchedulerPublisher().publish(messageContext);
        } catch (Exception ex) {
            logger.error("handleMonitoringComplete() -> Something went wrong while sending message: " + ex.getMessage(), ex);
        }

    }

    class AuroraTimer extends TimerTask {
        AuroraThriftClient auroraClient;
        private boolean isRunning = true;

        AuroraTimer() throws Exception {
            auroraClient = AuroraThriftClient.getAuroraThriftClient(auroraHost, auroraPort);
        }

        boolean isRunning() {
            return isRunning;
        }

        @Override
        public void run() {
            try {
                while (isRunning) {
                    JobDetailsResponseBean jobDetailsResponseBean = auroraClient.getJobDetails(jobKeyBean);
                    List<ScheduledTask> tasks = jobDetailsResponseBean.getTasks();
                    switch (tasks.get(0).getStatus()) {
                        case FINISHED:
                            isRunning = false;
                            handleMonitoringComplete(ScheduleStatus.FINISHED);
                            break;
                        case FAILED:
                            isRunning = false;
                            handleMonitoringComplete(ScheduleStatus.FAILED);
                            break;
                        case PENDING:
                            PendingJobReasonBean pendingReason = auroraClient.getPendingReasonForJob(jobKeyBean);
                            logger.info("Job {} is PENDING because of following reasons: " + pendingReason.getReasons());
                            break;
                        default:
                            logger.info("Job {} is '{}'. Continuing to monitor.", jobKeyBean.getName(), tasks.get(0).getStatus().name());
                            break;
                    }

                    // sleep for 3 secs
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException ex) {
                        logger.error("Aurora monitoring task interrupted!");
                    }

                }
            } catch (Exception ex) {
                logger.error("AuroraTimer Exception: " + ex.getMessage(), ex);
                handleMonitoringComplete(ScheduleStatus.FAILED);
            }
        }
    }
}
