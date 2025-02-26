package com.practice.streams.fromchatgpt;

import java.util.*;
import java.util.stream.Collectors;

public class Demonstration2 {
    public static void main(String[] args) {
        List<Employee3> employees = Arrays.asList(
                new Employee3("Alice", 7000),
                new Employee3("Bob", 12000),
                new Employee3("Charlie", 10000),
                new Employee3("David", 8000),
                new Employee3("Eve", 11000),
                new Employee3("Frank", 13000)
        );
//        Find the second highest salary
        Optional<Double> salary = employees.stream()
                .sorted(Comparator.comparing(employee3 -> employee3.getSalary(), Comparator.reverseOrder()))
                .skip(1)
                .map(employee3 -> employee3.getSalary())
                .findFirst();
        // Optimized solution
        double secondHighestSalary = employees.stream()
                .sorted(Comparator.comparingDouble(Employee3::getSalary).reversed()) // Sort by salary in descending order
                .skip(1) // Skip the first (highest salary)
                .map(Employee3::getSalary) // Map to salary
                .findFirst() // Get the second highest salary
                .orElse(0.0); // Provide a default value in case the list is empty or has only one employee

        // -------------------------------------------------------
        List<String> names = Arrays.asList(
                "Alice",
                "Bob",
                "Christina",
                "David",
                "Eve",
                "Franklin",
                "George"
        );
//        Find the longest name in the list
        Optional<String> longest = names.stream()
                .sorted(Comparator.comparing(name -> name.length(), Collections.reverseOrder()))  // Avoid using this instead use Comparator.comparingDouble(Employee::getSalary).reversed()
                .findFirst();
        System.out.println(longest);

        // Optimized
        String s = names.stream()
                .max(Comparator.comparing(String::length))
                .orElse("");
        System.out.println(s);

        // -----------------------------------------------------------------------------------

//        Using Java 8 Streams, find the top 3 employees with the highest salaries. Return the result as a List<Employee>.

        List<Employee3> employees2 = Arrays.asList(
                new Employee3("Alice", 7000),
                new Employee3("Bob", 12000),
                new Employee3("Charlie", 10000),
                new Employee3("David", 8000),
                new Employee3("Eve", 11000),
                new Employee3("Frank", 13000),
                new Employee3("Grace", 9000)
        );
        List<Employee3> collect = employees2.stream()
                .sorted(Comparator.comparing(employee3 -> employee3.getSalary(), Collections.reverseOrder()))
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(collect);


        //    Partition employees based on salary threshold
        /*Using Java 8 Streams, partition the employees into two groups:

            Employees with a salary greater than or equal to 10,000.
            Employees with a salary less than 10,000.
            Return the result as a Map<Boolean, List<Employee>>, where:

                    true = Employees earning 10,000 or more.
                    false = Employees earning less than 10,000.*/

        List<Employee3> employees3 = Arrays.asList(
                new Employee3("Alice", 7000),
                new Employee3("Bob", 12000),
                new Employee3("Charlie", 10000),
                new Employee3("David", 8000),
                new Employee3("Eve", 11000),
                new Employee3("Frank", 13000),
                new Employee3("Grace", 9000)
        );
        Map<Boolean, List<Employee3>> collect1 = employees3.stream()
                .collect(Collectors.partitioningBy(employee3 -> employee3.getSalary() >= 10000));

//        Using Java 8 Streams, concatenate all the employee names into a single string, separated by a comma (,).

        String collect2 = employees3.stream()
                .map(employee3 -> employee3.getName())
                .collect(Collectors.joining(","));
        System.out.println("collect2 = " + collect2);


        /*Using Java 8 Streams, group employees into salary ranges:

        "LOW": Salary less than 10,000.
        "MEDIUM": Salary between 10,000 (inclusive) and 12,000 (exclusive).
                "HIGH": Salary 12,000 and above.*/
        List<Employee3> employees4 = Arrays.asList(
                new Employee3("Alice", 7000),
                new Employee3("Bob", 12000),
                new Employee3("Charlie", 10000),
                new Employee3("David", 8000),
                new Employee3("Eve", 11000),
                new Employee3("Frank", 13000),
                new Employee3("Grace", 9000)
        );
        Map<String, List<Employee3>> collect3 = employees4
                .stream()
                .collect(Collectors.groupingBy(emp -> {
                    if (emp.getSalary() < 10000) {
                        return "LOW";
                    } else if (emp.getSalary() >= 10000 || emp.getSalary() < 12000) {
                        return "MEDIUM";
                    } else {
                        return "HIGH";
                    }
                }));



    }
}

class Employee3 {
    String name;
    double salary;

    public Employee3(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', salary=" + salary + "}";
    }
}