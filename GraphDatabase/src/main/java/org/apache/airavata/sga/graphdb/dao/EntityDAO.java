package org.apache.airavata.sga.graphdb.dao;

/**
 * Created by Amruta on 3/23/2017.
 */

import org.apache.airavata.sga.graphdb.entity.State;
import java.util.List;

public interface EntityDAO {

    public void saveEntity(Object entity) throws Exception;

    public int updateState(State State) throws Exception;

    public State getState(Integer StateId) throws Exception;
}
