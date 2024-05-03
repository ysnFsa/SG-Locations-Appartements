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

public class VilleTableHandler {

    // Method to create the VilleData table if it doesn't exist
    public static void createTable() {
        if(!DBConnect.checkTableExists("Ville")) {
            String sql = "CREATE TABLE IF NOT EXISTS Ville (\n"
                   + " id integer PRIMARY KEY,\n"
                   + " name text NOT NULL\n"
                   + ");";
        
            try (Connection conn = DBConnect.connect();
                 Statement stmt = conn.createStatement()) {
                stmt.execute(sql);
                System.out.println("Ville table created.");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

public static int addVille(String name) {
    String sql = "INSERT INTO Ville (name) VALUES (?);";
    int id = -1; 

    try (Connection conn = DBConnect.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        pstmt.setString(1, name);
        int affectedRows = pstmt.executeUpdate();

        
        if (affectedRows > 0) {
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    id = rs.getInt(1); 
                }
            }
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return id;
}

  public static boolean deleteVille(int id) {
        String sql = "DELETE FROM Ville WHERE id = ?";
        try (Connection conn = DBConnect.connect(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0; 
        } catch (SQLException e) {
            System.out.println("Err deleting Ville: " + e.getMessage());
            return false; 
        }
    }
  
  
    public static boolean ClearVille() {
        String sql = "DELETE FROM Ville ";
        try (Connection conn = DBConnect.connect(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
         
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0; 
        } catch (SQLException e) {
            System.out.println("Err Clearing table Ville: " + e.getMessage());
            return false; 
        }
    }

    public static boolean checkVilleExists(String name) {
        String sql = "SELECT id FROM Ville WHERE name = ?";
        try (Connection conn = DBConnect.connect();
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
    
    public static List<VilleData> getAllVilles() {
        String sql = "SELECT id, name FROM Ville";
        List<VilleData> villes = new ArrayList<>();
        try (Connection conn = DBConnect.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                villes.add(new VilleData(id, name));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching villes: " + e.getMessage());
        }
        return villes;
    }
    
    public static String getVilleNameById(int id) {
        String sql = "SELECT name FROM Ville WHERE id = ?";
        String villeName = null;

        try (Connection conn = DBConnect.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    villeName = rs.getString("name");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error fetching ville name: " + e.getMessage());
        }

        return villeName;
    }
}
