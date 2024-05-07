/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nezukoRent.database;

/**
 *
 * @author INFODAK
 */


import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        String sql = "SELECT id,firstName,lastName,tele,email,addresse FROM User";
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
                users.add(new UserData(id, firstName,lastName,tele,email,addresse));
            }
        } catch (SQLException e) {
            System.out.println("Error in fetching Users");
            System.out.println("Error fetching users: " + e.getMessage());
        }
        return users;
    }
    public static UserData getUser(int id) {
        String sql = "SELECT id,firstName,lastName,tele,addresse,email FROM User WHERE id = ?";
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
                    selectedUser = new UserData(id,firstName,lastName,addresse,tele,email);
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

        
        
    }

