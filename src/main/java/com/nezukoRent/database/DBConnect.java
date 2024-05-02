/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nezukoRent.database;

/**
 *
 * @author yassin
 */

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnect {
     public static Connection connect() {
        String dbFolder = "database";     
        String dbName = "app_database.db";
        new File(dbFolder).mkdirs();
        String url = "jdbc:sqlite:" + dbFolder + File.separator + dbName;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
     
     
       public static boolean checkTableExists(String tableName) {
  
        try (Connection conn = DBConnect.connect()) {
            DatabaseMetaData dbm = conn.getMetaData();
            try (ResultSet tables = dbm.getTables(null, null, tableName, null)) {
                if (tables.next()) {
                    System.out.println(tableName + " table exists.");
                    return true; 
                } else {
                    System.out.println(tableName + " table does not exist.");
                    return false; 
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return false;
        }
    }
    
  
}