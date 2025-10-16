package com.example.ee.control;

import com.example.ee.entity.Employee;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@Stateless
public class EmployeeService {
    @Inject EmployeeRepo repo;

    @Transactional
    public Employee create(Employee e){ return repo.create(e); }
    public List<Employee> all(){ return repo.findAll(); }
}
