/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class Database {
    private Connection connection;
    private Statement statement;
    
    public void savePenyedia(Penyedia n){
        
    }
//    public void connect () {
//        try {
//            
//            try {
//                Class.forName("com.mysql.jdbc.Driver"); //Harus load class dari lib.
////                connection = DriverManager.getConnection("jdbc:mysql://", user, password)
//            } catch (Exception e) {
//            }
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
