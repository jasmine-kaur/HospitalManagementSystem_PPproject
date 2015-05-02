/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staff;

import BasicDetails.Address;
import BasicDetails.Name;
import java.awt.Frame;
import patient.*;
import java.awt.Component;
import BasicLayout.BasicLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import patient.PatientRecord;

/**
 *
 * @author Mansi Verma
 */
public class HOD extends Doctor {
    
    private int employeeId;
    private Name name;
    private Date dateOfBirth;
    private Long contactInfo;
    private Address address;
    private int salary;
    private Frame frame;
    private DepartmentType departmentName;
    private JPanel jFunction;
    private JPanel left;
    public JPanel right;
    BasicLayout basicLayout;
    private Component cp;
    private JTextField registrationidField, messageField,surgeryidField, otnumberField,doctoridField, patientidField, bloodgroupField, wardnumberField, medicineField, departmentnameField, surgerytimeField;
    private JDatePickerImpl datePicker;

    public HOD(String employeeId){
        super(employeeId);
        this.employeeId=Integer.parseInt(employeeId);
    }
   /* @Override
    public void viewProfile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */
    @Override
    public void addUI(){
        JButton jviewProfile= new JButton("View Profile");
        JButton jViewAppointment= new JButton("View Appointments");
        JButton jcheckSchedule = new JButton("Check Schedule");
        JButton jupdatePatientRecord = new JButton("Update Patient Record");
        JButton jgetPatientRecord = new JButton("Get Patient Record");
        JButton jforwardPatientRecord = new JButton("Forward Patient Record");
        JButton jviewScheduledSurgeries = new JButton("View Scheduled Surgeries");
        JButton jscheduleSurgeries = new JButton("Schedule Surgeries");
        JButton jviewOtherDoctorDetails = new JButton("View Other doctor details");
        JButton jnotifyDoctors = new JButton("Notify Other Doctors");
        basicLayout= new BasicLayout();
        basicLayout.addUI();
        
        left= new JPanel(new GridLayout(11,1, 4,4 ));
     
        right= new JPanel();
        try {
            PreparedStatement ps1=con.prepareStatement("select departmentname from doctor where employeeid=?");
            ps1.setString(1, ""+employeeId);
            ResultSet rs1=ps1.executeQuery();
            String deptname="";
            while(rs1.next()){
                deptname=rs1.getString(1);
            }
            PreparedStatement ps=con.prepareStatement("select * from departmentnotification where departmentname=?");
            ps.setString(1,deptname);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                JLabel jl=new JLabel(rs.getString("message"));
                left.add(jl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        right.setBackground(Color.PINK);
        jFunction = basicLayout.getFunctions();
        
        jFunction.setLayout(new GridLayout(1, 2,4,4));
         
        left.add(jviewProfile);
        left.add(jViewAppointment);
        left.add(jcheckSchedule);
        left.add(jupdatePatientRecord);
        left.add(jgetPatientRecord);
        left.add(jforwardPatientRecord);
        left.add(jviewScheduledSurgeries);
        left.add(jscheduleSurgeries);
        left.add(jviewOtherDoctorDetails);
        left.add(jnotifyDoctors);
        jFunction.add(left);
        jFunction.add(right);
        super.right=this.right;
        
        jviewProfile.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                viewProfile();
            }
        } );
        jViewAppointment.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                viewAppointments();
            }
        } );
        jcheckSchedule.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                checkSchedule();
            }
        } );
        jgetPatientRecord.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                getPatientRecord(null);
            }
        } );
        jupdatePatientRecord.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                updatePatientRecord(null);
            }
        } );
        jforwardPatientRecord.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                forwardPatientRecord(null, null);
            }
        } );
        jviewScheduledSurgeries.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                viewScheduledSurgeries(null);
            }
        } );
        jscheduleSurgeries.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                scheduleSurgeries();
            }
        } );
        jviewOtherDoctorDetails.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                viewOtherDoctorDetails(null);
            }
        } );
        jnotifyDoctors.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                notifyDoctors();
            }
        } );
    }
    
    public void scheduleSurgeries(){
        JOptionPane.showMessageDialog(cp, "Schedule surgery");
        JPanel form= new JPanel(new GridLayout(10,1, 4,4 ));
        form.setBackground(Color.PINK);
        JLabel surgeryidLabel= new JLabel("Surgery ID:");
        surgeryidField= new JTextField();
        form.add(surgeryidLabel);
        form.add(surgeryidField);
        JLabel doctoridLabel= new JLabel("Doctor ID:");
        doctoridField= new JTextField();
        form.add(doctoridLabel);
        form.add(doctoridField);
        JLabel patientidLabel= new JLabel("Patient ID:");
        patientidField= new JTextField();
        form.add(patientidLabel);
        form.add(patientidField);
        JLabel surgerydateLabel= new JLabel("Surgery Date:");
        
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        DateLabelFormatter dateLabel=new DateLabelFormatter();
        datePicker = new JDatePickerImpl(datePanel, dateLabel);
        
        
        
        form.add(surgerydateLabel);              
        form.add(datePicker);
       
        JLabel surgerytimeLabel= new JLabel("Surgery Time:");
        surgerytimeField= new JTextField();
        form.add(surgerytimeLabel);
        form.add(surgerytimeField);
        JLabel otnumberLabel= new JLabel("OT Number:");
        otnumberField= new JTextField();
        form.add(otnumberLabel);
        form.add(otnumberField);
        JButton submit=new JButton("Submit");
        form.add(submit);
        right.removeAll();
        right.add(form);
        right.revalidate();
        right.repaint();
        submit.addActionListener(new ActionListener() { 
        @Override
        public void actionPerformed(ActionEvent e) { 
            PreparedStatement ps;
            try {
                ps = con.prepareStatement("insert into patientsurgery values(?,?,?,?,?,?,?)");
                ps.setString(1, surgeryidField.getText());
                
                ps.setString(2, patientidField.getText());
                
                ps.setString(3, doctoridField.getText());
               
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                Date scheduled_date_obj1=(Date)datePicker.getModel().getValue();
                String scheduled_date=dateFormat.format(scheduled_date_obj1);
               // System.out.println(scheduled_date);
               // System.out.println(scheduled_date_obj1);
                
                ps.setString(4, scheduled_date);
                
                ps.setString(5, surgerytimeField.getText());
                
                ps.setString(6, otnumberField.getText());
                PreparedStatement ps1=con.prepareStatement("select MAX(scheduledsurgeryid) from patientsurgery");
                ResultSet rs1=ps1.executeQuery();
                int rid=0;
                while(rs1.next()){
                     rid=Integer.parseInt(rs1.getString(1));
                     ps.setString(7, ""+(rid+1));
                }
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(HOD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }});
    }
    public void viewOtherDoctorDetails(Doctor doctor){
        JOptionPane.showMessageDialog(cp, "get doctor Details");
        try {
            String departmentname="";
            PreparedStatement ps=con.prepareStatement("select departmentname from doctor where employeeid=?");
            ps.setString(1, ""+employeeId);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                departmentname=rs.getString(1);
                
            }
            right.removeAll();
            ps = con.prepareStatement("select * from doctor where departmentname=?");
            ps.setString(1,departmentname);
            rs = ps.executeQuery();
            ArrayList<JLabel> jl =new ArrayList<>();
            int count=1; 
            while(rs.next()) {
                jl.add(new JLabel(rs.getString("employeeid")));
                jl.add(new JLabel(rs.getString("name")));
                jl.add(new JLabel(rs.getString("dob")));
                jl.add(new JLabel(rs.getString("contactinfo")));
                jl.add(new JLabel(rs.getString("address")));
                jl.add(new JLabel(rs.getString("practicestartyear")));
                jl.add(new JLabel(rs.getString("departmentsenioritynumber")));
                jl.add(new JLabel(rs.getString("shiftdate")));
                jl.add(new JLabel(rs.getString("shifttime")));
                count++; 
                               
            }
            JPanel jp;
            jp=new JPanel();
            jp.setLayout(new GridLayout(count,9,0,0));
            jp.setBackground(Color.pink);
            jp.add(new JLabel("employeeid"));
            jp.add(new JLabel("name"));
            jp.add(new JLabel("dob"));
            jp.add(new JLabel("contactinfo"));
            jp.add(new JLabel("address"));
            jp.add(new JLabel("practicestartyear"));
            jp.add(new JLabel("seniority"));
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
            Logger.getLogger(HOD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void notifyDoctors(){
        JOptionPane.showMessageDialog(cp, "notify Doctors");
        JPanel form= new JPanel(new GridLayout(10,1, 4,4 ));
        form.setBackground(Color.PINK);
        JLabel doctoridLabel= new JLabel("Doctor ID:");
        doctoridField= new JTextField();
        form.add(doctoridLabel);
        form.add(doctoridField);
        JLabel messageLabel= new JLabel("Message:");
        messageField= new JTextField();
        form.add(messageLabel);
        form.add(messageField);
        JButton submit=new JButton("Submit");
        form.add(submit);
        right.removeAll();
        right.add(form);
        right.revalidate();
        right.repaint();
        submit.addActionListener(new ActionListener() { 
        @Override
        public void actionPerformed(ActionEvent e) { 
            try {
                PreparedStatement ps = con.prepareStatement("insert into notification values(?,?)");
                //System.out.println(doctoridField.getText());
                //System.out.println(doctoridField.getText());
                ps.setString(1,doctoridField.getText());
                ps.setString(2, messageField.getText());
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(HOD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }});
    }
}
