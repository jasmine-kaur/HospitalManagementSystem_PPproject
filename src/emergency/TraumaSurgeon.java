/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergency;


import patient.Patient;
import staff.DepartmentType;
import staff.Staff;
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
public class TraumaSurgeon implements Staff{
    
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
    private JTextField registrationidField, messageField, doctoridField, bloodgroupField, wardnumberField, medicineField, departmentnameField;

    public TraumaSurgeon(String employeeId){
        this.employeeId=Integer.parseInt(employeeId);
    }
    @Override
    public void viewProfile() {
        JOptionPane.showMessageDialog(cp, "view Profile");
        System.out.println(employeeId);
        try {
            
            
            PreparedStatement ps=con.prepareStatement("select name, dob ,contactinfo, address , departmentname , salary , dateofappointment, qualification, practicestartyear , departmentsenioritynumber from traumasurgeon where employeeid=?");
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
            Logger.getLogger(TraumaSurgeon.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void addUI(){
        JButton jviewProfile= new JButton("View Profile");
        JButton jupdatePatientRecord = new JButton("Update Patient Record");
        JButton jviewPatientRecord = new JButton("View Patient Record");
        JButton jnotifyOtherDepartment = new JButton("Notify Other Departments");
        
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
            Logger.getLogger(TraumaSurgeon.class.getName()).log(Level.SEVERE, null, ex);
        }
        right.setBackground(Color.PINK);
        jFunction = basicLayout.getFunctions();
        
        jFunction.setLayout(new GridLayout(1, 2,4,4));
         
        left.add(jviewProfile);
       
        left.add(jupdatePatientRecord);
        left.add(jviewPatientRecord);
        left.add(jnotifyOtherDepartment);
       
        
        
        jFunction.add(left);
        jFunction.add(right);
        
        jviewProfile.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                viewProfile();
            }
        } );
        
        
        
        jupdatePatientRecord.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                updatePatientRecord(null);
            }
        } );
        jnotifyOtherDepartment.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                notifyOtherDepartments(null, null);
            }
        } );
        jviewPatientRecord.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                viewPatientRecord(null);
            }
        } );
        
        
    }
    
    public void notifyOtherDepartments(Patient patient, DepartmentType department){
        JOptionPane.showMessageDialog(cp, "notify other departments");
        
        JPanel form= new JPanel(new GridLayout(10,1, 4,4 ));
        form.setBackground(Color.PINK);
        JLabel departmentnameLabel= new JLabel("Department Type:");
        departmentnameField= new JTextField();
        form.add(departmentnameLabel);
        form.add(departmentnameField);
        JLabel messageLabel= new JLabel("Message:");
        messageField= new JTextField();
        form.add(messageLabel);
        form.add(messageField);
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
                PreparedStatement ps = con.prepareStatement("insert into departmentnotification values(?,?)");
                //System.out.println(doctoridField.getText());
                //System.out.println(doctoridField.getText());
                ps.setString(1,departmentnameField.getText());
                ps.setString(2, messageField.getText());
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(TraumaSurgeon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }});
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
            Logger.getLogger(TraumaSurgeon.class.getName()).log(Level.SEVERE, null, ex);
        }
          
            }
        } );
        right.removeAll();
        right.add(form);
        right.revalidate();
        right.repaint();
    }
    
    public void viewPatientRecord(Patient patient){
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
            Logger.getLogger(TraumaSurgeon.class.getName()).log(Level.SEVERE, null, ex);
        }
            }});
    }
    
}
