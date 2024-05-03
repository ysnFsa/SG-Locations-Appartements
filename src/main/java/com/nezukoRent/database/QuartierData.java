/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nezukoRent.database;

/**
 *
 * @author User
 */
public class QuartierData {
    private int id;
    private String name;
    private int id_ville; // New field to represent the foreign key

    public QuartierData(int id, String name, int id_ville) {
        this.id = id;
        this.name = name;
        this.id_ville = id_ville;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getIdVille() {
        return id_ville;
    }
}

