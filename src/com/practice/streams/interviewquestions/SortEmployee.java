package com.practice.streams.interviewquestions;

import java.util.*;
import java.util.stream.Collectors;

public class SortEmployee {
    public static void main(String[] args) {
        List<Employee> employees = getEmployeeList(); // get the list of employees

        // Sort by Salary in Ascending order
        List<Employee> salarySort = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());

        //Sort by name
        List<Employee> nameSorted = employees.stream()
                .sorted(Comparator.comparing(Employee::getName).reversed())
                .collect(Collectors.toList());

        //Find the highest salary of an Employee from HR department
        Optional<Employee> hrMaxSalary = employees.stream()
                .filter(emp -> emp.getDepartment().equals("HR"))
                .sorted(Comparator.comparing(Employee::getSalary))
                .findFirst();

        // Find the highest salary value
        Integer maxHrSalary = employees.stream()
                .filter(employee -> employee.getDepartment().equals("HR"))
                .map(employee -> employee.getSalary())
                .max(Integer::compare)
                .get();
//        System.out.println("max salary = " + maxHrSalary);

        // Find all employees who live in ‘Pune’ city, sort them by their name, and print the names of employees.
        List<String> puneEmps = employees.stream()
                .filter(employee -> employee.getCity().equals("Pune"))
                .sorted(Comparator.comparing(Employee::getName))
                .map(employee -> employee.getName())
                .collect(Collectors.toList());
//        System.out.println("pune emps = " + puneEmps);

        // find an average of even numbers using java using stream java 8?
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        OptionalDouble average = Arrays.stream(numbers)
                .filter(value -> value % 2 == 0)
                .average();

        // Find the occurrence of names of employees from the List<Employee>, and find the frequency of each name.
        Map<String, Long> collect = employees.stream()
                .collect(Collectors.groupingBy((employee -> employee.getName()), Collectors.counting()));

    }

    public static List<Employee> getEmployeeList() {
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(1, "Alice", 60000, "HR", "Mumbai"));
        employeeList.add(new Employee(2, "Kotesh", 70000, "IT", "Bangalore"));
        employeeList.add(new Employee(3, "Charlie", 55000, "Finance", "Delhi"));
        employeeList.add(new Employee(4, "Archish", 80000, "Marketing", "Chennai"));
        employeeList.add(new Employee(5, "Eva", 50000, "IT", "Hyderabad"));
        employeeList.add(new Employee(6, "Kotesh", 75000, "Finance", "Kolkata"));
        employeeList.add(new Employee(7, "Archish", 90000, "HR", "Pune"));
        employeeList.add(new Employee(8, "Harry", 65000, "Marketing", "Ahmedabad"));
        employeeList.add(new Employee(9, "Kotesh", 70000, "IT", "Jaipur"));
        employeeList.add(new Employee(10, "Jack", 85000, "Finance", "Pune"));


        return employeeList;
    }
}

class Employee {
    private int id;
    private String name;
    private int salary;
    private String department;
    private String city;

    public Employee(int id, String name, int salary, String department, String city) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", city=" + city +
                '}';
    }
}
