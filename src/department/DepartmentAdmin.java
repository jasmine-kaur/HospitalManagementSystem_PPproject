/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package department;

import BasicDetails.*;
import BasicLayout.BasicLayout;
import infrastructure.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static login.LogIn.con;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import staff.*;

/**
 *
 * @author Mansi Verma
 */
public class DepartmentAdmin implements Staff{
    
    public static int numberOfTenders=0;
    private int employeeId;
    private Name name;
    private Date dateOfBirth;
    private Long contactInfo;
    private Address address;
    private int salary;
    private DepartmentType departmentName;
    private Frame frame;
    private JPanel jFunction;
    private JPanel left;
    private JPanel right;
    BasicLayout basicLayout;
    private Component cp;
   
    
    
    public DepartmentAdmin(int employeeid)
    {
        employeeId=employeeid;
    }
    
    
    @Override
    public void viewProfile(){
        
        
        JOptionPane.showMessageDialog(cp, "view Profile");
        try {
           
            right.removeAll();
           
           PreparedStatement ps=con.prepareStatement("select * from departmentadmin where employeeid=?");
           ps.setString(1, Integer.toString(employeeId));
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
          right.repaint();
           
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void addUI(){
        
        JButton jViewProfile= new JButton("View Profile");
        jViewProfile.setPreferredSize(new Dimension(50,50));
        JButton jScheduleDoctor= new JButton("Schedule Doctor");
        JButton jCallTender = new JButton("Call tender");
        JButton jOpenTender=new JButton("Open tender");
        JButton jCloseTender=new JButton("Close tender");
        JButton jViewEquipments = new JButton("View Equipments");
        //JButton jSendFundRequest = new JButton("Send Fund Request");
        //JButton jGetFundApproval = new JButton("Get Fund Approval");
        
        basicLayout= new BasicLayout();
        basicLayout.addUI();
        
        left= new JPanel(new GridLayout(10,1, 4,4 ));
     
        right= new JPanel();
        
        
        right.setBackground(Color.PINK);
        jFunction = basicLayout.getFunctions();
        
        jFunction.setLayout(new GridLayout(1, 2,4,4));
         
        left.add(jViewProfile);
        left.add(jScheduleDoctor);
        left.add(jCallTender);
        left.add(jOpenTender);
        left.add(jCloseTender);
        left.add(jViewEquipments);
        //left.add(jSendFundRequest);
        //left.add(jGetFundApproval);
        
        
        jFunction.add(left);
        jFunction.add(right);
        
        //adding customer panel
        
        jViewProfile.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                
                viewProfile();
                
            }
        } );
        
        jScheduleDoctor.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                
                right.removeAll();
                
                
                JPanel form= new JPanel(new GridLayout(10,1, 4,4 ));
                form.setBackground(Color.PINK);
                

                JButton submitButton = new JButton("Submit");
                submitButton.setBounds(150, 160, 100, 30);
                JLabel doctorIdLabel= new JLabel("Doctor Id:");
                JLabel timeLabel= new JLabel("Time:");
                
                
                UtilDateModel model = new UtilDateModel();
                Properties p = new Properties();
                p.put("text.today", "Today");
                p.put("text.month", "Month");
                p.put("text.year", "Year");
                JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
                DateLabelFormatter dateLabel=new DateLabelFormatter();
                final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, dateLabel);
                
                
                final JTextField doctorIdField= new JTextField();
                final JTextField dateField= new JTextField();
                final JTextField timeField= new JTextField();
        
                form.add(doctorIdLabel);
                form.add(doctorIdField);
                
                form.add(datePicker);
                
                form.add(timeLabel);
                form.add(timeField);

                form.add(submitButton);
                right.add(form);
                

                submitButton.addActionListener(new ActionListener(){
                    
                    public void actionPerformed(ActionEvent e)
                    {

                        JOptionPane.showMessageDialog(null,

                   "Submission Successful!");
                        
                        String doctor_id = doctorIdField.getText();
                        Date scheduled_date_obj1=(Date)datePicker.getModel().getValue();
                        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                        String scheduled_date=dateFormat.format(scheduled_date_obj1);
                       // String scheduled_date= scheduled_date_obj1.toString();
                        String scheduled_time=timeField.getText();
                        
                
                
                doctorScheduling(doctor_id,scheduled_date,scheduled_time);
                
                    }
                });
                
            }
        } );
        
        
        jViewEquipments.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                
                viewEquipments();
                
            }
        } );
        
        jCallTender.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                
                callTenders();
                
            }
        } );
        
        jOpenTender.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                
                Tender tender = new Tender();
                tender.openTender(right);
                
            }
        } );
        
        jCloseTender.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                
                Tender tender = new Tender();
                tender.closeTender(right);
                
            }
        } );     
        
    }
    
    
    public void doctorScheduling(String docId,String dateScheduled,String timeScheduled){
        
        try{
            
           PreparedStatement ps=con.prepareStatement("update doctor set shiftdate=?,shifttime=? where employeeid=?");
           
           ps.setString(1,dateScheduled);
           ps.setString(2, timeScheduled);
           ps.setString(3,docId);
           ps.executeUpdate(); 
           
           right.repaint(); 
        }
        
        catch(SQLException ex) {
            Logger.getLogger(DepartmentAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    public void callTenders(){
        //create a new tender
        right.removeAll();
        JOptionPane.showMessageDialog(cp, "calling tenders");
        JPanel jp=new JPanel(new GridLayout(3, 2, 4, 4));
        jp.setBackground(Color.pink);
        //JLabel jl1 = new JLabel("Department Name: ");
        //final JTextField jf1 = new JTextField();
        JLabel jl2 = new JLabel("Tender amount limit:");
        final JTextField jf2 = new JTextField();
        JLabel jl3 = new JLabel("Equipments in Tender:");
        final JTextField jf3 = new JTextField();
        //JLabel jl4 = new JLabel("Tender Status:");
        //final JTextField jf4 = new JTextField();
        
        
        //jp.add(jl1);
        //jp.add(jf1);
        jp.add(jl2);
        jp.add(jf2);
        jp.add(jl3);
        jp.add(jf3);
        //jp.add(jl4);
        //jp.add(jf4);
        
        JButton btn = new JButton("Done");
        jp.add(btn);
        right.add(jp);
        right.revalidate();
        right.repaint();
        
        btn.addActionListener(new ActionListener(){
                    
                    public void actionPerformed(ActionEvent e)
                    {
                
                      String departmentName="";
                      PreparedStatement st;
                        try {
                            st = con.prepareStatement("select * from departmentadmin where employeeid=?");
                            st.setString(1,Integer.toString(employeeId));
                            ResultSet resultset=st.executeQuery();
                            while(resultset.next())
                            {
                                departmentName=resultset.getString("departmentname");
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(DepartmentAdmin.class.getName()).log(Level.SEVERE, null, ex);
                        }
                      
                      
                      
                      int tenderAmountLimit = Integer.parseInt(jf2.getText());
                      String equipments = jf3.getText();
                      String tenderStatus = "created";
                      
                      PreparedStatement ps;
                      ResultSet rs;
                      int tenderId=-1;
                        try {
                            ps=con.prepareStatement("select MAX(tenderid) from tender");
                            rs=ps.executeQuery();
                            while(rs.next()){
                                if(rs.getString(1)==null){tenderId=1;}
                                else{tenderId=Integer.parseInt(rs.getString(1))+1;}
                            }
                            //if(rs.getString(1)==null){return;}
                        } catch (SQLException ex) {
                            Logger.getLogger(DepartmentAdmin.class.getName()).log(Level.SEVERE, null, ex);
                        }
                      PreparedStatement ps1;
                        try {
                            
                            ps1=con.prepareStatement("insert into tender values (?,?,?,?,?,?,? )");
                            ps1.setString(1, ""+tenderId);
                            ps1.setString(2, departmentName);
                            ps1.setString(3, ""+tenderAmountLimit);
                            ps1.setString(4, equipments);
                            ps1.setString(5, tenderStatus);
                            ps1.setString(6, ""+0);
                            ps1.setString(7, "none");
                            ps1.executeUpdate();
                            
                        } catch (SQLException ex) {
                            Logger.getLogger(DepartmentAdmin.class.getName()).log(Level.SEVERE, null, ex);
                        }
                
                    }
        });
        
    }
    
    
    public void viewEquipments(){
        
        JOptionPane.showMessageDialog(cp, "view Equipments");
        String dept= new String();
        
        try{
            
            right.removeAll();
            JPanel jp=new JPanel(new GridLayout(12,1,4,4));
            jp.setBackground(Color.pink);
            
            //query1
            PreparedStatement st = con.prepareStatement("select * from departmentadmin where employeeid=?");
            
            st.setString(1,Integer.toString(employeeId));
            ResultSet resultset=st.executeQuery();
            while(resultset.next())
            {
                dept=resultset.getString("departmentname");
            }
            
            //query2
            PreparedStatement ps=con.prepareStatement("select * from equipment where departmenttype=?");
            ps.setString(1,dept);
            ResultSet rs = ps.executeQuery();
           
            
            while(rs.next()) {
                JLabel jl1 = new JLabel("Equipment Id: "+rs.getString("equipmentid"));
                JLabel jl2 = new JLabel("Name: "+rs.getString("equipmentname"));
                JLabel jl3 = new JLabel("Quantity: "+rs.getString("quantity"));
                
                jp.add(jl1);
                jp.add(jl2);
                jp.add(jl3);
                
            }
          
             right.add(jp);
             right.repaint();
             
        }
        catch(SQLException ex) {
            Logger.getLogger(DepartmentAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

}