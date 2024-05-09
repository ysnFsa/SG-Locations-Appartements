/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nezukoRent.database;

/**
 *
 * @author yassin
 */
public class PhotosData {
    
    private int id;
    private String path;
    private int appartementId;
    
    public PhotosData(int id , String path , int appartementId){
        this.id=id;
        this.path=path;
        this.appartementId=appartementId;
    }
    
    
    public int getId(){ return this.id;}
    public int getAppartementId(){ return this.appartementId;}
    public String getPath(){ return this.path;}
}
