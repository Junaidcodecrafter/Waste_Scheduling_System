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

public class viewreport {

    public static void report_details() {

    JFrame ScheduleFrame = new JFrame("Reports");
    ScheduleFrame.setDefaultCloseOperation(2);
    ScheduleFrame.setSize(800, 600);
    ScheduleFrame.setLayout(new BorderLayout());


    ScheduleFrame.getContentPane().setBackground(new Color(240, 248, 255)); 

    JLabel titleLabel = new JLabel("Report Details", JLabel.CENTER);
    titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
    titleLabel.setForeground(Color.WHITE);
    titleLabel.setOpaque(true);
    titleLabel.setBackground(new Color(0, 102, 204)); 
    titleLabel.setPreferredSize(new Dimension(ScheduleFrame.getWidth(), 50));
    ScheduleFrame.add(titleLabel, BorderLayout.NORTH);

    String[] columnNames = {"Report Title", "Description", "Report ID","Customer name"};
    DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
    JTable ReportTable = new JTable(tableModel);
    ReportTable.setFont(new Font("Arial", Font.PLAIN, 16));
    ReportTable.setRowHeight(25);
    ReportTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
    ReportTable.getTableHeader().setBackground(new Color(0, 153, 255));
    ReportTable.getTableHeader().setForeground(Color.WHITE); 
    ReportTable.setGridColor(new Color(200, 200, 200)); 
    ReportTable.setBackground(Color.WHITE);

    JScrollPane scrollPane = new JScrollPane(ReportTable);
    ScheduleFrame.add(scrollPane, BorderLayout.CENTER);

    try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/waste", "root", "$Nikal146027");
        String query = "SELECT * FROM report";
        PreparedStatement pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            String Report_title = rs.getString("report_title");
            String Description = rs.getString("rep_description");
            String ID = rs.getString("report_id");
            String name = rs.getString("customer_name");
            tableModel.addRow(new Object[]{Report_title, Description, ID,name});
        }
        rs.close();
        pst.close();
        con.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(ScheduleFrame, "Error loading report data.", "Error", JOptionPane.ERROR_MESSAGE);
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