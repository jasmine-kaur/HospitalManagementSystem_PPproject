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
import account.Accountant;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
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
import patient.Appointment;
import patient.Bill;
import patient.Patient;
import patient.PatientRecord;

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
    private JPanel left;
    private JPanel right;
    BasicLayout basicLayout;
    private Patient patient;
    
    String scheduledDate=new String();
     JDatePickerImpl datePicker;
     Bill bill;
     JPanel billDetailPanel;
     JPanel billPanel;
     JTextField regIdField;
     Accountant accountant=new Accountant();
     private final int APPOINTMENT_FEE=100;
    public Receptionist(int employeeId){
        this.employeeId=employeeId;
        System.out.println("employee id:"+this.employeeId);
    }

    @Override
    public void viewProfile() {
        try{
            
            right.removeAll();
            PreparedStatement ps = con.prepareStatement("select employeeid,name,dob,contactinfo,address,salary,dateofappointment,shiftdate,shifttime from receptionist where employeeid =?");
          
            ps.setString(1, ""+employeeId);
            
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
            right.add(jp);
            right.revalidate();
            right.repaint();
        }catch(SQLException ex){
            Logger.getLogger(Receptionist.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //Adding ui for receptionist 
    public void addUI(){
        JButton jViewProfile= new JButton("View Profile");
        JButton jGenerateBill= new JButton("Generate Bill");
        jGenerateBill.setPreferredSize(new Dimension(50,50));
        JButton jBookAppointment= new JButton("Book Appointment");
        
        
        basicLayout= new BasicLayout();
        basicLayout.addUI();
        
        left= new JPanel(new GridLayout(10,1, 4,4 ));
     
        right= new JPanel(new BorderLayout());
        
        
        right.setBackground(Color.PINK);
        jFunction = basicLayout.getFunctions();
        
        jFunction.setLayout(new GridLayout(1, 2,4,4));
         
        left.add(jViewProfile);
        left.add(jGenerateBill);
        left.add(jBookAppointment);
        
        
        
        jFunction.add(left);
        jFunction.add(right);
        
        //adding customer panel
        
        jViewProfile.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                viewProfile();
            }
        } );
        
        jGenerateBill.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                right.removeAll();
                billPanel= new JPanel(new GridLayout(10,1,4,4));
               
                //right.setLayout(new GridLayout(10,1,4,4));
                regIdField= new JTextField("0");
                JLabel registrationId= new JLabel("Registration Id");
                
                billPanel.add(registrationId);
                billPanel.add(regIdField);
                
                JButton okGenerateBill= new JButton("OK");
                billPanel.add(okGenerateBill);
                billPanel.setBackground(Color.pink);
                right.add(billPanel);
                okGenerateBill.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        bill = new Bill(Integer.parseInt(regIdField.getText()));
                        JOptionPane.showMessageDialog(null, bill.viewBill());
                    }
                });
                
                
                //}
                /*ok.addActionListener(new ActionListener() { 
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        bill =new Bill(Integer.parseInt(regIdField.getText())); 
                //if(Integer.parseInt(regIdField.getText())!=0){
                        billDetailPanel=bill.getBillPanel();
                        billPanel.add(billDetailPanel);
                        right.add(billPanel);
                        right.revalidate();
                        right.repaint();
                    //accountant.getBill(bill.generateBill());
                    }
                } );
               */
              generateBill(null);
                
            }
        } );
        
        jBookAppointment.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
                JButton saveToDb= new JButton("Save to Database");
                JButton submit=basicLayout.getSubmitButton();
                submit.setEnabled(true);
                
                right.removeAll();
                final JPanel customerForm= basicLayout.getCustomerForm(saveToDb);
                assert customerForm!=null;
                right.add(customerForm, BorderLayout.CENTER);
                patient=new Patient();
                
                JLabel appointmentDate= new JLabel("APPOINTMENT DATE:");
                JLabel appointmentTime= new JLabel("APPOINTMENT TIME:");
                JLabel departmentName= new JLabel("DEPARTMENT NAME:");
                JTextField timeField=new JTextField();
                final JTextField departmentField=new JTextField();
                
                customerForm.add(saveToDb);
                customerForm.add(appointmentDate);
                
                UtilDateModel model = new UtilDateModel();
                model.setDate(1990, 8, 24);
                Properties p = new Properties();
                p.put("text.today", "Today");
                p.put("text.month", "Month");
                p.put("text.year", "Year");
                JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
                DateLabelFormatter dateLabel=new DateLabelFormatter();
                datePicker = new JDatePickerImpl(datePanel, dateLabel);
                   
                customerForm.add(datePicker);
                customerForm.add(appointmentTime);
                timeField.setText("-");
                customerForm.add(timeField);
                customerForm.add(departmentName);
                departmentField.setText("-");
                customerForm.add(departmentField);
                
                saveToDb.setEnabled(false);
                patient= basicLayout.getPatient();
                
                saveToDb.addActionListener(new ActionListener() { 
                    @Override
                    public void actionPerformed(ActionEvent e) { 
                        try{
                            JButton submit=basicLayout.getSubmitButton();
                            submit.setEnabled(false);
                            PreparedStatement ps1=con.prepareStatement("select MAX(patientid) from patient");
                            ResultSet rs1=ps1.executeQuery();
                            int rid=0;
                            while(rs1.next()){
                                rid=Integer.parseInt(rs1.getString(1))+1;
                            }
                            if(patient!=null){
                                   patient.setRegistrationId(rid);
                                   PreparedStatement ps = con.prepareStatement("INSERT INTO patient values(?,?,?,?,?,?,?)");
                                   System.out.println(patient.getName().toString());
                                   ps.setString(1,""+patient.getName().toString());
                                   ps.setString(2, ""+patient.getDateOfBirth());
                                   ps.setString(3,patient.getGender());
                                   ps.setString(4,""+rid);
                                   ps.setString(5, ""+patient.getContactInfo());
                                   ps.setString(6,patient.getAddress().toString());
                                   ps.setString(7,""+0);
                                   ps.executeUpdate();
                                   bookAppointment(null, patient,departmentField.getText(),scheduledDate);
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "First Submit Record!!");
                                }
                        }catch(SQLException ex){
                            Logger.getLogger(Receptionist.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
            } );
                right.revalidate();
                right.repaint();
            }
        });
        
        
        
    }
    
    
    public void bookAppointment(Doctor doctor, Patient patient, String departmentType,String scheduled_date){
        //Taking patient's data 
        System.out.println("in book appointment");
        Integer id=new Integer(0);
        int flag=0;
        String date=new String();
        String department=new String();
        String time=new String();

        System.out.println("error source");
        if((Date)datePicker.getModel().getValue()!=null){
            Date scheduled_date_obj1=(Date)datePicker.getModel().getValue();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            scheduledDate=dateFormat.format(scheduled_date_obj1);
            }
            scheduled_date=scheduledDate;
        
        try{
            PreparedStatement ps2 = con.prepareStatement("select employeeid,shifttime,shiftdate,departmentname from doctor");

            Integer rid=new Integer(0);
            ResultSet rs = ps2.executeQuery();
            while (rs.next())
                {
                rid=(int)patient.getRegistrationId();
                id = Integer.parseInt(rs.getString("employeeid"));
                time = rs.getString("shifttime");
                date = rs.getString("shiftdate");
                department = rs.getString("departmentname");
                if(departmentType.equals(department)&& scheduled_date.equals(date)){
                    flag=1;
                    break;
                    }
                }
                
                if(flag==0){
                    JOptionPane.showMessageDialog(null, "NOT SCHEDULED!!");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Appointment Booked on!!"+date+"\nPayBill of"+APPOINTMENT_FEE);
                    Bill billAppointment= new Bill((int) patient.getRegistrationId());
                    billAppointment.updateBill((int) patient.getRegistrationId(), APPOINTMENT_FEE);
                    sendBillDetailsToAccountant(APPOINTMENT_FEE);
                    PreparedStatement ps3=con.prepareStatement("select MAX(appointmentid) from appointment");
                    ResultSet rs3=ps3.executeQuery();
                    int appointmentid=0;
                    while(rs3.next()){
                        appointmentid=Integer.parseInt(rs3.getString(1))+1;
                        }
                        
                    Appointment appointment =new Appointment(appointmentid, id,date, rid,department,time);
                    System.out.println("Appointment details:"+appointment.toString());
                }
            }catch(SQLException ex){
                Logger.getLogger(PatientRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
    
    public void queryAppointment(Patient patient){
        
        
    }
    public void payBill(Patient patient, Bill bill){
        
    }
    public Bill generateBill(Patient patient){
        JOptionPane.showMessageDialog(null, "Generating Bill!!!!!");
        return null;
    }
    public void sendBillDetailsToAccountant(int billAmount){
        
        accountant.getBill(billAmount);
        JOptionPane.showMessageDialog(null, "Sending Bill Details to Acountant!!!!!");
    }
    
    
    
     public static void main(String[] args) {
        // TODO code application logic here
         
         Receptionist rec= new Receptionist(1);
         rec.addUI();
    }
    
}
