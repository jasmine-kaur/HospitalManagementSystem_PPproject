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

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static login.LogIn.con;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;


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
    private String employeeType;

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
        JButton jScheduleWardBoyDuty = new JButton("Schedule Ward Boy Duty");
        JButton jScheduleReceptionistDuty = new JButton("Schedule Receptionist Duty");
        JButton jViewStaffProfile = new JButton("View Staff Profile");
        JButton jUpgradeToHOD = new JButton("Upgrade to HOD");
        JButton jUpdateStaffProfile = new JButton("Update Staff Profile");
        JButton jViewDepartmentAdmins = new JButton("View Department Admins");
        JButton jViewNurse = new JButton("View Nurse");
        JButton jViewWardBoy = new JButton("View WardBoy");
        JButton jViewReceptionist = new JButton("View Receptionist");
        left.add(jViewProfile);
        left.add(jAddNewStaff);
        left.add(jScheduleNurseDuty);
        left.add(jScheduleWardBoyDuty);
        left.add(jScheduleReceptionistDuty);
        left.add(jViewStaffProfile);
        left.add(jUpgradeToHOD);
        left.add(jUpdateStaffProfile);
        left.add(jViewDepartmentAdmins);
        left.add(jViewNurse);
        left.add(jViewWardBoy);
        left.add(jViewReceptionist);
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
                //JComboBox list=new JComboBox();
                //list.addItem(StaffType.DOCTOR);
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
                scheduleNurseDuty();
            }
        } );
        jScheduleWardBoyDuty.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                scheduleWardBoyDuty();
            }
        } );
        jScheduleReceptionistDuty.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                scheduleReceptionistDuty();
            }
        } );
        jViewStaffProfile.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                right.removeAll();
                JLabel l = new JLabel("Employee ID:");
                tf = new JTextField();
                JButton btn = new JButton("Submit");
                JPanel jp=new JPanel(new GridLayout(1,3,4,4));
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
                upgradeToHOD();
            }
        } );
        jUpdateStaffProfile.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                updateStaffProfile();
            }
        } );
        jViewDepartmentAdmins.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                viewDepartmentAdmins();
            }
        } );
        jViewNurse.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                viewNurse();
            }
        } );
        jViewWardBoy.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                viewWardBoy();
            }
        } );
        jViewReceptionist.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                viewReceptionist();
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
        StaffFactory staffFactory=new StaffFactory(staffType);
        staffFactory.addStaff(right);
    }
    public void scheduleNurseDuty(){
        right.removeAll();
        JOptionPane.showMessageDialog(cp, "Scheduling Nurse Duty");
        JPanel jp=new JPanel(new GridLayout(4,2,4,4));
        jp.setBackground(Color.pink);
        JLabel jl1 = new JLabel("employee ID: ");
        final JTextField jf1=new JTextField();
        JLabel jl2 = new JLabel("Shift Date: ");
        //final JTextField jf10=new JTextField();
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel= new JDatePanelImpl(model, p);
        DateLabelFormatter dateLabel=new DateLabelFormatter();
        final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, dateLabel);
        JLabel jl3 = new JLabel("Shift Time: ");
        final JTextField jf3=new JTextField();
        jp.add(jl1);
        jp.add(jf1);
        jp.add(jl2);
        jp.add(datePicker);
        jp.add(jl3);
        jp.add(jf3);
        JButton btn=new JButton("schedule");
        jp.add(btn);
        
        right.add(jp);
        right.revalidate();
        right.repaint();
        btn.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                
                int employeeId=Integer.parseInt(jf1.getText());
                
                Date shiftDate=(Date)datePicker.getModel().getValue();
                String s_shiftDate=dateFormat.format(shiftDate);
                
                String shiftTime=jf3.getText();
                
                PreparedStatement ps;
                
                try {
                    ps = con.prepareStatement("update nurse set shiftdate=?,shifttime=? where employeeid=? ");
                    ps.setString(1, s_shiftDate);
                    ps.setString(2,shiftTime);
                    ps.setString(3,""+employeeId);
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    public void scheduleWardBoyDuty(){
        right.removeAll();
        JOptionPane.showMessageDialog(cp, "Scheduling Wardboy duty");
        
        //JOptionPane.showMessageDialog(cp, "Scheduling Nurse Duty");
        JPanel jp=new JPanel(new GridLayout(4,2,4,4));
        jp.setBackground(Color.pink);
        JLabel jl1 = new JLabel("employee ID: ");
        final JTextField jf1=new JTextField();
        JLabel jl2 = new JLabel("Shift Date: ");
        //final JTextField jf10=new JTextField();
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel= new JDatePanelImpl(model, p);
        DateLabelFormatter dateLabel=new DateLabelFormatter();
        final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, dateLabel);
        JLabel jl3 = new JLabel("Shift Time: ");
        final JTextField jf3=new JTextField();
        jp.add(jl1);
        jp.add(jf1);
        jp.add(jl2);
        jp.add(datePicker);
        jp.add(jl3);
        jp.add(jf3);
        JButton btn=new JButton("schedule");
        jp.add(btn);
        
        right.add(jp);
        right.revalidate();
        right.repaint();
        btn.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                
                int employeeId=Integer.parseInt(jf1.getText());
                
                Date shiftDate=(Date)datePicker.getModel().getValue();
                String s_shiftDate=dateFormat.format(shiftDate);
                
                String shiftTime=jf3.getText();
                
                PreparedStatement ps;
                
                try {
                    ps = con.prepareStatement("update wardboy set shiftdate=?,shifttime=? where employeeid=? ");
                    ps.setString(1, s_shiftDate);
                    ps.setString(2,shiftTime);
                    ps.setString(3,""+employeeId);
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public void scheduleReceptionistDuty(){
        right.removeAll();
        JOptionPane.showMessageDialog(cp, "Scheduling Receptionist duty");
        
        //JOptionPane.showMessageDialog(cp, "Scheduling Nurse Duty");
        JPanel jp=new JPanel(new GridLayout(4,2,4,4));
        jp.setBackground(Color.pink);
        JLabel jl1 = new JLabel("employee ID: ");
        final JTextField jf1=new JTextField();
        JLabel jl2 = new JLabel("Shift Date: ");
        //final JTextField jf10=new JTextField();
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel= new JDatePanelImpl(model, p);
        DateLabelFormatter dateLabel=new DateLabelFormatter();
        final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, dateLabel);
        JLabel jl3 = new JLabel("Shift Time: ");
        final JTextField jf3=new JTextField();
        jp.add(jl1);
        jp.add(jf1);
        jp.add(jl2);
        jp.add(datePicker);
        jp.add(jl3);
        jp.add(jf3);
        JButton btn=new JButton("schedule");
        jp.add(btn);
        
        right.add(jp);
        right.revalidate();
        right.repaint();
        btn.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                
                int employeeId=Integer.parseInt(jf1.getText());
                
                Date shiftDate=(Date)datePicker.getModel().getValue();
                String s_shiftDate=dateFormat.format(shiftDate);
                
                String shiftTime=jf3.getText();
                
                PreparedStatement ps;
                
                try {
                    ps = con.prepareStatement("update receptionist set shiftdate=?,shifttime=? where employeeid=? ");
                    ps.setString(1, s_shiftDate);
                    ps.setString(2,shiftTime);
                    ps.setString(3,""+employeeId);
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
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
    public void upgradeToHOD(){
        JOptionPane.showMessageDialog(cp, "Upgrading to HOD");
        StaffFactory staffFactory=new StaffFactory("hod");
        staffFactory.addStaff(right);
    }
    public void updateStaffProfile(){
        JOptionPane.showMessageDialog(cp, "Updating Staff Profile");
        right.removeAll();
        JPanel jp=new JPanel(new GridLayout(2,2,4,4));
        JLabel jl=new JLabel("Employee ID: ");
        final JTextField jf=new JTextField();
        jp.add(jl);
        jp.add(jf);
        JButton btn=new JButton("Select");
        jp.add(btn);
        right.add(jp);
        right.revalidate();
        right.repaint();
        
        btn.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                employeeId=Integer.parseInt(jf.getText());
                PreparedStatement ps;
                try {
                    ps = con.prepareStatement("select employeetype from login where employeeid=?");
                    ps.setString(1, ""+employeeId);
                    ResultSet rs=ps.executeQuery();
                    while(rs.next()){
                        employeeType=rs.getString(1);
                    }
                    if(employeeType!=null){
                        updateProfile();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(StaffFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    }
    
    public void updateProfile(){
        if( employeeType.equals(StaffType.RECEPTIONIST.getStaffType())){
            updateReceptionist();        
        }
        else if( employeeType.equals(StaffType.STAFFADMIN.getStaffType())){
            updateStaffAdmin();        
        }
        else if(employeeType.equals(StaffType.DOCTOR.getStaffType()) || employeeType.equals(StaffType.HOD.getStaffType())){
            updateDoctor();    
        }
        else if(employeeType.equals(StaffType.WARDBOY.getStaffType())){
            updateWardBoy();    
        }
        else if(employeeType.equals(StaffType.NURSE.getStaffType())){
            updateNurse();    
        }
        else if(employeeType.equals(StaffType.DEPARTMENTADMIN.getStaffType())){
            updateDepartmentAdmin();    
        }
        else{}
    }
    
    private void updateDepartmentAdmin(){
        
        JPanel jp=new JPanel(new GridLayout(12,2,4,4));
        JLabel jl1 = new JLabel("Name: ");
        final JTextField jf1=new JTextField();
        JLabel jl2 = new JLabel("DOB: ");
        final JTextField jf2=new JTextField();
        
        JLabel jl3 = new JLabel("Contact info:");
        final JTextField jf3=new JTextField();
        JLabel jl4 = new JLabel("Address: ");
        final JTextField jf4=new JTextField();
        JLabel jl5 = new JLabel("Salary: ");
        final JTextField jf5=new JTextField();
        JLabel jl6 = new JLabel("Date of Appointment: ");
        final JTextField jf6=new JTextField();
        JLabel jl7 = new JLabel("Department Name: ");
        final JTextField jf7=new JTextField();
        jp.add(jl1);
        jp.add(jf1);
        jp.add(jl2); 
        jp.add(jf2); 
        jp.add(jl3); 
        jp.add(jf3);
        jp.add(jl4);
        jp.add(jf4); 
        jp.add(jl5);
        jp.add(jf5); 
        jp.add(jl6);
        jp.add(jf6);
        jp.add(jl7);
        jp.add(jf7);
        JButton btn=new JButton("Update");
        jp.add(btn);
        right.removeAll();
        right.add(jp);
        right.revalidate();
        right.repaint();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps=con.prepareStatement("select * from departmentadmin where employeeid=?");
            ps.setString(1,""+employeeId);
            rs= ps.executeQuery();
            while(rs.next()){
                jf1.setText(rs.getString("name"));
                jf2.setText(rs.getString("dob"));
                jf3.setText(rs.getString("contactinfo"));
                jf4.setText(rs.getString("address"));
                jf5.setText(rs.getString("salary"));
                jf6.setText(rs.getString("dateofappointment"));
                jf7.setText(rs.getString("departmentname"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
        btn.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                String name = jf1.getText();
                
                
                String s_dob=jf2.getText();
                
                long contactinfo;
                contactinfo = Long.parseLong(jf3.getText());
                
                String address=jf4.getText();
                
                //String departmentName=jf5.getText();
                int salary=Integer.parseInt(jf5.getText());
                
                //Date appointmentDate=(Date)datePicker2.getModel().getValue();
                String s_appointmentDate=jf6.getText();
                String departmentName=jf7.getText();
                PreparedStatement ps;
                try {
                    ps=con.prepareStatement("update departmentadmin set name=?,dob=?,contactinfo=?,address=?,salary=?,dateofappointment=?,departmentname=? where employeeid=?");
                    ps.setString(8,""+employeeId);
                
                    ps.setString(1,name);
                    ps.setString(2,s_dob);
                    ps.setString(3,""+contactinfo);
                    ps.setString(4,address);
                    //ps.setString(6,departmentName);
                    ps.setString(5,""+salary);
                    ps.setString(6,s_appointmentDate);
                    ps.setString(7,departmentName);
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        
    }
    
    private void updateReceptionist(){
        JPanel jp=new JPanel(new GridLayout(12,2,4,4));
        JLabel jl1 = new JLabel("Name: ");
        final JTextField jf1=new JTextField();
        JLabel jl2 = new JLabel("DOB: ");
        final JTextField jf2=new JTextField();
        
        JLabel jl3 = new JLabel("Contact info:");
        final JTextField jf3=new JTextField();
        JLabel jl4 = new JLabel("Address: ");
        final JTextField jf4=new JTextField();
        JLabel jl5 = new JLabel("Salary: ");
        final JTextField jf5=new JTextField();
        JLabel jl6 = new JLabel("Date of Appointment: ");
        final JTextField jf6=new JTextField();
        
        JLabel jl7 = new JLabel("Shift Date: ");
        final JTextField jf7=new JTextField();
        
        JLabel jl8 = new JLabel("Shift Time: ");
        final JTextField jf8=new JTextField();
        
        jp.add(jl1);
        jp.add(jf1);
        jp.add(jl2); 
        jp.add(jf2); 
        jp.add(jl3); 
        jp.add(jf3);
        jp.add(jl4);
        jp.add(jf4); 
        jp.add(jl5);
        jp.add(jf5); 
        jp.add(jl6);
        jp.add(jf6);
        jp.add(jl7);
        jp.add(jf7);
        jp.add(jl8); 
        jp.add(jf8);
        //jp.add(jl12);
        //jp.add(jf12);
        JButton btn=new JButton("Update");
        jp.add(btn);
        right.removeAll();
        right.add(jp);
        right.revalidate();
        right.repaint();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps=con.prepareStatement("select * from receptionist where employeeid=?");
            ps.setString(1,""+employeeId);
            rs= ps.executeQuery();
            while(rs.next()){
                jf1.setText(rs.getString("name"));
                jf2.setText(rs.getString("dob"));
                jf3.setText(rs.getString("contactinfo"));
                jf4.setText(rs.getString("address"));
                jf5.setText(rs.getString("salary"));
                jf6.setText(rs.getString("dateofappointment"));
                jf7.setText(rs.getString("shiftdate"));
                jf8.setText(rs.getString("shifttime"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
        btn.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                String name = jf1.getText();
                
                
                String s_dob=jf2.getText();
                
                long contactinfo;
                contactinfo = Long.parseLong(jf3.getText());
                
                String address=jf4.getText();
                
                //String departmentName=jf5.getText();
                int salary=Integer.parseInt(jf5.getText());
                
                //Date appointmentDate=(Date)datePicker2.getModel().getValue();
                String s_appointmentDate=jf6.getText();
                //String qualification = jf8.getText();
                //String yearOfStartPractice = jf9.getText();
                
                //Date shiftDate = (Date)datePicker3.getModel().getValue();
                String s_shiftDate = jf7.getText();
                
                String shiftTime=jf8.getText();
                
                PreparedStatement ps;
                try {
                    ps=con.prepareStatement("update receptionist set name=?,dob=?,contactinfo=?,address=?,salary=?,dateofappointment=?,shiftdate=?,shifttime=? where employeeid=?");
                    ps.setString(9,""+employeeId);
                
                    ps.setString(1,name);
                    ps.setString(2,s_dob);
                    ps.setString(3,""+contactinfo);
                    ps.setString(4,address);
                    //ps.setString(6,departmentName);
                    ps.setString(5,""+salary);
                    ps.setString(6,s_appointmentDate);
                    //ps.setString(9,qualification);
                    //ps.setString(10,yearOfStartPractice);
                    ps.setString(8,shiftTime);
                    ps.setString(7,s_shiftDate);
                    
                    //ps.setString(13,""+employeeId);
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }
    
    private void updateDoctor(){
        JPanel jp=new JPanel(new GridLayout(14,2,4,4));
        JLabel jl1 = new JLabel("Name: ");
        final JTextField jf1=new JTextField();
        JLabel jl2 = new JLabel("DOB: ");
        final JTextField jf2=new JTextField();
        
        JLabel jl3 = new JLabel("Contact info:");
        final JTextField jf3=new JTextField();
        JLabel jl4 = new JLabel("Address: ");
        final JTextField jf4=new JTextField();
        JLabel jl5 = new JLabel("Department Name: ");
        final JTextField jf5=new JTextField();
        JLabel jl6 = new JLabel("Salary: ");
        final JTextField jf6=new JTextField();
        JLabel jl7 = new JLabel("Date of Appointment: ");
        final JTextField jf7=new JTextField();
        JLabel jl8 = new JLabel("Qualification: ");
        final JTextField jf8=new JTextField();
        JLabel jl9 = new JLabel("Year of Start of Practice: ");
        final JTextField jf9=new JTextField();
        JLabel jl10 = new JLabel("Shift Date: ");
        final JTextField jf10=new JTextField();
        
        JLabel jl11 = new JLabel("Shift Time: ");
        final JTextField jf11=new JTextField();
        JLabel jl12 = new JLabel("Department seniority number: ");
        final JTextField jf12=new JTextField();
        
        jp.add(jl1);
        jp.add(jf1);
        jp.add(jl2); 
        jp.add(jf2); 
        jp.add(jl3); 
        jp.add(jf3);
        jp.add(jl4);
        jp.add(jf4); 
        jp.add(jl5);
        jp.add(jf5); 
        jp.add(jl6);
        jp.add(jf6);
        jp.add(jl7);
        jp.add(jf7);
        jp.add(jl8); 
        jp.add(jf8);
        jp.add(jl9); 
        jp.add(jf9);
        jp.add(jl10); 
        jp.add(jf10);
        jp.add(jl11); 
        jp.add(jf11);
        jp.add(jl12);
        jp.add(jf12);
        JButton btn=new JButton("Update");
        jp.add(btn);
        right.removeAll();
        right.add(jp);
        right.revalidate();
        right.repaint();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps=con.prepareStatement("select * from doctor where employeeid=?");
            ps.setString(1,""+employeeId);
            rs= ps.executeQuery();
            while(rs.next()){
                jf1.setText(rs.getString("name"));
                jf2.setText(rs.getString("dob"));
                jf3.setText(rs.getString("contactinfo"));
                jf4.setText(rs.getString("address"));
                jf5.setText(rs.getString("departmentname"));
                jf6.setText(rs.getString("salary"));
                jf7.setText(rs.getString("dateofappointment"));
                jf8.setText(rs.getString("qualification"));
                jf9.setText(rs.getString("practicestartyear"));
                jf10.setText(rs.getString("shiftdate"));
                jf11.setText(rs.getString("shifttime"));
                jf12.setText(rs.getString("departmentsenioritynumber"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
        btn.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                String name = jf1.getText();
                
                
                String s_dob=jf2.getText();
                
                long contactinfo;
                contactinfo = Long.parseLong(jf3.getText());
                
                String address=jf4.getText();
                
                String departmentName=jf5.getText();
                int salary=Integer.parseInt(jf6.getText());
                
                //Date appointmentDate=(Date)datePicker2.getModel().getValue();
                String s_appointmentDate=jf7.getText();
                String qualification = jf8.getText();
                String yearOfStartPractice = jf9.getText();
                
                //Date shiftDate = (Date)datePicker3.getModel().getValue();
                String s_shiftDate = jf10.getText();
                
                String shiftTime=jf11.getText();
                int departmentsenioritynumber=Integer.parseInt(jf12.getText());
                PreparedStatement ps;
                try {
                    ps=con.prepareStatement("update doctor set name=?,dob=?,contactinfo=?,address=?,departmentname=?,salary=?,dateofappointment=?,qualification=?,practicestartyear=?,shiftdate=?,shifttime=?,departmentsenioritynumber=? where employeeid=?");
                    ps.setString(13,""+employeeId);
                
                    ps.setString(1,name);
                    ps.setString(2,s_dob);
                    ps.setString(3,""+contactinfo);
                    ps.setString(4,address);
                    ps.setString(5,departmentName);
                    ps.setString(6,""+salary);
                    ps.setString(7,s_appointmentDate);
                    ps.setString(8,qualification);
                    ps.setString(9,yearOfStartPractice);
                    ps.setString(11,shiftTime);
                    ps.setString(10,s_shiftDate);
                    ps.setString(12, ""+departmentsenioritynumber);
                    //ps.setString(13,""+employeeId);
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }
    
    private void updateWardBoy(){
        JPanel jp=new JPanel(new GridLayout(12,2,4,4));
        JLabel jl1 = new JLabel("Name: ");
        final JTextField jf1=new JTextField();
        JLabel jl2 = new JLabel("DOB: ");
        final JTextField jf2=new JTextField();
        
        JLabel jl3 = new JLabel("Contact info:");
        final JTextField jf3=new JTextField();
        JLabel jl4 = new JLabel("Address: ");
        final JTextField jf4=new JTextField();
        JLabel jl5 = new JLabel("Salary: ");
        final JTextField jf5=new JTextField();
        JLabel jl6 = new JLabel("Date of Appointment: ");
        final JTextField jf6=new JTextField();
        
        JLabel jl7 = new JLabel("Shift Date: ");
        final JTextField jf7=new JTextField();
        
        JLabel jl8 = new JLabel("Shift Time: ");
        final JTextField jf8=new JTextField();
        
        jp.add(jl1);
        jp.add(jf1);
        jp.add(jl2); 
        jp.add(jf2); 
        jp.add(jl3); 
        jp.add(jf3);
        jp.add(jl4);
        jp.add(jf4); 
        jp.add(jl5);
        jp.add(jf5); 
        jp.add(jl6);
        jp.add(jf6);
        jp.add(jl7);
        jp.add(jf7);
        jp.add(jl8); 
        jp.add(jf8);
        //jp.add(jl12);
        //jp.add(jf12);
        JButton btn=new JButton("Update");
        jp.add(btn);
        right.removeAll();
        right.add(jp);
        right.revalidate();
        right.repaint();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps=con.prepareStatement("select * from wardboy where employeeid=?");
            ps.setString(1,""+employeeId);
            rs= ps.executeQuery();
            while(rs.next()){
                jf1.setText(rs.getString("name"));
                jf2.setText(rs.getString("dob"));
                jf3.setText(rs.getString("contactinfo"));
                jf4.setText(rs.getString("address"));
                jf5.setText(rs.getString("salary"));
                jf6.setText(rs.getString("dateofappointment"));
                jf7.setText(rs.getString("shiftdate"));
                jf8.setText(rs.getString("shifttime"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
        btn.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                String name = jf1.getText();
                
                
                String s_dob=jf2.getText();
                
                long contactinfo;
                contactinfo = Long.parseLong(jf3.getText());
                
                String address=jf4.getText();
                
                //String departmentName=jf5.getText();
                int salary=Integer.parseInt(jf5.getText());
                
                //Date appointmentDate=(Date)datePicker2.getModel().getValue();
                String s_appointmentDate=jf6.getText();
                //String qualification = jf8.getText();
                //String yearOfStartPractice = jf9.getText();
                
                //Date shiftDate = (Date)datePicker3.getModel().getValue();
                String s_shiftDate = jf7.getText();
                
                String shiftTime=jf8.getText();
                
                PreparedStatement ps;
                try {
                    ps=con.prepareStatement("update wardboy set name=?,dob=?,contactinfo=?,address=?,salary=?,dateofappointment=?,shiftdate=?,shifttime=? where employeeid=?");
                    ps.setString(9,""+employeeId);
                
                    ps.setString(1,name);
                    ps.setString(2,s_dob);
                    ps.setString(3,""+contactinfo);
                    ps.setString(4,address);
                    //ps.setString(6,departmentName);
                    ps.setString(5,""+salary);
                    ps.setString(6,s_appointmentDate);
                    //ps.setString(9,qualification);
                    //ps.setString(10,yearOfStartPractice);
                    ps.setString(8,shiftTime);
                    ps.setString(7,s_shiftDate);
                    
                    //ps.setString(13,""+employeeId);
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }
    
    private void updateNurse(){
        JPanel jp=new JPanel(new GridLayout(12,2,4,4));
        JLabel jl1 = new JLabel("Name: ");
        final JTextField jf1=new JTextField();
        JLabel jl2 = new JLabel("DOB: ");
        final JTextField jf2=new JTextField();
        
        JLabel jl3 = new JLabel("Contact info:");
        final JTextField jf3=new JTextField();
        JLabel jl4 = new JLabel("Address: ");
        final JTextField jf4=new JTextField();
        JLabel jl5 = new JLabel("Salary: ");
        final JTextField jf5=new JTextField();
        JLabel jl6 = new JLabel("Date of Appointment: ");
        final JTextField jf6=new JTextField();
        
        JLabel jl7 = new JLabel("Shift Date: ");
        final JTextField jf7=new JTextField();
        
        JLabel jl8 = new JLabel("Shift Time: ");
        final JTextField jf8=new JTextField();
        
        jp.add(jl1);
        jp.add(jf1);
        jp.add(jl2); 
        jp.add(jf2); 
        jp.add(jl3); 
        jp.add(jf3);
        jp.add(jl4);
        jp.add(jf4); 
        jp.add(jl5);
        jp.add(jf5); 
        jp.add(jl6);
        jp.add(jf6);
        jp.add(jl7);
        jp.add(jf7);
        jp.add(jl8); 
        jp.add(jf8);
        //jp.add(jl12);
        //jp.add(jf12);
        JButton btn=new JButton("Update");
        jp.add(btn);
        right.removeAll();
        right.add(jp);
        right.revalidate();
        right.repaint();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps=con.prepareStatement("select * from nurse where employeeid=?");
            ps.setString(1,""+employeeId);
            rs= ps.executeQuery();
            while(rs.next()){
                jf1.setText(rs.getString("name"));
                jf2.setText(rs.getString("dob"));
                jf3.setText(rs.getString("contactinfo"));
                jf4.setText(rs.getString("address"));
                jf5.setText(rs.getString("salary"));
                jf6.setText(rs.getString("dateofappointment"));
                jf7.setText(rs.getString("shiftdate"));
                jf8.setText(rs.getString("shifttime"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
        btn.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                String name = jf1.getText();
                
                
                String s_dob=jf2.getText();
                
                long contactinfo;
                contactinfo = Long.parseLong(jf3.getText());
                
                String address=jf4.getText();
                
                //String departmentName=jf5.getText();
                int salary=Integer.parseInt(jf5.getText());
                
                //Date appointmentDate=(Date)datePicker2.getModel().getValue();
                String s_appointmentDate=jf6.getText();
                String s_shiftDate = jf7.getText();
                
                String shiftTime=jf8.getText();
                
                PreparedStatement ps;
                try {
                    ps=con.prepareStatement("update nurse set name=?,dob=?,contactinfo=?,address=?,salary=?,dateofappointment=?,shiftdate=?,shifttime=? where employeeid=?");
                    ps.setString(9,""+employeeId);
                
                    ps.setString(1,name);
                    ps.setString(2,s_dob);
                    ps.setString(3,""+contactinfo);
                    ps.setString(4,address);
                    //ps.setString(6,departmentName);
                    ps.setString(5,""+salary);
                    ps.setString(6,s_appointmentDate);
                    ps.setString(8,shiftTime);
                    ps.setString(7,s_shiftDate);
                    
                    //ps.setString(13,""+employeeId);
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }
    
    private void updateStaffAdmin(){
        JPanel jp=new JPanel(new GridLayout(12,2,4,4));
        JLabel jl1 = new JLabel("Name: ");
        final JTextField jf1=new JTextField();
        JLabel jl2 = new JLabel("DOB: ");
        final JTextField jf2=new JTextField();
        
        JLabel jl3 = new JLabel("Contact info:");
        final JTextField jf3=new JTextField();
        JLabel jl4 = new JLabel("Address: ");
        final JTextField jf4=new JTextField();
        JLabel jl5 = new JLabel("Salary: ");
        final JTextField jf5=new JTextField();
        JLabel jl6 = new JLabel("Date of Appointment: ");
        final JTextField jf6=new JTextField();
        
        jp.add(jl1);
        jp.add(jf1);
        jp.add(jl2); 
        jp.add(jf2); 
        jp.add(jl3); 
        jp.add(jf3);
        jp.add(jl4);
        jp.add(jf4); 
        jp.add(jl5);
        jp.add(jf5); 
        jp.add(jl6);
        jp.add(jf6);
        
        JButton btn=new JButton("Update");
        jp.add(btn);
        right.removeAll();
        right.add(jp);
        right.revalidate();
        right.repaint();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps=con.prepareStatement("select * from staffadmin where employeeid=?");
            ps.setString(1,""+employeeId);
            rs= ps.executeQuery();
            while(rs.next()){
                jf1.setText(rs.getString("name"));
                jf2.setText(rs.getString("dob"));
                jf3.setText(rs.getString("contactinfo"));
                jf4.setText(rs.getString("address"));
                jf5.setText(rs.getString("salary"));
                jf6.setText(rs.getString("dateofappointment"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
        btn.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                String name = jf1.getText();
                
                
                String s_dob=jf2.getText();
                
                long contactinfo;
                contactinfo = Long.parseLong(jf3.getText());
                
                String address=jf4.getText();
                
                //String departmentName=jf5.getText();
                int salary=Integer.parseInt(jf5.getText());
                
                //Date appointmentDate=(Date)datePicker2.getModel().getValue();
                String s_appointmentDate=jf6.getText();
                //String departmentName=jf7.getText();
                PreparedStatement ps;
                try {
                    ps=con.prepareStatement("update staffadmin set name=?,dob=?,contactinfo=?,address=?,salary=?,dateofappointment=? where employeeid=?");
                    ps.setString(7,""+employeeId);
                
                    ps.setString(1,name);
                    ps.setString(2,s_dob);
                    ps.setString(3,""+contactinfo);
                    ps.setString(4,address);
                    //ps.setString(6,departmentName);
                    ps.setString(5,""+salary);
                    ps.setString(6,s_appointmentDate);
                    //ps.setString(7,departmentName);
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }
    
    ///DepartmentType should be replaced by Department LATER
    public void viewDepartmentAdmins(){
        JOptionPane.showMessageDialog(cp, "Viewing Department Admins");
        try {
            
            right.removeAll();
            PreparedStatement ps = con.prepareStatement("select * from departmentadmin");
            
            ResultSet rs = ps.executeQuery();
            ArrayList<JLabel> jl =new ArrayList<>();
            int count=1; 
            while(rs.next()) {
                jl.add(new JLabel(rs.getString("employeeid")));
                jl.add(new JLabel(rs.getString("name")));
                //jl.add(new JLabel(rs.getString("dob")));
                jl.add(new JLabel(rs.getString("contactinfo")));
                count++; 
                               
            }
            JPanel jp;
            jp=new JPanel();
            jp.setLayout(new GridLayout(count,3,4,4));
            jp.setBackground(Color.pink);
            jp.add(new JLabel("employeeid"));
            jp.add(new JLabel("name"));
            //jp.add(new JLabel("dob"));
            jp.add(new JLabel("contactinfo"));
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
    
    public void viewNurse(){
        JOptionPane.showMessageDialog(cp, "Viewing Nurses");
        try {
            
            right.removeAll();
            PreparedStatement ps = con.prepareStatement("select * from nurse");
            
            ResultSet rs = ps.executeQuery();
            ArrayList<JLabel> jl =new ArrayList<>();
            int count=1; 
            while(rs.next()) {
                jl.add(new JLabel(rs.getString("employeeid")));
                jl.add(new JLabel(rs.getString("name")));
                //jl.add(new JLabel(rs.getString("dob")));
                jl.add(new JLabel(rs.getString("contactinfo")));
                jl.add(new JLabel(rs.getString("shiftdate")));
                jl.add(new JLabel(rs.getString("shifttime")));
                count++; 
                               
            }
            JPanel jp;
            jp=new JPanel();
            jp.setLayout(new GridLayout(count,5,4,4));
            jp.setBackground(Color.pink);
            jp.add(new JLabel("employeeid"));
            jp.add(new JLabel("name"));
            //jp.add(new JLabel("dob"));
            jp.add(new JLabel("contactinfo"));
            jp.add(new JLabel("shiftdate"));
            jp.add(new JLabel("shifttime"));
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
    
    public void viewWardBoy(){
        JOptionPane.showMessageDialog(cp, "Viewing WardBoy");
        try {
            
            right.removeAll();
            PreparedStatement ps = con.prepareStatement("select * from wardboy");
            //System.out.println(employeeId);
            //ps.setString(1, Integer.toString(employeeId));
            ResultSet rs = ps.executeQuery();
            ArrayList<JLabel> jl =new ArrayList<>();
            int count=1; 
            while(rs.next()) {
                jl.add(new JLabel(rs.getString("employeeid")));
                jl.add(new JLabel(rs.getString("name")));
                //jl.add(new JLabel(rs.getString("dob")));
                jl.add(new JLabel(rs.getString("contactinfo")));
                
                jl.add(new JLabel(rs.getString("shiftdate")));
                jl.add(new JLabel(rs.getString("shifttime")));
                count++; 
                               
            }
            JPanel jp;
            jp=new JPanel();
            jp.setLayout(new GridLayout(count,5,4,4));
            jp.setBackground(Color.pink);
            jp.add(new JLabel("employeeid"));
            jp.add(new JLabel("name"));
            //jp.add(new JLabel("dob"));
            jp.add(new JLabel("contactinfo"));
            //jp.add(new JLabel("address"));
            //jp.add(new JLabel("salary"));
            //jp.add(new JLabel("dateofappointment"));
            jp.add(new JLabel("shiftdate"));
            jp.add(new JLabel("shifttime"));
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
    
    public void viewReceptionist(){
        JOptionPane.showMessageDialog(cp, "Viewing Receptionist");
        try {
            
            right.removeAll();
            PreparedStatement ps = con.prepareStatement("select * from receptionist");
            //System.out.println(employeeId);
            //ps.setString(1, Integer.toString(employeeId));
            ResultSet rs = ps.executeQuery();
            ArrayList<JLabel> jl =new ArrayList<>();
            int count=1; 
            while(rs.next()) {
                jl.add(new JLabel(rs.getString("employeeid")));
                jl.add(new JLabel(rs.getString("name")));
                //jl.add(new JLabel(rs.getString("dob")));
                jl.add(new JLabel(rs.getString("contactinfo")));
                //jl.add(new JLabel(rs.getString("address")));
                //jl.add(new JLabel(rs.getString("salary")));
                //jl.add(new JLabel(rs.getString("dateofappointment")));
                jl.add(new JLabel(rs.getString("shiftdate")));
                jl.add(new JLabel(rs.getString("shifttime")));
                count++; 
                               
            }
            JPanel jp;
            jp=new JPanel();
            jp.setLayout(new GridLayout(count,5,4,4));
            jp.setBackground(Color.pink);
            jp.add(new JLabel("employeeid"));
            jp.add(new JLabel("name"));
            //jp.add(new JLabel("dob"));
            jp.add(new JLabel("contactinfo"));
            //jp.add(new JLabel("address"));
            //jp.add(new JLabel("salary"));
            //jp.add(new JLabel("dateofappointment"));
            jp.add(new JLabel("shiftdate"));
            jp.add(new JLabel("shifttime"));
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
