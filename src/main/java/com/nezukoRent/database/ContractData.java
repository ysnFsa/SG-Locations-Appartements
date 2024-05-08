/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nezukoRent.database;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author yassin
 */


public class ContractData {
    private int id;
    private String dateDebut;
    private String dateFin;
    private int idClient;
    private int idAppartement;

    public ContractData(String dateDebut, String dateFin, int idClient, int idAppartement) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.idClient = idClient;
        this.idAppartement = idAppartement;
    }

    public int getId() {
        return id;
    }

 

    public String getDateDebut() {
        return dateDebut;
    }



    public String getDateFin() {
        return dateFin;
    }

 
    public int getIdClient() {
        return idClient;
    }

  

    public int getIdAppartement() {
        return idAppartement;
    }
    
        public static String formatDate(String dateString , String input , String output) {
        SimpleDateFormat inputFormat = new SimpleDateFormat(input);
        SimpleDateFormat outputFormat = new SimpleDateFormat(output);
        
        try {
            Date date = inputFormat.parse(dateString);
            return outputFormat.format(date);
        } catch (ParseException e) {
         
            e.printStackTrace();
            return null;
        }
        }
        
        public static long calculateDaysDifference(String startDateStr, String endDateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date startDate = sdf.parse(startDateStr);
            Date endDate = sdf.parse(endDateStr);
            long diffInMillies = endDate.getTime() - startDate.getTime();
            return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        } catch (ParseException e) {
            e.printStackTrace();
            return -1; 
        }
    }

   @Override
public String toString() {
    return "ContractData{" +
            
            ", dateDebut='" + dateDebut + '\'' +

            '}';
}

}
