package org.apache.airavata.sga.graphdb.dao.impl;

/**
 * Created by Amruta on 3/23/2017.
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.airavata.sga.commons.model.Experiment;
import org.apache.airavata.sga.graphdb.entity.ExperimentEntity;
import org.apache.airavata.sga.graphdb.entity.TaskStateEntity;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.apache.airavata.sga.graphdb.entity.State;
import org.apache.airavata.sga.graphdb.dao.EntityDAO;

import java.util.List;

public class EntityDAOImpl implements EntityDAO{

    Logger logger = LogManager.getLogger(EntityDAOImpl.class);
    @Override
    public void saveEntity(Object entity) throws Exception {
        try {
            logger.info("Saving entity in database. Entity: " + entity);
            // Connection details loaded from persistence.xml to create EntityManagerFactory.
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-state");

            EntityManager em = emf.createEntityManager();

            // Creating a new transaction.
            EntityTransaction tx = em.getTransaction();

            tx.begin();

            // Persisting the entity object.
            em.merge(entity);

            //orderSubscriber.sendAck(deliveryTag);

            // Committing transaction.
            tx.commit();

            logger.info("DB persist successful; closing connections now!");

            // Closing connection.
            em.close();
            emf.close();
        } catch (Exception ex) {
            logger.error("Error persisting entity in database. Error: " + ex.getMessage(), ex);
            throw ex;
        }
    }

    @Override
    public int updateState(State state) throws Exception {
        int rowsUpdated;
        try {
            // Connection details loaded from persistence.xml to create EntityManagerFactory.
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-state");

            EntityManager em = emf.createEntityManager();

            // Creating a new transaction.
            EntityTransaction tx = em.getTransaction();

            tx.begin();

            Query query = em.createQuery("UPDATE State SET state = "+ state.getState() + " WHERE ID = " + state.getID() + "AND taskType =" + state.getExpType());
            rowsUpdated = query.executeUpdate();

            // Committing transaction.
            tx.commit();

            // Closing connection.
            em.close();
            emf.close();
        } catch (Exception ex) {
            logger.error("Error getting customers from database. Error: " + ex.getMessage(), ex);
            throw ex;
        }

        return rowsUpdated;
    }

    @Override
    public State getState(String expId) throws Exception {
        State state = null;
        try {
            // Connection details loaded from persistence.xml to create EntityManagerFactory.
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-state");

            EntityManager em = emf.createEntityManager();

            // Creating a new transaction.
            EntityTransaction tx = em.getTransaction();

            tx.begin();

            Query query = em.createQuery("SELECT s FROM State s WHERE s.ID ='"+ expId+"'");
            state = (State) query.getSingleResult();

            // Committing transaction.
            tx.commit();

            // Closing connection.
            em.close();
            emf.close();
        } catch (Exception ex) {
            logger.error("Error getting customers from database. Error: " + ex.getMessage(), ex);
            throw ex;
        }

        return state;
    }

    @Override
    public ExperimentEntity getExperimentEntity(String experimentId) throws Exception {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            // Connection details loaded from persistence.xml to create EntityManagerFactory.
            emf = Persistence.createEntityManagerFactory("jpa-state");
            em = emf.createEntityManager();
            ExperimentEntity experimentEntity = em.find(ExperimentEntity.class, experimentId);
            return experimentEntity;
        } catch (Exception ex) {
            logger.error("Error getting ExperimentEntity from database. Error: " + ex.getMessage(), ex);
            throw ex;
        } finally {
            // Closing connection.
            if (emf != null && em!= null) {
                emf.close();
                em.close();
            }
        }
    }

    @Override
    public TaskStateEntity getTaskStateEntity(String taskId) throws Exception {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            // Connection details loaded from persistence.xml to create EntityManagerFactory.
            emf = Persistence.createEntityManagerFactory("jpa-state");
            em = emf.createEntityManager();
            TaskStateEntity taskStateEntity = em.find(TaskStateEntity.class, taskId);
            return taskStateEntity;
        } catch (Exception ex) {
            logger.error("Error getting TaskStateEntity from database. Error: " + ex.getMessage(), ex);
            throw ex;
        } finally {
            // Closing connection.
            if (emf != null && em!= null) {
                emf.close();
                em.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TaskStateEntity> getTaskListForExperiment(String experimentId) throws Exception {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            // Connection details loaded from persistence.xml to create EntityManagerFactory.
            emf = Persistence.createEntityManagerFactory("jpa-state");
            em = emf.createEntityManager();
            Query query = em.createQuery("SELECT t FROM TaskStateEntity t " +
                    "WHERE t.experiment.experimentId = '" + experimentId + "'");
            List<TaskStateEntity> taskStateEntities = query.getResultList();
            return taskStateEntities;
        } catch (Exception ex) {
            logger.error("Error getting TaskStateEntity from database. Error: " + ex.getMessage(), ex);
            throw ex;
        } finally {
            // Closing connection.
            if (emf != null && em!= null) {
                emf.close();
                em.close();
            }
        }
    }
}
