package BasicLayout;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import login.LogIn;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mansi Verma
 */
class LogOut  {

     private Component cp;
     
     public void actionLogIn(JFrame jFrame){
         jFrame.dispose();
         LogIn login= new LogIn();
     }


     
}
