/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import DataLayer.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.JOptionPane;
import DataLayer.*;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author user
 */
public class UserManagement {
    DataUtility du  = new DataUtility();
    
    public boolean checkUser(String user, String pass){
         boolean x = false;
        try {
           
            //String FName;
            //String LName;
            String UName = null;
            String Pass = null;
            String UType;
            
             ResultSet rs = du.getUserInfo(user);
                rs.beforeFirst();
                rs.last();
            int rows = rs.getRow();
                   rs.beforeFirst();
             System.out.print("\t"+rows+"\t");
             
             if (rows >= 1){ System.out.print("\t A"+rows);
                    while(rs.next()){
                        int UID = rs.getInt("UserID");
                        UName = rs.getString("UserName");System.out.print("\t"+UName+"\t");
                        Pass = rs.getString("Password");
                        UType = rs.getString("UserType");
                    }
             }else{
                 x = false; System.out.print("\t B"+rows);
                 return x;
             }
            
             if(!(UName.equals(user))) {
                        //JOptionPane.showMessageDialog(null,"Incorrect UserName");
                       // break; 
                       x = false; System.out.print("\t"+UName+"\t");
                     }else if(!(Pass.equals(pass))){
                         //JOptionPane.showMessageDialog(null,"Incorrect Password");
                         x = false;
                     }else{
                        // JOptionPane.showMessageDialog(null,"Login Succesfull");
                       x = true;
                     }         
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UserManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    return x;
    }
    
    
    public boolean checkAdmin(String user, String pass){
         boolean x = false;
        try {
           
            
            String UName = null;
            String Pass = null;
            String UType = null;
           
            ResultSet rs = du.getAdminInfo(user);
            
            while(rs.next()){
                int UID = rs.getInt("UserID");
                UName = rs.getString("UserName");
                Pass = rs.getString("Password");
                UType = rs.getString("UserType");
                
                 System.out.print("\n"+UName+"\t"+Pass+"\t"+UType+"\n");
            }
            
            
            if((UName.equals(user) && (Pass.equals(pass)))) {
                         //JOptionPane.showMessageDialog(null,"Login Succesfull");
                       x = true;
                       System.out.print("\n"+UName+"\t"+Pass+"\t"+UType+"\n");
                     }else{
                         x = false;
                         System.out.print("\n"+UName+"\t"+Pass+"\t"+UType+"\n");
                     }         
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UserManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.print("\n"+x+"\n");
    return x;
}
    
   public boolean register(String userID, String userName, String passW, String userType){
       boolean x = false;
       x = du.saveUserInfo(userID, userName, userType, passW); 
       
        return x;
   }
   
   /*public boolean updateUser(String userID, String userName, String passW, String userType){
        boolean x = false;
       x = du.updateUserInfo(userID, userName, userType, passW); 
       
        return x;
   }*/
    
   public boolean deleteUserInfo(String userN){
       boolean x = false;
       x = du.deleteUser(userN);
       
       return x;
       
   }
   public ResultSet DisplayUser(){
        ResultSet rs = null;
       rs = du.getUser(); 
 
                   
             return rs;
        
 }
}
