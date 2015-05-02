/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patient;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import staff.*; 

import java.util.logging.Level;
import java.util.logging.Logger;
import static login.LogIn.con;
 
/**
 *
 * @author Mansi Verma
 */
public class Appointment {
    
    private long appointId;
    private Doctor doctor;
    private Patient patient;
    private String date;
    private int patientId;
    private int doctorId;
    private String departmentName;
    private String appointmentTime;
   
    
    public Appointment(int appointmentId , int doctorId, String date, int patientId, String departmentName,String appointmentTime) {
        this.appointId = appointmentId;
        this.patientId=patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.departmentName=departmentName;
        this.appointmentTime=appointmentTime;
        
        PreparedStatement ps, ps2;
        try {
            
            ps=con.prepareStatement("insert into appointment values (?,?,?,?,?,?)");
            ps.setString(1,""+appointmentId);
            //extracting 
            ps.setString(2,""+doctorId);
            ps.setString(3,departmentName);
            ps.setString(4,""+patientId);
            //ps.setString(5,""+doctorId);
            ps.setString(5,""+date);
            ps.setString(6,""+appointmentTime);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PatientRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public long getId(){
        return this.appointId;
    }
    
    public Doctor getDoctor(){
        return this.doctor;
    }
    
    public Patient getPatient(){
        return patient;
    }
    
    public String getDate(){
        return date;
    }
    
    @Override
    public String toString(){
        return ""+appointId+","+doctorId+","+patientId+","+date+","+departmentName+","+appointmentTime;
    }
    
}
