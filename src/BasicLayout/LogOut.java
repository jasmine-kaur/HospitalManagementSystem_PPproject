package BasicLayout;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mansi Verma
 */
class LogOut implements ActionListener {

     private Component cp;

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane
          .showMessageDialog(
              cp,
              "SUCCESSFULLY LOGOUT");
        
    }

    
}
