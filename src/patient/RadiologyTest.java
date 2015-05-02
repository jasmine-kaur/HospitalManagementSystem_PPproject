/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patient;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import staff.DepartmentType;
import staff.Doctor;
import static login.LogIn.con;
import org.jdatepicker.impl.JDatePickerImpl;
import staff.DepartmentType;
/**
 *
 * @author Mansi Verma
 */
public class RadiologyTest {
    
    private long testId;
    private int registrationId;
    private int doctorId;
    private int patientId;
    private String departmentType;
    private String testDate;
  

    public RadiologyTest(int registrationid,String check){
        this.registrationId=registrationid;
        
        try {
            PreparedStatement ps=con.prepareStatement("insert into radiologytestpatientrecord values(?,?,?,?,?,?)");
            ps.setString(1, ""+0);
            ps.setString(2, ""+registrationid);
            ps.setString(3, ""+0);
            ps.setString(4, ""+0);
            ps.setString(5, "");
            ps.setString(6, "1500-01-01");
           
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RadiologyTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public RadiologyTest(int registrationid){
        this.registrationId=registrationid;
    }
    public String getTestDate() {
        try {
            PreparedStatement ps=con.prepareStatement("select testdate from radiologytestpatientrecord where registrationid=?");
            ps.setString(1, ""+this.registrationId);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                this.testDate=rs.getString("testdate");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RadiologyTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return testDate;
    }

    
    
    
    public long getTestId() {
        try {
            PreparedStatement ps=con.prepareStatement("select testid from radiologytestpatientrecord where registrationid=?");
            ps.setString(1, ""+this.registrationId);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                this.testId=Integer.parseInt(rs.getString("testid"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RadiologyTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return testId;
    }

    
    public int getDoctorId() {
         try {
            PreparedStatement ps=con.prepareStatement("select doctorid from radiologytestpatientrecord where registrationid=?");
            ps.setString(1, ""+this.registrationId);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                this.doctorId=Integer.parseInt(rs.getString("doctorid"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RadiologyTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doctorId;
    }

    public int getPatientId() {
         try {
            PreparedStatement ps=con.prepareStatement("select patientid from radiologytestpatientrecord where registrationid=?");
            ps.setString(1, ""+this.registrationId);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                this.patientId=Integer.parseInt(rs.getString("patientid"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RadiologyTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return patientId;
    }

    public String getDepartmentType() {
         try {
            PreparedStatement ps=con.prepareStatement("select departmentname from radiologytestpatientrecord where registrationid=?");
            ps.setString(1, ""+this.registrationId);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                this.departmentType=rs.getString("departmentname");
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RadiologyTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return departmentType;
    }

    

   

    

    public void setTestId(long testId) {
        try {
            PreparedStatement ps=con.prepareStatement("update radiologytestpatientrecord set testid=? where registrationid=?");
            
            ps.setString(1, ""+testId);
            ps.setString(2,""+this.registrationId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RadiologyTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.testId=testId;
    }

    
    public void setDoctorId(int doctorId) {
        try {
            PreparedStatement ps=con.prepareStatement("update radiologytestpatientrecord set doctorid=? where registrationid=?");
            ps.setString(1, ""+doctorId);
            ps.setString(2,""+this.registrationId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RadiologyTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.doctorId = doctorId;
    }

    public void setPatientId(int patientId) {
        try {
            PreparedStatement ps=con.prepareStatement("update radiologytestpatientrecord set patientid=? where registrationid=?");
            ps.setString(1, ""+patientId);
            ps.setString(2,""+this.registrationId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RadiologyTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.patientId = patientId;
    }

    public void setDepartmentType(String departmentType) {
        try {
            PreparedStatement ps=con.prepareStatement("update radiologytestpatientrecord set departmentname=? where registrationid=?");
            ps.setString(1, departmentType);
            ps.setString(2,""+this.registrationId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RadiologyTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.departmentType = departmentType;
    }

    public void setTestDate(JDatePickerImpl datePicker) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                   Date scheduled_date_obj1=(Date)datePicker.getModel().getValue();
                  
                        String scheduled_date=dateFormat.format(scheduled_date_obj1);
            PreparedStatement ps=con.prepareStatement("update radiologytestpatientrecord set testdate=? where registrationid=?");
            ps.setString(1, scheduled_date);
            ps.setString(2,""+this.registrationId);
            ps.executeUpdate();
            this.testDate = scheduled_date;
        } catch (SQLException ex) {
            Logger.getLogger(RadiologyTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }


    
    
    
}
