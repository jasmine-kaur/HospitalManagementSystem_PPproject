/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staff;
import java.util.Date;
import java.awt.Frame;
import BasicDetails.*;
import BasicLayout.BasicLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static login.LogIn.con;


/**
 *
 * @author Mansi Verma
 */
public class StaffAdmin implements Staff{
    private int employeeId;
    private Name name;
    private Date dateOfBirth;
    private Long contactInfo;
    private Address address;
    private int salary;
    private Frame frame;
    BasicLayout basicLayout;
    private JPanel jFunction;
    private JPanel left;
    private JPanel right;
    private Component cp;
    private JTextField tf;

    public StaffAdmin(int employeeid){
        employeeId=employeeid;
    }
    /*public Staff getStaff(StaffType staffType){
        return null;
    }*/
    public void addUI(){
        basicLayout= new BasicLayout();
        basicLayout.addUI();
        jFunction = basicLayout.getFunctions();
        jFunction.setLayout(new GridLayout(1, 2,4,4));
        left= new JPanel(new GridLayout(10,1, 4,4 ));     
        right= new JPanel();     
        right.setBackground(Color.PINK);
        JButton jViewProfile= new JButton("View Profile");
        //jGenerateBill.setPreferredSize(new Dimension(50,50));
        JButton jAddNewStaff = new JButton("Add New Staff");
        JButton jScheduleNurseDuty= new JButton("Schedule Nurse Duty");
        JButton jWardBoyDuty = new JButton("Schedule Ward Boy Duty");
        JButton jViewStaffProfile = new JButton("View Staff Profile");
        JButton jUpgradeToHOD = new JButton("Upgrade to HOD");
        JButton jUpdateStaffProfile = new JButton("Update Staff Profile");
        JButton jViewDepartmentAdmins = new JButton("View Department Admins");
        left.add(jViewProfile);
        left.add(jAddNewStaff);
        left.add(jScheduleNurseDuty);
        left.add(jWardBoyDuty);
        left.add(jViewStaffProfile);
        left.add(jUpgradeToHOD);
        left.add(jUpdateStaffProfile);
        left.add(jViewDepartmentAdmins);
        jFunction.add(left);
        jFunction.add(right);
        jViewProfile.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                viewProfile();
            }
        } );
        jAddNewStaff.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                right.removeAll();
                JLabel l = new JLabel("Employee Type:");
                tf = new JTextField();
                JButton btn = new JButton("Submit");
                JPanel jp=new JPanel(new GridLayout(3,1,4,4));
                jp.add(l);
                jp.add(tf);
                jp.add(btn);
                right.add(jp);
                right.revalidate();
                right.repaint();
                btn.addActionListener(new ActionListener() { 
                    @Override
                    public void actionPerformed(ActionEvent e) { 
                        String str = tf.getText();
                        addNewStaff(str);
                    }
                 });
            }
        } );
        jScheduleNurseDuty.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                scheduleNurseDuty(new Nurse());
            }
        } );
        jWardBoyDuty.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                wardBoyDuty(new WardBoy());
            }
        } );
        jViewStaffProfile.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                right.removeAll();
                JLabel l = new JLabel("Employee ID:");
                tf = new JTextField();
                JButton btn = new JButton("Submit");
                JPanel jp=new JPanel(new GridLayout(3,1,4,4));
                jp.add(l);
                jp.add(tf);
                jp.add(btn);
                right.add(jp);
                right.revalidate();
                right.repaint();
                btn.addActionListener(new ActionListener() { 
                    @Override
                    public void actionPerformed(ActionEvent e) { 
                        String str = tf.getText();
                        viewStaffProfile(Integer.parseInt(str));
                    }
                 });
                
            }
        } );
        jUpgradeToHOD.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                upgradeToHOD(new Doctor());
            }
        } );
        jUpdateStaffProfile.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                updateStaffProfile(new Doctor());
            }
        } );
        jViewDepartmentAdmins.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                viewDepartmentAdmins();
            }
        } );
    }
    public void viewProfile(){
        JOptionPane.showMessageDialog(cp, "Viewing Profile");
        try {
            right.removeAll();
            PreparedStatement ps = con.prepareStatement("select * from staffadmin where employeeid=?");
            //System.out.println(employeeId);
            ps.setString(1, Integer.toString(employeeId));
            ResultSet rs = ps.executeQuery();
            JPanel jp=new JPanel(new GridLayout(6,1,4,4));
            jp.setBackground(Color.pink);
            while(rs.next()) {
                JLabel jl1 = new JLabel("Name: "+rs.getString("name"));
                JLabel jl2 = new JLabel("DOB: "+ rs.getString("dob"));
                JLabel jl3 = new JLabel("Contact info:" +rs.getString("contactinfo"));
                JLabel jl4 = new JLabel("Address: "+rs.getString("address"));
                JLabel jl5 = new JLabel("Salary: "+rs.getString("salary"));
                JLabel jl6 = new JLabel("Date of Appointment: "+rs.getString("dateofappointment"));
                jp.add(jl1);  
                jp.add(jl2); 
                jp.add(jl3); 
                jp.add(jl4); 
                jp.add(jl5); 
                jp.add(jl6); 
                
            }
            right.add(jp);
            right.revalidate();
            right.repaint();
            //System.out.println(rs.getString(2));
        } catch (SQLException ex) {
            Logger.getLogger(StaffAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addNewStaff(String staffType){
        JOptionPane.showMessageDialog(cp, "Adding New Staff");
        
    }
    public void scheduleNurseDuty(Nurse nurse){
        JOptionPane.showMessageDialog(cp, "Scheduling Nurse Duty");
    }
    public void wardBoyDuty(WardBoy wardBoy){
        JOptionPane.showMessageDialog(cp, "Scheduling Wardboy duty");
    }
    public void viewStaffProfile(int employeeid){
        try {
            
            JOptionPane.showMessageDialog(cp, "Viewing Staff Profile");
            PreparedStatement ps = con.prepareStatement("select * from login where employeeid=?");
            //System.out.println(employeeId);
            ps.setString(1, Integer.toString(employeeid));
            ResultSet rs = ps.executeQuery();
            String employeeType="";
            while(rs.next()){
                employeeType = rs.getString("employeetype");
            }
            if( employeeType.equals(StaffType.RECEPTIONIST.getStaffType())){
                viewReceptionistProfile(employeeid);    
            }
            else if( employeeType.equals(StaffType.STAFFADMIN.getStaffType())){
                viewStaffAdminProfile(employeeid);    
            }
            else if(employeeType.equals(StaffType.DOCTOR.getStaffType())){
                viewDoctorProfile(employeeid);
            }
            else if(employeeType.equals(StaffType.WARDBOY.getStaffType())){
                viewWardBoyProfile(employeeid);
            }
            else if(employeeType.equals(StaffType.NURSE.getStaffType())){
                viewNurseProfile(employeeid);
            }
            else if(employeeType.equals(StaffType.DEPARTMENTADMIN.getStaffType())){
                viewDepartmentAdminProfile(employeeid);
            }
            else{}
        } catch (SQLException ex) {
            Logger.getLogger(StaffAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void upgradeToHOD(Doctor doctor){
        JOptionPane.showMessageDialog(cp, "Upgrading to HOD");
    }
    public void updateStaffProfile(Staff staff){
        JOptionPane.showMessageDialog(cp, "Updating Staff Profile");
    }
    
    ///DepartmentType should be replaced by Department LATER
    public void viewDepartmentAdmins(){
        JOptionPane.showMessageDialog(cp, "Viewing Department Admins");
        try {
            
            right.removeAll();
            PreparedStatement ps = con.prepareStatement("select * from departmentadmin");
            //System.out.println(employeeId);
            //ps.setString(1, Integer.toString(employeeId));
            ResultSet rs = ps.executeQuery();
            ArrayList<JLabel> jl =new ArrayList<>();
            int count=1; 
            while(rs.next()) {
                jl.add(new JLabel(rs.getString("employeeid")));
                jl.add(new JLabel(rs.getString("name")));
                jl.add(new JLabel(rs.getString("dob")));
                jl.add(new JLabel(rs.getString("contactinfo")));
                jl.add(new JLabel(rs.getString("address")));
                jl.add(new JLabel(rs.getString("salary")));
                jl.add(new JLabel(rs.getString("dateofappointment")));
                count++; 
                               
            }
            JPanel jp;
            jp=new JPanel();
            jp.setLayout(new GridLayout(count,7,0,0));
            jp.setBackground(Color.pink);
            jp.add(new JLabel("employeeid"));
            jp.add(new JLabel("name"));
            jp.add(new JLabel("dob"));
            jp.add(new JLabel("contactinfo"));
            jp.add(new JLabel("address"));
            jp.add(new JLabel("salary"));
            jp.add(new JLabel("dateofappointment"));
            for(int i=0;i<jl.size();i++){
                jp.add(jl.get(i));
            }
            right.removeAll();
            right.add(jp);
            right.revalidate();
            right.repaint();
        } catch (SQLException ex) {
            Logger.getLogger(StaffAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void viewReceptionistProfile(int employeeid) {
        try{
            right.removeAll();
            PreparedStatement ps = con.prepareStatement("select employeeid,name,dob,contactinfo,address,salary,dateofappointment,shiftdate,shifttime from receptionist where employeeid =?");
          
            ps.setString(1, ""+employeeid);
            
           // execute the query, and get a java resultset
            ResultSet rs = ps.executeQuery();

         // iterate through the java resultset
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
            right.add(jp, BorderLayout.CENTER);
            right.revalidate();
            right.repaint();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public void viewDoctorProfile(int employeeid) {
        //JOptionPane.showMessageDialog(cp, "view Profile");
        try {
            
            right.removeAll();
            PreparedStatement ps=con.prepareStatement("select name, dob ,contactinfo, address , departmentname , salary , dateofappointment, qualification, practicestartyear , shiftdate , shifttime , departmentsenioritynumber from doctor where employeeid=?");
           ps.setString(1, ""+employeeid);
           ResultSet rs = ps.executeQuery();

            JPanel jp=new JPanel(new GridLayout(12,1,4,4));
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
                JLabel jl10 = new JLabel("Shift Date: "+rs.getString("shiftdate"));
                JLabel jl11 = new JLabel("Shift Time: "+rs.getString("shifttime"));
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
                jp.add(jl10);
                jp.add(jl11);
                jp.add(jl12); 
                
        }
          right.add(jp);
          right.revalidate();
          right.repaint();      
            
        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
    public void viewWardBoyProfile(int employeeid) {
        
         //JOptionPane.showMessageDialog(cp, "view Profile");
        try {
           
           right.removeAll();
           PreparedStatement ps=con.prepareStatement("select * from wardboy where employeeid=?");
           ps.setString(1, Integer.toString(employeeid));
           ResultSet rs = ps.executeQuery();

            JPanel jp=new JPanel(new GridLayout(12,1,4,4));
            jp.setBackground(Color.pink);
            while(rs.next()) {
                JLabel jl1 = new JLabel("Name: "+rs.getString("name"));
                JLabel jl2 = new JLabel("DOB: "+ rs.getString("dob"));
                JLabel jl3 = new JLabel("Contact info:" +rs.getString("contactinfo"));
                JLabel jl4 = new JLabel("Address: "+rs.getString("address"));
                JLabel jl5 = new JLabel("Salary: "+rs.getString("salary"));
                JLabel jl6 = new JLabel("Date of Appointment: "+rs.getString("dateofAppointment"));
                JLabel jl7 = new JLabel("Shift Date: "+rs.getString("shiftdate"));
                JLabel jl8 = new JLabel("Shift Time: "+rs.getString("shifttime"));
 
                jp.add(jl1); 
                jp.add(jl2);
               jp.add(jl3);
                jp.add(jl4);
                jp.add(jl5);
                jp.add(jl6);
               jp.add(jl7);
               jp.add(jl8);
               
        }
          right.add(jp);
          right.revalidate();
          right.repaint();     
           
        } catch (SQLException ex) {
            Logger.getLogger(WardBoy.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    public void viewDepartmentAdminProfile(int employeeid){
        
        //JOptionPane.showMessageDialog(cp, "view Profile");
        try {
           
           right.removeAll();
           PreparedStatement ps=con.prepareStatement("select * from departmentadmin where employeeid=?");
           ps.setString(1, Integer.toString(employeeid));
           ResultSet rs = ps.executeQuery();

            JPanel jp=new JPanel(new GridLayout(12,1,4,4));
            jp.setBackground(Color.pink);
            while(rs.next()) {
                JLabel jl1 = new JLabel("Name: "+rs.getString("name"));
                JLabel jl2 = new JLabel("DOB: "+ rs.getString("dob"));
                JLabel jl3 = new JLabel("Contact info:" +rs.getString("contactinfo"));
                JLabel jl4 = new JLabel("Address: "+rs.getString("address"));
                JLabel jl5 = new JLabel("Salary: "+rs.getString("salary"));
                JLabel jl6 = new JLabel("Date of Appointment: "+rs.getString("dateofAppointment"));
             
 
                jp.add(jl1); 
                jp.add(jl2);
                jp.add(jl3);
                jp.add(jl4);
                jp.add(jl5);
                jp.add(jl6);
              
               
        }
          right.add(jp);
          right.revalidate();
          right.repaint();     
           
        } catch (SQLException ex) {
            Logger.getLogger(WardBoy.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void viewNurseProfile(int employeeid) {
        //JOptionPane.showMessageDialog(cp,"Viewing Profile");
        try{ //To change body of generated methods, choose Tools | Templates.
        
            right.removeAll();
            PreparedStatement ps=con.prepareStatement("select * from nurse where employeeid =?");
            ps.setString(1, ""+employeeid);
            //System.out.println(employeeid);
            //ps.setString(1, Integer.toString(employeeId));
            java.sql.ResultSet rs = ps.executeQuery();
            
            //System.out.println(rs.getString(2));
            
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
            right.add(jp);
            right.revalidate();
            right.repaint();
            
        }
        catch(SQLException ex){
            Logger.getLogger(Nurse.class.getName()).log(Level.SEVERE,null,ex);
        }
         
    }
    
    public void viewStaffAdminProfile(int employeeid){
        //JOptionPane.showMessageDialog(cp, "Viewing Profile");
        try {
            right.removeAll();
            PreparedStatement ps = con.prepareStatement("select * from staffadmin where employeeid=?");
            //System.out.println(employeeId);
            ps.setString(1, Integer.toString(employeeid));
            ResultSet rs = ps.executeQuery();
            JPanel jp=new JPanel(new GridLayout(6,1,4,4));
            jp.setBackground(Color.pink);
            while(rs.next()) {
                JLabel jl1 = new JLabel("Name: "+rs.getString("name"));
                JLabel jl2 = new JLabel("DOB: "+ rs.getString("dob"));
                JLabel jl3 = new JLabel("Contact info:" +rs.getString("contactinfo"));
                JLabel jl4 = new JLabel("Address: "+rs.getString("address"));
                JLabel jl5 = new JLabel("Salary: "+rs.getString("salary"));
                JLabel jl6 = new JLabel("Date of Appointment: "+rs.getString("dateofappointment"));
                jp.add(jl1);  
                jp.add(jl2); 
                jp.add(jl3); 
                jp.add(jl4); 
                jp.add(jl5); 
                jp.add(jl6); 
                
            }
            right.add(jp);
            right.revalidate();
            right.repaint();
            //System.out.println(rs.getString(2));
        } catch (SQLException ex) {
            Logger.getLogger(StaffAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
