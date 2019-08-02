/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googo.pmms.project2.databases;

import googo.pmms.project2.accountsHelper.fileInputOutPutStreams;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stanchart
 */
public class BackUpRestoreDB implements Runnable {
    
       fileInputOutPutStreams fios= new fileInputOutPutStreams(); 
         String userId;
       public void setUserID(String userid){
this.userId=userid;
}
    public void backUpTheDataBase(String theDataBase){

//
//        try {
            /*NOTE: Getting path to the Jar file being executed*/
            /*NOTE: YourImplementingClass-> replace with the class executing the code*/
//            CodeSource codeSource = BackUpRestoreDB.class.getProtectionDomain().getCodeSource();
//            File jarFile = new File(codeSource.getLocation().toURI().getPath());
//            String jarDir = jarFile.getParentFile().getPath();
            
            
            /*NOTE: Creating Database Constraints*/
            String dbName = theDataBase;
            String dbUser = "root";
            String dbPass = "PRINCE?;=2020";
            
            /*NOTE: Creating Path Constraints for folder saving*/
            /*NOTE: Here the backup folder is created for saving inside it*/
//            String folderPath = jarDir + "\\backup";
            
            /*NOTE: Creating Folder if it does not exist*/
//            File f1 = new File(folderPath);
//            f1.mkdir();
            
            /*NOTE: Creating Path Constraints for backup saving*/
            /*NOTE: Here the backup is saved in a folder called backup with the name backup.sql*/
//            String savePath = "\"" + jarDir + "\\backup\\" + "backup.sql\"";
            
            /*NOTE: Used to create a cmd command*/
            String executeCmd = "mysqldump -u  " + dbUser + " -p" +" "+ dbPass +" "+ dbName + "> " + "backup.sql";
            
       fios.stringFileWriter(fios.createFileName("dataBaseBackUps", "oneOffBacks", "excutionString"), executeCmd);//partly paidover is initialsied with 1
        Thread t=new Thread(this);
        t.start();
//        } catch (URISyntaxException ex) {
//            Logger.getLogger(BackUpRestoreDB.class.getName()).log(Level.SEVERE, null, ex);
//        }

        
       
      
    } 
  
    
    
    
    
    
//    public void backUpDataBases(List theDataBases){
//    int k=0;  StringBuilder sb = new StringBuilder();
//        while(k<=theDataBases.size()-1){
//        sb.append(theDataBases.get(k).toString());
//        sb.append(" ");
//        k++;
//        }
//
//        try {
//            /*NOTE: Getting path to the Jar file being executed*/
//            /*NOTE: YourImplementingClass-> replace with the class executing the code*/
//            CodeSource codeSource = BackUpRestoreDB.class.getProtectionDomain().getCodeSource();
//            File jarFile = new File(codeSource.getLocation().toURI().getPath());
//            String jarDir = jarFile.getParentFile().getPath();
//            
//            
//            /*NOTE: Creating Database Constraints*/
//            String dbName = sb.toString();
//            String dbUser = "root";
//            String dbPass = "PRINCE?;=2020";
//            
//            /*NOTE: Creating Path Constraints for folder saving*/
//            /*NOTE: Here the backup folder is created for saving inside it*/
//            String folderPath = jarDir + "\\backup";
//            
//            /*NOTE: Creating Folder if it does not exist*/
//            File f1 = new File(folderPath);
//            f1.mkdir();
//            
//            /*NOTE: Creating Path Constraints for backup saving*/
//            /*NOTE: Here the backup is saved in a folder called backup with the name backup.sql*/
//            String savePath = "\"" + jarDir + "\\backup\\" + "backup.sql\"";
//            
//            /*NOTE: Used to create a cmd command*/
//            String executeCmd = "mysqldump -u" +" "+ dbUser + " -p" +" "+ dbPass + " --databases " + dbName + " -r " + savePath;
//            
//       fios.stringFileWriter(fios.createFileName("dataBaseBackUps", "oneOffBacks", "excutionString"), executeCmd);//partly paidover is initialsied with 1
//        Thread t=new Thread(this);
//        t.start();
//        } catch (URISyntaxException ex) {
//            Logger.getLogger(BackUpRestoreDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        
//        
//    
//    }
    
    
    
//      public void backUppmms(){
//     try {
//            /*NOTE: Getting path to the Jar file being executed*/
//            /*NOTE: YourImplementingClass-> replace with the class executing the code*/
//            CodeSource codeSource = BackUpRestoreDB.class.getProtectionDomain().getCodeSource();
//            File jarFile = new File(codeSource.getLocation().toURI().getPath());
//            String jarDir = jarFile.getParentFile().getPath();
//            
//            
//            /*NOTE: Creating Database Constraints*/
//         
//            String dbUser = "root";
//            String dbPass = "PRINCE?;=2020";
//            
//            /*NOTE: Creating Path Constraints for folder saving*/
//            /*NOTE: Here the backup folder is created for saving inside it*/
//            String folderPath = jarDir + "\\backup";
//            
//            /*NOTE: Creating Folder if it does not exist*/
//            File f1 = new File(folderPath);
//            f1.mkdir();
//            
//            /*NOTE: Creating Path Constraints for backup saving*/
//            /*NOTE: Here the backup is saved in a folder called backup with the name backup.sql*/
//            String savePath = "\"" + jarDir + "\\backup\\" + "backup.sql\"";
//            
//            /*NOTE: Used to create a cmd command*/
//            String executeCmd = "mysqldump -u" + dbUser + " -p" + dbPass + " --databases " + "pmms" + " -r " + savePath;
//            
//       fios.stringFileWriter(fios.createFileName("dataBaseBackUps", "oneOffBacks", "excutionString"), executeCmd);//partly paidover is initialsied with 1
//        Thread t=new Thread(this);
//        t.start();
//        } catch (URISyntaxException ex) {
//            Logger.getLogger(BackUpRestoreDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    
//    }
//        public void backUppmms_loans(){
//      try {
//            /*NOTE: Getting path to the Jar file being executed*/
//            /*NOTE: YourImplementingClass-> replace with the class executing the code*/
//            CodeSource codeSource = BackUpRestoreDB.class.getProtectionDomain().getCodeSource();
//            File jarFile = new File(codeSource.getLocation().toURI().getPath());
//            String jarDir = jarFile.getParentFile().getPath();
//            
//            
//            /*NOTE: Creating Database Constraints*/
//         
//            String dbUser = "root";
//            String dbPass = "PRINCE?;=2020";
//            
//            /*NOTE: Creating Path Constraints for folder saving*/
//            /*NOTE: Here the backup folder is created for saving inside it*/
//            String folderPath = jarDir + "\\backup";
//            
//            /*NOTE: Creating Folder if it does not exist*/
//            File f1 = new File(folderPath);
//            f1.mkdir();
//            
//            /*NOTE: Creating Path Constraints for backup saving*/
//            /*NOTE: Here the backup is saved in a folder called backup with the name backup.sql*/
//            String savePath = "\"" + jarDir + "\\backup\\" + "backup.sql\"";
//            
//            /*NOTE: Used to create a cmd command*/
//            String executeCmd = "mysqldump -u" + dbUser + " -p" + dbPass + " --databases " + "pmms_loans" + " -r " + savePath;
//            
//       fios.stringFileWriter(fios.createFileName("dataBaseBackUps", "oneOffBacks", "excutionString"), executeCmd);//partly paidover is initialsied with 1
//        Thread t=new Thread(this);
//        t.start();
//        } catch (URISyntaxException ex) {
//            Logger.getLogger(BackUpRestoreDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    
//    }
    
//       public void backUpTheDataBaseTable(String theDataBase,String theTable){
//     StringBuilder sb = new StringBuilder();
//       
//        sb.append(theDataBase);
//        sb.append("  ");
//         sb.append(theTable);
//
//        try {
//            /*NOTE: Getting path to the Jar file being executed*/
//            /*NOTE: YourImplementingClass-> replace with the class executing the code*/
//            CodeSource codeSource = BackUpRestoreDB.class.getProtectionDomain().getCodeSource();
//            File jarFile = new File(codeSource.getLocation().toURI().getPath());
//            String jarDir = jarFile.getParentFile().getPath();
//            
//            
//            /*NOTE: Creating Database Constraints*/
//            String dbName = sb.toString();
//            String dbUser = "root";
//            String dbPass = "PRINCE?;=2020";
//            
//            /*NOTE: Creating Path Constraints for folder saving*/
//            /*NOTE: Here the backup folder is created for saving inside it*/
//            String folderPath = jarDir + "\\backup";
//            
//            /*NOTE: Creating Folder if it does not exist*/
//            File f1 = new File(folderPath);
//            f1.mkdir();
//            
//            /*NOTE: Creating Path Constraints for backup saving*/
//            /*NOTE: Here the backup is saved in a folder called backup with the name backup.sql*/
//            String savePath = "\"" + jarDir + "\\backup\\" + "backup.sql\"";
//            
//            /*NOTE: Used to create a cmd command*/
//            String executeCmd = "mysqldump -u" + dbUser + " -p" + dbPass + " --databases " + dbName + " -r " + savePath;
//            
//       fios.stringFileWriter(fios.createFileName("dataBaseBackUps", "oneOffBacks", "excutionString"), executeCmd);//partly paidover is initialsied with 1
//        Thread t=new Thread(this);
//        t.start();
//        } catch (URISyntaxException ex) {
//            Logger.getLogger(BackUpRestoreDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        
//        
//        
//    
//    }
    
    
//        public void backUpTheDataBaseTables(String theDataBase,List theTables){
//     int k=0;  StringBuilder sb = new StringBuilder();
//        
//       
//        sb.append(theDataBase);
//        while(k<=theTables.size()-1){
//          sb.append("  ");
//         sb.append(theTables.get(k));
//        k++;
//        }
//      
//
//        try {
//            /*NOTE: Getting path to the Jar file being executed*/
//            /*NOTE: YourImplementingClass-> replace with the class executing the code*/
//            CodeSource codeSource = BackUpRestoreDB.class.getProtectionDomain().getCodeSource();
//            File jarFile = new File(codeSource.getLocation().toURI().getPath());
//            String jarDir = jarFile.getParentFile().getPath();
//            
//            
//            /*NOTE: Creating Database Constraints*/
//            String dbName = sb.toString();
//            String dbUser = "root";
//            String dbPass = "PRINCE?;=2020";
//            
//            /*NOTE: Creating Path Constraints for folder saving*/
//            /*NOTE: Here the backup folder is created for saving inside it*/
//            String folderPath = jarDir + "\\backup";
//            
//            /*NOTE: Creating Folder if it does not exist*/
//            File f1 = new File(folderPath);
//            f1.mkdir();
//            
//            /*NOTE: Creating Path Constraints for backup saving*/
//            /*NOTE: Here the backup is saved in a folder called backup with the name backup.sql*/
//            String savePath = "\"" + jarDir + "\\backup\\" + "backup.sql\"";
//            
//            /*NOTE: Used to create a cmd command*/
//            String executeCmd = "mysqldump -u" + dbUser + " -p" + dbPass + " --databases " + dbName + " -r " + savePath;
//            
//       fios.stringFileWriter(fios.createFileName("dataBaseBackUps", "oneOffBacks", "excutionString"), executeCmd);//partly paidover is initialsied with 1
//        Thread t=new Thread(this);
//        t.start();
//        } catch (URISyntaxException ex) {
//            Logger.getLogger(BackUpRestoreDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    
//    }
    
//     public void backUppmmsTable(String theTable){
//    try {
//            /*NOTE: Getting path to the Jar file being executed*/
//            /*NOTE: YourImplementingClass-> replace with the class executing the code*/
//            CodeSource codeSource = BackUpRestoreDB.class.getProtectionDomain().getCodeSource();
//            File jarFile = new File(codeSource.getLocation().toURI().getPath());
//            String jarDir = jarFile.getParentFile().getPath();
//            
//            
//            /*NOTE: Creating Database Constraints*/
//         
//            String dbUser = "root";
//            String dbPass = "PRINCE?;=2020";
//            
//            /*NOTE: Creating Path Constraints for folder saving*/
//            /*NOTE: Here the backup folder is created for saving inside it*/
//            String folderPath = jarDir + "\\backup";
//            
//            /*NOTE: Creating Folder if it does not exist*/
//            File f1 = new File(folderPath);
//            f1.mkdir();
//            
//            /*NOTE: Creating Path Constraints for backup saving*/
//            /*NOTE: Here the backup is saved in a folder called backup with the name backup.sql*/
//            String savePath = "\"" + jarDir + "\\backup\\" + "backup.sql\"";
//            
//            /*NOTE: Used to create a cmd command*/
//            String executeCmd = "mysqldump -u" + dbUser + " -p" + dbPass + " --databases " + "pmms" +"  "+theTable+ " -r " + savePath;
//            
//       fios.stringFileWriter(fios.createFileName("dataBaseBackUps", "oneOffBacks", "excutionString"), executeCmd);//partly paidover is initialsied with 1
//        Thread t=new Thread(this);
//        t.start();
//        } catch (URISyntaxException ex) {
//            Logger.getLogger(BackUpRestoreDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    
//         
//         
//    }
//        public boolean backUppmms_loansTable(String theTable){
//    
//    
//    }
//    
//         public boolean backUppmmsTables(List theTables){
//    
//    
//    }
//        public boolean backUppmms_loansTable(List theTables){
//    
//    
//    }
//
//
//

    @Override
    public void run() {
        
        try {
            /*NOTE: Executing the command here*/
            Runtime.getRuntime().exec( fios.stringFileReader(fios.createFileName("dataBaseBackUps", "oneOffBacks", "excutionString")));
        } catch (IOException ex) {
            Logger.getLogger(BackUpRestoreDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }







}
