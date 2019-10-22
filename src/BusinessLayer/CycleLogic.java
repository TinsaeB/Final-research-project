/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;
import DataLayer.DataUtility;

/**
 *
 * @author user
 */
public class CycleLogic {
        
    ApplicationData appData = new ApplicationData();
    
    boolean bool = false;
    DataUtility du = new DataUtility();
    String pID = du.getPID();
    
    
    public boolean conventionalMethod(){
        bool = false;
        int NT = 0;
        NT = appData.getTotalTableN();  
        
        if (NT > 5){
            
            System.out.print("\tc >5 "+NT);
                appData.deleteCycleTables();
                this.generateIstablishmentSchedule();
                this.generateReplantingSchedule();
                this.generateHarvestProgramEXSC();
                this.generateHarvestProgramCC();
                this.generateReplantFieldHarvest();
                this.generateHarvestCane();
                this.calculateTotalHarvestCaneInPercent();
                    bool = true;
        }else{
             System.out.print("\n\tc <=5 "+NT);
                this.generateIstablishmentSchedule();
                this.generateReplantingSchedule();
                this.generateHarvestProgramEXSC();
                this.generateHarvestProgramCC();
                this.generateReplantFieldHarvest();
                this.generateHarvestCane();
                this.calculateTotalHarvestCaneInPercent();
                    bool = true;
        }
        return bool;
    }
    
    public boolean fastTrack(int value){
        bool = false;
        int ARA = 0;
        int newARA = 0;
        int NT = 0;
        NT = appData.getTotalTableN();   
           System.out.print(NT);
             /*   if (NT >= 5){
                    appData.deleteCycleTables();
                
                   ARA = du.getAnnualRArea();
                   newARA = (int) ((ARA * (float)(value/100))+ ARA);
                  
                   System.out.print("\n"+newARA+"\n");
                       // du.updateARA(newARA);
                        du.deleteCalculatedInitialPInfo();
                        du.createTableCalculatedPalantationInfo();
                        appData.calculateNSavePlantationInfo(ARA);
                        
                        this.generateIstablishmentSchedule();
                        this.generateReplantingSchedule();
                        this.generateHarvestProgramEXSC();
                        this.generateHarvestProgramCC();
                        this.generateReplantFieldHarvest();
                        this.generateHarvestCane();
                        this.calculateTotalHarvestCaneInPercent();
                            bool = true;
                   
                }else{
                         ARA = du.getAnnualRArea();
                   newARA = (int)(ARA * (float)(value/100))+ ARA;
                  System.out.print("\n"+newARA+"\n");
                        //du.updateARA(newARA);
                        du.deleteCalculatedInitialPInfo();
                        du.createTableCalculatedPalantationInfo();
                        appData.calculateNSavePlantationInfo(ARA);
                        
                        this.generateIstablishmentSchedule();
                        this.generateReplantingSchedule();
                        this.generateHarvestProgramEXSC();
                        this.generateHarvestProgramCC();
                        this.generateReplantFieldHarvest();
                        this.generateHarvestCane();
                        this.calculateTotalHarvestCaneInPercent();
                            bool = true;
                }*/
        return bool;
    }
    
    public boolean generateIstablishmentSchedule(){
        long acc = 0;
        long cc = du.getCC();
        long sc = du.getSC();
        long isc = du.getISC();
        long annualDevelopedArea = 0;
        long cumulative = 0;
        long TCA = du.getTotalCaneArea(pID);
        //int y = du.getAvgCuttingAgeInYears();
        int years[] =  new int[50];
        years[0]= 0;
        long cC[] = new long[50];
        cC[0] = 0;
        long sC[] = new long[50];
        sC[0] = 0;
        long iSC[] = new long[50];
        iSC[0] = 0;
        int i = 1;
        long x=cc+1;
                
                du.creatTableConventionalACP();
        
        
        while((cumulative < TCA)&&(x>cc)){
            
            
            years[i] = i;
            //System.out.print(years[i]+"\t");
            
            
                    if (iSC[i-1] == 0 && sC[i-1] == 0 && cC[i-1]== 0){
                        iSC[i]= isc;
                        annualDevelopedArea = iSC[i] + sC[i] + cC[i];
                        //System.out.print(iSC[i]+"\t"+sC[i]+"\t"+cC[i]+"\t"+annualDevelopedArea+"\n");
                    }else if (iSC[i-1] != 0 && sC[i-1] == 0){
                        iSC[i]= isc;
                        sC[i] = sc;
                        annualDevelopedArea = iSC[i] + sC[i] + cC[i];
                        //System.out.print(annualDevelopedArea+"\n");
                        //System.out.print(iSC[i]+"\t"+sC[i]+"\t"+cC[i]+"\t"+annualDevelopedArea+"\n");
                    }else if (iSC[i-1] != 0 && sC[i-1] != 0){ //&& (x > cc)){
                        iSC[i]= isc;
                        sC[i] = sc;
                        cC[i] = cc;
                        annualDevelopedArea = iSC[i] + sC[i] + cC[i];
                       //System.out.print(iSC[i]+"\t"+sC[i]+"\t"+cC[i]+"\n");
                    }
            
            cumulative = cumulative + annualDevelopedArea;
            x = TCA - cumulative; //System.out.print(x+"\n");
            
                    
                    
            System.out.print(years[i]+"\t"+iSC[i]+ "  \t"+sC[i]+"  \t"+cC[i]+"    \t"+annualDevelopedArea+"\t"+cumulative+"\n"); //for testing
           du.saveConventionalACPlanting(years[i],iSC[i],sC[i],cC[i],annualDevelopedArea,cumulative); 
            i++;     }
  
                    if (x == cc){}
                    else{
                        acc = (long)((float)x/du.getCommercialCane(pID));
                        sc = (long)((float)acc*du.getSeedCane(pID));
                        isc = (long)((float)acc * du.getInitialSeedCane(pID));
                        years[i+1] = years[i-1]+1;
                        iSC[i+1]= isc;
                        sC[i+1] = sc;
                        cC[i+1] = acc;
            
            annualDevelopedArea = iSC[i+1] + sC[i+1] + cC[i+1];
            cumulative = cumulative + annualDevelopedArea;

                    System.out.print(years[i+1]+"   \t"+iSC[i+1]+ "  \t"+sC[i+1]+"  \t"+cC[i+1]+"    \t"+annualDevelopedArea+"\t"+cumulative+"\n"); //for testing
            du.saveConventionalACPlanting(years[i+1],iSC[i+1],sC[i+1],cC[i+1],annualDevelopedArea,cumulative); 

                    }
        return bool;
    }
    
    public boolean generateNewIstablishmentSchedule(){
        long acc = 0;
        long cc = du.getNewCC();
        long sc = du.getNewSC();
        long isc = du.getNewISC();
        long annualDevelopedArea = 0;
        long cumulative = 0;
        long TCA = du.getNewTotalCaneArea(pID);
        //int y = du.getAvgCuttingAgeInYears();
        int years[] =  new int[50];
        years[0]= 0;
        long cC[] = new long[50];
        cC[0] = 0;
        long sC[] = new long[50];
        sC[0] = 0;
        long iSC[] = new long[50];
        iSC[0] = 0;
        int i = 1;
        long x=cc+1;
                
                du.creatNewTableConventionalACP();
        
        
        while((cumulative < TCA)&&(x>cc)){
            
            
            years[i] = i;
            //System.out.print(years[i]+"\t");
            
            
                    if (iSC[i-1] == 0 && sC[i-1] == 0 && cC[i-1]== 0){
                        iSC[i]= isc;
                        annualDevelopedArea = iSC[i] + sC[i] + cC[i];
                        //System.out.print(iSC[i]+"\t"+sC[i]+"\t"+cC[i]+"\t"+annualDevelopedArea+"\n");
                    }else if (iSC[i-1] != 0 && sC[i-1] == 0){
                        iSC[i]= isc;
                        sC[i] = sc;
                        annualDevelopedArea = iSC[i] + sC[i] + cC[i];
                        //System.out.print(annualDevelopedArea+"\n");
                        //System.out.print(iSC[i]+"\t"+sC[i]+"\t"+cC[i]+"\t"+annualDevelopedArea+"\n");
                    }else if (iSC[i-1] != 0 && sC[i-1] != 0){ //&& (x > cc)){
                        iSC[i]= isc;
                        sC[i] = sc;
                        cC[i] = cc;
                        annualDevelopedArea = iSC[i] + sC[i] + cC[i];
                       //System.out.print(iSC[i]+"\t"+sC[i]+"\t"+cC[i]+"\n");
                    }
            
            cumulative = cumulative + annualDevelopedArea;
            x = TCA - cumulative; //System.out.print(x+"\n");
            
                    
                    
            System.out.print(years[i]+"\t"+iSC[i]+ "  \t"+sC[i]+"  \t"+cC[i]+"    \t"+annualDevelopedArea+"\t"+cumulative+"\n"); //for testing
           du.saveNewConventionalACPlanting(years[i],iSC[i],sC[i],cC[i],annualDevelopedArea,cumulative); 
            i++;     }
  
                    if (x == cc){}
                    else{
                        acc = (long)((float)x/du.getCommercialCane(pID));
                        sc = (long)((float)acc*du.getSeedCane(pID));
                        isc = (long)((float)acc * du.getInitialSeedCane(pID));
                        years[i+1] = years[i-1]+1;
                        iSC[i+1]= isc;
                        sC[i+1] = sc;
                        cC[i+1] = acc;
            
            annualDevelopedArea = iSC[i+1] + sC[i+1] + cC[i+1];
            cumulative = cumulative + annualDevelopedArea;

                    System.out.print(years[i+1]+"   \t"+iSC[i+1]+ "  \t"+sC[i+1]+"  \t"+cC[i+1]+"    \t"+annualDevelopedArea+"\t"+cumulative+"\n"); //for testing
            du.saveNewConventionalACPlanting(years[i+1],iSC[i+1],sC[i+1],cC[i+1],annualDevelopedArea,cumulative); 

                    }
        return bool;
    }
    
    public boolean generateNewReplantingSchedule(){
        int i = 1;
        long cc = 0;
        long sc = 0;
        long isc = 0;
        long annualDevelopedArea[] = new long[50];
        long cumulative[] = new long[50];
        int avgCuttingAY = du.getNewAvgCuttingAgeInYears();
                System.out.print(avgCuttingAY);//for testing
        int getLastPlantingY = du.getNewLastPlantingY();
                System.out.print(getLastPlantingY);//for testing
        int diff = (getLastPlantingY - avgCuttingAY)+1;
                System.out.print(diff+"\n");//for testing
        int LY = avgCuttingAY;
        long avgRotationArea = du.getNewAvgRotationArea();
        long total = 0;
        int years[] =  new int[50];
        years[0]= 0;
        long cC[] = new long[50];
        cC[0] = 0;
        long sC[] = new long[50];
        sC[0] = 0;
        long iSC[] = new long[50];
        iSC[0] = 0;
        float ccRatio  = du.getNewCommercialCane(pID);
        float scRatio = du.getNewSeedCane(pID);  
        float iscRatio = du.getNewInitialSeedCane(pID);
        long initialSeedCane = du.getNewISC();
        long seedCane = du.getNewSC();
            
            
            while(i <= diff+getLastPlantingY){
              
                if((diff - i) == 0){
                    total = (long)((double)avgRotationArea * 0.7);
                   //System.out.print(total+"\t"); //for testing
                    cc =(long)((float)total / ccRatio);
                    sc = (long)((float) cc * scRatio);
                    years[i] = LY++;
                    cC[i] = cc;
                    sC[i-1] = sc;
                    annualDevelopedArea[i-1] =  sC[i-1] + cC[i-1];
                    cumulative[i-1] = cumulative[i-2] + annualDevelopedArea[i-1];
                    //System.out.print(years[i]+"\t"+cC[i]+"\t"+sC[i-1]+"\n");//for testing
                    //System.out.print(years[i]+"\t"+cC[i]+"\t"+sC[i]+"\t"+annualDevelopedArea[i]+"\t"+cumulative[i]+"\n");
                    //du.saveConventionalACPlanting(years[i+1],iSC[i+1],sC[i+1],cC[i+1],annualDevelopedArea,cumulative);
                    i++;
                }else if((diff - i) == (diff - 1)){
                    total = initialSeedCane + initialSeedCane + seedCane;
                   //System.out.print(total+"\t"); //for testing
                    years[i] = LY++;
                    cc = total;//(long)((float)total / ccRatio);
                    //sc = (long)((float) cc * scRatio);
                    cC[i] = cc;
                    //sC[i-1] = 0;
                    annualDevelopedArea[i] =  sC[i] + cC[i];
                    cumulative[i] = cumulative[i-1] + annualDevelopedArea[i];
                    
                  // System.out.print(years[i]+"\t"+cC[i]+"\t"+sC[i-1]+"\n");//for testing
                   //System.out.print(years[i]+"\t"+cC[i]+"\t"+sC[i]+"\t"+annualDevelopedArea[i]+"\t"+cumulative[i]+"\n");
                   //du.saveConventionalACPlanting(years[i+1],iSC[i+1],sC[i+1],cC[i+1],annualDevelopedArea,cumulative);
                    i++;
                }else if((diff - i) >= 1){
                    total = (long)((double)avgRotationArea * 0.2);
                   //System.out.print(total+"\t"); //for testing
                    years[i] = LY++;
                    cc =(long)((float)total / ccRatio);
                    sc = (long)((float) cc * scRatio);
                    cC[i] = cc;
                    sC[i-1] = sc;
                    annualDevelopedArea[i-1] =  sC[i-1] + cC[i-1];
                    cumulative[i-1] = cumulative[i-2] + annualDevelopedArea[i-1];
                    
                  // System.out.print(years[i]+"\t"+cC[i]+"\t"+sC[i-1]+"\n");//for testing
                   //System.out.print(years[i]+"\t"+cC[i]+"\t"+sC[i-1]+"\t"+annualDevelopedArea[i-1]+"\t"+cumulative[i-1]+"\n");
                   //du.saveConventionalACPlanting(years[i+1],iSC[i+1],sC[i+1],cC[i+1],annualDevelopedArea,cumulative);
                    i++;
                }else{// if ((diff - 1) < 0 && (diff - 1) > -6){
                     total = (long)((double)avgRotationArea * 1);
                   //System.out.print(total+"\t"); //for testing
                    cc =(long)((float)total / ccRatio);
                    sc = (long)((float) cc * scRatio);
                    isc = (long)((float) cc * iscRatio);
                    sc = sc + isc;
                    years[i] = LY++;
                    cC[i] = cc;
                    sC[i-1] = sc;
                    annualDevelopedArea[i-1] =  sC[i-1] + cC[i-1];
                    cumulative[i-1] = cumulative[i-2] + annualDevelopedArea[i-1];
                    //System.out.print(years[i]+"\t"+cC[i]+"\t"+sC[i-1]+"\n");//for testing
                    //System.out.print(years[i]+"\t"+cC[i]+"\t"+sC[i-1]+"\t"+annualDevelopedArea[i-1]+"\t"+cumulative[i-1]+"\n");
                    //du.saveConventionalACPlanting(years[i+1],iSC[i+1],sC[i+1],cC[i+1],annualDevelopedArea,cumulative);
                    i++;
                }
                    
            }
        System.out.print("\n\n\n");
        cumulative[1] = cumulative[1]+sC[1];
        du.createNewTableReplanting();
      for (int j=1; j < diff+getLastPlantingY; j++){
           du.saveNewReplantingSchedule(years[j],cC[j],sC[j], annualDevelopedArea[j], cumulative[j]);
            System.out.print(years[j]+"\t"+cC[j]+"\t"+sC[j]+"\t"+annualDevelopedArea[j]+"\t"+cumulative[j]+"\n");
        }
        
        
        return bool;
    }
    
    public boolean generateReplantingSchedule(){
        
        int i = 1;
        long cc = 0;
        long sc = 0;
        long isc = 0;
        long annualDevelopedArea[] = new long[50];
        long cumulative[] = new long[50];
        int avgCuttingAY = du.getAvgCuttingAgeInYears();
                System.out.print(avgCuttingAY);//for testing
        int getLastPlantingY = du.getLastPlantingY();
                System.out.print(getLastPlantingY);//for testing
        int diff = (getLastPlantingY - avgCuttingAY)+1;
                System.out.print(diff+"\n");//for testing
        int LY = avgCuttingAY;
        long avgRotationArea = du.getAvgRotationArea();
        long total = 0;
        int years[] =  new int[50];
        years[0]= 0;
        long cC[] = new long[50];
        cC[0] = 0;
        long sC[] = new long[50];
        sC[0] = 0;
        long iSC[] = new long[50];
        iSC[0] = 0;
        float ccRatio  = du.getCommercialCane(pID);
        float scRatio = du.getSeedCane(pID);  
        float iscRatio = du.getInitialSeedCane(pID);
        long initialSeedCane = du.getISC();
        long seedCane = du.getSC();
            
            
            while(i <= diff+getLastPlantingY){
              
                if((diff - i) == 0){
                    total = (long)((double)avgRotationArea * 0.7);
                   //System.out.print(total+"\t"); //for testing
                    cc =(long)((float)total / ccRatio);
                    sc = (long)((float) cc * scRatio);
                    years[i] = LY++;
                    cC[i] = cc;
                    sC[i-1] = sc;
                    annualDevelopedArea[i-1] =  sC[i-1] + cC[i-1];
                    cumulative[i-1] = cumulative[i-2] + annualDevelopedArea[i-1];
                    //System.out.print(years[i]+"\t"+cC[i]+"\t"+sC[i-1]+"\n");//for testing
                    //System.out.print(years[i]+"\t"+cC[i]+"\t"+sC[i]+"\t"+annualDevelopedArea[i]+"\t"+cumulative[i]+"\n");
                    //du.saveConventionalACPlanting(years[i+1],iSC[i+1],sC[i+1],cC[i+1],annualDevelopedArea,cumulative);
                    i++;
                }else if((diff - i) == (diff - 1)){
                    total = initialSeedCane + initialSeedCane + seedCane;
                   //System.out.print(total+"\t"); //for testing
                    years[i] = LY++;
                    cc = total;//(long)((float)total / ccRatio);
                    //sc = (long)((float) cc * scRatio);
                    cC[i] = cc;
                    //sC[i-1] = 0;
                    annualDevelopedArea[i] =  sC[i] + cC[i];
                    cumulative[i] = cumulative[i-1] + annualDevelopedArea[i];
                    
                  // System.out.print(years[i]+"\t"+cC[i]+"\t"+sC[i-1]+"\n");//for testing
                   //System.out.print(years[i]+"\t"+cC[i]+"\t"+sC[i]+"\t"+annualDevelopedArea[i]+"\t"+cumulative[i]+"\n");
                   //du.saveConventionalACPlanting(years[i+1],iSC[i+1],sC[i+1],cC[i+1],annualDevelopedArea,cumulative);
                    i++;
                }else if((diff - i) >= 1){
                    total = (long)((double)avgRotationArea * 0.2);
                   //System.out.print(total+"\t"); //for testing
                    years[i] = LY++;
                    cc =(long)((float)total / ccRatio);
                    sc = (long)((float) cc * scRatio);
                    cC[i] = cc;
                    sC[i-1] = sc;
                    annualDevelopedArea[i-1] =  sC[i-1] + cC[i-1];
                    cumulative[i-1] = cumulative[i-2] + annualDevelopedArea[i-1];
                    
                  // System.out.print(years[i]+"\t"+cC[i]+"\t"+sC[i-1]+"\n");//for testing
                   //System.out.print(years[i]+"\t"+cC[i]+"\t"+sC[i-1]+"\t"+annualDevelopedArea[i-1]+"\t"+cumulative[i-1]+"\n");
                   //du.saveConventionalACPlanting(years[i+1],iSC[i+1],sC[i+1],cC[i+1],annualDevelopedArea,cumulative);
                    i++;
                }else{// if ((diff - 1) < 0 && (diff - 1) > -6){
                     total = (long)((double)avgRotationArea * 1);
                   //System.out.print(total+"\t"); //for testing
                    cc =(long)((float)total / ccRatio);
                    sc = (long)((float) cc * scRatio);
                    isc = (long)((float) cc * iscRatio);
                    sc = sc + isc;
                    years[i] = LY++;
                    cC[i] = cc;
                    sC[i-1] = sc;
                    annualDevelopedArea[i-1] =  sC[i-1] + cC[i-1];
                    cumulative[i-1] = cumulative[i-2] + annualDevelopedArea[i-1];
                    //System.out.print(years[i]+"\t"+cC[i]+"\t"+sC[i-1]+"\n");//for testing
                    //System.out.print(years[i]+"\t"+cC[i]+"\t"+sC[i-1]+"\t"+annualDevelopedArea[i-1]+"\t"+cumulative[i-1]+"\n");
                    //du.saveConventionalACPlanting(years[i+1],iSC[i+1],sC[i+1],cC[i+1],annualDevelopedArea,cumulative);
                    i++;
                }
                    
            }
        System.out.print("\n\n\n");
        cumulative[1] = cumulative[1]+sC[1];
        du.creatTableRplanting();
      for (int j=1; j < diff+getLastPlantingY; j++){
           du.saveReplantingSchedule(years[j],cC[j],sC[j], annualDevelopedArea[j], cumulative[j]);
            System.out.print(years[j]+"\t"+cC[j]+"\t"+sC[j]+"\t"+annualDevelopedArea[j]+"\t"+cumulative[j]+"\n");
        }
        
        
        return bool;
    }
    
    public boolean generateNewHarvestProgramEXSC(){
          
        //long isc = 0;
        //long sc = 0;
        int LY = du.getNewLastPlantingY();
        int LR = du.getNewLastRatoon();
        //int newLY = 0;
        long[] cumulative = new long[50];
        float ratoonR[] = new float[50];
        long R[][] = new long [50][50];
        R[0][0] = 0;
        int i = 1;
        int n = 2;
        int j = 1;
        int r = du.getNewAvgCuttingAgeInYears();
        n = r;
        
            while(i <= LY){
                cumulative[i] = du.getNewISCFConventional(i) + du.getNewSCFConventional(i);
               //System.out.print(cumulative[i]+"\t\n");//for testing
                i++;
            }i=1;
            while (i <= LR ){
                ratoonR[i] = (float)((float)12/du.getNewRatoonAge(i));
                System.out.print("\n"+"\t"+ratoonR[i]);//for testing
                i++;
            }
                i=1;     

                        while (i < r){ //System.out.print("\nR"+(i)+"\t");//+i+"\t");//for testing
                                if(i<2){
                                    du.createNewTable(LY+LY);
                                    i++;
                                    j = 2;
                                //}
                                }else if(i == 2){                        //R[i-1] [j-1] starts inserting values 2,2
                                    while (j < LY+LY){
                                        R[i][j] = cumulative[j-1];
                                       
                                       // System.out.print(R[i][j]+"\t");//for testing
                                        j++;
                                    }
                                    i++;
                                    j = 3;
                                   
                                }else if (i > 2){
                                    while (j < LY + LY){
                                        R[i][j] = ((long)((double)R[i-1][j - 1] * ratoonR[i]) + (long)Math.ceil(R[i-1][j-2] * (1 -ratoonR[i])));//j++;
                                       // System.out.print("\n"+(Math.ceil(R[i-1][j-2] * (1 -ratoonR[i])))+"\n");
                                        if ((R[i-1][j-2] - R[i][j-1])>=0){
                                       // System.out.print(R[i][j-1]+"\t");//for testing
                                        j++;
                                    }else if ((R[i-1][j-2] - R[i][j-1])<0){
                                       R[i][j] = 0;
                                        // System.out.print(R[i][j-1]+"\t");//for testing
                                        j++;
                                    }else{
                                         //System.out.print(R[i][j-1]+"\t");//for testing
                                         j++;
                                    }
                                    }
                                    i++;
                                    j=3;
                                    
                        }
         }              i = 1;
                        //j = 1;
                        while (i <= n){ 
                            System.out.print("\n");
                            for(j=0; j < LY+LY; j++){
                            System.out.print(R[i][j]+"\t");
                            
                              }i++;
                        }

       du.saveNewHarvestProgramEXSC(R , n, LY);
        
        
        
        
        return bool;
    }
    
    public boolean generateHarvestProgramEXSC(){
        
        long isc = 0;
        long sc = 0;
        int LY = du.getLastPlantingY();
        int LR = du.getLastRatoon();
        int newLY = 0;
        long[] cumulative = new long[50];
        float ratoonR[] = new float[50];
        long R[][] = new long [50][50];
        R[0][0] = 0;
        int i = 1;
        int n = 2;
        int j = 1;
        int r = du.getAvgCuttingAgeInYears();
        n = r;
        
            while(i <= LY){
                cumulative[i] = du.getISCFConventional(i) + du.getSCFConventional(i);
               //System.out.print(cumulative[i]+"\t\n");//for testing
                i++;
            }i=1;
            while (i <= LR ){
                ratoonR[i] = (float)((float)12/du.getRatoonAge(i));
                System.out.print("\n"+"\t"+ratoonR[i]);//for testing
                i++;
            }
                i=1;     

                        while (i < r){ //System.out.print("\nR"+(i)+"\t");//+i+"\t");//for testing
                                if(i<2){
                                    du.createTable(LY+LY);
                                    i++;
                                    j = 2;
                                //}
                                }else if(i == 2){                        //R[i-1] [j-1] starts inserting values 2,2
                                    while (j < LY+LY){
                                        R[i][j] = cumulative[j-1];
                                       
                                       // System.out.print(R[i][j]+"\t");//for testing
                                        j++;
                                    }
                                    i++;
                                    j = 3;
                                   
                                }else if (i > 2){
                                    while (j < LY + LY){
                                        R[i][j] = ((long)((double)R[i-1][j - 1] * ratoonR[i]) + (long)Math.ceil(R[i-1][j-2] * (1 -ratoonR[i])));//j++;
                                       // System.out.print("\n"+(Math.ceil(R[i-1][j-2] * (1 -ratoonR[i])))+"\n");
                                        if ((R[i-1][j-2] - R[i][j-1])>=0){
                                       // System.out.print(R[i][j-1]+"\t");//for testing
                                        j++;
                                    }else if ((R[i-1][j-2] - R[i][j-1])<0){
                                       R[i][j] = 0;
                                        // System.out.print(R[i][j-1]+"\t");//for testing
                                        j++;
                                    }else{
                                         //System.out.print(R[i][j-1]+"\t");//for testing
                                         j++;
                                    }
                                    }
                                    i++;
                                    j=3;
                                    
                        }
         }              i = 1;
                        //j = 1;
                        while (i <= n){ 
                            System.out.print("\n");
                            for(j=0; j < LY+LY; j++){
                            System.out.print(R[i][j]+"\t");
                            
                              }i++;
                        }

       du.saveHarvestProgramEXSC(R , n, LY);
        
        
        
        
        return bool;
    }
    
    public boolean generateNewHarvestProgramCC(){
        int LY = du.getNewLastPlantingY();
        int LR = du.getNewLastRatoon();
        float oneRS = du.getNewOneRS();
        float twoRS = du.getTwoRS();
        
        long[] cumulative = new long[50];
        float ratoonR[] = new float[50];
        long R[][] = new long [50][50];
        R[0][0] = 0;
        int i = 1;
        int n = 0;
        int j = 1;
        int r = du.getNewAvgCuttingAgeInYears();
        n=r;
            while(i <= LY){
                cumulative[i] = du.getNewCCConventional(i);
               // System.out.print(cumulative[i]+"\t");//for testing
                i++;
            } i=1;
            while (i <= LR ){
                ratoonR[i] = (float)((float)12/du.getNewRatoonAge(i));
                System.out.print("\n"+"\t"+ratoonR[i]);//for testing
                i++;
            }
                i=0;     
                j=0;
                      while (i < r){ //System.out.print("\nR"+(i)+"\t");//+i+"\t");//for testing
                                if(i<1){
                                  du.createNewTableH(LY+LY);
                                    //i++;
                                    j = 2;
                        
                                    while (j <= LY+LY){
                                        
                                        R[i][j] = (cumulative[j-1] );
                                       // System.out.print(R[i][j]+"\t");//for testing
                                        j++;
                                    }
                                    i++;
                                    j = 3;
                                    
                                }else if (i == 1){
                                    //R[i][j] = ((long)((double)R[i-1][j - 1] * oneRS) + (R[i-1][j-2] - R[i][j-1]));
                                            while (j <= LY+LY){
                                         R[i][j] = ((long)(((double)R[i-1][j - 1] * oneRS) + ((double)R[i-1][j-2] * twoRS)));
                                       
                                       // System.out.print(R[i][j]+"\t");//for testing
                                        j++;
                                    }
                                    i++;
                                    j = 3;
                                            
                                   
                                }else if (i > 1){
                                    while (j <= LY + LY+3){
                                        R[i][j] = ((long)((double)R[i-1][j - 1] * ratoonR[i]) + (long)Math.ceil(R[i-1][j-2] * (1 -ratoonR[i])));
                                        
                                    j++;
                                    }
                                    i++;
                                    j= 3;
                                    
                        }
         }              i = 0;
                        //j = 1;
                        while (i < n){ 
                            System.out.print("\n"+i+"\t");
                            for(j=2; j < LY+LY+LY; j++){
                            System.out.print(R[i][j]+"\t");
                            //j++;
                            //System.out.print(j+"\t");
                              }i++;//System.out.print(i+"\t");
                        }

     du.saveNewHarvestProgramCC(R , n, LY);
        
        
        
        
        return bool;
    }
    
    public boolean generateHarvestProgramCC(){
       
        int LY = du.getLastPlantingY();
        int LR = du.getLastRatoon();
        float oneRS = du.getOneRS();
        float twoRS = du.getTwoRS();
        
        long[] cumulative = new long[50];
        float ratoonR[] = new float[50];
        long R[][] = new long [50][50];
        R[0][0] = 0;
        int i = 1;
        int n = 0;
        int j = 1;
        int r = du.getAvgCuttingAgeInYears();
        n=r;
            while(i <= LY){
                cumulative[i] = du.getCCConventional(i);
               // System.out.print(cumulative[i]+"\t");//for testing
                i++;
            } i=1;
            while (i <= LR ){
                ratoonR[i] = (float)((float)12/du.getRatoonAge(i));
                System.out.print("\n"+"\t"+ratoonR[i]);//for testing
                i++;
            }
                i=0;     
                j=0;
                      while (i < r){ //System.out.print("\nR"+(i)+"\t");//+i+"\t");//for testing
                                if(i<1){
                                  du.createTableH(LY+LY);
                                    //i++;
                                    j = 2;
                        
                                    while (j <= LY+LY){
                                        
                                        R[i][j] = (cumulative[j-1] );
                                       // System.out.print(R[i][j]+"\t");//for testing
                                        j++;
                                    }
                                    i++;
                                    j = 3;
                                    
                                }else if (i == 1){
                                    //R[i][j] = ((long)((double)R[i-1][j - 1] * oneRS) + (R[i-1][j-2] - R[i][j-1]));
                                            while (j <= LY+LY){
                                         R[i][j] = ((long)(((double)R[i-1][j - 1] * oneRS) + ((double)R[i-1][j-2] * twoRS)));
                                       
                                       // System.out.print(R[i][j]+"\t");//for testing
                                        j++;
                                    }
                                    i++;
                                    j = 3;
                                            
                                   
                                }else if (i > 1){
                                    while (j <= LY + LY+3){
                                        R[i][j] = ((long)((double)R[i-1][j - 1] * ratoonR[i]) + (long)Math.ceil(R[i-1][j-2] * (1 -ratoonR[i])));
                                        
                                    j++;
                                    }
                                    i++;
                                    j= 3;
                                    
                        }
         }              i = 0;
                        //j = 1;
                        while (i < n){ 
                            System.out.print("\n"+i+"\t");
                            for(j=2; j < LY+LY+LY; j++){
                            System.out.print(R[i][j]+"\t");
                            //j++;
                            //System.out.print(j+"\t");
                              }i++;//System.out.print(i+"\t");
                        }

     du.SaveHarvestProgramCC(R , n, LY);
        
        
        
        
        return bool;
    }
    
    public boolean generateNewReplantFieldHarvest(){
        
         int LY = du.getNewLastPlantingY();
        int LR = du.getNewLastRatoon();
        float oneRS = du.getNewOneRS();
        float twoRS = du.getNewTwoRS();
        
        long cumulative[] = new long[50];
        float ratoonR[] = new float[50];
        long R[][] = new long [50][50];
        R[0][0] = 0;
        int i = du.getNewReplantingStartYear();
        int n = i;
        int j = 1;
        int r = i;
        
        
        
            while(i <= LY+LY+3){
                cumulative[i] = du.getNewReplantingScheduleCC(i);
                 if (du.getNewReplantingScheduleCC(i) == 0){
                                cumulative[i] = cumulative[i-1];
                                        }
               System.out.print(cumulative[i]+"\t");//for testing
                i++;//r++;
            }i=1;
            while (i <= LR){
                ratoonR[i] = (float)((float)12/du.getNewRatoonAge(i));
                System.out.print("\n"+"\t"+ratoonR[i]);//for testing
                i++;
            }
                i=0;     
                j=0;
                      while (i <= LR){ //System.out.print("\nR"+(i)+"\t");//+i+"\t");//for testing
                                if(i<1){
                                 du.createNewTableRFH(LY+LY);
                                   // i++;
                                    j = 2;
                               
                                    
                                    while (j <= LY+LY+3){
                                        
                                        R[i][j] = (cumulative[j-1] );
                                       // System.out.print(R[i][j]+"\t");//for testing
                                        j++;
                                       
                                    }
                                    i++;
                                    j = 3;
                                    
                                }else if (i == 1){
                                    //R[i][j] = ((long)((double)R[i-1][j - 1] * oneRS) + (R[i-1][j-2] - R[i][j-1]));
                                            while (j <= LY+LY+3){
                                         R[i][j] = ((long)(((double)R[i-1][j - 1] * oneRS) + ((double)R[i-1][j-2] * twoRS)));
                                       
                                       // System.out.print(R[i][j]+"\t");//for testing
                                        j++;
                                    }
                                    i++;
                                    j = 3;
                                     
                                   
                                }else if (i > 1){
                                    while (j <= LY + LY+3){
                                        R[i][j] = ((long)((double)R[i-1][j - 1] * ratoonR[i]) + (long)((double)R[i-1][j-2] * (1 -ratoonR[i])));
                                        //System.out.print(ratoonR[i]+"\t"+ratoonR[i]+"\n"); for testing
                                 j++;}
                                    i++;
                                    j = 3;
                                }
                                        
                        
         }            i = 0;
                        //j = 1;
                        while (i < r){ 
                            System.out.print("\n"+i+"\t");
                            for(j=2; j < LY+LY+3; j++){
                            System.out.print(R[i][j]+"\t");
                            //j++;
                            //System.out.print(j+"\t");
                              }i++;//System.out.print(i+"\t");
                        }
                      System.out.print("\n"+n);
    du.saveNewReplantFieldHarvest(R , n, LY);
        

        
        
        
        
        
        return bool;
    }
    
    public boolean generateReplantFieldHarvest(){
        
        
         int LY = du.getLastPlantingY();
        int LR = du.getLastRatoon();
        float oneRS = du.getOneRS();
        float twoRS = du.getTwoRS();
        
        long cumulative[] = new long[50];
        float ratoonR[] = new float[50];
        long R[][] = new long [50][50];
        R[0][0] = 0;
        int i = du.getReplantingStartYear();
        int n = i;
        int j = 1;
        int r = i;
        
        
        
            while(i <= LY+LY+3){
                cumulative[i] = du.getReplantingScheduleCC(i);
                 if (du.getReplantingScheduleCC(i) == 0){
                                cumulative[i] = cumulative[i-1];
                                        }
               System.out.print(cumulative[i]+"\t");//for testing
                i++;//r++;
            }i=1;
            while (i <= LR){
                ratoonR[i] = (float)((float)12/du.getRatoonAge(i));
                System.out.print("\n"+"\t"+ratoonR[i]);//for testing
                i++;
            }
                i=0;     
                j=0;
                      while (i <= LR){ //System.out.print("\nR"+(i)+"\t");//+i+"\t");//for testing
                                if(i<1){
                                 du.createTableRFH(LY+LY);
                                   // i++;
                                    j = 2;
                               
                                    
                                    while (j <= LY+LY+3){
                                        
                                        R[i][j] = (cumulative[j-1] );
                                       // System.out.print(R[i][j]+"\t");//for testing
                                        j++;
                                       
                                    }
                                    i++;
                                    j = 3;
                                    
                                }else if (i == 1){
                                    //R[i][j] = ((long)((double)R[i-1][j - 1] * oneRS) + (R[i-1][j-2] - R[i][j-1]));
                                            while (j <= LY+LY+3){
                                         R[i][j] = ((long)(((double)R[i-1][j - 1] * oneRS) + ((double)R[i-1][j-2] * twoRS)));
                                       
                                       // System.out.print(R[i][j]+"\t");//for testing
                                        j++;
                                    }
                                    i++;
                                    j = 3;
                                     
                                   
                                }else if (i > 1){
                                    while (j <= LY + LY+3){
                                        R[i][j] = ((long)((double)R[i-1][j - 1] * ratoonR[i]) + (long)((double)R[i-1][j-2] * (1 -ratoonR[i])));
                                        //System.out.print(ratoonR[i]+"\t"+ratoonR[i]+"\n"); for testing
                                 j++;}
                                    i++;
                                    j = 3;
                                }
                                        
                        
         }            i = 0;
                        //j = 1;
                        while (i < r){ 
                            System.out.print("\n"+i+"\t");
                            for(j=2; j < LY+LY+3; j++){
                            System.out.print(R[i][j]+"\t");
                            //j++;
                            //System.out.print(j+"\t");
                              }i++;//System.out.print(i+"\t");
                        }
                      System.out.print("\n"+n);
    du.SaveReplantFieldHarvest(R , n, LY);
        

        
        
        
        
        
        return bool;
    }
    
    public boolean generateNewHarvestCane(){
        
        int LY = du.getNewLastPlantingY();
        int avgYield = du.getNewAvgCaneProduction();
        long totalEXSC[] = new long[50];
        long totalCC[] = new long [50];
        long totalReField[] = new long [50];
        long annualHarvestC[] = new long [50];
        int i=1;
        int countOfColumn = du.getNewCountOfColumns_EXSCHarvestP();
        
            while (i < countOfColumn){
                totalEXSC[i] = du.getNewTotalEXSCH(i) * avgYield;
                totalCC[i] = du.getNewTotalCCH(i) * avgYield;
                totalReField[i] = du.getNewReplantF(i) * avgYield;
                annualHarvestC[i] = (totalEXSC[i] + totalCC[i] + totalReField[i]);
                
                System.out.print(totalEXSC[i]+"\t"+totalCC[i]+"\t"+totalReField[i]+"\t"+annualHarvestC[i]+"\n");
                i++;
            }
        
         du.createNewTableHCTotal(LY+LY);
         du.saveNewTotalHarvestCane(totalEXSC, totalCC, totalReField, annualHarvestC, LY);
        
        
        
        return bool;
    }
    
    public boolean generateHarvestCane(){
        
        int LY = du.getLastPlantingY();
        int avgYield = du.getAvgCaneProduction();
        long totalEXSC[] = new long[50];
        long totalCC[] = new long [50];
        long totalReField[] = new long [50];
        long annualHarvestC[] = new long [50];
        int i=1;
        int countOfColumn = du.getCountOfColumns_EXSCHarvestP();
        
            while (i < countOfColumn){
                totalEXSC[i] = du.getTotalEXSCH(i) * avgYield;
                totalCC[i] = du.getTotalCCH(i) * avgYield;
                totalReField[i] = du.getReplantF(i) * avgYield;
                annualHarvestC[i] = (totalEXSC[i] + totalCC[i] + totalReField[i]);
                
                System.out.print(totalEXSC[i]+"\t"+totalCC[i]+"\t"+totalReField[i]+"\t"+annualHarvestC[i]+"\n");
                i++;
            }
        
         du.createTableHCTotal(LY+LY);
         du.saveTotalHarvestCane(totalEXSC, totalCC, totalReField, annualHarvestC, LY);
        
        
        
        return bool;
    }
    
    public boolean calculateNewTotalHarvestCaneInPercent(){
        long annualC = du.getNewAnnualCane(pID);
        long THC[] = new long[50];
        THC[0] = 0;
        float totalInPercent[] = new float[50];
        int count = du.getNewCountOfColumns_TotalHCane();
        int i = 1;
        
            while (i<count){
                THC[i] = du.getNewTotalHC(i);
                totalInPercent[i] = ((float)((float)THC[i] / (float)annualC) * 100);
                
                i++;
            }
        i = 1;
        while(i<count){
            System.out.print(THC[i]+" / "+annualC+" = "+totalInPercent[i]+"\n");
            i++;
        }
        
        
        du.createNewTableHCTotalInPercent(count);
        du.saveNewCTotalHCIPercent(totalInPercent, count);
        
        
        return bool;
    }
    
    public boolean calculateTotalHarvestCaneInPercent(){
        long annualC = du.getAnnualCane(pID);
        long THC[] = new long[50];
        THC[0] = 0;
        float totalInPercent[] = new float[50];
        int count = du.getCountOfColumns_TotalHCane();
        int i = 1;
        
            while (i<count){
                THC[i] = du.getTotalHC(i);
                totalInPercent[i] = ((float)((float)THC[i] / (float)annualC) * 100);
                
                i++;
            }
        i = 1;
        while(i<count){
            System.out.print(THC[i]+" / "+annualC+" = "+totalInPercent[i]+"\n");
            i++;
        }
        
        
        du.createTableHCTotalInPercent(count);
        du.saveCTotalHCIPercent(totalInPercent, count);
        
        
        return bool;
    }
    
    
}
