# 🗑️ Waste Collection Scheduling System

<div align="center">

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![Swing](https://img.shields.io/badge/Java%20Swing-GUI-blue?style=for-the-badge)
![NetBeans](https://img.shields.io/badge/NetBeans-IDE-1B6AC6?style=for-the-badge&logo=apache-netbeans-ide&logoColor=white)
![OOP](https://img.shields.io/badge/OOP-Project-green?style=for-the-badge)

**A Java-based desktop application for managing and scheduling municipal waste collection operations, built with Object-Oriented Programming principles.**

</div>

---

## 📋 Table of Contents

- [Overview](#-overview)
- [Features](#-features)
- [System Architecture](#-system-architecture)
- [Class Diagram](#-class-diagram)
- [System Flow](#-system-flow)
- [User Roles & Flows](#-user-roles--flows)
- [Database Schema](#-database-schema)
- [OOP Concepts Applied](#-oop-concepts-applied)
- [Project Structure](#-project-structure)
- [Requirements](#-requirements)
- [Setup & Installation](#-setup--installation)
- [Running the Application](#-running-the-application)
- [Screenshots Guide](#-screenshots-guide)
- [Known Issues & Limitations](#-known-issues--limitations)

---

## 🌐 Overview

The **Waste Collection Scheduling System** is a desktop application developed in Java using **Java Swing** for the GUI and **MySQL** as the backend database. It was built as an Object-Oriented Programming (OOP) project to simulate a real-world municipal waste management system.

The system supports **three distinct user roles** — Admin, Customer, and Employee — each with dedicated interfaces and permissions. Customers can register, log in, submit pickup requests, file reports, and check their collection status. Employees are assigned to specific locations and can view and action customer requests in their zone. Admins have full oversight: they manage employees, view all schedules, requests, reports, and collection statuses.

---

## ✨ Features

### 👤 Customer
| Feature | Description |
|---|---|
| Sign Up | Register with name, age, CNIC, address, phone number, and password |
| Sign In | Authenticate using username and password |
| Initiate Request | Submit a pickup request with preferred time, day, and instructions |
| View Schedule | View the waste collection schedule (time, shift, driver) |
| Submit Report | File a report with a title, description, and auto-generated report ID |
| Update Status | Update collection status (Yes/No) tied to their address |

### 🛠️ Admin
| Feature | Description |
|---|---|
| Secure Login | Hardcoded credential authentication (username: `admin`, password: `password`) |
| View Schedule | View the complete waste collection timetable |
| View Reports | See all customer-submitted reports |
| Customer Details | View complete customer registration data |
| Collection Status | View waste collection status per customer |
| View Requests | Review all submitted pickup requests |
| Add Employee | Register a new employee with name, username, password, and location |
| Delete Employee | Remove an employee from the system by ID |

### 👷 Employee
| Feature | Description |
|---|---|
| Login | Authenticate via username and password stored in the DB |
| View Requests | View customer requests filtered by the employee's assigned location |
| Accept Request | Mark a customer's request as "completed" |

---

## 🏗️ System Architecture

```
┌─────────────────────────────────────────────────────────────────┐
│                        PRESENTATION LAYER                        │
│                        (Java Swing GUI)                          │
│  ┌──────────┐      ┌──────────────┐      ┌─────────────────┐   │
│  │  Admin   │      │   Customer   │      │    Employee     │   │
│  │  Panel   │      │    Panel     │      │     Panel       │   │
│  └────┬─────┘      └──────┬───────┘      └────────┬────────┘   │
└───────┼────────────────────┼─────────────────────┼─────────────┘
        │                    │                       │
┌───────┼────────────────────┼─────────────────────┼─────────────┐
│       │              LOGIC LAYER                 │             │
│  ┌────▼────────────────────▼─────────────────────▼────────┐   │
│  │         Domain Classes: Admin, Customer, Employee,      │   │
│  │         Neighbour, Report, request, status,             │   │
│  │         Collection_Status, Schedule                     │   │
│  └────────────────────────┬────────────────────────────────┘   │
└───────────────────────────┼─────────────────────────────────────┘
                            │
┌───────────────────────────┼─────────────────────────────────────┐
│                    DATA ACCESS LAYER                             │
│              ┌────────────▼────────────┐                        │
│              │      Connection_DB       │                        │
│              │  (JDBC / MySQL Driver)   │                        │
│              └────────────┬────────────┘                        │
└───────────────────────────┼─────────────────────────────────────┘
                            │
┌───────────────────────────▼─────────────────────────────────────┐
│                       DATABASE LAYER                             │
│                    MySQL Database: waste                         │
│   Tables: register, employee, schedule, report,                  │
│           request, collection                                     │
└──────────────────────────────────────────────────────────────────┘
```

---

## 📐 Class Diagram

```
┌──────────────────────────────────────────────────────────────────────────┐
│                          CLASS DIAGRAM                                   │
└──────────────────────────────────────────────────────────────────────────┘

┌─────────────────────┐          ┌──────────────────────────────────────┐
│      Neighbour      │          │            Connection_DB              │
├─────────────────────┤          ├──────────────────────────────────────┤
│ - name: String      │          │ - user: String                       │
│ - age: int          │          │ - pass: String                       │
│ - cnic: String      │◄─────────│ - url: String                        │
│ - phonenumber:String│ uses     │ - con: Connection                    │
│ - address: String   │          │ - pst: PreparedStatement             │
│ - password: String  │          ├──────────────────────────────────────┤
├─────────────────────┤          │ + login(Customer): int               │
│ + getName(): String │          │ + employeelogin(Employee): String    │
│ + getAge(): int     │          │ + insertneighbour(Neighbour): void   │
│ + getCnic(): String │          │ + insertreport(Report): void         │
│ + getAddress():     │          │ + submitrequest(request): void       │
│ + getPassword():    │          │ + see_status(status): void           │
│ + getPhonenumber(): │          │ + insertemployee(Employee): void     │
└─────────────────────┘          │ + deleteEmployee(Employee): void     │
                                 │ + employee(String): DefaultTableModel│
                                 │ + check(String, String): boolean     │
                                 │ + closedconnection(): void           │
                                 └──────────────────────────────────────┘
                                              ▲
                    ┌─────────────────────────┼─────────────────────┐
                    │                         │                     │
        ┌───────────────────────┐  ┌──────────────────┐  ┌─────────────────────┐
        │        Customer       │  │      Employee    │  │        Admin        │
        ├───────────────────────┤  ├──────────────────┤  ├─────────────────────┤
        │ - name: String        │  │ - Emp_name:String│  │ (GUI only, no fields│
        │ - password: String    │  │ - Username:String│  │  – logic via        │
        │ - reportid: String    │  │ - Emp_password:  │  │  Connection_DB)     │
        │ - request_id: String  │  │ - Emp_id: int    │  └─────────────────────┘
        │ - username: String    │  │ - Emp_location:  │
        │ - address: String     │  ├──────────────────┤
        ├───────────────────────┤  │ + getEmp_name()  │
        │ + getName(): String   │  │ + getEmp_password│
        │ + getPassword():      │  │ + getEmp_location│
        │ + reportdetailsform() │  │ + AddEmployee()  │
        │ + initiate()          │  │ + delete()       │
        │ + show_status()       │  │ + status(String) │
        └───────────────────────┘  └──────────────────┘

┌─────────────────────┐   ┌────────────────────┐   ┌──────────────────────┐
│        Report       │   │       request       │   │        status        │
├─────────────────────┤   ├────────────────────┤   ├──────────────────────┤
│ - report_title      │   │ - request_time     │   │ - collection_status  │
│ - report_description│   │ - request_address  │   │ - customer_name      │
│ - report_id         │   │ - request_shift    │   │ - customer_address   │
│ - customername      │   │ - request_id       │   ├──────────────────────┤
├─────────────────────┤   │ - customer_name    │   │ + getCollection_     │
│ + getReport_title() │   │ - status           │   │   status()           │
│ + getReport_desc()  │   ├────────────────────┤   │ + getCustomer_name() │
│ + getReport_id()    │   │ + getRequest_time()│   │ + getCustomer_addr() │
│ + getCustomername() │   │ + getRequest_shift │   └──────────────────────┘
└─────────────────────┘   │ + getStatus()      │
                          └────────────────────┘

┌──────────────────────────┐   ┌──────────────────────────┐
│    Collection_Status     │   │         Schedule         │
├──────────────────────────┤   ├──────────────────────────┤
│ - scheduleID: String     │   │  (placeholder class –    │
│ - neighborhood: String   │   │   data fetched from DB   │
│ - date: String           │   │   table: schedule)       │
│ - time: String           │   └──────────────────────────┘
│ - collectionStatus: bool │
├──────────────────────────┤
│ + updateStatus(bool)     │
│ + displaySchedule()      │
└──────────────────────────┘
```

---

## 🔄 System Flow

```
                    ┌─────────────────────┐
                    │   Application Start  │
                    │  Waste_Scheduling_   │
                    │     System.main()    │
                    └──────────┬──────────┘
                               │
                    ┌──────────▼──────────┐
                    │      MainGUI        │
                    │  (Main Dashboard)   │
                    └──────┬──────┬───────┘
                           │      │      │
             ┌─────────────┘      │      └──────────────┐
             │                    │                      │
    ┌────────▼──────┐    ┌────────▼──────┐    ┌────────▼──────┐
    │    ADMIN      │    │   CUSTOMER    │    │   EMPLOYEE    │
    │  Login Form   │    │  Sign In /    │    │  Login Form   │
    │               │    │  Sign Up      │    │               │
    └───────┬───────┘    └──────┬────────┘    └───────┬───────┘
            │                   │                      │
    ┌───────▼───────┐   ┌───────▼───────┐     ┌───────▼───────┐
    │ Credential    │   │  DB Auth /    │     │  DB Auth via  │
    │ Check         │   │  Registration │     │  employee     │
    │ admin/password│   │  (register    │     │  table        │
    └───────┬───────┘   │   table)      │     └───────┬───────┘
            │           └───────┬───────┘             │
    ┌───────▼──────────┐        │             ┌───────▼───────┐
    │   Admin Panel    │ ┌──────▼──────────┐  │ Employee Panel│
    │  ┌─────────────┐ │ │ Customer Menu   │  │  View Requests│
    │  │View Schedule│ │ │ ┌─────────────┐ │  │  (filtered by │
    │  │View Reports │ │ │ │Init Request │ │  │   location)   │
    │  │Cust Details │ │ │ │View Schedule│ │  └───────┬───────┘
    │  │Coll. Status │ │ │ │Submit Report│ │          │
    │  │View Requests│ │ │ │Update Status│ │  ┌───────▼───────┐
    │  │Add Employee │ │ │ └─────────────┘ │  │ Accept/Reject │
    │  │Delete Emp.  │ │ └─────────────────┘  │   Request     │
    │  └─────────────┘ │                      │ (UPDATE DB)   │
    └──────────────────┘                      └───────────────┘
```

---

## 👥 User Roles & Flows

### 🔴 Admin Flow

```
Admin Clicks "Admin" on MainGUI
         │
         ▼
  Admin Login Form
  [Username: admin]
  [Password: password]
         │
    ┌────▼────┐
    │ Valid?  │──── No ──▶ Show Error Dialog
    └────┬────┘
         │ Yes
         ▼
  Admin Dashboard
  ┌──────────────────────────────────────────┐
  │  [View Schedule]  →  schedule_table      │
  │  [View Reports]   →  viewreport          │
  │  [Customer Dets]  →  View_customer       │
  │  [Coll. Status]   →  see_status          │
  │  [View Requests]  →  view_requests       │
  │  [Add Employee]   →  Employee.AddEmployee│
  │  [Delete Employee]→  Employee.delete()   │
  │  [Logout]         →  Dispose frame       │
  └──────────────────────────────────────────┘
```

### 🟢 Customer Flow

```
Customer Clicks "Customer" on MainGUI
         │
         ▼
  ┌──────────────┐
  │  Sign In     │──────────────────────────────────┐
  │  Sign Up     │                                  │
  └──────┬───────┘                                  │
         │ Sign Up                                  │ Sign In
         ▼                                          ▼
  Registration Form                        Login Form (username + password)
  [Name, Age, CNIC,                                 │
   Address, Password,                    ┌──────────▼──────────┐
   Phone Number]                         │  DB: SELECT from    │
         │                               │  register table     │
         ▼                               └──────────┬──────────┘
  INSERT into register                              │
  → Redirect to Sign In                  ┌──────────▼──────────┐
                                         │    Customer Menu    │
                                         └──────────┬──────────┘
                              ┌───────────┬──────────┼──────────────┐
                              │           │          │              │
                     ┌────────▼──┐ ┌──────▼───┐ ┌───▼────┐ ┌──────▼──────┐
                     │ Initiate  │ │  Update  │ │ Report │ │    View     │
                     │  Request  │ │   Info   │ │        │ │  Schedule   │
                     │           │ │ (Status) │ │        │ │             │
                     └─────┬─────┘ └────┬─────┘ └───┬────┘ └─────────────┘
                           │            │            │
                     SELECT time,  INSERT into  INSERT into
                     day, extras   collection   report table
                     INSERT into   table
                     request table
```

### 🟠 Employee Flow

```
Employee Clicks "Employee" on MainGUI
         │
         ▼
  Employee Login Form
  [Username] [Password]
         │
  DB: SELECT from employee
  WHERE Username=? AND Emp_password=?
         │
    ┌────▼────┐
    │ Valid?  │──── No ──▶ Frame closes
    └────┬────┘
         │ Yes
         ▼
  Employee Status Panel
  [View Request] button
         │
         ▼
  DB: Fetch Emp_location for logged-in user
         │
         ▼
  DB: SELECT from register WHERE address = Emp_location
  (Shows customers in employee's assigned area)
         │
         ▼
  Customer Table [Address | Name | Phone]
  [Get Selected Row] button
         │
  Confirm Dialog: "Accept Request?"
         │ Yes
         ▼
  UPDATE request SET status = 'completed'
  WHERE customer_name = selected_customer
```

---

## 🗄️ Database Schema

**Database Name:** `waste`

```sql
-- Customer / Neighbour Registration
CREATE TABLE register (
    name        VARCHAR(100),
    age         INT,
    cnic        VARCHAR(20),
    address     VARCHAR(200),
    password    VARCHAR(100),
    phonenumber VARCHAR(20)
);

-- Employee Table
CREATE TABLE employee (
    Emp_id       INT AUTO_INCREMENT PRIMARY KEY,
    Emp_name     VARCHAR(100),
    Username     VARCHAR(100),
    Emp_password VARCHAR(100),
    Emp_location VARCHAR(200)
);

-- Waste Collection Schedule
CREATE TABLE schedule (
    time        VARCHAR(50),
    shift       VARCHAR(100),
    driver_name VARCHAR(100)
);

-- Customer Reports
CREATE TABLE report (
    report_title   VARCHAR(200),
    rep_description TEXT,
    report_id      VARCHAR(20),
    customer_name  VARCHAR(100)
);

-- Pickup Requests
CREATE TABLE request (
    req_time               VARCHAR(50),
    Additional_information TEXT,
    day                    VARCHAR(50),
    request_id             VARCHAR(20),
    customer_name          VARCHAR(100),
    status                 VARCHAR(50)
);

-- Collection Status
CREATE TABLE collection (
    collection_status VARCHAR(10),
    customer_name     VARCHAR(100),
    customer_address  VARCHAR(200)
);
```

---

## 🧩 OOP Concepts Applied

| Concept | Where Applied |
|---|---|
| **Encapsulation** | All domain classes (`Neighbour`, `Employee`, `Report`, `request`, `status`, `Collection_Status`) use private fields with public getters/setters |
| **Abstraction** | `Connection_DB` abstracts all database operations — the GUI classes never write raw SQL; they call methods like `insertneighbour()`, `login()`, `submitrequest()` |
| **Constructor Overloading** | `Employee` has 4 constructors (default, (id), (name, pass), (name, username, pass, location)); `Customer` has 3 |
| **Anonymous Inner Classes** | All `ActionListener` and `MouseAdapter` implementations are anonymous inner classes inside GUI methods |
| **Static Methods** | Utility methods like `Admin.openAdminPerformFrame()`, `Customer.initiate()`, `Employee.AddEmployee()` are static for direct invocation without object creation |
| **Object Composition** | `Connection_DB` holds a `Neighbour` object as a field; it composes domain objects to perform DB operations |
| **Separation of Concerns** | GUI classes handle presentation; domain model classes hold data; `Connection_DB` handles persistence |

---

## 📁 Project Structure

```
Waste_Scheduling_System/
│
├── src/
│   └── waste_scheduling_system/
│       ├── Waste_Scheduling_System.java  ← Entry point (main method)
│       ├── MainGUI.java                  ← Main dashboard (3 role buttons)
│       │
│       ├── ── DOMAIN MODEL CLASSES ──
│       ├── Neighbour.java                ← Customer data model (name, age, CNIC, etc.)
│       ├── Employee.java                 ← Employee data model + GUI for login/add/delete
│       ├── Customer.java                 ← Customer GUI + logic (signup, login, request, report)
│       ├── Admin.java                    ← Admin GUI + login
│       ├── Report.java                   ← Report data model
│       ├── request.java                  ← Pickup request data model
│       ├── status.java                   ← Collection status data model
│       ├── Collection_Status.java        ← Schedule-based status entity
│       ├── Schedule.java                 ← Placeholder class
│       │
│       ├── ── DATABASE ACCESS ──
│       ├── Connection_DB.java            ← All JDBC DB operations (DAO layer)
│       │
│       ├── ── VIEW / GUI UTILITIES ──
│       ├── schedule_table.java           ← Displays schedule from DB
│       ├── viewreport.java               ← Displays reports from DB
│       ├── view_requests.java            ← Displays all requests from DB
│       ├── see_status.java               ← Displays collection statuses from DB
│       ├── View_customer.java            ← Displays all customer records
│       ├── View_Employee.java            ← Displays all employee records
│       ├── view_neighbour.java           ← Legacy neighbour viewer
│       ├── view_vehicle.java             ← Vehicle viewer (reads vehichle table)
│       └── gui.java                      ← Early prototype GUI (not in active use)
│
├── build/
│   └── classes/                          ← Compiled .class files
│
├── nbproject/                            ← NetBeans project config
├── build.xml                             ← Ant build script
└── manifest.mf
```

---

## 🔧 Requirements

### Software Requirements

| Requirement | Version |
|---|---|
| Java Development Kit (JDK) | 8 or higher |
| MySQL Server | 5.7 or higher |
| MySQL JDBC Driver (Connector/J) | 8.x recommended |
| NetBeans IDE *(recommended)* | 12+ |

### Hardware Requirements

| Component | Minimum |
|---|---|
| RAM | 512 MB |
| Storage | 100 MB |
| OS | Windows / Linux / macOS |

---

## ⚙️ Setup & Installation

### Step 1 — Install MySQL and Create the Database

```sql
-- Open MySQL command line or MySQL Workbench and run:

CREATE DATABASE waste;
USE waste;

CREATE TABLE register (
    name        VARCHAR(100),
    age         INT,
    cnic        VARCHAR(20),
    address     VARCHAR(200),
    password    VARCHAR(100),
    phonenumber VARCHAR(20)
);

CREATE TABLE employee (
    Emp_id       INT AUTO_INCREMENT PRIMARY KEY,
    Emp_name     VARCHAR(100),
    Username     VARCHAR(100),
    Emp_password VARCHAR(100),
    Emp_location VARCHAR(200)
);

CREATE TABLE schedule (
    time        VARCHAR(50),
    shift       VARCHAR(100),
    driver_name VARCHAR(100)
);

CREATE TABLE report (
    report_title    VARCHAR(200),
    rep_description TEXT,
    report_id       VARCHAR(20),
    customer_name   VARCHAR(100)
);

CREATE TABLE request (
    req_time               VARCHAR(50),
    Additional_information TEXT,
    day                    VARCHAR(50),
    request_id             VARCHAR(20),
    customer_name          VARCHAR(100),
    status                 VARCHAR(50)
);

CREATE TABLE collection (
    collection_status VARCHAR(10),
    customer_name     VARCHAR(100),
    customer_address  VARCHAR(200)
);

-- Optional: Seed schedule data
INSERT INTO schedule (time, shift, driver_name) VALUES
('8:00 AM',  'Morning', 'Ali Hassan'),
('12:00 PM', 'Noon',    'Usman Khan'),
('4:00 PM',  'Evening', 'Bilal Ahmed');
```

### Step 2 — Configure Database Credentials

Open `Connection_DB.java` and update the credentials to match your MySQL setup:

```java
String user = "root";           // your MySQL username
String pass = "your_password";  // your MySQL password
String url  = "jdbc:mysql://localhost:3306/waste";
```

> ⚠️ **Security Note:** The credentials are currently hardcoded in multiple places in `Connection_DB.java` and `Employee.java`. Before sharing or deploying this project, replace all hardcoded DB passwords with environment variables or a configuration file.

### Step 3 — Add MySQL JDBC Driver

1. Download **MySQL Connector/J** from [https://dev.mysql.com/downloads/connector/j/](https://dev.mysql.com/downloads/connector/j/)
2. In NetBeans: Right-click project → Properties → Libraries → Add JAR/Folder → Select the `.jar` file

### Step 4 — Fix the Background Image Path

In `MainGUI.java`, update the absolute image path to point to an image on your system (or remove it):

```java
// Replace this:
ImageIcon backgroundImg = new ImageIcon("C:\\Users\\lenovo L390\\OneDrive\\Desktop\\project.png");

// With a relative path or bundled resource:
ImageIcon backgroundImg = new ImageIcon(getClass().getResource("/images/project.png"));
```

---

## ▶️ Running the Application

### Via NetBeans IDE

1. Open NetBeans → File → Open Project → Select `Waste_Scheduling_System`
2. Right-click the project → Clean and Build
3. Press **F6** or click **Run Project**

### Via Command Line

```bash
# Compile
javac -cp .;mysql-connector-j-x.x.x.jar src/waste_scheduling_system/*.java -d build/classes

# Run
java -cp build/classes;mysql-connector-j-x.x.x.jar waste_scheduling_system.Waste_Scheduling_System
```

*(Use `:` instead of `;` on Linux/macOS)*

---

## 🖥️ Screenshots Guide

Once running, here's what each screen shows:

| Screen | Description |
|---|---|
| **Main Dashboard** | Three buttons: Admin, Customer, Employee |
| **Admin Login** | Username/password form (admin / password) |
| **Admin Panel** | 7 action buttons in green |
| **Customer Portal** | Sign In / Sign Up options |
| **Customer Signup** | Full registration form |
| **Customer Menu** | 4 options: Initiate Request, Update Info, Report, View Schedule |
| **Initiate Request** | Dropdown for time (6 slots) and day (Mon–Sat), text field for notes |
| **Submit Report** | Title, description text area, auto-generated report ID |
| **Employee Login** | Username and password authentication |
| **Employee Panel** | Single "View Request" button |
| **Request Table** | Customers in employee's zone with accept button |

---

## ⚠️ Known Issues & Limitations

| Issue | Description |
|---|---|
| **Hardcoded Credentials** | Admin username/password (`admin`/`password`) and DB credentials are hardcoded in source files |
| **Hardcoded Image Path** | Background image uses an absolute path (`C:\Users\lenovo L390\...`) which won't work on other machines |
| **No Password Hashing** | Passwords are stored and compared as plain text — not suitable for production |
| **No Input Validation** | CNIC format, phone number format, and most fields have no format validation |
| **DB Connection per Query** | Some methods open new DB connections per call rather than reusing the shared connection |
| **Unused Classes** | `Schedule.java`, `gui.java`, `view_neighbour.java`, and `view_vehicle.java` are either unused or legacy code |
| **No Session Management** | The logged-in username is stored as a static variable, which can cause issues if multiple windows are open |
| **Request ID Collision** | Report/request IDs are 4-digit random numbers — collisions are possible |

---

## 👨‍💻 Author
**Junaid Mehmood**

**Developed as an OOP Course Project**
Department of Computer Science 
© 2024 Waste Management System
