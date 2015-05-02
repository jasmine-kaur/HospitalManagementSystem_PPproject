/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staff;

import BasicDetails.Address;
import BasicDetails.Name;
import java.awt.Frame;
import patient.*;
import java.awt.Component;
import BasicLayout.BasicLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static login.LogIn.con;
import patient.PatientRecord;
/**
 *
 * @author Mansi Verma
 */
public class Doctor implements Staff{
    private int employeeId;
    private Name name;
    private Date dateOfBirth;
    private Long contactInfo;
    private Address address;
    private int salary;
    private Frame frame;
    private DepartmentType departmentName;
    private JPanel jFunction;
    private JPanel left;
    public JPanel right;
    BasicLayout basicLayout;
    private Component cp;
    private JTextField registrationidField, doctoridField, bloodgroupField, wardnumberField, medicineField, departmentnameField;

    @Override
    public void viewProfile() {
        JOptionPane.showMessageDialog(cp, "view Profile");
        System.out.println(employeeId);
        try {
            
            
            PreparedStatement ps=con.prepareStatement("select name, dob ,contactinfo, address , departmentname , salary , dateofappointment, qualification, practicestartyear , departmentsenioritynumber from doctor where employeeid=?");
            ps.setString(1, ""+employeeId);
            ResultSet rs = ps.executeQuery();

            JPanel jp=new JPanel(new GridLayout(10,1,4,4));
            jp.setBackground(Color.pink);
            while(rs.next()) {
                
                JLabel jl1 = new JLabel("Name: "+rs.getString("name"));
                JLabel jl2 = new JLabel("DOB: "+ rs.getString("dob"));
                JLabel jl3 = new JLabel("Contact info:" +rs.getString("contactinfo"));
                JLabel jl4 = new JLabel("Address: "+rs.getString("address"));
                JLabel jl5 = new JLabel("Department Name: " +rs.getString("departmentname"));
                JLabel jl6 = new JLabel("Salary: "+rs.getString("salary"));
                JLabel jl7 = new JLabel("Date of Appointment: "+rs.getString("dateofAppointment"));
                JLabel jl8 = new JLabel("Qualification: "+rs.getString("qualification"));
                JLabel jl9 = new JLabel("Practice Start year: " +rs.getString("practicestartyear"));
                JLabel jl12 = new JLabel("Department Seniority Number: "+rs.getString("departmentsenioritynumber"));
                jp.add(jl1);  
                jp.add(jl2); 
                jp.add(jl3); 
                jp.add(jl4); 
                jp.add(jl5); 
                jp.add(jl6); 
                jp.add(jl7);
                jp.add(jl8);
                jp.add(jl9);
                jp.add(jl12); 
                
            }
          
          right.removeAll();
          System.out.println("yes");
          right.add(jp);
          System.out.println("yes1");
          right.revalidate();
          System.out.println("yes2");
          right.repaint();
            
        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
   public Doctor(String employeeId){
        this.employeeId=Integer.parseInt(employeeId);
    }
    public void addUI(){
        
        JButton jviewProfile= new JButton("View Profile");
        JButton jViewAppointment= new JButton("View Appointments");
        JButton jcheckSchedule = new JButton("Check Schedule");
        JButton jupdatePatientRecord = new JButton("Update Patient Record");
        JButton jgetPatientRecord = new JButton("Get Patient Record");
        JButton jforwardPatientRecord = new JButton("Forward Patient Record");
        JButton jviewScheduledSurgeries = new JButton("View Scheduled Surgeries");
        basicLayout= new BasicLayout();
        basicLayout.addUI();
        
        left= new JPanel(new GridLayout(10,1, 4,4 ));
     
        right= new JPanel();
        
        try {
            PreparedStatement ps=con.prepareStatement("select * from notification where employeeid=?");
            ps.setString(1,""+employeeId);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                JLabel jl=new JLabel(rs.getString("message"));
                left.add(jl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
        right.setBackground(Color.PINK);
        jFunction = basicLayout.getFunctions();
        
        jFunction.setLayout(new GridLayout(1, 2,4,4));
         
        left.add(jviewProfile);
        left.add(jViewAppointment);
        left.add(jcheckSchedule);
        left.add(jupdatePatientRecord);
        left.add(jgetPatientRecord);
        left.add(jforwardPatientRecord);
        left.add(jviewScheduledSurgeries);
        
        
        jFunction.add(left);
        jFunction.add(right);
        
        jviewProfile.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                viewProfile();
            }
        } );
        jViewAppointment.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                viewAppointments();
            }
        } );
        jcheckSchedule.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                checkSchedule();
            }
        } );
        jgetPatientRecord.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                getPatientRecord(null);
            }
        } );
        jupdatePatientRecord.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                updatePatientRecord(null);
            }
        } );
        jforwardPatientRecord.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                forwardPatientRecord(null, null);
            }
        } );
        jviewScheduledSurgeries.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                viewScheduledSurgeries(null);
            }
        } );
        
    }
    
    public void viewAppointments(){
        JOptionPane.showMessageDialog(cp, "view Appointments");
        
        try {
            PreparedStatement ps=con.prepareStatement("select * from appointment where doctorid=?");
            ps.setString(1, ""+employeeId);
            ResultSet rs = ps.executeQuery();
            
            
            ArrayList<JLabel> jl =new ArrayList<>();
            int count=1; 
            while(rs.next()) {
                jl.add(new JLabel(rs.getString("patientid")));
                jl.add(new JLabel(rs.getString("appointmentdate")));
                jl.add(new JLabel(rs.getString("appointmenttime")));
                count++; 
                               
            }
            JPanel jp;
            jp=new JPanel();
            jp.setLayout(new GridLayout(count,3,4,4));
            jp.setBackground(Color.pink);
            jp.add(new JLabel("Patient ID"));
            jp.add(new JLabel("Appointment Date"));
            jp.add(new JLabel("Appointment Time"));
            for(int i=0;i<jl.size();i++){
                jp.add(jl.get(i));
            }
            right.removeAll();
            right.add(jp);
            right.revalidate();
            right.repaint();
        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void checkSchedule(){
        JOptionPane.showMessageDialog(cp, "check Schedule");
        try {
            
            
           PreparedStatement ps=con.prepareStatement("select shiftdate, shifttime from doctor where employeeid=?");
           ps.setString(1, ""+employeeId);
           ResultSet rs = ps.executeQuery();

            JPanel jp=new JPanel(new GridLayout(2,1,4,4));
            jp.setBackground(Color.pink);
            while(rs.next()) {
               
               JLabel jl10 = new JLabel("Shift Date: "+rs.getString("shiftdate"));
               JLabel jl11 = new JLabel("Shift Time: "+rs.getString("shifttime"));
                
              
               jp.add(jl10);
               jp.add(jl11);
                
                
        }
          right.removeAll();
          right.add(jp);
          right.revalidate();
          right.repaint();
            
        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    public void updatePatientRecord(Patient patient){
        JOptionPane.showMessageDialog(cp, "update patient Record");
        JPanel form= new JPanel(new GridLayout(10,1, 4,4 ));
        form.setBackground(Color.PINK);
        JLabel registrationidLabel= new JLabel("Registration ID:");
        registrationidField= new JTextField();
        form.add(registrationidLabel);
        form.add(registrationidField);
        JLabel bloodgroupLabel= new JLabel("Blood Group:");
        bloodgroupField= new JTextField();
        form.add(bloodgroupLabel);
        form.add(bloodgroupField);
        JLabel doctoridLabel= new JLabel("Doctor ID:");
        doctoridField= new JTextField();
        form.add(doctoridLabel);
        form.add(doctoridField);
        JLabel wardnumberLabel= new JLabel("Ward Number:");
        wardnumberField= new JTextField();
        form.add(wardnumberLabel);
        form.add(wardnumberField);
        JLabel medicineLabel= new JLabel("Medicine:");
        medicineField= new JTextField();
        form.add(medicineLabel);
        form.add(medicineField);
        
        JLabel departmentnameLabel= new JLabel("Department Name:");
        departmentnameField= new JTextField();
        form.add(departmentnameLabel);
        form.add(departmentnameField);
        JButton submit=new JButton("Submit");
        form.add(submit);
        
        
        submit.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                try {
                    PreparedStatement ps;
            if(Integer.parseInt(doctoridField.getText())==employeeId){
            if(!bloodgroupField.getText().equals("")){
                
                ps = con.prepareStatement("update patientrecord set bloodgroup = ? where registrationid=?");
                ps.setString(1, bloodgroupField.getText());
                ps.setString(2, registrationidField.getText());
                ps.executeUpdate();
            }
            if(!doctoridField.getText().equals("")){
                System.out.println("yes");
                ps = con.prepareStatement("update patientrecord set doctorid = ? where registrationid=?");
                ps.setString(1, doctoridField.getText());
                ps.setString(2, registrationidField.getText());
                ps.executeUpdate();
            }
            if(!wardnumberField.getText().equals("")){
                
                ps = con.prepareStatement("update patientrecord set wardnumber = ? where registrationid=?");
                ps.setString(1, wardnumberField.getText());
                ps.setString(2, registrationidField.getText());
                ps.executeUpdate();
            }
            if(!medicineField.getText().equals("")){
                
                ps = con.prepareStatement("update patientrecord set medicine = ? where registrationid=?");
                ps.setString(1, medicineField.getText());
                ps.setString(2, registrationidField.getText());
                ps.executeUpdate();
            }
            if(!departmentnameField.getText().equals("")){
                
                ps = con.prepareStatement("update patientrecord set departmentname = ? where registrationid=?");
                ps.setString(1, departmentnameField.getText());
                ps.setString(2, registrationidField.getText());
                ps.executeUpdate();
            }}
        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
          
            }
        } );
        right.removeAll();
        right.add(form);
        right.revalidate();
        right.repaint();
        
    }
    public void getPatientRecord(Patient patient){
        JOptionPane.showMessageDialog(cp, "get patient Record");
        JPanel form= new JPanel(new GridLayout(10,1, 4,4 ));
        form.setBackground(Color.PINK);
        JLabel registrationidLabel= new JLabel("Registration ID:");
        registrationidField= new JTextField();
        form.add(registrationidLabel);
        form.add(registrationidField);
        JButton submit=new JButton("Submit");
        form.add(submit);
        right.removeAll();
                right.add(form);
                right.revalidate();
                right.repaint();  
         submit.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                try {
                    PreparedStatement ps;
            
                
                ps = con.prepareStatement("select * from patientrecord where registrationid=? and doctorid=?");
                ps.setString(1, registrationidField.getText());
                ps.setString(2, ""+employeeId);
                ResultSet rs= ps.executeQuery();
                JPanel jp=new JPanel(new GridLayout(10,1,4,4));
            jp.setBackground(Color.pink);
                while(rs.next()) {
                JLabel jl1 = new JLabel("Registrationi ID: "+rs.getString("registrationid"));
                JLabel jl2 = new JLabel("Patient ID: "+ rs.getString("patientid"));
                JLabel jl3 = new JLabel("Blood Group:" +rs.getString("bloodgroup"));
                JLabel jl4 = new JLabel("Department Name: "+rs.getString("departmentname"));
                JLabel jl5 = new JLabel("Doctor ID: " +rs.getString("doctorid"));
                JLabel jl6 = new JLabel("Ward Number: "+rs.getString("wardnumber"));
                JLabel jl7 = new JLabel("Medicine: "+rs.getString("medicine"));
                jp.add(jl1);
                jp.add(jl2);
                jp.add(jl3);
                jp.add(jl4);
                jp.add(jl5);
                jp.add(jl6);
                jp.add(jl7);
                     
                right.removeAll();
                right.add(jp);
                right.revalidate();
                right.repaint();      
        }
          
            }catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
            }});
        
    }
    public void forwardPatientRecord(Doctor doctor, Patient patient){
        JOptionPane.showMessageDialog(cp, "forward patient Record");
        JPanel form= new JPanel(new GridLayout(10,1, 4,4 ));
        form.setBackground(Color.PINK);
        JLabel registrationidLabel= new JLabel("Registration ID:");
        registrationidField= new JTextField();
        form.add(registrationidLabel);
        form.add(registrationidField);
        JLabel doctoridLabel= new JLabel("Doctor ID:");
        doctoridField= new JTextField();
        form.add(doctoridLabel);
        form.add(doctoridField);
        JButton submit=new JButton("Submit");
        form.add(submit);
        
        
        submit.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                try {
                    PreparedStatement ps;
            
                
                ps = con.prepareStatement("select * from patientrecord where registrationid=?");
                ps.setString(1, registrationidField.getText());
                ResultSet rs=ps.executeQuery();
                while(rs.next()){
                    PreparedStatement ps1=con.prepareStatement("select MAX(registrationid) from patientrecord");
                    ResultSet rs1=ps1.executeQuery();
                    int rid=0;
                    while (rs1.next()){
                        rid=Integer.parseInt(rs1.getString(1));
                        System.out.println(rid);
                        PatientRecord pr=new PatientRecord();
                        
                        ps=con.prepareStatement("insert into patientrecord values (?,?,?,?,?,?,?)");
                        ps.setString(1, ""+(rid+1));
                        ps.setString(2, rs.getString("patientid"));
                        ps.setString(3, rs.getString("bloodgroup"));
                        PreparedStatement ps2=con.prepareStatement("select departmentname from doctor where employeeid=?");
                        ps2.setString(1,doctoridField.getText() );
                        ResultSet rs2=ps2.executeQuery();
                        while(rs2.next()){
                            ps.setString(4, rs2.getString(1));
                        }
                        
                        ps.setString(5, doctoridField.getText());
                        ps.setString(6, rs.getString("wardnumber"));
                        ps.setString(7, rs.getString("medicine"));
                        ps.executeUpdate();
                    }
                    
                }
           
        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
          
            }
        } );
        right.removeAll();
        right.add(form);
        right.revalidate();
        right.repaint();
    }
    public void viewScheduledSurgeries(Date date){
        JOptionPane.showMessageDialog(cp, "view Scheduled Surgeries");
        try {
            PreparedStatement ps=con.prepareStatement("select * from patientsurgery where doctorid=?");
            ps.setString(1, ""+employeeId);
            ResultSet rs = ps.executeQuery();
            
            
            ArrayList<JLabel> jl =new ArrayList<>();
            int count=1; 
            while(rs.next()) {
                jl.add(new JLabel(rs.getString("patientid")));
                jl.add(new JLabel(rs.getString("surgerydate")));
                jl.add(new JLabel(rs.getString("surgerytime")));
                jl.add(new JLabel(rs.getString("otnumber")));
                count++; 
                               
            }
            JPanel jp;
            jp=new JPanel();
            jp.setLayout(new GridLayout(count,4,4,4));
            jp.setBackground(Color.pink);
            jp.add(new JLabel("Patient ID"));
            jp.add(new JLabel("Surgery Date"));
            jp.add(new JLabel("Surgery Time"));
            jp.add(new JLabel("OT Number"));
            for(int i=0;i<jl.size();i++){
                jp.add(jl.get(i));
            }
            right.removeAll();
            right.add(jp);
            right.revalidate();
            right.repaint();
        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
