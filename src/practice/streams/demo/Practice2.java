package practice.streams.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Practice2 {
    static List<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        EmployeeFactory employeeFactory = new EmployeeFactory();
        employeeList = employeeFactory.getAllEmployee();

        //6. Min Salary
        Integer minSalary = employeeList.stream()
                .map(e -> e.getSalary())
//                .mapToInt(e -> e.getSalary())
//                        .min()
//                                .orElse(0);
                .min(Integer::compare)
                .orElse(null);


        System.out.println("min = " + minSalary);

        // 7. All employees with min salary
        List<Employee> minSalariedEmpl = employeeList.stream()
                .filter(e -> e.getSalary() == minSalary)
                .collect(Collectors.toList());

        // 8. List of people working on more than 2 projects.
        List<Employee> moreThan2 = employeeList.stream()
                .filter(e -> e.getProjects().size() > 2)
                .collect(Collectors.toList());

        // 9. Count of total laptops assigned to the employees.
        int totalLaptops = employeeList.stream()
                .mapToInt(e -> e.getTotalLaptopsAssigned())
                .sum();

        // 10. Count of all projects with Robert Downey Jr as PM.
        long manager = employeeList.stream()
                .flatMap(employee -> employee.getProjects().stream())
                .distinct()
                .filter(project -> project.getProjectManager().equals("Downey Jr"))
                .count();

        // 11. List of all projects with Robert Downey Jr as PM.
        List<Project> downeyJrProjects = employeeList.stream()
                .flatMap(employee -> employee.getProjects().stream())
                .distinct()
                .filter(project -> project.getProjectManager().equals("Downey Jr"))
                .collect(Collectors.toList());

        // 12. List of all people working with Robert Downey Jr.
        List<Employee> team = employeeList.stream()
                .filter(employee -> employee.getProjects().stream()
                        .anyMatch(project -> project.getProjectManager().equals("Robert Downey Jr"))
                ).collect(Collectors.toList());

        // 13. Create a map based on this data, the key should be the year of joining, and value should be list of all the employees who joined the particular year.
        Map<Integer, List<Employee>> collect = employeeList.stream()
                .collect(Collectors.groupingBy(employee -> Integer.parseInt(employee.getId().substring(0, 4))));

        // 14. Create a map based on this data, the key should be year of joining and value should be the count of people joined in that particular year.
        Map<Integer, Long> collect1 = employeeList.stream()
                .collect(Collectors.groupingBy(employee -> Integer.parseInt(employee.getId().substring(0, 4)), Collectors.counting()));

    }
}
