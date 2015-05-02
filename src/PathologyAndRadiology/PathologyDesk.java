/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PathologyAndRadiology;
import staff.*;
import java.util.Date;
import java.util.ArrayList;
import BasicDetails.*;
import BasicLayout.BasicLayout;
import emergency.EmergencyDesk;
import emergency.TraumaSurgeon;
import java.awt.Color;
import java.awt.Component;
import patient.*;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
 * @author Devanshu
 */
public class PathologyDesk implements Staff{
    
    private ArrayList<String> testsScheduled;
    private Name name;
    private int employeeId;
    private Date dateOfBirth;
    private long contactInfo;
    private Address address;
    private int salary;
    private Frame frame;
    private DepartmentType departmentName;
    private JPanel jFunction;
    private JPanel left;
    public JPanel right;
    BasicLayout basicLayout;
    private Component cp;
    private JTextField registrationidField;
    private JTextField testnameField;
    private JTextField costField;
    private JTextField testidField;
    private JTextField doctoridField;
    private JTextField patientidField;
    private JTextField departmentnameField;
    private JTextField testdateField;
    private JTextField resultField;
     private JDatePickerImpl datePicker;
    private JTextField registrationField;
    
    public PathologyDesk(String employeeid){
        this.employeeId=Integer.parseInt(employeeid);
    }
    @Override
    public void viewProfile(){
        JOptionPane.showMessageDialog(cp, "view Profile");
  
        System.out.println(employeeId);
        try {
            
            
            PreparedStatement ps=con.prepareStatement("select name, dob ,contactinfo, address , salary from pathologydesk where employeeid=?");
            ps.setString(1, ""+employeeId);
            ResultSet rs = ps.executeQuery();

            JPanel jp=new JPanel(new GridLayout(10,1,4,4));
            jp.setBackground(Color.pink);
            while(rs.next()) {
                
                JLabel jl1 = new JLabel("Name: "+rs.getString("name"));
                JLabel jl2 = new JLabel("DOB: "+ rs.getString("dob"));
                JLabel jl3 = new JLabel("Contact info:" +rs.getString("contactinfo"));
                JLabel jl4 = new JLabel("Address: "+rs.getString("address"));
               
                JLabel jl6 = new JLabel("Salary: "+rs.getString("salary"));
                jp.add(jl1);  
                jp.add(jl2); 
                jp.add(jl3); 
                jp.add(jl4); 
                jp.add(jl6); 
                
                
            }
          
          right.removeAll();
          right.add(jp);
          right.revalidate();
          right.repaint();
            
        } catch (SQLException ex) {
            Logger.getLogger(PathologyDesk.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void addUI(){
        JButton jviewProfile= new JButton("View Profile");
        JButton jupdateTestDetails = new JButton("Update Test Details");
        JButton jaddTestToList = new JButton("Add Test to List");
        JButton jremoveTestFromList = new JButton("Remove Test from List");
        JButton jupdateTestRecordForPatient=new JButton("Update Test Record for Patient");
        JButton jviewAllTests = new JButton("View All Tests");
        JButton jviewAllPatientTests = new JButton("View All patient test details");
        JButton jaddTestPatientRecord = new JButton("Add Patient Test Record");
        basicLayout= new BasicLayout();
        basicLayout.addUI();
        
        left= new JPanel(new GridLayout(10,1, 4,4 ));
     
        right= new JPanel();
        
         
        
        right.setBackground(Color.PINK);
        jFunction = basicLayout.getFunctions();
        
        jFunction.setLayout(new GridLayout(1, 2,4,4));
         
        left.add(jviewProfile);
       
        left.add(jupdateTestDetails);
        left.add(jaddTestToList);
        left.add(jremoveTestFromList);
        left.add(jaddTestPatientRecord);
        left.add(jupdateTestRecordForPatient);
        left.add(jviewAllTests);
        left.add(jviewAllPatientTests);
        
        jFunction.add(left);
        jFunction.add(right);
        
        jviewProfile.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                viewProfile();
            }
        } );
        
        
        
        jupdateTestDetails.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                updateTestDetails();
            }
        } );
        jaddTestToList.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                addTestToList(null);
            }
        } );
        jremoveTestFromList.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                removeTestFromList(null);
            }
        } );
        jviewAllTests.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                viewAllTests();
            }
        } );
        jviewAllPatientTests.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                viewAllPatientTests();
            }
        } );
        jaddTestPatientRecord.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                addTestPatientRecord();
            }
        } );
        jupdateTestRecordForPatient.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                updateTestRecordForPatient(null);
            }
        } );
    }
    
    public void updateTestDetails(){
        JOptionPane.showMessageDialog(cp, "Add test to list");
        JPanel form= new JPanel(new GridLayout(10,1, 4,4 ));
        form.setBackground(Color.PINK);
        JLabel testidLabel= new JLabel("Test ID:");
        testidField= new JTextField();
        form.add(testidLabel);
        form.add(testidField);
        JLabel testnameLabel= new JLabel("Test Name:");
        testnameField= new JTextField();
        form.add(testnameLabel);
        form.add(testnameField);
        JLabel costLabel= new JLabel("Cost:");
        costField= new JTextField();
        form.add(costLabel);
        form.add(costField);
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
                    if(!testnameField.getText().equals("")){
                        ps=con.prepareStatement("update pathologytest set testname=? where testid=?");
                        ps.setString(1, testnameField.getText());
                        ps.setString(2, testidField.getText());
                        ps.executeUpdate();
                    
                    }
                    if(!costField.getText().equals("")){
                        ps=con.prepareStatement("update pathologytest set cost=? where testid=?");
                        ps.setString(1, costField.getText());
                        ps.setString(2, testidField.getText());
                        ps.executeUpdate();
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(PathologyDesk.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }});
    }
    
    public void addTestToList(RadiologyTest test){
        JOptionPane.showMessageDialog(cp, "Add test to list");
        JPanel form= new JPanel(new GridLayout(10,1, 4,4 ));
        form.setBackground(Color.PINK);
        JLabel testnameLabel= new JLabel("Test Name:");
        testnameField= new JTextField();
        form.add(testnameLabel);
        form.add(testnameField);
        JLabel costLabel= new JLabel("Cost:");
        costField= new JTextField();
        form.add(costLabel);
        form.add(costField);
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
                    ps = con.prepareStatement("insert into pathologytest values (?,?,?)");
                    ps.setString(1, testnameField.getText());
                    if(!costField.equals("")){
                        ps.setString(3, costField.getText());
                    }
                    else{
                        ps.setString(3, "0");
                    }
                    PreparedStatement ps2=con.prepareStatement("select MAX(testid) from pathologytest");
                    ResultSet rs2=ps2.executeQuery();
                    int testid=0;
                    while (rs2.next()){
                        testid=Integer.parseInt(rs2.getString(1));
                    }
                    ps.setString(2, ""+(testid+1));
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(PathologyDesk.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }});
    }
    
    public void removeTestFromList(RadiologyTest test){
        JOptionPane.showMessageDialog(cp, "remove patient Record");
        JPanel form= new JPanel(new GridLayout(10,1, 4,4 ));
        form.setBackground(Color.PINK);
        JLabel testidLabel= new JLabel("Test ID:");
        testidField= new JTextField();
        form.add(testidLabel);
        form.add(testidField);
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
                    PreparedStatement ps=con.prepareStatement("delete from pathologytest where testid=?");
                    ps.setString(1, testidField.getText());
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(PathologyDesk.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }});
    }
    
    public void updateTestRecordForPatient(Patient patient){
        JOptionPane.showMessageDialog(cp, "Update Patient test record");
        JPanel form= new JPanel(new GridLayout(10,1, 4,4 ));
        form.setBackground(Color.PINK);
        JLabel registrationidLabel= new JLabel("Registration ID:");
        registrationidField= new JTextField();
        form.add(registrationidLabel);
        form.add(registrationidField);
        JLabel doctoridLabel= new JLabel("Doctor ID:");
        doctoridField= new JTextField();
        form.add(doctoridLabel);
        form.add(doctoridField);
        JLabel patientidLabel= new JLabel("Patient ID:");
        patientidField= new JTextField();
        form.add(patientidLabel);
        form.add(patientidField);
        JLabel testidLabel= new JLabel("Test ID:");
        testidField= new JTextField();
        form.add(testidLabel);
        form.add(testidField);
        JLabel departmentnameLabel= new JLabel("Department Name:");
        departmentnameField= new JTextField();
        form.add(departmentnameLabel);
        form.add(departmentnameField);
        JLabel testdateLabel= new JLabel("Test Date:");
        
        form.add(testdateLabel);
        
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        DateLabelFormatter dateLabel=new DateLabelFormatter();
        datePicker = new JDatePickerImpl(datePanel, dateLabel);
        form.add(datePicker);
        JLabel resultLabel= new JLabel("Result:");
        resultField= new JTextField();
        form.add(resultLabel);
        form.add(resultField);
        JButton submit=new JButton("Submit");
        
        form.add(submit);
        right.removeAll();
        right.add(form);
        right.revalidate();
        right.repaint();
        
        submit.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                
                   PathologyTest pathtest=new PathologyTest(Integer.parseInt(registrationidField.getText()));
                   if(!doctoridField.getText().equals("")){
                       pathtest.setDoctorId(Integer.parseInt(doctoridField.getText()));
                   }
                   if(!patientidField.getText().equals("")){
                       pathtest.setPatientId(Integer.parseInt(patientidField.getText()));
                   }
                   if(!testidField.getText().equals("")){
                       pathtest.setTestId(Integer.parseInt(testidField.getText()));
                   }
                   if(!departmentnameField.getText().equals("")){
                       pathtest.setDepartmentType(departmentnameField.getText());
                   }
                   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                   Date scheduled_date_obj1=(Date)datePicker.getModel().getValue();
                   if(scheduled_date_obj1!=null){
                        String scheduled_date=dateFormat.format(scheduled_date_obj1);
                        pathtest.setTestDate(datePicker);
                        
                   }
                   if(!resultField.getText().equals("")){
                       pathtest.setResult(resultField.getText());
                   }
                
                
                
            }});
    }
    public void addTestPatientRecord(){
        JOptionPane.showMessageDialog(cp, "Add Patient test record");
        JPanel form= new JPanel(new GridLayout(10,1, 4,4 ));
        form.setBackground(Color.PINK);
        JLabel doctoridLabel= new JLabel("Doctor ID:");
        doctoridField= new JTextField();
        form.add(doctoridLabel);
        form.add(doctoridField);
        JLabel patientidLabel= new JLabel("Patient ID:");
        patientidField= new JTextField();
        form.add(patientidLabel);
        form.add(patientidField);
        JLabel testidLabel= new JLabel("Test ID:");
        testidField= new JTextField();
        form.add(testidLabel);
        form.add(testidField);
        JLabel departmentnameLabel= new JLabel("Department Name:");
        departmentnameField= new JTextField();
        form.add(departmentnameLabel);
        form.add(departmentnameField);
        JLabel testdateLabel= new JLabel("Test Date:");
        
        form.add(testdateLabel);
        
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        DateLabelFormatter dateLabel=new DateLabelFormatter();
        datePicker = new JDatePickerImpl(datePanel, dateLabel);
        form.add(datePicker);
        JLabel resultLabel= new JLabel("Result:");
        resultField= new JTextField();
        form.add(resultLabel);
        form.add(resultField);
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
                    PreparedStatement ps2=con.prepareStatement("select MAX(registrationid) from pathologytestpatientrecord");
                       ResultSet rs2=ps2.executeQuery();
                       int regid=0;
                       while (rs2.next()){
                           regid=Integer.parseInt(rs2.getString(1));
                       }
                   PathologyTest pathtest=new PathologyTest(regid+1,"");
                   if(!doctoridField.getText().equals("")){
                       pathtest.setDoctorId(Integer.parseInt(doctoridField.getText()));
                   }
                   if(!patientidField.getText().equals("")){
                       pathtest.setPatientId(Integer.parseInt(patientidField.getText()));
                   }
                   if(!testidField.getText().equals("")){
                       pathtest.setTestId(Integer.parseInt(testidField.getText()));
                   }
                   if(!departmentnameField.getText().equals("")){
                       pathtest.setDepartmentType(departmentnameField.getText());
                   }
                   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                   Date scheduled_date_obj1=(Date)datePicker.getModel().getValue();
                   if(scheduled_date_obj1!=null){
                        String scheduled_date=dateFormat.format(scheduled_date_obj1);
                        pathtest.setTestDate(datePicker);
                        
                   }
                   if(!resultField.getText().equals("")){
                       pathtest.setResult(resultField.getText());
                   }
                
                } catch (SQLException ex) {
                    Logger.getLogger(PathologyDesk.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }});
    }
    
    public void viewAllTests(){
        JOptionPane.showMessageDialog(cp, "Get List of All tests");
        try {
            PreparedStatement ps;
            right.removeAll();
            ps = con.prepareStatement("select * from pathologytest");
          
            ResultSet rs = ps.executeQuery();
            ArrayList<JLabel> jl =new ArrayList<>();
            int count=1; 
            while(rs.next()) {
                jl.add(new JLabel(rs.getString("testname")));
                jl.add(new JLabel(rs.getString("testid")));
                jl.add(new JLabel(rs.getString("cost")));
             
                count++; 
                               
            }
            JPanel jp;
            jp=new JPanel();
            jp.setLayout(new GridLayout(count,3,0,0));
            jp.setBackground(Color.pink);
            jp.add(new JLabel("testname"));
            jp.add(new JLabel("testid"));
            jp.add(new JLabel("cost"));
            
            for(int i=0;i<jl.size();i++){
                jp.add(jl.get(i));
            }
            right.removeAll();
            right.add(jp);
            right.revalidate();
            right.repaint();
        } catch (SQLException ex) {
            Logger.getLogger(PathologyDesk.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void viewAllPatientTests(){
        JOptionPane.showMessageDialog(cp, "Get List of All pathology test patients");
        try {
            PreparedStatement ps;
            right.removeAll();
            ps = con.prepareStatement("select * from pathologytestpatientrecord");
          
            ResultSet rs = ps.executeQuery();
            ArrayList<JLabel> jl =new ArrayList<>();
            int count=1; 
            while(rs.next()) {
                jl.add(new JLabel(rs.getString("doctorid")));
                jl.add(new JLabel(rs.getString("registrationid")));
                jl.add(new JLabel(rs.getString("patientid")));
                jl.add(new JLabel(rs.getString("testid")));
                jl.add(new JLabel(rs.getString("departmentname")));
                jl.add(new JLabel(rs.getString("testdate")));
                jl.add(new JLabel(rs.getString("result")));
             
                count++; 
                               
            }
            JPanel jp;
            jp=new JPanel();
            jp.setLayout(new GridLayout(count,7,4,4));
            jp.setBackground(Color.pink);
            jp.add(new JLabel("doctorid"));
            jp.add(new JLabel("registrationid"));
            jp.add(new JLabel("patientid"));
            jp.add(new JLabel("testid"));
            jp.add(new JLabel("departmentname"));
            jp.add(new JLabel("testdate"));
            jp.add(new JLabel("result"));
            for(int i=0;i<jl.size();i++){
                jp.add(jl.get(i));
            }
            right.removeAll();
            right.add(jp);
            right.revalidate();
            right.repaint();
        } catch (SQLException ex) {
            Logger.getLogger(PathologyDesk.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
