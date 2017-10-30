/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finamproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class Connecter {
    Connection con;
    public Connecter(){
    try{
          //oad the driver
         Class.forName("com.mysql.jdbc.Driver");
         System.out.println("Driver connect");
      }catch(ClassNotFoundException ex){
            System.err.println(ex);
      } 
    try{
        //etablishing connection
        
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/finalproject","root","");
        System.out.println("connection establish");   
    }catch(SQLException ex){
        System.err.println(ex);
    }   
}
 Connection getConnect(){
     return con;
 }   
}
