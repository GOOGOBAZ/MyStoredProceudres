/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googo.pmms.project2.financialStatement;

import googo.pmms.project2.accountsHelper.Formartter;
import googo.pmms.project2.accountsHelper.fileInputOutPutStreams;
import googo.pmms.project2.frameHelper.ListDataModel;
import static java.lang.Double.parseDouble;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author SSRN
 */
public class TheBalanceSheet implements  BalanceSheet {
    Formartter ffm=new Formartter();
String materialDates;
    fileInputOutPutStreams fios= new fileInputOutPutStreams();
    ListDataModel model1;
String title;
    List<String> tableHeaders=new ArrayList();
    List< List<Object>> dataBody=new ArrayList();
     
     Map<Integer, List<Object>> data=new HashMap();
     
     
   BalanceSheetUtility bUtility=new BalanceSheetUtility();  
             
    public TheBalanceSheet(String materialDate){
    materialDates=ffm.forDatabaseWithFullYearBeginningWithDate(materialDate);
    }
    



                      public ListDataModel createBalanceSheet(){
                          
                        this.setBodyList(bUtility.comperativePeriodTitles(materialDates, "Year"));
                        
                        LiabilityEquityAccounts liabEqui=LiabilityEquityAccounts.assetProducer(materialDates);

                        AssetAccount asset=AssetAccount.assetProducer(materialDates);

                        boolean bs=true;

                        if(!isAssetsEmpty()){

                        this.setBodyList(asset.mainAssetTitle());


                        if(!isCurrentAssetsEmpty()){  

                        this.setBodyList(asset.currentAssetTitle());
                        int t=0;
                        while(t<asset.currentAssets().size()){

                        this.setBodyList(asset.currentAssets().get(t));
                        
                        t++;
                        }
                            this.setBodyList(totalCurrentAssets());

                            if(!isNonCurrentAssetsEmpty()){

                            this.setBodyList(asset.nonCurrentAssetTitle());

                            int p=0;

                            while(p<asset.nonCurrentAssets().size()){

                            this.setBodyList(asset.nonCurrentAssets().get(p));
                            p++;
                            }

                            this.setBodyList(totalNonCurrentAssets());

                            this.setBodyList(this.totalAssets());
//
                            if(!isLiabilitiesEmpty()){ 

                            this.setBodyList(liabEqui.mainLiabilitiesEquityTitle());

                            if(!isCurrentLiabilityEmpty()){

                            this.setBodyList(liabEqui.currentLiabilitiesTitle());
                            int y=0;     
                            while(y<liabEqui.currentLiabilities().size()){

                            this.setBodyList(liabEqui.currentLiabilities().get(y));
                            y++;
                            }
                            this.setBodyList(totalCurrentLiabilities());

                            if(!isNonCurrentLiabilityEmpty()){

                            this.setBodyList(liabEqui.nonCurrentLiabilitiesTitle());
                            int z=0;
                            while(z<liabEqui.nonCurrentLiabilities().size()){

                            this.setBodyList( liabEqui.nonCurrentLiabilities().get(z));
                            z++;
                            }
                            this.setBodyList(totalNonCurrentLiabilities()); 

                            this.setBodyList(this.totalLiabilities());

                            if(!isEquityEmpty()){

                            this.setBodyList( liabEqui.equityTitle());
                            int jk=0;
                            while(jk<liabEqui.equity().size()){
                            this.setBodyList( liabEqui.equity().get(jk));
                            jk++;
                            }
                            this.setBodyList( totalEquity());
                            this.setBodyList(this.totalLiabilitiesEquity());
                            }


                            }else{
                            if(!isEquityEmpty()){
                            this.setBodyList( liabEqui.equityTitle());
                            int jk=0;
                            while(jk<liabEqui.equity().size()){
                            this.setBodyList( liabEqui.equity().get(jk));
                            jk++;
                            }
                            this.setBodyList( totalEquity());
                            this.setBodyList(this.totalLiabilitiesEquity());
                            }

                            }

                            } else if(!isNonCurrentLiabilityEmpty()){

                            this.setBodyList(liabEqui.nonCurrentLiabilitiesTitle());
                            int z=0;
                            while(z<liabEqui.nonCurrentLiabilities().size()){

                            this.setBodyList( liabEqui.nonCurrentLiabilities().get(z));
                            z++;
                            }
                            this.setBodyList( totalNonCurrentLiabilities());
                            this.setBodyList(this.totalLiabilities());

                            if(!isEquityEmpty()){
                            this.setBodyList( liabEqui.equityTitle());
                            int jk=0;
                            while(jk<liabEqui.equity().size()){
                            this.setBodyList( liabEqui.equity().get(jk));
                            jk++;
                            }
                            this.setBodyList( totalEquity());
                            this.setBodyList(this.totalLiabilitiesEquity());
                            }
                            }else  if(!isEquityEmpty()){
                            this.setBodyList( liabEqui.equityTitle());
                            int jk=0;
                            while(jk<liabEqui.equity().size()){
                            this.setBodyList( liabEqui.equity().get(jk));
                            jk++;
                            }
                            this.setBodyList( totalEquity());
                            this.setBodyList(this.totalLiabilitiesEquity());
                            } }      
                            }else{

                            this.setBodyList(this.totalAssets());

                            if(!isLiabilitiesEmpty()){ 

                            this.setBodyList(liabEqui.mainLiabilitiesEquityTitle());

                            if(!isCurrentLiabilityEmpty()){

                            this.setBodyList(liabEqui.currentLiabilitiesTitle());

                            int y=0;     
                            while(y<liabEqui.currentLiabilities().size()){

                            this.setBodyList(liabEqui.currentLiabilities().get(y));
                            y++;
                            }

                            this.setBodyList( totalCurrentLiabilities());

                            if(!isNonCurrentLiabilityEmpty()){

                            this.setBodyList(liabEqui.nonCurrentLiabilitiesTitle());

                            int z=0;
                            while(z<liabEqui.nonCurrentLiabilities().size()){

                            this.setBodyList( liabEqui.nonCurrentLiabilities().get(z));
                            z++;
                            }

                            this.setBodyList(totalNonCurrentLiabilities());

                            this.setBodyList(this.totalLiabilities());

                            if(!isEquityEmpty()){

                            this.setBodyList( liabEqui.equityTitle());
                            int jk=0;
                            while(jk<liabEqui.equity().size()){
                            this.setBodyList( liabEqui.equity().get(jk));
                            jk++;
                            }
                            this.setBodyList( totalEquity());
                            this.setBodyList(this.totalLiabilitiesEquity());
                            }


                            }else{
                            if(!isEquityEmpty()){
                            this.setBodyList( liabEqui.equityTitle());
                            int jk=0;
                            while(jk<liabEqui.equity().size()){
                            this.setBodyList( liabEqui.equity().get(jk));
                            jk++;
                            }
                            this.setBodyList( totalEquity());
                            this.setBodyList(this.totalLiabilitiesEquity());
                            }

                            }

                            }else if(!isNonCurrentLiabilityEmpty()){

                            this.setBodyList( liabEqui.nonCurrentLiabilitiesTitle());
                            int z=0;
                            while(z<liabEqui.nonCurrentLiabilities().size()){

                            this.setBodyList( liabEqui.nonCurrentLiabilities().get(z));
                            z++;
                            }
                            this.setBodyList( totalNonCurrentLiabilities());
                            this.setBodyList(this.totalLiabilities());

                            if(!isEquityEmpty()){
                            this.setBodyList( liabEqui.equityTitle());
                            int jk=0;
                            while(jk<liabEqui.equity().size()){
                            this.setBodyList( liabEqui.equity().get(jk));
                            jk++;
                            }
                            this.setBodyList( totalEquity());
                            this.setBodyList(this.totalLiabilitiesEquity());
                            }
                            }else if(!isEquityEmpty()){
                            this.setBodyList( liabEqui.equityTitle());
                            int jk=0;
                            while(jk<liabEqui.equity().size()){
                            this.setBodyList( liabEqui.equity().get(jk));
                            jk++;
                            }
                            this.setBodyList(totalEquity());
                            this.setBodyList(this.totalLiabilitiesEquity());
                            }

}
                            }

                            }else  if(!isNonCurrentAssetsEmpty()){

                            this.setBodyList(asset.nonCurrentAssetTitle());
                            int p=0;

                            while(p<asset.nonCurrentAssets().size()){

                            this.setBodyList(asset.nonCurrentAssets().get(p));
                            p++;
                            }
                            this.setBodyList(totalNonCurrentAssets());
                            
                            
                            this.setBodyList(this.totalAssets());


                            if(!isLiabilitiesEmpty()){

                            this.setBodyList(liabEqui.mainLiabilitiesEquityTitle());

                            if(!isCurrentLiabilityEmpty()){

                            this.setBodyList( liabEqui.currentLiabilitiesTitle());
                            int y=0;     
                            while(y<liabEqui.currentLiabilities().size()){

                            this.setBodyList(liabEqui.currentLiabilities().get(y));
                            y++;
                            }
                            this.setBodyList(totalCurrentLiabilities());
                            if(!isNonCurrentLiabilityEmpty()){

                            this.setBodyList(liabEqui.nonCurrentLiabilitiesTitle());
                            int z=0;
                            while(z<liabEqui.nonCurrentLiabilities().size()){

                            this.setBodyList( liabEqui.nonCurrentLiabilities().get(z));
                            z++;
                            }
                            this.setBodyList(totalNonCurrentLiabilities());
                            this.setBodyList(this.totalLiabilities());

                            if(!isEquityEmpty()){
                            this.setBodyList( liabEqui.equityTitle());
                            int jk=0;
                            while(jk<liabEqui.equity().size()){
                            this.setBodyList( liabEqui.equity().get(jk));
                            jk++;
                            }
                            this.setBodyList( totalEquity());
                            this.setBodyList(this.totalLiabilitiesEquity());
                            }
                            }else{
                            if(!isEquityEmpty()){
                            this.setBodyList( liabEqui.equityTitle());
                            int jk=0;
                            while(jk<liabEqui.equity().size()){
                            this.setBodyList( liabEqui.equity().get(jk));
                            jk++;
                            }
                            this.setBodyList( totalEquity());
                            this.setBodyList(this.totalLiabilitiesEquity());
                            }

                            }

                            }else if(!isNonCurrentLiabilityEmpty()){



                            this.setBodyList(liabEqui.nonCurrentLiabilitiesTitle());
                            int z=0;
                            while(z<liabEqui.nonCurrentLiabilities().size()){

                            this.setBodyList( liabEqui.nonCurrentLiabilities().get(z));
                            z++;
                            }
                            this.setBodyList(totalNonCurrentLiabilities());
                            this.setBodyList(this.totalLiabilities());

                            if(!isEquityEmpty()){
                            this.setBodyList( liabEqui.equityTitle());
                            int jk=0;
                            while(jk<liabEqui.equity().size()){
                            this.setBodyList( liabEqui.equity().get(jk));
                            jk++;
                            }
                            this.setBodyList( totalEquity());
                            this.setBodyList(this.totalLiabilitiesEquity());
                            }

                            }else if(!isEquityEmpty()){

                            this.setBodyList( liabEqui.equityTitle());
                            int jk=0;
                            while(jk<liabEqui.equity().size()){
                            this.setBodyList( liabEqui.equity().get(jk));
                            jk++;
                            }
                            this.setBodyList( totalEquity());
                            this.setBodyList(this.totalLiabilitiesEquity());

                            }}   }



                            }
                            else if(!isLiabilitiesEmpty()){

                            this.setBodyList(liabEqui.mainLiabilitiesEquityTitle());

                            if(!isCurrentLiabilityEmpty()){
                            this.setBodyList(liabEqui.currentLiabilitiesTitle());
                            int y=0;     
                            while(y<liabEqui.currentLiabilities().size()){

                            this.setBodyList(liabEqui.currentLiabilities().get(y));
                            y++;
                            }
                            this.setBodyList(totalCurrentLiabilities());


                            if(!isNonCurrentLiabilityEmpty()){

                            this.setBodyList(liabEqui.nonCurrentLiabilitiesTitle());
                            int z=0;
                            while(z<liabEqui.nonCurrentLiabilities().size()){

                            this.setBodyList( liabEqui.nonCurrentLiabilities().get(z));
                            z++;
                            }
                            this.setBodyList(totalNonCurrentLiabilities());

                            this.setBodyList(this.totalLiabilities());

                            if(!isEquityEmpty()){
                            this.setBodyList( liabEqui.equityTitle());
                            int jk=0;
                            while(jk<liabEqui.equity().size()){
                            this.setBodyList( liabEqui.equity().get(jk));
                            jk++;
                            }
                            this.setBodyList( totalEquity());
                            this.setBodyList(this.totalLiabilitiesEquity());
                            }


                            }else{
                            if(!isEquityEmpty()){
                            this.setBodyList( liabEqui.equityTitle());
                            int jk=0;
                            while(jk<liabEqui.equity().size()){
                            this.setBodyList( liabEqui.equity().get(jk));
                            jk++;
                            }
                            this.setBodyList( totalEquity());
                            this.setBodyList(this.totalLiabilitiesEquity());
                            }


                            }
                            }else if(!isNonCurrentLiabilityEmpty()){

                            this.setBodyList(liabEqui.nonCurrentLiabilitiesTitle());
                            int z=0;
                            while(z<liabEqui.nonCurrentLiabilities().size()){

                            this.setBodyList( liabEqui.nonCurrentLiabilities().get(z));
                            z++;
                            }
                            this.setBodyList(totalNonCurrentLiabilities());

                            this.setBodyList(this.totalLiabilities());

                            if(!isEquityEmpty()){
                            this.setBodyList( liabEqui.equityTitle());
                            int jk=0;
                            while(jk<liabEqui.equity().size()){
                            this.setBodyList( liabEqui.equity().get(jk));
                            jk++;
                            }
                            this.setBodyList( totalEquity());
                            this.setBodyList(this.totalLiabilitiesEquity());
                            }

                            } else if(!isEquityEmpty()){

                            this.setBodyList( liabEqui.equityTitle());
                            int jk=0;
                            while(jk<liabEqui.equity().size()){
                            this.setBodyList( liabEqui.equity().get(jk));
                            jk++;
                            }
                            this.setBodyList(totalEquity());
                            this.setBodyList(this.totalLiabilitiesEquity());
                            }


                            }
                            else{

                            bs=false;    
                            }



                              if(bs){


                            model1= new ListDataModel( getBodyList(), getTableHeaders());
                           

                       return model1;
                              }

                            return model1;
                            }
                           private List totalLiabilitiesEquity(){
                        
                           LiabilityEquityAccounts liabEqui=LiabilityEquityAccounts.assetProducer(materialDates);
                            List amount1=bUtility.totalSummation(liabEqui.equity(), new ArrayList());

                            List amount2=bUtility.totalSummation(liabEqui.currentLiabilities(), liabEqui.nonCurrentLiabilities());

                            List totaLiabilitiesEquity=new ArrayList();

                            totaLiabilitiesEquity.add("Total liabilities and equity");
                            totaLiabilitiesEquity.add("");
                            
                            if(amount1.get(0).toString().equals("-")&&amount2.get(0).toString().equals("-")){
                             totaLiabilitiesEquity.add("-");
                             }else if(amount1.get(0).toString().equals("-")){
                              totaLiabilitiesEquity.add(amount2.get(0).toString());
                             
                             }else if(amount2.get(0).toString().equals("-")){
                             totaLiabilitiesEquity.add(amount1.get(0).toString());
                             }else{
                            
                                
                            totaLiabilitiesEquity.add((parseDouble(amount1.get(0).toString())+parseDouble(amount2.get(0).toString())));
                            }
     
                            
//                            totaLiabilitiesEquity.add((parseDouble(amount1.get(0).toString())+parseDouble(amount2.get(0).toString())));
                            
                             if(amount1.get(1).toString().equals("-")||amount1.get(1).toString().equals("-")){
                             totaLiabilitiesEquity.add("-");
                             }else{
                            totaLiabilitiesEquity.add((parseDouble(amount1.get(1).toString())+parseDouble(amount2.get(1).toString())));
                            }
                            

                            return   totaLiabilitiesEquity;


                            }


                            private List totalLiabilities(){

     LiabilityEquityAccounts liabEqui=LiabilityEquityAccounts.assetProducer(materialDates);
                            List tatoLiabi=new ArrayList();

                            List amount=bUtility.totalSummation(liabEqui.currentLiabilities(), liabEqui.nonCurrentLiabilities());
                            tatoLiabi.add("Total liabilities");
                            tatoLiabi.add("");
                            tatoLiabi.add(amount.get(0));
                            tatoLiabi.add(amount.get(1));

                            return   tatoLiabi;

                            }

                            private List totalEquity(){


     LiabilityEquityAccounts liabEqui=LiabilityEquityAccounts.assetProducer(materialDates);
                            List totaequity=new ArrayList();

                            List amount=bUtility.totalSummation(liabEqui.equity(), new ArrayList());
                            totaequity.add("Total equity");
                            totaequity.add("");
                            totaequity.add(amount.get(0));
                            totaequity.add(amount.get(1));

                            return   totaequity;

                            }

                            private List totalNonCurrentLiabilities(){


     LiabilityEquityAccounts liabEqui=LiabilityEquityAccounts.assetProducer(materialDates);
                            List totalNonCurrentLiabilities=new ArrayList();

                            List amount=bUtility.totalSummation(liabEqui.nonCurrentLiabilities(), new ArrayList());
                            totalNonCurrentLiabilities.add("Total non-current liabilities");
                            totalNonCurrentLiabilities.add("");
                            totalNonCurrentLiabilities.add(amount.get(0));
                            totalNonCurrentLiabilities.add(amount.get(1));

                            return   totalNonCurrentLiabilities;

                            }
                            private List totalCurrentLiabilities(){

     LiabilityEquityAccounts liabEqui=LiabilityEquityAccounts.assetProducer(materialDates);

                            List totalCurrentLiabilities=new ArrayList();

                            List amount=bUtility.totalSummation(liabEqui.currentLiabilities(), new ArrayList());
                            totalCurrentLiabilities.add("Total current liabilities");
                            totalCurrentLiabilities.add("");
                            totalCurrentLiabilities.add(amount.get(0));
                            totalCurrentLiabilities.add(amount.get(1));

                            return   totalCurrentLiabilities;

                            }

                         
                            
                             private List totalAssets(){
                    AssetAccount asset=AssetAccount.assetProducer(materialDates);
               
                            List tatoAsset=new ArrayList();

                            List amount=bUtility.totalSummation(asset.currentAssets(), asset.nonCurrentAssets());

                            tatoAsset.add("Total assets");
                            tatoAsset.add("");
                            tatoAsset.add(amount.get(0));
                            tatoAsset.add(amount.get(1));

                            return   tatoAsset;


                            }
                            public List totalCurrentAssets(){
                              
                                AssetAccount asset=AssetAccount.assetProducer(materialDates);
  
                            List currentAssets =new ArrayList();
                            List amount1=bUtility.totalSummation(asset.currentAssets(), new ArrayList());
                            currentAssets.add("Total current assets");
                            currentAssets.add("");
                            currentAssets.add(amount1.get(0));
                            currentAssets.add(amount1.get(1));
                            return currentAssets;
                            }


                            public List  totalNonCurrentAssets(){
                                
                                AssetAccount asset= AssetAccount.assetProducer(materialDates);
   
                            List nonCurrentAssets =new ArrayList();

                            List amount1=bUtility.totalSummation(asset.nonCurrentAssets(), new ArrayList());
                            
                            nonCurrentAssets.add("Total non-current assets");
                            nonCurrentAssets.add("");
                            nonCurrentAssets.add(amount1.get(0));
                            nonCurrentAssets.add(amount1.get(1));
                            return nonCurrentAssets;
                            }
                            public boolean isAssetsEmpty(){
                                AssetAccount asset=AssetAccount.assetProducer(materialDates);
     
                            boolean assetIsEmpty=false;
                            if(asset.currentAssets().isEmpty()&&asset.nonCurrentAssets().isEmpty()){
                            assetIsEmpty=true;
                            }

                            return assetIsEmpty;
                            }
                            public boolean isCurrentAssetsEmpty(){
                                AssetAccount asset=AssetAccount.assetProducer(materialDates);
 
                            boolean currentAssetIsEmpty=false;
                            if(asset.currentAssets().isEmpty()){
                            currentAssetIsEmpty=true;

                            }

                            return currentAssetIsEmpty;
                            }
                            public boolean isNonCurrentAssetsEmpty(){
                                AssetAccount asset=AssetAccount.assetProducer(materialDates);
 
                            boolean nonCurrentAssetIsEmpty=false;
                            if(asset.nonCurrentAssets().isEmpty()){
                            nonCurrentAssetIsEmpty=true;

                            }

                            return nonCurrentAssetIsEmpty;
                            }

                            public boolean isEquityEmpty(){

                            LiabilityEquityAccounts liabEqui=LiabilityEquityAccounts.assetProducer(materialDates);
                            
                            boolean equityIsEmpty=false;
                            if(liabEqui.equity().isEmpty()){

                            equityIsEmpty=true;
                            }

                            return equityIsEmpty;
                            }
                            public boolean isLiabilitiesEmpty(){
                                
                            boolean liabilityIsEmpty=false;

                            LiabilityEquityAccounts liabEqui=LiabilityEquityAccounts.assetProducer(materialDates); 
                            
                            if((liabEqui.currentLiabilities().isEmpty()&&liabEqui.nonCurrentLiabilities().isEmpty()&&liabEqui.equity().isEmpty())){
                            liabilityIsEmpty=true;
                            }

                            return liabilityIsEmpty;
                            }
                            public boolean isCurrentLiabilityEmpty(){

                            LiabilityEquityAccounts liabEqui=LiabilityEquityAccounts.assetProducer(materialDates);                     
                            boolean currentLiabilityIsEmpty=false;
                            if(liabEqui.currentLiabilities().isEmpty()){

                            currentLiabilityIsEmpty=true;
                            }


                            return currentLiabilityIsEmpty;
                            }
                            public boolean isNonCurrentLiabilityEmpty(){

                            LiabilityEquityAccounts liabEqui=LiabilityEquityAccounts.assetProducer(materialDates);                    
                            boolean nonCurrentLiabilityIsEmpty=false;
                            if(liabEqui.nonCurrentLiabilities().isEmpty()){

                            nonCurrentLiabilityIsEmpty=true;
                            }

                            return nonCurrentLiabilityIsEmpty;
                            }

                            

    @Override
    public String getTitle(String date) {
        return title;
    }

    @Override
    public List<String> getTableHeaders() {
        tableHeaders.add(null);
           tableHeaders.add(null);
              tableHeaders.add(null);
                 tableHeaders.add(null);
                 
       return tableHeaders;
    }

    @Override
    public List<List<Object>> getBodyList() {
       return dataBody;
    }

    @Override
    public Map<Integer, List<Object>> getBodyMap() {
        return data;
    }

    @Override
    public void setTitle(String title) {
       this.title=title;
    }

    @Override
    public void setTableHeader(String header) {
        tableHeaders.add(header);
    }

    @Override
    public void setBodyList(List body) {
        dataBody.add(body);
    }

    @Override
    public void setBodyMap(Integer index, List<Object> body) {
        data.put(index, body);
    }

  
    

}
