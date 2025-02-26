package com.practice.streams.fromchatgpt;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demonstration {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 30, "HR", 7000),
                new Employee("Bob", 45, "Engineering", 12000),
                new Employee("Charlie", 28, "Engineering", 10000),
                new Employee("David", 35, "HR", 8000),
                new Employee("Eve", 40, "Finance", 11000),
                new Employee("Frank", 50, "Finance", 13000),
                new Employee("Grace", 29, "Engineering", 9500)
        );

//        Using Java 8 Streams, group employees by their department but only include employees with salaries greater
//        than 10,000 in the groups. Return the result as a Map<String, List<Employee>>.
        Map<String, List<Employee>> collect = employees.stream()
                .filter(employee -> employee.getSalary() > 10000)
                .collect(Collectors.groupingBy(Employee::getDepartment));
        collect.entrySet()
                .stream()
                .forEach(emp -> System.out.println(emp.getKey()));






    }
}


class Employee {
    String name;
    int age;
    String department;
    double salary;

    public Employee(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }
}


