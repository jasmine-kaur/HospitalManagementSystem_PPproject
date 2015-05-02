

package BasicLayout;

//import com.sun.java.util.jar.pack.Attribute.Layout;
import BasicDetails.Address;
import BasicDetails.Name;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import patient.Gender;
import patient.Patient;
import staff.DateLabelFormatter;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mansi Verma
 */

public class BasicLayout {
    
    private JFrame jFrame;
    boolean enteredData=false;
    private JPanel title_panel;
    private JPanel buttons;
    private JPanel footer;
    private JPanel main;
    private JPanel loginAs;
    Patient patient;
    JMenuBar jMenuBar =new JMenuBar();
    private final int MAX=1024;
    
    ///////////////////////
    JTextField firstnameField;
        JTextField secondnameField;
        JTextField thirdnameField;
     
        JTextField contactField;
        JTextField houseNumField;
        JTextField streetField;
        JTextField cityField;
        JTextField stateField;
        JTextField postalcodeField;
        JRadioButton male;
        JRadioButton female;
        JRadioButton others;
        JTextField dobField;
        JDatePickerImpl datePicker ;
        JTextField billField;
        //BloodGroup bloodGroup, int PatientId, 
        //int Registrationid, DepartmentType departmentType, int doctorId, int wardNumber, String medicine)
        JTextField departmentTypeField;
        JButton submit=new JButton("Submit");
    
    public void addUI(){
       
      //main frame
        jFrame= new JFrame("IIITD Hospital" );
        jFrame.setLayout(new BorderLayout());
        jFrame.setSize(400, 400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        
        //Title panel with label iiitd-hospital
        title_panel= new JPanel(new BorderLayout());
        
        JButton logOut= new JButton("Log out");
        
        //Panel after title panel
        
        loginAs= new JPanel(new BorderLayout());
        buttons=new JPanel();
        main= new JPanel(new BorderLayout());
       Dimension d= new Dimension(50,50);
       title_panel.setPreferredSize(d);
        
       logOut.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                LogOut logOut= new LogOut();
                
                int dialogResult = JOptionPane.showConfirmDialog (null, "You really wanna LOG OUT?","Warning",1);
                if(dialogResult == JOptionPane.YES_OPTION){
                     JOptionPane.showMessageDialog(null,"SUCCESSFULLY LOGOUT");
                     logOut.actionLogIn(jFrame);
                }
            }});
       
       
       loginAs.setBackground(Color.DARK_GRAY);
       loginAs.add(logOut, BorderLayout.EAST);
       loginAs.setPreferredSize(d);
         
       title_panel.setBackground(Color.cyan);
       JPanel title_main= new JPanel(new BorderLayout());
       title_main.setBackground(Color.DARK_GRAY);
       
       JLabel name=new JLabel("IIITD-Hospital", JLabel.CENTER);
       
       title_panel.add(name, BorderLayout.CENTER);
      
            
       title_main.add(title_panel, BorderLayout.NORTH);
       title_main.add(loginAs, BorderLayout.SOUTH);
         
       //Buttons is the panel to set buttons for the functionality 
       //This panel will be returned to set buttons for functionalities
       buttons.setBackground(Color.LIGHT_GRAY);
       main.setBackground(Color.BLACK);
        
       
       
         
         main.add(title_main, BorderLayout.NORTH);
         main.add(buttons);
         
        
         footer= new JPanel(new BorderLayout());
         JLabel footerName=new JLabel("copyright@PP_Team", JLabel.CENTER);
         
         footer.add(footerName,BorderLayout.CENTER);
         main.add(footer, BorderLayout.SOUTH);
         jFrame.add(main);
         
    }
    
      
    
    public JPanel getCustomerForm(final JButton saveToDb){
        
        patient= new Patient();
        
        JPanel form= new JPanel(new GridLayout(20,1, 4,4 ));
        form.setBackground(Color.PINK);
        JLabel firstnameLabel= new JLabel("First Name:");
        JLabel secondnameLabel= new JLabel("Second Name:");
        JLabel thirdnameLabel= new JLabel("Third Name:");
        JLabel dobLabel= new JLabel("Date of Birth:");
        JLabel genderLabel= new JLabel("Gender:");
        
        JLabel contactLabel= new JLabel("Contact Info:");
        JLabel houseNumLabel= new JLabel("House Number:");
        JLabel streetLabel= new JLabel("Street Name:");
        JLabel cityLabel= new JLabel("City:");
        JLabel stateLabel= new JLabel("State:");
        
        
        firstnameField= new JTextField();
        secondnameField= new JTextField();
        thirdnameField= new JTextField();
        
        //JTextField dobField= new JTextField();
        
        male= new JRadioButton("male");
        female= new JRadioButton("female");
         others= new JRadioButton("others");
                
      
         contactField= new JTextField();
         houseNumField= new JTextField();
         streetField= new JTextField();
         cityField= new JTextField();
         stateField= new JTextField();
         billField= new JTextField();
        dobField= new JTextField();
        
        //Adding them in the panel created
        form.add(firstnameLabel);
        form.add(firstnameField);
       firstnameField.setText("-");
       // form.add(new JSeparator(SwingConstants.HORIZONTAL));
        
        form.add(secondnameLabel);
        form.add(secondnameField);
        secondnameField.setText("-");
        
        form.add(thirdnameLabel);
        form.add(thirdnameField);
        thirdnameField.setText("-");
        
        form.add(dobLabel);
        //Adding date picker
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        DateLabelFormatter dateLabel=new DateLabelFormatter();
        datePicker = new JDatePickerImpl(datePanel, dateLabel);
        form.add(datePicker);
        
        //dobField.setText("1");
        //dobField.setText(datePicker.getModel().getValue().toString());
        /*Calendar selectedValue = (Calendar) datePicker.getModel().getValue();
        Date selectedDate = selectedValue.getTime();
        System.out.println("date:"+selectedDate);*/
        
        //Adding radiobutton
        form.add(genderLabel);
        form.add(male);
        form.add(female);
        form.add(others);
        
        /* private int houseNumber;
    private String street;
    private String city;
    private String state;
    private Long postalCode;*/
        //Adding registrationid
        /*form.add(regIDLabel);
        regIdField.setText("0");
        form.add(regIdField);*/
        
        //Adding contact info
        form.add(contactLabel);
        contactField.setText("0");
        form.add(contactField);
        
        //Adding address
        form.add(houseNumLabel);
        houseNumField.setText("0");
        form.add(houseNumField);
        
        form.add(streetLabel);
        streetField.setText("-");
        form.add(streetField);
        
        form.add(cityLabel);
        cityField.setText("-");
        form.add(cityField);
        
        form.add(stateLabel);
        stateField.setText("-");
        form.add(stateField);
        
  
        
        //
        
        
        
        submit.setPreferredSize(new Dimension(100,100));
        form.add(submit);
       
        
        submit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) { 
                
                System.out.println("Submit is clicked");
                saveToDb.setEnabled(true);
                
                if(male.isSelected()){
                    patient.setGender(Gender.MALE.getGender());
                }
                if(female.isSelected()){
                    patient.setGender(Gender.FEMALE.getGender());
                  }
                Name nameObj=new Name(firstnameField.getText(), secondnameField.getText(), thirdnameField.getText());
                
                patient.setName(nameObj);
                Date scheduled_date_obj1=(Date)datePicker.getModel().getValue();
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                String scheduled_date=dateFormat.format(scheduled_date_obj1);
                
                Address address=new Address(Integer.parseInt(houseNumField.getText()),streetField.getText(),cityField.getText(),stateField.getText());
                if(address.toString().length() > MAX ){
                    JOptionPane.showMessageDialog(null, "Too Long address!");
                }
                patient.setAddress(address);
                try{
                    patient.setContactInfo(Long.parseLong(contactField.getText()));
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Not proper format for contact information!");
                }
                
                try{
                    patient.setDateOfBirth(scheduled_date);
                }catch(NullPointerException ex){
                    JOptionPane.showMessageDialog(null, "Date field is empty!");
                }
                
                }
        });
       
        
        return form;
    }
    
    public JPanel getFunctions(){
        return buttons;
    }
   
    public JButton getSubmitButton(){
        return submit;
    }
    public Patient getPatient(){
        
        if(patient!=null)
            return patient;
        return null;
    }
    
    public static void main(String[] args) {
        BasicLayout basicLayout= new BasicLayout();
        basicLayout.addUI();
    }
    
}
