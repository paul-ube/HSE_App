/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hse_application;


import java.awt.Color;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author OPTIPLEX
 */
public class HSE_Application {
    
    static Date LogDate = new Date();
    static FileHandler fh;
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HSE_HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HSE_HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HSE_HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HSE_HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
//        UIManager.put("TextField.inactiveBackground", new ColorUIResource(Color.WHITE));
        UIManager.put("TextField.disabledBackground", new ColorUIResource(Color.WHITE));   
        
                
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd h:mm a");
//        String currentdate = sdf.format(LogDate);
//        
//        Logger logger = Logger.getLogger("app_log"+currentdate);
//        
//        try{
//            File newFile = new File("logger"+currentdate+".txt");
//            if (!newFile.exists()){
//                newFile.createNewFile();
//            }
//            
//            
////            fh = new FileHandler("\\Desktop\\testLog.log");
////            logger.addHandler(fh);
////            SimpleFormatter formatter = new SimpleFormatter();
////            fh.setFormatter(formatter);
//            
////            logger.info("test");
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        LoginFrame e = new LoginFrame();
        e.setVisible(true);
        
        

    }
    
}
