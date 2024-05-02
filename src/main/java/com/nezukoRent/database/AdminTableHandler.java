/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nezukoRent.database;

import static com.nezukoRent.database.DBConnect.connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author yassin
 */
public class AdminTableHandler {
    
    public static void create() {
        
        String sql = "CREATE TABLE IF NOT EXISTS Admin (\n"
                + " id integer PRIMARY KEY,\n"
                + " name text NOT NULL,\n"
                + " passwd text NOT NULL\n"
                + ");";
        
        try (Connection conn = DBConnect.connect();
             Statement stmt = conn.createStatement()) {
         
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    

    private static boolean isAdminCreated(Connection conn) throws SQLException {
        String sqlCheck = "SELECT count(*) AS count FROM Admin;";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sqlCheck)) {
            if (rs.next()) {
                return rs.getInt("count") == 0;
            }
        }
        return false; 
    }
        

        private static void createTable(Connection conn) throws SQLException {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS Admin (\n"
                + " id integer PRIMARY KEY,\n"
                + " name text NOT NULL,\n"
                + " passwd text NOT NULL\n"
                + ");";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sqlCreate);
        }
    }
        
          private static void insertDefaultAdmin(Connection conn) throws SQLException {
        String sqlInsert = "INSERT INTO Admin (id, name, passwd) VALUES (1, 'admin', 'admin');";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sqlInsert);
            System.out.println("Default admin inserted.");
        }
    }
          
           public static void initializeAdminProfile() {
        try (Connection conn = DBConnect.connect()) {
            createTable(conn);
            if (isAdminCreated(conn)) {
                insertDefaultAdmin(conn);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
           
              public static boolean checkLogin(String username, String password) {
        String sql = "SELECT id FROM Admin WHERE name = ? AND passwd = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    
    
}
