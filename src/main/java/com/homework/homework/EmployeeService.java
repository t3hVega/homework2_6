package com.homework.homework;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class EmployeeService {
    List<Employee> employees = new ArrayList<>();
    int arraySize = 3;
    public boolean locateBool(String firstName, String lastName) {
        Employee e = new Employee(firstName, lastName);
        boolean found = false;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).equals(e)) {
                found = true;
            }
        }
        return found;
    }
    public int locateInt(String firstName, String lastName) {
        Employee e = new Employee(firstName, lastName);
        int j = 0;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).equals(e)) {
                j = i;
            }
        }
        return j;
    }
    public void add(String firstName, String lastName) {
        if (employees.size() == arraySize) throw new EmployeeStorageIsFullException("Штат заполнен");
        if (locateBool(firstName, lastName) == false){
            Employee e = new Employee(firstName, lastName);
            employees.add(e);
        } else {
            throw new EmployeeAlreadyAddedException("Сотрудник уже в штате");
        }
    }
    public void remove(String firstName, String lastName) {
        if (locateBool(firstName, lastName) == true){
            Employee e = new Employee(firstName, lastName);
            employees.remove(e);
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }
    public String find(String firstName, String lastName) {
        if (locateBool(firstName, lastName) == true){
            return "Сотрудник №" + (locateInt(firstName, lastName) + 1) + "\n"
                    + employees.get(locateInt(firstName, lastName));
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }

}
