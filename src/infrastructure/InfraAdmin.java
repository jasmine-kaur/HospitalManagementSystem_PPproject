/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infrastructure;

import BasicDetails.Address;
import BasicDetails.Name;
import java.awt.Frame;
import java.util.Date;
import java.util.ArrayList;
import staff.*;

/**
 *
 * @author Mansi Verma
 */
public class InfraAdmin implements Staff{
    
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
    
    public void viewProfile(Staff staff){
        
    }
    
    public void receiveTender(Tender tender){
        
    }
    
    public void checkTenderForApproval(Tender tender){
        
    }
    
    public void sendApprovedTender(Tender tender){
        
    }
    
    public void generatePharmaceuticalTender(ArrayList<Medicine> al){
        
    }
    
    public void viewDepartmentInfrastructureDetail(DepartmentType department){ //Department
        
    }
    
    public void updateDepartmentInfrastructureDetail(DepartmentType department){ //Department
        
    }
    
}
