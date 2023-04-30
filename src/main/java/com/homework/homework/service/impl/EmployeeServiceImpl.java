package com.homework.homework.service.impl;

import com.homework.homework.exceptions.EmployeeAlreadyAddedException;
import com.homework.homework.exceptions.EmployeeNotFoundException;
import com.homework.homework.exceptions.EmployeeStorageIsFullException;
import com.homework.homework.model.Employee;
import com.homework.homework.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    int arraySize = 3;
    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee e = new Employee(firstName, lastName);
        if(employees.size() == arraySize) throw new EmployeeStorageIsFullException();
        if(employees.contains(e) == false) {
            employees.add(e);
            return e;
        } else throw new EmployeeAlreadyAddedException();
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee e = new Employee(firstName, lastName);
        if(employees.contains(e) == false) {
            throw new EmployeeNotFoundException();
        } else employees.remove(e);
        return e;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee e = new Employee(firstName, lastName);
        if(employees.contains(e) == true) {
            return e;
        }
        throw new EmployeeNotFoundException();
    }
}
