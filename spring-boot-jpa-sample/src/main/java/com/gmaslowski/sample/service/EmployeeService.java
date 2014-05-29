package com.gmaslowski.sample.service;

import com.gmaslowski.sample.entity.Employee;
import com.gmaslowski.sample.repo.JpaEmployeeRepository;
import com.gmaslowski.sample.repo.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private Employees employees;

    @Autowired
    private JpaEmployeeRepository jpaEmployeeRepository;

    public Employee addEmployee(Employee employee) {
        employees.save(employee);

        return employee;
    }

    public List<Employee> listEmployees() {
        return employees.listAll();
    }

    public Iterable<Employee> listEmployeesUsingJpaEmployeeRepository() {
        return jpaEmployeeRepository.findAll();
    }


}
