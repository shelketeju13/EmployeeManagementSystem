# Employee Management System – Data Format

---

## 1. Employee Attributes

Each employee record contains the following fields:

- **Employee ID** (String)  
  Unique identifier for each employee (e.g., E001, E002).

- **Name** (String)  
  Full name of the employee (e.g., Alice Johnson).

- **Department** (String)  
  Department in which the employee works (e.g., Engineering, HR, Marketing).

- **Position** (String)  
  Job title or position of the employee (e.g., Software Developer, Manager).

- **Salary** (double)  
  Employee’s salary in numeric format (e.g., 85000.0).

- **Join Date** (LocalDate)  
  Date when the employee joined the organization (e.g., 2024-01-15).

---

## 2. File Storage Format

- **File Name:** `employees.dat`  
- **Location:** `data/employees.dat`  
- **Format:** Binary serialized file  
- **Purpose:** Stores all employee objects in ArrayList format.  
- **Reason for Serialization:**  
  - Preserves object structure  
  - Fast read/write operations  
  - Prevents accidental data loss  

---

## 3. Data Handling Procedures

- **Saving Data:**  
  Employee records are saved to the file using the method `EmployeeFileHandler.saveToFile()`.  
  The entire ArrayList of employee objects is written to `employees.dat`.  
  The file is created automatically if it does not exist.

- **Loading Data:**  
  Employee records are loaded from the file using `EmployeeFileHandler.loadFromFile()`.  
  Employee objects are read into memory, and the HashMap is rebuilt for fast lookup.  

---

## 4. Sample Data Representation (for reference)

| Employee ID | Name           | Department   | Position           | Salary    | Join Date  |
|------------|----------------|-------------|------------------|----------|-----------|
| E001       | Alice Johnson  | Engineering | Software Developer| 85000.0  | 2024-01-15|
| E002       | Bob Wilson     | Marketing   | Manager           | 95000.0  | 2024-01-10|
| E003       | Carol Davis    | HR          | Specialist        | 75000.0  | 2024-01-05|

> ⚠ Note: The actual file (`employees.dat`) is stored in binary format and cannot be opened directly using a text editor.  
> Use the program’s load functionality to read employee data.

---

# Employee Data Format Specification

## Storage Method
- Java Object Serialization
- Binary `.dat` file

## File Path
data/employees.dat

## Stored Object
ArrayList<Employee>

## Employee Object Structure
- Employee ID : String
- Name : String
- Department : String
- Position : String
- Salary : double
- Join Date : LocalDate

## Notes
- File is system-generated
- Manual editing is not supported
- Data is accessed only through the application


