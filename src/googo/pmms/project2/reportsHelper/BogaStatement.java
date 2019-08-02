/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googo.pmms.project2.reportsHelper;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import static com.itextpdf.text.Rectangle.BOTTOM;
import static com.itextpdf.text.Rectangle.LEFT;
import static com.itextpdf.text.Rectangle.RIGHT;
import static com.itextpdf.text.Rectangle.TOP;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEvent;
import com.itextpdf.text.pdf.PdfWriter;
import googo.pmms.project2.accountsHelper.Formartter;
import googo.pmms.project2.accountsHelper.fileInputOutPutStreams;
import googo.pmms.project2.databases.DatabaseQuaries;
import googo.pmms.project2.databaseConnectors.JdbcConnector;
import googo.pmms.project2.databases.ReportsDatabase;
import googo.pmms.project2.frameHelper.MyTableModel;
import googo.pmms.project2.frames.PostingEntryWindow;
import googo.pmms.project2.loanHelper.Amortization;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Stanchart
 */
public class BogaStatement implements PdfPageEvent {

//     Amortization amortize = new Amortization();

     Calendar calN = Calendar.getInstance();
  ReportsDatabase getdata = new ReportsDatabase();  
fileInputOutPutStreams fios= new fileInputOutPutStreams();
    Formartter ffm= new Formartter();
    Date Trndate,valuedate;
   ArrayList<String> data4, column1;
 ArrayList<ArrayList<String>> data5;
          JOptionPane p;
     MyTableModel model;
    Date date;
  SimpleDateFormat df;
  String text;
  int realMonth, otherMonth;
   String dates, dates2,getFieldValue,actualFieldValue,  jTFuserId1mt,today,thistime,today1,newDate1,jTFuserId1mt1,newDate11,today2;
   Integer Value,Value1;
   double newbalance,ledgerBalance,creditamount;
    GregorianCalendar cal = new GregorianCalendar(); 
      JdbcConnector csx = new JdbcConnector(fios.stringFileReader(fios.createFileName("emailDetails", "sendMail", "AccountDBDetails.txt"))); 
    DatabaseQuaries quaries =new DatabaseQuaries();
    Formartter format = new Formartter();
ReportsDatabase rdb = new ReportsDatabase();
 int   pagenumber=0;

    DecimalFormat NumberFormatS =new DecimalFormat("#.##");
     String userId;
public void setUserID(String userid){
this.userId=userid;
}
      public boolean createBogaStatement(String fileName) { 
     
  boolean BogaStatement=false;
     
  
  if(fios.exitsFile(fios.createFileName("PMMS_Statements", "PMMS_Statements1", fileName+".pdf"))){
  if(fios.deleteFileFirst(fios.createFileName("PMMS_Statements", "PMMS_Statements1", fileName+".pdf"))){
createActuallyBogaStatement(fileName);
BogaStatement=true;
  } 
    
  }else{
createActuallyBogaStatement(fileName);
BogaStatement=true;
  }
      
      return BogaStatement;
       }
  
      private void createActuallyBogaStatement(String fileName1){

      
       String fileName="",accountName="";
 
      try {
          
          
          Paragraph headerz =createHeading();
          headerz.setIndentationLeft(50);
          headerz.setIndentationRight(50);
         
          
          
          Document document = new Document(PageSize.A3, 45f, 36f, 54f, 72f);
          PdfWriter writer=PdfWriter.getInstance(document, fios.FileOutputStream(fios.createFileName("PMMS_Statements", "PMMS_Statements1", fileName1+".pdf")));
          PdfPTable body= createBogaTable();
          Font font1 = new Font(Font.FontFamily.COURIER  , 14, Font.NORMAL);
          writer.setPageEvent(this);
          document.open();
          
          String BoxN=fios.stringFileReader(fios.createFileName("emailDetails", "sendMail", "boxNumber.txt"));
          Paragraph ct= new Paragraph("P.O BOX"+"\n"+BoxN.split("[,]", 3)[0]+"\n"+"Tel:"+BoxN.split("[,]", 3)[1]+"\n\t"+"    "+BoxN.split("[,]", 3)[2],font1);
          ct.setIndentationLeft(50f);
          ct.setIndentationRight(200f);
          document.add(ct);
          
          String name = accountName;
          String[] words = name.split("\\s");
          Image image1 = Image.getInstance("strawberry3.jpg");
          image1.setAbsolutePosition(49f, 1080f);
          image1.scaleAbsolute(43f, 43f);
          document.add(image1);
          document.add(headerz );
          document.add(new Paragraph("  ") );
          Paragraph currency= new Paragraph("CURRENCY UGANDA SHILLINGS",font1);
          currency.setIndentationLeft(280f);
          currency.setIndentationRight(30f);
          document.add( currency);
          document.add(new Paragraph("  ") );
          document.add( body);
          document.add(new Paragraph("  ") );
          document.add(new Paragraph("  ") );
           document.add(new Paragraph("  ") );
    document.add(new Paragraph("  ") );
    document.add(this.createFooter());
            document.newPage();
          document.close();
         
         
      } catch (BadElementException ex) {
          Logger.getLogger(ReportsPDFFormulars.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IOException | DocumentException ex) {
          Logger.getLogger(ReportsPDFFormulars.class.getName()).log(Level.SEVERE, null, ex);
      }
    
       }
       
      public  PdfPTable createBogaTable(){
       PdfPTable table = new PdfPTable(7);
       table.setWidthPercentage(100);
       float[] columnWidths = {10f, 100f, 35f, 75f,75f,75f,15f};
       /*  table.setFooterRows(5);*/
       Font font1 = new Font(Font.FontFamily.COURIER  , 14, Font.NORMAL);
       Font font2 = new Font(Font.FontFamily.COURIER  , 14, Font.BOLD);
       
    try {
        table.setWidths(columnWidths);
        
    } catch (DocumentException ex) {
        Logger.getLogger(PostingEntryWindow.class.getName()).log(Level.SEVERE, null, ex);
    }
            PdfPCell cell1 = new PdfPCell(new Paragraph("S/N",font2));
            PdfPCell cell2 = new PdfPCell(new Paragraph("A/C Name",font2));
            PdfPCell cell3 = new PdfPCell(new Paragraph("NO_Shares",font2));
            PdfPCell cell4 = new PdfPCell(new Paragraph("V_Shares",font2));
            PdfPCell cell5 = new PdfPCell(new Paragraph("B_Qualified",font2)); 
            PdfPCell cell6 = new PdfPCell(new Paragraph("G_Qualified",font2)); 
            PdfPCell cell7 = new PdfPCell(new Paragraph("B_Status",font2));
           cell1.setBackgroundColor(BaseColor.CYAN);   //sets BG color to yellow.
           cell2.setBackgroundColor(BaseColor.CYAN); 
           cell3.setBackgroundColor(BaseColor.CYAN); 
           cell4.setBackgroundColor(BaseColor.CYAN); 
           cell5.setBackgroundColor(BaseColor.CYAN); 
           cell6.setBackgroundColor(BaseColor.CYAN); 
           cell7.setBackgroundColor(BaseColor.CYAN);
             

           cell1.setBorderWidth (2f);         // sets border width to 3 units
           cell2.setBorderWidth (2f);
           cell3.setBorderWidth (2f);
           cell4.setBorderWidth (2f);
           cell5.setBorderWidth (2f);
           cell6.setBorderWidth (2f);
           cell7.setBorderWidth (2f);
            
        
           
           
           cell1 .disableBorderSide(LEFT);         // sets border width to 3 units
           cell2 .disableBorderSide(LEFT);
           cell3 .disableBorderSide(LEFT);
           cell4 .disableBorderSide(LEFT);
           cell5 .disableBorderSide(LEFT);
           cell6 .disableBorderSide(LEFT);
           cell7 .disableBorderSide(LEFT);
           
           
           cell1 .disableBorderSide(TOP);       // sets border width to 3 units
           cell2.disableBorderSide(TOP); 
           cell3.disableBorderSide(TOP); 
           cell4.disableBorderSide(TOP); 
           cell5.disableBorderSide(TOP); 
           cell6.disableBorderSide(TOP); 
           cell7.disableBorderSide(TOP); 
           
           cell1.disableBorderSide(RIGHT);         // sets border width to 3 units
           cell2.disableBorderSide(RIGHT); 
           cell3.disableBorderSide(RIGHT); 
           cell4.disableBorderSide(RIGHT); 
           cell5.disableBorderSide(RIGHT); 
            cell6.disableBorderSide(RIGHT); 
           cell7.disableBorderSide(RIGHT); 
      
            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            table.addCell(cell5);
            table.addCell(cell6);
            table.addCell(cell7);
    
          int n=0; Map<Integer, List<Object>> dataBase=rdb.bogaEntries();
          
           if(!dataBase.isEmpty()){
               
           while(n<dataBase.size()) {
               
           List realData=dataBase.get(n);int z=0;
           
           while(z<realData.size()){
               
           if(z==0){
               PdfPCell cellx1 = new PdfPCell(new Paragraph(realData.get(0).toString(),font1));
             cellx1.setFixedHeight(16.2f);
               cellx1.disableBorderSide(LEFT);
             cellx1.disableBorderSide(TOP);
               cellx1.disableBorderSide(RIGHT);
             cellx1.setPadding(.5f);
               cellx1.setBorderColorBottom(BaseColor.BLACK);
             cellx1.setBorderColorTop(BaseColor.WHITE);
             cellx1.setBorderColorLeft(BaseColor.WHITE);
             cellx1.setBorderColorRight(BaseColor.WHITE);
             cellx1.setVerticalAlignment(Element.ALIGN_TOP);
               table.addCell(cellx1);
           }
           if(z==1){
         
            PdfPCell cellx2 =new PdfPCell(new Paragraph(realData.get(1).toString(),font1));
           cellx2.disableBorderSide(LEFT);
         cellx2.disableBorderSide(TOP);
         cellx2.disableBorderSide(RIGHT);
               cellx2.setBorderColorBottom(BaseColor.BLACK);
             cellx2.setBorderColorTop(BaseColor.WHITE);
             cellx2.setBorderColorLeft(BaseColor.WHITE);
             cellx2.setBorderColorRight(BaseColor.WHITE);
              cellx2.setFixedHeight(16.2f);
              cellx2.setPadding(.5f);
              cellx2.setVerticalAlignment(Element.ALIGN_TOP);
            table.addCell(cellx2);
            
           }
          
            
             if(z==2){
        PdfPCell cellx4=null;
        if(parseDouble(realData.get(2).toString().replaceAll(",", ""))<0.0){
       cellx4 = new PdfPCell(new Paragraph("("+NumberFormatS.format(parseDouble(ffm.formatForStatementNumbers(realData.get(2).toString().replaceAll(",", ""))))+")",font1));
        }else if(parseDouble(realData.get(2).toString().replaceAll(",", ""))>=0.0){
        
        cellx4 = new PdfPCell(new Paragraph(NumberFormatS.format(parseDouble(realData.get(2).toString().replaceAll(",", "")))+"",font1));
        }
                cellx4.setFixedHeight(16.2f);
                 cellx4.setPadding(.5f);
                   cellx4.disableBorderSide(LEFT);
         cellx4.disableBorderSide(TOP);
         cellx4.disableBorderSide(RIGHT);
                cellx4.setBorderColorBottom(BaseColor.BLACK);
             cellx4.setBorderColorTop(BaseColor.WHITE);
             cellx4.setBorderColorLeft(BaseColor.WHITE);
             cellx4.setBorderColorRight(BaseColor.WHITE);
              cellx4.setVerticalAlignment(Element.ALIGN_TOP);
            table.addCell(cellx4);
             }
              if(z==3){
                 
                  
                PdfPCell cellx5=null;
        if(parseDouble(realData.get(3).toString().replaceAll(",", ""))<0.0){
       cellx5 = new PdfPCell(new Paragraph("("+ffm.formatForStatementNumbers(realData.get(3).toString().replaceAll(",", ""))+")",font1));
        }else if(parseDouble(realData.get(3).toString().replaceAll(",", ""))>=0.0){
        
        cellx5 = new PdfPCell(new Paragraph(ffm.formatForStatementNumbers(realData.get(3).toString().replaceAll(",", ""))+"",font1));
        }
                cellx5.setFixedHeight(16.2f);
                 cellx5.setPadding(.5f);
                   cellx5.disableBorderSide(LEFT);
         cellx5.disableBorderSide(TOP);
         cellx5.disableBorderSide(RIGHT);
                cellx5.setBorderColorBottom(BaseColor.BLACK);
             cellx5.setBorderColorTop(BaseColor.WHITE);
             cellx5.setBorderColorLeft(BaseColor.WHITE);
             cellx5.setBorderColorRight(BaseColor.WHITE);
              cellx5.setVerticalAlignment(Element.ALIGN_TOP);
            table.addCell(cellx5);
              }
                if(z==4){
                   
                PdfPCell cellx6=null;
        if(parseDouble(realData.get(4).toString().replaceAll(",", ""))<0.0){
       cellx6 = new PdfPCell(new Paragraph("("+ffm.formatForStatementNumbers(realData.get(4).toString().replaceAll(",", ""))+")",font1));
        }else if(parseDouble(realData.get(4).toString().replaceAll(",", ""))>=0.0){
        
        cellx6 = new PdfPCell(new Paragraph(ffm.formatForStatementNumbers(realData.get(4).toString().replaceAll(",", ""))+"",font1));
        }
                cellx6.setFixedHeight(16.2f);
                 cellx6.setPadding(.5f);
                   cellx6.disableBorderSide(LEFT);
         cellx6.disableBorderSide(TOP);
         cellx6.disableBorderSide(RIGHT);
                cellx6.setBorderColorBottom(BaseColor.BLACK);
             cellx6.setBorderColorTop(BaseColor.WHITE);
             cellx6.setBorderColorLeft(BaseColor.WHITE);
             cellx6.setBorderColorRight(BaseColor.WHITE);
              cellx6.setVerticalAlignment(Element.ALIGN_TOP);
            table.addCell(cellx6);
                }
                if(z==5){
                   
                PdfPCell cellx7=null;
        if(parseDouble(realData.get(5).toString().replaceAll(",", ""))<0.0){
       cellx7 = new PdfPCell(new Paragraph("("+ffm.formatForStatementNumbers(realData.get(5).toString().replaceAll(",", ""))+")",font1));
        }else if(parseDouble(realData.get(5).toString().replaceAll(",", ""))>=0.0){
        
        cellx7 = new PdfPCell(new Paragraph(ffm.formatForStatementNumbers(realData.get(5).toString().replaceAll(",", ""))+"",font1));
        }
                cellx7.setFixedHeight(16.2f);
                 cellx7.setPadding(.5f);
                   cellx7.disableBorderSide(LEFT);
         cellx7.disableBorderSide(TOP);
         cellx7.disableBorderSide(RIGHT);
                cellx7.setBorderColorBottom(BaseColor.BLACK);
             cellx7.setBorderColorTop(BaseColor.WHITE);
             cellx7.setBorderColorLeft(BaseColor.WHITE);
             cellx7.setBorderColorRight(BaseColor.WHITE);
              cellx7.setVerticalAlignment(Element.ALIGN_TOP);
            table.addCell(cellx7);
                }
                if(z==6){
                   
           PdfPCell cellx8 = new PdfPCell(new Paragraph(realData.get(6).toString(),font1));
             cellx8.setFixedHeight(16.2f);
               cellx8.disableBorderSide(LEFT);
             cellx8.disableBorderSide(TOP);
               cellx8.disableBorderSide(RIGHT);
             cellx8.setPadding(.5f);
               cellx8.setBorderColorBottom(BaseColor.BLACK);
             cellx8.setBorderColorTop(BaseColor.WHITE);
             cellx8.setBorderColorLeft(BaseColor.WHITE);
             cellx8.setBorderColorRight(BaseColor.WHITE);
             cellx8.setVerticalAlignment(Element.ALIGN_TOP);
               table.addCell(cellx8);
                }
           z++;   
           } 
      
           n++;
           } 
           }else{
           table.addCell(new PdfPCell(new Paragraph("Empty selection",font1)));
            table.addCell(new PdfPCell(new Paragraph("Empty selection",font1)));
            table.addCell(new PdfPCell(new Paragraph("Empty selection",font1)));
           table.addCell(new PdfPCell(new Paragraph("Empty selection"+"",font1)));
           table.addCell(new PdfPCell(new Paragraph("Empty selection"+"",font1)));
            table.addCell(new PdfPCell(new Paragraph("Empty selection",font1))); 
            table.addCell(new PdfPCell(new Paragraph("Empty selection",font1)));
           }
      return table;

       }
       

 public  PdfPTable createFooter( ){
    PdfPTable table = new PdfPTable(3);
    table.setWidthPercentage(100);
    float[] columnWidths = {30f, 30f, 30f};

    Font font1 = new Font(Font.FontFamily.COURIER  , 18, Font.NORMAL);
    
    Font font2 = new Font(Font.FontFamily.COURIER  , 18, Font.BOLD);

    try {
    table.setWidths(columnWidths);

    } catch (DocumentException ex) {
    Logger.getLogger(PostingEntryWindow.class.getName()).log(Level.SEVERE, null, ex);
    }
    PdfPCell cell1 = new PdfPCell(new Paragraph("PREPARED BY",font2));
    PdfPCell cell2 = new PdfPCell(new Paragraph("",font2));
    PdfPCell cell3 = new PdfPCell(new Paragraph("APPROVED BY",font2));
   PdfPCell cell4 = new PdfPCell(new Paragraph("NAME:_________________",font1));
    PdfPCell cell5 = new PdfPCell(new Paragraph("",font1));
    PdfPCell cell6 = new PdfPCell(new Paragraph("NAME:_________________",font1));
    PdfPCell cell7 = new PdfPCell(new Paragraph("SIGNITURE:____________",font1));
    PdfPCell cell8 = new PdfPCell(new Paragraph("",font1));
    PdfPCell cell9 = new PdfPCell(new Paragraph("SIGNITURE:____________",font1));
    PdfPCell cell10 = new PdfPCell(new Paragraph("DATE:_________________",font1));
    PdfPCell cell11= new PdfPCell(new Paragraph("",font1));
    PdfPCell cell12= new PdfPCell(new Paragraph("DATE:_________________",font1));

//
//    cell1.setBackgroundColor(BaseColor.GREEN);   //sets BG color to yellow.
//    cell2.setBackgroundColor(BaseColor.GREEN); 
//    cell3.setBackgroundColor(BaseColor.GREEN); 

//
//    cell1.setBorderWidth (2f);         // sets border width to 3 units
//    cell2.setBorderWidth (2f);
//    cell3.setBorderWidth (2f);
 
    cell1 .disableBorderSide(LEFT);         // sets border width to 3 units
    cell2 .disableBorderSide(LEFT);
    cell3 .disableBorderSide(LEFT);
  cell4.disableBorderSide(LEFT);         // sets border width to 3 units
    cell5 .disableBorderSide(LEFT);
    cell6 .disableBorderSide(LEFT);
     cell7 .disableBorderSide(LEFT);         // sets border width to 3 units
    cell8.disableBorderSide(LEFT);
    cell9 .disableBorderSide(LEFT);
     cell10 .disableBorderSide(LEFT);         // sets border width to 3 units
    cell11.disableBorderSide(LEFT);
    cell12 .disableBorderSide(LEFT);

    cell1 .disableBorderSide(TOP);       // sets border width to 3 units
    cell2.disableBorderSide(TOP); 
    cell3.disableBorderSide(TOP); 
    cell4.disableBorderSide(TOP);         // sets border width to 3 units
    cell5 .disableBorderSide(TOP);
    cell6 .disableBorderSide(TOP);
     cell7 .disableBorderSide(TOP);         // sets border width to 3 units
    cell8.disableBorderSide(TOP);
    cell9 .disableBorderSide(TOP);
     cell10 .disableBorderSide(TOP);         // sets border width to 3 units
    cell11.disableBorderSide(TOP);
    cell12 .disableBorderSide(TOP);
    
    cell1.disableBorderSide(RIGHT);         // sets border width to 3 units
    cell2.disableBorderSide(RIGHT); 
    cell3.disableBorderSide(RIGHT);
      cell4.disableBorderSide(RIGHT);         // sets border width to 3 units
    cell5 .disableBorderSide(RIGHT);
    cell6 .disableBorderSide(RIGHT);
     cell7 .disableBorderSide(RIGHT);         // sets border width to 3 units
    cell8.disableBorderSide(RIGHT);
    cell9 .disableBorderSide(RIGHT);
     cell10 .disableBorderSide(RIGHT);         // sets border width to 3 units
    cell11.disableBorderSide(RIGHT);
    cell12 .disableBorderSide(RIGHT);
  
     cell1.disableBorderSide(BOTTOM);      // sets border width to 3 units
    cell2.disableBorderSide(BOTTOM); 
    cell3.disableBorderSide(BOTTOM); 
    cell1.disableBorderSide(BOTTOM);         // sets border width to 3 units
    cell2.disableBorderSide(BOTTOM); 
    cell3.disableBorderSide(BOTTOM);
      cell4.disableBorderSide(BOTTOM);         // sets border width to 3 units
    cell5 .disableBorderSide(BOTTOM);
    cell6 .disableBorderSide(BOTTOM);
     cell7 .disableBorderSide(BOTTOM);         // sets border width to 3 units
    cell8.disableBorderSide(BOTTOM);
    cell9 .disableBorderSide(BOTTOM);
     cell10 .disableBorderSide(BOTTOM);         // sets border width to 3 units
    cell11.disableBorderSide(BOTTOM);
    cell12 .disableBorderSide(BOTTOM);
    
    table.addCell(cell1);
    table.addCell(cell2);
    table.addCell(cell3);
    table.addCell(cell4);
    table.addCell(cell5);
    table.addCell(cell6);
    table.addCell(cell7);
    table.addCell(cell8);
    table.addCell(cell9);
    table.addCell(cell10);
    table.addCell(cell11);
    table.addCell(cell12);
  return table;
    }

private Paragraph createHeading() {
  Paragraph ss=null;
  
  Font font1 = new Font(Font.FontFamily.COURIER  , 14, Font.NORMAL);
  ss= new Paragraph("BORROWING_GUARANTEEING STATEMENT"+"\n"+"AS AT"+" "+ffm.getTodayDate(),font1);
   ss.setAlignment(Element.ALIGN_CENTER);
  return ss;
  
  }

    @Override
    public void onOpenDocument(PdfWriter writer, Document document) {
     pagenumber = 0;
    }

    @Override
    public void onStartPage(PdfWriter writer, Document document) {
      pagenumber++;
    }

    @Override
    public void onEndPage(PdfWriter writer, Document document) {
      Font font1 = new Font(Font.FontFamily.COURIER  , 10, Font.BOLDITALIC);
       Font font2 = new Font(Font.FontFamily.COURIER  , 5, Font.BOLDITALIC);
        ColumnText.showTextAligned(writer.getDirectContent(),
                    Element.ALIGN_CENTER, new Phrase(String.format("page %d", pagenumber),font1),
                    ( document.right()-document.left())/2+document.leftMargin(), document.bottom()+1, 0);
      
        ColumnText.showTextAligned(writer.getDirectContent(),
                    Element.ALIGN_CENTER, new Phrase("POWERED BY: BAZIRAKE AUGUSTINE GOOGO, MOBILE: 0782231039, EMAIL: augbazi@gmail.com",font2),
                    ( document.right()-document.left())/2+(document.leftMargin()), document.bottom()-10, 0);
    }
    @Override
    public void onCloseDocument(PdfWriter writer, Document document) {
            Font font1 = new Font(Font.FontFamily.COURIER  , 10, Font.BOLDITALIC);
        ColumnText.showTextAligned(writer.getDirectContent(),
                    Element.ALIGN_CENTER, new Phrase("POWERED BY: BAZIRAKE AUGUSTINE GOOGO, MOBILE: 0782231039, EMAIL: augbazi@gmail.com",font1),
                    ( document.right()-document.left())/2+(document.leftMargin()), document.bottom()-10, 0);
    }

    @Override
    public void onParagraph(PdfWriter writer, Document document, float paragraphPosition) {
        
    }

    @Override
    public void onParagraphEnd(PdfWriter writer, Document document, float paragraphPosition) {
        
    }

    @Override
    public void onChapter(PdfWriter writer, Document document, float paragraphPosition, Paragraph title) {
        
    }

    @Override
    public void onChapterEnd(PdfWriter writer, Document document, float paragraphPosition) {
        
    }

    @Override
    public void onSection(PdfWriter writer, Document document, float paragraphPosition, int depth, Paragraph title) {
        
    }

    @Override
    public void onSectionEnd(PdfWriter writer, Document document, float paragraphPosition) {
       
    }

    @Override
    public void onGenericTag(PdfWriter writer, Document document, Rectangle rect, String text) {
        
    }
  





}
  

