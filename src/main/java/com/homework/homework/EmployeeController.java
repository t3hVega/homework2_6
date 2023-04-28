package com.homework.homework;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService = new EmployeeService();
    @GetMapping("/add")
    public String add(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName
    ) {

        try {
            employeeService.add(firstName, lastName);
            return "Сотрудник нанят";
        } catch (EmployeeStorageIsFullException employeeStorageIsFullException) {
            return "Штат заполнен";
        } catch (EmployeeAlreadyAddedException employeeAlreadyAddedException) {
            return "Сотрудник уже в штате";
        }
    }
    @GetMapping("/remove")
    public String remove(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName
    ) {
        try {
            employeeService.remove(firstName, lastName);
            return "Сотрудник уволен";
        } catch (EmployeeNotFoundException employeeNotFoundException) {
            return "Сотрудник не найден";
        }
    }
    @GetMapping("/find")
    public String find(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName
    ) {
        try {
            return employeeService.find(firstName, lastName);
        } catch (EmployeeNotFoundException employeeNotFoundException) {
            return "Сотрудник не найден";
        }
    }
    @GetMapping("/list")
    public String list() {
        String info = "";
        for (int i = 0; i < employeeService.employees.size(); i++) {
            info = info + employeeService.employees.get(i).toString() + "\n";
        }
        return info;
    }
}
