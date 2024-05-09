/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nezukoRent.database;

/**
 *
 * @author yassin
 */
public class AppartementData {
    private int id;
    private String type;
    private double surface;
    private int chambres;
    private boolean disponibilite;
    private double prix;
    private int ville_id;
    private int quartier_id;
    private String descreption;
    private int contratID;

    public AppartementData(int id, String type, double surface, int chambres, boolean disponibilite, double prix, int ville_id, int quartier_id, String descreption) {
        this.id = id;
        this.type = type;
        this.surface = surface;
        this.chambres = chambres;
        this.disponibilite = disponibilite;
        this.prix = prix;
        this.ville_id = ville_id;
        this.quartier_id = quartier_id;
        this.descreption=descreption;
    }
    public AppartementData(int id, String type, double surface, int chambres, boolean disponibilite, double prix, int ville_id, int quartier_id, String descreption,int contratID) {
        this.id = id;
        this.type = type;
        this.surface = surface;
        this.chambres = chambres;
        this.disponibilite = disponibilite;
        this.prix = prix;
        this.ville_id = ville_id;
        this.quartier_id = quartier_id;
        this.descreption=descreption;
        this.contratID = contratID;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getSurface() {
        return surface;
    }

    public int getChambres() {
        return chambres;
    }

    public boolean isDisponibilite() {
        return disponibilite;
    }

    public double getPrix() {
        return prix;
    }

    public int getVilleId() {
        return ville_id;
    }

    public int getQuartierId() {
        return quartier_id;
    }
    
    public String getDescreption(){
        return this.descreption;
    }
    public int getContratId() {
        return this.contratID;
    }
}