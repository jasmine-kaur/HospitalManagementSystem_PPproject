/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patient;
import staff.*;
import java.util.Date;

/**
 *
 * @author Mansi Verma
 */
public class Surgery {
    
    private String name;
    private long surgeryId;
    private DepartmentType departmentType;
    private Doctor doctor;
    private Patient patient;
    private Date scheduledDate;
    //private Time scheduledTime;
    private int OTnumber;
    private int cost;
    
    public String getName(){
        return this.name;
    }
    
    public long getSurgeryId(){
        return this.surgeryId;
    }
    
    public DepartmentType getDepartmentType(){
        return this.departmentType;
    }
    
    public Doctor getDoctor(){
        return this.doctor;
    }
    
    public Patient getPatient(){
        return this.patient;
    }
    
    public Date getScheduledDate(){
        return this.scheduledDate;
    }
       
    /*public long getScheduledTime(){
        return this.scheduledTime;
    }*/
    
    public int getOTnumber(){
        return this.OTnumber;
    }
    
   public int getCost(){
        return this.cost;
    }
    
    private void setName(String name){
        this.name=name;
    }
    
    private void setDepartmentType(DepartmentType type){
        this.departmentType=type;
    }
    
    private void setDoctor(Doctor doctor){
        this.doctor=doctor;
    }
    
    private void setPatient(Patient patient){
        this.patient=patient;
    }
    
    private void setScheduledDate(Date date){
        this.scheduledDate=date;
    }
    
    /*private void setScheduledTime(Time time){
        this.scheduledTime=time;
    }*/
    
    private void setOTnumber(int otNumber){
        this.OTnumber=otNumber;
    }
    
    private void setCost(int c){
        this.cost=c;
    }
}

