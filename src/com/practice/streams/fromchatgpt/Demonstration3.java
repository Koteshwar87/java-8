package com.practice.streams.fromchatgpt;

public class Demonstration3 {

}
class Employee2 {
    String name;
    String department;
    double salary;

    public Employee2(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', department='" + department + "', salary=" + salary + "}";
    }
}