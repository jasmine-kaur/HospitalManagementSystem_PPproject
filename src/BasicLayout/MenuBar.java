
import java.awt.BorderLayout;
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
public class MenuBar {
    private JPanel menuBar;
    private static MenuBar instance= new MenuBar();
    
    
    protected MenuBar(){
        menuBar=new JPanel(new BorderLayout());
        //menuBar.setSize(640, 480);
    }
    
    public static MenuBar getInstance(){
        return instance;
    }
    
    public JPanel getMenu(){
        
        return menuBar;
    }
    
    public void setMenu(){
        JMenuBar jMenuBar=new JMenuBar();
        JMenu game=new JMenu("mansi");
        //Game gameMenu=new Game();
        JMenuItem newGame= new JMenuItem("logout");
        newGame.addActionListener(new LogOut());
        game.add(newGame);
       
        jMenuBar.add(game);
        
        this.menuBar.add(jMenuBar);
    }
    
}
