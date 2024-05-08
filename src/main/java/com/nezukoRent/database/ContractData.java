/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nezukoRent.database;
import java.time.LocalDate;
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

   
}
