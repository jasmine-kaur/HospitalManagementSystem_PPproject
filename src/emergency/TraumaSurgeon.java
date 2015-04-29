/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergency;

import BasicDetails.Address;
import BasicDetails.Name;
import java.awt.Frame;
import java.util.Date;
import patient.Patient;
import staff.DepartmentType;
import staff.Staff;

/**
 *
 * @author Mansi Verma
 */
public class TraumaSurgeon implements Staff{
    
    private int employeeId;
    private Name name;
    private Date dateOfBirth;
    private Long contactInfo;
    private Address address;
    private int salary;
    private Frame frame;
    
    @Override
    public void viewProfile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void addUI(){
        
    }
    
    public void notifyOtherDepartments(Patient patient){
        
    }
    
    public DepartmentType department(){
        return null;
    }
    
    public void updatePatientRecord(Patient patient){
        
    }
    
    public void viewPatientRecord(Patient patient){
        
    }
    
}
