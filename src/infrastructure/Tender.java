/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infrastructure;

import staff.*;
import BasicDetails.*;
import java.util.ArrayList;

/**
 *
 * @author Mansi Verma
 */
public class Tender {
    
    private long tenderId;
    private DepartmentType departmentType;
    private int tenderAmountLimit;
    private ArrayList<Equipment> equipments; 
    private Name departmentAdmin;
    private String tenderStatus;
    private int tenderAmount;
    
    public long getTenderId(){
        return tenderId;
    }
    
    public DepartmentType getDepartmentType(){
        return departmentType;
        
    }
    
    public int getTenderAmountLimit(){
        return tenderAmountLimit;
    }
    
    public void openTender(){
        
    }
    
    public void closeTender(){
        
    }
    
    public void selectTender(){
        
    }
    
    public void sendTenderToInfraAdmin(){
        
    }
    
    public void checkTenderForApproval(){
        
    }
    
    public void receiveApprovedTender(){
        
    }
}
