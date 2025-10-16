package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepo repo;
    public EmployeeService(EmployeeRepo repo) { this.repo = repo; }

    @Transactional(readOnly = true)
    public List<Employee> all() { return repo.findAll(); }

    @Transactional
    public Employee create(Employee e) { return repo.save(e); }
}
