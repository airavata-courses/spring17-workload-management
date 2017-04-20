package org.apache.airavata.sga.graphdb.entity;

import org.neo4j.cypher.internal.frontend.v2_3.ast.functions.Str;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by goshenoy on 4/20/17.
 */

@Entity
public class TaskStateEntity {

    @Id
    String taskId;

    @Id
    @JoinColumn(name = "experimentId")
    @ManyToOne(targetEntity = ExperimentEntity.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    ExperimentEntity experiment;

    @Column
    String taskName;

    @Column
    Date taskStartTime;

    @Column
    Date taskEndTime;

    @Column
    Date taskLastUpdatedTime;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public ExperimentEntity getExperiment() {
        return experiment;
    }

    public void setExperiment(ExperimentEntity experiment) {
        this.experiment = experiment;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getTaskStartTime() {
        return taskStartTime;
    }

    public void setTaskStartTime(Date taskStartTime) {
        this.taskStartTime = taskStartTime;
    }

    public Date getTaskEndTime() {
        return taskEndTime;
    }

    public void setTaskEndTime(Date taskEndTime) {
        this.taskEndTime = taskEndTime;
    }

    public Date getTaskLastUpdatedTime() {
        return taskLastUpdatedTime;
    }

    public void setTaskLastUpdatedTime(Date taskLastUpdatedTime) {
        this.taskLastUpdatedTime = taskLastUpdatedTime;
    }

    @Override
    public String toString() {
        return "TaskStateEntity{" +
                "taskId='" + taskId + '\'' +
                ", experiment=" + experiment +
                ", taskName='" + taskName + '\'' +
                ", taskStartTime=" + taskStartTime +
                ", taskEndTime=" + taskEndTime +
                ", taskLastUpdatedTime=" + taskLastUpdatedTime +
                '}';
    }
}
