/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staff;

import BasicDetails.Address;
import BasicDetails.Name;
import java.util.Date;

/**
 *
 * @author Mansi Verma
 */
public class StaffFactory {
    
    private String staffType;
    private int employeeId;
    private Name name;
    private Date dateOfBirth;
    private Long contactInfo;
    private Address address;
    private int salary;
    private Date dateOfAppointment;
    
    public StaffFactory(String staffType/*,int employeeId, Name name,Date dateOfBirth,Long contactInfo,
            Address address, int salary, Date dateOfAppointment*/){
        this.staffType=staffType;
        if( staffType.equals(StaffType.RECEPTIONIST.getStaffType())){
            addReceptionist();        
        }
        else if( staffType.equals(StaffType.STAFFADMIN.getStaffType())){
            addStaffAdmin();        
        }
        else if(staffType.equals(StaffType.DOCTOR.getStaffType())){
            addDoctor();    
        }
        else if(staffType.equals(StaffType.WARDBOY.getStaffType())){
            addWardBoy();    
        }
        else if(staffType.equals(StaffType.NURSE.getStaffType())){
            addNurse();    
        }
        else if(staffType.equals(StaffType.DEPARTMENTADMIN.getStaffType())){
            addDepartmentAdmin();    
        }
        else if(staffType.equals(StaffType.HOD.getStaffType())){
            promoteToHOD();
        }
        else{}
        //this.employeeId=employeeId;
        //this.name=name;
        //this.dateOfBirth=dateOfBirth;
        //this.contactInfo=contactInfo;
        //this.address=address;
        //this.salary=salary;
        //this.dateOfAppointment=dateOfAppointment;
    }
    
    public void addDoctor(){
        
    }
    public void addNurse(){
        
    }
    public void promoteToHOD(){
        
    }
    public void addWardBoy(){
        
    }
    public void addDepartmentAdmin(){
        
    }
    public void addStaffAdmin(){
        
    }
    public void addReceptionist(){
        
    }
}

