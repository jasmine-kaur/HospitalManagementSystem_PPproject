/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patient;

import java.awt.GridLayout;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static login.LogIn.con;

/**
 *
 * @author Mansi Verma
 */
public class Bill {
   private int bill;
   private PatientRecord patientRecord;
   private double totalAmount;
   private String paymentStatus;
   String viewBill= new String();
   
   JPanel jp= new JPanel(new GridLayout(15,1,4,4));
   
   public Bill(){
       this.bill=0;
       this.jp=null;
       this.patientRecord=null;
       this.totalAmount=0;
       this.paymentStatus="false";
       
   }
   public Bill(int patientId){
        PreparedStatement ps, ps2;
        try {
            ps=con.prepareStatement("select * from patientrecord where patientid =?");
            ps.setString(1,""+patientId);
            
            ResultSet rs= ps.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    JLabel jregId = new JLabel("Registration Id: "+rs.getString("registrationid"));
                    JLabel jpatientId = new JLabel("Patient Id: "+ rs.getString("patientid"));
                    JLabel jbloodgroup = new JLabel("Blood Group:" +rs.getString("bloodgroup"));
                    JLabel jdepartmentname = new JLabel("Department Name: "+rs.getString("departmentname"));
                    JLabel jdoctorId = new JLabel("Doctor id: "+rs.getString("doctorid"));
                    JLabel jwardNumber = new JLabel("Ward Number: "+rs.getString("wardnumber"));
                    JLabel jmedicine = new JLabel("Medicine: "+rs.getString("medicine"));
                    
                    jp.add(jregId);  
                    jp.add(jpatientId); 
                    jp.add(jbloodgroup); 
                    jp.add(jdepartmentname); 
                    jp.add(jdoctorId); 
                    jp.add(jwardNumber);
                    jp.add(jmedicine);
                    viewBill="Registration id:"+rs.getString("registrationid")+"\nPatient Id:"+rs.getString("patientid")+"\nBlood Group:"+rs.getString("bloodgroup")+"\nDepartment Name:"+rs.getString("departmentname")+"\nDoctor Id:"+rs.getString("doctorid")+"\nWard Number:"+rs.getString("wardnumber")+"\nMedicine:"+rs.getString("medicine");
                }
            }
            JLabel separator= new JLabel("--------------------");
            jp.add(separator);
            ps2=con.prepareStatement("select bill from patient where patientid =?");
            ps2.setString(1,""+patientId);
            
            ResultSet rs1= ps2.executeQuery();
            if(rs1!=null){
                while(rs1.next()){
                    JLabel jbill = new JLabel("BILL: "+rs1.getString("bill"));
                    JTextField billField=new JTextField();
                    
                    this.bill=Integer.parseInt(rs1.getString("bill"));
                    viewBill+="\nBILL:"+this.bill;
                    jp.add(jbill);  
                    jp.add(billField);
                    billField.setText("Bill:"+rs1.getString("bill"));
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PatientRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
    
   public int generateBill(){
       return this.bill;
   }
    
   public String viewBill(){
       return this.viewBill;
   }
   public JPanel getBillPanel(){
       return this.jp;
   }
   
    public void updateBill(int patientid, Integer bill){
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("update patient set bill=? where patientid=?");
            ps.setString(1, ""+bill.toString());
            ps.setString(2, ""+patientid);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PatientRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
