package com.checkinsystem.Privilege.dao;

import com.checkinsystem.Common.Dao.JpaDao;
import com.checkinsystem.Privilege.Privilege;
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
       /* Query query=entityManager().createNamedQuery("Privilege.findByName");
        return query.getResultList()*/
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
