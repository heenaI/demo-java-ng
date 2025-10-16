package com.example.ee.control;

import com.example.ee.entity.Employee;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class EmployeeRepo {
    @PersistenceContext EntityManager em;
    public List<Employee> findAll(){ return em.createQuery("from Employee", Employee.class).getResultList(); }
    public Employee find(Long id){ return em.find(Employee.class, id); }
    public Employee create(Employee e){ em.persist(e); return e; }
    public Employee update(Employee e){ return em.merge(e); }
    public void delete(Long id){ var e = em.find(Employee.class, id); if(e!=null) em.remove(e); }
}
