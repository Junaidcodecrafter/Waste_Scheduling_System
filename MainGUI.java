package waste_scheduling_system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainGUI {
    public MainGUI() {
     
        JFrame mainframe = new JFrame("Waste Collection Scheduling System");
        mainframe.setDefaultCloseOperation(3);
        mainframe.setSize(900, 515);
        mainframe.setLayout(null);  
        
        ImageIcon backgroundImg = new ImageIcon("C:\\Users\\lenovo L390\\OneDrive\\Desktop\\project.png");
        JLabel backgroundLabel = new JLabel(backgroundImg);
        int imgWidth = backgroundImg.getIconWidth();
        int imgHeight = backgroundImg.getIconHeight();
        int xPos = (mainframe.getWidth() - imgWidth) /2;
        int yPos = (mainframe.getHeight() - imgHeight) /2;
        backgroundLabel.setBounds(xPos, yPos, imgWidth, imgHeight);

        JLabel projectnamelabel = new JLabel("Waste Collection Scheduling System", JLabel.CENTER);
        projectnamelabel.setBounds(50, 50, 700, 100);
        projectnamelabel.setFont(new Font("Serif", Font.BOLD, 36));
        projectnamelabel.setForeground(Color.WHITE); 
        mainframe.add(projectnamelabel);

        JButton AdminButton = new JButton("Admin");
        AdminButton.setBounds(300, 150, 200, 50);
        AdminButton.setFont(new Font("Arial", Font.BOLD, 20));
        AdminButton.setBackground(new Color(30, 144, 255)); 
        AdminButton.setForeground(Color.WHITE); 
        mainframe.add(AdminButton);

        JButton CustomerButton = new JButton("Customer");
        CustomerButton.setBounds(300, 230, 200, 50);
        CustomerButton.setFont(new Font("Arial", Font.BOLD, 20));
        CustomerButton.setBackground(new Color(34, 139, 34)); 
        CustomerButton.setForeground(Color.WHITE); 
        mainframe.add(CustomerButton);

        JButton EmployeeButton = new JButton("Employee");
        EmployeeButton.setBounds(300, 310, 200, 50);
        EmployeeButton.setFont(new Font("Arial", Font.BOLD, 20));
        EmployeeButton.setBackground(new Color(255, 140, 0)); 
        EmployeeButton.setForeground(Color.WHITE); 
        mainframe.add(EmployeeButton);
        
        mainframe.add(backgroundLabel);

        AdminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Admin();
            }
        });
        CustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Customer();
            }
        });
        EmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Employee();
            }
        });
        mainframe.setVisible(true);
    }
}