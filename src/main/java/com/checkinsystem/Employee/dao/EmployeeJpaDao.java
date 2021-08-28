
package com.checkinsystem.Employee.dao;

import com.checkinsystem.Common.Dao.JpaDao;
import com.checkinsystem.Employee.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;


public class EmployeeJpaDao implements JpaDao<Employee>{
    
    private final EntityManager entityManager= ENTITY_MANAGER_FACTORY.createEntityManager();

    @Override
    public EntityManager entityManager() {
        return entityManager;
    }

    @Override
    public Employee get(long id) {
    return entityManager.find(Employee.class,id);
   
    }

    @Override
    public List<Employee> getAll() {
    Query query= entityManager.createNamedQuery("Employee.findAll");
    return query.getResultList();
    }

    @Override
    public void save(Employee employee) {
    executeInsideTransaction(em ->em.persist(employee));
    }

    @Override
    public void update(Employee employee) {
    executeInsideTransaction(em ->em.merge(employee));
    }

    @Override
    public void delete(Employee employee) {
    executeInsideTransaction(em ->em.remove(em.contains(employee)? employee:em.merge(employee)));
    }
    
    public Employee login(String username,String password){
        if(username==null||username.isEmpty()||password==null||password.isEmpty()){
            return null;
        }
        
    Query query= entityManager.createNamedQuery("Employee.findByUsernameAndPassword");
query.setParameter("username",username);
query.setParameter("password",password);
try{
    Employee employee=(Employee)query.getSingleResult();
    return employee;
}catch(NoResultException exception){
    System.err.format("Not exist user with username '%s'%n", username);
    return null;
}catch(NonUniqueResultException exception){
    throw new RuntimeException(exception.getMessage());
}
    }
    
    public Employee findByUsername(String username){
        if(username==null||username.isEmpty()){
            return null;
        }
        
        Query query=entityManager.createNamedQuery("Employee.findByUsername");
        query.setParameter("username",username);
        
        try{
            Employee employee=(Employee)query.getSingleResult();
    return employee;
}catch(NoResultException exception){
    System.err.format("Not exist user with username '%s'%n", username);
    return null;
}catch(NonUniqueResultException exception){
    throw new RuntimeException(exception.getMessage());
}
        }
    }
    

