/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infrastructure;

import BasicDetails.Address;
import BasicDetails.Name;
import BasicLayout.BasicLayout;
import department.DepartmentAdmin;
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
import java.util.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static login.LogIn.con;
import staff.*;

/**
 *
 * @author Mansi Verma
 */
public class InfraAdmin implements Staff{
    
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
    
    public InfraAdmin(int employeeid)
    {
        employeeId=employeeid;
    }
    
    public void addUI(){
        
        JButton jViewProfile= new JButton("View Profile");
        jViewProfile.setPreferredSize(new Dimension(50,50));
        JButton jViewTender = new JButton("View Tender");
        JButton jReceiveTender= new JButton("Receive Tender");
        JButton jCheckTenderForApproval = new JButton("Check Tender For Approval");
        //JButton jSendApprovedTender = new JButton("Send Approved Tender");
        //JButton jGeneratePharmaceuticalTender = new JButton("Generate Pharmaceutical Tender");
        JButton jViewDepartmentInfrastructureDetail = new JButton("View Department Infra Detail");
        JButton jUpdateDepartmentInfrastructureDetail = new JButton("Update Department Infra Detail");
        
        
        basicLayout= new BasicLayout();
        basicLayout.addUI();
        
        left= new JPanel(new GridLayout(10,1, 4,4 ));
     
        right= new JPanel();
        
        
        right.setBackground(Color.PINK);
        jFunction = basicLayout.getFunctions();
        
        jFunction.setLayout(new GridLayout(1, 2,4,4));
         
        left.add(jViewProfile);
        left.add(jViewTender);
        left.add(jReceiveTender);
        left.add(jCheckTenderForApproval);
        //left.add(jSendApprovedTender);
        //left.add(jGeneratePharmaceuticalTender);
        left.add(jViewDepartmentInfrastructureDetail);
        left.add(jUpdateDepartmentInfrastructureDetail);
        
        jFunction.add(left);
        jFunction.add(right);
        
        
        jViewProfile.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                
                viewProfile();
                
            }
        } );
        
        jViewTender.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                
                viewTender();
                
            }
        } );
        
        jReceiveTender.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                
                receiveTender();
                
            }
        } );
        
        jCheckTenderForApproval.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                
                checkTenderForApproval();
                
            }
        } );
        
        jViewDepartmentInfrastructureDetail.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                
               viewDepartmentInfrastructureDetail();
                
            }
        } );
        
        jUpdateDepartmentInfrastructureDetail.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                
               updateDepartmentInfrastructureDetail();
                
            }
        } );
    }
    
    @Override
    public void viewProfile(){
        
        JOptionPane.showMessageDialog(cp, "view Profile");
        try {
           
            right.removeAll();
           
           PreparedStatement ps=con.prepareStatement("select * from infraadmin where employeeid=?");
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
             
 
                jp.add(jl1); 
                jp.add(jl2);
                jp.add(jl3);
                jp.add(jl4);
                jp.add(jl5);
 
                            
        }
           
          right.add(jp);
          right.revalidate();
          right.repaint();
           
        } catch (SQLException ex) {
            Logger.getLogger(InfraAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void viewTender(){
        JOptionPane.showMessageDialog(cp, "View the Tenders");
        try {
            
            right.removeAll();
            PreparedStatement ps = con.prepareStatement("select * from tender");
            //ps.setString(1,"created");
            //System.out.println(employeeId);
            //ps.setString(1, Integer.toString(employeeId));
            ResultSet rs = ps.executeQuery();
            ArrayList<JLabel> jl =new ArrayList<>();
            int count=1; 
            while(rs.next()) {
                jl.add(new JLabel(rs.getString("tenderid")));
                jl.add(new JLabel(rs.getString("departmenttype")));
                //jl.add(new JLabel(rs.getString("dob")));
                jl.add(new JLabel(rs.getString("tenderamountlimit")));
                jl.add(new JLabel(rs.getString("equipments")));
                jl.add(new JLabel(rs.getString("tenderstatus")));
                //jl.add(new JLabel(rs.getString("salary")));
                //jl.add(new JLabel(rs.getString("dateofappointment")));
                count++; 
                               
            }
            JPanel jp;
            jp=new JPanel();
            jp.setLayout(new GridLayout(count,5,4,4));
            jp.setBackground(Color.pink);
            jp.add(new JLabel("tenderid"));
            jp.add(new JLabel("departmenttype"));
            //jp.add(new JLabel("dob"));
            jp.add(new JLabel("tenderamountlimit"));
            jp.add(new JLabel("equipments"));
            jp.add(new JLabel("tenderstatus"));
            //jp.add(new JLabel("dateofappointment"));
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
    
    public void receiveTender(){
       //set status of tender to received
        JOptionPane.showMessageDialog(cp, "Receive the new Tenders");
        try {
            
            right.removeAll();
            PreparedStatement ps = con.prepareStatement("select * from tender where tenderstatus=?");
            ps.setString(1,"created");
            //System.out.println(employeeId);
            //ps.setString(1, Integer.toString(employeeId));
            ResultSet rs = ps.executeQuery();
            ArrayList<JLabel> jl =new ArrayList<>();
            int count=1; 
            while(rs.next()) {
                jl.add(new JLabel(rs.getString("tenderid")));
                jl.add(new JLabel(rs.getString("departmenttype")));
                //jl.add(new JLabel(rs.getString("dob")));
                jl.add(new JLabel(rs.getString("tenderamountlimit")));
                jl.add(new JLabel(rs.getString("equipments")));
                //jl.add(new JLabel(rs.getString("address")));
                //jl.add(new JLabel(rs.getString("salary")));
                //jl.add(new JLabel(rs.getString("dateofappointment")));
                count++; 
                               
            }
            JPanel jp;
            jp=new JPanel();
            JPanel jp1=new JPanel();
            jp1.setLayout(new GridLayout(count,4,4,4));
            jp1.setBackground(Color.pink);
            jp1.add(new JLabel("tenderid"));
            jp1.add(new JLabel("departmenttype"));
            //jp.add(new JLabel("dob"));
            jp1.add(new JLabel("tenderamountlimit"));
            jp1.add(new JLabel("equipments"));
            //jp.add(new JLabel("salary"));
            //jp.add(new JLabel("dateofappointment"));
            for(int i=0;i<jl.size();i++){
                jp1.add(jl.get(i));
            }
            jp.add(jp1);
            JButton btn=new JButton("Received");
            jp.add(btn);
            right.removeAll();
            right.add(jp);
            right.revalidate();
            right.repaint();
            btn.addActionListener(new ActionListener(){
                    
                    public void actionPerformed(ActionEvent e)
                    {
                        try {
                            PreparedStatement ps1 = con.prepareStatement("update tender set tenderstatus=? where tenderstatus=?");
                            ps1.setString(1,"received");
                            ps1.setString(2,"created");
                            ps1.executeUpdate();
                        } catch (SQLException ex) {
                            Logger.getLogger(InfraAdmin.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
        } catch (SQLException ex) {
            Logger.getLogger(StaffAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void checkTenderForApproval(){
        
        //view tenders where status =created
        JOptionPane.showMessageDialog(cp, "Check Tenders");
        Tender tender=new Tender();
        tender.checkTenderForApproval(right);
    }
    
    
    public void viewDepartmentInfrastructureDetail(){ //Department
        
        //take dept name as input and execute select query on equipment table
        
                right.removeAll();
                
                
                final JPanel form= new JPanel(new GridLayout(10,1, 4,4 ));
                form.setBackground(Color.PINK);
                

                JButton submitButton = new JButton("Submit");
                submitButton.setBounds(150, 160, 100, 30);
                JLabel departmentLabel= new JLabel("Department name:");
                
                final JTextField departmentField= new JTextField();
        
                
                form.add(departmentLabel);
                form.add(departmentField);

                form.add(submitButton);
                right.add(form);
                

                submitButton.addActionListener(new ActionListener(){
                    
                    public void actionPerformed(ActionEvent e)
                    {

                        try {
                            JOptionPane.showMessageDialog(null,"Submission Successful!");
                            
                            right.removeAll();
                 
                            System.out.println("a");
                
                            final JPanel jp= new JPanel(new GridLayout(10,1, 4,4 ));
                            jp.setBackground(Color.PINK);
                
                            System.out.println("b");
                            String deptName = departmentField.getText();
                            
                            System.out.println("dept name:"+deptName);
                      //      viewDepartmentInfrastructureDetail();
                            
                            PreparedStatement ps=con.prepareStatement("select * from equipment where departmenttype=?");
                            ps.setString(1,deptName);
                            ResultSet rs = ps.executeQuery();
                            
                            while(rs.next())
                            {
                                System.out.println("c");
                                JLabel jl1 = new JLabel("Equipment Id: "+rs.getString("equipmentid"));
                                JLabel jl2 = new JLabel("Name: "+rs.getString("equipmentname"));
                                JLabel jl3 = new JLabel("Quantity: "+rs.getString("quantity"));
                                
                                jp.add(jl1);
                                jp.add(jl2);
                                jp.add(jl3);
                                
                            }
                            
                            System.out.println("d");
                            right.add(jp);
                            System.out.println("e");
                            right.repaint();
                        } catch (SQLException ex) {
                            Logger.getLogger(InfraAdmin.class.getName()).log(Level.SEVERE, null, ex);
                     }//action performed closes here
             
                  }});
                   
            
                
            
           
              
       

    }
        
    public void updateDepartmentInfrastructureDetail(){ //Department
        
        //take dept name as input and execute update query on equipment table
        right.removeAll();
                
                
                final JPanel form= new JPanel(new GridLayout(10,1, 4,4 ));
                form.setBackground(Color.PINK);
                

                JButton submitButton = new JButton("Submit");
                submitButton.setBounds(150, 160, 100, 30);
                JLabel departmentLabel= new JLabel("Department name:");
                
                final JTextField departmentField= new JTextField();
        
                
                form.add(departmentLabel);
                form.add(departmentField);

                form.add(submitButton);
                right.removeAll();
                right.add(form);
                 right.repaint();
                            right.revalidate();

                submitButton.addActionListener(new ActionListener(){
            private JTextField equipmentIdField;
                    
                    public void actionPerformed(ActionEvent e)
                    {

                        try {
                            JOptionPane.showMessageDialog(null,"Submission Successful!");
                            
                            right.removeAll();
                 
                            System.out.println("a");
                
                            final JPanel jp= new JPanel(new GridLayout(10,1, 4,4 ));
                            jp.setBackground(Color.PINK);
                
                            System.out.println("b");
                            String deptName = departmentField.getText();
                            
                            System.out.println("dept name:"+deptName);
                      //      viewDepartmentInfrastructureDetail();
                            
                            PreparedStatement ps=con.prepareStatement("select * from equipment where departmenttype=?");
                            ps.setString(1,deptName);
                            ResultSet rs = ps.executeQuery();
                            
                            while(rs.next())
                            {
                                System.out.println("c");
                                JLabel jl1 = new JLabel("Equipment Id: "+rs.getString("equipmentid"));
                                JLabel jl2 = new JLabel("Name: "+rs.getString("equipmentname"));
                                JLabel jl3 = new JLabel("Quantity: "+rs.getString("quantity"));
                                
                                jp.add(jl1);
                                jp.add(jl2);
                                jp.add(jl3);
                                
                            }
                            
                            
                            //right.add(jp);
                            
                            JLabel equipmentIdLabel =new JLabel("enter equipment id:");
                            equipmentIdField = new JTextField();
                          
                           // System.out.println("yes"+equipId);
                            JButton submit = new JButton("Submit");
                            
                            jp.add(equipmentIdLabel);
                            jp.add(equipmentIdField);
                            jp.add(submit);
                            right.removeAll();
                            right.add(jp);
                            right.revalidate();
                            right.repaint();
                            
                            //action listener for submit
                            submit.addActionListener(new ActionListener() { 
                                private JTextField newNameField;
                                private JTextField newQtyField;
                            @Override
                            public void actionPerformed(ActionEvent e) { 
                                
                               //take input for new values
                                 final String equipId = equipmentIdField.getText();
                                
                               JLabel newName = new JLabel("equipment name:");
                               newNameField = new JTextField();
                               
                               JLabel newQty = new JLabel("equipment quantity:");
                               newQtyField = new JTextField();
                               JButton submit = new JButton("Submit");
                              
                               //create new jp here
                               final JPanel jp2= new JPanel(new GridLayout(10,1, 4,4 ));
                            jp2.setBackground(Color.PINK);
                               
                               jp2.add(newName);
                               jp2.add(newNameField);
                               
                               jp2.add(newQty);
                               jp2.add(newQtyField);
                               jp2.add(submit);
                               right.removeAll();
                               right.add(jp2);
                               right.revalidate();
                               right.repaint();
                            
                               submit.addActionListener(new ActionListener() { 
                                   @Override
                                   public void actionPerformed(ActionEvent e) { 
                                //extracting the values from the form
                              JOptionPane.showMessageDialog(null,"Updation Successful!");
                               String updateName = newNameField.getText();
                               int updateQuantity = Integer.parseInt(newQtyField.getText());
                               //update on equipment id
                               try{
                                   PreparedStatement ps2 = con.prepareStatement("update equipment set equipmentname=?, quantity=? where equipmentid=?");
                                   ps2.setString(1,updateName);
                                   ps2.setString(2,""+updateQuantity);
                                   
                                   ps2.setString(3,equipId);
                                   
                                   ps2.executeUpdate();
                               }catch (SQLException ex) {
                            Logger.getLogger(InfraAdmin.class.getName()).log(Level.SEVERE, null, ex);}}});
                                
                            
                
                                 }
                                } );
                            
                            //action listener ends here
                            
                            
                        } catch (SQLException ex) {
                            Logger.getLogger(InfraAdmin.class.getName()).log(Level.SEVERE, null, ex);
                     }//action performed closes here
             
                  }});
                   
            
        
    }
    
}