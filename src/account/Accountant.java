/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package account;
import BasicDetails.Address;
import BasicDetails.Name;
import BasicLayout.BasicLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static login.LogIn.con;
import staff.*;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.JTextField;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author Devanshu
 */
public class Accountant implements Staff{
    
    private int employeeId;
    private Name name;
    private Date dateOfBirth;
    private Long contactInfo;
    private Address address;
    private int salary;
    private JPanel jFunction;
    
    private Component cp;
    private JPanel right;
    private JPanel left;
    Budget bgt=new Budget();
    
    public Accountant(){
        this.address=null;
        this.contactInfo=null;
        this.cp=null;
        this.dateOfBirth=null;
        this.employeeId=0;
        this.jFunction=null;
        this.left=null;
        this.right=null;
        this.salary=0;
    }
    public Accountant(int employeeId){
        this.employeeId=employeeId;
    }
    
    public void addUI(){
        
        JButton viewPro= new JButton("View Profile");
        JButton updateBudget= new JButton("Update Budget");
        JButton viewBudget= new JButton("View Budget");
        JButton tenderDone= new JButton("Tender Done");
        JButton addFunder= new JButton("Add Funder");

        
        BasicLayout basicLayout= new BasicLayout();
        basicLayout.addUI();
        
        left= new JPanel(new GridLayout(10,1, 4,4 ));
     
        right= new JPanel();

        right.setBackground(Color.PINK);
        jFunction = basicLayout.getFunctions();
        
        jFunction.setLayout(new GridLayout(1,2,4,4));
         
        left.add(updateBudget);
        left.add(viewBudget);
        left.add(viewPro);
        left.add(tenderDone);
        left.add(addFunder);

        
        jFunction.add(left);
        jFunction.add(right);
        
        updateBudget.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                updateBudget();
            }
        } );
        
        viewBudget.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                viewBudget();
            }
        } );
        
        addFunder.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                addFunderToSystem();
            }
        });
        
        tenderDone.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                tenderSuccess();
            }
        });
        
        viewPro.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                viewProfile();
            }
        });
        
    }
    @Override
    public void viewProfile(){
        
        try{ //To change body of generated methods, choose Tools | Templates.
        
            PreparedStatement ps=con.prepareStatement("select * from accountant where employeeid =?");
            ps.setString(1, ""+employeeId);
            System.out.println(employeeId);
            //ps.setString(1, Integer.toString(employeeId));
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
            Logger.getLogger(Nurse.class.getName()).log(Level.SEVERE,null,ex);
        }
        
    }
    
    public void getBill(int amt){
        
        bgt.budgetValue+=amt;
        updateBudget();   
    }
    
    
    //Set budget details
    private void updateBudget(){
        try{
            PreparedStatement ps=con.prepareStatement("update budget set budgetvalue=? where budgetid=1");
            ps.setString(1, ""+bgt.getBudget());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(cp,"Budget updated");
        }
        catch(SQLException ex){
            Logger.getLogger(Nurse.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    private void viewBudget(){
        
        try{
            JPanel jp=new JPanel(new GridLayout(12,1,4,4));
            jp.setBackground(Color.pink);
            
            PreparedStatement ps=con.prepareStatement("select budgetvalue from budget where budgetid=1");
            java.sql.ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                JLabel jbudget = new JLabel("Budget: "+rs.getString("budgetvalue"));
                jp.add(jbudget);  
                }
                right.removeAll();
                right.add(jp);
                right.revalidate();
                right.repaint();
        }
        
        catch(SQLException ex){
            Logger.getLogger(Accountant.class.getName()).log(Level.SEVERE,null,ex);
        }
                    
    }
    
    JTextField fundidField,fundnameField,fundingdateField,chequeNumberField,contactField,amountField;
    public void addFunderToSystem(){
        
        
        JPanel form= new JPanel(new GridLayout(10,1,4,4 ));
        form.setBackground(Color.PINK);
        
        JLabel fundnameLabel= new JLabel("Trustee Name:");
        fundnameField= new JTextField();
        form.add(fundnameLabel);
        form.add(fundnameField);
        
        JLabel fundingdateLabel= new JLabel("Date:");
        form.add(fundingdateLabel);
        
        UtilDateModel model = new UtilDateModel();
        model.setDate(1990, 8, 24);
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        DateLabelFormatter dateLabel=new DateLabelFormatter();
        final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, dateLabel);
        form.add(datePicker);
        
        JLabel chequeNumLabel = new JLabel("Cheque Number:");
        chequeNumberField= new JTextField();
        form.add(chequeNumLabel);
        form.add(chequeNumberField);
        
        JLabel contactLabel = new JLabel("Contact:");
        contactField= new JTextField();
        form.add(contactLabel);
        form.add(contactField);
        
        JLabel amountLabel = new JLabel("Amount Given:");
        amountField= new JTextField();
        form.add(amountLabel);
        form.add(amountField);
        
        JButton submit=new JButton("Submit");
        form.add(submit);
        
        submit.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
            int rid=0;
            String funderid="";
            
            Date scheduled_date_obj1=(Date)datePicker.getModel().getValue();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            final String scheduledDate=dateFormat.format(scheduled_date_obj1);
            
            try{
            
            int id=0;    
            PreparedStatement ps1=con.prepareStatement("select MAX(fundid) from funders");
            ResultSet rs1=ps1.executeQuery();
            
            while(rs1.next()){
            
            if(rs1.getString(1)==null)
            {
                id=0;
                rid=id+1;
            }
            else{
                rid=Integer.parseInt(rs1.getString(1))+1;
            }
            
            funderid=Integer.toString(rid);
            
            }
                
            PreparedStatement ps=con.prepareStatement("insert into funders values(?,?,?,?,?,?)");
            ps.setString(1, funderid);
            //,fundingdateField,chequeNumberField,contactField,amountField
            ps.setString(2, fundnameField.getText());
            ps.setString(3, scheduledDate);
            ps.setString(4, chequeNumberField.getText());
            ps.setString(5, contactField.getText());
            ps.setString(6, amountField.getText());
            
            
            
            ps.executeUpdate();
            int amount=Integer.parseInt(amountField.getText());
                getBill(amount);
                updateBudget();
            
            }catch(SQLException ex){   
                Logger.getLogger(Accountant.class.getName()).log(Level.SEVERE,null,ex);
            }
     
        }
        } );
        right.removeAll();
        right.add(form);
        right.revalidate();
        right.repaint();
        
    }


    public void tenderSuccess(){
        ArrayList<String> al = new ArrayList<String>();
        String tenderId,getId;
        long tenderAmount;
        int budgetLowFlag=0;
        try{
            JPanel jp=new JPanel(new GridLayout(12,1,4,4));
            jp.setBackground(Color.pink);
            
            PreparedStatement ps=con.prepareStatement("select * from tender where tenderstatus=?");
            ps.setString(1, ""+"closed");
            java.sql.ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                
                tenderId=rs.getString("tenderid");
                al.add(tenderId);
                
            }
            
            for (int i = 0; i < al.size(); i++) {
                getId=al.get(i);
                System.out.println(getId);

                PreparedStatement ps1=con.prepareStatement("select tenderamount from tender where tenderid=?");
                ps1.setString(1, ""+getId);
                java.sql.ResultSet rs1 = ps1.executeQuery();
                while(rs1.next()){
                    tenderAmount=Integer.parseInt(rs1.getString("tenderamount"));
                    System.out.println(tenderAmount);
                
                    JLabel jtenderid = new JLabel("Tender Id: "+getId);
                    JLabel jtenderamount = new JLabel("Tender Amount: "+ tenderAmount);
                
                    jp.add(jtenderid);  
                    jp.add(jtenderamount); 
                
                    if(bgt.getBudget()>=tenderAmount){
                        
                        PreparedStatement ps2=con.prepareStatement("update tender set tenderstatus = 'paid' where tenderid=?");
                        ps2.setString(1, ""+getId);
                        ps2.executeUpdate();
                        long value=bgt.getBudget();
                        value=value-tenderAmount;
                        bgt.setBudget(value);
                        updateBudget();  
                        
                    }
                    else{
                        if(budgetLowFlag==0)
                        {
                            JOptionPane.showMessageDialog(cp,"Budget Value low, Cannot give necessary amount");}
                            budgetLowFlag=1;
                    }
                }
                
            }
            budgetLowFlag=0;   
            right.removeAll();
            right.add(jp);
            right.revalidate();
            right.repaint();
            
            JOptionPane.showMessageDialog(cp,"All tenders paid");
            
        }catch(SQLException ex){
            Logger.getLogger(Accountant.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
}
