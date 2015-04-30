/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package account;
import BasicDetails.Address;
import BasicDetails.Name;
import java.awt.Frame;
import java.util.Date;
import staff.*;
import patient.*;

/**
 *
 * @author Devanshu
 */
public class Accountant implements Staff{
    
    private int employeeId;
    private Name name;
    private Date dateOfBirth;
    private Long contactInfo;
    private Address address;
    private int salary;
    private Frame frame;
    
    private void addUI(){
        
    }
    @Override
    public void viewProfile(){
        
    }
    
    public void getBill(Bill bill){
        
    }
    
    public void getFunds(int amount){
        
    }
    
    private void updateBudget(Bill bill){
        
    }
    
    public int transfertoStaffAdmin(int amount){
        return 1;
    }
    
    public int transfertoInfraAdmin(int amount){
        return 1;
    }
    
}
