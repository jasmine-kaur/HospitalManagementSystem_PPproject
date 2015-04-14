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
public class Nurse implements Staff{
     private int employeeId;
    private Name name;
    private Date dateOfBirth;
    private Long contactInfo;
    private Address address;
    private int salary;
    private Frame frame;
    private Date dateOfAppointment;

    @Override
    public void viewProfile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void addUI(){
        
    }
    
    public void updatePatientRecord(Patient patient){
        
    }
    public void viewPatientRecord(Patient patient){
        
    }
    public void checkAssignedDuty(Date date){
        
    }
    
}
