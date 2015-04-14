/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staff;

import BasicDetails.Address;
import BasicDetails.Name;
import java.awt.Frame;
import java.util.Date;
import patient.*;
/**
 *
 * @author Mansi Verma
 */
public class Doctor implements Staff{
    private int employeeId;
    private Name name;
    private Date dateOfBirth;
    private Long contactInfo;
    private Address address;
    private int salary;
    private Frame frame;
    private DepartmentType departmentName;
    
    @Override
    public void viewProfile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void addUI(){
        
    }
    
    public void viewAppointments(Date date){
        
    }
    public void checkSchedule(Date date){
        
    }
    public void updatePatientRecord(Patient patient){
        
    }
    public PatientRecord getPatientRecord(Patient patient){
        return null;
    }
    public void forwardPatientRecord(Doctor doctor, Patient patient){
        
    }
    public void viewScheduledSurgeries(Date date){
        
    }
    
}
