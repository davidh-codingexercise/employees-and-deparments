import java.util.*;
import java.util.stream.Collectors;

public class EmployeeAnalysis {

    public static void main(final String[] str) {

        final List<Employee> employees = Arrays.asList(
                // Employee(String name, Integer age, String gender, String departmentID)
                new Employee("John Doe", 21, "M", "ENG"),
                new Employee("Kimchy", 21, "M", "ENG"),
                new Employee("Sarah", 24, "F", "SALES"),
                new Employee("Bob Beck", 32, "F", "MKTNG"),
                new Employee("Jane", 33, "F", "ADMIN")
        );

        final List<Department> departments = Arrays.asList(
                // Department(String departmentID, String name, String location)
                new Department("ENG", "Engineering", "Atlanta"),
                new Department("MKTNG", "Marketing", "New York"),
                new Department("SALES", "Sales", "Orlando"),
                new Department("ADMIN", "Administration", "New York"),
                new Department("LGL", "Legal", "Palo Alto"),
                new Department("RSRCH", "Research", "Palo Alto")
        );

        // Print Employee names Sorted by Age

        System.out.println("\n\nEmployee names sorted by age:");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .forEach(System.out::println);

        // Print list of employees at each location

        final Map<String, List<Employee>> employeesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentID));

        final Map<String, List<Department>> departmentsByLocation = departments.stream()
                .collect(Collectors.groupingBy(Department::getLocation));

        System.out.println("\n\nEmployees at each location:");

        departmentsByLocation.keySet().forEach(location -> {
            System.out.println(location + ":");

            final List<Department> departmentsForLocation = departmentsByLocation.get(location);

            departmentsForLocation.stream()
                    .map(department -> employeesByDepartment.getOrDefault(department.departmentID, List.of()))
                    .flatMap(Collection::stream)
                    .forEach(employee -> System.out.println("\t" + employee));
        });

        // Print Departments without any employees

        System.out.println("\n\nDepartments without any employees:");

        departments.stream()
                .filter(department -> !employeesByDepartment.containsKey(department.getDepartmentID()))
                .forEach(System.out::println);
    }

}
