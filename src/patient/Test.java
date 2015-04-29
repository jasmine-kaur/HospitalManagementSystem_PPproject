/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patient;

import java.util.Date;
import staff.DepartmentType;
import staff.Doctor;

/**
 *
 * @author Mansi Verma
 */
public class Test {
    
    private String testName;
    private long testId;
    private String testType;
    private Doctor doctor;
    private Patient patient;
    DepartmentType departmentType;
    private int cost;
    private String result;
    
    public String getTestName(){
        return this.testName;
    }
    
    public long getTestId(){
        return this.testId;
    }
    
    public String getTestType(){
        return this.testType;
    }
    
    public Doctor getDoctor(){
        return this.doctor;
    }
    
    public Patient getPatient(){
        return this.patient;
    }
    
    public DepartmentType getDepartmentType(){
        return this.departmentType;
    }

    
   public int getCost(){
        return this.cost;
    }
    
    private void setTestName(String name){
        this.testName=name;
    }
    
    private void setDepartmentType(DepartmentType type){
        this.departmentType=type;
    }
    
    private void setDoctor(Doctor doctor){
        this.doctor=doctor;
    }
    
    private void setPatient(Patient patient){
        this.patient=patient;
    }
     
    private void setCost(int c){
        this.cost=c;
    }
    
    private void setResult(String res){
        this.result=res;
    }
    
}
