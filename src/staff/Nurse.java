/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staff;

import BasicDetails.Address;
import BasicDetails.Name;

import java.awt.Component;
import BasicLayout.BasicLayout;
import com.mysql.jdbc.ResultSet;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextField;
import patient.*;
import static login.LogIn.con;

/**
 *
 * @author Mansi Verma
 */
public class Nurse implements Staff{
    
    private int employeeId;
    private Name name;
    private Date dateOfBirth;
    private Long contactInfo;
    private Address address;
    private int salary;
    private Frame frame;
    private Date dateOfAppointment;
    private JPanel jFunction;
    private Component cp;
    private JPanel right;
    private JPanel left;
    
    public Nurse(int employeeId){
        this.employeeId=employeeId;
    }

    @Override
    public void viewProfile()
    {
        
        try{ //To change body of generated methods, choose Tools | Templates.
        
            PreparedStatement ps=con.prepareStatement("select * from nurse where employeeid =?");
            ps.setString(1, ""+employeeId);
            System.out.println(employeeId);
            //ps.setString(1, Integer.toString(employeeId));
            java.sql.ResultSet rs = ps.executeQuery();
            
            JPanel jp=new JPanel(new GridLayout(12,1,4,4));
            jp.setBackground(Color.pink);
            while(rs.next()) {
                JLabel jname = new JLabel("Name: "+rs.getString("name"));
                JLabel jdob = new JLabel("DOB: "+ rs.getString("dob"));
                JLabel jcontactinfo = new JLabel("Contact info:" +rs.getString("contactinfo"));
                JLabel jaddress = new JLabel("Address: "+rs.getString("address"));
                
                JLabel jsalary = new JLabel("Salary: "+rs.getString("salary"));
                JLabel jdateofAppointment = new JLabel("Date of Appointment: "+rs.getString("dateofAppointment"));
               
                JLabel jshiftdate = new JLabel("Shift Date: "+rs.getString("shiftdate"));
                JLabel jshifttime= new JLabel("Shift Time: "+rs.getString("shifttime"));
                
                jp.add(jname);  
                jp.add(jdob); 
                jp.add(jcontactinfo); 
                jp.add(jaddress); 
                
                jp.add(jsalary); 
                jp.add(jdateofAppointment);
                jp.add(jshiftdate);
                jp.add(jshifttime);
               
                
        }
            //JPanel right= new JPanel();
            right.removeAll();
            right.add(jp);
            right.revalidate();
            right.repaint();
            
        }
        catch(SQLException ex){
            Logger.getLogger(Nurse.class.getName()).log(Level.SEVERE,null,ex);
        }
         
    }
    
    public void addUI(){
        JButton viewPro= new JButton("View Profile");
        JButton updatePatientRec= new JButton("Update Patient Record");
        //updatePatientRec.setPreferredSize(new Dimension(50,50));
        JButton viewPatientRec= new JButton("View Patient Record");
        
        JButton checkAssignedDuty = new JButton("Check Assigned Duty");
        
        BasicLayout basicLayout= new BasicLayout();
        basicLayout.addUI();
        
        left= new JPanel(new GridLayout(10,1, 4,4 ));
     
        right= new JPanel();

        right.setBackground(Color.PINK);
        jFunction = basicLayout.getFunctions();
        
        jFunction.setLayout(new GridLayout(1,2,4,4));
         
        left.add(updatePatientRec);
       
        left.add(viewPatientRec);
        left.add(checkAssignedDuty);
        left.add(viewPro);
        
        jFunction.add(left);
        jFunction.add(right);
        
        updatePatientRec.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                updatePatientRecord(null);
            }
        } );
        
        viewPatientRec.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                viewPatientRecord(null);
            }
        });
        
        checkAssignedDuty.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                checkAssignedDuty(null);
            }
        });
        
        viewPro.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                viewProfile();
            }
        });
    }
    
    JTextField registrationidField,bloodgroupField,wardnumberField,medicineField,departmentnameField;
    public void updatePatientRecord(Patient patient){
        
        
        JPanel form= new JPanel(new GridLayout(10,1,4,4 ));
        form.setBackground(Color.PINK);
        
        JLabel registrationidLabel= new JLabel("Registration ID:");
        
        registrationidField= new JTextField();
        registrationidField.setText("-");
        form.add(registrationidLabel);
        form.add(registrationidField);
        
        JLabel bloodgroupLabel= new JLabel("Blood Group:");
        
        bloodgroupField= new JTextField();
        bloodgroupField.setText("-");
        form.add(bloodgroupLabel);
        form.add(bloodgroupField);

        JButton submit=new JButton("Submit");
        form.add(submit);
        
        submit.addActionListener(new ActionListener() { 
        @Override
        public void actionPerformed(ActionEvent e) { 
            try {
            PreparedStatement ps;
            if(!bloodgroupField.getText().equalsIgnoreCase("")){
                
                ps = con.prepareStatement("update patientrecord set bloodgroup = ? where registrationid=?");
                ps.setString(1, bloodgroupField.getText());
                ps.setString(2, registrationidField.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(cp,"Patient record updated");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Nurse.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        }
        } );
        
        right.removeAll();
        right.add(form);
        right.revalidate();
        right.repaint();
        
        
    }
    public void viewPatientRecord(Patient patient){
          
        final JPanel form= new JPanel(new GridLayout(10,1,4,4 ));
        final JPanel display= new JPanel(new GridLayout(10,1,4,4 ));
        form.setBackground(Color.PINK);
        display.setBackground(Color.PINK);
        
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
            if(!registrationidField.getText().equals("")){
                
                ps = con.prepareStatement("select * from patientrecord where registrationid=?");
                ps.setString(1, registrationidField.getText());
                java.sql.ResultSet rs = ps.executeQuery();
                
                while(rs.next()) {
                //JLabel jregistrationid = new JLabel("Registration Id: "+rs.getString("registrationid"));
                JLabel jpatientid= new JLabel("Patient Id: "+rs.getString("patientid"));
                JLabel jbloodgroup = new JLabel("Blood Group: "+rs.getString("bloodgroup"));
                JLabel jdepartmentname= new JLabel("Department Name: "+rs.getString("departmentname"));
                JLabel jdoctorid = new JLabel("Ward Number: "+rs.getString("wardnumber"));
                JLabel jmedicine= new JLabel("Medicines: "+rs.getString("medicine"));
                
                //jp.add(jregistrationid); 
                
                display.add(jpatientid); 
                display.add(jbloodgroup);
                display.add(jdepartmentname); 
                display.add(jdoctorid); 
                display.add(jmedicine); 
                
            right.removeAll();
            right.add(display);
            right.revalidate();
            right.repaint();
            
            }
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(Nurse.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        }
        } );
            
    }
    public void checkAssignedDuty(Date date){
        try{
            PreparedStatement ps=con.prepareStatement("select shiftdate,shifttime from nurse where employeeid =?");
            ps.setString(1, ""+employeeId);
            //System.out.println(employeeId);
            //ps.setString(1, Integer.toString(employeeId));
            java.sql.ResultSet rs = ps.executeQuery();
            JPanel jp=new JPanel(new GridLayout(12,1,4,4));
            jp.setBackground(Color.pink);
            while(rs.next()) {
                JLabel jshiftdate = new JLabel("Shift Date: "+rs.getString("shiftdate"));
                JLabel jshifttime= new JLabel("Shift Time: "+rs.getString("shifttime"));
                
                jp.add(jshiftdate);  
                jp.add(jshifttime); 
            
            }
            right.removeAll();
            right.add(jp);
            right.revalidate();
            right.repaint();
            
        }catch(SQLException ex){
            Logger.getLogger(Nurse.class.getName()).log(Level.SEVERE,null,ex);
        }
            
   
    }
    
}
