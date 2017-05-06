package org.apache.airavata.sga.graphdb.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by goshenoy on 4/26/17.
 */
public class JPAUtils {

    private final static Logger logger = LoggerFactory.getLogger(JPAUtils.class);
    private static final String PERSISTENCE_UNIT_NAME = "workload-jpa";

    @PersistenceUnit(unitName = PERSISTENCE_UNIT_NAME)
    private static EntityManagerFactory factory;

    public static EntityManager getEntityManager(){
        EntityManager entityManager;

        if (factory == null) {
            String connectionURL = "jdbc:mysql://" + Constants.getMysqlJdbcConnection() + "/" + Constants.getMysqlJdbcDb() +
                    "?nullNamePatternMatchesAll=true&" +
                    "useUnicode=true&useJDBCCompliantTimezoneShift=true&" +
                    "useLegacyDatetimeCode=false&serverTimezone=UTC";
            logger.info(connectionURL);

            Map<String, String> properties = new HashMap<String, String>();
            properties.put("openjpa.ConnectionURL", connectionURL);
            properties.put("javax.persistence.jdbc.user", Constants.getMysqlJdbcUser());
            properties.put("javax.persistence.jdbc.password", Constants.getMysqlJdbcPassword());
            properties.put("openjpa.RuntimeUnenhancedClasses", "warn");
            properties.put("openjpa.RemoteCommitProvider", "sjvm");
            properties.put("openjpa.Log", "DefaultLevel=INFO, Runtime=INFO, Tool=INFO, SQL=INFO");
            properties.put("openjpa.jdbc.SynchronizeMappings", "buildSchema(ForeignKeys=true)");
            properties.put("openjpa.jdbc.QuerySQLCache", "false");
            properties.put("openjpa.ConnectionFactoryProperties", "PrettyPrint=true, PrettyPrintLineLength=72," +
                    " PrintParameters=true, MaxActive=10, MaxIdle=5, MinIdle=2, MaxWait=31536000,  autoReconnect=true");
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME, properties);
        }
        entityManager = factory.createEntityManager();
        return entityManager;
    }

}
