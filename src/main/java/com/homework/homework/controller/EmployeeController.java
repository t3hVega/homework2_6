package com.homework.homework.controller;

import com.homework.homework.exceptions.EmployeeAlreadyAddedException;
import com.homework.homework.exceptions.EmployeeNotFoundException;
import com.homework.homework.exceptions.EmployeeStorageIsFullException;
import com.homework.homework.model.Employee;
import com.homework.homework.service.EmployeeService;
import com.homework.homework.service.impl.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/add")
    public Employee add(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName
    ) {
        return employeeService.addEmployee(firstName, lastName);
    }
    @GetMapping("/remove")
    public Employee remove(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName
    ) {
        return employeeService.removeEmployee(firstName, lastName);
    }
    @GetMapping("/find")
    public Employee find(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName
    ) {
        return employeeService.findEmployee(firstName, lastName);
    }
    @GetMapping("/list")
    public List<Employee> list() {
        return employeeService.employees;
    }
}
