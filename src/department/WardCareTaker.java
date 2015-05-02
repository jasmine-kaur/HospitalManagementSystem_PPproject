/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package department;

import java.util.Date;
import java.awt.Frame;
import staff.*;
import infrastructure.*;
import BasicDetails.*;
import BasicLayout.BasicLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static login.LogIn.con;
import patient.*;

/**
 *
 * @author Devanshu
 */
public class WardCareTaker implements Staff{
    private int employeeId;
    private int wardId;
    boolean wardAvailable=false;
    int wardBedAvailable=0;
    private Name name;
    private Date dateOfBirth;
    private Long contactInfo;
    private Address address;
    private int salary;
    private Frame frame;
    private JPanel jFunction;
    private JPanel right;
    private JPanel left;
    private Component cp;
    
    public WardCareTaker(int employeeId){
        this.employeeId=employeeId;
    }
    
    @Override
    public void viewProfile() {
        
        try{ //To change body of generated methods, choose Tools | Templates.
        
            PreparedStatement ps=con.prepareStatement("select * from wardcaretaker where employeeid =?");
            ps.setString(1, ""+employeeId);
            System.out.println(employeeId);
            java.sql.ResultSet rs = ps.executeQuery();
            
            JPanel jp=new JPanel(new GridLayout(12,1,4,4));
            jp.setBackground(Color.pink);
            while(rs.next()) {
                JLabel jname = new JLabel("Name: "+rs.getString("name"));
                JLabel jdob = new JLabel("DOB: "+ rs.getString("dob"));
                JLabel jcontactinfo = new JLabel("Contact info:" +rs.getString("contactinfo"));
                JLabel jaddress = new JLabel("Address: "+rs.getString("address"));
                
                JLabel jsalary = new JLabel("Salary: "+rs.getString("salary"));
                
                jp.add(jname);  
                jp.add(jdob); 
                jp.add(jcontactinfo); 
                jp.add(jaddress); 
                jp.add(jsalary); 

               }
            right.removeAll();
            right.add(jp);
            right.revalidate();
            right.repaint();
            
        }
        catch(SQLException ex){
            Logger.getLogger(WardCareTaker.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public void addUI(){
        
        JButton viewPro= new JButton("View Profile");

        JButton assignWard= new JButton("Assign Ward");
        
        JButton checkWardAvailable = new JButton("Check Ward Availability");
        
        BasicLayout basicLayout= new BasicLayout();
        basicLayout.addUI();
        
        left= new JPanel(new GridLayout(10,1, 4,4 ));
     
        right= new JPanel();

        right.setBackground(Color.PINK);
        jFunction = basicLayout.getFunctions();
        
        jFunction.setLayout(new GridLayout(1,2,4,4));
        
        left.add(viewPro);
         
        left.add(assignWard);
       
        left.add(checkWardAvailable);

        jFunction.add(left);
        jFunction.add(right);
        
        assignWard.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                assignWard();
            }
        } );
        
        
        checkWardAvailable.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                checkWardAvailability();
            }
        });
        
        viewPro.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                viewProfile();
            }
        });
        
    }
    
    JTextField wardidField;
    public void checkWardAvailability(){

        JPanel form= new JPanel(new GridLayout(10,1,4,4 ));
        form.setBackground(Color.PINK);
        
        JLabel wardidLabel= new JLabel("Ward Number:");
        wardidField= new JTextField();
        form.add(wardidLabel);
        form.add(wardidField);
        
        JButton submit=new JButton("Submit");
        form.add(submit);
        
        submit.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
//        int wardAvailable=0;
        try{
            PreparedStatement ps=con.prepareStatement("select * from ward where wardid =?");
            ps.setString(1, wardidField.getText());
            java.sql.ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            if(rs.getString("patient1id").equals("-1") ){
                JOptionPane.showMessageDialog(cp,"Ward is available");
            }
        else if(rs.getString("patient2id").equals("-1")){
            JOptionPane.showMessageDialog(cp,"Ward is available");
        }
        else if(rs.getString("patient3id").equals("-1")){
            JOptionPane.showMessageDialog(cp,"Ward is available");
        }
        else if(rs.getString("patient4id").equals("-1")){
            JOptionPane.showMessageDialog(cp,"Ward is available");
        }
        else{
            JOptionPane.showMessageDialog(cp,"Ward is not available");
        }}
        
        }catch(SQLException ex){
            Logger.getLogger(WardCareTaker.class.getName()).log(Level.SEVERE,null,ex);
        }
     
        }
        } );
        right.removeAll();
        right.add(form);
        right.revalidate();
        right.repaint();
        
    }
            
    public int checkWardAvailabilityCall(String wardId){
 
        try{
            PreparedStatement ps=con.prepareStatement("select * from ward where wardid =?");
            ps.setString(1, wardId);
            java.sql.ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            if(rs.getString("patient1id").equals("-1") ){
                //wardAvailable=true;
                wardBedAvailable=1;
            }
        else if(rs.getString("patient2id").equals("-1")){
            //wardAvailable=true;
            wardBedAvailable=2;
        }
        else if(rs.getString("patient3id").equals("-1")){
            //wardAvailable=true;
            wardBedAvailable=3;
        }
        else if(rs.getString("patient4id").equals("-1")){
            //wardAvailable=true;
            wardBedAvailable=4;
        }
        else{
            JOptionPane.showMessageDialog(cp,"Ward is not available");
        }}
        
        }catch(SQLException ex){
            Logger.getLogger(WardCareTaker.class.getName()).log(Level.SEVERE,null,ex);
        }
        return wardBedAvailable;
    }
    
    JTextField registrationidField,wardnumberField;
    public void assignWard(){
        
        JPanel form= new JPanel(new GridLayout(10,1,4,4 ));
        form.setBackground(Color.PINK);
        
        JLabel registrationidLabel= new JLabel("Registration ID of patient:");
        registrationidField= new JTextField();
        form.add(registrationidLabel);
        form.add(registrationidField);
        
        JLabel wardnumberLabel= new JLabel("Ward Number:");
        wardnumberField= new JTextField();
        form.add(wardnumberLabel);
        form.add(wardnumberField);
        
        JButton submit=new JButton("Submit");
        form.add(submit);
        
        submit.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                try{
                
                int wardBedAvail=checkWardAvailabilityCall(wardnumberField.getText());
                System.out.println(wardBedAvail);
                if (wardBedAvail!=-1){
                    PreparedStatement ps = con.prepareStatement("update patientrecord set wardnumber = ? where registrationid=?");
                    ps.setString(1, wardnumberField.getText());
                    ps.setString(2, registrationidField.getText());
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(cp, "Ward assigned to patient");
                    
                    if(wardBedAvail==1){
                        
                        PreparedStatement ps1 = con.prepareStatement("update ward set patient1id = ? where wardid=?");
                        ps1.setString(1, registrationidField.getText());
                        System.out.println(registrationidField.getText());
                        ps1.setString(2, wardnumberField.getText());
                        System.out.println(wardnumberField.getText());
                        ps1.executeUpdate();
                    }
                    else if(wardBedAvail==2){
                        PreparedStatement ps1 = con.prepareStatement("update ward set patient2id = ? where wardid=?");
                        ps1.setString(1, registrationidField.getText());
                        ps1.setString(2, wardnumberField.getText());
                        ps1.executeUpdate();}
                    else if(wardBedAvail==3){
                        PreparedStatement ps1 = con.prepareStatement("update ward set patient3id = ? where wardid=?");
                        ps1.setString(1, registrationidField.getText());
                        ps1.setString(2, wardnumberField.getText());
                        ps1.executeUpdate();}
                    else if(wardBedAvail==4){
                        PreparedStatement ps1 = con.prepareStatement("update ward set patient4id = ? where wardid=?");
                        ps1.setString(1, registrationidField.getText());
                        ps1.setString(2, wardnumberField.getText());
                        ps1.executeUpdate();}
                    else{
                        
                    } 
                    wardBedAvailable=-1;
                }
                
                else{
                    JOptionPane.showMessageDialog(cp, "Ward is not available");
                }
                
                }catch(SQLException ex){
                    Logger.getLogger(WardCareTaker.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } );
        right.removeAll();
        right.add(form);
        right.revalidate();
        right.repaint();
    }
}
