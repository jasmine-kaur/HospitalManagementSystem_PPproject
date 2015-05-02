/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staff;

import BasicDetails.Address;
import BasicDetails.Name;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
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
public class StaffFactory {
    
    private String staffType;
    private int employeeId;
    private Name name;
    private Date dateOfBirth;
    private Long contactInfo;
    private Address address;
    private int salary;
    private Date dateOfAppointment;
    int seniority;
    public StaffFactory(String staffType){
        this.staffType=staffType;
        
    }
    
    public void addStaff(JPanel panel){
        if( staffType.equals(StaffType.RECEPTIONIST.getStaffType())){
            addReceptionist(panel);        
        }
        else if( staffType.equals(StaffType.STAFFADMIN.getStaffType())){
            addStaffAdmin(panel);        
        }
        else if(staffType.equals(StaffType.DOCTOR.getStaffType())){
            addDoctor(panel);    
        }
        else if(staffType.equals(StaffType.WARDBOY.getStaffType())){
            addWardBoy(panel);    
        }
        else if(staffType.equals(StaffType.NURSE.getStaffType())){
            addNurse(panel);    
        }
        else if(staffType.equals(StaffType.DEPARTMENTADMIN.getStaffType())){
            addDepartmentAdmin(panel);    
        }
        else if(staffType.equals(StaffType.HOD.getStaffType())){
            promoteToHOD(panel);
        }
        else{}
    }
    
    public void addDoctor(JPanel panel){
        JPanel jp=new JPanel(new GridLayout(12,2,4,4));
        
        JLabel jl1 = new JLabel("Name: ");
        final JTextField jf1=new JTextField();
        JLabel jl2 = new JLabel("DOB: ");
        //final JTextField jf2=new JTextField();
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        DateLabelFormatter dateLabel=new DateLabelFormatter();
        final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, dateLabel);
        JLabel jl3 = new JLabel("Contact info:");
        final JTextField jf3=new JTextField();
        JLabel jl4 = new JLabel("Address: ");
        final JTextField jf4=new JTextField();
        JLabel jl5 = new JLabel("Department Name: ");
        final JTextField jf5=new JTextField();
        JLabel jl6 = new JLabel("Salary: ");
        final JTextField jf6=new JTextField();
        JLabel jl7 = new JLabel("Date of Appointment: ");
        //final JTextField jf7=new JTextField();
        UtilDateModel model2 = new UtilDateModel();
        Properties p2 = new Properties();
        p2.put("text.today", "Today");
        p2.put("text.month", "Month");
        p2.put("text.year", "Year");
        JDatePanelImpl datePanel2= new JDatePanelImpl(model2, p2);
        DateLabelFormatter dateLabel2=new DateLabelFormatter();
        final JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2, dateLabel2);
        JLabel jl8 = new JLabel("Qualification: ");
        final JTextField jf8=new JTextField();
        JLabel jl9 = new JLabel("Practice Start year: ");
        final JTextField jf9=new JTextField();
        JLabel jl10 = new JLabel("Shift Date: ");
        //final JTextField jf10=new JTextField();
        UtilDateModel model3 = new UtilDateModel();
        Properties p3 = new Properties();
        p3.put("text.today", "Today");
        p3.put("text.month", "Month");
        p3.put("text.year", "Year");
        JDatePanelImpl datePanel3= new JDatePanelImpl(model3, p3);
        DateLabelFormatter dateLabel3=new DateLabelFormatter();
        final JDatePickerImpl datePicker3 = new JDatePickerImpl(datePanel3, dateLabel3);
        JLabel jl11 = new JLabel("Shift Time: ");
        final JTextField jf11=new JTextField();
        //JLabel jl12 = new JLabel("Department Seniority Number: ");
        //final JTextField jf12=new JTextField();
        jp.add(jl1);
        jp.add(jf1);
        jp.add(jl2); 
        jp.add(datePicker); 
        jp.add(jl3); 
        jp.add(jf3);
        jp.add(jl4);
        jp.add(jf4); 
        jp.add(jl5);
        jp.add(jf5); 
        jp.add(jl6);
        jp.add(jf6);
        jp.add(jl7); 
        jp.add(datePicker2);
        jp.add(jl8);
        jp.add(jf8);
        jp.add(jl9); 
        jp.add(jf9);
        jp.add(jl10);
        jp.add(datePicker3); 
        jp.add(jl11); 
        jp.add(jf11);
        
        JButton btn=new JButton("Add");
        jp.add(btn);
        panel.removeAll();
        panel.add(jp);
        panel.revalidate();
        panel.repaint();
        btn.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                String name = jf1.getText();
                Date dob=(Date)datePicker.getModel().getValue();
                String s_dob=dateFormat.format(dob);
                long contactinfo;
                contactinfo = Long.parseLong(jf3.getText());
                String address=jf4.getText();
                String departmentName=jf5.getText();
                int salary=Integer.parseInt(jf6.getText());
                Date appointmentDate=(Date)datePicker2.getModel().getValue();
                String s_appointmentDate=dateFormat.format(appointmentDate);
                String qualification = jf8.getText();
                String yearOfStartPractice = jf9.getText();
                Date shiftDate = (Date)datePicker3.getModel().getValue();
                String s_shiftDate = dateFormat.format(shiftDate);
                String shiftTime=jf11.getText();
                PreparedStatement ps1;
                
                try {
                    ps1 = con.prepareStatement("select MAX(employeeid) from login");
                    
                    ResultSet rs1=ps1.executeQuery();
                    while(rs1.next()){
                        employeeId=Integer.parseInt(rs1.getString(1))+1;
                        //System.out.println(employeeId);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(StaffFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                PreparedStatement ps3;
                try {
                    ps3=con.prepareStatement("select MAX(departmentsenioritynumber) from doctor where departmentname=?");
                    ps3.setString(1,departmentName);
                    ResultSet rs=ps3.executeQuery();
                    
                    while(rs.next()){
                        if(rs.getString(1)!=null){
                            seniority=Integer.parseInt(rs.getString(1))+1;
                        }
                        else{
                            seniority=0;
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(StaffFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                PreparedStatement ps;
                try {
                    ps=con.prepareStatement("insert into doctor values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    ps.setString(1,""+employeeId);
                
                    ps.setString(2,name);
                    ps.setString(3,s_dob);
                    ps.setString(4,""+contactinfo);
                    ps.setString(5,address);
                    ps.setString(6,departmentName);
                    ps.setString(7,""+salary);
                    ps.setString(8,s_appointmentDate);
                    ps.setString(9,qualification);
                    ps.setString(10,yearOfStartPractice);
                    ps.setString(11,s_shiftDate);
                    ps.setString(12,shiftTime);
                    ps.setString(13,""+seniority);
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
                }
                PreparedStatement ps2;
                try {
                    ps2=con.prepareStatement("insert into login values (?,?,?,?)");
                    ps2.setString(1,name);
                    ps2.setString(2,name);
                    ps2.setString(3,""+employeeId);
                    ps2.setString(4,"doctor");
                    ps2.executeUpdate();
               } catch (SQLException ex) {
                    Logger.getLogger(StaffFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    public void addNurse(JPanel panel){
        JPanel jp=new JPanel(new GridLayout(12,2,4,4));
        JLabel jl1 = new JLabel("Name: ");
        final JTextField jf1=new JTextField();
        JLabel jl2 = new JLabel("DOB: ");
        
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        DateLabelFormatter dateLabel=new DateLabelFormatter();
        final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, dateLabel);
        JLabel jl3 = new JLabel("Contact info:");
        final JTextField jf3=new JTextField();
        JLabel jl4 = new JLabel("Address: ");
        final JTextField jf4=new JTextField();
        JLabel jl5 = new JLabel("Salary: ");
        final JTextField jf5=new JTextField();
        JLabel jl6 = new JLabel("Date of Appointment: ");
        
        UtilDateModel model2 = new UtilDateModel();
        Properties p2 = new Properties();
        p2.put("text.today", "Today");
        p2.put("text.month", "Month");
        p2.put("text.year", "Year");
        JDatePanelImpl datePanel2= new JDatePanelImpl(model2, p2);
        DateLabelFormatter dateLabel2=new DateLabelFormatter();
        final JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2, dateLabel2);
        JLabel jl7 = new JLabel("Shift Date: ");
        
        UtilDateModel model3 = new UtilDateModel();
        Properties p3 = new Properties();
        p3.put("text.today", "Today");
        p3.put("text.month", "Month");
        p3.put("text.year", "Year");
        JDatePanelImpl datePanel3= new JDatePanelImpl(model3, p3);
        DateLabelFormatter dateLabel3=new DateLabelFormatter();
        final JDatePickerImpl datePicker3 = new JDatePickerImpl(datePanel3, dateLabel3);
        JLabel jl8 = new JLabel("Shift Time: ");
        final JTextField jf8=new JTextField();
        
        jp.add(jl1);
        jp.add(jf1);
        jp.add(jl2); 
        jp.add(datePicker); 
        jp.add(jl3); 
        jp.add(jf3);
        jp.add(jl4);
        jp.add(jf4); 
        jp.add(jl5);
        jp.add(jf5); 
        jp.add(jl6);
        jp.add(datePicker2);
        jp.add(jl7);
        jp.add(datePicker3);
        jp.add(jl8); 
        jp.add(jf8);
        
        JButton btn=new JButton("Add");
        jp.add(btn);
        panel.removeAll();
        panel.add(jp);
        panel.revalidate();
        panel.repaint();
        
        btn.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                String name = jf1.getText();
                
                Date dob=(Date)datePicker.getModel().getValue();
                String s_dob=dateFormat.format(dob);
                
                long contactinfo;
                contactinfo = Long.parseLong(jf3.getText());
                
                String address=jf4.getText();
                
                int salary=Integer.parseInt(jf5.getText());
                
                Date appointmentDate=(Date)datePicker2.getModel().getValue();
                String s_appointmentDate=dateFormat.format(appointmentDate);
                
                Date shiftDate = (Date)datePicker3.getModel().getValue();
                String s_shiftDate = dateFormat.format(shiftDate);
                
                String shiftTime=jf8.getText();
                PreparedStatement ps1;
                
                try {
                    ps1 = con.prepareStatement("select MAX(employeeid) from login");
                    
                    ResultSet rs1=ps1.executeQuery();
                    while(rs1.next()){
                        employeeId=Integer.parseInt(rs1.getString(1))+1;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(StaffFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
                PreparedStatement ps;
                try {
                    ps=con.prepareStatement("insert into nurse values (?,?,?,?,?,?,?,?,?)");
                    ps.setString(1,""+employeeId);
                    ps.setString(2,name);
                    ps.setString(3,s_dob);
                    ps.setString(4,""+contactinfo);
                    ps.setString(5,address);
                    ps.setString(6,""+salary);
                    ps.setString(7,s_appointmentDate);
                    ps.setString(8,s_shiftDate);
                    ps.setString(9,shiftTime);
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
                }
                PreparedStatement ps2;
                try {
                    ps2=con.prepareStatement("insert into login values (?,?,?,?)");
                    ps2.setString(1,name);
                    ps2.setString(2,name);
                    ps2.setString(3,""+employeeId);
                
                    ps2.setString(4,"nurse");
                    
                    ps2.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    public void promoteToHOD(JPanel panel){
        JPanel jp=new JPanel(new GridLayout(1,2,4,4));
        JLabel jl1 = new JLabel("Department Name: ");
        final JTextField jf1=new JTextField();
        jp.add(jl1);
        jp.add(jf1);
        JButton btn=new JButton("Add");
        jp.add(btn);
        panel.removeAll();
        panel.add(jp);
        panel.revalidate();
        panel.repaint();
        btn.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
        
                String departmentname = jf1.getText();
                PreparedStatement ps1;
                
                try {
                    ps1 = con.prepareStatement("select MIN(departmentsenioritynumber) from doctor where departmentname=?");
                    ps1.setString(1,departmentname);
                    ResultSet rs1=ps1.executeQuery();
                    
                    while(rs1.next()){
                        if(rs1.getString(1)==null){
                            return;
                        }
                        seniority=Integer.parseInt(rs1.getString(1));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(StaffFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
                PreparedStatement ps4;
                try {
                    ps4=con.prepareStatement("select employeeid from doctor where departmentsenioritynumber=? and departmentname=?");
                    ps4.setString(1,""+seniority);
                    ps4.setString(2,departmentname);
                    ResultSet rs4=ps4.executeQuery();
                    while(rs4.next()){
                        employeeId=Integer.parseInt(rs4.getString(1));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(StaffFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
                PreparedStatement ps;
                try {
                    ps=con.prepareStatement("update doctor set departmentsenioritynumber=0 where employeeid=?");
                    ps.setString(1,""+employeeId);
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
                }
                PreparedStatement ps2;
                try {
                    ps2=con.prepareStatement("update login set employeetype='hod' where employeeid=?");
                    ps2.setString(1,""+employeeId);
                    ps2.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    public void addWardBoy(JPanel panel){
        JPanel jp=new JPanel(new GridLayout(12,2,4,4));
        JLabel jl1 = new JLabel("Name: ");
        final JTextField jf1=new JTextField();
        JLabel jl2 = new JLabel("DOB: ");
        
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        DateLabelFormatter dateLabel=new DateLabelFormatter();
        final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, dateLabel);
        JLabel jl3 = new JLabel("Contact info:");
        final JTextField jf3=new JTextField();
        JLabel jl4 = new JLabel("Address: ");
        final JTextField jf4=new JTextField();
        JLabel jl5 = new JLabel("Salary: ");
        final JTextField jf5=new JTextField();
        JLabel jl6 = new JLabel("Date of Appointment: ");
        //final JTextField jf7=new JTextField();
        UtilDateModel model2 = new UtilDateModel();
        Properties p2 = new Properties();
        p2.put("text.today", "Today");
        p2.put("text.month", "Month");
        p2.put("text.year", "Year");
        JDatePanelImpl datePanel2= new JDatePanelImpl(model2, p2);
        DateLabelFormatter dateLabel2=new DateLabelFormatter();
        final JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2, dateLabel2);
        JLabel jl7 = new JLabel("Shift Date: ");
        
        UtilDateModel model3 = new UtilDateModel();
        Properties p3 = new Properties();
        p3.put("text.today", "Today");
        p3.put("text.month", "Month");
        p3.put("text.year", "Year");
        JDatePanelImpl datePanel3= new JDatePanelImpl(model3, p3);
        DateLabelFormatter dateLabel3=new DateLabelFormatter();
        final JDatePickerImpl datePicker3 = new JDatePickerImpl(datePanel3, dateLabel3);
        JLabel jl8 = new JLabel("Shift Time: ");
        final JTextField jf8=new JTextField();
        
        jp.add(jl1);
        jp.add(jf1);
        jp.add(jl2); 
        jp.add(datePicker); 
        jp.add(jl3); 
        jp.add(jf3);
        jp.add(jl4);
        jp.add(jf4); 
        jp.add(jl5);
        jp.add(jf5); 
        jp.add(jl6);
        jp.add(datePicker2);
        jp.add(jl7);
        jp.add(datePicker3);
        jp.add(jl8); 
        jp.add(jf8);
        
        JButton btn=new JButton("Add");
        jp.add(btn);
        panel.removeAll();
        panel.add(jp);
        panel.revalidate();
        panel.repaint();
        
        btn.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                String name = jf1.getText();
                
                Date dob=(Date)datePicker.getModel().getValue();
                String s_dob=dateFormat.format(dob);
                
                long contactinfo;
                contactinfo = Long.parseLong(jf3.getText());
                
                String address=jf4.getText();
                
                int salary=Integer.parseInt(jf5.getText());
                
                Date appointmentDate=(Date)datePicker2.getModel().getValue();
                String s_appointmentDate=dateFormat.format(appointmentDate);
                Date shiftDate = (Date)datePicker3.getModel().getValue();
                String s_shiftDate = dateFormat.format(shiftDate);
                
                String shiftTime=jf8.getText();
                PreparedStatement ps1;
                
                try {
                    ps1 = con.prepareStatement("select MAX(employeeid) from login");
                    
                    ResultSet rs1=ps1.executeQuery();
                    while(rs1.next()){
                        employeeId=Integer.parseInt(rs1.getString(1))+1;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(StaffFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
                PreparedStatement ps;
                try {
                    ps=con.prepareStatement("insert into wardboy values (?,?,?,?,?,?,?,?,?)");
                    ps.setString(1,""+employeeId);
                
                    ps.setString(2,name);
                    ps.setString(3,s_dob);
                    ps.setString(4,""+contactinfo);
                    ps.setString(5,address);
                    ps.setString(6,""+salary);
                    ps.setString(7,s_appointmentDate);
                    ps.setString(9,shiftTime);
                    ps.setString(8,s_shiftDate);
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
                }
                PreparedStatement ps2;
                try {
                    ps2=con.prepareStatement("insert into login values (?,?,?,?)");
                    ps2.setString(1,name);
                    ps2.setString(2,name);
                    ps2.setString(3,""+employeeId);
                
                    ps2.setString(4,"WardBoy");
                    
                    ps2.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    public void addDepartmentAdmin(JPanel panel){
        JPanel jp=new JPanel(new GridLayout(12,2,4,4));
        JLabel jl1 = new JLabel("Name: ");
        final JTextField jf1=new JTextField();
        JLabel jl2 = new JLabel("DOB: ");
        
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        DateLabelFormatter dateLabel=new DateLabelFormatter();
        final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, dateLabel);
        JLabel jl3 = new JLabel("Contact info:");
        final JTextField jf3=new JTextField();
        JLabel jl4 = new JLabel("Address: ");
        final JTextField jf4=new JTextField();
        JLabel jl5 = new JLabel("Salary: ");
        final JTextField jf5=new JTextField();
        JLabel jl6 = new JLabel("Date of Appointment: ");
        //final JTextField jf7=new JTextField();
        UtilDateModel model2 = new UtilDateModel();
        Properties p2 = new Properties();
        p2.put("text.today", "Today");
        p2.put("text.month", "Month");
        p2.put("text.year", "Year");
        JDatePanelImpl datePanel2= new JDatePanelImpl(model2, p2);
        DateLabelFormatter dateLabel2=new DateLabelFormatter();
        final JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2, dateLabel2);
        JLabel jl7 = new JLabel("Department name ");
        final JTextField jf7=new JTextField();
        jp.add(jl1);
        jp.add(jf1);
        jp.add(jl2); 
        jp.add(datePicker); 
        jp.add(jl3); 
        jp.add(jf3);
        jp.add(jl4);
        jp.add(jf4); 
        jp.add(jl5);
        jp.add(jf5); 
        jp.add(jl6);
        jp.add(datePicker2);
        jp.add(jl7); 
        jp.add(jf7);
        
        JButton btn=new JButton("Add");
        jp.add(btn);
        panel.removeAll();
        panel.add(jp);
        panel.revalidate();
        panel.repaint();
        
        btn.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                String name = jf1.getText();
                
                Date dob=(Date)datePicker.getModel().getValue();
                String s_dob=dateFormat.format(dob);
                
                long contactinfo;
                contactinfo = Long.parseLong(jf3.getText());
                
                String address=jf4.getText();
                int salary=Integer.parseInt(jf5.getText());
                
                Date appointmentDate=(Date)datePicker2.getModel().getValue();
                String s_appointmentDate=dateFormat.format(appointmentDate);
                String departmentname=jf7.getText();
                PreparedStatement ps1;
                
                try {
                    ps1 = con.prepareStatement("select MAX(employeeid) from login");
                    
                    ResultSet rs1=ps1.executeQuery();
                    while(rs1.next()){
                        employeeId=Integer.parseInt(rs1.getString(1))+1;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(StaffFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
                PreparedStatement ps;
                try {
                    ps=con.prepareStatement("insert into departmentadmin values (?,?,?,?,?,?,?,?)");
                    ps.setString(1,""+employeeId);
                
                    ps.setString(2,name);
                    ps.setString(3,s_dob);
                    ps.setString(4,""+contactinfo);
                    ps.setString(5,address);
                    ps.setString(6,""+salary);
                    ps.setString(7,s_appointmentDate);
                    ps.setString(8,departmentname);
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
                }
                PreparedStatement ps2;
                try {
                    ps2=con.prepareStatement("insert into login values (?,?,?,?)");
                    ps2.setString(1,name);
                    ps2.setString(2,name);
                    ps2.setString(3,""+employeeId);
                    ps2.setString(4,"departmentadmin");
                    ps2.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(StaffFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    public void addStaffAdmin(JPanel panel){
        JPanel jp=new JPanel(new GridLayout(12,2,4,4));
        JLabel jl1 = new JLabel("Name: ");
        final JTextField jf1=new JTextField();
        JLabel jl2 = new JLabel("DOB: ");
        //final JTextField jf2=new JTextField();
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        DateLabelFormatter dateLabel=new DateLabelFormatter();
        final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, dateLabel);
        JLabel jl3 = new JLabel("Contact info:");
        final JTextField jf3=new JTextField();
        JLabel jl4 = new JLabel("Address: ");
        final JTextField jf4=new JTextField();
        JLabel jl5 = new JLabel("Salary: ");
        final JTextField jf5=new JTextField();
        JLabel jl6 = new JLabel("Date of Appointment: ");
        //final JTextField jf7=new JTextField();
        UtilDateModel model2 = new UtilDateModel();
        Properties p2 = new Properties();
        p2.put("text.today", "Today");
        p2.put("text.month", "Month");
        p2.put("text.year", "Year");
        JDatePanelImpl datePanel2= new JDatePanelImpl(model2, p2);
        DateLabelFormatter dateLabel2=new DateLabelFormatter();
        final JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2, dateLabel2);
        
        jp.add(jl1);
        jp.add(jf1);
        jp.add(jl2); 
        jp.add(datePicker); 
        jp.add(jl3); 
        jp.add(jf3);
        jp.add(jl4);
        jp.add(jf4); 
        jp.add(jl5);
        jp.add(jf5); 
        jp.add(jl6);
        jp.add(datePicker2);
        
        JButton btn=new JButton("Add");
        jp.add(btn);
        panel.removeAll();
        panel.add(jp);
        panel.revalidate();
        panel.repaint();
        
        btn.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                String name = jf1.getText();
                
                Date dob=(Date)datePicker.getModel().getValue();
                String s_dob=dateFormat.format(dob);
                
                long contactinfo;
                contactinfo = Long.parseLong(jf3.getText());
                
                String address=jf4.getText();
                
                int salary=Integer.parseInt(jf5.getText());
                
                Date appointmentDate=(Date)datePicker2.getModel().getValue();
                String s_appointmentDate=dateFormat.format(appointmentDate);
                PreparedStatement ps1;
                
                try {
                    ps1 = con.prepareStatement("select MAX(employeeid) from login");
                    
                    ResultSet rs1=ps1.executeQuery();
                    while(rs1.next()){
                        employeeId=Integer.parseInt(rs1.getString(1))+1;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(StaffFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
                PreparedStatement ps;
                try {
                    ps=con.prepareStatement("insert into staffadmin values (?,?,?,?,?,?,?)");
                    ps.setString(1,""+employeeId);
                    ps.setString(2,name);
                    ps.setString(3,s_dob);
                    ps.setString(4,""+contactinfo);
                    ps.setString(5,address);
                    ps.setString(6,""+salary);
                    ps.setString(7,s_appointmentDate);
                    
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
                }
                PreparedStatement ps2;
                try {
                    ps2=con.prepareStatement("insert into login values (?,?,?,?)");
                    ps2.setString(1,name);
                    ps2.setString(2,name);
                    ps2.setString(3,""+employeeId);
                
                    ps2.setString(4,"staffadmin");
                    ps2.executeUpdate();
            
                } catch (SQLException ex) {
                    Logger.getLogger(StaffFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    public void addReceptionist(JPanel panel){
        JPanel jp=new JPanel(new GridLayout(12,2,4,4));
        JLabel jl1 = new JLabel("Name: ");
        final JTextField jf1=new JTextField();
        JLabel jl2 = new JLabel("DOB: ");
        
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        DateLabelFormatter dateLabel=new DateLabelFormatter();
        final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, dateLabel);
        JLabel jl3 = new JLabel("Contact info:");
        final JTextField jf3=new JTextField();
        JLabel jl4 = new JLabel("Address: ");
        final JTextField jf4=new JTextField();
        JLabel jl5 = new JLabel("Salary: ");
        final JTextField jf5=new JTextField();
        JLabel jl6 = new JLabel("Date of Appointment: ");
        
        UtilDateModel model2 = new UtilDateModel();
        Properties p2 = new Properties();
        p2.put("text.today", "Today");
        p2.put("text.month", "Month");
        p2.put("text.year", "Year");
        JDatePanelImpl datePanel2= new JDatePanelImpl(model2, p2);
        DateLabelFormatter dateLabel2=new DateLabelFormatter();
        final JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2, dateLabel2);
        JLabel jl7 = new JLabel("Shift Date: ");
        
        UtilDateModel model3 = new UtilDateModel();
        Properties p3 = new Properties();
        p3.put("text.today", "Today");
        p3.put("text.month", "Month");
        p3.put("text.year", "Year");
        JDatePanelImpl datePanel3= new JDatePanelImpl(model3, p3);
        DateLabelFormatter dateLabel3=new DateLabelFormatter();
        final JDatePickerImpl datePicker3 = new JDatePickerImpl(datePanel3, dateLabel3);
        JLabel jl8 = new JLabel("Shift Time: ");
        final JTextField jf8=new JTextField();
        
        jp.add(jl1);
        jp.add(jf1);
        jp.add(jl2); 
        jp.add(datePicker); 
        jp.add(jl3); 
        jp.add(jf3);
        jp.add(jl4);
        jp.add(jf4); 
        jp.add(jl5);
        jp.add(jf5); 
        jp.add(jl6);
        jp.add(datePicker2);
        jp.add(jl7);
        jp.add(datePicker3);
        jp.add(jl8); 
        jp.add(jf8);
        
        JButton btn=new JButton("Add");
        jp.add(btn);
        panel.removeAll();
        panel.add(jp);
        panel.revalidate();
        panel.repaint();
        
        btn.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                String name = jf1.getText();
                
                Date dob=(Date)datePicker.getModel().getValue();
                String s_dob=dateFormat.format(dob);
                
                long contactinfo;
                contactinfo = Long.parseLong(jf3.getText());
                
                String address=jf4.getText();
                int salary=Integer.parseInt(jf5.getText());
                
                Date appointmentDate=(Date)datePicker2.getModel().getValue();
                String s_appointmentDate=dateFormat.format(appointmentDate);
                
                Date shiftDate = (Date)datePicker3.getModel().getValue();
                String s_shiftDate = dateFormat.format(shiftDate);
                
                String shiftTime=jf8.getText();
                PreparedStatement ps1;
                
                try {
                    ps1 = con.prepareStatement("select MAX(employeeid) from login");
                    
                    ResultSet rs1=ps1.executeQuery();
                    while(rs1.next()){
                        employeeId=Integer.parseInt(rs1.getString(1))+1;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(StaffFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
                PreparedStatement ps;
                try {
                    ps=con.prepareStatement("insert into receptionist values (?,?,?,?,?,?,?,?,?)");
                    ps.setString(1,""+employeeId);
                
                    ps.setString(2,name);
                    ps.setString(3,s_dob);
                    ps.setString(4,""+contactinfo);
                    ps.setString(5,address);
                    
                    ps.setString(6,""+salary);
                    ps.setString(7,s_appointmentDate);
                    
                    ps.setString(9,shiftTime);
                    ps.setString(8,s_shiftDate);
                    
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
                }
                PreparedStatement ps2;
                try {
                    ps2=con.prepareStatement("insert into login values (?,?,?,?)");
                    ps2.setString(1,name);
                    ps2.setString(2,name);
                    ps2.setString(3,""+employeeId);
                    ps2.setString(4,"receptionist");
                    ps2.executeUpdate();
                    
                } catch (SQLException ex) {
                    Logger.getLogger(StaffFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}

