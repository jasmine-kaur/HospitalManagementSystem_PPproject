package BasicLayout;

import java.awt.Component;
import javax.swing.JFrame;
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
         LogIn logIn = new LogIn();
     }


     
}
