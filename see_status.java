package waste_scheduling_system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class see_status {

    public static void status_details() {
 
    JFrame ScheduleFrame = new JFrame("Status Details");
    ScheduleFrame.setDefaultCloseOperation(2);
    ScheduleFrame.setSize(800, 600);
    ScheduleFrame.setLayout(new BorderLayout());

    ScheduleFrame.getContentPane().setBackground(new Color(240, 248, 255));

    JLabel titleLabel = new JLabel("Status Details", JLabel.CENTER);
    titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
    titleLabel.setForeground(Color.WHITE);
    titleLabel.setOpaque(true);
    titleLabel.setBackground(new Color(0, 102, 204)); 
    titleLabel.setPreferredSize(new Dimension(ScheduleFrame.getWidth(), 50));
    ScheduleFrame.add(titleLabel, BorderLayout.NORTH);

    String[] columnNames = {"Collection Status", "Customer Name", "Customer Address"};
    DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
    JTable VehicleTable = new JTable(tableModel);
    VehicleTable.setFont(new Font("Arial", Font.PLAIN, 16));
    VehicleTable.setRowHeight(25);
    VehicleTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
    VehicleTable.getTableHeader().setBackground(new Color(0, 153, 255)); 
    VehicleTable.getTableHeader().setForeground(Color.WHITE); 
    VehicleTable.setGridColor(new Color(200, 200, 200)); 
    VehicleTable.setBackground(Color.WHITE);

    JScrollPane scrollPane = new JScrollPane(VehicleTable);
    ScheduleFrame.add(scrollPane, BorderLayout.CENTER);

    try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/waste", "root", "$Nikal146027");
        String query = "SELECT * FROM collection";
        PreparedStatement pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            String collection_status = rs.getString("collection_status");
            String customer_name = rs.getString("customer_name");
            String customer_address = rs.getString("customer_address");
            tableModel.addRow(new Object[]{collection_status, customer_name, customer_address});
        }
        rs.close();
        pst.close();
        con.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(ScheduleFrame, "Error loading status data.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    JLabel footerLabel = new JLabel("Waste Management System © 2024", JLabel.CENTER);
    footerLabel.setFont(new Font("Arial", Font.ITALIC, 14));
    footerLabel.setForeground(new Color(128, 128, 128)); 
    footerLabel.setOpaque(true);
    footerLabel.setBackground(new Color(240, 240, 240)); 
    footerLabel.setPreferredSize(new Dimension(ScheduleFrame.getWidth(), 30));
    ScheduleFrame.add(footerLabel, BorderLayout.SOUTH);

    ScheduleFrame.setVisible(true);
}
}