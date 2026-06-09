package waste_scheduling_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Admin {
    public Admin() {
    JFrame adminLoginFrame = new JFrame("Admin Login");
    adminLoginFrame.setDefaultCloseOperation(2);
    adminLoginFrame.setSize(500, 400);
    adminLoginFrame.setLayout(null);
    adminLoginFrame.getContentPane().setBackground(new Color(240, 240, 240));

    JLabel titleLabel = new JLabel("Enter your details", JLabel.CENTER);
    titleLabel.setBounds(100, 30, 300, 40);
    titleLabel.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
    titleLabel.setForeground(new Color(0, 102, 204)); 
    adminLoginFrame.add(titleLabel);

    JLabel usernameLabel = new JLabel("Username:");
    usernameLabel.setBounds(50, 100, 100, 30);
    usernameLabel.setFont(new java.awt.Font("Arial", Font.PLAIN, 14));
    usernameLabel.setForeground(Color.BLACK);
    adminLoginFrame.add(usernameLabel);

    JTextField usernameField = new JTextField();
    usernameField.setBounds(150, 100, 200, 30);
    usernameField.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 2)); 
    adminLoginFrame.add(usernameField);

    JLabel passwordLabel = new JLabel("Password:");
    passwordLabel.setBounds(50, 150, 100, 30);
    passwordLabel.setFont(new java.awt.Font("Arial", Font.PLAIN, 14));
    passwordLabel.setForeground(Color.BLACK);
    adminLoginFrame.add(passwordLabel);

    JPasswordField passwordField = new JPasswordField();
    passwordField.setBounds(150, 150, 200, 30);
    passwordField.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 2)); 
    adminLoginFrame.add(passwordField);

    JButton submitButton = new JButton("Submit");
    submitButton.setBounds(200, 220, 100, 40);
    submitButton.setBackground(new Color(0, 102, 204));
    submitButton.setForeground(Color.WHITE);
    submitButton.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
    submitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (username.equals("admin") && password.equals("password")) {
                adminLoginFrame.dispose(); 
                openAdminPerformFrame();
            } else {
                JOptionPane.showMessageDialog(adminLoginFrame, "Invalid credentials.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    });
    adminLoginFrame.add(submitButton);
    adminLoginFrame.setVisible(true);
}

private static void openAdminPerformFrame() {
    JFrame adminPerformFrame = new JFrame("Admin Perform");
    adminPerformFrame.setDefaultCloseOperation(2);
    adminPerformFrame.setSize(400, 500);
    adminPerformFrame.setLayout(null);

    adminPerformFrame.getContentPane().setBackground(new Color(240, 248, 255)); 

    Font buttonFont = new Font("Arial", Font.BOLD, 14);

    JButton viewScheduleButton = createStyledButton("View Schedule", 100, 50, buttonFont);
    JButton viewReportsButton = createStyledButton("View Reports", 100, 100, buttonFont);
    JButton neighbourDetailsButton = createStyledButton("Customer Details", 100, 150, buttonFont);
    JButton collectionStatusButton = createStyledButton("Collection Status", 100, 200, buttonFont);
    JButton viewRequestButton = createStyledButton("View Requests", 100, 250, buttonFont);
    JButton addEmployeeButton = createStyledButton("Add Employee", 100, 300, buttonFont);
    JButton deleteEmployeeButton = createStyledButton("Delete Employee", 100, 350, buttonFont);
    JButton logoutButton = createStyledButton("Logout", 200, 400, buttonFont);

    adminPerformFrame.add(viewScheduleButton);
    adminPerformFrame.add(viewReportsButton);
    adminPerformFrame.add(neighbourDetailsButton);
    adminPerformFrame.add(collectionStatusButton);
    adminPerformFrame.add(viewRequestButton);
    adminPerformFrame.add(addEmployeeButton);
    adminPerformFrame.add(deleteEmployeeButton);
    adminPerformFrame.add(logoutButton);

    viewScheduleButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           schedule_table.showSchedule();
        }
    });
    viewReportsButton.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
           viewreport.report_details();
        }     
    });
    neighbourDetailsButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            View_customer.customer_details();
        }
    });
    collectionStatusButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            see_status.status_details();
        }
    });
    viewRequestButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            view_requests.request_details();
        }
    });
    addEmployeeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Employee.AddEmployee();
        }
    });
    deleteEmployeeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Employee.delete();
        }
    });
    logoutButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            adminPerformFrame.dispose();
        }
    });
    adminPerformFrame.setVisible(true);
}

private static JButton createStyledButton(String text, int x, int y, Font font) {
    JButton button = new JButton(text);
    button.setBounds(x, y, 200, 40);
    button.setFont(font);
    button.setBackground(new Color(60, 179, 113)); 
    button.setForeground(Color.WHITE); 
    button.setFocusPainted(false); 
    button.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2)); 

    button.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            button.setBackground(new Color(46, 139, 87)); 
        }
        @Override
        public void mouseExited(MouseEvent e) {
            button.setBackground(new Color(60, 179, 113));
        }
    });
    return button;
    }
}