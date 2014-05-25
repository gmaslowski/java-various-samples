package com.gmaslowski.sample.rest;

import com.gmaslowski.sample.entity.Employee;
import com.gmaslowski.sample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController("/employee")
public class EmployeeRest {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = GET)
    @ResponseBody
    public List<Employee> home() {
        return employeeService.listEmployees();
    }

    @RequestMapping(method = POST)
    @ResponseBody
    public Employee add() {
        return employeeService.addEmployee();
    }
}
