/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nezukoRent.database;

/**
 *
 * @author yassin
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QuartierTableHandler {

    // Method to create the QuartierData table if it doesn't exist
    public static void createTable() {
        if(!DBConnect.checkTableExists("Quartier")){
             String sql = "CREATE TABLE IF NOT EXISTS Quartier (\n"
                   + " id integer PRIMARY KEY,\n"
                   + " name text NOT NULL\n"
                   + ");";
        
        try (Connection conn = DBConnect.connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Quartier table created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        }
   
    }

    private static boolean isTableEmpty(Connection conn) throws SQLException {
        String sqlCheck = "SELECT count(*) AS count FROM Quartier;";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sqlCheck)) {
            if (rs.next()) {
                return rs.getInt("count") == 0;
            }
        }
        return false;
    }


  public static boolean deleteQuartier(int id) {
        String sql = "DELETE FROM Quartier WHERE id = ?";
        try (Connection conn = DBConnect.connect(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0; 
        } catch (SQLException e) {
            System.out.println("Err deleting Quartier: " + e.getMessage());
            return false; 
        }
    }
public static int addQuartier(String name) {
    int quartierId = -1; // Default value indicating failure
    String sql = "INSERT INTO Quartier (name) VALUES (?);";
    try (Connection conn = DBConnect.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        pstmt.setString(1, name);
        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected == 1) {
          
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                quartierId = rs.getInt(1); 
            }
            
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return quartierId;
}

   
    public static boolean checkQuartierExists(String name) {
        String sql = "SELECT id FROM Quartier WHERE name = ?";
        try (Connection conn =  DBConnect.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public static List<QuartierData> getAllQuartiers() {
        String sql = "SELECT id, name FROM Quartier";
        List<QuartierData> quartiers = new ArrayList<>();
        try (Connection conn = DBConnect.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                quartiers.add(new QuartierData(id, name));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching quartiers: " + e.getMessage());
        }
        return quartiers;
    }
}
