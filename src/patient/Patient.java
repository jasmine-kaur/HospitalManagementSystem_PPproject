/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patient;

import BasicDetails.*;
import staff.*;
import java.util.Date;

/**
 *
 * @author Mansi Verma
 */
public class Patient {
    
    private Name name;
    private Date dateOfBirth;
    private Gender gender;
    private long registrationId;
    private long contactInfo;
    private Address address;
    
    private PatientRecord patientRecord;
    private Bill bill;
    private RadiologyTest test;
    private Appointment appointment;
    private Surgery surgery;
    
    public Name getName(){
        return name;
    }
    
    public void setName(Name name){
        this.name=name;
    }
    
    public Date getDateOfBirth(){
        return dateOfBirth;
    }
    
    public void setDateOfBirth(Date date){
        this.dateOfBirth=date;
    }
    
    public Gender getGender(){
        return gender;
    }
    
    public void setGender(Gender gender){
        this.gender=gender;
    }
    
    public long getContactInfo(){
        return contactInfo;
    }
    
    public void setContactInfo(long contact){
        this.contactInfo=contact;
    }
    
    public long getRegistrationId(){
        return registrationId;
    }
    
    public Address getAddress(){
        return address;
    }
    
    public void setAddress(Address address){
        this.address=address;
    }
    
    private void addBill(Bill newBill){
        
    }
    
    private void removeBill(Bill oldBill){
        
    }
    
    public PatientRecord getPatientRecord(){
        return patientRecord;
    }
    
    private void updatePatientRecord(PatientRecord patientRecord){
        
    }
    
    private void updatePatientRecord(Appointment appointment){
        
    }
    
    private void updatePatientRecord(RadiologyTest test){
        
    }
    
    private void updatePatientRecord(Surgery surgery){
        
    }
    
    private void updatePatientRecord(int wardNumber){
        
    }
    
    private void updatePatientRecord(Doctor doctor){
        
    }
    
    private void updatePatientRecord(DepartmentType departmentType){
        
    }
    
    private void updatePatientRecord(BloodGroup bloodGroup){
        
    }
    
}
