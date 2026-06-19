/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package waste_scheduling_system;

/**
 *
 * @author lenovo L390
 */
public class Collection_Status {
    private String scheduleID;
    private String neighborhood;
    private String date;
    private String time;
    private boolean collectionStatus;
    
    public Collection_Status(){
        
    }

    public Collection_Status(String scheduleID, String neighborhood, String date, String time) {
        this.scheduleID = scheduleID;
        this.neighborhood = neighborhood;
        this.date = date;
        this.time = time;
        this.collectionStatus = false;
    }

    public void updateStatus(boolean status) {
        this.collectionStatus = status;
    }

    public void displaySchedule() {
        System.out.println("Schedule ID: " + scheduleID);
        System.out.println("Neighborhood: " + neighborhood);
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
        System.out.println("Collection Status: " + (collectionStatus ? "Completed" : "Pending"));
    }
}