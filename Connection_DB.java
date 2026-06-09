package waste_scheduling_system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Connection_DB {
    Neighbour neg = new Neighbour();
    String user = "root";
    String pass = "$Nikal146027";
    String url = "jdbc:mysql://localhost:3306/waste";
    Connection con = null;
    PreparedStatement pst = null;
    String query = null;
    ResultSet rs = null;

    Connection_DB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection done");
           } 
            catch (ClassNotFoundException ex) {
            System.out.println("class not found.");
           }
            catch (SQLException exs) {
            System.out.println("Failed to connect to database.");
           } 
    }

    public int login(Customer c) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/waste", "root", "$Nikal146027");
            String query = "SELECT * FROM register WHERE name = ? AND password = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, c.getName());
            pst.setString(2, c.getPassword());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return 1;
            }
            rs.close();
            pst.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
        }
        return 0;
    }

    public String employeelogin(Employee em) {
        try {
            int status = 0;
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/waste", "root", "$Nikal146027");
            String query = "SELECT * FROM employee WHERE Username = ? AND Emp_password = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, em.getEmp_name());
            pst.setString(2, em.getEmp_password());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                status = 1;
            }
            rs.close();
            pst.close();
            con.close();
            if (status == 1) {
                return em.getEmp_name();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
        }
        return "no";
    }

    public void insertneighbour(Neighbour neg) {
        try {
            query = "Insert into Register(name,age,cnic,address,password,phonenumber) VALUES(?,?,?,?,?,?)";
            pst = con.prepareStatement(query);
            pst.setString(1, neg.getName());
            pst.setInt(2, neg.getAge());
            pst.setString(3, neg.getCnic());
            pst.setString(4, neg.getAddress());
            pst.setString(5, neg.getPassword());
            pst.setString(6, neg.getPhonenumber());
            pst.executeUpdate();
            System.out.println("Data inserted successfully.");
        } catch (SQLException ex) {
            System.out.println("Failed to connect to database ");
        }
    }

    public void insertreport(Report r) {
        try {
            query = "Insert into report(report_title,rep_description,report_id,customer_name) VALUES(?,?,?,?)";
            pst = con.prepareStatement(query);
            pst.setString(1, r.getReport_title());
            pst.setString(2, r.getReport_description());
            pst.setString(3, r.getReport_id());
            pst.setString(4, r.getCustomername());
            pst.executeUpdate();
            System.out.println("Report data added successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to insert data." + e.getMessage());
        }
    }

    public void submitrequest(request r1) {
        try {
            query = "Insert into request(req_time,Additional_information,day,request_id,customer_name,status) VALUES(?,?,?,?,?,?)";
            pst = con.prepareStatement(query);
            pst.setString(1, r1.getRequest_time());
            pst.setString(2, r1.getRequest_shift());
            pst.setString(3, r1.getRequest_address());
            pst.setString(4, r1.getRequest_id());
            pst.setString(5, r1.getCustomer_name());
            pst.setString(6, r1.getStatus());
            pst.executeUpdate();
            System.out.println("Request Submitted.");
        } catch (SQLException e) {
            System.out.println("Failed to insert request data." + e.getMessage());
        }
    }

    public void see_status(status s) {
        try {
            query = "Insert into collection(collection_status,customer_name,customer_address) VALUES(?,?,?)";
            pst = con.prepareStatement(query);
            pst.setString(1, s.getCollection_status());
            pst.setString(2, s.getCustomer_name());
            pst.setString(3, s.getCustomer_address());
            pst.executeUpdate();
            System.out.println("data added ");
        } catch (SQLException e) {
            System.out.println("failed to insert ");
        }
    }

    public void insertemployee(Employee empl) {
        try {
            query = "Insert into employee(Emp_name,Username,Emp_password,Emp_location) VALUES(?,?,?,?)";
            pst = con.prepareStatement(query);
            pst.setString(1, empl.getEmp_name());
            pst.setString(2, empl.getUsername());
            pst.setString(3, empl.getEmp_password());
            pst.setString(4, empl.getEmp_location());
            pst.executeUpdate();
            System.out.println("Employee added.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error" + e.getMessage());
        }
    }

    public boolean check(String a, String b) {
        try {
            query = "Select name,age,cnic,address,password,phonenumber from register where name = ? AND cnic = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, a);
            pst.setString(2, b);
            pst.execute();
            return true;
        } catch (SQLException f) {
            System.out.println("Failed" + f.getMessage());
            return false;
        }
    }

    public DefaultTableModel employee(String location) {
        JFrame ScheduleFrame = new JFrame("Request Details");
        ScheduleFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ScheduleFrame.setSize(800, 600);
        ScheduleFrame.setLayout(new BorderLayout());

        ScheduleFrame.getContentPane().setBackground(new Color(240, 248, 255));

        JLabel titleLabel = new JLabel("Request Details", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(0, 102, 204));
        titleLabel.setPreferredSize(new Dimension(ScheduleFrame.getWidth(), 50));
        ScheduleFrame.add(titleLabel, BorderLayout.NORTH);

        String[] columnNames = {"Customer Address", "Customer name", "Phone number"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable RequestTable = new JTable(tableModel);
        RequestTable.setFont(new Font("Arial", Font.PLAIN, 16));
        RequestTable.setRowHeight(25);
        RequestTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        RequestTable.getTableHeader().setBackground(new Color(0, 153, 255));
        RequestTable.getTableHeader().setForeground(Color.WHITE);
        RequestTable.setGridColor(new Color(200, 200, 200));
        RequestTable.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(RequestTable);
        ScheduleFrame.add(scrollPane, BorderLayout.CENTER);

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/waste", "root", "$Nikal146027");
            String query = "select * from register where address=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, location);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String address = rs.getString("address");
                String customername = rs.getString("name");
                String emp_location = rs.getString("phonenumber");

                tableModel.addRow(new Object[]{address, customername, emp_location});
            }
            rs.close();

            JButton button = new JButton("Get Selected Row");
            ScheduleFrame.add(button, BorderLayout.EAST);

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int selectedRow = RequestTable.getSelectedRow();
                    if (selectedRow != -1) {
                        String customerName = RequestTable.getValueAt(selectedRow, 1).toString();
                        int result;
                        result = JOptionPane.showConfirmDialog(null, "Do you want to accept request?", "Confirm", JOptionPane.YES_NO_OPTION);
                        if (result == JOptionPane.YES_OPTION) {
                            try {
                                String query = "UPDATE request SET status = ? where customer_name=?";
                                PreparedStatement pst1 = con.prepareStatement(query);
                                pst1 = con.prepareStatement(query);

                                pst1.setString(1, "completed");
                                pst1.setString(2, customerName);
                                pst1.executeUpdate();
                                System.out.println("Done");

                                pst.close();
                                con.close();
                            } catch (SQLException sqle) {
                                System.out.println(sqle);
                            }
                        } else {
                            System.out.println("User clicked No");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "No row selected!");
                    }
                }
            });

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(ScheduleFrame, "Error loading request data.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        JLabel footerLabel = new JLabel("Waste Management System © 2024", JLabel.CENTER);
        footerLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        footerLabel.setForeground(new Color(128, 128, 128));
        footerLabel.setOpaque(true);
        footerLabel.setBackground(new Color(240, 240, 240));
        footerLabel.setPreferredSize(new Dimension(ScheduleFrame.getWidth(), 30));
        ScheduleFrame.add(footerLabel, BorderLayout.SOUTH);

        ScheduleFrame.setVisible(true);
        return null;
    }

    public void deleteEmployee(Employee emp) {
        try {
            query = "DELETE FROM employee WHERE Emp_id = ?";
            pst = con.prepareStatement(query);
            pst.setInt(1, emp.getEmp_id());
            pst.executeUpdate();
            System.out.println("Employee deleted.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error deleting employee: " + e.getMessage());
        }
    }
//    public static void viewemployee(Employee employ){
//        try{
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/waste", "root", "$Nikal146027");
//            String query = "SELECT * FROM employee";
//            PreparedStatement pst = con.prepareStatement(query);
//            ResultSet rs = pst.executeQuery();
//        }
//        catch(SQLException e){
//            JOptionPane.showMessageDialog(null, "Error viewing employee." + e.getMessage());
//        }
//    }

    public void closedconnection() {
        if (con != null) {
            try {
                con.close();
                pst.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
