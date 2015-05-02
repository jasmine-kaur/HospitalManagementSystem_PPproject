/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infrastructure;

import staff.*;
import BasicDetails.*;
import java.awt.Color;
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
import javax.swing.JPanel;
import javax.swing.JTextField;
import static login.LogIn.con;

/**
 *
 * @author Mansi Verma
 */
public class Tender {
    
    private long tenderId;
    private DepartmentType departmentType;
    private int tenderAmountLimit;
    private ArrayList<Equipment> equipments; 
    private Name departmentAdmin;
    private String tenderStatus;
    private int tenderAmount;
    
    public long getTenderId(){
        return tenderId;
    }
    
    public DepartmentType getDepartmentType(){
        return departmentType;
        
    }
    
    public int getTenderAmountLimit(){
        return tenderAmountLimit;
    }
    
    public void openTender(JPanel right){
        try {
            
            right.removeAll();
            PreparedStatement ps = con.prepareStatement("select * from tender where tenderstatus=?");
            ps.setString(1,"approved");
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
                //jl.add(new JLabel(rs.getString("tenderstatus")));
                //jl.add(new JLabel(rs.getString("salary")));
                //jl.add(new JLabel(rs.getString("dateofappointment")));
                count++; 
                               
            }
            JPanel jp;
            jp=new JPanel();
            jp.setLayout(new GridLayout(count+1,4,4,4));
            jp.setBackground(Color.pink);
            jp.add(new JLabel("tenderid"));
            jp.add(new JLabel("departmenttype"));
            //jp.add(new JLabel("dob"));
            jp.add(new JLabel("tenderamountlimit"));
            jp.add(new JLabel("equipments"));
            //jp.add(new JLabel("tenderstatus"));
            //jp.add(new JLabel("dateofappointment"));
            for(int i=0;i<jl.size();i++){
                jp.add(jl.get(i));
            }
            JLabel jl1=new JLabel("Tender ID:");
            final JTextField jf1=new JTextField();
            JButton btn1=new JButton("Open");
            btn1.setSize(5, 5);
            //JButton btn2=new JButton("Reject");
            jp.add(jl1);
            jp.add(jf1);
            jp.add(btn1);
            //jp.add(btn2);
            right.removeAll();
            right.add(jp);
            right.revalidate();
            right.repaint();
            btn1.addActionListener(new ActionListener(){
                    
                    public void actionPerformed(ActionEvent e)
                    {
                        int tenderId=Integer.parseInt(jf1.getText());
                        try {
                            
                            PreparedStatement ps1 = con.prepareStatement("update tender set tenderstatus=? where tenderid=? and tenderstatus=?");
                            ps1.setString(1,"open");
                            ps1.setString(2,""+tenderId);
                            ps1.setString(3,"approved");
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
    
    public void closeTender(JPanel right){
        try {
            
            right.removeAll();
            PreparedStatement ps = con.prepareStatement("select * from tender where tenderstatus=?");
            ps.setString(1,"open");
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
                //jl.add(new JLabel(rs.getString("tenderstatus")));
                //jl.add(new JLabel(rs.getString("salary")));
                //jl.add(new JLabel(rs.getString("dateofappointment")));
                count++; 
                               
            }
            JPanel jp;
            jp=new JPanel();
            jp.setLayout(new GridLayout(count,4,4,4));
            jp.setBackground(Color.pink);
            jp.add(new JLabel("tenderid"));
            jp.add(new JLabel("departmenttype"));
            //jp.add(new JLabel("dob"));
            jp.add(new JLabel("tenderamountlimit"));
            jp.add(new JLabel("equipments"));
            //jp.add(new JLabel("tenderstatus"));
            //jp.add(new JLabel("dateofappointment"));
            for(int i=0;i<jl.size();i++){
                jp.add(jl.get(i));
            }
            JPanel jp1=new JPanel(new GridLayout(4,2,4,4));
            jp1.setSize(4,4);
            jp1.setBackground(Color.PINK);
            JLabel jl1=new JLabel("Tender ID:");
            final JTextField jf1=new JTextField();
            JLabel jl2=new JLabel("Tender Amount:");
            final JTextField jf2=new JTextField();
            JLabel jl3=new JLabel("Company allotted to:");
            final JTextField jf3=new JTextField();
            JButton btn1=new JButton("Select");
            //JButton btn2=new JButton("Reject");
            jp1.add(jl1);
            jp1.add(jf1);
            jp1.add(jl2);
            jp1.add(jf2);
            jp1.add(jl3);
            jp1.add(jf3);
            jp1.add(btn1);
            
            right.removeAll();
            right.setLayout(new GridLayout(2, 1, 4, 4));
            right.add(jp);
            right.add(jp1);
            right.revalidate();
            right.repaint();
            btn1.addActionListener(new ActionListener(){
                    
                    public void actionPerformed(ActionEvent e)
                    {
                        int tenderId=Integer.parseInt(jf1.getText());
                        int tenderAmount=Integer.parseInt(jf2.getText());
                        String company = jf3.getText();
                        int tenderAmountLimit=0;
                        try {
                            PreparedStatement ps2 = con.prepareStatement("select * from tender where tenderid=?");
                            ps2.setString(1, ""+tenderId);
                            ResultSet rs=ps2.executeQuery();
                            while(rs.next()){
                                if(rs.getString("tenderamountlimit")==null){return;}
                                tenderAmountLimit = Integer.parseInt(rs.getString("tenderamountlimit"));
                            }
                            
                        } catch (SQLException ex) {
                            Logger.getLogger(Tender.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if(tenderAmount>tenderAmountLimit){
                            return;
                        }
                        try {
                            
                            PreparedStatement ps1 = con.prepareStatement("update tender set tenderstatus=?,tenderamount=?,allottedto=? where tenderid=? and tenderstatus=?");
                            ps1.setString(1,"closed");
                            ps1.setString(2,""+tenderAmount);
                            ps1.setString(3,company);
                            ps1.setString(4,""+tenderId);
                            ps1.setString(5,"open");
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
    
    
    public void checkTenderForApproval(JPanel right){
        try {
            
            right.removeAll();
            PreparedStatement ps = con.prepareStatement("select * from tender where tenderstatus=?");
            ps.setString(1,"received");
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
                //jl.add(new JLabel(rs.getString("tenderstatus")));
                //jl.add(new JLabel(rs.getString("salary")));
                //jl.add(new JLabel(rs.getString("dateofappointment")));
                count++; 
                               
            }
            JPanel jp;
            jp=new JPanel();
            jp.setLayout(new GridLayout(count+1,4,4,4));
            jp.setBackground(Color.pink);
            jp.add(new JLabel("tenderid"));
            jp.add(new JLabel("departmenttype"));
            //jp.add(new JLabel("dob"));
            jp.add(new JLabel("tenderamountlimit"));
            jp.add(new JLabel("equipments"));
            //jp.add(new JLabel("tenderstatus"));
            //jp.add(new JLabel("dateofappointment"));
            for(int i=0;i<jl.size();i++){
                jp.add(jl.get(i));
            }
            JLabel jl1=new JLabel("Tender ID:");
            final JTextField jf1=new JTextField();
            JButton btn1=new JButton("Approve");
            JButton btn2=new JButton("Reject");
            jp.add(jl1);
            jp.add(jf1);
            jp.add(btn1);
            jp.add(btn2);
            right.removeAll();
            right.add(jp);
            right.revalidate();
            right.repaint();
            btn1.addActionListener(new ActionListener(){
                    
                    public void actionPerformed(ActionEvent e)
                    {
                        int tenderId=Integer.parseInt(jf1.getText());
                        try {
                            
                            PreparedStatement ps1 = con.prepareStatement("update tender set tenderstatus=? where tenderid=? and tenderstatus=?");
                            ps1.setString(1,"approved");
                            ps1.setString(2,""+tenderId);
                            ps1.setString(3,"received");
                            ps1.executeUpdate();
                        } catch (SQLException ex) {
                            Logger.getLogger(InfraAdmin.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

            
                });
            
            btn2.addActionListener(new ActionListener(){
                    
                    public void actionPerformed(ActionEvent e)
                    {
                        int tenderId=Integer.parseInt(jf1.getText());
                        try {
                            
                            PreparedStatement ps1 = con.prepareStatement("update tender set tenderstatus=? where tenderid=?");
                            ps1.setString(1,"rejected");
                            ps1.setString(2,""+tenderId);
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
}
