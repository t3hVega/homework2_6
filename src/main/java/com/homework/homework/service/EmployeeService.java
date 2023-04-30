package com.homework.homework.service;

import com.homework.homework.model.Employee;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeService {
    List<Employee> employees = new ArrayList<>();
    Employee addEmployee(String firstName, String lastName);
    Employee removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
}
