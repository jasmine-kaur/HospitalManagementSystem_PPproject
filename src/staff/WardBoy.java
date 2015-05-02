/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staff;

import BasicDetails.Address;
import BasicDetails.Name;
import BasicLayout.BasicLayout;
import java.awt.Color;
import java.awt.Component;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static login.LogIn.con;

/**
 *
 * @author Mansi Verma
 */
public class WardBoy implements Staff{
    private int employeeId;
    private Name name;
    private Date dateOfBirth;
    private Long contactInfo;
    private Address address;
    private int salary;
    private Frame frame;
    private JPanel jFunction;
    private JPanel left;
    private JPanel right;
    BasicLayout basicLayout;
    private Component cp;

    
    public WardBoy(int employeeid)
    {
       employeeId=employeeid;
    }
    
    
    @Override
    public void viewProfile() {
        
         JOptionPane.showMessageDialog(cp, "view Profile");
        try {
           
           
           PreparedStatement ps=con.prepareStatement("select * from wardboy where employeeid=?");
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
               
           
        } catch (SQLException ex) {
            Logger.getLogger(WardBoy.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    public void addUI(){
        
        JButton jViewProfile= new JButton("View Profile");
        JButton jCheckWardDuty = new JButton("Check Ward Duty");
        
        basicLayout= new BasicLayout();
        basicLayout.addUI();
        
        left= new JPanel(new GridLayout(10,1, 4,4 ));
     
        right= new JPanel();
        
        
        right.setBackground(Color.PINK);
        jFunction = basicLayout.getFunctions();
        
        jFunction.setLayout(new GridLayout(1, 2,4,4));
         
       
        left.add(jViewProfile);
        left.add(jCheckWardDuty);
        
        
        jFunction.add(left);
        jFunction.add(right);
        
        jViewProfile.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                viewProfile();
            }
        } );
        
        
        jCheckWardDuty.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                Date date = new Date();
                System.out.println(dateFormat.format(date));
                checkWardDuty(date);
            }
        } );
    }
    
    public void checkWardDuty(Date date){
        
        JOptionPane.showMessageDialog(cp, "check ward duty");
        
        try {
           
           
           PreparedStatement ps=con.prepareStatement("select * from wardboy where employeeid=?");
           ps.setString(1, Integer.toString(employeeId));
           ResultSet rs = ps.executeQuery();

            JPanel jp=new JPanel(new GridLayout(12,1,4,4));
            jp.setBackground(Color.pink);
            while(rs.next()) {
                JLabel jl1 = new JLabel("Shift timimgs: "+rs.getString("shifttime"));
                jp.add(jl1); 
            }
            
            right.add(jp);
        }catch(SQLException ex) {
            Logger.getLogger(WardBoy.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
  
            
}
