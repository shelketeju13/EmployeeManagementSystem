# EmployeeManagementSystem

---

## Project Overview

The Employee Management System allows users to manage employee records efficiently.
It supports adding, viewing, searching, updating, and deleting employees.
The system also generates salary and department-wise reports and stores
employee data persistently using file handling.

---

## Technologies Used

- Java
- OOP (Encapsulation, Abstraction)
- Collections Framework (ArrayList, HashMap)
- File Handling (Serialization)
- Exception Handling
- Console-based UI

---

## Features

- Add new employee
- View all employees in tabular format
- Search employees by:
  - ID
  - Name (partial & case-insensitive)
  - Department
- Update employee details
- Delete employee records
- Generate reports:
  - Salary statistics
  - Department-wise summary
- Save employee data to file
- Load employee data from file

---

## Project Structure

```text
EmployeeManagementSystem/
│
├── README.md
│
├── src/
│ └── com/
│ └── employee/
│ ├── Employee.java
│ ├── EmployeeFileHandler.java
│ ├── EmployeeReportGenerator.java
│ └── EmployeeManagementSystem.java
│
├── data/
│ └── employees.dat
│
├── docs/
│ ├── documentation.md
│ └── Data_Format.md
│ 
│
└── reports/
├── salary_report.txt
├── department_summary.txt
│   sample_output.txt
└── sample_data.txt
```

---

## Data Storage

Employee data is stored using **Java Object Serialization**.

- File Path:
data/employees.dat

- Created when **Save to File** option is selected
- Loaded using **Load from File**

---

## How to Run

1. Clone the repository
2. Open in any Java IDE
3. Ensure `data/` folder exists
4. Run `EmployeeManagementSystem.java`

---

## Data Storage & File Visibility (Important Note)

This project uses **Java Object Serialization** to store employee records.

### Data File Used
- File Name: `employees.dat`
- Location: `data/` folder
- Format: Binary `.dat` file

### Why `employees.dat` is Not Readable on GitHub
- `.dat` files store data in **binary format**
- GitHub can preview only **text-based files**
- Therefore, employee data will **not be visible** on GitHub

This is **expected behavior** and does not indicate missing or incorrect data.

### How Data is Stored
- Employee objects are stored using `ObjectOutputStream`
- Entire `ArrayList<Employee>` is saved at once
- File is created automatically when data is saved

### How Data is Loaded
- Data is read using `ObjectInputStream`
- Objects are restored into memory
- HashMap is rebuilt for fast searching

### How to View the Stored Data
1. Run `EmployeeManagementSystem.java`
2. Select the **Load/View Employees** option from the menu
3. Employee records will be displayed in the console

### Reason for Using `.dat` File
- Preserves complete object structure
- Faster read/write operations
- Prevents manual data tampering
- Standard practice for console-based Java applications

✔ This approach follows recommended Java file-handling standards.

---

## Conclusion

This project demonstrates effective use of Java collections, file handling,
and OOP principles to build a reliable Employee Management System.
It meets internship requirements and provides a scalable base for future
enhancements such as database integration or GUI development.

---

## Author

**Tejaswini Shelke**



