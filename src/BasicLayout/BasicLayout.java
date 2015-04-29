

package BasicLayout;

//import com.sun.java.util.jar.pack.Attribute.Layout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;



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
    JMenuBar jMenuBar =new JMenuBar();
    
    public void addUI(){
       
      //main frame
        jFrame= new JFrame("IIITD Hospital" );
        jFrame.setLayout(new BorderLayout());
        jFrame.setSize(400, 400);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
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
    
    public void addUser(String  name){
        JMenuBar jMenuBar=new JMenuBar();
        JMenu user=new JMenu(name);
        //Game gameMenu=new Game();
        JMenuItem logOut= new JMenuItem("log out");
        logOut.addActionListener(new LogOut());
        user.add(logOut);
        
        jMenuBar.add(user);
         
        loginAs.add(jMenuBar);
       
    }
    
    public JPanel getFunctions(){
        return buttons;
    }
   
    
    
}
