package waste_scheduling_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee {

    private String Emp_name;
    private String Emp_password;
    private String Username;
    private int Emp_id;
    private String Emp_location;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public int getEmp_id() {
        return Emp_id;
    }

    public Employee(int Emp_id) {
        this.Emp_id = Emp_id;
    }

    public Employee(String Emp_name, String Username, String Emp_password, String Emp_location) {
        this.Emp_name = Emp_name;
        this.Username = Username;
        this.Emp_password = Emp_password;
        this.Emp_location = Emp_location;
    }

    public void setEmp_id(int Emp_id) {
        this.Emp_id = Emp_id;
    }

    public String getEmp_location() {
        return Emp_location;
    }

    public void setEmp_location(String Emp_location) {
        this.Emp_location = Emp_location;
    }

    public Employee(String emp_name, String emp_password) {
        this.Emp_name = emp_name;
        this.Emp_password = emp_password;
    }

    public String getEmp_name() {
        return Emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.Emp_name = emp_name;
    }

    public String getEmp_password() {
        return Emp_password;
    }

    public void setEmp_password(String emp_password) {
        this.Emp_password = emp_password;
    }

    public Employee() {
        
        JFrame employeeframe = new JFrame("Employee Login");
        employeeframe.setSize(500, 400);
        employeeframe.setLayout(null);
        employeeframe.getContentPane().setBackground(new Color(240, 240, 240));

        JLabel titleLabel = new JLabel("Enter your details", JLabel.CENTER);
        titleLabel.setBounds(100, 30, 300, 40);
        titleLabel.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(new Color(0, 102, 204));
        employeeframe.add(titleLabel);

        JLabel usernameLabel = new JLabel("Enter Username:");
        usernameLabel.setBounds(50, 100, 150, 30);
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        usernameLabel.setForeground(Color.black);
        employeeframe.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(170, 100, 200, 30);
        usernameField.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 2));
        employeeframe.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordLabel.setForeground(Color.black);
        employeeframe.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(170, 150, 200, 30);
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 2));
        employeeframe.add(passwordField);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(200, 220, 100, 40);
        submitButton.setBackground(new Color(0, 102, 204));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        employeeframe.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = usernameField.getText();
                String pass = passwordField.getText();
                if (user.isEmpty() || pass.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter both username and password.", "Input Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                Employee emp = new Employee(user, pass);
                Connection_DB con = new Connection_DB();
                String userName = con.employeelogin(emp);
                if (!(userName.equals("no"))) {
                    Employee.status(userName);
                }
                employeeframe.dispose();
            }
        });
        employeeframe.setVisible(true);
    }

    public static void status(String userName) {
        JFrame status = new JFrame("Status");
        status.setSize(500, 400);
        status.setLayout(null);
        status.getContentPane().setBackground(new Color(240, 240, 240));

        JButton viewRequest = new JButton("View Request");
        viewRequest.setBounds(150, 150, 200, 60);
        viewRequest.setBackground(new Color(0, 102, 204));
        viewRequest.setForeground(Color.WHITE);
        viewRequest.setFont(new Font("Arial", Font.BOLD, 16));
        viewRequest.setFocusPainted(false);
        viewRequest.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204)));
        viewRequest.setCursor(new Cursor(Cursor.HAND_CURSOR));

        viewRequest.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewRequest.setBackground(new Color(51, 153, 255));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewRequest.setBackground(new Color(0, 102, 204));
            }
        });
        viewRequest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection_DB co = new Connection_DB();
                String location = null;
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/waste", "root", "$Nikal146027");
                    String query = "Select * from employee where Username=?";
                    PreparedStatement pst = con.prepareStatement(query);
                    pst.setString(1, userName);
                    ResultSet rs = pst.executeQuery();
                    if (rs.next()) {
                        location = rs.getString("Emp_location");
                    }
                    co.employee(location);

                } catch (SQLException sql) {
                    JOptionPane.showMessageDialog(null, "Error getting data." + sql.getMessage());
                }
            }
        });
        status.add(viewRequest);
        status.setDefaultCloseOperation(2);
        status.setLocationRelativeTo(null);
        status.setVisible(true);
    }

    public static void AddEmployee(){

        JFrame frame = new JFrame("Add Employee");
        frame.setDefaultCloseOperation(2);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        frame.getContentPane().setBackground(new Color(240, 248, 255));

        Font labelFont = new Font("Arial", Font.BOLD, 14);

        JLabel lblEmpId = new JLabel("Employee ID:");
        lblEmpId.setBounds(50, 30, 120, 25);
        lblEmpId.setFont(labelFont);
        lblEmpId.setForeground(new Color(70, 130, 180));

        JTextField txtEmpId = new JTextField();
        txtEmpId.setBounds(190, 30, 150, 25);
        txtEmpId.setText(null);
        txtEmpId.setEditable(false);

        JLabel lblEmpName = new JLabel("Employee name:");
        lblEmpName.setBounds(50, 70, 150, 25);
        lblEmpName.setFont(labelFont);
        lblEmpName.setForeground(new Color(70, 130, 180));

        JTextField txtEmpName = new JTextField();
        txtEmpName.setBounds(190, 70, 150, 25);

        JLabel lblUsername = new JLabel("Password:");
        lblUsername.setBounds(50, 110, 120, 25);
        lblUsername.setFont(labelFont);
        lblUsername.setForeground(new Color(70, 130, 180));

        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(190, 110, 150, 25);

        JLabel lblPassword = new JLabel("Username:");
        lblPassword.setBounds(50, 150, 120, 25);
        lblPassword.setFont(labelFont);
        lblPassword.setForeground(new Color(70, 130, 180));

        JTextField txtPassword = new JTextField();
        txtPassword.setBounds(190, 150, 150, 25);

        JLabel lblEmpLocation = new JLabel("Employee Location:");
        lblEmpLocation.setBounds(50, 190, 150, 25);
        lblEmpLocation.setFont(labelFont);
        lblEmpLocation.setForeground(new Color(70, 130, 180));

        JTextField txtEmpLocation = new JTextField();
        txtEmpLocation.setBounds(190, 190, 150, 25);

        JButton btnAddEmployee = new JButton("Add Employee");
        btnAddEmployee.setBounds(130, 250, 120, 30);
        btnAddEmployee.setFont(new Font("Arial", Font.BOLD, 12));
        btnAddEmployee.setBackground(new Color(34, 139, 34));
        btnAddEmployee.setForeground(Color.WHITE);
        frame.add(lblEmpId);
        frame.add(txtEmpId);
        frame.add(lblEmpName);
        frame.add(txtEmpName);
        frame.add(lblUsername);
        frame.add(txtUsername);
        frame.add(lblPassword);
        frame.add(txtPassword);
        frame.add(lblEmpLocation);
        frame.add(txtEmpLocation);
        frame.add(btnAddEmployee);

        btnAddEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String empName = txtEmpName.getText();
                String username = txtUsername.getText();
                String password = txtPassword.getText();
                String empLocation = txtEmpLocation.getText();
                Employee emp = new Employee(empName, password, username, empLocation);
                new Connection_DB().insertemployee(emp);
                frame.dispose();
            }
        });
        frame.setVisible(true);
    }

    public static void delete() {
        JFrame del = new JFrame("Delete Employee");
        del.setSize(500, 400);
        del.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        del.setLayout(null);

        del.getContentPane().setBackground(new Color(240, 240, 240));

        JLabel id = new JLabel("Enter ID:");
        id.setBounds(50, 50, 100, 50);
        id.setFont(new Font("Arial", Font.BOLD, 16));
        id.setForeground(new Color(0, 102, 204));
        del.add(id);

        JTextField enterid = new JTextField();
        enterid.setBounds(150, 50, 200, 40);
        enterid.setFont(new Font("Arial", Font.PLAIN, 14));
        del.add(enterid);

        JButton del_emp = new JButton("Delete Employee");
        del_emp.setBounds(150, 150, 200, 50);
        del_emp.setFont(new Font("Arial", Font.BOLD, 14));
        del_emp.setForeground(Color.WHITE);
        del_emp.setBackground(new Color(220, 53, 69));
        del_emp.setFocusPainted(false);
        del_emp.setBorder(BorderFactory.createLineBorder(new Color(169, 42, 53), 2));
        del.add(del_emp);

        del_emp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection_DB con = new Connection_DB();
                String empId = enterid.getText();
                try {
                    int id = Integer.parseInt(empId);
                    Employee emp = new Employee(id);
                    con.deleteEmployee(emp);
                    JOptionPane.showMessageDialog(del, "Employee deleted successfully!");
                    del.dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(del, "Please enter a valid ID.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });        
        JButton view_emp = new JButton("View Employee");
        view_emp.setBounds(150, 250, 200, 50);
        view_emp.setFont(new Font("Arial", Font.BOLD, 14));
        view_emp.setForeground(Color.WHITE);
        view_emp.setBackground(new Color(220, 53, 69));
        view_emp.setFocusPainted(false);
        view_emp.setBorder(BorderFactory.createLineBorder(new Color(169, 42, 53), 2));
        del.add(view_emp);
        
        view_emp.addActionListener(new ActionListener(){;
            @Override
            public void actionPerformed(ActionEvent e) {
                View_Employee.Employee_details();
            }
    });
        del.setVisible(true);
}
}