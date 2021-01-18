/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ulise
 */
public class UConnection {
 private static Connection con = null;
 private static String driver = "org.postgresql.Driver";
 private static String pwd = "caramelo123";
 private static String usuario = "Omar";
 private static String url = "jdbc:postgresql://localhost/InventarioMultimedia";



public static Connection getConnection(){
try {
   if (con == null) {
     Runtime.getRuntime().addShutdownHook(new MiShDown());
     Class.forName(driver);
     con = DriverManager.getConnection(url, usuario, pwd);
    }
} catch (ClassNotFoundException | SQLException ex) {
     Logger.getLogger(UConnection.class.getName()).log(Level.SEVERE, null, ex);   
  }
return con;
}
static class MiShDown extends Thread{
 public void run(){  
  try {
     con.close();
    } catch (SQLException ex) {
        Logger.getLogger(UConnection.class.getName()).log(Level.SEVERE, null, ex);
    }
 }
}
}