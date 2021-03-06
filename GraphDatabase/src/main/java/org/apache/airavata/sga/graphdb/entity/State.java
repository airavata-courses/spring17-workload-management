package org.apache.airavata.sga.graphdb.entity;

/**
 * Created by Amruta on 3/22/2017.
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class State {

    @Id
    String ID;

    @Column
    String expType;

    @Column
    String state;

    public String getID() {
        return ID;
    }

    public String getExpType() {
        return expType;
    }

    public String getState() {
        return state;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setExpType(String expType) {
        this.expType = expType;
    }

    public void setState(String state) {
        this.state = state;
    }


}
