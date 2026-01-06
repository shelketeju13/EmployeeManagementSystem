package com.employee;

import java.time.LocalDate;
import java.util.*;

public class EmployeeManagementSystem {

    private static ArrayList<Employee> employees = new ArrayList<>();
    private static HashMap<String, Employee> employeeMap = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        employees = EmployeeFileHandler.loadFromFile();
        for (Employee e : employees) {
            employeeMap.put(e.getId(), e);
        }

        int choice;
        do {
            System.out.println("\n=== EMPLOYEE MANAGEMENT SYSTEM ===");
            System.out.println("1. Add New Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Generate Reports");
            System.out.println("7. Save to File");
            System.out.println("8. Load from File");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> viewEmployees();
                case 3 -> searchEmployee();
                case 4 -> updateEmployee();
                case 5 -> deleteEmployee();
                case 6 -> generateReports();
                case 7 -> EmployeeFileHandler.saveToFile(employees);
                case 8 -> reloadFromFile();
                case 9 -> System.out.println("👋 Exiting system...");
                default -> System.out.println("❌ Invalid choice!");
            }
        } while (choice != 9);
    }

    private static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine();

        if (employeeMap.containsKey(id)) {
            System.out.println("❌ Employee ID already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Department: ");
        String dept = sc.nextLine();
        System.out.print("Enter Position: ");
        String pos = sc.nextLine();
        System.out.print("Enter Salary: ");
        double sal = sc.nextDouble();
        sc.nextLine();

        Employee emp = new Employee(id, name, dept, pos, sal, LocalDate.now());
        employees.add(emp);
        employeeMap.put(id, emp);

        System.out.println("✅ Employee added successfully!");
    }

    private static void viewEmployees() {
    	System.out.println("ID       Name                 Department      Position             Salary        Join Date");
    	System.out.println("---------------------------------------------------------------------------------------------");
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    private static void searchEmployee() {
        System.out.println("1. Search by ID");
        System.out.println("2. Search by Name");
        System.out.println("3. Search by Department");
        int ch = sc.nextInt();
        sc.nextLine();

        if (ch == 1) {
            System.out.print("Enter ID: ");
            String id = sc.nextLine();
            Employee e = employeeMap.get(id);
            System.out.println(e != null ? e : "Not found");
        }
        
        else if (ch == 2) {
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            boolean found = false;

            for (Employee e : employees) {
                if (e.getName().toLowerCase().contains(name.toLowerCase())) {
                    System.out.println(e);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("❌ No employee found with given name.");
            }
        }

        else if (ch == 3) {
            System.out.print("Enter Department: ");
            String dept = sc.nextLine();
            employees.stream()
                    .filter(e -> e.getDepartment().equalsIgnoreCase(dept))
                    .forEach(System.out::println);
        }
    }

    private static void updateEmployee() {
        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine();
        Employee e = employeeMap.get(id);

        if (e == null) {
            System.out.println("Employee not found.");
            return;
        }

        System.out.print("New Name: ");
        e.setName(sc.nextLine());
        System.out.print("New Department: ");
        e.setDepartment(sc.nextLine());
        System.out.print("New Position: ");
        e.setPosition(sc.nextLine());
        System.out.print("New Salary: ");
        e.setSalary(sc.nextDouble());

        System.out.println("✅ Employee updated.");
    }

    private static void deleteEmployee() {
        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine();

        Employee e = employeeMap.remove(id);
        if (e != null) {
            employees.remove(e);
            System.out.println("🗑 Employee deleted.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void generateReports() {
        System.out.println("1. Department-wise Summary");
        System.out.println("2. Salary Statistics");
        int ch = sc.nextInt();

        if (ch == 1)
            EmployeeReportGenerator.departmentSummary(employees);
        else
            EmployeeReportGenerator.salaryStatistics(employees);
    }

    private static void reloadFromFile() {
        employees = EmployeeFileHandler.loadFromFile();
        employeeMap.clear();

        for (Employee e : employees) {
            employeeMap.put(e.getId(), e);
        }

        if (employees.isEmpty()) {
            System.out.println("⚠ No employee data found in file.");
        } else {
            System.out.println("✅ Employee data loaded successfully!");
        }
    }

}
