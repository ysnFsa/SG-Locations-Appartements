/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nezukoRent.database;

/**
 *
 * @author INFODAK
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class UserTableHandler {
    public static void createUserTable() {
        if(!DBConnect.checkTableExists("User")) {
            String sql = "CREATE TABLE IF NOT EXISTS User (\n"
                    + " id integer PRIMARY KEY,\n"
                    + " firstName text NOT NULL,\n"
                    + " lastName text NOT NULL,\n"
                    + " tele text NOT NULL, \n"
                    + " email text NOT NULL, \n"
                    + " addresse text NOT NULL \n"
                    + ");";

            try (Connection conn = DBConnect.connect();
                Statement stmt = conn.createStatement()) {
                stmt.execute(sql);
                System.out.println("User table created.");
            } catch (SQLException e) {
                System.out.println("Error in Creating User Table");
                System.out.println(e.getMessage());
            }
        }
    }
    public static void addUser(String firstName,String lastName,String tele,String email,String addresse) {
        String sql = "INSERT INTO User (firstName,lastName,tele,email,addresse) VALUES (?,?,?,?,?);";
        try (Connection conn = DBConnect.connect();
            PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            String[] values = {firstName,lastName,tele,email,addresse};
            for (int i = 0 ; i < values.length ; i++) {
                preparedStatement.setString(i + 1, values[i]);
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error in adding User");
            System.out.println(e.getMessage());
        }
    }
    public static boolean setUser(int id,String firstName,String lastName,String tele,String email,String addresse) {
        String sql = "UPDATE user SET firstName = ?, lastName = ?,tele = ?,email = ?,addresse = ? WHERE id = ?;";
        try (Connection conn = DBConnect.connect();
            PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            String[] values = {firstName,lastName,tele,email,addresse};
            for (int i = 0 ; i < values.length ; i++) {
                preparedStatement.setString(i + 1, values[i]);
            }
            int ID_PARAMETER_INDEX = 6;
            preparedStatement.setInt(ID_PARAMETER_INDEX, id);
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public static boolean deleteUser(int id) {
        String sql = "DELETE FROM User WHERE id = ?";
        try (Connection conn = DBConnect.connect(); 
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0; 
        } catch (SQLException e) {
            System.out.println("Err deleting User: " + e.getMessage());
            return false; 
        }
    }
    public static List<UserData> getUsers() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate tmpToday = LocalDate.now();
        String todayFormatted = tmpToday.format(formatter);
        String sql = "SELECT id, firstName, lastName, tele, email, addresse, " +
                        "(SELECT COUNT(*) FROM contrat WHERE id_client = u.id AND date_fin > ?) AS activeRents " +
                     "FROM User u";

        List<UserData> users = new ArrayList<>();
        try (Connection conn = DBConnect.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, todayFormatted);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    String tele = rs.getString("tele");
                    String email = rs.getString("email");
                    String addresse = rs.getString("addresse");
                    int activeRents = rs.getInt("activeRents");
                    users.add(new UserData(id, firstName, lastName, tele, email, addresse, activeRents));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error in fetching Users: " + e.getMessage());
        }
        return users;
    }
    public static List<UserData> getOrderedUsersByName() {
        String sql = "SELECT id,firstName,lastName,tele,email,addresse,(SELECT count(*) from contrat WHERE id_client = u.id) as activeRents FROM User u ORDER BY firstName,lastName";
        List<UserData> users = new ArrayList<>();
        try (Connection conn = DBConnect.connect();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String tele = rs.getString("tele");
                String email = rs.getString("email");
                String addresse = rs.getString("addresse");
                int activeRents = rs.getInt("activeRents");
                users.add(new UserData(id, firstName,lastName,tele,email,addresse,activeRents));
            }
        } catch (SQLException e) {
            System.out.println("Error in fetching Ordered Users");
            System.out.println("Error fetching Ordered users: " + e.getMessage());
        }
        return users;
    }
public static List<UserData> getOrderedUsersByActiveRents() {
    LocalDate tmpToday = LocalDate.now();
    String todayFormatted = tmpToday.format(ContratTableHandler.formatter);
    String sql = "SELECT id, firstName, lastName, tele, email, addresse, " +
                 "(SELECT COUNT(*) FROM contrat WHERE id_client = u.id AND date_fin > ?) AS activeRents " +
                 "FROM User u ORDER BY activeRents DESC";
    List<UserData> users = new ArrayList<>();
    try (Connection conn = DBConnect.connect();
         PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
        preparedStatement.setString(1, todayFormatted);
        try (ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String tele = rs.getString("tele");
                String email = rs.getString("email");
                String addresse = rs.getString("addresse");
                int activeRents = rs.getInt("activeRents");
                users.add(new UserData(id, firstName, lastName, tele, email, addresse, activeRents));
            }
        }
    } catch (SQLException e) {
        System.out.println("Error in fetching Ordered Users");
        System.out.println("Error fetching Ordered users: " + e.getMessage());
    }
    return users;
}

    public static UserData getUser(int id) {
        String sql = "SELECT id,firstName,lastName,tele,email,addresse,(SELECT count(*) from contrat WHERE id_client = u.id) as activeRents FROM User u WHERE id = ?";
        UserData selectedUser = null;

        try (Connection conn = DBConnect.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    String addresse = rs.getString("addresse");
                    String tele = rs.getString("tele");
                    String email = rs.getString("email");
                    int activeRents = rs.getInt("activeRents");
                    selectedUser = new UserData(id,firstName,lastName,addresse,tele,email,activeRents);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error fetching User : " + e.getMessage());
        }

        return selectedUser;
    }
    

    public static boolean updateUser(int id, String firstName, String lastName, String tele, String email, String addresse) {
    String sql = "UPDATE User SET firstName = ?, lastName = ?, tele = ?, email = ?, addresse = ? WHERE Id = ?";

    try (Connection conn = DBConnect.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, firstName);
        pstmt.setString(2, lastName);
        pstmt.setString(3, tele);
        pstmt.setString(4, email);
        pstmt.setString(5, addresse);
        pstmt.setInt(6, id);

        int affectedRows = pstmt.executeUpdate();
        return affectedRows > 0;
    } catch (SQLException e) {
        System.out.println("Error updating user: " + e.getMessage());
        return false;
    }
}
    
     public static int getUserCount() {
        int count = 0;
        String sql = "SELECT COUNT(*) AS count FROM User;";

        try (Connection conn = DBConnect.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            System.out.println("Error getting user count");
            System.out.println(e.getMessage());
        }

        return count;
    }
     public static List<UserData> searchUser(String searchValue) {
        String sql = "SELECT id,firstName,lastName,tele,email,addresse,(SELECT count(*) from contrat WHERE id_client = u.id) as activeRents,(firstName || lastName) as name FROM User u WHERE name LIKE ?";
        List<UserData> users = new ArrayList<>();
        try (Connection conn = DBConnect.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,"%" + searchValue + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    String tele = rs.getString("tele");
                    String email = rs.getString("email");
                    String addresse = rs.getString("addresse");
                    int activeRents = rs.getInt("activeRents");
                    users.add(new UserData(id, firstName,lastName,tele,email,addresse,activeRents));
                }
            }
        } catch(SQLException e) {
            System.out.println("Error fetching searched users by name : " + e.getMessage());
        }
        return users;
    }
        
        
    }

