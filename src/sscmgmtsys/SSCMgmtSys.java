/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sscmgmtsys;

import UserInterface.*;
import javax.swing.UIManager;

/**
 *
 * @author user
 */
public class SSCMgmtSys {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try { 
    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
} catch (Exception ex) { 
    ex.printStackTrace(); 
}
        LoginPage home = new LoginPage();
        home.setVisible(true);
        
        

    }

}
