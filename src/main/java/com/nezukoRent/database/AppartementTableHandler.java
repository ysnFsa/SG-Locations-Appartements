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

public static void createTable() {
    String sql = "CREATE TABLE IF NOT EXISTS Appartement (\n"
               + " id integer PRIMARY KEY,\n"
               + " type text NOT NULL,\n"
               + " description text,\n"  
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
    
    //***************




public static int addAppartement( double surface, int chambres, boolean disponibilite, boolean meublee, double prix, int ville_id, int quartier_id, String description,String type) {
    String sql = "INSERT INTO Appartement (type, surface, chambres, disponibilite , prix, ville_id, quartier_id, meublee, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
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
        pstmt.setString(9, description); // Setting the description parameter
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



    //**************************
    
    
    
    
    

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
    String sql = "SELECT id, type, surface, chambres, disponibilite, prix, ville_id,description, quartier_id FROM Appartement";
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
            String descreption= rs.getString("description");
            appartements.add(new AppartementData(id, type, surface, chambres, disponibilite, prix, ville_id, quartier_id,descreption));
        }
    } catch (SQLException e) {
        System.out.println("Error fetching appartements: " + e.getMessage());
    }
    return appartements;
}
    
      public static void createImageTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Photos (\n"
                   + " id integer PRIMARY KEY,\n"
                   + " path text NOT NULL,\n"
                   + " FOREIGN KEY (appartement_id) REFERENCES Appartement(id),\n"
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
      
      public static List<String> getPhotos(int appartementId) {
        String sql = "SELECT path FROM Photos WHERE appartement_id = ?";
        List<String> photos = new ArrayList<>();

        try (Connection conn = DBConnect.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, appartementId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                photos.add(rs.getString("path"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return photos;
    }
      
      
      
public static List<AppartementData> getAllAppartementsFiltered(Integer villeid, Integer quartierId, String typeF,
        Integer prixMin, Integer prixMax, Integer surfaceMin, Integer surfaceMax, Integer chambre, boolean furnished, boolean disponible) {
          
    StringBuilder sqlBuilder = new StringBuilder();
    
    sqlBuilder.append("SELECT id, type, surface, chambres, disponibilite, prix, ville_id, description, quartier_id FROM Appartement WHERE 1 = 1");

    if (villeid != null && villeid!= -1) {
        sqlBuilder.append(" AND ville_id = ?");
    }
    if (quartierId != null && quartierId!= -1) {
        sqlBuilder.append(" AND quartier_id = ?");
    }
    if (typeF != null && !typeF.equals("None")) {
        sqlBuilder.append(" AND type = ?");
    }
    if (prixMin != null && prixMin != -1) {
        sqlBuilder.append(" AND prix >= ?");
    }
    if (prixMax != null && prixMax != -1) {
        sqlBuilder.append(" AND prix <= ?");
    }
    if (surfaceMin != null && surfaceMin != -1) {
        sqlBuilder.append(" AND surface >= ?");
    }
    if (surfaceMax != null && surfaceMax != -1) {
        sqlBuilder.append(" AND surface <= ?");
    }
    if (chambre != null && chambre != -1) {
        sqlBuilder.append(" AND chambres = ?");
    }
    if (furnished) {
        sqlBuilder.append(" AND meublee = 1");
    }
    if (!disponible) {
        sqlBuilder.append(" AND disponibilite = 0");
    }
  
    List<AppartementData> appartements = new ArrayList<>();
    try (Connection conn = DBConnect.connect();
         PreparedStatement pstmt = conn.prepareStatement(sqlBuilder.toString())) {
        int parameterIndex = 1;

        if (villeid != null && villeid!= -1) {
            pstmt.setInt(parameterIndex++, villeid);
        }
        if (quartierId != null && quartierId!= -1) {
            pstmt.setInt(parameterIndex++, quartierId);
        }
        if (typeF != null && !typeF.equals("None")) {
            pstmt.setString(parameterIndex++, typeF);
        }
        if (prixMin != null && prixMin != -1) {
            pstmt.setInt(parameterIndex++, prixMin);
        }
        if (prixMax != null && prixMax != -1) {
            pstmt.setInt(parameterIndex++, prixMax);
        }
        if (surfaceMin != null && surfaceMin != -1) {
            pstmt.setInt(parameterIndex++, surfaceMin);
        }
        if (surfaceMax != null && surfaceMax != -1) {
            pstmt.setInt(parameterIndex++, surfaceMax);
        }
        if (chambre != null && chambre != -1) {
            pstmt.setInt(parameterIndex++, chambre);
        }

        try (ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String type = rs.getString("type");
                double surface = rs.getDouble("surface");
                int chambres = rs.getInt("chambres");
                boolean disponibilite = rs.getBoolean("disponibilite");
                double prix = rs.getDouble("prix");
                int ville_id = rs.getInt("ville_id");
                int quartier_id = rs.getInt("quartier_id");
                String descreption= rs.getString("description");
                appartements.add(new AppartementData(id, type, surface, chambres, disponibilite, prix, ville_id, quartier_id, descreption));
            }
        }
    } catch (SQLException e) {
        System.out.println("Error fetching filtered appartements: " + e.getMessage());
    }
    return appartements;
}

      
      
      
      public static boolean updateAppartement(int id, double surface, int chambres, boolean disponibilite, boolean meublee, double prix, int ville_id, int quartier_id, String description,String type) {
    String sql = "UPDATE Appartement SET type = ?, surface = ?, chambres = ?, disponibilite = ?, prix = ?, ville_id = ?, quartier_id = ?, meublee = ?, description = ? WHERE id = ?";
    try (Connection conn = DBConnect.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, type);
        pstmt.setDouble(2, surface);
        pstmt.setInt(3, chambres);
        pstmt.setBoolean(4, disponibilite);
        pstmt.setDouble(5, prix);
        pstmt.setInt(6, ville_id);
        pstmt.setInt(7, quartier_id);
        pstmt.setBoolean(8, meublee);
        pstmt.setString(9, description);
        pstmt.setInt(10, id);
        int affectedRows = pstmt.executeUpdate();
        return affectedRows > 0;
    } catch (SQLException e) {
        System.out.println("Error updating appartement: " + e.getMessage());
        return false;
    }
}
    public static AppartementData getAppartement(int id) {
        String sql = "SELECT id, type, surface, chambres, disponibilite, prix, ville_id, quartier_id,description FROM Appartement WHERE id = ?";
        AppartementData selectedAppartement = null;

        try (Connection conn = DBConnect.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String type = rs.getString("type");
                    double surface = rs.getDouble("surface");
                    int chambres = rs.getInt("chambres");
                    Boolean disponibilite = rs.getBoolean("disponibilite");
                    double prix = rs.getDouble("prix");
                    int ville_id = rs.getInt("ville_id");
                    int quartier_id = rs.getInt("quartier_id");
                    String description = rs.getString("description");
                    selectedAppartement = new AppartementData(id,type,surface,chambres,disponibilite,prix,ville_id,quartier_id,description);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error fetching Appartement : " + e.getMessage());
        }

        return selectedAppartement;
    }

      
      
      
}