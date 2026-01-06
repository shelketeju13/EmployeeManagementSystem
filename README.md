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
└── sample_output.txt
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

## Conclusion

This project demonstrates effective use of Java collections, file handling,
and OOP principles to build a reliable Employee Management System.
It meets internship requirements and provides a scalable base for future
enhancements such as database integration or GUI development.

---

## Author

**Tejaswini Shelke**



