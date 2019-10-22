/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;
import DataLayer.DBConnection;
import DataLayer.DataUtility;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
/**
 *
 * @author user
 */
public class ApplicationData {
    
    public static Vector columns_name = new Vector();
    public static Vector data_raws = new Vector();
    public static int column= 0;
    
    private boolean x = false;
    DBConnection conn = new DBConnection();
    DataUtility du = new DataUtility();
    
    public boolean savePlantationData(String plantationID, String totalCaneArea,  String oRS, String tRS, String commercialCane,
                                      String seedCane, String initialSeedCane) throws ParseException, SQLException{
        
                long mC = du.getMillingCapacity(plantationID);          System.out.print(mC+"/t"); //for testing
                long nMS = du.getNMSeason(plantationID);                 System.out.print(nMS+"/t"); //for testing
                long aC = (mC*nMS);
                float sC = Float.parseFloat(seedCane);
                //sC = (float) Math.floor(sC);
                float iSC = Float.parseFloat(initialSeedCane);
                float comC = Float.parseFloat(commercialCane);
                float cC = (comC+sC+iSC);
                float fors = Float.parseFloat(oRS);
                float ftrs = Float.parseFloat(tRS);
                long tCA = Long.parseLong(totalCaneArea);
                
                du.savePlantationD(plantationID, tCA, aC, cC, sC, iSC, fors, ftrs);
                        x = true;
                       
                return x;
    }
    
     public boolean saveNewPlantationData(String plantationID, String totalCaneArea,  String oRS, String tRS, String commercialCane,
                                      String seedCane, String initialSeedCane) throws ParseException, SQLException{
        
                long mC = du.getMillingCapacity(plantationID);          System.out.print(mC+"/t"); //for testing
                long nMS = du.getNMSeason(plantationID);                 System.out.print(nMS+"/t"); //for testing
                long aC = (mC*nMS);
                float sC = Float.parseFloat(seedCane);
                //sC = (float) Math.floor(sC);
                float iSC = Float.parseFloat(initialSeedCane);
                float comC = Float.parseFloat(commercialCane);
                float cC = (comC+sC+iSC);
                float fors = Float.parseFloat(oRS);
                float ftrs = Float.parseFloat(tRS);
                long tCA = Long.parseLong(totalCaneArea);
                
                du.saveNewPlantationD(plantationID, tCA, aC, cC, sC, iSC, fors, ftrs);
                        x = true;
                       
                return x;
    }
     
    public boolean updateNewPlantationData(String plantationID, String totalCaneArea,  String oRS, String tRS, String commercialCane,
                                      String seedCane, String initialSeedCane) throws ParseException, SQLException{
        
                long mC = du.getMillingCapacity(plantationID);          System.out.print(mC+"/t"); //for testing
                long nMS = du.getNMSeason(plantationID);                 System.out.print(nMS+"/t"); //for testing
                long aC = (mC*nMS);
                float sC = Float.parseFloat(seedCane);
                //sC = (float) Math.floor(sC);
                float iSC = Float.parseFloat(initialSeedCane);
                float comC = Float.parseFloat(commercialCane);
                float cC = (comC+sC+iSC);
                float fors = Float.parseFloat(oRS);
                float ftrs = Float.parseFloat(tRS);
                long tCA = Long.parseLong(totalCaneArea);
                
                du.updateNewPlantationD(plantationID, tCA, aC, cC, sC, iSC, fors, ftrs);
                        x = true;
                       
                return x;
    }
    
    public boolean saveCuttingSchedule(String cutting, String cMonth, String yield){
        
                int month = Integer.parseInt(cMonth);
                int y = Integer.parseInt(yield);
               

                        try {
                            x = du.saveCaneSchedule( cutting, month, y);
                        } catch (SQLException ex) {
                            Logger.getLogger(ApplicationData.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        return x;
         }   

    
    public boolean saveFactoryData(String factoryID, String factoryName, String mC, String NetMSeason){
        
        Long millingC = Long.parseLong(mC);
        Long nMS = Long.parseLong(NetMSeason);
        this.x = du.saveFactoryD(factoryID, factoryName, millingC, nMS);
                return this.x;
    }
    
    public boolean saveCCP(String factoryID, String y, String iSC, String sC){
        
                    //int year = Integer.parseInt(y);
                    y = y + factoryID;
                    int initialSC = Integer.parseInt(iSC);
                    Long SeedC = Long.parseLong(sC);

                    Long aCPRate = SeedC * 10;
                    Long sCP = SeedC + initialSC;
                    Long aDA = (SeedC + initialSC + aCPRate);
                    Long cumDA = Long.parseLong("0");

                    cumDA = cumDA + aDA;

                    conn.saveCCPlatationD(y, initialSC, SeedC, aCPRate, sCP, aDA, cumDA);

        return true;
        
    }
    
    
    public ResultSet getTableResultPCF(){
        
                ResultSet rs = null;
                try {
                    rs = null;
                    rs = du.getResultSetPCF();
                    ResultSetMetaData rsmetadata = rs.getMetaData();
                    column = rsmetadata.getColumnCount();



                } catch (SQLException ex) {
                    Logger.getLogger(ApplicationData.class.getName()).log(Level.SEVERE, null, ex);
                }
        return rs;
    }
    
    public ResultSet getTableResultCACPlanting(){
        ResultSet rs = null;
                try{
                    rs = du.getResultCACPlanting();
                    ResultSetMetaData rsmetadata = rs.getMetaData();
                    column = rsmetadata.getColumnCount();



                } catch (SQLException ex) {
                    Logger.getLogger(ApplicationData.class.getName()).log(Level.SEVERE, null, ex);
                }
        return rs;
    }
    
    public ResultSet getNewTableResultCACPlanting(){
         ResultSet rs = null;
                try{
                    rs = du.getNewResultCACPlanting();
                    ResultSetMetaData rsmetadata = rs.getMetaData();
                    column = rsmetadata.getColumnCount();



                } catch (SQLException ex) {
                    Logger.getLogger(ApplicationData.class.getName()).log(Level.SEVERE, null, ex);
                }
        return rs;
    }
    
    public ResultSet getReplantSchedule(){
        ResultSet rs = null;
                try{
                    rs = du.getReplantSchedule();
                    ResultSetMetaData rsmetadata = rs.getMetaData();
                    column = rsmetadata.getColumnCount();



                } catch (SQLException ex) {
                    Logger.getLogger(ApplicationData.class.getName()).log(Level.SEVERE, null, ex);
                }
        return rs;
    }
    
    public ResultSet getNewReplantSchedule(){
        ResultSet rs = null;
                try{
                    rs = du.getNewReplantSchedule();
                    ResultSetMetaData rsmetadata = rs.getMetaData();
                    column = rsmetadata.getColumnCount();



                } catch (SQLException ex) {
                    Logger.getLogger(ApplicationData.class.getName()).log(Level.SEVERE, null, ex);
                }
        return rs;
    }
    
    public ResultSet getHarvestProgramEXSC(){
         ResultSet rs = null;
                try{
                    rs = du.getHarvestProgramEXSC();
                    ResultSetMetaData rsmetadata = rs.getMetaData();
                    column = rsmetadata.getColumnCount();



                } catch (SQLException ex) {
                    Logger.getLogger(ApplicationData.class.getName()).log(Level.SEVERE, null, ex);
                }
        return rs;
    }
    
    
    public ResultSet getNewHarvestProgramEXSC(){
         ResultSet rs = null;
                try{
                    rs = du.getNewHarvestProgramEXSC();
                    ResultSetMetaData rsmetadata = rs.getMetaData();
                    column = rsmetadata.getColumnCount();



                } catch (SQLException ex) {
                    Logger.getLogger(ApplicationData.class.getName()).log(Level.SEVERE, null, ex);
                }
        return rs;
    }
    
    public ResultSet getHarvestProgramCC(){
        ResultSet rs = null;
                try{
                    rs = du.HarvestProgramCC();
                    ResultSetMetaData rsmetadata = rs.getMetaData();
                    column = rsmetadata.getColumnCount();



                } catch (SQLException ex) {
                    Logger.getLogger(ApplicationData.class.getName()).log(Level.SEVERE, null, ex);
                }
        return rs;
    }
    
    public ResultSet getNewHarvestProgramCC(){
        ResultSet rs = null;
                try{
                    rs = du.NewHarvestProgramCC();
                    ResultSetMetaData rsmetadata = rs.getMetaData();
                    column = rsmetadata.getColumnCount();



                } catch (SQLException ex) {
                    Logger.getLogger(ApplicationData.class.getName()).log(Level.SEVERE, null, ex);
                }
        return rs;
    }
    
    public ResultSet getReplantFieldHarvest(){
         ResultSet rs = null;
                try{
                    rs = du.ReplantFieldHarvest();
                    ResultSetMetaData rsmetadata = rs.getMetaData();
                    column = rsmetadata.getColumnCount();



                } catch (SQLException ex) {
                    Logger.getLogger(ApplicationData.class.getName()).log(Level.SEVERE, null, ex);
                }
        return rs;
    }
    
    public ResultSet getNewReplantFieldHarvest(){
         ResultSet rs = null;
                try{
                    rs = du.NewReplantFieldHarvest();
                    ResultSetMetaData rsmetadata = rs.getMetaData();
                    column = rsmetadata.getColumnCount();



                } catch (SQLException ex) {
                    Logger.getLogger(ApplicationData.class.getName()).log(Level.SEVERE, null, ex);
                }
        return rs;
    }
    
    public ResultSet getTotalHCaneInP(){
        ResultSet rs = null;
                try{
                    rs = du.totalHarvestCaneInP();
                    ResultSetMetaData rsmetadata = rs.getMetaData();
                    column = rsmetadata.getColumnCount();



                } catch (SQLException ex) {
                    Logger.getLogger(ApplicationData.class.getName()).log(Level.SEVERE, null, ex);
                }
        return rs;
    }
    
    public ResultSet getNewTotalHCaneInP(){
         ResultSet rs = null;
                try{
                    rs = du.totalNewHarvestCaneInP();
                    ResultSetMetaData rsmetadata = rs.getMetaData();
                    column = rsmetadata.getColumnCount();



                } catch (SQLException ex) {
                    Logger.getLogger(ApplicationData.class.getName()).log(Level.SEVERE, null, ex);
                }
        return rs;
    }
    
    public ResultSet getTotalHCane(){
        ResultSet rs = null;
                try{
                    rs = du.totalHarvestCane();
                    ResultSetMetaData rsmetadata = rs.getMetaData();
                    column = rsmetadata.getColumnCount();



                } catch (SQLException ex) {
                    Logger.getLogger(ApplicationData.class.getName()).log(Level.SEVERE, null, ex);
                }
        return rs;
    }
    
    public ResultSet getNewTotalHCane(){
        ResultSet rs = null;
        try{
            rs = du.NewTotalHarvestCane();
            ResultSetMetaData rsmetadata = rs.getMetaData();
            column = rsmetadata.getColumnCount();
        } catch (SQLException ex){
            Logger.getLogger(ApplicationData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    
    public  ResultSet getFactory(){//review all for comboBox
        
        //String[] factoryString = null;
        ResultSet rs = null;
                try {
                    rs = conn.getResultSetF();
                    ResultSetMetaData rsmetadata = rs.getMetaData();
                    int column = rsmetadata.getColumnCount();
                   // String[] factoryString = null;

                    for(int i=1; i<=column; i++){
                               data_raws.add(rsmetadata.getColumnName(i));
                           }
                //dtm.setColumnIdentifiers(columns_name);

                } catch (SQLException ex) {
                    Logger.getLogger(ApplicationData.class.getName()).log(Level.SEVERE, null, ex);
                }

        return rs;
    } 
    
    public String getTHArea(String sItem){
        
         String tHA = null;
        ResultSet rs = null;
                    try {
                        rs = conn.getTotalHA(sItem);
                        ResultSetMetaData rsmd = rs.getMetaData();
                        int column = rsmd.getColumnCount();
                       // String[] factoryString = null;


                        while(rs.next()){
                            //data_raws = new Vector();
                            for (int j=1; j<= column; j++){
                                tHA = (rs.getString(j));
                            }
                        }
                    //dtm.setColumnIdentifiers(columns_name);

                    } catch (SQLException ex) {
                        Logger.getLogger(ApplicationData.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    return tHA;
                }

    public String getcCArea(String sItem){
                    String cCA = null;
                    ResultSet rs = null;
                    try {
                        rs = conn.getCommercialHA(sItem);
                        ResultSetMetaData rsmd = rs.getMetaData();
                        int column = rsmd.getColumnCount();
                       // String[] factoryString = null;


                        while(rs.next()){
                            //data_raws = new Vector();
                            for (int j=1; j<= column; j++){
                                cCA = (rs.getString(j));
                            }
                        }
                    //dtm.setColumnIdentifiers(columns_name);

                    } catch (SQLException ex) {
                        Logger.getLogger(ApplicationData.class.getName()).log(Level.SEVERE, null, ex);
                    }

        return  cCA;
    }
    
    public int getTotalTableN(){
        int x = 0;
        
        
        x = du.getTotalTable();
       
        return x;
    }
    
    public int getNewTotalTableN(){
        int x = 0;
        
        
        x = du.getNewTotalTable();
       
        return x;
    }
    
    public boolean calculateNSavePlantationInfo(String pID){
        int m = du.getSumOfMonth(pID);        System.out.print(m+"/t"); //for testing
        double avgCuttingAge_Years = ((double)m/12);
        
        long aC = du.getTotalCaneArea(pID);    System.out.print(aC+"/t"); //for testing
        long annualRotationArea = (long)((double)aC/avgCuttingAge_Years);
        
        long sYield = du.getSumOfYield(pID);    System.out.print(sYield+"/t"); //for testing
        int c = du.getCountOfRaws_CYL(pID);     System.out.print(c+"/t"); //for testing
        long avgCaneProduction = (sYield/c);
        
        long annualHarvestArea = (du.getAnnualCane(pID) / avgCaneProduction);     System.out.print(du.getAnnualCane(pID)+"/t"); //for testing
        long avgAge = (m/c);
        
        float cRatio = du.getCommercialCane(pID);
        long cC = (long) Math.ceil(annualRotationArea / cRatio);
        
        float sRatio = du.getSeedCane(pID);
        long sC = (long) Math.ceil(cC*sRatio);
        
        float iRatio = du.getInitialSeedCane(pID);
        long iSC = (long) Math.ceil(annualRotationArea * iRatio);
        x = du.saveCPI(pID,avgCuttingAge_Years, annualRotationArea, avgCaneProduction, annualHarvestArea, avgAge, iSC, sC, cC);
        
        du.saveNewCPI(pID,avgCuttingAge_Years, annualRotationArea, avgCaneProduction, annualHarvestArea, avgAge, iSC, sC, cC);
        
        
        
        return x;
    }
    
    public boolean calculateNewSavePlantationInfo(int ARA){
        String pID = du.getPID();
        int m = du.getSumOfMonth(pID);        System.out.print(m+"/t"); //for testing
        double avgCuttingAge_Years = ((double)m/12);
        
        long aC = du.getNewTotalCaneArea(pID);    System.out.print(aC+"/t"); //for testing
        long annualRotationArea = ARA;//(long)((double)aC/avgCuttingAge_Years);
        
        long sYield = du.getSumOfYield(pID);    System.out.print(sYield+"/t"); //for testing
        int c = du.getCountOfRaws_CYL(pID);     System.out.print(c+"/t"); //for testing
        long avgCaneProduction = (sYield/c);
        
        long annualHarvestArea = (du.getNewAnnualCane(pID) / avgCaneProduction);     System.out.print(du.getAnnualCane(pID)+"/t"); //for testing
        long avgAge = (m/c);
        
        float cRatio = du.getNewCommercialCane(pID);
        long cC = (long) Math.ceil(annualRotationArea / cRatio);
        
        float sRatio = du.getNewSeedCane(pID);
        long sC = (long) Math.ceil(cC*sRatio);
        
        float iRatio = du.getNewInitialSeedCane(pID);
        long iSC = (long) Math.ceil(annualRotationArea * iRatio);
        x = //du.saveNewCPI(pID,avgCuttingAge_Years, annualRotationArea, avgCaneProduction, annualHarvestArea, avgAge, iSC, sC, cC);
        du.updateNewCPI(pID,avgCuttingAge_Years, annualRotationArea, avgCaneProduction, annualHarvestArea, avgAge, iSC, sC, cC);
        
        
        return x;
    }
    
    public boolean deleteTables(){
        boolean x = false;
        
        du.deletePlantationInfo();
        du.deleteFactoryInfo();
        du.deleteCalculatedInitialPInfo();
        du.deleteConventioanalACanePlanting();
        du.deleteCaneYieldLevel();
        du.deleteHarvestPEXSC();
        du.deleteHarvestPCC();
        du.deleteRePlantFieldHarvest();
        du.deleteRePlantingSchedule();
        du.deleteTotalHarvestCane();
        du.deleteTotalHarvestInPercent();
        
        x = true;
        
        return x;
    }
    
    public boolean deleteNewTables(){
         boolean x = false;
        
       // du.deletePlantationInfo();
       // du.deleteNewPlantationInfo();
        //du.deleteFactoryInfo();
        //du.deleteNewFactoryInfo();
        //du.deleteCalculatedInitialPInfo();
        //du.deleteNewCalculatedInitialPInfo();
        //du.deleteConventioanalACanePlanting();
        du.deleteNewConventioanalACanePlanting();
        //du.deleteCaneYieldLevel();  
        //du.deleteNewCaneYieldLevel();
        //du.deleteHarvestPEXSC();    
        du.deleteNewHarvestPEXSC();
        //du.deleteHarvestPCC();      
        du.deleteNewHarvestPCC();
        //du.deleteRePlantFieldHarvest();  
        du.deleteNewRePlantFieldHarvest();
        //du.deleteRePlantingSchedule();    
        du.deleteNewRePlantingSchedule();
        //du.deleteTotalHarvestCane();      
        du.deleteNewTotalHarvestCane();
        //du.deleteTotalHarvestInPercent();      
        du.deleteNewTotalHarvestInPercent();
        
        x = true;
        
        return x;
    }
    
    public boolean deleteCycleTables(){
        
        boolean x = false;
        du.deleteConventioanalACanePlanting();
        du.deleteHarvestPEXSC();
        du.deleteHarvestPCC();
        du.deleteRePlantFieldHarvest();
        du.deleteRePlantingSchedule();
        du.deleteTotalHarvestCane();
        du.deleteTotalHarvestInPercent();
        x = true;
        return x;
    }
    
    public boolean deleteInitialTables(){
          boolean x = false;
        
        du.deletePlantationInfo();
        du.deleteFactoryInfo();
        du.deleteCalculatedInitialPInfo();
        //du.deleteConventioanalACanePlanting();
        du.deleteCaneYieldLevel();
        /*du.deleteHarvestPEXSC();
        du.deleteHarvestPCC();
        du.deleteRePlantFieldHarvest();
        du.deleteRePlantingSchedule();
        du.deleteTotalHarvestCane();
        du.deleteTotalHarvestInPercent();*/
        
        x = true;
        
        return x;
    }
    
    public boolean deleteNewInitialTables(){
        boolean x = false;
        
        du.deleteNewPlantationInfo();
        du.deleteNewCalculatedInitialPInfo();
        
        
        
        
        x = true;
        
        return x;
    }
    
    public boolean createInitialTables(){
        boolean x = false;
        
        du.createTablePlantationInfo();                     
        du.createTableFactoryInfo();
        du.createTableCalculatedPalantationInfo();       
        du.createTableCaneYieldLavel();
                //du.createNewTablePlantationInfo();
               // du.createNewTableCalculatedPlantationInfo();
        
        
        return x;
    }
    
    public boolean createNewInitialTables(){
         boolean x = false;
        
        //du.createTablePlantationInfo();  
        du.createNewTablePlantationInfo();
        //du.createTableFactoryInfo();     
        //du.createTableCalculatedPalantationInfo(); 
        du.createNewTableCalculatedPlantationInfo();
        //du.createTableCaneYieldLavel();   
                
        
        
        
        return x;
    }
}
    
