package org.apache.airavata.sga.graphdb.dao;

/**
 * Created by Amruta on 3/23/2017.
 */

import org.apache.airavata.sga.graphdb.entity.State;
import java.util.List;

public interface EntityDAO {

    public void saveEntity(Object entity) throws Exception;

    public int updateState(org.apache.airavata.sga.graphdb.entity.State State) throws Exception;

    public String getState(Integer StateId, String task) throws Exception;
}
