package BasicLayout;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
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
    private final JPanel menuBar;
    private static final MenuBar instance= new MenuBar();
    
    
    protected MenuBar(){
        menuBar=new JPanel(new BorderLayout());
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
        JMenuItem newGame= new JMenuItem("logout");
        newGame.addActionListener((ActionListener) new LogOut());
        game.add(newGame);
       
        jMenuBar.add(game);
        
        this.menuBar.add(jMenuBar);
    }
    
}
