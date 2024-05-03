package com.nezukoRent.database;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yassin
 */


public class SetupDB {
   
             public  SetupDB(){
   
              }
             
             public static void Setup(){ 
             
              AdminTableHandler.initializeAdminProfile();
               VilleTableHandler.createTable();
               QuartierTableHandler.createTable();
               AppartementTableHandler.createTable();
             }
}
