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
    String dbPassword = getPassword(username);
    if (dbPassword == null) {
        dbPassword = getPassword(getOldUsername(username));
        if (dbPassword == null) {
            System.out.println("User not found: " + username);
            return false;
        }
    }
    System.out.println("Retrieved password: " + dbPassword);
    return dbPassword.equals(password);
}

        private static String getOldUsername(String newUsername) {
    String sql = "SELECT name FROM Admin WHERE passwd = (SELECT passwd FROM Admin WHERE name = ?) AND name != ?";
    try (Connection conn = DBConnect.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, newUsername);
        pstmt.setString(2, newUsername);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return rs.getString("name");
        }
    } catch (SQLException e) {
        System.err.println("Error retrieving old username: " + e.getMessage());
    }
    return null;
}

private static String getPassword(String username) {
    String sql = "SELECT passwd FROM Admin WHERE name = ?";
    try (Connection conn = DBConnect.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, username);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return rs.getString("passwd");
        }
    } catch (SQLException e) {
        System.err.println("Error retrieving password: " + e.getMessage());
    }
    return null;
}
              
              
    private static final String UPDATE_PASSWORD_QUERY = "UPDATE Admin SET passwd =? WHERE name =?";

    public static boolean updatePassword(String username, String newPassword) {
        try (Connection conn = DBConnect.connect();
             PreparedStatement pstmt = conn.prepareStatement(UPDATE_PASSWORD_QUERY)) {
            pstmt.setString(1, newPassword);
            pstmt.setString(2, username);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error updating password: " + e.getMessage(), e);
        }
    }
}


    
    

