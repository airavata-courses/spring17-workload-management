package org.apache.airavata.sga.graphdb.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by goshenoy on 4/20/17.
 */
public class ExperimentEntity {

    @Id
    String experimentId;

    @Column
    String experimentName;

    @Column
    String experimentType;

    @Column
    Date experimentStartTime;

    @Column
    Date experimentEndTime;

    @Column
    Date experimentLastUpdatedTime;

    public String getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(String experimentId) {
        this.experimentId = experimentId;
    }

    public String getExperimentName() {
        return experimentName;
    }

    public void setExperimentName(String experimentName) {
        this.experimentName = experimentName;
    }

    public String getExperimentType() {
        return experimentType;
    }

    public void setExperimentType(String experimentType) {
        this.experimentType = experimentType;
    }

    public Date getExperimentStartTime() {
        return experimentStartTime;
    }

    public void setExperimentStartTime(Date experimentStartTime) {
        this.experimentStartTime = experimentStartTime;
    }

    public Date getExperimentEndTime() {
        return experimentEndTime;
    }

    public void setExperimentEndTime(Date experimentEndTime) {
        this.experimentEndTime = experimentEndTime;
    }

    public Date getExperimentLastUpdatedTime() {
        return experimentLastUpdatedTime;
    }

    public void setExperimentLastUpdatedTime(Date experimentLastUpdatedTime) {
        this.experimentLastUpdatedTime = experimentLastUpdatedTime;
    }

    @Override
    public String toString() {
        return "ExperimentEntity{" +
                "experimentId='" + experimentId + '\'' +
                ", experimentName='" + experimentName + '\'' +
                ", experimentType='" + experimentType + '\'' +
                ", experimentStartTime=" + experimentStartTime +
                ", experimentEndTime=" + experimentEndTime +
                ", experimentLastUpdatedTime=" + experimentLastUpdatedTime +
                '}';
    }
}
