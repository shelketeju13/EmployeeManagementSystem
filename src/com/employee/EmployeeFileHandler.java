package com.employee;

import java.io.*;
import java.util.ArrayList;

public class EmployeeFileHandler {

    private static final String FILE_NAME = "data/employees.dat";

    public static void saveToFile(ArrayList<Employee> employees) {
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(employees);
            System.out.println("📁 Employee data saved to data/employees.dat");
        } catch (IOException e) {
            System.out.println("❌ Error saving file: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Employee> loadFromFile() {
        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (ArrayList<Employee>) in.readObject();
        } catch (Exception e) {
            System.out.println("⚠ No employee data file found.");
            return new ArrayList<>();
        }
    }
}
