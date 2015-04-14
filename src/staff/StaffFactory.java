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
    
    private StaffType staffType;
    private int employeeId;
    private Name name;
    private Date dateOfBirth;
    private Long contactInfo;
    private Address address;
    private int salary;
    private Date dateOfAppointment;
    
    public StaffFactory(StaffType staffType,int employeeId, Name name,Date dateOfBirth,Long contactInfo,
            Address address, int salary, Date dateOfAppointment){
        this.staffType=staffType;
        this.employeeId=employeeId;
        this.name=name;
        this.dateOfBirth=dateOfBirth;
        this.contactInfo=contactInfo;
        this.address=address;
        this.salary=salary;
        this.dateOfAppointment=dateOfAppointment;
    }
    
    public void addDoctor(){
        
    }
    public void addNurse(){
        
    }
    public void promoteToHOD(Doctor doctor){
        
    }
    public void createWardBoy(){
        
    }
}

