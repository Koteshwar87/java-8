package practice.streams.demo;

import java.util.*;
import java.util.stream.Collectors;

public class App {

    static List<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        EmployeeFactory employeeFactory = new EmployeeFactory();
        employeeList = employeeFactory.getAllEmployee();

        // 1. List all distinct project in non-ascending order.
        System.out.println("1. List all distinct project in non-ascending order.");
        List<Project> distinctProjects = employeeList.stream()
                .flatMap(e -> e.getProjects().stream())
                .distinct()
                .sorted(Comparator.comparing(Project::getName).reversed())
                .collect(Collectors.toList());
        distinctProjects.stream()
                .forEach(p -> System.out.println(p.getName()));


        // 2. Print full name of any employee whose firstName starts with ‘A’.
        System.out.println(" 3. Print full name of any employee whose firstName starts with ‘A’.");
        Employee startWithA = employeeList.stream()
                .filter(e -> e.getFirstName().startsWith("A"))
                .findAny()// fineFirst()
                .orElse(null);
        System.out.println(startWithA.getFirstName() + " " + startWithA.getLastName());

        // 3. List of all employee who joined in year 2023 (year to be extracted from employee id i.e., 1st 4 characters)
        System.out.println("3. List of all employee who joined in year 2023 (year to be extracted from employee id i.e., 1st 4 characters)");
        List<Employee> joined2023 = employeeList.stream()
                .filter(e -> e.getId().substring(0, 4).equals("2023")) // employee.getId().startsWith("2023")
                .collect(Collectors.toList());
        System.out.println("2023 joining = " + joined2023);


        // 4. Sort employees based on firstName, for same firstName sort by salary.
        System.out.println("4. Sort employees based on firstName, for same firstName sort by salary.");
        List<Employee> sortedEmployees = employeeList.stream()
                .sorted((e1, e2) -> {
                    if (e1.getFirstName().equals(e2.getFirstName())) {
                        return e1.getSalary() - e2.getSalary();
                    }
                    return e1.getFirstName().compareTo(e2.getFirstName());
                }).collect(Collectors.toList());
        sortedEmployees.stream()
                .forEach(e -> System.out.println(e.getFirstName() + " " + e.getLastName()));


        // 5. Print names of all employee with 3rd highest salary. (generalise it for nth highest salary).
        System.out.println("5. Print names of all employee with 3rd highest salary. (generalise it for nth highest salary).");
        Employee heighest3 = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .skip(3)
                .findFirst()
                .orElse(null);
        System.out.println(heighest3.getFirstName() + " " + heighest3.getLastName());


        // 6. Print min salary.
        System.out.println("6. Print min salary.");
        Employee minSalary = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .findFirst()
                .orElse(null);
        System.out.println("min salary = " + minSalary.getSalary());
        // Other better way
        Integer minSalary2 = employeeList.stream()
                .map(Employee::getSalary)
                .min(Integer::compare)// compareTo also correct
                .orElse(null);
        System.out.println("min salary = " + minSalary2);


        // 7. Print list of all employee with min salary.
        System.out.println("7. Print list of all employee with min salary.");
        Integer minSal = employeeList.stream()
                .map(e -> e.getSalary())
                .min(Integer::compare)
                .orElse(null);
        List<Employee> minSalEmp = employeeList.stream()
                .filter(e -> e.getSalary() == minSal)
                .collect(Collectors.toList());
        minSalEmp.stream()
                .forEach(e -> System.out.println(e.getFirstName() + " " + e.getLastName()));


        // 8. List of people working on more than 2 projects.
        System.out.println("8. List of people working on more than 2 projects.");
        List<Employee> moreThan2 = employeeList.stream()
                .filter(e -> e.getProjects().size() > 2)
                .collect(Collectors.toList());
        moreThan2.stream()
                        .forEach(e -> System.out.println(e.getFirstName() + " " + e.getLastName()));


        // 9. Count of total laptops assigned to the employees.
        System.out.println("9. Count of total laptops assigned to the employees.");
        int sumLaptops = employeeList.stream()
                .map(Employee::getTotalLaptopsAssigned)
                .mapToInt(n -> n) // map is redundant directly use .mapToInt(Employee::getTotalLaptopsAssigned)
                .sum();
        System.out.println("laptops total = " + sumLaptops);


        // 10. Count of all projects with Robert Downey Jr as PM.
        System.out.println("10. Count of all projects with Robert Downey Jr as PM.");
        long robertProjects = employeeList.stream()
                .flatMap(e -> e.getProjects().stream())
                .filter(p -> p.getProjectManager().equals("Robert Downey Jr"))
                .distinct()
                .count();
        System.out.println("Robert projects = " + robertProjects);


        // 11. List of all projects with Robert Downey Jr as PM.
        System.out.println("11. List of all projects with Robert Downey Jr as PM.");
        List<Project> robertDowneyJrProjects = employeeList.stream()
                .flatMap(e -> e.getProjects().stream())
                .distinct()
                .filter(p -> p.getProjectManager().equals("Robert Downey Jr"))
                .collect(Collectors.toList());
        robertDowneyJrProjects.stream()
                        .forEach(p -> System.out.println(p.getName()));


        // 12. List of all people working with Robert Downey Jr.
        System.out.println("12. List of all people working with Robert Downey Jr.");
        List<Employee> robertDowneyJrTeam = employeeList.stream()
                .filter(e -> e.getProjects().stream()
                        .anyMatch(p -> p.getProjectManager().equals("Robert Downey Jr")))
                .collect(Collectors.toList());
        robertDowneyJrTeam.stream()
                .forEach(e -> System.out.println(e.getFirstName() + " " + e.getLastName()));


        //13. Create a map based on this data, they key should be the year of joining, and value should be list of all the employees who joined the particular year.
        System.out.println("13. Create a map based on this data, they key should be the year of joining, and value should be list of all the employees who joined the particular year.");
        Map<Integer, List<Employee>> groupingEmps = employeeList.stream()
                .collect(Collectors.groupingBy(employee -> Integer.parseInt(employee.getId().substring(0, 4))));

        groupingEmps.forEach((integer, employees) -> {
            System.out.println(integer + " ");
            employees.stream()
                    .forEach(employee -> System.out.println(employee.getFirstName() + " " + employee.getLastName()));
        });


        // 14. Create a map based on this data, the key should be year of joining and value should be the count of people joined in that particular year.
        System.out.println("14. Create a map based on this data, the key should be year of joining and value should be the count of people joined in that particular year.");
        Map<Integer, Long> groupingCount = employeeList.stream()
                .collect(Collectors.groupingBy(employee -> Integer.parseInt(employee.getId().substring(0, 4)),
                        Collectors.counting()));
        groupingCount.forEach((integer, aLong) -> {
            System.out.println(integer + " " + aLong);
        });
    }
}