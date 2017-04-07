import org.apache.airavata.sga.graphdb.dao.EntityDAO;
import org.apache.airavata.sga.graphdb.dao.impl.EntityDAOImpl;
import org.apache.airavata.sga.graphdb.entity.State;
import org.apache.airavata.sga.graphdb.utils.ExpTypes;
import org.apache.airavata.sga.graphdb.utils.States;

/**
 * Created by Amruta on 3/23/2017.
 */
public class StateDBTest {

    private static final EntityDAO DAO = new EntityDAOImpl();

    public void saveState(){
        State state = new State();
        state.setID("exp");
        state.setState(States.ENV_SETUP.toString());
        state.setExpType(ExpTypes.BIOLOGY.toString());

        try {
            DAO.saveEntity(state);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateState(){
        State state = new State();
        state.setID("exp");
        state.setState(States.ENV_SETUP.toString());
        state.setExpType(ExpTypes.CHEMISTRY.toString());

        try {
            DAO.updateState(state);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getState(){
        try {
            System.out.println(DAO.getState("exp"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]){
        StateDBTest stateDBTest = new StateDBTest();

        stateDBTest.saveState();
        stateDBTest.getState();
    }
}
