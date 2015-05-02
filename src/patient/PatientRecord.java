/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patient;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static login.LogIn.con;
import staff.*;

/**
 *
 * @author Mansi Verma
 */
public class PatientRecord {
    
    private BloodGroup bloodGroup;
    private int Registrationid;
    private int PatientId;
    private DepartmentType departmentType;
    int doctorId ;
    private int wardNumber;
    ArrayList<Surgery> surgeries;
    // ArrayList<Medicine> medicines;
    ArrayList<RadiologyTest> tests;
    ArrayList<Appointment> appointments;

    public PatientRecord(){
        PreparedStatement ps;
        try {
            ps=con.prepareStatement("insert into patientrecord values (0,0,null,null,0,0,null)");
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PatientRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public PatientRecord(BloodGroup bloodGroup, int PatientId, int Registrationid, DepartmentType departmentType, int doctorId, int wardNumber, String medicine) {
        this.bloodGroup = bloodGroup;
        this.PatientId=PatientId;
        this.Registrationid = Registrationid;
        this.departmentType = departmentType;
        this.doctorId = doctorId;
        this.wardNumber = wardNumber;
        PreparedStatement ps;
        try {
            PreparedStatement ps1=con.prepareStatement("select MAX(registrationid) from patientrecord");
            ResultSet rs1=ps1.executeQuery();
            int rid=Integer.parseInt(rs1.getString(1));
            System.out.println(rid);
            
            ps=con.prepareStatement("insert into patientrecord values (?,?,?,?,?,?,?)");
            ps.setString(1,""+rid);
            ps.setString(2,""+PatientId);
            ps.setString(3,bloodGroup.toString());
            ps.setString(4,departmentType.toString());
            ps.setString(5,""+doctorId);
            ps.setString(6,""+wardNumber);
            ps.setString(7,medicine);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PatientRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void updatePatientBloodGroup(BloodGroup bloodGroup){
        this.bloodGroup=bloodGroup;
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("update patientrecord set bloodgroup=? where registrationid=?");
            ps.setString(1, bloodGroup.toString());
            ps.setString(2, ""+this.Registrationid);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PatientRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateDepartmentType(DepartmentType departmentType){
        this.departmentType=departmentType;
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("update patientrecord set departmentname=? where registrationid=?");
            ps.setString(1, departmentType.toString());
            ps.setString(2, ""+this.Registrationid);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PatientRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateDoctorid(int doctorid){
        this.doctorId=doctorid;
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("update patientrecord set doctorid=? where registrationid=?");
            ps.setString(1, ""+doctorId);
            ps.setString(2, ""+this.Registrationid);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PatientRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updatePatientid(int patientid){
        this.PatientId=patientid;
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("update patientrecord set patientid=? where registrationid=?");
            ps.setString(1, ""+PatientId);
            ps.setString(2, ""+this.Registrationid);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PatientRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateWardNumber(int wardNumber){
        this.wardNumber=wardNumber;
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("update patientrecord set wardnumber=? where registrationid=?");
            ps.setString(1, ""+this.wardNumber);
            ps.setString(2, ""+this.Registrationid);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PatientRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public PatientRecord getPatientRecord(){
        return this.getPatientRecord();
    }
    
    public void addSurgey(Surgery surgery){
        
    }
    
    public void removeSurgey(Surgery surgery){
        
    }
    
    public void addTest(RadiologyTest test){
        
    }
    
    public void removeTest(RadiologyTest test){
        
    }
    
    public void addMedicine(String medicine){ //medicine
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("update patientrecord set medicine=? where registrationid=?");
            ps.setString(1, medicine);
            ps.setString(2, ""+this.Registrationid);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PatientRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void removeMedicine(){ //medicine
        
    }
      
}
