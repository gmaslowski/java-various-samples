package com.gmaslowski.sample.rest;

import com.gmaslowski.sample.entity.Employee;
import com.gmaslowski.sample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class EmployeeRest {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee", method = GET)
    public List<Employee> home() {
        return employeeService.listEmployees();
    }

    @RequestMapping(value = "/employee", method = POST)
    public Employee add() {
        return employeeService.addEmployee();
    }
}
