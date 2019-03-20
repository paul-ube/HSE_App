/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hse_application.functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author OPTIPLEX
 */
public class DBConnect{
    Connection conn = null;

    public static Connection ConnDB(){
        
        String dbname = "muztaph_hsepro";
        String username = "muztaph_norman";
        String password = "921507921507";
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hse","root","P@ssw0rd");
            Connection conn = DriverManager.getConnection("jdbc:mysql://muzta.ph:3306/"+dbname,username,password);
            System.out.println("Connected to the Database");
            return conn;
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Cannot connect to the Database"+e);
            System.out.println("Cannot connect to the Database");
            return null;
        }
    }
}

