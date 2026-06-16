package waste_scheduling_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Random;

public class Customer {
    private String name;
    private String password;
    private static String reportid;
    private static String request_id;
    private static String username;
    private static String address;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Customer(String name,String password){
        this.name = name;
        this.password = password;
    }    
    
    public Customer() {
        JFrame customerFrame = new JFrame("Customer");
        customerFrame.setDefaultCloseOperation(2);
        customerFrame.setSize(800, 500);
        customerFrame.setLayout(null);
        
        customerFrame.getContentPane().setBackground(new Color(240, 248, 255)); 
        
        JLabel signinLabel = new JLabel("Select to sign in:");
        signinLabel.setBounds(300, 120, 200, 40);
        signinLabel.setFont(new Font("Arial", Font.BOLD, 16));
        signinLabel.setForeground(new Color(0, 102, 204)); 
        customerFrame.add(signinLabel);

        JButton signinButton = new JButton("Sign in");
        signinButton.setBounds(300, 170, 200, 40);
        signinButton.setFont(new Font("Arial", Font.BOLD, 16));
        signinButton.setBackground(new Color(0, 102, 204)); 
        signinButton.setForeground(Color.WHITE);
        signinButton.setFocusPainted(false);
        customerFrame.add(signinButton);

        JLabel signupLabel = new JLabel("Select to sign up:");
        signupLabel.setBounds(300, 240, 200, 40);
        signupLabel.setFont(new Font("Arial", Font.BOLD, 16));
        signupLabel.setForeground(new Color(0, 102, 204)); 
        customerFrame.add(signupLabel);

        JButton signupButton = new JButton("Sign up");
        signupButton.setBounds(300, 290, 200, 40);
        signupButton.setFont(new Font("Arial", Font.BOLD, 16));
        signupButton.setBackground(new Color(0, 102, 204)); 
        signupButton.setForeground(Color.WHITE); 
        signupButton.setFocusPainted(false);
        customerFrame.add(signupButton);

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCustomerSignupFrame();
            }
        });
        signinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCustomerSigninFrame();
            }
        });
        customerFrame.setVisible(true);
    }

    private static void openCustomerFrame() {
    JFrame customerFrame = new JFrame("Customer");
    customerFrame.setDefaultCloseOperation(2);
    customerFrame.setSize(800, 500);
    customerFrame.setLayout(null);

    customerFrame.getContentPane().setBackground(new Color(245, 245, 245)); 

    JLabel signinLabel = new JLabel("Select to sign in:");
    signinLabel.setBounds(300, 120, 200, 40);
    signinLabel.setFont(new Font("Arial", Font.BOLD, 16));
    signinLabel.setForeground(new Color(0, 102, 153)); 
    customerFrame.add(signinLabel);

    JButton signinButton = new JButton("Sign in");
    signinButton.setBounds(300, 170, 200, 40);
    signinButton.setFont(new Font("Arial", Font.BOLD, 16));
    signinButton.setBackground(new Color(0, 153, 204)); 
    signinButton.setForeground(Color.WHITE); 
    signinButton.setFocusPainted(false);
    signinButton.setBorderPainted(false);
    customerFrame.add(signinButton);

    JLabel signupLabel = new JLabel("Select to sign up:");
    signupLabel.setBounds(300, 240, 200, 40);
    signupLabel.setFont(new Font("Arial", Font.BOLD, 16));
    signupLabel.setForeground(new Color(0, 102, 153)); 
    customerFrame.add(signupLabel);

    JButton signupButton = new JButton("Sign up");
    signupButton.setBounds(300, 290, 200, 40);
    signupButton.setFont(new Font("Arial", Font.BOLD, 16));
    signupButton.setBackground(new Color(0, 153, 204)); 
    signupButton.setForeground(Color.WHITE); 
    signupButton.setFocusPainted(false);
    signupButton.setBorderPainted(false);
    customerFrame.add(signupButton);
    
    signupButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            openCustomerSignupFrame();
        }
    });
    signinButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            openCustomerSigninFrame();
        }
    });
    customerFrame.setVisible(true);
}

    private static void openCustomerSigninFrame() {
    JFrame signinFrame = new JFrame("Customer Sign-in");
    signinFrame.setDefaultCloseOperation(2);
    signinFrame.setSize(600, 400);
    signinFrame.setLayout(null);

    signinFrame.getContentPane().setBackground(new Color(230, 240, 255)); 

    JLabel usernameLabel = new JLabel("Enter Username:");
    usernameLabel.setBounds(100, 100, 150, 40);
    usernameLabel.setFont(new Font("Arial", Font.BOLD, 16));
    usernameLabel.setForeground(new Color(0, 51, 102)); 
    signinFrame.add(usernameLabel);

    JTextField usernameField = new JTextField();
    usernameField.setBounds(300, 100, 180, 40);
    usernameField.setFont(new Font("Arial", Font.PLAIN, 16));
    signinFrame.add(usernameField);

    JLabel passwordLabel = new JLabel("Enter Password:");
    passwordLabel.setBounds(100, 180, 150, 40);
    passwordLabel.setFont(new Font("Arial", Font.BOLD, 16));
    passwordLabel.setForeground(new Color(0, 51, 102)); 
    signinFrame.add(passwordLabel);

    JPasswordField passwordField = new JPasswordField();
    passwordField.setBounds(300, 180, 180, 40);
    passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
    signinFrame.add(passwordField);

    JButton loginButton = new JButton("Login");
    loginButton.setBounds(220, 260, 150, 40);
    loginButton.setFont(new Font("Arial", Font.BOLD, 16));
    loginButton.setBackground(new Color(0, 153, 204));
    loginButton.setForeground(Color.WHITE); 
    loginButton.setFocusPainted(false);
    loginButton.setBorderPainted(false);
    signinFrame.add(loginButton);

    loginButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            username = usernameField.getText();
            String password = new String(passwordField.getPassword()); 
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter both username and password.", "Input Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
            Customer customer = new Customer(username, password);
            Connection_DB connectionDB = new Connection_DB();
            int loginStatus = connectionDB.login(customer);
            if (loginStatus == 1) {
                signinFrame.dispose();
                openCustomerMenuFrame();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password. Kindly signup first.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        }
    });
    signinFrame.setVisible(true);
}

    private static void openCustomerMenuFrame() {
    JFrame customerMenuFrame = new JFrame("Customer Menu");
    customerMenuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    customerMenuFrame.setSize(400, 500);
    customerMenuFrame.setLayout(null);

    customerMenuFrame.getContentPane().setBackground(new Color(240, 248, 255)); 

    JLabel menuLabel = new JLabel("Customer Menu");
    menuLabel.setBounds(100, 20, 200, 40);
    menuLabel.setFont(new Font("Arial", Font.BOLD, 24));
    menuLabel.setHorizontalAlignment(SwingConstants.CENTER);
    menuLabel.setForeground(new Color(0, 102, 153)); 
    customerMenuFrame.add(menuLabel);

    Font buttonFont = new Font("Arial", Font.BOLD, 18);
    Color buttonBackground = new Color(0, 153, 204); 
    Color buttonForeground = Color.WHITE;

    JButton initiateButton = new JButton("Initiate Request");
    initiateButton.setBounds(100, 80, 200, 50);
    initiateButton.setFont(buttonFont);
    initiateButton.setBackground(buttonBackground);
    initiateButton.setForeground(buttonForeground);
    initiateButton.setFocusPainted(false);
    initiateButton.setBorderPainted(false);
    customerMenuFrame.add(initiateButton);

    initiateButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Customer.initiate();
        }
    });
    JButton updateButton = new JButton("Update Info");
    updateButton.setBounds(100, 140, 200, 50);
    updateButton.setFont(buttonFont);
    updateButton.setBackground(buttonBackground);
    updateButton.setForeground(buttonForeground);
    updateButton.setFocusPainted(false);
    updateButton.setBorderPainted(false);
    customerMenuFrame.add(updateButton);

    updateButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Customer.show_status();
        }
    });
    JButton reportButton = new JButton("Report");
    reportButton.setBounds(100, 200, 200, 50);
    reportButton.setFont(buttonFont);
    reportButton.setBackground(buttonBackground);
    reportButton.setForeground(buttonForeground);
    reportButton.setFocusPainted(false);
    reportButton.setBorderPainted(false);
    customerMenuFrame.add(reportButton);
    reportButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Customer.reportdetailsform();
        }
    });

    JButton viewButton = new JButton("View Schedule");
    viewButton.setBounds(100, 260, 200, 50);
    viewButton.setFont(buttonFont);
    viewButton.setBackground(buttonBackground);
    viewButton.setForeground(buttonForeground);
    viewButton.setFocusPainted(false);
    viewButton.setBorderPainted(false);
    customerMenuFrame.add(viewButton);

    viewButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            schedule_table.showSchedule();
        }
    });
    
    JButton logoutButton = new JButton("Logout");
    logoutButton.setBounds(200, 400, 100, 50);
    logoutButton.setFont(buttonFont);
    logoutButton.setBackground(buttonBackground);
    logoutButton.setForeground(buttonForeground);    
    logoutButton.setFocusPainted(false);
    logoutButton.setBorderPainted(false);
    customerMenuFrame.add(logoutButton);
        
        logoutButton.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               customerMenuFrame.dispose();
           }   
        });

    customerMenuFrame.setVisible(true);
}
    
    private static void openCustomerSignupFrame() {

    JFrame signupFrame = new JFrame("Customer Signup");
    signupFrame.setDefaultCloseOperation(2);
    signupFrame.setSize(800, 600);
    signupFrame.setLayout(null);

    signupFrame.getContentPane().setBackground(new Color(245, 245, 245));

    Font labelFont = new Font("Arial", Font.BOLD, 16);
    Color labelColor = new Color(0, 102, 153); 

    JLabel nameLabel = new JLabel("Enter your name:");
    nameLabel.setBounds(100, 100, 200, 40);
    nameLabel.setFont(labelFont);
    nameLabel.setForeground(labelColor);
    signupFrame.add(nameLabel);

    JTextField nameField = new JTextField();
    nameField.setBounds(320, 100, 300, 40);
    signupFrame.add(nameField);

    JLabel ageLabel = new JLabel("Enter your age:");
    ageLabel.setBounds(100, 160, 200, 40);
    ageLabel.setFont(labelFont);
    ageLabel.setForeground(labelColor);
    signupFrame.add(ageLabel);

    JTextField ageField = new JTextField();
    ageField.setBounds(320, 160, 300, 40);
    signupFrame.add(ageField);

    JLabel cnicLabel = new JLabel("Enter your CNIC:");
    cnicLabel.setBounds(100, 220, 200, 40);
    cnicLabel.setFont(labelFont);
    cnicLabel.setForeground(labelColor);
    signupFrame.add(cnicLabel);

    JTextField cnicField = new JTextField();
    cnicField.setBounds(320, 220, 300, 40);
    signupFrame.add(cnicField);

    JLabel addressLabel = new JLabel("Enter your address:");
    addressLabel.setBounds(100, 280, 200, 40);
    addressLabel.setFont(labelFont);
    addressLabel.setForeground(labelColor);
    signupFrame.add(addressLabel);

    JTextField addressField = new JTextField();
    addressField.setBounds(320, 280, 300, 40);
    signupFrame.add(addressField);

    JLabel passwordLabel = new JLabel("Enter your password:");
    passwordLabel.setBounds(100, 340, 200, 40);
    passwordLabel.setFont(labelFont);
    passwordLabel.setForeground(labelColor);
    signupFrame.add(passwordLabel);

    JPasswordField passField = new JPasswordField();
    passField.setBounds(320, 340, 300, 40);
    signupFrame.add(passField);

    JLabel phoneLabel = new JLabel("Enter your phone number:");
    phoneLabel.setBounds(100, 400, 250, 40);
    phoneLabel.setFont(labelFont);
    phoneLabel.setForeground(labelColor);
    signupFrame.add(phoneLabel);

    JTextField phoneField = new JTextField();
    phoneField.setBounds(320, 400, 300, 40);
    signupFrame.add(phoneField);

    JButton submitButton = new JButton("Submit");
    submitButton.setBounds(320, 480, 200, 50);
    submitButton.setFont(new Font("Arial", Font.BOLD, 18));
    submitButton.setBackground(new Color(0, 153, 204)); 
    submitButton.setForeground(Color.WHITE);
    submitButton.setFocusPainted(false);
    signupFrame.add(submitButton);

    submitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String ageText = ageField.getText();
            String cnic = cnicField.getText();
            address = addressField.getText();
            String password = new String(passField.getPassword());
            String phoneNumber = phoneField.getText();  
            if (name.isEmpty() || ageText.isEmpty() || cnic.isEmpty() || address.isEmpty() || password.isEmpty() || phoneNumber.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter all fields", "Input Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
            int age;
            try {
                age = Integer.parseInt(ageText);
            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(null, "Age must be a valid number", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Connection_DB con = new Connection_DB();
            boolean check = con.check(name, cnic);
            if (!check) {
                JOptionPane.showMessageDialog(null, "User already exists.", "Signup Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            con.insertneighbour(new Neighbour(name, age, cnic, address, password, phoneNumber));
            JOptionPane.showMessageDialog(null, "Signup successful! Redirecting to sign-in page.", "Success", JOptionPane.INFORMATION_MESSAGE);
            signupFrame.dispose();
            openCustomerSigninFrame();
            con.closedconnection();
        }
    });
    signupFrame.setVisible(true);
}

    public static void reportdetailsform() {

    JFrame reportFrame = new JFrame("Report");
    reportFrame.setDefaultCloseOperation(2);
    reportFrame.setSize(800, 600);
    reportFrame.setLayout(null);

    reportFrame.getContentPane().setBackground(new Color(240, 248, 255)); 

    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String reportID = "" + Math.abs(first4);

    Font labelFont = new Font("Arial", Font.BOLD, 18);
    Color labelColor = new Color(0, 51, 102); 

    JLabel reportTitleLabel = new JLabel("Enter your report title:");
    reportTitleLabel.setBounds(50, 50, 250, 40);
    reportTitleLabel.setFont(labelFont);
    reportTitleLabel.setForeground(labelColor);
    reportFrame.add(reportTitleLabel);

    JTextField titleField = new JTextField();
    titleField.setBounds(300, 50, 400, 40);
    titleField.setFont(new Font("Arial", Font.PLAIN, 16));
    reportFrame.add(titleField);

    JLabel reportDetailsLabel = new JLabel("Enter report details:");
    reportDetailsLabel.setBounds(50, 120, 250, 40);
    reportDetailsLabel.setFont(labelFont);
    reportDetailsLabel.setForeground(labelColor);
    reportFrame.add(reportDetailsLabel);

    JTextArea reportTextArea = new JTextArea();
    reportTextArea.setBounds(300, 120, 400, 150);
    reportTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
    reportTextArea.setLineWrap(true);
    reportTextArea.setWrapStyleWord(true);
    reportFrame.add(reportTextArea);

    JLabel idLabel = new JLabel("Report ID: " + reportID);
    idLabel.setBounds(50, 300, 250, 40);
    idLabel.setFont(labelFont);
    idLabel.setForeground(labelColor);
    reportFrame.add(idLabel);
    
    JLabel customerlabel = new JLabel("Customer name:");
    customerlabel.setBounds(50, 350, 200, 40);
    customerlabel.setFont(labelFont);
    customerlabel.setForeground(labelColor);
    reportFrame.add(customerlabel);
    
    JTextField customertext = new JTextField();
    customertext.setBounds(300, 350, 250, 40);
    customertext.setFont(new Font("Arial", Font.PLAIN, 16));
    reportFrame.add(customertext);
    customertext.setText(username);
    customertext.setEditable(false);

    JButton submitReportButton = new JButton("Submit");
    submitReportButton.setBounds(300, 400, 200, 50);
    submitReportButton.setFont(new Font("Arial", Font.BOLD, 20));
    submitReportButton.setBackground(new Color(0, 153, 204)); 
    submitReportButton.setForeground(Color.WHITE);
    submitReportButton.setFocusPainted(false);
    reportFrame.add(submitReportButton);

    submitReportButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = titleField.getText();
            String description = reportTextArea.getText();
            String name = customertext.getText();

            if (title.isEmpty() || description.isEmpty()) {
                JOptionPane.showMessageDialog(
                        reportFrame,
                        "Please fill in all fields before submitting.",
                        "Input Error",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }
            Connection_DB con1 = new Connection_DB();
            Report report = new Report(title, description, reportID,name);
            con1.insertreport(report);
            con1.closedconnection();

            JOptionPane.showMessageDialog(
                    reportFrame,
                    "Report submitted successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );
            reportFrame.dispose();
        }
    });

    reportFrame.setVisible(true);
}
    public static void initiate() {
    JFrame requestFrame = new JFrame("Initiate Request");
    requestFrame.setSize(800, 600);
    requestFrame.setLayout(null);
    requestFrame.setDefaultCloseOperation(2);

    requestFrame.getContentPane().setBackground(new Color(240, 248, 255)); 

    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String requestID = "" + Math.abs(first4);

    Font labelFont = new Font("Arial", Font.BOLD, 18);
    Color labelColor = new Color(0, 51, 102); 

    JLabel initiateRequestLabel = new JLabel("Initiate Request");
    initiateRequestLabel.setBounds(250, 20, 300, 40);
    initiateRequestLabel.setFont(new Font("Arial", Font.BOLD, 24));
    initiateRequestLabel.setForeground(labelColor);
    requestFrame.add(initiateRequestLabel);

    JLabel selectTimeLabel = new JLabel("Select Time:");
    selectTimeLabel.setBounds(50, 80, 150, 30);
    selectTimeLabel.setFont(labelFont);
    selectTimeLabel.setForeground(labelColor);
    requestFrame.add(selectTimeLabel);

    String[] timings = {"8 am", "10 am", "12 pm", "2 pm", "4 pm", "6 pm"};
    JComboBox<String> timeBox = new JComboBox<>(timings);
    timeBox.setBounds(200, 80, 150, 30);
    timeBox.setFont(new Font("Arial", Font.PLAIN, 16));
    requestFrame.add(timeBox);

    JLabel dayLabel = new JLabel("Select Day:");
    dayLabel.setBounds(50, 130, 150, 30);
    dayLabel.setFont(labelFont);
    dayLabel.setForeground(labelColor);
    requestFrame.add(dayLabel);

    String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    JComboBox<String> dayBox = new JComboBox<>(days);
    dayBox.setBounds(200, 130, 150, 30);
    dayBox.setFont(new Font("Arial", Font.PLAIN, 16));
    requestFrame.add(dayBox);

    JLabel commentLabel = new JLabel("Additional Instructions:");
    commentLabel.setBounds(50, 180, 220, 30);
    commentLabel.setFont(labelFont);
    commentLabel.setForeground(labelColor);
    requestFrame.add(commentLabel);

    JTextField commentTextField = new JTextField();
    commentTextField.setBounds(250, 180, 400, 50);
    commentTextField.setFont(new Font("Arial", Font.PLAIN, 16));
    requestFrame.add(commentTextField);

    JLabel requestIDLabel = new JLabel("Request ID: " + requestID);
    requestIDLabel.setBounds(50, 250, 300, 30);
    requestIDLabel.setFont(labelFont);
    requestIDLabel.setForeground(labelColor);
    requestFrame.add(requestIDLabel);
    
    JLabel customerlabel = new JLabel("Customer name:");
    customerlabel.setBounds(50, 300, 200, 40);
    customerlabel.setFont(labelFont);
    customerlabel.setForeground(labelColor);
    requestFrame.add(customerlabel);
    
    JTextField customertext = new JTextField();
    customertext.setBounds(300, 300, 250, 40);
    customertext.setFont(new Font("Arial", Font.PLAIN, 16));
    requestFrame.add(customertext);
    customertext.setText(username);
    customertext.setEditable(false);

    JButton submitButton = new JButton("Submit Request");
    submitButton.setBounds(300, 400, 200, 50);
    submitButton.setFont(new Font("Arial", Font.BOLD, 20));
    submitButton.setBackground(new Color(0, 153, 204)); // Light blue button
    submitButton.setForeground(Color.WHITE);
    submitButton.setFocusPainted(false);
    requestFrame.add(submitButton);

    submitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedTime = timeBox.getSelectedItem().toString();
            String selectedDay = dayBox.getSelectedItem().toString();
            String requestDetails = commentTextField.getText();
            String custname = customertext.getText();

            Connection_DB con2 = new Connection_DB();
            request r1 = new request(selectedTime, selectedDay, requestDetails, requestID,custname,"pending");
            con2.submitrequest(r1);
            con2.closedconnection();

            JOptionPane.showMessageDialog(
                    requestFrame,
                    "Request submitted successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );
            requestFrame.dispose();
        }
    });
    requestFrame.setVisible(true);
}
    public static void show_status() {
    JFrame statusFrame = new JFrame("Customer Status");
    statusFrame.setSize(800, 600);
    statusFrame.setLayout(null);
    statusFrame.setDefaultCloseOperation(2);

    statusFrame.getContentPane().setBackground(new Color(245, 245, 245)); 

    Font labelFont = new Font("Arial", Font.BOLD, 18);
    Color labelColor = new Color(34, 45, 65); 

    JLabel titleLabel = new JLabel("Customer Status");
    titleLabel.setBounds(250, 20, 300, 40);
    titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
    titleLabel.setForeground(new Color(0, 102, 204)); 
    statusFrame.add(titleLabel);

    JLabel statusLabel = new JLabel("Collection Status:");
    statusLabel.setBounds(50, 100, 200, 30);
    statusLabel.setFont(labelFont);
    statusLabel.setForeground(labelColor);
    statusFrame.add(statusLabel);

    String[] statusOptions = {"Yes", "No"};
    JComboBox<String> statusBox = new JComboBox<>(statusOptions);
    statusBox.setBounds(250, 100, 150, 30);
    statusBox.setFont(new Font("Arial", Font.PLAIN, 16));
    statusFrame.add(statusBox);

    JLabel customerNameLabel = new JLabel("Customer Name:");
    customerNameLabel.setBounds(50, 160, 200, 30);
    customerNameLabel.setFont(labelFont);
    customerNameLabel.setForeground(labelColor);
    statusFrame.add(customerNameLabel);

    JTextField customerNameField = new JTextField();
    customerNameField.setBounds(250, 160, 400, 30);
    customerNameField.setFont(new Font("Arial", Font.PLAIN, 16));
    statusFrame.add(customerNameField);
    customerNameField.setText(username);
    customerNameField.setEditable(false);

    JLabel addressLabel = new JLabel("Customer Address:");
    addressLabel.setBounds(50, 220, 200, 30);
    addressLabel.setFont(labelFont);
    addressLabel.setForeground(labelColor);
    statusFrame.add(addressLabel);

    JTextField addressField = new JTextField();
    addressField.setBounds(250, 220, 400, 30);
    addressField.setFont(new Font("Arial", Font.PLAIN, 16));
    statusFrame.add(addressField);
    addressField.setText(address);
    addressField.setEditable(false);

    JButton submitButton = new JButton("Submit Status");
    submitButton.setBounds(300, 400, 200, 50);
    submitButton.setFont(new Font("Arial", Font.BOLD, 20));
    submitButton.setBackground(new Color(0, 153, 76)); 
    submitButton.setForeground(Color.WHITE);
    submitButton.setFocusPainted(false);
    statusFrame.add(submitButton);

    submitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String collectionStatus = statusBox.getSelectedItem().toString();
            String customerName = customerNameField.getText();
            String customerAddress = addressField.getText();
            Connection_DB con2 = new Connection_DB();
            status s = new status(collectionStatus, customerName, customerAddress);
            con2.see_status(s);
            con2.closedconnection();
            JOptionPane.showMessageDialog(
                    statusFrame,
                    "Status submitted successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );
            statusFrame.dispose();
        }
    });
    statusFrame.setVisible(true);
}
}