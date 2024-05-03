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

public class AppartementTableHandler {

    // Method to create the Appartement table if it doesn't exist
    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Appartement (\n"
                   + " id integer PRIMARY KEY,\n"
                   + " type text NOT NULL,\n"
                   + " surface real NOT NULL,\n"
                   + " chambres integer NOT NULL,\n"
                   + " disponibilite boolean NOT NULL,\n"
                   + " meublee boolean NOT NULL,\n"
                   + " prix real NOT NULL,\n"
                   + " ville_id integer,\n"
                   + " quartier_id integer,\n"
                   + " FOREIGN KEY (ville_id) REFERENCES Ville(id),\n"
                   + " FOREIGN KEY (quartier_id) REFERENCES Quartier(id)\n"
                   + ");";
        try (Connection conn = DBConnect.connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Appartement table created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int addAppartement(String type, double surface, int chambres, boolean disponibilite,boolean meublee, double prix, int ville_id, int quartier_id) {
        String sql = "INSERT INTO Appartement (type, surface, chambres, disponibilite , prix, ville_id, quartier_id, meublee) VALUES (?, ?, ?, ?, ?, ?, ?,?);";
        int id = -1;
        try (Connection conn = DBConnect.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, type);
            pstmt.setDouble(2, surface);
            pstmt.setInt(3, chambres);
            pstmt.setBoolean(4, disponibilite);
            pstmt.setDouble(5, prix);
            pstmt.setInt(6, ville_id);
            pstmt.setInt(7, quartier_id);
             pstmt.setBoolean(8, meublee);
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

    public static boolean deleteAppartement(int id) {
        String sql = "DELETE FROM Appartement WHERE id = ?";
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

    public static List<AppartementData> getAllAppartements() {
        String sql = "SELECT id, type, surface, chambres, disponibilite, prix, ville_id, quartier_id FROM Appartement";
        List<AppartementData> appartements = new ArrayList<>();
        try (Connection conn = DBConnect.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String type = rs.getString("type");
                double surface = rs.getDouble("surface");
                int chambres = rs.getInt("chambres");
                boolean disponibilite = rs.getBoolean("disponibilite");
                double prix = rs.getDouble("prix");
                int ville_id = rs.getInt("ville_id");
                int quartier_id = rs.getInt("quartier_id");
                appartements.add(new AppartementData(id, type, surface, chambres, disponibilite, prix, ville_id, quartier_id));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching appartements: " + e.getMessage());
        }
        return appartements;
    }
}