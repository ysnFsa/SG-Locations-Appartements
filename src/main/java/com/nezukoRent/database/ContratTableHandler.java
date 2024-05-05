/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nezukoRent.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author INFODAK
 */
public class ContratTableHandler {
    public static void createContratTable() {
        if(!DBConnect.checkTableExists("Contrat")) {
            String sql = "CREATE TABLE IF NOT EXISTS Contrat (\n"
                    + " id integer PRIMARY KEY,\n"
                    + " date_debut date NOT NULL,\n"
                    + " date_fin date NOT NULL,\n"
                    + " id_client intger NOT NULL, \n"
                    + " id_appartement integer NOT NULL \n"
                    + ");";
        
            try (Connection conn = DBConnect.connect();
                Statement stmt = conn.createStatement()) {
                stmt.execute(sql);
                System.out.println("Contrat table created.");
            } catch (SQLException e) {
                System.out.println("Error in Creating Contrat Table");
                System.out.println(e.getMessage());
            }
        }
    }
    public static void addContart(String dateDebut,String dateFin,int clientID,int appartementId) {
        String sql = "INSERT INTO Contrat (date_debut,date_fin,id_client,id_appartement) VALUES (?,?,?,?);";
        try (Connection conn = DBConnect.connect();
            PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1,dateDebut);
            preparedStatement.setString(2,dateFin);
            preparedStatement.setInt(3,clientID);
            preparedStatement.setInt(4,appartementId);
            preparedStatement.executeUpdate();
            System.out.println("Contrat inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error in adding Contart");
            System.out.println(e.getMessage());
        }
    }
}
