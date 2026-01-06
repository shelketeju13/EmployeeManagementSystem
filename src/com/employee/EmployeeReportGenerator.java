package com.employee;

import java.util.*;

public class EmployeeReportGenerator {

    public static void salaryStatistics(ArrayList<Employee> list) {
        if (list.isEmpty()) {
            System.out.println("No employees available.");
            return;
        }

        double total = 0;
        Employee max = list.get(0);
        Employee min = list.get(0);

        for (Employee e : list) {
            total += e.getSalary();
            if (e.getSalary() > max.getSalary()) max = e;
            if (e.getSalary() < min.getSalary()) min = e;
        }

        System.out.println("\n💰 SALARY STATISTICS:");
        System.out.println("• Total Employees: " + list.size());
        System.out.printf("• Total Salary: ₹%.2f%n", total);
        System.out.printf("• Average Salary: ₹%.2f%n", total / list.size());
        System.out.printf("• Highest Salary: ₹%.2f (%s)%n",
                max.getSalary(), max.getName());
        System.out.printf("• Lowest Salary: ₹%.2f (%s)%n",
                min.getSalary(), min.getName());
    }

    public static void departmentSummary(ArrayList<Employee> list) {
        Map<String, List<Employee>> map = new HashMap<>();

        for (Employee e : list) {
            map.computeIfAbsent(e.getDepartment(), k -> new ArrayList<>()).add(e);
        }

        System.out.println("\n🏢 DEPARTMENT SUMMARY:");
        for (String dept : map.keySet()) {
            double sum = 0;
            for (Employee e : map.get(dept)) sum += e.getSalary();

            System.out.printf("• %s: %d employees, Average: ₹%.2f%n",
                    dept, map.get(dept).size(), sum / map.get(dept).size());
        }
    }
}
