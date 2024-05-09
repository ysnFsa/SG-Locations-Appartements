/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nezukoRent.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author INFODAK
 */
public class ContratTableHandler {
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    public static void createContratTable() {
        if(!DBConnect.checkTableExists("Contrat")) {
                 
                String sql = "CREATE TABLE IF NOT EXISTS Contrat (\n"
                + " id integer PRIMARY KEY,\n"
                + " date_debut date NOT NULL,\n"
                + " date_fin date NOT NULL,\n"
                + " id_client integer NOT NULL,\n"
                + " id_appartement integer NOT NULL,\n"
                + " FOREIGN KEY (id_client) REFERENCES User(id),\n"
                + " FOREIGN KEY (id_appartement) REFERENCES Appartement(id)\n"
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
    public static boolean isAppartementAvailableFromto(String from,String to,int appartementId) {
        String sql = "SELECT count(*) as counter FROM Contrat WHERE id_appartement = ? and ((? >= date_debut and ? <= date_fin) or (? >= date_debut and ? <= date_fin))";
        int counter = 0;
        try (Connection conn = DBConnect.connect();
            PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1,appartementId);
            preparedStatement.setString(2,from);
            preparedStatement.setString(3,to);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    counter = rs.getInt("counter");
                }
            }
            return counter == 0;
        } catch (SQLException e) {
            System.out.println("Error in isAppartementAvailableFromto");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    
 


    public static List<ContractData> getContracts(int months) {
    List<ContractData> filteredContracts = new ArrayList<>();
    
    // Calculate the date by subtracting the specified number of months from the current date
    LocalDate dateDebutFilter = LocalDate.now().minusMonths(months);
    
    String sql = "SELECT * FROM Contrat WHERE date_debut <= ?";
    
    try (Connection conn = DBConnect.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, dateDebutFilter.format(formatter));
        
        try (ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String dateDebut = rs.getString("date_debut");
                String dateFin = rs.getString("date_fin");
                int idClient = rs.getInt("id_client");
                int idAppartement = rs.getInt("id_appartement");
                
                ContractData contract = new ContractData(dateDebut, dateFin, idClient, idAppartement);
                filteredContracts.add(contract);
            }
        }
    } catch (SQLException e) {
        System.out.println("Error when retrieving filtered contracts");
        System.out.println(e.getMessage());
    }
    return filteredContracts; 
}
    
    


public static List<ContractData> getActiveContracts() {
    List<ContractData> activeContracts = new ArrayList<>();
    String sql = "SELECT * FROM Contrat WHERE date_fin > ?";
      LocalDate tmpToday = (LocalDate.now());

    try (Connection conn = DBConnect.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1,tmpToday.format(formatter));
        try (ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
               String dateDebut = rs.getString("date_debut");
               String dateFin = rs.getString("date_fin");
              
               
                int idClient = rs.getInt("id_client");
                int idAppartement = rs.getInt("id_appartement");
                
                ContractData contract = new ContractData(dateDebut, dateFin, idClient, idAppartement);
                activeContracts.add(contract);
            }
        }
    } catch (SQLException e) {
        System.out.println("Error when retrieving active contracts");
        System.out.println(e.getMessage());
    }
    return activeContracts; 

}
    
public static List<ContractData> getAllContracts() {
    List<ContractData> allContracts = new ArrayList<>();
    String sql = "SELECT * FROM Contrat ORDER BY date_debut DESC";
    
    try (Connection conn = DBConnect.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery()) {
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        while (rs.next()) {
            int id = rs.getInt("id");
        String dateDebut = rs.getString("date_debut");


String dateFin = rs.getString("date_fin");



            
            int idClient = rs.getInt("id_client");
            int idAppartement = rs.getInt("id_appartement");
            
            ContractData contract = new ContractData(dateDebut, dateFin, idClient, idAppartement);
            allContracts.add(contract);
        }
    } catch (SQLException e) {
        System.out.println("Error when retrieving contracts");
        System.out.println(e.getMessage());
    }
     System.out.println("*****==>" + allContracts.size());
    return allContracts; 
}




    

    //30jr
public static int releasedRents() {
    int count = 0;
       LocalDate tmpdDate = (LocalDate.now().minusMonths(1));
     LocalDate tmpToday = (LocalDate.now());
  
    String oneMonthEarlierDate = tmpdDate.format(formatter);
    String todayDate=tmpToday.format(formatter);
    String sql = "SELECT COUNT(*) AS contract_count FROM Contrat WHERE date_debut >= ? AND date_fin <= ?";
    
    try (Connection conn = DBConnect.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
         
         pstmt.setString(1, oneMonthEarlierDate);
        pstmt.setString(2, todayDate);
        
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                count = rs.getInt("contract_count");
            }
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return count; 
}
   
    public static int newRents() {
    int count = 0;
    
    LocalDate tmpdDate = (LocalDate.now().minusMonths(1));
     LocalDate tmpToday = (LocalDate.now());
  
    String oneMonthEarlierDate = tmpdDate.format(formatter);
    String todayDate=tmpToday.format(formatter);
    String sql = "SELECT COUNT(*) AS contract_count FROM Contrat WHERE date_debut >= ? AND date_fin > ?";

    try (Connection conn = DBConnect.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, oneMonthEarlierDate);
        pstmt.setString(2, todayDate);
        
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                count = rs.getInt("contract_count");
            }
        }
    } catch (SQLException e) {
  
        System.out.println(e.getMessage());
    }
    return count; 
}
    
    public static Map<ContractData, Integer> ContratsByMonth(int monthNumber , Boolean insideInterval) {
 Map<ContractData, Integer> contrats = new HashMap<>();
    
  
    int currentYear = LocalDate.now().getYear();
    
    LocalDate startDateOfMonthP = LocalDate.of(currentYear, monthNumber, 1);
    LocalDate endDateOfMonthP = startDateOfMonthP.withDayOfMonth(startDateOfMonthP.lengthOfMonth());
    
    
      String startDateOfMonth = startDateOfMonthP.format(formatter);
    String endDateOfMonth=endDateOfMonthP.format(formatter);
     String sql ="";
        System.out.println("oooooop : " +startDateOfMonth);
        if(insideInterval){
         sql = "SELECT * FROM Contrat WHERE date_debut BETWEEN ? AND ?";
        }else{
         sql = "SELECT * FROM Contrat WHERE date_debut <= ? AND date_fin > ?";
        }
    
    long daysActive;
    try (Connection conn = DBConnect.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        if(insideInterval){
             pstmt.setString(1, startDateOfMonth);
            pstmt.setString(2, endDateOfMonth);
        }else{
            pstmt.setString(1, startDateOfMonth);
            pstmt.setString(2, startDateOfMonth);
             //pstmt.setString(3, endDateOfMonth);
        }
 
 
        
        try (ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String dateDebut = rs.getString("date_debut");
                    String dateFin = rs.getString("date_fin");
                int idClient = rs.getInt("id_client");
                int idAppartement = rs.getInt("id_appartement");
                ContractData contract = new ContractData(dateDebut, dateFin, idClient, idAppartement);
                 LocalDate dateStart = LocalDate.parse(dateDebut, formatter);
              
                
                if(!insideInterval){
                    System.out.println("not inside +++++ : "+endDateOfMonth +" > "+dateFin);
                    if(Integer.valueOf(dateFin)>Integer.valueOf(endDateOfMonth)){
                         daysActive=ChronoUnit.DAYS.between(startDateOfMonthP, endDateOfMonthP);
                         System.out.println("here************ : "+daysActive);
                    }else{
                         LocalDate datEnd = LocalDate.parse(dateFin, formatter);
                           daysActive = ChronoUnit.DAYS.between(startDateOfMonthP, datEnd);
                    }
                }else{
                        if(Integer.valueOf(dateFin)>Integer.valueOf(endDateOfMonth)){
                        
                          LocalDate dateEND = LocalDate.parse(dateFin, formatter);
                         daysActive = ChronoUnit.DAYS.between(dateStart, endDateOfMonthP);
                        }else{
                         LocalDate dateEND = LocalDate.parse(dateFin, formatter);
                         daysActive = ChronoUnit.DAYS.between(dateStart, dateEND);
                        
                        }
                    
                 
                 
                 
                }
                contrats.put(contract, (int) daysActive);
            }
        }
    } catch (SQLException e) {
        System.out.println("Error when retrieving contracts in the specified month");
        System.out.println(e.getMessage());
    }
    return contrats; 
}
    
   //***********************


public static Map<Integer, Integer> contratsByMonth1(int monthNumber) {
    Map<Integer, Integer> apartmentCounts = new HashMap<>();

    // Get the current year and calculate the starting month based on the input
 
   LocalDate endDate = LocalDate.now();
    LocalDate startDate = endDate.minusMonths(monthNumber).withDayOfMonth(1);
    
  
    
    
      String startDateOfMonth = startDate.format(formatter);
    String endDateOfMonth=endDate.format(formatter);
        
    
    
    System.out.println("start date : " + startDateOfMonth );
   System.out.println("end date : " + endDateOfMonth );
    // SQL to select contracts within the date range
    String sql = "SELECT id_appartement FROM Contrat WHERE date_debut >= ? AND date_debut <= ?";

    try (Connection conn = DBConnect.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, startDateOfMonth);
        pstmt.setString(2, endDateOfMonth);

        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            int idAppartement = rs.getInt("id_appartement");
            apartmentCounts.put(idAppartement, apartmentCounts.getOrDefault(idAppartement, 0) + 1);
        }
    } catch (SQLException e) {
        System.out.println("Error when retrieving contracts in the specified time frame:");
        System.out.println(e.getMessage());
    }

    return apartmentCounts;
}

    
}
