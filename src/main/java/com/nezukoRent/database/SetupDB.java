package com.nezukoRent.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yassin
 */


public class SetupDB {
   
             public  SetupDB(){
   
              }
             
             public static void Setup(){ 
             
              AdminTableHandler.initializeAdminProfile();
               VilleTableHandler.createTable();
               QuartierTableHandler.createTable();
               AppartementTableHandler.createTable();
               PhotosTableHandler.createTable();
             }
             
          public static void dropTable(String tableName) {
   
                 String sql = "DROP TABLE " + tableName + ";";
                try (Connection conn = DBConnect.connect();
                    Statement stmt = conn.createStatement()) {
                    stmt.executeUpdate(sql);
                    System.out.println("Table " + tableName + " dropped successfully.");
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
         }
}
