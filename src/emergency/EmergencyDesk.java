/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergency;
import patient.Patient;
import staff.DepartmentType;
import staff.Staff;
import BasicDetails.Address;
import BasicDetails.Name;
import java.awt.Frame;
import java.awt.Component;
import BasicLayout.BasicLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import staff.DateLabelFormatter;

/**
 *
 * @author Mansi Verma
 */
public class EmergencyDesk implements Staff {
    
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
    
    //Basic Layout
    BasicLayout basicLayout;
    private Component cp;
    private JTextField traumasurgeonidField, messageField;
    private JTextField nameField;
    private JTextField dobField;
    private JTextField genderField;
    private JTextField contactField;
    private JTextField addressField;
    private JTextField bloodgroupField;
    private JTextField doctoridField;
    private int regid, patientid;
    private JTextField firnumberField;
    private JTextField accidenttypeField;
    private JTextField accidentdateField;
    private JTextField accidenttimeField;
    private JDatePickerImpl datePicker;
    public EmergencyDesk(String employeeid){
        this.employeeId=Integer.parseInt(employeeid);
    }
    @Override
    public void viewProfile() {
        JOptionPane.showMessageDialog(cp, "view Profile");
  
        System.out.println(employeeId);
        try {
            
            
            PreparedStatement ps=con.prepareStatement("select name, dob ,contactinfo, address , salary from emergencydesk where employeeid=?");
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
            Logger.getLogger(EmergencyDesk.class.getName()).log(Level.SEVERE, null, ex);
        } 
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addUI(){
        JButton jviewProfile= new JButton("View Profile");
        JButton jnotifyTraumaSurgeon = new JButton("Notify Trauma Surgeon");
        JButton jcallPoliceIfNecessary = new JButton("Call Police if Necessary");
        JButton jgetBriefDetails = new JButton("Get Brief Details");
        JButton jgetTraumaSurgeonDetails=new JButton("Get list of Trauma Surgeons");
        basicLayout= new BasicLayout();
        basicLayout.addUI();
        
        left= new JPanel(new GridLayout(10,1, 4,4 ));
     
        right= new JPanel();
        
         
        
        right.setBackground(Color.PINK);
        jFunction = basicLayout.getFunctions();
        
        jFunction.setLayout(new GridLayout(1, 2,4,4));
         
        left.add(jviewProfile);
       
        left.add(jnotifyTraumaSurgeon);
        left.add(jgetBriefDetails);
        left.add(jcallPoliceIfNecessary);
        left.add(jgetTraumaSurgeonDetails);
        
        
        jFunction.add(left);
        jFunction.add(right);
        try {
            PreparedStatement ps=con.prepareStatement("select * from notification where employeeid=?");
            ps.setString(1,""+employeeId);
        } catch (SQLException ex) {
            Logger.getLogger(TraumaSurgeon.class.getName()).log(Level.SEVERE, null, ex);
        }
        jviewProfile.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                viewProfile();
            }
        } );
        
        
        
        jnotifyTraumaSurgeon.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                notifyTraumaSurgeon(null);
            }
        } );
        jgetBriefDetails.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                getBriefDetails(null);
            }
        } );
        jcallPoliceIfNecessary.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                callPoliceIfNecessary();
            }
        } );
        jgetTraumaSurgeonDetails.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                getTraumaSurgeonDetails();
            }
        } );
        
    }
    
    public void notifyTraumaSurgeon(Patient patient){
        JOptionPane.showMessageDialog(cp, "Notify Trauma Surgeon");
        
        JPanel form= new JPanel(new GridLayout(10,1, 4,4 ));
        form.setBackground(Color.PINK);
        JLabel traumasurgeonidLabel= new JLabel("Trauma Surgeon ID:");
        traumasurgeonidField= new JTextField();
        form.add(traumasurgeonidLabel);
        form.add(traumasurgeonidField);
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
                ps.setString(1,traumasurgeonidField.getText());
                ps.setString(2, messageField.getText());
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(EmergencyDesk.class.getName()).log(Level.SEVERE, null, ex);
            }
        }});
    }
    
    public void getBriefDetails(Patient patient){
        JOptionPane.showMessageDialog(cp, "Get Brief Details");
        JPanel form= new JPanel(new GridLayout(10,1, 4,4 ));
        form.setBackground(Color.PINK);
        JLabel nameLabel= new JLabel("Name:");
        nameField= new JTextField();
        form.add(nameLabel);
        form.add(nameField);
        JLabel dobLabel= new JLabel("DOB:");
      //  dobField= new JTextField();
        form.add(dobLabel);
       // form.add(dobField);
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        DateLabelFormatter dateLabel=new DateLabelFormatter();
        datePicker = new JDatePickerImpl(datePanel, dateLabel);
         form.add(datePicker);
        JLabel genderLabel= new JLabel("Gender:");
        genderField= new JTextField();
        form.add(genderLabel);
        form.add(genderField);
        JLabel contactLabel= new JLabel("Contact:");
        contactField= new JTextField();
        form.add(contactLabel);
        form.add(contactField);
        JLabel addressLabel= new JLabel("Address:");
        addressField= new JTextField();
        form.add(addressLabel);
        form.add(addressField);
        JLabel bloodgroupLabel= new JLabel("Blood Group:");
        bloodgroupField= new JTextField();
        form.add(bloodgroupLabel);
        form.add(bloodgroupField);
        JLabel doctoridLabel= new JLabel("Doctor id:");
        doctoridField= new JTextField();
        form.add(doctoridLabel);
        form.add(doctoridField);
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
                PreparedStatement ps= con.prepareStatement("insert into patient values(?,?,?,?,?,?,?)");
                ps.setString(1, nameField.getText());
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                Date scheduled_date_obj1=(Date)datePicker.getModel().getValue();
                if(scheduled_date_obj1!=null){
                    String scheduled_date=dateFormat.format(scheduled_date_obj1);
                    ps.setString(2, scheduled_date);
                }
                else{
                    
                    ps.setString(2, "1500-01-01");
                }

                ps.setString(3, genderField.getText());
                PreparedStatement ps1=con.prepareStatement("select MAX(patientid) from patient");
                    ResultSet rs1=ps1.executeQuery();
                    patientid=0;
                    while (rs1.next()){
                        patientid=Integer.parseInt(rs1.getString(1));
                    }
                ps.setString(4, ""+(patientid+1));
                if(!contactField.getText().equals("")){
                    ps.setString(5, contactField.getText());
                }
                else{
                    ps.setString(5, "0");
                }
                ps.setString(6, addressField.getText());
                ps.setString(7, "0");
                ps.executeUpdate();
                
                ps= con.prepareStatement("insert into patientrecord values(?,?,?,?,?,?,?)");
                PreparedStatement ps2=con.prepareStatement("select MAX(registrationid) from patientrecord");
                    ResultSet rs2=ps2.executeQuery();
                    regid=0;
                    while (rs2.next()){
                        regid=Integer.parseInt(rs2.getString(1));
                    }
                ps.setString(1, ""+(regid+1));
                ps.setString(2, ""+(regid+1));
                ps.setString(3, bloodgroupField.getText());
                ps.setString(4, "trauma");
                ps.setString(5, doctoridField.getText());
                ps.setString(6, "0");
                ps.setString(7, "");
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(EmergencyDesk.class.getName()).log(Level.SEVERE, null, ex);
            }
        }});
    }
    public void getTraumaSurgeonDetails(){
        JOptionPane.showMessageDialog(cp, "Get List of Trauma Surgeons");
        try {
            PreparedStatement ps;
            right.removeAll();
            ps = con.prepareStatement("select * from traumasurgeon");
          
            ResultSet rs = ps.executeQuery();
            ArrayList<JLabel> jl =new ArrayList<>();
            int count=1; 
            while(rs.next()) {
                jl.add(new JLabel(rs.getString("employeeid")));
                jl.add(new JLabel(rs.getString("name")));
                jl.add(new JLabel(rs.getString("contactinfo")));
                jl.add(new JLabel(rs.getString("shiftdate")));
                jl.add(new JLabel(rs.getString("shifttime")));
                count++; 
                               
            }
            JPanel jp;
            jp=new JPanel();
            jp.setLayout(new GridLayout(count,5,4,4));
            jp.setBackground(Color.pink);
            jp.add(new JLabel("employeeid"));
            jp.add(new JLabel("name"));
            jp.add(new JLabel("contactinfo"));
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
            Logger.getLogger(EmergencyDesk.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void callPoliceIfNecessary(){
        JOptionPane.showMessageDialog(cp, "Call Police if necessary");
        JPanel form= new JPanel(new GridLayout(10,1, 4,4 ));
        form.setBackground(Color.PINK);
        JLabel firnumberLabel= new JLabel("FIR number:");
        firnumberField= new JTextField();
        form.add(firnumberLabel);
        form.add(firnumberField);
        
        JLabel accidenttypeLabel= new JLabel("Accident Type:");
        accidenttypeField= new JTextField();
        form.add(accidenttypeLabel);
        form.add(accidenttypeField);
        
        JLabel accidentdateLabel= new JLabel("Accident Date:");
        //accidentdateField= new JTextField();
        form.add(accidentdateLabel);
        //form.add(accidentdateField);
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        DateLabelFormatter dateLabel=new DateLabelFormatter();
        datePicker = new JDatePickerImpl(datePanel, dateLabel);
         form.add(datePicker);
        JLabel accidenttimeLabel= new JLabel("Accident Time:");
        accidenttimeField= new JTextField();
        form.add(accidenttimeLabel);
        form.add(accidenttimeField);
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
                ps = con.prepareStatement("insert into policerecord values(?,?,?,?,?)");
                ps.setString(1, ""+(patientid+1));
                ps.setString(2, firnumberField.getText());
                ps.setString(3, accidenttypeField.getText());
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                Date scheduled_date_obj1=(Date)datePicker.getModel().getValue();
                String scheduled_date=dateFormat.format(scheduled_date_obj1);
                ps.setString(4, scheduled_date);
                ps.setString(5, accidenttimeField.getText());
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(EmergencyDesk.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }});
    }
    
}
