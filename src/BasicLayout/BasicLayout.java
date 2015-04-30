

package BasicLayout;

//import com.sun.java.util.jar.pack.Attribute.Layout;
import BasicDetails.Name;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
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
    //private JLabel title;
    private JPanel title_panel;
    private JPanel buttons;
    private JPanel footer;
    private JPanel main;
    private JPanel loginAs;
    Patient patient;
    JMenuBar jMenuBar =new JMenuBar();
    
    public void addUI(){
       
      //main frame
        jFrame= new JFrame("IIITD Hospital" );
        jFrame.setLayout(new BorderLayout());
        jFrame.setSize(400, 400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        
        //Title panel with label iiitd-hospital
        title_panel= new JPanel(new BorderLayout());
        
        //Panel after title panel
        loginAs= new JPanel(new BorderLayout());
        buttons=new JPanel();
        main= new JPanel(new BorderLayout());
       Dimension d= new Dimension(50,50);
       title_panel.setPreferredSize(d);
        
       
       
       loginAs.setBackground(Color.DARK_GRAY);
       
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
    
      
    
    public JPanel getCustomerForm(){
        
        JPanel form= new JPanel(new GridLayout(10,1, 4,4 ));
        form.setBackground(Color.PINK);
        JLabel firstnameLabel= new JLabel("First Name:");
        JLabel secondnameLabel= new JLabel("Second Name:");
        JLabel dobLabel= new JLabel("Date of Birth:");
        JLabel genderLabel= new JLabel("Gender:");
        JLabel regIDLabel= new JLabel("Registration Id:");
        JLabel contactLabel= new JLabel("Contact Info:");
        JLabel addressLabel= new JLabel("Address:");
        
        JTextField firstnameField= new JTextField();
        JTextField secondnameField= new JTextField();
        JTextField dobField= new JTextField();
        
        JRadioButton male= new JRadioButton("male");
        JRadioButton female= new JRadioButton("female");
        JRadioButton others= new JRadioButton("others");
                
        JTextField regIdField= new JTextField();
        JTextField contactField= new JTextField();
        JTextField addressField= new JTextField();
        
        //Adding them in the panel created
        form.add(firstnameLabel);
        form.add(firstnameField);
       // form.add(new JSeparator(SwingConstants.HORIZONTAL));
        
        form.add(secondnameLabel);
        form.add(secondnameField);
        
        form.add(dobLabel);
        //Adding date picker
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        DateLabelFormatter dateLabel=new DateLabelFormatter();
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, dateLabel);
        form.add(datePicker);
        

        Calendar selectedValue = (Calendar) datePicker.getModel().getValue();
        Date selectedDate = selectedValue.getTime();
        System.out.println("date:"+selectedDate);
        
        //Adding radiobutton
        form.add(genderLabel);
        form.add(male);
        form.add(female);
        form.add(others);
        
        //Adding registrationid
        form.add(regIDLabel);
        form.add(regIdField);
        
        //Adding contact info
        form.add(contactLabel);
        form.add(contactField);
        
        //Adding address
        form.add(addressLabel);
        form.add(addressField);
        
        //Name name=new Name(firstnameField.getText(),secondnameField.getText(),null);
        //name.setFirstname(firstname.getText());
        //patient.setName(name);
       /*if(male.isSelected()){
            patient.setGender(Gender.MALE);
        }
        if(female.isSelected()){
            patient.setGender(Gender.FEMALE);
        }
        */
        
        //String localDate= datePicker
       // System.out.println("local date:"+ localDate);
        //patient.setDateOfBirth(datePicker.get);//
        
        return form;
    }
    
    public JPanel getFunctions(){
        return buttons;
    }
   
    public Patient getPatient(){
        
        if(patient!=null)
            return patient;
        return null;
    }
    
    
}
