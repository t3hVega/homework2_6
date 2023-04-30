package com.homework.homework;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    public Employee (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)  return true;
        if (o == null || getClass() != o.getClass())    return false;
        Employee e = (Employee) o;
        return (Objects.equals(firstName, e.firstName) & Objects.equals(lastName, e.lastName));
    }
    @Override
    public int hashCode() {
        int i = firstName != null ? firstName.hashCode() : 0;
        int j = lastName != null ? lastName.hashCode() : 0;
        return i + j;
    }
    public String toString() {
        return "Имя - " + firstName + "\n" +
                "Фамилия - " + lastName;
    }
}

