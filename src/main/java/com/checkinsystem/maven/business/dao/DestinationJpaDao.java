package com.checkinsystem.maven.business.dao;

import com.checkinsystem.maven.business.entity.Destination;
import java.util.List;
import javax.persistence.EntityManager;

public class DestinationJpaDao implements JpaDao<Destination> {

    private EntityManager entityManager=ENTITY_MANAGER_FACTORY.createEntityManager();
    
    @Override
    public EntityManager entityManager() {
    return entityManager;
    }

    @Override
    public Destination get(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Destination> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Destination e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Destination e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Destination e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
