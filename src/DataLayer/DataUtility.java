/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import static DataLayer.DBConnection.getCon;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class DataUtility {
    boolean x = false;
    
    public boolean saveFactoryD(String fID, String fN, Long mD, Long nMS){
        x = false;
         try {
             Connection con = DBConnection.getCon();
             String query = "USE SSCMgmtSysDB; INSERT INTO Factory_Info "+" VALUES('"+fID+"','"+fN+"','"+mD+"','"+nMS+"')";
             con.prepareStatement(query); 
             x = con.createStatement().execute(query);            
             
             
         } catch (SQLException ex) {
             Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         return this.x;
    }
    
    public boolean savePlantationD(String plantationID, long tCA, long aC, float cC, float sC, float iSC, 
            float fors, float strs) throws SQLException{
        x = false;
         try {
             Connection con = DBConnection.getCon();
             String query = "USE SSCMgmtSysDB; INSERT INTO Plantation_Info "+" VALUES('"+plantationID+"','"+tCA+
                            "','"+aC+"','"+cC+"','"+sC+"','"+iSC+"','"+fors+"','"+strs+"')";
            con.prepareStatement(query); 
             x = con.createStatement().execute(query);
             
             
             
             
         } catch (SQLException ex) {
             Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         return x;
    }
    
    public boolean saveNewPlantationD(String plantationID, long tCA, long aC, float cC, float sC, float iSC, 
            float fors, float strs) throws SQLException{
        x = false;
         try {
             Connection con = DBConnection.getCon();
             String query = "USE SSCMgmtSysDB; INSERT INTO New_Plantation_Info "+" VALUES('"+plantationID+"','"+tCA+
                            "','"+aC+"','"+cC+"','"+sC+"','"+iSC+"','"+fors+"','"+strs+"')";
            con.prepareStatement(query); 
             x = con.createStatement().execute(query);
             
             
             
             
         } catch (SQLException ex) {
             Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         return x;
    }
    
    public boolean updateNewPlantationD(String plantationID, long tCA, long aC, float cC, float sC, float iSC, 
            float fors, float strs) throws SQLException{
        x = false;
         try {
             Connection con = DBConnection.getCon();
             String query = "USE SSCMgmtSysDB; UPDATE New_Plantation_Info SET PlantationID = '"+plantationID+"',TotalCaneArea = '"+tCA+
                            "',AnnualCane = '"+aC+"',CommercialCane = '"+cC+"',SeedCane = '"+sC+"',InitialSeedCane = '"+iSC+
                            "',OneRS = '"+fors+"',TwoRS = '"+strs+"';";
            con.prepareStatement(query); 
             x = con.createStatement().execute(query);
             
             
             
             
         } catch (SQLException ex) {
             Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         return x;
    }
    
     public boolean saveCaneSchedule(String cutting, int month, int yield )throws SQLException{
        
        x = false;
         try {
             Connection con = DBConnection.getCon();
             String query = "USE SSCMgmtSysDB; INSERT INTO Cane_Yield_Level "+" VALUES('"+cutting+"','"
                     +month+"','"+yield+"')";
             con.prepareStatement(query); 
             x = con.createStatement().execute(query);
             
             
             //return true;
         } catch (SQLException ex) {
             Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
       
      return x;
            
    }
     
    public boolean saveCPI(String pID, double avgCuttingAge_Years, long annualRotationArea, long avgCaneProduction, 
            long annualHarvestArea, long avgAge, long cC, long sC, long iSC){
        x = false;
         try {
             Connection con = DBConnection.getCon();
             String query = "USE SSCMgmtSysDB; INSERT INTO Calculated_Initial_Plantaion_Info "+" VALUES('"+pID+"','"+avgCuttingAge_Years+
                            "','"+annualRotationArea+"','"+avgCaneProduction+"','"+annualHarvestArea+"','"+avgAge+"','"+cC+"','"+sC+"','"+iSC+"')";
            con.prepareStatement(query); 
             x = con.createStatement().execute(query);
             
             
             
             
         } catch (SQLException ex) {
             Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         return x;
    }
    
    public boolean saveNewCPI(String pID, double avgCuttingAge_Years, long annualRotationArea, long avgCaneProduction, 
            long annualHarvestArea, long avgAge, long cC, long sC, long iSC){
        x = false;
         try {
             Connection con = DBConnection.getCon();
             String query = "USE SSCMgmtSysDB; INSERT INTO New_Calculated_Initial_Plantaion_Info "+" VALUES('"+pID+"','"+avgCuttingAge_Years+
                            "','"+annualRotationArea+"','"+avgCaneProduction+"','"+annualHarvestArea+"','"+avgAge+"','"+cC+"','"+sC+"','"+iSC+"')";
            con.prepareStatement(query); 
             x = con.createStatement().execute(query);
             
             
             
             
         } catch (SQLException ex) {
             Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         return x;
    }
    
    public boolean updateNewCPI(String pID, double avgCuttingAge_Years, long annualRotationArea, long avgCaneProduction, 
            long annualHarvestArea, long avgAge, long iSC, long sC, long cC){
        x = false;
         try {
             Connection con = DBConnection.getCon();
             String query = "USE SSCMgmtSysDB; UPDATE New_Calculated_Initial_Plantaion_Info SET PID = '"+pID+"',AvgCuttingAgeInYears = '"+avgCuttingAge_Years+
                            "',AnnualRotationArea = '"+annualRotationArea+"',AvgCaneProduction = '"+avgCaneProduction+"',AnnualHarvestArea = '"+annualHarvestArea+
                            "',AvgAge = '"+avgAge+"',ISC = '"+iSC+"',SC = '"+sC+"',CC = '"+cC+"';";
            con.prepareStatement(query); 
             x = con.createStatement().execute(query);
             
             
             
             
         } catch (SQLException ex) {
             Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         return x;
    }
    
    /*public boolean updateUserInfo(String userID, String userName, String passW, String userType){
        x = false;
        try {
             Connection con = DBConnection.getCon();
             String query = "USE SSCMgmtSysDB; INSERT INTO Users "+" VALUES('"+userID+"','"+userName+
                            "','"+passW+"','"+userType+"')";
            con.prepareStatement(query); 
             x = con.createStatement().execute(query);
    
             
             
             
             
         } catch (SQLException ex) {
             Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         return x;
    }
    */
    public boolean saveUserInfo(String userID, String userName, String passW, String userType){
        x = false;
        try {
             Connection con = DBConnection.getCon();
             String query = "USE SSCMgmtSysDB; INSERT INTO [User] "+" VALUES('"+userID+"','"+userName+
                           "','"+passW+"','"+userType+"')";
             /* String query="USE BookstoreRecord; UPDATE Users SET UserId = '"+userID+"',"
            +"Passw = '"+passW+"',"+"UserType = '"+userType+"'"+"WHERE UserName = '"+userName+"';";*/
             
            con.prepareStatement(query); 
             x = con.createStatement().execute(query);
             
             
            
             
         } catch (SQLException ex) {
             Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         return x;
    }
    
    public boolean saveNewConventionalACPlanting(int year, long ISC, long SC, long CC, long ADA, long Comulative){
        x = false;
        try {
             Connection con = DBConnection.getCon();
             String query = "USE SSCMgmtSysDB; INSERT INTO New_Conventional_Annual_Cane_Planting "+" VALUES('"+year+"','"+ISC+
                            "','"+SC+"','"+CC+"','"+ADA+"','"+Comulative+"')";
            con.prepareStatement(query); 
             x = con.createStatement().execute(query);
             
             
             
             
         } catch (SQLException ex) {
             Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         return x;
       
       
       
       
    }
    
    public boolean saveConventionalACPlanting(int year, long ISC, long SC, long CC, long ADA, long Comulative){
        x = false;
        try {
             Connection con = DBConnection.getCon();
             String query = "USE SSCMgmtSysDB; INSERT INTO Conventional_Annual_Cane_Planting "+" VALUES('"+year+"','"+ISC+
                            "','"+SC+"','"+CC+"','"+ADA+"','"+Comulative+"')";
            con.prepareStatement(query); 
             x = con.createStatement().execute(query);
             
             
             
             
         } catch (SQLException ex) {
             Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         return x;
       
       
       
       
    }
    
    public boolean saveNewReplantingSchedule(int year,long sC,long cC, long annualDevelopedArea, long cumulative){
         x = false;
        try {
             Connection con = DBConnection.getCon();
             String query = "USE SSCMgmtSysDB; INSERT INTO New_Replanting_Schedule "+" VALUES('"+year+"','"+
                            sC+"','"+cC+"','"+annualDevelopedArea+"','"+cumulative+"');";
            con.prepareStatement(query); 
             x = con.createStatement().execute(query);
             
             
             
             
         } catch (SQLException ex) {
             Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         return x;
    }
    
    public boolean saveReplantingSchedule(int year,long sC,long cC, long annualDevelopedArea, long cumulative){
         x = false;
        try {
             Connection con = DBConnection.getCon();
             String query = "USE SSCMgmtSysDB; INSERT INTO Replanting_Schedule "+" VALUES('"+year+"','"+
                            sC+"','"+cC+"','"+annualDevelopedArea+"','"+cumulative+"');";
            con.prepareStatement(query); 
             x = con.createStatement().execute(query);
             
             
             
             
         } catch (SQLException ex) {
             Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         return x;
        
    }
    
    public boolean saveNewHarvestProgramEXSC(long R[][], int LR, int LY){
         x = false;
        int i = 1;
        int j = 2;
        int r = 1;
            Connection con = DBConnection.getCon();
            while(r < LR-1){
            try {
                String query = "USE SSCMgmtSysDB; INSERT INTO New_Harvest_Program_EX_SC (Y0)"+" VALUES('R"+r+"')";
                con.prepareStatement(query);
                con.createStatement().execute(query);
                r++;
            } catch (SQLException ex) {
                Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
                        while (i < LY+LY){ 
                           //String query = "USE SSCMgmtSysDB; UPDATE Harvest_Program_EX-SC "+" SET('Y"+i+"="+R[i][j]+"')";
                            for(j=1; j < LR+1; j++){
                                try {
                                    String query = "USE SSCMgmtSysDB; UPDATE New_Harvest_Program_EX_SC  SET Y"+i+" = "+R[j][i]+"WHERE Y0 = 'R"+(j-1)+"'";
                                    con.prepareStatement(query);
                                    con.createStatement().executeUpdate(query);
                                } catch (SQLException ex) {
                                    Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                                }
                              }i++;//System.out.print(i+"\t");
                        }
       
        
        
        return x;
    }
    
    public boolean saveHarvestProgramEXSC(long R[][], int LR, int LY ){
        x = false;
        int i = 1;
        int j = 2;
        int r = 1;
            Connection con = DBConnection.getCon();
            while(r < LR-1){
            try {
                String query = "USE SSCMgmtSysDB; INSERT INTO Harvest_Program_EX_SC (Y0)"+" VALUES('R"+r+"')";
                con.prepareStatement(query);
                con.createStatement().execute(query);
                r++;
            } catch (SQLException ex) {
                Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
                        while (i < LY+LY){ 
                           //String query = "USE SSCMgmtSysDB; UPDATE Harvest_Program_EX-SC "+" SET('Y"+i+"="+R[i][j]+"')";
                            for(j=1; j < LR+1; j++){
                                try {
                                    String query = "USE SSCMgmtSysDB; UPDATE Harvest_Program_EX_SC  SET Y"+i+" = "+R[j][i]+"WHERE Y0 = 'R"+(j-1)+"'";
                                    con.prepareStatement(query);
                                    con.createStatement().executeUpdate(query);
                                } catch (SQLException ex) {
                                    Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                                }
                              }i++;//System.out.print(i+"\t");
                        }
       
        
        
        return x;
    }
    
    public boolean saveNewHarvestProgramCC(long R[][], int LR, int LY){
        x = false;
        int i = 1;
        int j = 2;
        int r = 0;
            Connection con = DBConnection.getCon();
            while(r < LR){
            try {
                if (r == 0){
                    String query = "USE SSCMgmtSysDB; INSERT INTO New_Harvest_Program_CC (Y0)"+" VALUES('CommercialCane')";
                    con.prepareStatement(query);
                    con.createStatement().execute(query);
                    r++;
                }else if(r == 1){
                    String query = "USE SSCMgmtSysDB; INSERT INTO New_Harvest_Program_CC (Y0)"+" VALUES('PC')";
                    con.prepareStatement(query);
                    con.createStatement().execute(query);
                    r++;
                }else{
                    String query = "USE SSCMgmtSysDB; INSERT INTO New_Harvest_Program_CC (Y0)"+" VALUES('R"+(r-1)+"')";
                    con.prepareStatement(query);
                    con.createStatement().execute(query);
                    r++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            
                        while (i < LY+LY+3){ 
                           //there should be some IF STATMETS HERE;
                           if (i==1){
                               for(j=1; j < LY+LY+1; j++){
                                try {
                                    String query = "USE SSCMgmtSysDB; UPDATE New_Harvest_Program_CC  SET Y"+(j)+" = "+R[i-1][j]+"WHERE Y0 = 'CommercialCane'";
                                    con.prepareStatement(query);
                                    con.createStatement().executeUpdate(query);
                                } catch (SQLException ex) {
                                    Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                                }
                              }i++;
                           }else if(i==2){
                               for(j=1; j < LY+LY+1; j++){
                                try {
                                    String query = "USE SSCMgmtSysDB; UPDATE New_Harvest_Program_CC  SET Y"+(j)+" = "+R[i-1][j]+"WHERE Y0 = 'PC'";
                                    con.prepareStatement(query);
                                    con.createStatement().executeUpdate(query);
                                } catch (SQLException ex) {
                                    Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                                }
                              }i++;
                           }else if ((i > 2)){
                            for(j=1; j < LY+LY+1; j++){
                                try {
                                    String query = "USE SSCMgmtSysDB; UPDATE New_Harvest_Program_CC  SET Y"+(j)+" = "+R[i-1][j]+"WHERE Y0 = 'R"+(i-2)+"'";
                                    con.prepareStatement(query);
                                    con.createStatement().executeUpdate(query);
                                } catch (SQLException ex) {
                                    Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                                }
                              }i++;//System.out.print(i+"\t");
                            }
        
            
                        }
        
        
        return x;
    }
    
    public boolean SaveHarvestProgramCC(long R[][], int LR, int LY ){
        x = false;
        int i = 1;
        int j = 2;
        int r = 0;
            Connection con = DBConnection.getCon();
            while(r < LR){
            try {
                if (r == 0){
                    String query = "USE SSCMgmtSysDB; INSERT INTO Harvest_Program_CC (Y0)"+" VALUES('CommercialCane')";
                    con.prepareStatement(query);
                    con.createStatement().execute(query);
                    r++;
                }else if(r == 1){
                    String query = "USE SSCMgmtSysDB; INSERT INTO Harvest_Program_CC (Y0)"+" VALUES('PC')";
                    con.prepareStatement(query);
                    con.createStatement().execute(query);
                    r++;
                }else{
                    String query = "USE SSCMgmtSysDB; INSERT INTO Harvest_Program_CC (Y0)"+" VALUES('R"+(r-1)+"')";
                    con.prepareStatement(query);
                    con.createStatement().execute(query);
                    r++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            
                        while (i < LY+LY+3){ 
                           //there should be some IF STATMETS HERE;
                           if (i==1){
                               for(j=1; j < LY+LY+1; j++){
                                try {
                                    String query = "USE SSCMgmtSysDB; UPDATE Harvest_Program_CC  SET Y"+(j)+" = "+R[i-1][j]+"WHERE Y0 = 'CommercialCane'";
                                    con.prepareStatement(query);
                                    con.createStatement().executeUpdate(query);
                                } catch (SQLException ex) {
                                    Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                                }
                              }i++;
                           }else if(i==2){
                               for(j=1; j < LY+LY+1; j++){
                                try {
                                    String query = "USE SSCMgmtSysDB; UPDATE Harvest_Program_CC  SET Y"+(j)+" = "+R[i-1][j]+"WHERE Y0 = 'PC'";
                                    con.prepareStatement(query);
                                    con.createStatement().executeUpdate(query);
                                } catch (SQLException ex) {
                                    Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                                }
                              }i++;
                           }else if ((i > 2)){
                            for(j=1; j < LY+LY+1; j++){
                                try {
                                    String query = "USE SSCMgmtSysDB; UPDATE Harvest_Program_CC  SET Y"+(j)+" = "+R[i-1][j]+"WHERE Y0 = 'R"+(i-2)+"'";
                                    con.prepareStatement(query);
                                    con.createStatement().executeUpdate(query);
                                } catch (SQLException ex) {
                                    Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                                }
                              }i++;//System.out.print(i+"\t");
                            }
        
            
                        }
        
        
        return x;
    }
    
    public boolean saveNewCTotalHCIPercent(float totalInPercent[], int LY){
         boolean x = false;
            //int i = 1;
            int j = 2;
            //int r = 1;
            Connection con = DBConnection.getCon();
        
        
                 try {
                            String query = "USE SSCMgmtSysDB; INSERT INTO New_Total_Harvest_In_Percent (Y0) VALUES('T_Harvest_In_Percent');";
                                            con = DBConnection.getCon();
                                            con.prepareStatement(query);
                                            con.createStatement().execute(query);
                
                            for(j=1; j < LY; j++){
                                query = "USE SSCMgmtSysDB; UPDATE New_Total_Harvest_In_Percent  SET Y"+(j)+" = "+totalInPercent[j]+"WHERE Y0 = 'T_Harvest_In_Percent';";
                               // System.out.print(j+"\t"+totalEXSC[j]+"\t");
                                con = DBConnection.getCon();
                                con.prepareStatement(query);
                                con.createStatement().executeUpdate(query);
                                
                            }//r++;
                } catch (SQLException ex) {
                    Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                }
        return x;
    }
    
    public boolean saveCTotalHCIPercent(float totalInPercent[],int LY){
        
        boolean x = false;
            //int i = 1;
            int j = 2;
            //int r = 1;
            Connection con = DBConnection.getCon();
        
        
                 try {
                            String query = "USE SSCMgmtSysDB; INSERT INTO Total_Harvest_In_Percent (Y0) VALUES('T_Harvest_In_Percent');";
                                            con = DBConnection.getCon();
                                            con.prepareStatement(query);
                                            con.createStatement().execute(query);
                
                            for(j=1; j < LY; j++){
                                query = "USE SSCMgmtSysDB; UPDATE Total_Harvest_In_Percent  SET Y"+(j)+" = "+totalInPercent[j]+"WHERE Y0 = 'T_Harvest_In_Percent';";
                               // System.out.print(j+"\t"+totalEXSC[j]+"\t");
                                con = DBConnection.getCon();
                                con.prepareStatement(query);
                                con.createStatement().executeUpdate(query);
                                
                            }//r++;
                } catch (SQLException ex) {
                    Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                }
        return x;
    }
    
    public boolean saveNewTotalHarvestCane(long totalEXSC[], long totalCC[],long totalReField[], long annualHarvestC[], int LY){
        
            boolean x = false;
            //int i = 1;
            int j = 2;
            int r = 1;
            Connection con = DBConnection.getCon();
            
            
            while(r < 5){
           
                
             if ( r == 1){
                    try {
                            String query = "USE SSCMgmtSysDB; INSERT INTO New_Total_Harvest_Cane (Y0) VALUES('Total_EX_SCH');";
                                            con = DBConnection.getCon();
                                            con.prepareStatement(query);
                                            con.createStatement().execute(query);
                
                            for(j=1; j <= LY+LY; j++){
                                query = "USE SSCMgmtSysDB; UPDATE New_Total_Harvest_Cane  SET Y"+(j)+" = "+totalEXSC[j]+"WHERE Y0 = 'Total_EX_SCH';";
                               // System.out.print(j+"\t"+totalEXSC[j]+"\t");
                                con = DBConnection.getCon();
                                con.prepareStatement(query);
                                con.createStatement().executeUpdate(query);
                                
                            }r++;
                } catch (SQLException ex) {
                    Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if ( r == 2){
                try {
                            String query = "USE SSCMgmtSysDB; INSERT INTO New_Total_Harvest_Cane (Y0) VALUES('Total_CCH');";
                                            con = DBConnection.getCon();
                                            con.prepareStatement(query);
                                            con.createStatement().execute(query);
                            
                            for(j=1; j <= LY+LY; j++){
                            query = "USE SSCMgmtSysDB; UPDATE New_Total_Harvest_Cane  SET Y"+(j)+" = "+totalCC[j]+"WHERE Y0 = 'Total_CCH';";
                            //System.out.print(j+"\t"+totalCC[j]+"\t");
                            con = DBConnection.getCon();
                            con.prepareStatement(query);
                    con.createStatement().executeUpdate(query);
                    
                    }r++;
                } catch (SQLException ex) {
                    Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if ( r == 3){
                try {
                            String query = "USE SSCMgmtSysDB; INSERT INTO New_Total_Harvest_Cane (Y0)"+" VALUES('Total_Replant_FieldH');";
                                           con = DBConnection.getCon();
                                           con.prepareStatement(query);
                                           con.createStatement().execute(query);

                            for(j=1; j <= LY+LY; j++){        
                            query = "USE SSCMgmtSysDB; UPDATE New_Total_Harvest_Cane  SET Y"+(j)+" = "+totalReField[j]+"WHERE Y0 = 'Total_Replant_FieldH';";
                            //System.out.print(j+"\t"+totalReField[j]+"\t");
                            con = DBConnection.getCon();
                            con.prepareStatement(query);
                            con.createStatement().executeUpdate(query);
                    
                    }r++;
                } catch (SQLException ex) {
                    Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if (r == 4){
                try {
                    String query = "USE SSCMgmtSysDB; INSERT INTO New_Total_Harvest_Cane (Y0)"+" VALUES('Total_Harvest_CH');";
                                    con = DBConnection.getCon();
                                    con.prepareStatement(query);
                                    con.createStatement().execute(query);

                            
                    for(j=1; j <= LY+LY; j++){        
                    query = "USE SSCMgmtSysDB; UPDATE New_Total_Harvest_Cane  SET Y"+(j)+" = "+annualHarvestC[j]+"WHERE Y0 = 'Total_Harvest_CH';";
                    System.out.print(j+"\t"+annualHarvestC[j]+"\n");
                    con = DBConnection.getCon();
                    con.prepareStatement(query);
                    con.createStatement().executeUpdate(query);
                    
                    }r++;
                } catch (SQLException ex) {
                    Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                }
            }//i++;//System.out.print(i+"\t");  
                     
            
       
    }
            return x;
    }
    
    public boolean saveTotalHarvestCane(long totalEXSC[], long totalCC[],long totalReField[], long annualHarvestC[], int LY){
        
            boolean x = false;
            //int i = 1;
            int j = 2;
            int r = 1;
            Connection con = DBConnection.getCon();
            
            
            while(r < 5){
           
                
             if ( r == 1){
                    try {
                            String query = "USE SSCMgmtSysDB; INSERT INTO Total_Harvest_Cane (Y0) VALUES('Total_EX_SCH');";
                                            con = DBConnection.getCon();
                                            con.prepareStatement(query);
                                            con.createStatement().execute(query);
                
                            for(j=1; j <= LY+LY; j++){
                                query = "USE SSCMgmtSysDB; UPDATE Total_Harvest_Cane  SET Y"+(j)+" = "+totalEXSC[j]+"WHERE Y0 = 'Total_EX_SCH';";
                               // System.out.print(j+"\t"+totalEXSC[j]+"\t");
                                con = DBConnection.getCon();
                                con.prepareStatement(query);
                                con.createStatement().executeUpdate(query);
                                
                            }r++;
                } catch (SQLException ex) {
                    Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if ( r == 2){
                try {
                            String query = "USE SSCMgmtSysDB; INSERT INTO Total_Harvest_Cane (Y0) VALUES('Total_CCH');";
                                            con = DBConnection.getCon();
                                            con.prepareStatement(query);
                                            con.createStatement().execute(query);
                            
                            for(j=1; j <= LY+LY; j++){
                            query = "USE SSCMgmtSysDB; UPDATE Total_Harvest_Cane  SET Y"+(j)+" = "+totalCC[j]+"WHERE Y0 = 'Total_CCH';";
                            //System.out.print(j+"\t"+totalCC[j]+"\t");
                            con = DBConnection.getCon();
                            con.prepareStatement(query);
                    con.createStatement().executeUpdate(query);
                    
                    }r++;
                } catch (SQLException ex) {
                    Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if ( r == 3){
                try {
                            String query = "USE SSCMgmtSysDB; INSERT INTO Total_Harvest_Cane (Y0)"+" VALUES('Total_Replant_FieldH');";
                                           con = DBConnection.getCon();
                                           con.prepareStatement(query);
                                           con.createStatement().execute(query);

                            for(j=1; j <= LY+LY; j++){        
                            query = "USE SSCMgmtSysDB; UPDATE Total_Harvest_Cane  SET Y"+(j)+" = "+totalReField[j]+"WHERE Y0 = 'Total_Replant_FieldH';";
                            //System.out.print(j+"\t"+totalReField[j]+"\t");
                            con = DBConnection.getCon();
                            con.prepareStatement(query);
                            con.createStatement().executeUpdate(query);
                    
                    }r++;
                } catch (SQLException ex) {
                    Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if (r == 4){
                try {
                    String query = "USE SSCMgmtSysDB; INSERT INTO Total_Harvest_Cane (Y0)"+" VALUES('Total_Harvest_CH');";
                                    con = DBConnection.getCon();
                                    con.prepareStatement(query);
                                    con.createStatement().execute(query);

                            
                    for(j=1; j <= LY+LY; j++){        
                    query = "USE SSCMgmtSysDB; UPDATE Total_Harvest_Cane  SET Y"+(j)+" = "+annualHarvestC[j]+"WHERE Y0 = 'Total_Harvest_CH';";
                    System.out.print(j+"\t"+annualHarvestC[j]+"\n");
                    con = DBConnection.getCon();
                    con.prepareStatement(query);
                    con.createStatement().executeUpdate(query);
                    
                    }r++;
                } catch (SQLException ex) {
                    Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                }
            }//i++;//System.out.print(i+"\t");  
                     
            
       
    }
            return x;
    }
    
    public boolean saveNewReplantFieldHarvest(long R[][], int LR, int LY){
        boolean x = false;
        int i = 1;
        int j = 2;
        int r = 0;
            Connection con = DBConnection.getCon();
            while(r < LR){
            try {
                if (r == 0){
                    String query = "USE SSCMgmtSysDB; INSERT INTO New_Replant_Filed_Harvest (Y0)"+" VALUES('CommercialCane')";
                    con.prepareStatement(query);
                    con.createStatement().execute(query);
                    r++;
                }else if(r == 1){
                    String query = "USE SSCMgmtSysDB; INSERT INTO New_Replant_Filed_Harvest (Y0)"+" VALUES('PC')";
                    con.prepareStatement(query);
                    con.createStatement().execute(query);
                    r++;
                }else{
                    String query = "USE SSCMgmtSysDB; INSERT INTO New_Replant_Filed_Harvest (Y0)"+" VALUES('R"+(r-1)+"')";
                    con.prepareStatement(query);
                    con.createStatement().execute(query);
                    r++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            
                        while (i < LY+LY+3){ 
                           //there should be some IF STATMETS HERE;
                           if (i==1){
                               for(j=2; j < LY+LY+2; j++){
                                try {
                                    String query = "USE SSCMgmtSysDB; UPDATE New_Replant_Filed_Harvest  SET Y"+(j-1)+" = "+R[i-1][j]+"WHERE Y0 = 'CommercialCane'";
                                    con.prepareStatement(query);
                                    con.createStatement().executeUpdate(query);
                                } catch (SQLException ex) {
                                    Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                                }
                              }i++;
                           }else if(i==2){
                               for(j=2; j < LY+LY+2; j++){
                                try {
                                    String query = "USE SSCMgmtSysDB; UPDATE New_Replant_Filed_Harvest  SET Y"+(j-1)+" = "+R[i-1][j]+"WHERE Y0 = 'PC'";
                                    con.prepareStatement(query);
                                    con.createStatement().executeUpdate(query);
                                } catch (SQLException ex) {
                                    Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                                }
                              }i++;
                           }else if ((i > 2)){
                            for(j=2; j < LY+LY+3; j++){
                                try {
                                    String query = "USE SSCMgmtSysDB; UPDATE New_Replant_Filed_Harvest  SET Y"+(i-2)+" = "+R[j-1][i-1]+"WHERE Y0 = 'R"+(j-2)+"'";
                                    con.prepareStatement(query);
                                    con.createStatement().executeUpdate(query);
                                } catch (SQLException ex) {
                                    Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                                }
                              }i++;//System.out.print(i+"\t");
                            }
        
            
                        }
        
        
        return x;
    }
    
    public boolean SaveReplantFieldHarvest(long R[][], int LR, int LY ){
        boolean x = false;
        int i = 1;
        int j = 2;
        int r = 0;
            Connection con = DBConnection.getCon();
            while(r < LR){
            try {
                if (r == 0){
                    String query = "USE SSCMgmtSysDB; INSERT INTO Replant_Filed_Harvest (Y0)"+" VALUES('CommercialCane')";
                    con.prepareStatement(query);
                    con.createStatement().execute(query);
                    r++;
                }else if(r == 1){
                    String query = "USE SSCMgmtSysDB; INSERT INTO Replant_Filed_Harvest (Y0)"+" VALUES('PC')";
                    con.prepareStatement(query);
                    con.createStatement().execute(query);
                    r++;
                }else{
                    String query = "USE SSCMgmtSysDB; INSERT INTO Replant_Filed_Harvest (Y0)"+" VALUES('R"+(r-1)+"')";
                    con.prepareStatement(query);
                    con.createStatement().execute(query);
                    r++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            
                        while (i < LY+LY+3){ 
                           //there should be some IF STATMETS HERE;
                           if (i==1){
                               for(j=2; j < LY+LY+2; j++){
                                try {
                                    String query = "USE SSCMgmtSysDB; UPDATE Replant_Filed_Harvest  SET Y"+(j-1)+" = "+R[i-1][j]+"WHERE Y0 = 'CommercialCane'";
                                    con.prepareStatement(query);
                                    con.createStatement().executeUpdate(query);
                                } catch (SQLException ex) {
                                    Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                                }
                              }i++;
                           }else if(i==2){
                               for(j=2; j < LY+LY+2; j++){
                                try {
                                    String query = "USE SSCMgmtSysDB; UPDATE Replant_Filed_Harvest  SET Y"+(j-1)+" = "+R[i-1][j]+"WHERE Y0 = 'PC'";
                                    con.prepareStatement(query);
                                    con.createStatement().executeUpdate(query);
                                } catch (SQLException ex) {
                                    Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                                }
                              }i++;
                           }else if ((i > 2)){
                            for(j=2; j < LY+LY+3; j++){
                                try {
                                    String query = "USE SSCMgmtSysDB; UPDATE Replant_Filed_Harvest  SET Y"+(i-2)+" = "+R[j-1][i-1]+"WHERE Y0 = 'R"+(j-2)+"'";
                                    con.prepareStatement(query);
                                    con.createStatement().executeUpdate(query);
                                } catch (SQLException ex) {
                                    Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                                }
                              }i++;//System.out.print(i+"\t");
                            }
        
            
                        }
        
        
        return x;
    }
    
    public ResultSet getUserInfo(String user){
         ResultSet rs = null;
         try {
             Connection con = DBConnection.getCon();
            // con = getCon();
             Statement st = con.createStatement();
                          
                     String query="USE SSCMgmtSysDB; SELECT * FROM [User] WHERE UserType = 'User' AND UserName= '"+user+" ';";
                   //Connection con = DBConnection.getCon(); //connects to the database 
                   st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
    ResultSet.CONCUR_READ_ONLY);
                    rs = st.executeQuery(query);
             System.out.print(rs);
         } catch (SQLException ex) {
             Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
         return rs;
    }
    public ResultSet getAdminInfo(String user){
        ResultSet rs = null;
         try {
             Connection con = DBConnection.getCon();
             con = getCon();
             Statement st = con.createStatement();
                          
                     String query="USE SSCMgmtSysDB; SELECT * FROM [User] WHERE UserType = 'Admin' AND UserName='"+user+"';";
                   //Connection con = DBConnection.getCon(); //connects to the database 
                   //st = con.createStatement();
                    rs = st.executeQuery(query);
             System.out.print(rs);
         } catch (SQLException ex) {
             Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
         return rs;
    }
    
    public long getMillingCapacity(String plantationID){
        long mc = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; SELECT MillingCapacity FROM Factory_Info;";
             Connection con = DBConnection.getCon();

            
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    mc = Long.parseLong(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
         System.out.print(mc); // for testing 
        
        return mc;
    }
    
    public long getNMSeason(String plantationID){
        long nMS = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; SELECT NetMillingSeason FROM Factory_Info;";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    nMS = Long.parseLong(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
        System.out.print(nMS); // for testing
        
        return nMS; 
    }
    
    public int getSumOfMonth(String pID){
        int sOM = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; 	SELECT SUM(Age) FROM Cane_Yield_Level;";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    sOM = Integer.parseInt(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
        System.out.print(sOM); // for testing
        
        return sOM; 
        
    }
    
    public long getNewTotalCaneArea(String pID){
         int tCA = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; 	SELECT TotalCaneArea FROM New_Plantation_Info;";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    tCA = Integer.parseInt(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
        //System.out.print(tCA); // for testing
        
        return tCA; 
    }
    
   
    
    public long getTotalCaneArea(String pID){
        int tCA = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; 	SELECT TotalCaneArea FROM Plantation_Info;";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    tCA = Integer.parseInt(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
        //System.out.print(tCA); // for testing
        
        return tCA; 
    }
    
    public int getSumOfYield(String pID){
        int sOY = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; 	SELECT SUM(Yield) FROM Cane_Yield_Level;";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    sOY = Integer.parseInt(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
        System.out.print(sOY); // for testing
        
        return sOY; 
        
    }
    
    public int getNewCountOfColumns_TotalHCane(){
        int count = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "use SSCMgmtSysDB; SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS "
                          + " WHERE TABLE_NAME = 'New_Total_Harvest_Cane';"; 
				 
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    count = Integer.parseInt(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
       // System.out.print(count); // for testing
        
        return count; 

        
    }
    
    public int getCountOfColumns_TotalHCane(){
        int count = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "use SSCMgmtSysDB; SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS "
                          + " WHERE TABLE_NAME = 'Total_Harvest_Cane';"; 
				 
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    count = Integer.parseInt(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
       // System.out.print(count); // for testing
        
        return count; 

        
    }
    
    public int getNewCountOfColumns_EXSCHarvestP(){
        int count = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "use SSCMgmtSysDB; SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS "
                          + " WHERE TABLE_NAME = 'New_Harvest_Program_EX_SC';"; 
				 
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    count = Integer.parseInt(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
       // System.out.print(count); // for testing
        
        return count; 
    }
    
    public int getCountOfColumns_EXSCHarvestP(){
        int count = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "use SSCMgmtSysDB; SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS "
                          + " WHERE TABLE_NAME = 'Harvest_Program_EX_SC';"; 
				 
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    count = Integer.parseInt(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
       // System.out.print(count); // for testing
        
        return count; 
        
    }
    
    
    public int getCountOfRaws_CYL(String pID){
        int cOR = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; 	SELECT COUNT(ID) FROM Cane_Yield_Level;";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    cOR = Integer.parseInt(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
        System.out.print(cOR); // for testing
        
        return cOR; 
    }
    
    public long getNewAnnualCane(String pID){
        long aC = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; SELECT AnnualCane FROM New_Plantation_Info;";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    aC = Long.parseLong(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
        System.out.print(aC); // for testing
        
        return aC; 
    }
    
    public long getAnnualCane(String pID){
        long aC = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; SELECT AnnualCane FROM Plantation_Info;";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    aC = Long.parseLong(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
        System.out.print(aC); // for testing
        
        return aC; 
    }
    
    public float getNewCommercialCane(String pID){
          float cc = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; SELECT CommercialCane FROM New_Plantation_Info;";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    cc = Float.parseFloat(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
       // System.out.print(cc); // for testing
        
        
        
        
        
        return cc;
    }
    
    public float getCommercialCane(String pID){
        
         float cc = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; SELECT CommercialCane FROM Plantation_Info;";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    cc = Float.parseFloat(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
       // System.out.print(cc); // for testing
        
        
        
        
        
        return cc;
    }
    
    public float getNewSeedCane(String pID){
         float sc = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; SELECT SeedCane FROM New_Plantation_Info;";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    sc = Float.parseFloat(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
        //System.out.print(sc); // for testing
       
        return sc;
    }
    
    public float getSeedCane(String pID){
        
        float sc = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; SELECT SeedCane FROM Plantation_Info;";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    sc = Float.parseFloat(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
        //System.out.print(sc); // for testing
       
        return sc;
    }
    
    public float getNewInitialSeedCane(String pID){
        float isc = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; SELECT InitialSeedCane FROM New_Plantation_Info;";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    isc = Float.parseFloat(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
       // System.out.print(isc); // for testing
       
        return isc;
    }
    
    public float getInitialSeedCane(String pID){
        
        float isc = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; SELECT InitialSeedCane FROM Plantation_Info;";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    isc = Float.parseFloat(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
       // System.out.print(isc); // for testing
       
        return isc;
    }
    
    public float getNewOneRS(){
        float ors = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; SELECT OneRS FROM New_Plantation_Info;";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    ors = Float.parseFloat(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
        return ors;
    }
    
    public float getOneRS(){
        float ors = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; SELECT OneRS FROM Plantation_Info;";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    ors = Float.parseFloat(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
        return ors;
    }
    
    
    public int getTotalTable(){
        int TN  = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; SELECT COUNT(*) FROM information_schema.tables WHERE table_type = 'base table';";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    TN = Integer.parseInt(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
        
        
        
        return TN;
    }
    
    public int getNewTotalTable(){
        int TN  = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME LIKE 'New_%';";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    TN = Integer.parseInt(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
        
        
        
        return TN;
    }
    
    public float getNewTwoRS(){
        float trs = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; SELECT TwoRS FROM New_Plantation_Info;";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    trs = Float.parseFloat(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
        return trs;
        
    }
        
    
    public float getTwoRS(){
        
         float trs = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; SELECT TwoRS FROM Plantation_Info;";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    trs = Float.parseFloat(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
        return trs;
        
    }
    
     public ResultSet getResultSetPCF(){
        
        ResultSet rs = null;
         try {
             Connection con = DBConnection.getCon();
             con = getCon();
             Statement st = con.createStatement();
                          
                    String query ="USE SSCMgmtSysDB; SELECT * FROM Plantaion_CalculatedPlanation_Factory;";
                    rs = st.executeQuery(query);
             System.out.print(rs);
         } catch (SQLException ex) {
             Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
         return rs;
    }
     
     public long getNewReplantF(int Y){
           long TRF = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "	use SSCMgmtSysDB; SELECT SUM(Y"+Y+") FROM New_Replant_Filed_Harvest WHERE Y0 != 'CommercialCane';";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    TRF = Long.parseLong(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
       // System.out.print("\n"+isc+"\n"); // for testing
       
        return TRF;
     }
     
     public long getReplantF(int Y){
          long TRF = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "	use SSCMgmtSysDB; SELECT SUM(Y"+Y+") FROM Replant_Filed_Harvest WHERE Y0 != 'CommercialCane';";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    TRF = Long.parseLong(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
       // System.out.print("\n"+isc+"\n"); // for testing
       
        return TRF;
         
     }
     
     public long getNewTotalCCH(int Y){
         long TCC = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "	use SSCMgmtSysDB; SELECT SUM(Y"+Y+") FROM New_Harvest_Program_CC WHERE Y0 != 'CommercialCane';";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    TCC = Long.parseLong(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
       // System.out.print("\n"+isc+"\n"); // for testing
       
        return TCC;
     }
     
     public long getTotalCCH(int Y){
          long TCC = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "	use SSCMgmtSysDB; SELECT SUM(Y"+Y+") FROM Harvest_Program_CC WHERE Y0 != 'CommercialCane';";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    TCC = Long.parseLong(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
       // System.out.print("\n"+isc+"\n"); // for testing
       
        return TCC;
     }
     
     public long getNewTotalHC(int Y){
               long TEXSC = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "	use SSCMgmtSysDB; SELECT Y"+Y+" FROM New_Total_Harvest_Cane WHERE Y0 = 'Total_Harvest_CH';";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    TEXSC = Long.parseLong(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
       // System.out.print("\n"+isc+"\n"); // for testing
       
        return TEXSC;
     }
     
     public long getTotalHC(int Y){
             long TEXSC = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "	use SSCMgmtSysDB; SELECT Y"+Y+" FROM Total_Harvest_Cane WHERE Y0 = 'Total_Harvest_CH';";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    TEXSC = Long.parseLong(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
       // System.out.print("\n"+isc+"\n"); // for testing
       
        return TEXSC;
     }
     
     public long getNewTotalEXSCH(int Y){
            long TEXSC = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "	USE SSCMgmtSysDB; SELECT SUM(Y"+Y+") FROM New_Harvest_Program_EX_SC WHERE Y0 != 'CommercialCane';";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    TEXSC = Long.parseLong(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
       // System.out.print("\n"+isc+"\n"); // for testing
       
        return TEXSC;
     }
     
     public long getTotalEXSCH(int Y){
           long TEXSC = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "	use SSCMgmtSysDB; SELECT SUM(Y"+Y+") FROM Harvest_Program_EX_SC WHERE Y0 != 'CommercialCane';";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    TEXSC = Long.parseLong(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
       // System.out.print("\n"+isc+"\n"); // for testing
       
        return TEXSC;
     }
     
     public long getNewCC(){
          long cc = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; SELECT CC FROM New_Calculated_Initial_Plantaion_Info;";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    cc = Long.parseLong(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
       // System.out.print("\n"+cc+"\n"); // for testing
       
        return cc;
     }
     
     public long getCC(){
         long cc = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; SELECT CC FROM Calculated_Initial_Plantaion_Info;";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    cc = Long.parseLong(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
       // System.out.print("\n"+cc+"\n"); // for testing
       
        return cc;
     }
     
     public long getNewISC(){
          long isc = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; SELECT ISC FROM New_Calculated_Initial_Plantaion_Info;";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    isc = Long.parseLong(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
       // System.out.print("\n"+isc+"\n"); // for testing
       
        return isc;
     }
     
     public long getISC(){
     long isc = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; SELECT ISC FROM Calculated_Initial_Plantaion_Info;";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    isc = Long.parseLong(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
       // System.out.print("\n"+isc+"\n"); // for testing
       
        return isc;
    
     }
     
     public long getNewISCFConventional(int i){
         long isc = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; "
                     + "SELECT InitialSC FROM New_Conventional_Annual_Cane_Planting WHERE Years = '"+i+"';";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    isc = Long.parseLong(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
       // System.out.print("\n"+isc+"\n"); // for testing
       
        return isc;
     }
     
     public long getISCFConventional(int i){
         long isc = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; "
                     + "SELECT InitialSC FROM Conventional_Annual_Cane_Planting WHERE Years = '"+i+"';";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    isc = Long.parseLong(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
       // System.out.print("\n"+isc+"\n"); // for testing
       
        return isc;
    
     }
     
     public long getNewSC(){
          long sc = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; SELECT SC FROM New_Calculated_Initial_Plantaion_Info;";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    sc = Long.parseLong(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
       // System.out.print("\n"+cc+"\n"); // for testing
       
        return sc;
     }
     
     public long getSC(){
         long sc = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; SELECT SC FROM Calculated_Initial_Plantaion_Info;";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    sc = Long.parseLong(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
        //System.out.print("\n"+sc+"\n"); // for testing
       
        return sc;
     }
     
     public long getNewCCConventional(int i){
          long cc = 0;
          int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; "
                     + "SELECT CommercialC FROM New_Conventional_Annual_Cane_Planting WHERE Years = '"+i+"';";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    cc = Long.parseLong(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
         
         
         return cc;
     }
     
     public long getCCConventional(int i){
         long cc = 0;
          int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; "
                     + "SELECT CommercialC FROM Conventional_Annual_Cane_Planting WHERE Years = '"+i+"';";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    cc = Long.parseLong(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
         
         
         return cc;
     }
     
     public long getNewSCFConventional(int i){
            long sc = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; "
                     + "SELECT SeedC FROM New_Conventional_Annual_Cane_Planting WHERE Years = '"+i+"';";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    sc = Long.parseLong(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
       // System.out.print("\n"+isc+"\n"); // for testing
       
        return sc;
     }
     
     public long getSCFConventional(int i){
          long sc = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; "
                     + "SELECT SeedC FROM Conventional_Annual_Cane_Planting WHERE Years = '"+i+"';";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    sc = Long.parseLong(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
       // System.out.print("\n"+isc+"\n"); // for testing
       
        return sc;
     }
     
     public int getNewRatoonAge(int r){
           int AIM = 0;
        //double s = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; 	SELECT Age FROM Cane_Yield_Level WHERE ID = '"+r+"';";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                                //System.out.print("\n"+result+"\n");
                            }
                        }
                    AIM = Integer.parseInt(result);
                   //result = String.valueOf(s);
                    //ACAIY = Integer.parseInt(result);
               }catch(NumberFormatException | SQLException e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
           // AIM = (int)s;
         
        //System.out.print("\n"+ACAIY+"\n"); // for testing
       
        return AIM;
     }
     
     public int getRatoonAge(int r){
         int AIM = 0;
        //double s = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; 	SELECT Age FROM Cane_Yield_Level WHERE ID = '"+r+"';";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                                //System.out.print("\n"+result+"\n");
                            }
                        }
                    AIM = Integer.parseInt(result);
                   //result = String.valueOf(s);
                    //ACAIY = Integer.parseInt(result);
               }catch(NumberFormatException | SQLException e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
           // AIM = (int)s;
         
        //System.out.print("\n"+ACAIY+"\n"); // for testing
       
        return AIM;
     }
     
     public int getNewAvgCuttingAgeInYears(){
         int ACAIY = 0;
        double s = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; 	SELECT AvgCuttingAgeInYears FROM New_Calculated_Initial_Plantaion_Info;";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                                //System.out.print("\n"+result+"\n");
                            }
                        }
                    s = Double.parseDouble(result);
                   //result = String.valueOf(s);
                    //ACAIY = Integer.parseInt(result);
               }catch(NumberFormatException | SQLException e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
            ACAIY = (int)s;
         
        //System.out.print("\n"+ACAIY+"\n"); // for testing
       
        return ACAIY;
     }
     
     public int getAvgCuttingAgeInYears(){
        
        int ACAIY = 0;
        double s = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; 	SELECT AvgCuttingAgeInYears FROM Calculated_Initial_Plantaion_Info;";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                                //System.out.print("\n"+result+"\n");
                            }
                        }
                    s = Double.parseDouble(result);
                   //result = String.valueOf(s);
                    //ACAIY = Integer.parseInt(result);
               }catch(NumberFormatException | SQLException e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
            ACAIY = (int)s;
         
        //System.out.print("\n"+ACAIY+"\n"); // for testing
       
        return ACAIY;
     }
     
     public ResultSet getResultCACPlanting(){
        
        ResultSet rs = null;
        
       try {
             String query ="USE SSCMgmtSysDB; SELECT * FROM Conventional_Annual_Cane_Planting;";
             Connection con = DBConnection.getCon();
              con = getCon();
             Statement st = con.createStatement();
             rs = null;
             rs = st.executeQuery(query);
             System.out.print(rs);
         } catch (SQLException ex) {
             Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
         return rs;
    }
     
    public ResultSet getNewResultCACPlanting(){
           
        ResultSet rs = null;
        
       try {
             String query ="USE SSCMgmtSysDB; SELECT * FROM New_Conventional_Annual_Cane_Planting;";
             Connection con = DBConnection.getCon();
              con = getCon();
             Statement st = con.createStatement();
             rs = null;
             rs = st.executeQuery(query);
             System.out.print(rs);
         } catch (SQLException ex) {
             Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
         return rs;
    }
     
    public ResultSet getReplantSchedule(){
         ResultSet rs = null;
        
       try {
             String query ="USE SSCMgmtSysDB; SELECT * FROM Replanting_Schedule;";
             Connection con = DBConnection.getCon();
              con = getCon();
             Statement st = con.createStatement();
             rs = null;
             rs = st.executeQuery(query);
             System.out.print(rs);
         } catch (SQLException ex) {
             Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
         return rs;
    }
    
    public ResultSet getNewReplantSchedule(){
         ResultSet rs = null;
        
       try {
             String query ="USE SSCMgmtSysDB; SELECT * FROM New_Replanting_Schedule;";
             Connection con = DBConnection.getCon();
              con = getCon();
             Statement st = con.createStatement();
             rs = null;
             rs = st.executeQuery(query);
             System.out.print(rs);
         } catch (SQLException ex) {
             Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
         return rs;
    }
    
    public ResultSet getHarvestProgramEXSC(){
         ResultSet rs = null;
        
       try {
             String query ="USE SSCMgmtSysDB; SELECT * FROM Harvest_Program_EX_SC;";
             Connection con = DBConnection.getCon();
              con = getCon();
             Statement st = con.createStatement();
             rs = null;
             rs = st.executeQuery(query);
             System.out.print(rs);
         } catch (SQLException ex) {
             Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
         return rs;
    }
    
    public ResultSet getNewHarvestProgramEXSC(){
         ResultSet rs = null;
        
       try {
             String query ="USE SSCMgmtSysDB; SELECT * FROM New_Harvest_Program_EX_SC;";
             Connection con = DBConnection.getCon();
              con = getCon();
             Statement st = con.createStatement();
             rs = null;
             rs = st.executeQuery(query);
             System.out.print(rs);
         } catch (SQLException ex) {
             Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
         return rs;
    }
    
    public ResultSet HarvestProgramCC(){
        ResultSet rs = null;
        
       try {
             String query ="USE SSCMgmtSysDB; SELECT * FROM Harvest_Program_CC;";
             Connection con = DBConnection.getCon();
              con = getCon();
             Statement st = con.createStatement();
             rs = null;
             rs = st.executeQuery(query);
             System.out.print(rs);
         } catch (SQLException ex) {
             Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
         return rs;
    }
    
    public ResultSet NewHarvestProgramCC(){
          ResultSet rs = null;
        
       try {
             String query ="USE SSCMgmtSysDB; SELECT * FROM New_Harvest_Program_CC;";
             Connection con = DBConnection.getCon();
              con = getCon();
             Statement st = con.createStatement();
             rs = null;
             rs = st.executeQuery(query);
             System.out.print(rs);
         } catch (SQLException ex) {
             Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
         return rs;
    }
    
    public ResultSet totalHarvestCaneInP(){
        ResultSet rs = null;
        
       try {
             String query ="USE SSCMgmtSysDB; SELECT * FROM Total_Harvest_In_Percent;";
             Connection con = DBConnection.getCon();
              con = getCon();
             Statement st = con.createStatement();
             rs = null;
             rs = st.executeQuery(query);
             System.out.print(rs); //for testing
         } catch (SQLException ex) {
             Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
         return rs;
    }
    
    public ResultSet totalNewHarvestCaneInP(){
        ResultSet rs = null;
        
       try {
             String query ="USE SSCMgmtSysDB; SELECT * FROM New_Total_Harvest_In_Percent;";
             Connection con = DBConnection.getCon();
              con = getCon();
             Statement st = con.createStatement();
             rs = null;
             rs = st.executeQuery(query);
             System.out.print(rs); //for testing
         } catch (SQLException ex) {
             Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
         return rs;
    }
    
    public ResultSet ReplantFieldHarvest(){
        ResultSet rs = null;
        
       try {
             String query ="USE SSCMgmtSysDB; SELECT * FROM Replant_Filed_Harvest;";
             Connection con = DBConnection.getCon();
              con = getCon();
             Statement st = con.createStatement();
             rs = null;
             rs = st.executeQuery(query);
             System.out.print(rs);
         } catch (SQLException ex) {
             Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
         return rs;
    }
    
    public ResultSet NewReplantFieldHarvest(){
         ResultSet rs = null;
        
       try {
             String query ="USE SSCMgmtSysDB; SELECT * FROM New_Replant_Filed_Harvest;";
             Connection con = DBConnection.getCon();
              con = getCon();
             Statement st = con.createStatement();
             rs = null;
             rs = st.executeQuery(query);
             System.out.print(rs);
         } catch (SQLException ex) {
             Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
         return rs;
    }
    
    public ResultSet totalHarvestCane(){
         ResultSet rs = null;
        
       try {
             String query ="USE SSCMgmtSysDB; SELECT * FROM Total_Harvest_Cane ORDER BY Y3 ASC;";
             Connection con = DBConnection.getCon();
              con = getCon();
             Statement st = con.createStatement();
             rs = null;
             rs = st.executeQuery(query);
             System.out.print(rs);
         } catch (SQLException ex) {
             Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
         return rs;
    }
    
    public ResultSet NewTotalHarvestCane(){
          ResultSet rs = null;
        
       try {
             String query ="USE SSCMgmtSysDB; SELECT * FROM New_Total_Harvest_Cane ORDER BY Y3 ASC;";
             Connection con = DBConnection.getCon();
              con = getCon();
             Statement st = con.createStatement();
             rs = null;
             rs = st.executeQuery(query);
             System.out.print(rs);
         } catch (SQLException ex) {
             Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
         return rs;
    }
    
    public ResultSet getUser(){
         ResultSet rs = null;
        
       try {
             String query ="USE SSCMgmtSysDB; SELECT * FROM [User] ORDER BY UserID;";
             Connection con = DBConnection.getCon();
              con = getCon();
             Statement st = con.createStatement();
             rs = null;
             rs = st.executeQuery(query);
             System.out.print(rs);
         } catch (SQLException ex) {
             Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
         return rs;
    }
    
    public String getPID(){
         String PID = null;
        double s = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; 	SELECT PlantationID years FROM Plantation_Info;";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                                //System.out.print("\n"+result+"\n");
                            }
                        }
                    PID = result;
                   //result = String.valueOf(s);
                    //ACAIY = Integer.parseInt(result);
               }catch(NumberFormatException | SQLException e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
           // SY = (int)s;
         
        //System.out.print("\n"+ACAIY+"\n"); // for testing
       
        return PID;
    }
    
    public int getAnnualRArea(){
            int ARA = 0;
        double s = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; 	SELECT AnnualRotationArea years FROM Calculated_Initial_Plantaion_Info;";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                                //System.out.print("\n"+result+"\n");
                            }
                        }
                    ARA = Integer.parseInt(result);
                   //result = String.valueOf(s);
                    //ACAIY = Integer.parseInt(result);
               }catch(NumberFormatException | SQLException e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
           // SY = (int)s;
         
        //System.out.print("\n"+ACAIY+"\n"); // for testing
       
        return ARA;
    }
    
    public int getNewAvgCaneProduction(){
        int ACP = 0;
        //double s = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; 	SELECT AvgCaneProduction years FROM New_Calculated_Initial_Plantaion_Info;";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                                //System.out.print("\n"+result+"\n");
                            }
                        }
                    ACP = Integer.parseInt(result);
                   //result = String.valueOf(s);
                    //ACAIY = Integer.parseInt(result);
               }catch(NumberFormatException | SQLException e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
           // SY = (int)s;
         
        //System.out.print("\n"+ACAIY+"\n"); // for testing
       
        return ACP;
    }
    
    public int getAvgCaneProduction(){
           int ACP = 0;
        double s = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; 	SELECT AvgCaneProduction years FROM Calculated_Initial_Plantaion_Info;";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                                //System.out.print("\n"+result+"\n");
                            }
                        }
                    ACP = Integer.parseInt(result);
                   //result = String.valueOf(s);
                    //ACAIY = Integer.parseInt(result);
               }catch(NumberFormatException | SQLException e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
           // SY = (int)s;
         
        //System.out.print("\n"+ACAIY+"\n"); // for testing
       
        return ACP;
    }
    
    public int getNewReplantingStartYear(){
        int SY = 0;
        double s = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; 	SELECT TOP 1 years FROM New_Replanting_Schedule;";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                                //System.out.print("\n"+result+"\n");
                            }
                        }
                    SY = Integer.parseInt(result);
                   //result = String.valueOf(s);
                    //ACAIY = Integer.parseInt(result);
               }catch(NumberFormatException | SQLException e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
           // SY = (int)s;
         
        //System.out.print("\n"+ACAIY+"\n"); // for testing
       
        return SY;
    }
    
    public int getReplantingStartYear(){
          int SY = 0;
        double s = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; 	SELECT TOP 1 years FROM Replanting_Schedule;";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                                //System.out.print("\n"+result+"\n");
                            }
                        }
                    SY = Integer.parseInt(result);
                   //result = String.valueOf(s);
                    //ACAIY = Integer.parseInt(result);
               }catch(NumberFormatException | SQLException e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
           // SY = (int)s;
         
        //System.out.print("\n"+ACAIY+"\n"); // for testing
       
        return SY;
    }
    
    public int getNewLastPlantingY(){
        int LPY = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; (SELECT MAX(years) FROM New_Conventional_Annual_Cane_Planting);";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    LPY = Integer.parseInt(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
         
               
         return LPY;
    }
    
   
     
    public int getLastPlantingY(){
        int LPY = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; (SELECT MAX(years) FROM Conventional_Annual_Cane_Planting);";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    LPY = Integer.parseInt(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
         
               
         return LPY;
    }
    
    public int getNewLastRatoon(){
        int LR = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; SELECT count(ID) FROM Cane_Yield_Level ;";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    LR = Integer.parseInt(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
         
        
        return LR;
    }
    
    public int getLastRatoon(){
        int LR = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; SELECT count(ID) FROM Cane_Yield_Level ;";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    LR = Integer.parseInt(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
         
        
        
        
        
        
        return LR;
    }
    
    public long getNewReplantingScheduleCC(int Y){
         long CRS = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
        

    
   
    
            try{
                
             String query = "USE SSCMgmtSysDB; SELECT CommericalCane FROM New_RePlanting_Schedule WHERE years = '"+Y+"';";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    CRS = Long.parseLong(result);
               }catch(Exception e){
                   //JOptionPane.showMessageDialog(null,e.getMessage());
                   //String query = "USE SSCMgmtSysDB; SELECT CommercialC FROM Replanting_Schedule WHERE years = '"+Y+"';";
               }
        
        //System.out.print("\n"+sc+"\n"); // for testing
       
        return CRS;
    }
    
    public long getReplantingScheduleCC(int Y){
        long CRS = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
        

    
   
    
            try{
                
             String query = "USE SSCMgmtSysDB; SELECT CommericalCane FROM RePlanting_Schedule WHERE years = '"+Y+"';";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    CRS = Long.parseLong(result);
               }catch(Exception e){
                   //JOptionPane.showMessageDialog(null,e.getMessage());
                   //String query = "USE SSCMgmtSysDB; SELECT CommercialC FROM Replanting_Schedule WHERE years = '"+Y+"';";
               }
        
        //System.out.print("\n"+sc+"\n"); // for testing
       
        return CRS;

    }
    
    public long getNewAvgRotationArea(){
        long ARA = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; SELECT AnnualRotationArea FROM New_Calculated_Initial_Plantaion_Info;";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    ARA = Long.parseLong(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
        //System.out.print("\n"+sc+"\n"); // for testing
       
        return ARA;
    }
    
    public long getAvgRotationArea(){
        
          long ARA = 0;
        int column = 0;
        String result = null;
        ResultSet rs = null;
            try{
                
             String query = "USE SSCMgmtSysDB; SELECT AnnualRotationArea FROM Calculated_Initial_Plantaion_Info;";
             Connection con = DBConnection.getCon();

             
               Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    column = rsmd.getColumnCount();
                    while(rs.next()){
                            
                            for (int j=1; j<= column; j++){
                                result = (rs.getString(j));
                            }
                        }
                    ARA = Long.parseLong(result);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
               }
        
        //System.out.print("\n"+sc+"\n"); // for testing
       
        return ARA;
        
    }
    
    public boolean updateARA(int ARA){
          x = false;
        try {
             Connection con = DBConnection.getCon();
             String query =  " USE SSCMgmtSysDB; UPDATE Calculated_Initial_Plantaion_Info  SET AnnualRotationArea = '"+ARA+"'";
            con.prepareStatement(query); 
             x = con.createStatement().execute(query);
             
             
             
             
         } catch (SQLException ex) {
             Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         return x;
       
    }
    
    public boolean createNewTableReplanting(){
         boolean x=false;
                    try {
                                String query = "USE SSCMgmtSysDB; CREATE TABLE New_RePlanting_Schedule(Years INT PRIMARY KEY," +
                                                                                                            "	CommericalCane BIGINT NOT NULL," +
                                                                                                            "	SeedCane BIGINT NOT NULL,"+
                                                                                                            "   AnnualDevelopedArea BIGINT NOT NULL,"+
                                                                                                            "   Cumulative BIGINT NOT NULL);";

                                Connection con = DBConnection.getCon();
                                Statement st = con.createStatement();
                                st.execute(query);
                                x = true;
                        } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                    }
         return x;
    }
    
    public boolean creatTableRplanting(){
        boolean x=false;
                    try {
                                String query = "USE SSCMgmtSysDB; CREATE TABLE RePlanting_Schedule(Years INT PRIMARY KEY," +
                                                                                                            "	CommericalCane BIGINT NOT NULL," +
                                                                                                            "	SeedCane BIGINT NOT NULL,"+
                                                                                                            "   AnnualDevelopedArea BIGINT NOT NULL,"+
                                                                                                            "   Cumulative BIGINT NOT NULL);";

                                Connection con = DBConnection.getCon();
                                Statement st = con.createStatement();
                                st.execute(query);
                                x = true;
                        } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                    }
         return x;
    }
    
    public boolean createTablePlantationInfo(){
         boolean x=false;
                    try {
                                String query = "USE SSCMgmtSysDB; CREATE TABLE Plantation_Info(" +
                                                            "	PlantationID VARCHAR(10) PRIMARY KEY," +
                                                            "	TotalCaneArea BIGINT NOT NULL," +
                                                            "	AnnualCane BIGINT NOT NULL," +
                                                            "	CommercialCane FLOAT NOT NULL," +
                                                            "	SeedCane FLOAT NOT NULL," +
                                                            "	InitialSeedCane FLOAT NOT NULL," +
                                                            "	OneRS FLOAT NOT NULL," +
                                                            "	TwoRS FLOAT NOT NULL);";

                                Connection con = DBConnection.getCon();
                                Statement st = con.createStatement();
                                st.execute(query);
                                x = true;
                        } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                    }
         return x;
    }
    
    public boolean createNewTablePlantationInfo(){
         boolean x=false;
                    try {
                                String query = "USE SSCMgmtSysDB; CREATE TABLE New_Plantation_Info(" +
                                                            "	PlantationID VARCHAR(10) PRIMARY KEY," +
                                                            "	TotalCaneArea BIGINT NOT NULL," +
                                                            "	AnnualCane BIGINT NOT NULL," +
                                                            "	CommercialCane FLOAT NOT NULL," +
                                                            "	SeedCane FLOAT NOT NULL," +
                                                            "	InitialSeedCane FLOAT NOT NULL," +
                                                            "	OneRS FLOAT NOT NULL," +
                                                            "	TwoRS FLOAT NOT NULL);";

                                Connection con = DBConnection.getCon();
                                Statement st = con.createStatement();
                                st.execute(query);
                                x = true;
                        } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                    }
         return x;
    }
    
    public boolean createTableFactoryInfo(){
         boolean x=false;
                    try {
                                String query = "USE SSCMgmtSysDB; CREATE TABLE Factory_Info(" +
                                                            "	FactoryID VARCHAR(10) PRIMARY KEY," +
                                                            "	FactoryName VARCHAR(MAX)," +
                                                            "	MillingCapacity BIGINT NOT NULL," +
                                                            "	NetMillingSeason BIGINT NOT NULL);";

                                Connection con = DBConnection.getCon();
                                Statement st = con.createStatement();
                                st.execute(query);
                                x = true;
                        } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                    }
         return x;
    }
    
    public boolean createTableCalculatedPalantationInfo(){
        boolean x=false;
                    try {
                                String query = "USE SSCMgmtSysDB; CREATE TABLE Calculated_Initial_Plantaion_Info(" +
                                                                        "	PID VARCHAR(10) PRIMARY KEY," +
                                                                        "	AvgCuttingAgeInYears FLOAT NOT NULL," +
                                                                        "	AnnualRotationArea BIGINT NOT NULL," +
                                                                        "	AvgCaneProduction BIGINT NOT NULL," +
                                                                        "	AnnualHarvestArea BIGINT NOT NULL," +
                                                                        "	AvgAge INT NOT NULL," +
                                                                        "	ISC BIGINT NOT NULL," +
                                                                        "	SC BIGINT NOT NULL," +
                                                                        "	CC BIGINT NOT NULL);";

                                Connection con = DBConnection.getCon();
                                Statement st = con.createStatement();
                                st.execute(query);
                                x = true;
                        } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                    }
         return x;
    }
    
    public boolean createNewTableCalculatedPlantationInfo(){
         boolean x=false;
                    try {
                                String query = "USE SSCMgmtSysDB; CREATE TABLE New_Calculated_Initial_Plantaion_Info(" +
                                                                        "	PID VARCHAR(10) PRIMARY KEY," +
                                                                        "	AvgCuttingAgeInYears FLOAT NOT NULL," +
                                                                        "	AnnualRotationArea BIGINT NOT NULL," +
                                                                        "	AvgCaneProduction BIGINT NOT NULL," +
                                                                        "	AnnualHarvestArea BIGINT NOT NULL," +
                                                                        "	AvgAge INT NOT NULL," +
                                                                        "	ISC BIGINT NOT NULL," +
                                                                        "	SC BIGINT NOT NULL," +
                                                                        "	CC BIGINT NOT NULL);";

                                Connection con = DBConnection.getCon();
                                Statement st = con.createStatement();
                                st.execute(query);
                                x = true;
                        } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                    }
         return x;
    }
    
    public boolean createTableCaneYieldLavel(){
        boolean x=false;
                    try {
                                String query = "USE SSCMgmtSysDB; CREATE TABLE Cane_Yield_Level(" +
                                                        "	ID int IDENTITY(1,1) PRIMARY KEY," +
                                                        "	Cutting VARCHAR(5) NOT NULL," +
                                                        "	Age int NOT NULL," +
                                                        "	Yield int NOT NULL);";

                                Connection con = DBConnection.getCon();
                                Statement st = con.createStatement();
                                st.execute(query);
                                x = true;
                        } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                    }
         return x;
    }
    
    public boolean creatNewTableConventionalACP(){
        boolean x=false;
                    try {
                                String query = "USE SSCMgmtSysDB; CREATE TABLE New_Conventional_Annual_Cane_Planting(Years INT PRIMARY KEY," +
                                                                                                            "	InitialSC BIGINT NOT NULL," +
                                                                                                            "	SeedC BIGINT NOT NULL," +
                                                                                                            "	CommercialC BIGINT NOT NULL," +
                                                                                                            "	AnnualDA BIGINT NOT NULL," +
                                                                                                            "	ComulativeDA BIGINT NOT NULL);";

                                Connection con = DBConnection.getCon();
                                Statement st = con.createStatement();
                                st.execute(query);
                                x = true;
                        } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                    }
         return x;
    }
    
    public boolean creatTableConventionalACP(){
        boolean x=false;
                    try {
                                String query = "USE SSCMgmtSysDB; CREATE TABLE Conventional_Annual_Cane_Planting(Years INT PRIMARY KEY," +
                                                                                                            "	InitialSC BIGINT NOT NULL," +
                                                                                                            "	SeedC BIGINT NOT NULL," +
                                                                                                            "	CommercialC BIGINT NOT NULL," +
                                                                                                            "	AnnualDA BIGINT NOT NULL," +
                                                                                                            "	ComulativeDA BIGINT NOT NULL);";

                                Connection con = DBConnection.getCon();
                                Statement st = con.createStatement();
                                st.execute(query);
                                x = true;
                        } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                    }
         return x;
    }
    
    public boolean createNewTable(int LY){
        boolean x = false;
            int i = 1;
                if (i <= LY){
                    try {
                        String query = "USE SSCMgmtSysDB; CREATE TABLE New_Harvest_Program_EX_SC(Y0 VARCHAR(10) PRIMARY KEY);";

                        Connection con = DBConnection.getCon();
                        Statement st = con.createStatement();
                        st.execute(query);
                            while(i <= LY){
                                query = "USE SSCMgmtSysDB; ALTER TABLE New_Harvest_Program_EX_SC "
                                        + "ADD Y"+(i)+" BIGINT;";
                                st.execute(query);
                                i++;
                            }

                            x = true;

                    } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        
        
        return x;
    }
    
    public boolean createTable(int LY){
        boolean x = false;
            int i = 1;
                if (i <= LY){
                    try {
                        String query = "USE SSCMgmtSysDB; CREATE TABLE Harvest_Program_EX_SC(Y0 VARCHAR(10) PRIMARY KEY);";

                        Connection con = DBConnection.getCon();
                        Statement st = con.createStatement();
                        st.execute(query);
                            while(i <= LY){
                                query = "USE SSCMgmtSysDB; ALTER TABLE Harvest_Program_EX_SC "
                                        + "ADD Y"+(i)+" BIGINT;";
                                st.execute(query);
                                i++;
                            }

                            x = true;

                    } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        
        
        return x;
    }
    
    public boolean createNewTableH(long LY){
        boolean x = false;
            int i = 1;
                if (i <= LY+1){
                    try {
                        String query = "USE SSCMgmtSysDB; CREATE TABLE New_Harvest_Program_CC(Y0 VARCHAR(20) PRIMARY KEY);";

                        Connection con = DBConnection.getCon();
                        Statement st = con.createStatement();
                        st.execute(query);
                            while(i <= LY){
                                query = "USE SSCMgmtSysDB; ALTER TABLE New_Harvest_Program_CC "
                                        + "ADD Y"+(i)+" BIGINT;";
                                st.execute(query);
                                i++;
                            }

                            x = true;

                    } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        
        
        return x;
    }
    
    public boolean createTableH(long LY){
         boolean x = false;
            int i = 1;
                if (i <= LY+1){
                    try {
                        String query = "USE SSCMgmtSysDB; CREATE TABLE Harvest_Program_CC(Y0 VARCHAR(20) PRIMARY KEY);";

                        Connection con = DBConnection.getCon();
                        Statement st = con.createStatement();
                        st.execute(query);
                            while(i <= LY){
                                query = "USE SSCMgmtSysDB; ALTER TABLE Harvest_Program_CC "
                                        + "ADD Y"+(i)+" BIGINT;";
                                st.execute(query);
                                i++;
                            }

                            x = true;

                    } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        
        
        return x;
    }
    
    public boolean createNewTableRFH(long LY){
         boolean x = false;
            int i = 1;
                if (i <= LY){
                    try {
                        String query = "USE SSCMgmtSysDB; CREATE TABLE New_Replant_Filed_Harvest(Y0 VARCHAR(20) PRIMARY KEY);";

                        Connection con = DBConnection.getCon();
                        Statement st = con.createStatement();
                        st.execute(query);
                            while(i <= LY){
                                query = "USE SSCMgmtSysDB; ALTER TABLE New_Replant_Filed_Harvest "
                                        + "ADD Y"+(i)+" BIGINT;";
                                st.execute(query);
                                i++;
                            }

                            x = true;

                    } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        
        
        return x;
    }
    
    public boolean createTableRFH(long LY){
         boolean x = false;
            int i = 1;
                if (i <= LY){
                    try {
                        String query = "USE SSCMgmtSysDB; CREATE TABLE Replant_Filed_Harvest(Y0 VARCHAR(20) PRIMARY KEY);";

                        Connection con = DBConnection.getCon();
                        Statement st = con.createStatement();
                        st.execute(query);
                            while(i <= LY){
                                query = "USE SSCMgmtSysDB; ALTER TABLE Replant_Filed_Harvest "
                                        + "ADD Y"+(i)+" BIGINT;";
                                st.execute(query);
                                i++;
                            }

                            x = true;

                    } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        
        
        return x;
    }
    
    public boolean createNewTableHCTotalInPercent(int LY){
        boolean x = false;
            int i = 1;
                
                    try {
                        String query = "USE SSCMgmtSysDB; CREATE TABLE New_Total_Harvest_In_Percent(Y0 VARCHAR(50) PRIMARY KEY);";

                        Connection con = DBConnection.getCon();
                        Statement st = con.createStatement();
                        st.execute(query);
                            while(i <= LY){
                                query = "USE SSCMgmtSysDB; ALTER TABLE New_Total_Harvest_In_Percent "
                                        + "ADD Y"+(i)+" FLOAT;";
                                st.execute(query);
                                i++;
                            }

                            x = true;

                    }catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
        
        
        return x;
    
    }
    
    public boolean createTableHCTotalInPercent(int LY){
        boolean x = false;
            int i = 1;
                
                    try {
                        String query = "USE SSCMgmtSysDB; CREATE TABLE Total_Harvest_In_Percent(Y0 VARCHAR(50) PRIMARY KEY);";

                        Connection con = DBConnection.getCon();
                        Statement st = con.createStatement();
                        st.execute(query);
                            while(i <= LY){
                                query = "USE SSCMgmtSysDB; ALTER TABLE Total_Harvest_In_Percent "
                                        + "ADD Y"+(i)+" FLOAT;";
                                st.execute(query);
                                i++;
                            }

                            x = true;

                    }catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
        
        
        return x;
    
    }
    
    public boolean createNewTableHCTotal(long LY){
        boolean x = false;
            int i = 1;
                if (i <= LY){
                    try {
                        String query = "USE SSCMgmtSysDB; CREATE TABLE New_Total_Harvest_Cane(Y0 VARCHAR(50) PRIMARY KEY);";

                        Connection con = DBConnection.getCon();
                        Statement st = con.createStatement();
                        st.execute(query);
                            while(i <= LY){
                                query = "USE SSCMgmtSysDB; ALTER TABLE New_Total_Harvest_Cane "
                                        + "ADD Y"+(i)+" BIGINT;";
                                st.execute(query);
                                i++;
                            }

                            x = true;

                    } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        
        
        return x;
    }
    
    public boolean createTableHCTotal(long LY){
        boolean x = false;
            int i = 1;
                if (i <= LY){
                    try {
                        String query = "USE SSCMgmtSysDB; CREATE TABLE Total_Harvest_Cane(Y0 VARCHAR(50) PRIMARY KEY);";

                        Connection con = DBConnection.getCon();
                        Statement st = con.createStatement();
                        st.execute(query);
                            while(i <= LY){
                                query = "USE SSCMgmtSysDB; ALTER TABLE Total_Harvest_Cane "
                                        + "ADD Y"+(i)+" BIGINT;";
                                st.execute(query);
                                i++;
                            }

                            x = true;

                    } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        
        
        return x;
    }
    
    public boolean deletePlantationInfo(){
        boolean x = false;
                            
                    try {
                        String query="USE SSCMgmtSysDB; DROP TABLE Plantation_Info;";

                        Connection con = DBConnection.getCon();
                        Statement st = con.createStatement();
                        st.execute(query);
                            
                            x = true;

                    } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                        x = false;
                    }
                
        
        
        return x;
    }
    
    public boolean deleteNewPlantationInfo(){
        boolean x = false;
                            
                    try {
                        String query="USE SSCMgmtSysDB; DROP TABLE New_Plantation_Info;";

                        Connection con = DBConnection.getCon();
                        Statement st = con.createStatement();
                        st.execute(query);
                            
                            x = true;

                    } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                        x = false;
                    }
                
        
        
        return x;
    }
    
    public boolean deleteFactoryInfo(){
         boolean x = false;
                            
                    try {
                        String query="USE SSCMgmtSysDB; DROP TABLE Factory_Info;";

                        Connection con = DBConnection.getCon();
                        Statement st = con.createStatement();
                        st.execute(query);
                            
                            x = true;

                    } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                        x = false;
                    }
                
        
        
        return x;
    }
    
    public boolean deleteNewFactoryInfo(){
        boolean x = false;
                            
                    try {
                        String query="USE SSCMgmtSysDB; DROP TABLE New_Factory_Info;";

                        Connection con = DBConnection.getCon();
                        Statement st = con.createStatement();
                        st.execute(query);
                            
                            x = true;

                    } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                        x = false;
                    }
                
        
        
        return x;
    }
    
    public boolean deleteCalculatedInitialPInfo(){
         boolean x = false;
                            
                    try {
                        String query="USE SSCMgmtSysDB; DROP TABLE Calculated_Initial_Plantaion_Info;";

                        Connection con = DBConnection.getCon();
                        Statement st = con.createStatement();
                        st.execute(query);
                            
                            x = true;

                    } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                        x = false;
                    }
                
        
        
        return x;
    }
    
    public boolean deleteNewCalculatedInitialPInfo(){
        boolean x = false;
                            
                    try {
                        String query="USE SSCMgmtSysDB; DROP TABLE New_Calculated_Initial_Plantaion_Info;";

                        Connection con = DBConnection.getCon();
                        Statement st = con.createStatement();
                        st.execute(query);
                            
                            x = true;

                    } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                        x = false;
                    }
                
        
        
        return x;
    }
    
    public boolean deleteConventioanalACanePlanting(){
        boolean x = false;
                            
                    try {
                        String query="USE SSCMgmtSysDB; DROP TABLE Conventional_Annual_Cane_Planting;";

                        Connection con = DBConnection.getCon();
                        Statement st = con.createStatement();
                        st.execute(query);
                            
                            x = true;

                    } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                        x = false;
                    }
                
        
        
        return x;
    }
    
    public boolean deleteNewConventioanalACanePlanting(){
        boolean x = false;
                            
                    try {
                        String query="USE SSCMgmtSysDB; DROP TABLE New_Conventional_Annual_Cane_Planting;";

                        Connection con = DBConnection.getCon();
                        Statement st = con.createStatement();
                        st.execute(query);
                            
                            x = true;

                    } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                        x = false;
                    }
                
        
        
        return x;
    }
    
    public boolean deleteCaneYieldLevel(){
        boolean x = false;
                            
                    try {
                        String query="USE SSCMgmtSysDB; DROP TABLE Cane_Yield_Level;";

                        Connection con = DBConnection.getCon();
                        Statement st = con.createStatement();
                        st.execute(query);
                            
                            x = true;

                    } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                        x = false;
                    }
                
        
        
        return x;
    }
    
    public boolean deleteNewCaneYieldLevel(){
        boolean x = false;
                            
                    try {
                        String query="USE SSCMgmtSysDB; DROP TABLE New_Cane_Yield_Level;";

                        Connection con = DBConnection.getCon();
                        Statement st = con.createStatement();
                        st.execute(query);
                            
                            x = true;

                    } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                        x = false;
                    }
                
        
        
        return x;
    }
    
    public boolean deleteHarvestPEXSC(){
         boolean x = false;
                            
                    try {
                        String query="USE SSCMgmtSysDB; DROP TABLE Harvest_Program_EX_SC;";

                        Connection con = DBConnection.getCon();
                        Statement st = con.createStatement();
                        st.execute(query);
                            
                            x = true;

                    } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                        x = false;
                    }
                
        
        
        return x;
    }
    
    public boolean deleteNewHarvestPEXSC(){
         boolean x = false;
                            
                    try {
                        String query="USE SSCMgmtSysDB; DROP TABLE New_Harvest_Program_EX_SC;";

                        Connection con = DBConnection.getCon();
                        Statement st = con.createStatement();
                        st.execute(query);
                            
                            x = true;

                    } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                        x = false;
                    }
                
        
        
        return x;
    }
    
    public boolean deleteHarvestPCC(){
                 boolean x = false;
                            
                    try {
                        String query="USE SSCMgmtSysDB; DROP TABLE Harvest_Program_CC;";

                        Connection con = DBConnection.getCon();
                        Statement st = con.createStatement();
                        st.execute(query);
                            
                            x = true;

                    } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                        x = false;
                    }
                
        
        
        return x;
    }
    
    public boolean deleteNewHarvestPCC(){
               boolean x = false;
                            
                    try {
                        String query="USE SSCMgmtSysDB; DROP TABLE New_Harvest_Program_CC;";

                        Connection con = DBConnection.getCon();
                        Statement st = con.createStatement();
                        st.execute(query);
                            
                            x = true;

                    } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                        x = false;
                    }
                
        
        
        return x;
    }
    
    public boolean deleteRePlantFieldHarvest(){
        boolean x = false;
                            
                    try {
                        String query="USE SSCMgmtSysDB; DROP TABLE Replant_Filed_Harvest;";

                        Connection con = DBConnection.getCon();
                        Statement st = con.createStatement();
                        st.execute(query);
                            
                            x = true;

                    } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                        x = false;
                    }
                
        
        
        return x;
    }
    
    public boolean deleteNewRePlantFieldHarvest(){
        boolean x = false;
                            
                    try {
                        String query="USE SSCMgmtSysDB; DROP TABLE New_Replant_Filed_Harvest;";

                        Connection con = DBConnection.getCon();
                        Statement st = con.createStatement();
                        st.execute(query);
                            
                            x = true;

                    } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                        x = false;
                    }
                
        
        
        return x;
    }
    
    public boolean deleteRePlantingSchedule(){
        boolean x = false;
                            
                    try {
                        String query="USE SSCMgmtSysDB; DROP TABLE RePlanting_Schedule;";

                        Connection con = DBConnection.getCon();
                        Statement st = con.createStatement();
                        st.execute(query);
                            
                            x = true;

                    } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                        x = false;
                    }
                
        
        
        return x;
    }
    
    public boolean deleteNewRePlantingSchedule(){
         boolean x = false;
                            
                    try {
                        String query="USE SSCMgmtSysDB; DROP TABLE New_RePlanting_Schedule;";

                        Connection con = DBConnection.getCon();
                        Statement st = con.createStatement();
                        st.execute(query);
                            
                            x = true;

                    } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                        x = false;
                    }
                
        
        
        return x;
    }
    
    public boolean deleteTotalHarvestCane(){
        boolean x = false;
                            
                    try {
                        String query="USE SSCMgmtSysDB; DROP TABLE Total_Harvest_Cane;";

                        Connection con = DBConnection.getCon();
                        Statement st = con.createStatement();
                        st.execute(query);
                            
                            x = true;

                    } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                        x = false;
                    }
                
        
        
        return x;
    }
    
    public boolean deleteNewTotalHarvestCane(){
         boolean x = false;
                            
                    try {
                        String query="USE SSCMgmtSysDB; DROP TABLE New_Total_Harvest_Cane;";

                        Connection con = DBConnection.getCon();
                        Statement st = con.createStatement();
                        st.execute(query);
                            
                            x = true;

                    } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                        x = false;
                    }
                
        
        
        return x;
    }
    
    public boolean deleteTotalHarvestInPercent(){
         boolean x = false;
                            
                    try {
                        String query="USE SSCMgmtSysDB; DROP TABLE Total_Harvest_In_Percent;";

                        Connection con = DBConnection.getCon();
                        Statement st = con.createStatement();
                        st.execute(query);
                            
                            x = true;

                    } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                        x = false;
                    }
                
        
        
        return x;
    }
    
    public boolean deleteNewTotalHarvestInPercent(){
        boolean x = false;
                            
                    try {
                        String query="USE SSCMgmtSysDB; DROP TABLE New_Total_Harvest_In_Percent;";

                        Connection con = DBConnection.getCon();
                        Statement st = con.createStatement();
                        st.execute(query);
                            
                            x = true;

                    } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                        x = false;
                    }
                
        
        
        return x;
    }
    
    public boolean deleteUser(String userN){
         boolean x = false;
                            
                    try {
                        String query="USE SSCMgmtSysDB; DELETE FROM [User] WHERE UserName = '"+userN+"';";

                        Connection con = DBConnection.getCon();
                        Statement st = con.createStatement();
                        st.execute(query);
                            
                            x = true;

                    } catch (SQLException ex) {
                        Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
                        x = false;
                    }
                
        
        
        return x;
    }
}

