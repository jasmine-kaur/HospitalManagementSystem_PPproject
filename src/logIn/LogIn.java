/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

/**
 *
 * @author Aarushi
 */




import javax.swing.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.*;

import java.awt.event.*;

import java.sql.*;
import staff.Receptionist;
import staff.StaffAdmin;
import staff.StaffType;



public class LogIn extends JFrame implements ActionListener

{

    public static Connection con; 
    JLabel l1, l2, l3;

    JTextField tf1;

    JButton btn1;

    JPasswordField p1;

 

    LogIn()

    {   
        

        setTitle("Login Form in Windows Form");

        setVisible(true);

        setSize(800, 800);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

 

        l1 = new JLabel("Login:");

        l1.setForeground(Color.blue);

        l1.setFont(new Font("Serif", Font.BOLD, 20));

 

        l2 = new JLabel("Enter username:");

        l3 = new JLabel("Enter Password:");

        tf1 = new JTextField();

        p1 = new JPasswordField();

        btn1 = new JButton("Submit");

 

        l1.setBounds(100, 30, 400, 30);

        l2.setBounds(80, 70, 200, 30);

        l3.setBounds(80, 110, 200, 30);

        tf1.setBounds(300, 70, 200, 30);

        p1.setBounds(300, 110, 200, 30);

        btn1.setBounds(150, 160, 100, 30);

 

        add(l1);

        add(l2);

        add(tf1);

        add(l3);

        add(p1);

        add(btn1);

        btn1.addActionListener(this);

    }

 

    public void actionPerformed(ActionEvent e)

    {

        showData();

    }

 

    public void showData()

    {

        JFrame f1 = new JFrame();

        JLabel l, l0;

 

        String str1 = tf1.getText();

        char[] p = p1.getPassword();

        String str2 = new String(p);

        try

        {

            Class.forName("com.mysql.jdbc.Driver");
            //String host="173.194.253.179/pp";
            String host="jdbc:mysql://173.194.253.179/hospital";
            con = DriverManager.getConnection(host, "root", "sampleapp");

            PreparedStatement ps = con.prepareStatement("select username,employeetype,employeeid from login where username =? and password=?");

            ps.setString(1, str1);

            ps.setString(2, str2);
          

            //System.out.println("Type of the employee:"+str1+","+str2);
            ResultSet rs = ps.executeQuery();

            if (rs.next())

            {
                dispose();
                JOptionPane.showMessageDialog(null,

                   "SUCCESSFULLY LOGIN :)))))))))))!");
                String employeeType=rs.getString(2);
                
                if( employeeType.equals(StaffType.RECEPTIONIST.getStaffType())){
                    Receptionist rec= new Receptionist();
                    rec.addUI();
                }
                else if(employeeType.equals(StaffType.STAFFADMIN.getStaffType())){
                    StaffAdmin sta=new StaffAdmin(Integer.parseInt(rs.getString(3)));
                    sta.addUI();
                }
                else{}
                //System.out.println("Type of Employee:"+employeetype);
                /*f1.setVisible(true);

                f1.setSize(600, 600);

                f1.setLayout(null);

                l = new JLabel();

                l0 = new JLabel("you are succefully logged in..");

                l0.setForeground(Color.blue);

                l0.setFont(new Font("Serif", Font.BOLD, 30));

                l.setBounds(60, 50, 400, 30);

                l0.setBounds(60, 100, 400, 40);

 

                f1.add(l);

                f1.add(l0);

                l.setText("Welcome " + rs.getString(1));

                l.setForeground(Color.red);

                l.setFont(new Font("Serif", Font.BOLD, 30));*/

 

            } else

            {

                JOptionPane.showMessageDialog(null,

                   "Incorrect email-Id or password..Try Again with correct detail");

            }

        }

        catch (Exception ex)

        {

            System.out.println(ex);

        }

    }
    public static void main(String[] args) {
        // TODO code application logic here
        new LogIn();
    }

}