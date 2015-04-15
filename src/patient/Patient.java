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
    private Test test;
    private Appointment appointment;
    private Surgery surgery;
    
    public Name getName(){
        return name;
    }
    
    private void setName(Name name){
        this.name=name;
    }
    
    public Date getDateOfBirth(){
        return dateOfBirth;
    }
    
    private void setDateOfBirth(Date date){
        this.dateOfBirth=date;
    }
    
    public Gender getGender(){
        return gender;
    }
    
    private void setGender(Gender gender){
        this.gender=gender;
    }
    
    public long getContactInfo(){
        return contactInfo;
    }
    
    private void setContactInfo(long contact){
        this.contactInfo=contact;
    }
    
    public long getRegistrationId(){
        return registrationId;
    }
    
    public Address getAddress(){
        return address;
    }
    
    private void setAddress(Address address){
        this.address=address;
    }
    
    private void addBill(Bill newBill){
        
    }
    
    private void removeBill(Bill oldBill){
        
    }
    
    public PatientRecord getPatientRecord(){
        return patientRecord;
    }
    
    void updatePatientRecord(PatientRecord patientRecord){
        
    }
    
    void updatePatientRecord(Appointment appointment){
        
    }
    
    void updatePatientRecord(Test test){
        
    }
    
}
