/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nezukoRent.database;

/**
 *
 * @author INFODAK
 */
public class UserData {
    private int id;
    private int activeRents;
    private String firstName,lastName,tele,email,addresse;

    public UserData(int id, String firstName, String lastName, String tele, String email, String addresse,int activeRents) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tele = tele;
        this.email = email;
        this.addresse = addresse;
        this.activeRents = activeRents;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTele() {
        return tele;
    }

    public String getEmail() {
        return email;
    }

    public String getAddresse() {
        return addresse;
    }

    public int getActiveRents() {
        return activeRents;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }
    
}
