/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package department;

import java.util.Date;
import java.awt.Frame;
import staff.*;
import infrastructure.*;
import BasicDetails.*;

/**
 *
 * @author Mansi Verma
 */
public class DepartmentAdmin implements Staff{
    
    private int employeeId;
    private Name name;
    private Date dateOfBirth;
    private Long contactInfo;
    private Address address;
    private int salary;
    private DepartmentType departmentName;
    private Frame frame;

    @Override
    public void viewProfile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void viewProfile(Staff staff){
        
    }
    
    private void addUI(){
        
    }
    public void doctorScheduling(){
        
    }
    public void callTenders(Tender tender){
        
    }
    public void viewEquipments(Equipment equipment){
        
    }
    public void sendFundRequestsToInfraAdmin(int amount){
        
    }
    ////should return BOOLEAN
    public void getFundApprovalFromInfraAdmin(){
        
    }
}
