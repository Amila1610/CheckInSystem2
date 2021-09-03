
package com.checkinsystem.Passenger.dao;

import com.checkinsystem.Common.Dao.JpaDao;
import com.checkinsystem.Passenger.Passenger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class PassengerJpaDao implements JpaDao<Passenger>{
    
    private EntityManager entityManager=ENTITY_MANAGER_FACTORY.createEntityManager();

    @Override
    public EntityManager entityManager() {
    return entityManager;
    }

    @Override
    public Passenger get(long id) {
    
        return entityManager.find(Passenger.class,id);
        }

    @Override
    public List<Passenger> getAll() {
    
    Query query= entityManager.createNamedQuery("Passenger.findAll");
    return query.getResultList();
    }

    @Override
    public void save(Passenger passenger) {
    
        executeInsideTransaction(em ->em.persist(passenger));
    }

    @Override
    public void update(Passenger passenger) {
    
        executeInsideTransaction(em ->em.merge(passenger));
    }

    @Override
    public void delete(Passenger passenger) {
    
        executeInsideTransaction(em ->em.remove(passenger));
    }
    
}
