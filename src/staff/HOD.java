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
import patient.Patient;

/**
 *
 * @author Mansi Verma
 */
public class HOD implements Staff{
    
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
    
    public void viewAppointments(Doctor doctor){
        
    }
    public void checkSchedule(Doctor doctor,Date date){
        
    }
    public void updatePatientRecord(Patient patient){
        
    }
    public void forwardPatientRecord(Doctor doctor, Patient patient){
    }
    
    public void viewScheduledSurgeries(Doctor doctor, Date date){
        
    }
    
    public void scheduleSurgeries(){
        
    }
    public void viewOtherDoctorDetails(Doctor doctor){
        
    }
    public void notifyDoctors(){
        
    }
}
