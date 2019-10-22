/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;
import DataLayer.DataUtility;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author user
 */
public class FuzzyLogic {
    ApplicationData appData = new ApplicationData();
    DataUtility du = new DataUtility();
    
    
    public String fuzzyLogicSystem(String value, String valueTwo){ // value can only be 0 or 50   and   valuetwo Can only be 0 or 300 or 600;
        boolean bool = false;
        float fValue = 0;
        int ADA = 0;
        String message = null;
        
        
       fValue = this.fuzzify(value, valueTwo);
        ADA = this.fuzzyRule(fValue);
        message = this.deFuzzify(ADA);
        
        
       return message; 
    }
    public float fuzzify(String x, String y){
        boolean bool = false;
        float v1 = 0;
        //float v2 = 0;
        if ("Low".equals(x) && "FastTrackOne".equals(y)){
            v1 = 0.05f; 
        }else if ("High".equals(x) && "FastTrackOne".equals(y)){
            v1 = 0.13f;
            System.out.print("\n"+v1+"\n");
        }else if ("Low".equals(x) && "FastTrackTwo".equals(y)){
            v1 = 0.15f;
        }else if ("High".equals(x) && "FastTrackTwo".equals(y)){
            v1 = 0.23f;
        }else if ("Low".equals(x) && "FastTrackThree".equals(y)){
            v1 = 0.25f;
        }else if ("High".equals(x) && "FastTrackThree".equals(y)){
            v1 = 0.3f; 
            System.out.print("\n"+v1+"\n");
        }
        
        
        bool = true;
        return v1;
    }
    public int fuzzyRule(float v){
        int ARA = du.getAnnualRArea();
            int newARA = (ARA+(int)(ARA * v));
            int NT = 0;
            //NT = appData.getTotalTableN();
            NT = appData.getNewTotalTableN();
            System.out.print("\n"+v+"\t"+ARA+"\t"+newARA+"\n");
            
            if(NT >= 9){
                //appData.deleteTables(); //just for
                 appData.deleteNewTables();
                //appData.createInitialTables();//just for
                //appData.createNewInitialTables();
                
            }else if(NT <= 9){
                //appData.deleteInitialTables();
                // appData.createNewInitialTables();
            }else{
                // appData.createNewInitialTables();
            }
            String pid = du.getPID();
            Long tca = du.getTotalCaneArea(pid);
            float ors =  du.getOneRS();
            float trs = du.getTwoRS();
            float cc = du.getCommercialCane(pid);
            float sc = du.getSeedCane(pid);
            float isc = du.getInitialSeedCane(pid);
            
                    try {
                        //appData.saveNewPlantationData(pid, tca.toString(), Float.toString(ors),Float.toString(trs),Float.toString(cc), Float.toString(sc), Float.toString(isc));
                        appData.updateNewPlantationData(pid, tca.toString(), Float.toString(ors),Float.toString(trs),
                                Float.toString(cc), Float.toString(sc), Float.toString(isc));
                        appData.calculateNewSavePlantationInfo(newARA);
                    } catch (ParseException ex) {
                        Logger.getLogger(FuzzyLogic.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(FuzzyLogic.class.getName()).log(Level.SEVERE, null, ex);
                    }
            //du.updateARA(ARA);
            {
        CycleLogic cl = new CycleLogic();
        cl.generateNewIstablishmentSchedule();
        cl.generateNewReplantingSchedule();
        cl.generateNewHarvestProgramEXSC();
        cl.generateNewHarvestProgramCC();
        cl.generateNewReplantFieldHarvest();
        cl.generateNewHarvestCane();
        cl.calculateNewTotalHarvestCaneInPercent();
    }
        return newARA;
    }
    public String deFuzzify(int ADA){
        String message = null;
        
        message = "The supply cycle is generated using "+ADA+" annual developed area.";
        
        
        
        
        return message;
    }
}
