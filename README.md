♻️ Waste Scheduling Management System
A robust, Java-based desktop application designed to streamline waste collection operations. This system provides administrative control over scheduling, employee management, customer requests, and system reporting through an intuitive Graphical User Interface (GUI).

🚀 Features
Based on the core administrative modules, the system offers the following capabilities:

Secure Authentication: Dedicated admin login portal with credential verification.

Employee Management: Complete control to onboard (add) and offboard (delete) waste collection staff.

Schedule Tracking: View and manage active waste collection routes and timetables.

Customer & Request Handling: Access customer details and monitor incoming waste disposal requests.

Real-time Status Monitoring: Track the ongoing status of active collections and pending requests.

Reporting: Generate and view comprehensive system reports for operational oversight.

Polished UI: Custom-styled interactive buttons with responsive mouse-hover effects for a better user experience.

🛠️ Technology Stack
Language: Java

GUI Framework: Java Swing (javax.swing, java.awt)

Architecture: Object-Oriented Event-Driven Architecture

📊 System Architecture
The following flowchart illustrates the administrative workflow and navigation within the application:

Code snippet
graph TD
    A[Admin Login Portal] -->|Invalid Credentials| A
    A -->|Authentication Success| B{Admin Dashboard}
    
    B --> C[👥 Employee Management]
    C --> C1(Add Employee)
    C --> C2(Delete Employee)
    
    B --> D[📅 Schedule Management]
    D --> D1(View Schedule Table)
    
    B --> E[🧑‍🤝‍🧑 Customer Operations]
    E --> E1(View Customers)
    E --> E2(View Requests)
    
    B --> F[📈 Monitoring & Analytics]
    F --> F1(Check Status)
    F --> F2(View Reports)
    
    B --> G[Logout / Dispose Frame]
🗄️ Entity-Relationship Diagram (ERD)
Based on the system's modules, here is the inferred database architecture required to support the application:

Code snippet
erDiagram
    ADMIN {
        int admin_id PK
        string username
        string password
    }
    EMPLOYEE {
        int emp_id PK
        string name
        string contact_info
        string assigned_route
    }
    CUSTOMER {
        int customer_id PK
        string name
        string address
        string contact_info
    }
    SCHEDULE {
        int schedule_id PK
        date collection_date
        string area_zone
        int emp_id FK
    }
    REQUEST {
        int request_id PK
        int customer_id FK
        string waste_type
        date request_date
    }
    STATUS {
        int status_id PK
        int request_id FK
        string current_state
    }
    REPORT {
        int report_id PK
        date generated_date
        string metrics_summary
    }

    ADMIN ||--o{ EMPLOYEE : manages
    ADMIN ||--o{ SCHEDULE : oversees
    ADMIN ||--o{ REPORT : generates
    EMPLOYEE ||--o{ SCHEDULE : assigned_to
    CUSTOMER ||--o{ REQUEST : submits
    REQUEST ||--|| STATUS : tracks
💻 Installation & Setup
Prerequisites: Ensure you have the Java Development Kit (JDK) 8 or higher installed on your machine.

Clone the Repository:

Bash
git clone https://github.com/yourusername/waste-scheduling-system.git
Compile the Code:
Navigate to the root directory of the project and compile the Java files.

Bash
javac waste_scheduling_system/*.java
Run the Application:
Execute the main Admin class to launch the login portal.

Bash
java waste_scheduling_system.Admin
📂 Project Structure (Admin Scope)
The administrative functions are handled via anonymous inner classes bound to UI action listeners:

Admin$1: Validates user credentials and handles login logic.

Admin$2: Renders the schedule_table.

Admin$3: Fetches and displays report_details.

Admin$4: Loads customer_details for administrative review.

Admin$5: Polls and displays status_details.

Admin$6: Handles incoming request_details.

Admin$7 & Admin$8: Triggers the Employee creation and deletion logic.

Admin$10: UI handler for custom button styling and dynamic MouseAdapter hover effects.
