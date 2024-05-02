package com.nezukoRent.database;

public class QuartierData {
    private int id;
    private String name;
    private int id_ville; 

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

