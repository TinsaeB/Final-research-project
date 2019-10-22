/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author user
 */
public class DBConnection {
    
     private static Connection con;
     private boolean x = false;
        static Connection getCon(){
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String constr="jdbc:sqlserver://localhost; databaseName=SSCMgmtSysDB;user=TINSAE1;password=123";
                con=DriverManager.getConnection(constr);
               // JOptionPane.showMessageDialog(null, "Connected");
                return con;
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("not connected"+ex.getMessage());
                   JOptionPane.showMessageDialog(null, "Not Connected");
                }
            return null;    
       } 
    
        
        
    
    
    
    
    
   
    
    
    
    
   public boolean saveCCPlatationD (String year, int iSC, Long sC, Long aCPRate, Long sCP, Long aDA,long cumDA){
       
       try {
             Connection con = DBConnection.getCon();
             String query = "USE SSCMgmtSysDB; INSERT INTO CCPlantationD "+" VALUES('"+year+"','"+iSC+"','"
                     +sC+"','"+aCPRate+"','"+sCP+"','"+aDA+"','"+cumDA+"')";
             con.prepareStatement(query); 
             x = con.createStatement().execute(query);            
             
             
         } catch (SQLException ex) {
             Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         
       
       
       return x;
   }
    
    
   
       
    
    public ResultSet getResultSetF(){
        
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; SELECT FactoryID FROM Plantation;";
             con = DBConnection.getCon();

             // PreparedStatement ps = con.prepareStatement(query);
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    System.out.print(rs.getFetchSize());
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        return rs;
    }
    
    public ResultSet getTotalHA(String fID){
        
          ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; SELECT TotalPlantationArea FROM Plantation WHERE FactoryID = '"+fID+"';";
             con = DBConnection.getCon();

             // PreparedStatement ps = con.prepareStatement(query);
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    System.out.print(rs.getFetchSize());
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        return rs;
        
    }
    
    public ResultSet getCommercialHA(String fID){
        
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; SELECT HarvestableArea FROM Plantation WHERE FactoryID = '"+fID+"';";
             con = DBConnection.getCon();

             // PreparedStatement ps = con.prepareStatement(query);
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    System.out.print(rs.getFetchSize());
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        return rs;
        
    }
    
    
    public boolean Disconnect()
    {
        if(con != null)
        {
            try
            {
                if(!con.isClosed())
                {
                    
                    con.close();
                }
                return true;
            }
            catch(Exception ex)
            {
                System.err.println(ex.toString());
                return false;
            }
            finally
            {
             
            }
        }
         return false;
    }
}
         
    
