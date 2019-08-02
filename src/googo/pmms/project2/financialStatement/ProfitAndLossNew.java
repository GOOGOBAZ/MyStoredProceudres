/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googo.pmms.project2.financialStatement;

import googo.pmms.project2.accountsHelper.Formartter;
import googo.pmms.project2.accountsHelper.fileInputOutPutStreams;
import googo.pmms.project2.frameHelper.ListDataModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author SSRN
 */
public class ProfitAndLossNew implements BalanceSheet {
    
    Formartter ffm=new Formartter();
String materialDates1,materialDates2;
    fileInputOutPutStreams fios= new fileInputOutPutStreams();
    ListDataModel model1;
String title;
    List<String> tableHeaders=new ArrayList();
    List< List<Object>> dataBody=new ArrayList();
     
     Map<Integer, List<Object>> data=new HashMap();
     
     
   BalanceSheetUtility bUtility=new BalanceSheetUtility();  
             
    public ProfitAndLossNew(List materialDate){
    materialDates1=ffm.forDatabaseWithFullYearBeginningWithDate(materialDate.get(0).toString());
    materialDates2=ffm.forDatabaseWithFullYearBeginningWithDate(materialDate.get(1).toString());
    }
    



                        public ListDataModel createProfitAndLoss(){
                            
                        this.setBodyList(bUtility.comperativePeriodTitles(materialDates2, "Year"));
                        
                        IncomeAccounts income=IncomeAccounts.incomeProducer(materialDates1,materialDates2);

                        ExpensesAccounts expense=ExpensesAccounts.expenseProducer(materialDates1,materialDates2);

                        boolean bs=true;

                        if(!this.isIncomeEmpty()){

                        this.setBodyList(income.revenueTitle());


                        if(!isMainIncomeEmpty()){  

//                        this.setBodyList(income.mainIncomeTitle());
                        int t=0;
                        while(t<income.mainIncome().size()){

                        this.setBodyList(income.mainIncome().get(t));
                        
                        t++;
                        }
//                            this.setBodyList(totalMainIncome());

                            if(!isOtheIncomeEmpty()){

//                            this.setBodyList(income.otherIncomeTitle());

                            int p=0;

                            while(p<income.otherIncomes().size()){

                            this.setBodyList(income.otherIncomes().get(p));
                            p++;
                            }

//                            this.setBodyList(totalOtherIncome());

                            this.setBodyList(this.totalAllIncome());
//
                            if(!isExpenseEmpty()){ 

                            this.setBodyList(expense.expenseTitle());

                            if(!isExpensesEmpty()){
                            int y=0;     
                            while(y<expense.expensesDeclared().size()){

                            this.setBodyList(expense.expensesDeclared().get(y));
                            y++;
                            }
                            this.setBodyList(totalExpenses());
} } } }else{
                 
                            if(!isOtheIncomeEmpty()){

//                            this.setBodyList(income.otherIncomeTitle());

                            int p=0;

                            while(p<income.otherIncomes().size()){

                            this.setBodyList(income.otherIncomes().get(p));
                            p++;
                            }

//                            this.setBodyList(totalOtherIncome());

                            this.setBodyList(this.totalAllIncome());
//
                            if(!isExpenseEmpty()){ 

                            this.setBodyList(expense.expenseTitle());

                            if(!isExpensesEmpty()){
                            int y=0;     
                            while(y<expense.expensesDeclared().size()){

                            this.setBodyList(expense.expensesDeclared().get(y));
                            y++;
                            }
                            this.setBodyList(totalExpenses());
} } }       
                        
                        }
                     this.setBodyList(profitBeforeTax());
                       
                            if(!isIncomeTaxEmpty()){
                                
                           this.setBodyList( expense.incomeTaxE().get(0));
                             this.setBodyList(profitForTheYear());
                            }
                            
                            
                            if(!isRetainedEarningStartYearEmpty()){
                            
                             this.setBodyList( expense.retainedEarningY().get(0));
                            }
                          
                            
                             if(!isRestatementRetainedErrorsEmpty()){
                            
                             this.setBodyList( expense.periodErrorS().get(0));
                            }
                             
                             
                             if(!isRestatementRetainedAccountPriEmpty()){
                            
                             this.setBodyList( expense.periodAccountPolicy().get(0));
                            }
                             
                             
                             if(!isDevidendPaidEmpty()){
                            
                             this.setBodyList( expense.devidendsPaidInAyear().get(0));
                            }
                             
                            this.setBodyList(retainedEarningsAtEndYear());    
                        
                        
                        }else if(!isExpenseEmpty()){ 

                            this.setBodyList(expense.expenseTitle());

                            if(!isExpensesEmpty()){
                            int y=0;     
                            while(y<expense.expensesDeclared().size()){

                            this.setBodyList(expense.expensesDeclared().get(y));
                            y++;
                            }
//                            this.setBodyList(totalExpenses());

                            } 
                
                     this.setBodyList(profitBeforeTax());
                       
                            if(!isIncomeTaxEmpty()){
                                
                           this.setBodyList( expense.incomeTaxE().get(0));
                             this.setBodyList(profitForTheYear());
                            }
                            
                            
                            if(!isRetainedEarningStartYearEmpty()){
                            
                             this.setBodyList( expense.retainedEarningY().get(0));
                            }
                          
                            
                             if(!isRestatementRetainedErrorsEmpty()){
                            
                             this.setBodyList( expense.periodErrorS().get(0));
                            }
                             
                             
                             if(!isRestatementRetainedAccountPriEmpty()){
                            
                             this.setBodyList( expense.periodAccountPolicy().get(0));
                            }
                             
                             
                             if(!isDevidendPaidEmpty()){
                            
                             this.setBodyList( expense.devidendsPaidInAyear().get(0));
                            }
                             
                            this.setBodyList(retainedEarningsAtEndYear());  
                        
                        
                        
                        }else{

                            bs=false;    
                            }


                              if(bs){


                            model1= new ListDataModel( getBodyList(), getTableHeaders());
                           

                       return model1;
                              }

                            return model1;
                            }

                           private List profitForTheYear(){
                        List<List<Object>> totalIncome=new ArrayList();
                        List<List<Object>> totalExpenses=new ArrayList();
                           ExpensesAccounts expense=ExpensesAccounts.expenseProducer(materialDates1,materialDates2); 
                           
                             IncomeAccounts income=IncomeAccounts.incomeProducer(materialDates1,materialDates2);
                             
                           totalIncome.addAll( income.mainIncome());
                            totalIncome.addAll( income.otherIncomes());
                            
                            
                            totalExpenses.addAll(expense.expensesDeclared());
                             totalExpenses.addAll(expense.incomeTaxE());
                  
                             List profitForYear=new ArrayList();
                            List amount=bUtility.diffTwoNumbers(totalIncome,  totalExpenses);
                            profitForYear.add("Profit for the period");
                            profitForYear.add("");
                            profitForYear.add(amount.get(0));
                            profitForYear.add(amount.get(1));

                            return   profitForYear;

                            }


                            private List profitBeforeTax(){
List<List<Object>> totalIncome=new ArrayList();

     ExpensesAccounts expense=ExpensesAccounts.expenseProducer(materialDates1,materialDates2); 
     IncomeAccounts income=IncomeAccounts.incomeProducer(materialDates1,materialDates2);
     totalIncome.addAll( income.mainIncome());
        totalIncome.addAll(income.otherIncomes());
                            List totalPBTax=new ArrayList();
//                            fios.stringFileWriter(fios.createFileName("test", "testit", "trdyr.txt"),expense.expensesDeclared().size()+"");
                            List amount=bUtility.diffTwoNumbers(totalIncome, expense.expensesDeclared());
                            totalPBTax.add("Profit before tax");
                            totalPBTax.add("");
                            totalPBTax.add(amount.get(0));
                            totalPBTax.add(amount.get(1));

                            return   totalPBTax;

                            }

                            
                            
                   

                            private List retainedEarningsAtEndYear(){
List<List<Object>> retainedInTotalIncome=new ArrayList();
List<List<Object>> retainedInTotalExpenses=new ArrayList();
 ExpensesAccounts expense=ExpensesAccounts.expenseProducer(materialDates1,materialDates2); 
     IncomeAccounts income=IncomeAccounts.incomeProducer(materialDates1,materialDates2);
                            List retainEndYear=new ArrayList();
                            retainedInTotalIncome.addAll(income.mainIncome());
                             retainedInTotalIncome.addAll(income.otherIncomes());
                                 
                        retainedInTotalExpenses.addAll(expense.expensesDeclared());
                         retainedInTotalExpenses.addAll(expense.incomeTaxE());
                        retainedInTotalExpenses.addAll(expense.retainedEarningY());
                       retainedInTotalExpenses.addAll(expense.periodErrorS());
                        retainedInTotalExpenses.addAll(expense.periodAccountPolicy());
                        retainedInTotalExpenses.addAll(expense.devidendsPaidInAyear());
                   
                            List amount=bUtility.diffTwoNumbers(retainedInTotalIncome, retainedInTotalExpenses);
                            retainEndYear.add("Retained earnings at end of Period");
                            retainEndYear.add("");
                            retainEndYear.add(amount.get(0));
                            retainEndYear.add(amount.get(1));

                            return   retainEndYear;

                            }
                            private List totalExpenses(){

      ExpensesAccounts expense=ExpensesAccounts.expenseProducer(materialDates1,materialDates2); 

                            List totalExpenses=new ArrayList();

                            List amount=bUtility.totalSummation(expense.expensesDeclared(), new ArrayList());
                            totalExpenses.add("Total Expenses");
                            totalExpenses.add("");
                            totalExpenses.add(amount.get(0));
                            totalExpenses.add(amount.get(1));

                            return   totalExpenses;

                            }

                         
                            
                             private List totalAllIncome(){
                       IncomeAccounts income=IncomeAccounts.incomeProducer(materialDates1,materialDates2);
               
                            List tatoAsset=new ArrayList();

                            List amount=bUtility.totalSummation(income.mainIncome(), income.otherIncomes());

                            tatoAsset.add("Total Income");
                            tatoAsset.add("");
                            tatoAsset.add(amount.get(0));
                            tatoAsset.add(amount.get(1));

                            return   tatoAsset;


                            }
                            public List totalMainIncome(){
                              
                             IncomeAccounts income=IncomeAccounts.incomeProducer(materialDates1,materialDates2);
  
                            List mainIncome =new ArrayList();
                            List amount1=bUtility.totalSummation(income.mainIncome(), new ArrayList());
                            mainIncome.add("Total Main Income");
                            mainIncome.add("");
                            mainIncome.add(amount1.get(0));
                            mainIncome.add(amount1.get(1));
                            return mainIncome;
                            }


                            public List  totalOtherIncome(){
                             IncomeAccounts income=IncomeAccounts.incomeProducer(materialDates1,materialDates2);
   
                            List otherIncome=new ArrayList();

                            List amount1=bUtility.totalSummation(income.otherIncomes(), new ArrayList());
                            otherIncome.add("Total OtherIncome");
                            otherIncome.add("");
                            otherIncome.add(amount1.get(0));
                            otherIncome.add(amount1.get(1));
                            return otherIncome;
                            }
                            public boolean isIncomeEmpty(){
                                IncomeAccounts income=IncomeAccounts.incomeProducer(materialDates1,materialDates2);
     
                            boolean incomeIsEmpty=false;
                            if(income.mainIncome().isEmpty()&&income.otherIncomes().isEmpty()){
                            incomeIsEmpty=true;
                            }

                            return incomeIsEmpty;
                            }
                            public boolean isMainIncomeEmpty(){
                            IncomeAccounts income=IncomeAccounts.incomeProducer(materialDates1,materialDates2);
 
                            boolean mainIncomeIsEmpty=false;
                            if(income.mainIncome().isEmpty()){
                            mainIncomeIsEmpty=true;

                            }

                            return mainIncomeIsEmpty;
                            }
                            public boolean isOtheIncomeEmpty(){
                                 IncomeAccounts income=IncomeAccounts.incomeProducer(materialDates1,materialDates2);
 
                            boolean otherIncomeIsEmpty=false;
                            if(income.otherIncomes().isEmpty()){
                            otherIncomeIsEmpty=true;

                            }

                            return otherIncomeIsEmpty;
                            }

                            public boolean isRetainedEarningStartYearEmpty(){

                           ExpensesAccounts expense=ExpensesAccounts.expenseProducer(materialDates1,materialDates2); 
                            
                            boolean retainedEarningsIsEmpty=false;
                            if(expense.retainedEarningY().isEmpty()){

                            retainedEarningsIsEmpty=true;
                            }

                            return retainedEarningsIsEmpty;
                            }
                            public boolean isExpenseEmpty(){
                                
                            boolean expenseIsEmpty=false;

                            ExpensesAccounts expense=ExpensesAccounts.expenseProducer(materialDates1,materialDates2); 
                            
                            if((expense.expensesDeclared().isEmpty()&&expense.devidendsPaidInAyear().isEmpty()&&expense.incomeTaxE().isEmpty()&&expense.periodAccountPolicy().isEmpty()&&expense.periodErrorS().isEmpty()&&expense.retainedEarningY().isEmpty())){
                            expenseIsEmpty=true;
                            }

                            return expenseIsEmpty;
                            }
                            public boolean isExpensesEmpty(){

                          ExpensesAccounts expense=ExpensesAccounts.expenseProducer(materialDates1,materialDates2);                    
                            boolean expenseIsEmpty=false;
                            if(expense.expensesDeclared().isEmpty()){

                            expenseIsEmpty=true;
                            }


                            return expenseIsEmpty;
                            }
                            
                            
                            
                            public boolean isIncomeTaxEmpty(){

                           ExpensesAccounts expense=ExpensesAccounts.expenseProducer(materialDates1,materialDates2);  
                           
                            boolean incomeTaxIsEmpty=false;
                            
                            if(expense.incomeTaxE().isEmpty()){

                            incomeTaxIsEmpty=true;
                            }

                            return incomeTaxIsEmpty;
                            }
                       public boolean isRestatementRetainedErrorsEmpty(){

                           ExpensesAccounts expense=ExpensesAccounts.expenseProducer(materialDates1,materialDates2);  
                           
                            boolean ErrorRestatmentTaxIsEmpty=false;
                            
                            if(expense.periodErrorS().isEmpty()){

                            ErrorRestatmentTaxIsEmpty=true;
                            }

                            return ErrorRestatmentTaxIsEmpty;
                            }
                           public boolean isRestatementRetainedAccountPriEmpty(){

                           ExpensesAccounts expense=ExpensesAccounts.expenseProducer(materialDates1,materialDates2);  
                           
                            boolean accountPrincePriEmpty=false;
                            
                            if(expense.periodErrorS().isEmpty()){

                            accountPrincePriEmpty=true;
                            }

                            return accountPrincePriEmpty;
                            }
                
                 
                  public boolean isDevidendPaidEmpty(){

                           ExpensesAccounts expense=ExpensesAccounts.expenseProducer(materialDates1,materialDates2);  
                           
                            boolean isdevidendsPaid=false;
                            
                            if(expense.devidendsPaidInAyear().isEmpty()){

                            isdevidendsPaid=true;
                            }

                            return isdevidendsPaid;
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
