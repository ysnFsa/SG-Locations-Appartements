package com.nezukoRent.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yassin
 */
public class PhotosTableHandler {
    
    
    
          public static void createTable() {
String sql = "CREATE TABLE IF NOT EXISTS Photos (\n"
           + " id integer PRIMARY KEY,\n"
           + " path text NOT NULL,\n"
           + " appartement_id  integer NOT NULL,\n"
           + " FOREIGN KEY (appartement_id) REFERENCES Appartement(id)\n"
           + ");";

        try (Connection conn = DBConnect.connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Photos table created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
      
      
      public static void insertPhoto(String path, int appartementId) {
        String sql = "INSERT INTO Photos (path, appartement_id) VALUES (?, ?)";

        try (Connection conn = DBConnect.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, path);
            pstmt.setInt(2, appartementId);
            pstmt.executeUpdate();
            System.out.println("Photo inserted.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
      
 public static List<PhotosData> getPhotos(int appartementId) {
    String sql = "SELECT id, path, appartement_id FROM Photos WHERE appartement_id = ?";
    List<PhotosData> photos = new ArrayList<>();

    try (Connection conn = DBConnect.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, appartementId);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String path = rs.getString("path");
            int apartmentId = rs.getInt("appartement_id");
            
            PhotosData photo = new PhotosData(id, path, apartmentId);
            photos.add(photo);
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }

    return photos;
}
 public static String getPhoto(int appartementId) {
    String sql = "SELECT path FROM Photos WHERE appartement_id = ? LIMIT 1";
    String firstPath = null;

    try (Connection conn = DBConnect.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, appartementId);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            firstPath = rs.getString("path");
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }

    return firstPath;
}

 
 public static void updatePhotoPath(int id, String newPath) {
    String sql = "UPDATE Photos SET path = ? WHERE id = ?";
    
    try (Connection conn = DBConnect.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, newPath);
        pstmt.setInt(2, id);
        
        // Execute the update
        pstmt.executeUpdate();
        
        System.out.println("Photo path updated successfully!");
    } catch (SQLException e) {
        System.out.println("Error updating photo path: " + e.getMessage());
    }
}
 
    public static boolean deletePhotos(int id) {
        String sql = "DELETE FROM Photos WHERE appartement_id = ?";
        try (Connection conn = DBConnect.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("Error deleting appartement: " + e.getMessage());
            return false;
        }
    }


}
