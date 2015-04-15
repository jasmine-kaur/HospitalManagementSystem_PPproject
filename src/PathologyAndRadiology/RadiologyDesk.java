/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PathologyAndRadiology;

import BasicDetails.Address;
import BasicDetails.Name;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.Date;
import patient.Patient;
import staff.*;
import patient.Test;

/**
 *
 * @author Devanshu
 */
public class RadiologyDesk implements Staff{
    
    private ArrayList<String> testsScheduled;
    private Name name;
    private Date dateOfBirth;
    private long contactInfo;
    private Address address;
    private int salary;
    private Frame frame;
    
    @Override
    public void viewProfile(){
        
    }
    
    private void addUI(){
        
    }
    
    public void updateTestDetails(){
        
    }
    
    public void addTestToList(Test test){
        
    }
    
    public void removeTestFromList(Test test){
        
    }
    
    public void updateTestRecordForPatient(Patient patient){
        
    }
    
}
