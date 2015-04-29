/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package department;

import java.util.Date;
import java.awt.Frame;
import staff.*;
import infrastructure.*;
import BasicDetails.*;
import patient.*;

/**
 *
 * @author Devanshu
 */
public class WardCareTaker implements Staff{
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
    
    public void checkWardAvailability(){
        
    }
    
    public void assignWard(Patient patient){
        
    }
}
