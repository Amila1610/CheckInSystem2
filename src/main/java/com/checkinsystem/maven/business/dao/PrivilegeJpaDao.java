package com.checkinsystem.maven.business.dao;

import com.checkinsystem.maven.business.entity.Privilege;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PrivilegeJpaDao implements JpaDao<Privilege> {

     private final EntityManager entityManager=ENTITY_MANAGER_FACTORY.createEntityManager();
     
    @Override
    public EntityManager entityManager() {
    return entityManager;
    }

    @Override
    public Privilege get(long id) {
    return entityManager().find(Privilege.class, id);
    }

    @Override
    public List<Privilege> getAll() {
    Query query= entityManager().createNamedQuery("Privilege.findAll");
    return query.getResultList();
    }

    @Override
    public void save(Privilege privilege) {
    executeInsideTransaction(em -> em.persist(privilege));
    }

    @Override
    public void update(Privilege privilege) {
    executeInsideTransaction(em -> em.merge(privilege));
    }

    @Override
    public void delete(Privilege privilege) {
    executeInsideTransaction(em -> em.remove(privilege));
    }
    
}
