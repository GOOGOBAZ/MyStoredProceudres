/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googo.pmms.project2.smallFrames;

import googo.pmms.project2.accountsHelper.Formartter;
import googo.pmms.project2.accountsHelper.fileInputOutPutStreams;
import googo.pmms.project2.databases.loanDatabaseQuaries;
import googo.pmms.project2.databases.DatabaseQuaries;
import googo.pmms.project2.frameHelper.IUpdateText;
import googo.pmms.project2.frameHelper.ListDataModel;
import googo.pmms.project2.reportsHelper.OtherLoanReports;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import googo.pmms.project2.frames.NewLoanApplication;
import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;

/**
 *
 * @author STAT SOLUTIONS
 */
public class PayRollModule extends javax.swing.JFrame implements MouseListener, IUpdateText, ActionListener,KeyListener{
String userId;
//JFrame reflection;
//    List amortDetails;
//    DecimalFormat NumberFormat =new DecimalFormat("#,###");
//        SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy");
    fileInputOutPutStreams fios= new fileInputOutPutStreams();
//    Formartter ffm = new Formartter();
//    Date Trndate,valuedate;
//   ArrayList<String> data4, column1;
//List data5;
//    String text,position;
// Integer Value,Value1;
//    GregorianCalendar cal = new GregorianCalendar(); 
//    
//         BatchPostingHelper bPost=new BatchPostingHelper(); 
//         
//     JdbcConnector csx = new JdbcConnector(fios.stringFileReader(fios.createFileName("emailDetails", "sendMail", "AccountDBDetails.txt"))); ; 
    DatabaseQuaries dbq =new DatabaseQuaries();
    loanDatabaseQuaries loan=new loanDatabaseQuaries();
//    Formartter form= new Formartter();
//    AccountNumberCreationDataBase ancdb=new AccountNumberCreationDataBase();
//   ReportsDatabase report =new ReportsDatabase();
//    BalanceSheet bsheet= new BalanceSheet();
//    PostingMain post= new PostingMain();
//    BackUpRestoreDB dbBackUp= new BackUpRestoreDB();
//    CreatingFolders filesW= new CreatingFolders();
//   private PostingEntryWindow.ProcessLoanRepayment laonPay;
//  String completeStatus="Not Complete",flag="Not Flagged"; int temper=0;
//    String batchNumber;
    OtherLoanReports otherLoans=new  OtherLoanReports();
//     LoanSavingsSharesOthers loanSaveShare=new LoanSavingsSharesOthers();
//         ListDataModel model1;
         ListDataModel result;
//         String theAccount="";
//         
////     OtherLoanReports otherLoans=new  OtherLoanReports();
//     
//    List loanPaymentOrder;
//    SimpleDateFormat sdk =new SimpleDateFormat("dd.MM.yyyy");
//  
//        CreateExcelWorkBook writeExcel= new CreateExcelWorkBook();
//    
// int n=0;
//   
//          JOptionPane p;
//    PostingModal model ;
//    JFrame fi, f,fa,fb,fc;
//    Date date;
//  SimpleDateFormat df;
     Formartter fmt= new Formartter();
// AccountNumberCreationDataBase db =new AccountNumberCreationDataBase();
//NewLoanApplication component;
String accountNumber;
String GroupId;
    public PayRollModule(String userId,String comp) {
        
         
          
        initComponents();
        this.userId=userId;
//        component=comp;
   
         accountNumber=comp;
        
        Image img = new ImageIcon(System.getProperty("user.dir")+"/"+"ICON_LOGO.jpg").getImage();
        this.setIconImage(img);
        this.setTitle("OTHER LOAN DETAILS"); 
//        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        amountCredit4 = new javax.swing.JFormattedTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jButton51 = new javax.swing.JButton();
        jButton50 = new javax.swing.JButton();
        jButton49 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton47 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton46 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton48 = new javax.swing.JButton();
        jButton52 = new javax.swing.JButton();
        jButton53 = new javax.swing.JButton();
        jButton54 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton55 = new javax.swing.JButton();
        jButton56 = new javax.swing.JButton();
        jButton57 = new javax.swing.JButton();
        jButton58 = new javax.swing.JButton();
        jButton59 = new javax.swing.JButton();
        jButton60 = new javax.swing.JButton();
        jButton61 = new javax.swing.JButton();
        jButton62 = new javax.swing.JButton();
        jButton63 = new javax.swing.JButton();
        jButton64 = new javax.swing.JButton();
        jButton65 = new javax.swing.JButton();
        jButton66 = new javax.swing.JButton();
        jButton67 = new javax.swing.JButton();
        jButton68 = new javax.swing.JButton();
        jButton69 = new javax.swing.JButton();
        jButton70 = new javax.swing.JButton();
        jButton71 = new javax.swing.JButton();
        jButton72 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAutoRequestFocus(false);
        setMaximumSize(new java.awt.Dimension(1000, 550));
        setMinimumSize(new java.awt.Dimension(1000, 550));
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setPreferredSize(new java.awt.Dimension(1000, 550));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setBackground(java.awt.SystemColor.activeCaption);
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 204, 153), new java.awt.Color(0, 204, 153)));
        jPanel1.setLayout(null);

        jPanel6.setBackground(java.awt.SystemColor.activeCaption);
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setLayout(null);

        jPanel4.setBackground(java.awt.SystemColor.activeCaption);
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(null);

        jButton1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton1.setText("Create PayRoll");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1);
        jButton1.setBounds(800, 10, 160, 50);

        jComboBox1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel4.add(jComboBox1);
        jComboBox1.setBounds(190, 10, 170, 50);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Amount Involved");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.add(jLabel3);
        jLabel3.setBounds(540, 10, 120, 50);
        jLabel3.setVisible(false);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Percent Involved");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.add(jLabel4);
        jLabel4.setBounds(360, 10, 120, 50);
        jLabel4.setVisible(false);

        jTextField2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel4.add(jTextField2);
        jTextField2.setBounds(480, 10, 60, 50);
        jTextField2.setVisible(false);

        jComboBox2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select PayRoll Category", "Deduction", "Employee Reward" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel4.add(jComboBox2);
        jComboBox2.setBounds(10, 10, 181, 50);

        amountCredit4.setForeground(new java.awt.Color(0, 102, 51));
        amountCredit4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###,###,###,###"))));
        amountCredit4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        amountCredit4.setValue(null);
        amountCredit4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountCredit4ActionPerformed(evt);
            }
        });
        jPanel4.add(amountCredit4);
        amountCredit4.setBounds(660, 10, 140, 50);
        amountCredit4.setVisible(false);

        jPanel6.add(jPanel4);
        jPanel4.setBounds(10, 10, 970, 140);

        jPanel5.setBackground(java.awt.SystemColor.activeCaption);
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 153, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setForeground(new java.awt.Color(102, 153, 255));
        jPanel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel2.setLayout(null);

        jLabel2.setBackground(new java.awt.Color(255, 153, 102));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(java.awt.SystemColor.controlLtHighlight);
        jLabel2.setText("BASIC SALARY AND ALLOWANCES");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(jLabel2);
        jLabel2.setBounds(90, 10, 290, 40);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(12, 52, 460, 210);

        jPanel5.add(jPanel2);
        jPanel2.setBounds(0, 10, 480, 280);

        jPanel3.setBackground(new java.awt.Color(102, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setForeground(new java.awt.Color(255, 102, 102));
        jPanel3.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(102, 153, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(java.awt.SystemColor.controlLtHighlight);
        jLabel1.setText("DEDUCTIONS AND NET PAY");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.add(jLabel1);
        jLabel1.setBounds(90, 10, 290, 40);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(10, 50, 470, 210);

        jPanel5.add(jPanel3);
        jPanel3.setBounds(480, 10, 490, 280);

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.setLayout(null);
        jPanel5.add(jPanel7);
        jPanel7.setBounds(0, 290, 970, 40);

        jPanel6.add(jPanel5);
        jPanel5.setBounds(10, 150, 970, 370);

        jPanel1.add(jPanel6);
        jPanel6.setBounds(0, 10, 990, 530);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 0, 1000, 550);

        jButton51.setBackground(new java.awt.Color(0, 51, 51));
        jButton51.setText("jButton5");
        getContentPane().add(jButton51);
        jButton51.setBounds(1800, 360, 73, 23);

        jButton50.setBackground(java.awt.SystemColor.controlLtHighlight);
        jButton50.setText("jButton5");
        getContentPane().add(jButton50);
        jButton50.setBounds(1790, 330, 73, 23);

        jButton49.setBackground(new java.awt.Color(255, 204, 204));
        jButton49.setText("jButton5");
        getContentPane().add(jButton49);
        jButton49.setBounds(1870, 320, 73, 23);

        jButton31.setBackground(new java.awt.Color(255, 204, 153));
        jButton31.setText("Blue");
        getContentPane().add(jButton31);
        jButton31.setBounds(1810, 310, 53, 23);

        jButton38.setBackground(new java.awt.Color(204, 204, 0));
        jButton38.setText("Blue");
        getContentPane().add(jButton38);
        jButton38.setBounds(1810, 290, 53, 23);

        jButton32.setBackground(new java.awt.Color(0, 153, 153));
        jButton32.setText("Blue");
        getContentPane().add(jButton32);
        jButton32.setBounds(1870, 290, 53, 23);

        jButton47.setBackground(new java.awt.Color(204, 255, 204));
        jButton47.setText("Blue");
        getContentPane().add(jButton47);
        jButton47.setBounds(1930, 290, 53, 23);

        jButton29.setBackground(new java.awt.Color(0, 204, 204));
        jButton29.setText("Blue");
        getContentPane().add(jButton29);
        jButton29.setBounds(1920, 270, 53, 23);

        jButton37.setBackground(new java.awt.Color(204, 153, 255));
        jButton37.setText("Blue");
        getContentPane().add(jButton37);
        jButton37.setBounds(1870, 270, 53, 23);

        jButton33.setBackground(new java.awt.Color(152, 198, 94));
        jButton33.setText("Blue");
        getContentPane().add(jButton33);
        jButton33.setBounds(1810, 270, 53, 23);

        jButton35.setBackground(new java.awt.Color(255, 204, 204));
        jButton35.setText("Blue");
        getContentPane().add(jButton35);
        jButton35.setBounds(1810, 250, 53, 23);

        jButton45.setBackground(new java.awt.Color(255, 255, 204));
        jButton45.setText("Blue");
        getContentPane().add(jButton45);
        jButton45.setBounds(1870, 250, 53, 23);

        jButton42.setBackground(new java.awt.Color(0, 204, 102));
        jButton42.setText("Blue");
        getContentPane().add(jButton42);
        jButton42.setBounds(1920, 230, 53, 23);

        jButton43.setBackground(new java.awt.Color(204, 204, 204));
        jButton43.setText("Blue");
        getContentPane().add(jButton43);
        jButton43.setBounds(1870, 230, 53, 23);

        jButton30.setBackground(new java.awt.Color(0, 153, 255));
        jButton30.setText("Blue");
        getContentPane().add(jButton30);
        jButton30.setBounds(1810, 230, 53, 23);

        jButton36.setBackground(java.awt.SystemColor.activeCaption);
        jButton36.setText("Blue");
        getContentPane().add(jButton36);
        jButton36.setBounds(1810, 210, 53, 23);

        jButton44.setBackground(new java.awt.Color(204, 165, 165));
        jButton44.setText("Blue");
        getContentPane().add(jButton44);
        jButton44.setBounds(1870, 210, 53, 23);

        jButton39.setBackground(new java.awt.Color(204, 204, 255));
        jButton39.setText("Blue");
        getContentPane().add(jButton39);
        jButton39.setBounds(1920, 210, 53, 23);

        jButton41.setBackground(java.awt.SystemColor.activeCaption);
        jButton41.setText("Blue");
        getContentPane().add(jButton41);
        jButton41.setBounds(1920, 190, 53, 23);

        jButton46.setBackground(java.awt.SystemColor.activeCaption);
        jButton46.setText("Blue");
        getContentPane().add(jButton46);
        jButton46.setBounds(1870, 190, 53, 23);

        jButton40.setBackground(java.awt.SystemColor.activeCaption);
        jButton40.setText("Blue");
        getContentPane().add(jButton40);
        jButton40.setBounds(1810, 190, 53, 23);

        jButton48.setBackground(new java.awt.Color(201, 222, 223));
        jButton48.setText("Blue");
        getContentPane().add(jButton48);
        jButton48.setBounds(1870, 170, 53, 23);

        jButton52.setBackground(new java.awt.Color(0, 51, 51));
        jButton52.setText("jButton5");
        getContentPane().add(jButton52);
        jButton52.setBounds(1800, 360, 73, 23);

        jButton53.setBackground(java.awt.SystemColor.controlLtHighlight);
        jButton53.setText("jButton5");
        getContentPane().add(jButton53);
        jButton53.setBounds(1790, 330, 73, 23);

        jButton54.setBackground(new java.awt.Color(255, 204, 204));
        jButton54.setText("jButton5");
        getContentPane().add(jButton54);
        jButton54.setBounds(1870, 320, 73, 23);

        jButton34.setBackground(new java.awt.Color(255, 204, 153));
        jButton34.setText("Blue");
        getContentPane().add(jButton34);
        jButton34.setBounds(1810, 310, 53, 23);

        jButton55.setBackground(new java.awt.Color(204, 204, 0));
        jButton55.setText("Blue");
        getContentPane().add(jButton55);
        jButton55.setBounds(1810, 290, 53, 23);

        jButton56.setBackground(new java.awt.Color(0, 153, 153));
        jButton56.setText("Blue");
        getContentPane().add(jButton56);
        jButton56.setBounds(1870, 290, 53, 23);

        jButton57.setBackground(new java.awt.Color(204, 255, 204));
        jButton57.setText("Blue");
        getContentPane().add(jButton57);
        jButton57.setBounds(1930, 290, 53, 23);

        jButton58.setBackground(new java.awt.Color(0, 204, 204));
        jButton58.setText("Blue");
        getContentPane().add(jButton58);
        jButton58.setBounds(1920, 270, 53, 23);

        jButton59.setBackground(new java.awt.Color(204, 153, 255));
        jButton59.setText("Blue");
        getContentPane().add(jButton59);
        jButton59.setBounds(1870, 270, 53, 23);

        jButton60.setBackground(new java.awt.Color(152, 198, 94));
        jButton60.setText("Blue");
        getContentPane().add(jButton60);
        jButton60.setBounds(1810, 270, 53, 23);

        jButton61.setBackground(new java.awt.Color(255, 204, 204));
        jButton61.setText("Blue");
        getContentPane().add(jButton61);
        jButton61.setBounds(1810, 250, 53, 23);

        jButton62.setBackground(new java.awt.Color(255, 255, 204));
        jButton62.setText("Blue");
        getContentPane().add(jButton62);
        jButton62.setBounds(1870, 250, 53, 23);

        jButton63.setBackground(new java.awt.Color(0, 204, 102));
        jButton63.setText("Blue");
        getContentPane().add(jButton63);
        jButton63.setBounds(1920, 230, 53, 23);

        jButton64.setBackground(new java.awt.Color(204, 204, 204));
        jButton64.setText("Blue");
        getContentPane().add(jButton64);
        jButton64.setBounds(1870, 230, 53, 23);

        jButton65.setBackground(new java.awt.Color(0, 153, 255));
        jButton65.setText("Blue");
        getContentPane().add(jButton65);
        jButton65.setBounds(1810, 230, 53, 23);

        jButton66.setBackground(java.awt.SystemColor.activeCaption);
        jButton66.setText("Blue");
        getContentPane().add(jButton66);
        jButton66.setBounds(1810, 210, 53, 23);

        jButton67.setBackground(new java.awt.Color(204, 165, 165));
        jButton67.setText("Blue");
        getContentPane().add(jButton67);
        jButton67.setBounds(1870, 210, 53, 23);

        jButton68.setBackground(new java.awt.Color(204, 204, 255));
        jButton68.setText("Blue");
        getContentPane().add(jButton68);
        jButton68.setBounds(1920, 210, 53, 23);

        jButton69.setBackground(java.awt.SystemColor.activeCaption);
        jButton69.setText("Blue");
        getContentPane().add(jButton69);
        jButton69.setBounds(1920, 190, 53, 23);

        jButton70.setBackground(java.awt.SystemColor.activeCaption);
        jButton70.setText("Blue");
        getContentPane().add(jButton70);
        jButton70.setBounds(1870, 190, 53, 23);

        jButton71.setBackground(java.awt.SystemColor.activeCaption);
        jButton71.setText("Blue");
        getContentPane().add(jButton71);
        jButton71.setBounds(1810, 190, 53, 23);

        jButton72.setBackground(new java.awt.Color(201, 222, 223));
        jButton72.setText("Blue");
        getContentPane().add(jButton72);
        jButton72.setBounds(1870, 170, 53, 23);

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
     
        dbq.feelPayRollUserReward(jTable2,this.accountNumber);
        
        dbq.feelPayRollUserDeductions(jTable1,accountNumber);
        
       
        
        
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       int i=1;
     while(i<=5){
     
     JOptionPane.showMessageDialog(this, "SYSTEM LOG OUT ERROR!!!!!!!!!");}
    }//GEN-LAST:event_formWindowClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    switch(jComboBox1.getSelectedItem().toString()){
           case "PAYE":break;
       case "NSSF":break;
       case "PENSION":break;
       case "LOCAL SERVICE TAX":break;
       case "OVER TIME":break;
       }
        
        
        
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void amountCredit4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountCredit4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amountCredit4ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
 dbq.feelNonExistingCodes(jComboBox1,accountNumber,jComboBox2.getSelectedItem().toString());
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
       switch(jComboBox1.getSelectedItem().toString()){
           case "PAYE":break;
       case "NSSF":break;
       case "PENSION":break;
       case "LOCAL SERVICE TAX":break;
       case "OVER TIME":break;
       }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
////        public static String u=AddBatch.this.userId;
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(AddBatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AddBatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AddBatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AddBatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AddBatch().setVisible(true);
//            }
//        });
//    }
   private void sortTable(JTable table,JTextField textField){

   
    
TableRowSorter<TableModel> rowSorter  = new TableRowSorter<>(table.getModel());
                     
                      table.setRowSorter(rowSorter);
                     textField.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = textField.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = textField.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
    

}
   
     
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField amountCredit4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton55;
    private javax.swing.JButton jButton56;
    private javax.swing.JButton jButton57;
    private javax.swing.JButton jButton58;
    private javax.swing.JButton jButton59;
    private javax.swing.JButton jButton60;
    private javax.swing.JButton jButton61;
    private javax.swing.JButton jButton62;
    private javax.swing.JButton jButton63;
    private javax.swing.JButton jButton64;
    private javax.swing.JButton jButton65;
    private javax.swing.JButton jButton66;
    private javax.swing.JButton jButton67;
    private javax.swing.JButton jButton68;
    private javax.swing.JButton jButton69;
    private javax.swing.JButton jButton70;
    private javax.swing.JButton jButton71;
    private javax.swing.JButton jButton72;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
      
    }

    @Override
    public void mouseReleased(MouseEvent e) {
     
    }

    @Override
    public void mouseEntered(MouseEvent e) {
     
    }

    @Override
    public void mouseExited(MouseEvent e) {
     
    }

    @Override
    public void updateText(String text) {
  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
 
    }

    @Override
    public void keyTyped(KeyEvent e) {
 
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
    
    }

    
}
