/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patient;
import staff.*; 
import java.util.Date;
import java.util.TimeZone;
 
/**
 *
 * @author Mansi Verma
 */
public class Appointment {
    
    private long appointId;
    private Doctor doctor;
    private Patient patient;
    private Date date;
    //private Time time;
    
    
    public long getId(){
        return this.appointId;
    }
    
    public Doctor getDoctor(){
        return this.doctor;
    }
    
    public Patient getPatient(){
        return patient;
    }
    
    public Date getDate(){
        return date;
    }
    
    /*public Time getTime(){
        return date;
    }*/
    
    public void setDoctor(Doctor doctor){
        
    }
    
    public void setPatient(Patient patient){
        
    }
    
    public void setDate(Date date){
        
    }
    
    /*public void setTime(Time time){
        
    }*/
    
    public void checkDoctorAvailability(){
        
    }
    
    public void bookAppointment(){
        
    }
    
    public void cancelAppointment(){
        
    }
    
}
