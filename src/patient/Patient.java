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
    private String dateOfBirth;
    private String gender;
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
    
    public String getDateOfBirth(){
        return dateOfBirth;
    }
    
    public void setDateOfBirth(String date){
        this.dateOfBirth=date;
    }
    
    public String getGender(){
        return gender;
    }
    
    public void setGender(String gender){
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
    
    public void setRegistrationId(int registrationId){
        this.registrationId= registrationId;
    }
    
    public Address getAddress(){
        return address;
    }
    
    public void setAddress(Address address){
        this.address=address;
    }
    
    
    
    public PatientRecord getPatientRecord(){
        return patientRecord;
    }
    
    public void updatePatientRecord(PatientRecord patientRecord){
        this.patientRecord= patientRecord;
    }
    
    public void updatePatientRecord(int patientid){
        patientRecord.updatePatientid(patientid);
    }
    
 
    
    public void updatePatientRecordDoctor(int doctorid){
        this.patientRecord.updateDoctorid(doctorid);
    }
    
    public void updatePatientRecord(DepartmentType departmentType){
        this.patientRecord.updateDepartmentType(departmentType);
    }
    
    public void updatePatientRecord(BloodGroup bloodGroup){
        this.patientRecord.updatePatientBloodGroup(bloodGroup);
    }

   public String toString(){
       return this.getName().toString()+this.getAddress().toString()+this.getContactInfo()+this.getDateOfBirth()+this.getGender()+this.getRegistrationId();
   }
}
