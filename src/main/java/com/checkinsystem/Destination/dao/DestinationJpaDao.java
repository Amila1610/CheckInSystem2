package com.checkinsystem.Destination.dao;

import com.checkinsystem.Common.Dao.JpaDao;
import com.checkinsystem.Destination.Destination;
import com.checkinsystem.Employee.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

public class DestinationJpaDao implements JpaDao<Destination> {

    private EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

    @Override
    public EntityManager entityManager() {
        return entityManager;
    }

    @Override
    public Destination get(long id) {
        return entityManager.find(Destination.class, id);
    }

    @Override
    public List<Destination> getAll() {
        Query query = entityManager.createNamedQuery("Destination.findAll");
        return query.getResultList();
    }

    @Override
    public void save(Destination destination) {
        executeInsideTransaction(em -> em.persist(destination));
    }

    @Override
    public void update(Destination destination) {
        executeInsideTransaction(em -> em.merge(destination));
    }

    @Override
    public void delete(Destination destination) {
        executeInsideTransaction(em -> em.remove(em.contains(destination)?destination:em.merge(destination)));
    }

    public Destination findByDestination(String des) {
        if (des == null || des.isEmpty()) {
            return null;
        }

        Query query = entityManager.createNamedQuery("Destination.findByDestination");
        query.setParameter("destination", des);
        try {

            Destination destination = (Destination) query.getSingleResult();
            return destination;
        } catch (NoResultException exception) {
            System.err.format("Not exist destination '%s'%n", des);
            return null;
        } catch (NonUniqueResultException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }
}
