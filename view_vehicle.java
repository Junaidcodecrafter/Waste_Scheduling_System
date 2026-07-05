package waste_scheduling_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class view_vehicle {
    public static void vehicle_details(){
    JFrame ScheduleFrame = new JFrame("Schedule");
    ScheduleFrame.setDefaultCloseOperation(2);
    ScheduleFrame.setSize(800, 600);

    String[] columnNames = {"Vehicle Name", "Vehicle Type", "Vehicle Engine"};
        
    DefaultTableModel table = new DefaultTableModel(columnNames, 0);
    JTable VehicleTable = new JTable(table);

    ScheduleFrame.add(VehicleTable.getTableHeader(), "North");
    ScheduleFrame.add(VehicleTable);
    try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/waste ", "root", "$Nikal146027");
        String query = "SELECT * FROM vehichle";
        PreparedStatement pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            String Vehicle_name = rs.getString("vec_name");
            String Vehicle_type = rs.getString("vec_type");
            String Vehicle_engine = rs.getString("vec_engine");
            table.addRow(new Object[]{Vehicle_name,Vehicle_type,Vehicle_engine});
            }
           rs.close();
           pst.close();
           con.close();
            
           }catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(ScheduleFrame, "Error loading schedule data.");
        }
        ScheduleFrame.setVisible(true);
    }
}