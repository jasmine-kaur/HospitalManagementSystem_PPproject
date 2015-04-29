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
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import patient.Bill;
import patient.Patient;

/**
 *
 * @author Mansi Verma
 */

public class Receptionist implements Staff{
    private int employeeId;
    private Name name;
    private Date dateOfBirth;
    private Long contactInfo;
    private Address address;
    private int salary;
    private JPanel jFunction;
    private Component cp;

    @Override
    public void viewProfile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void addUI(){
        
        
        JButton jGenerateBill= new JButton("Generate Bill");
        jGenerateBill.setPreferredSize(new Dimension(50,50));
        JButton jBookAppointment= new JButton("Book Appointment");
        JButton jSendBillDetails = new JButton("Send Bill Details");
        
        BasicLayout basicLayout= new BasicLayout();
        basicLayout.addUI();
        
        JPanel left= new JPanel(new GridLayout(10,1, 4,4 ));
     
        JPanel right= new JPanel();
        
        
        right.setBackground(Color.PINK);
        jFunction = basicLayout.getFunctions();
        
        jFunction.setLayout(new GridLayout(1, 2,4,4));
         
        left.add(jGenerateBill);
       
        left.add(jBookAppointment);
        left.add(jSendBillDetails);
        
        
        jFunction.add(left);
        jFunction.add(right);
        
        jGenerateBill.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                generateBill(null);
            }
        } );
        
        jBookAppointment.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                bookAppointment(null, null,null);
            }
        });
      
           
    }
    
    
    public void bookAppointment(Doctor doctor, Patient patient, DepartmentType departmentType){
        
    }
    
    public void queryAppointment(Patient patient){
        
    }
    public void payBill(Patient patient, Bill bill){
        
    }
    public Bill generateBill(Patient patient){
        JOptionPane.showMessageDialog(cp, "Generating Bill!!!!!");
        return null;
    }
    public void sendBillDetailsToAccountant(Bill bill){
        JOptionPane.showMessageDialog(cp, "Sending Bill Details to Acountant!!!!!");
    }
    
     public static void main(String[] args) {
        // TODO code application logic here
         
         Receptionist rec= new Receptionist();
         rec.addUI();
    }
    
}
