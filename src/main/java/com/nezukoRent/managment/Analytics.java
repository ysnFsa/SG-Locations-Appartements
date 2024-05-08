/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nezukoRent.managment;

import com.nezukoRent.database.AppartementData;
import com.nezukoRent.database.AppartementTableHandler;
import com.nezukoRent.database.ContractData;
import com.nezukoRent.database.ContratTableHandler;
import com.nezukoRent.database.UserTableHandler;
import com.nezukoRent.database.VilleTableHandler;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;
import ui.customcomponents.RoundedPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import ui.customcomponents.PChartPanel;
import ui.customcomponents.RoundedChartPanel;



/**
 *
 * @author yassin
 */
public class Analytics extends javax.swing.JPanel {

    /**
     * Creates new form Analytics
     */
   Login LoginFrame;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    public Analytics(Login login) {
        this.LoginFrame=login;
        initComponents();
         AdjustFrame();
        initC();
         initPieChar(0);
       

          // dataSetGen();
        //       setupAndDisplaySmoothLineGraph(jPanel7);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new RoundedPanel(30);
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new RoundedPanel(30);
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel5 = new RoundedPanel(30);
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel6 = new RoundedPanel(30);
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel9 = new RoundedPanel(30);
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel10 = new RoundedPanel(30);
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel7 = new RoundedPanel(30);
        jPanel4 = new RoundedPanel(30);
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(237, 241, 244));

        jPanel1.setBackground(new java.awt.Color(237, 241, 244));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Total Active Rents");

        jLabel3.setFont(new java.awt.Font("Liberation Mono", 1, 36)); // NOI18N
        jLabel3.setText("239");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel3)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("Earnings");

        jLabel6.setFont(new java.awt.Font("Liberation Mono", 1, 36)); // NOI18N
        jLabel6.setText("239");

        jLabel17.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 255));
        jLabel17.setText("(last 30 days)");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)))
                .addGap(0, 15, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel17))
                .addGap(40, 40, 40)
                .addComponent(jLabel6)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 255));
        jLabel4.setText("new rent");

        jLabel7.setFont(new java.awt.Font("Liberation Mono", 1, 36)); // NOI18N
        jLabel7.setText("239");

        jLabel16.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 255));
        jLabel16.setText("(last 30 days)");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel7)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel16))
                .addGap(34, 34, 34)
                .addComponent(jLabel7)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("released rent");

        jLabel8.setFont(new java.awt.Font("Liberation Mono", 1, 36)); // NOI18N
        jLabel8.setText("239");

        jLabel15.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 255));
        jLabel15.setText("(last 30 days)");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel8)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel15))
                .addGap(38, 38, 38)
                .addComponent(jLabel8)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "last 3 months", "last 6 months", "this year" }));
        jComboBox1.setSelectedIndex(2);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 255));
        jLabel9.setText("Appartements");

        jLabel10.setFont(new java.awt.Font("Liberation Mono", 1, 36)); // NOI18N
        jLabel10.setText("239");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel9))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel10)))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel9)
                .addGap(41, 41, 41)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 255));
        jLabel11.setText("Clients");

        jLabel12.setFont(new java.awt.Font("Liberation Mono", 1, 36)); // NOI18N
        jLabel12.setText("239");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel11))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel12)))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel11)
                .addGap(41, 41, 41)
                .addComponent(jLabel12)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(237, 241, 244));
        jPanel8.setLayout(new java.awt.GridLayout(1, 0, 100, 0));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 591, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 453, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel7);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 591, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 453, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel4);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "this month", "last month", "last 3 months", "all time" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Liberation Serif", 1, 18)); // NOI18N
        jLabel13.setText("Income Growth");

        jLabel14.setFont(new java.awt.Font("Liberation Serif", 1, 18)); // NOI18N
        jLabel14.setText("Top Rental Cities Distribution");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(325, 325, 325)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(10, 10, 10)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1276, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
       int nbMonth=-1;
        int selectedIndex=jComboBox1.getSelectedIndex();
        if(selectedIndex==1 ){
            nbMonth=6;
        }else if(selectedIndex==0){
            nbMonth=3;
        }
          dataSetGen(nbMonth);
       
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
           int nbMonth=0;
        int selectedIndex=jComboBox2.getSelectedIndex();
        if(selectedIndex==1){
            nbMonth=1;
        }else if(selectedIndex==2){
            nbMonth=3;
        }else if(selectedIndex==3){
                 nbMonth=999;
    }
          initPieChar(nbMonth);
    }//GEN-LAST:event_jComboBox2ActionPerformed

   public void AdjustFrame(){
        this.LoginFrame.setResizable(true);
        this.LoginFrame.AdjustSize(1400, 800);
        this.LoginFrame.setLocationRelativeTo(null);
           this.LoginFrame.setVisible(true);
   }
   



public void initC(){
    

 List<ContractData> contrats =  ContratTableHandler.getActiveContracts(); 
List<AppartementData> appartements = new ArrayList<>();
double earnings =0.0;
 System.out.println("count : " + contrats.size());
      for (ContractData contrat : contrats) {
          contrat.getIdAppartement();
          appartements.add(AppartementTableHandler.getAppartement( contrat.getIdAppartement()));
            System.out.println("ddd");
        }
      
        System.out.println(String.valueOf(getToatalEarning(appartements)));
      jLabel6.setText(String.valueOf(String.format("%.2f", getToatalEarning(appartements)))+ " DH");
      jLabel7.setText(String.valueOf(ContratTableHandler.newRents()));
      jLabel8.setText(String.valueOf(ContratTableHandler.releasedRents()));  
      jLabel10.setText(String.valueOf(AppartementTableHandler.getAllAppartements().size()));
       jLabel12.setText(String.valueOf(UserTableHandler.getUserCount()));
      
      jLabel3.setText(String.valueOf(contrats.size()));
     
      ///*************** logic dyl data set d graph *************
    dataSetGen(-1);
      

}
public void dataSetGen(int nbMonth){
    
      Map< Integer ,Double> dataSet = new HashMap<>();
     
     double totalIncome;
     int startIndex;
     if(nbMonth!=-1 && LocalDate.now().getMonthValue()-nbMonth>0){
         startIndex=LocalDate.now().getMonthValue()-nbMonth;
     }else{
         startIndex=1;
     }
       
       // LocalDate dateDebut = LocalDate.parse(dateDebutStr, formatter);
        //LocalDate dateFin = LocalDate.parse(dateFinStr, formatter);
     
    for( int i = startIndex ; i <=LocalDate.now().getMonthValue() ; i++){    
           totalIncome=0.0;
       for (Map.Entry<ContractData, Integer> entry : ContratTableHandler.ContratsByMonth(i , true).entrySet()) {
             System.out.println("contrat **** : " + entry.getKey().getIdAppartement() +  ":"+ entry.getValue() + "*** ");
            AppartementData appartement= AppartementTableHandler.getAppartement( entry.getKey().getIdAppartement());
            totalIncome+=(appartement.getPrix()/30)*entry.getValue();
        }
        
          for (Map.Entry<ContractData, Integer> entry : ContratTableHandler.ContratsByMonth(i , false).entrySet()) {
             System.out.println("contrat **** : " + entry.getKey().getIdAppartement() +  ":"+ entry.getValue() + "*** ");
            AppartementData appartement= AppartementTableHandler.getAppartement( entry.getKey().getIdAppartement());
            totalIncome+=(appartement.getPrix()/30)*entry.getValue();
        }
         dataSet.put(i, totalIncome);
            
    }
      System.out.println("data **** : " + dataSet + " ==>  ");
     initGraph(dataSet);
      /*
     System.out.println("j****************");
  
      dataSet.put(1 , 32000.0);
    dataSet.put(2 , 83200.0.0);
    dataSet.put(3 , 50000.0);
    dataSet.put(4 , 40000.0.0);
    dataSet.put(5 , 48000.0);
    dataSet.put(6 , 1900.0);
    dataSet.put(7 , 1900.0);
    initGraph(dataSet); */

}





public void initGraph(Map<Integer, Double> dataSet) {
   
    XYSeries series = new XYSeries("Income Data");
    for (Map.Entry<Integer, Double> entry : dataSet.entrySet()) {
        series.add(entry.getKey(), entry.getValue());
    }
    XYSeriesCollection dataset = new XYSeriesCollection();
    dataset.addSeries(series);


    JFreeChart chart = ChartFactory.createXYLineChart(
        "", 
        "Month", 
        "Income", 
        dataset,
        PlotOrientation.VERTICAL, 
        false, 
        false,
        false 
    );

  
    XYPlot plot = chart.getXYPlot();
    XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
    renderer.setSeriesLinesVisible(0, true);
    renderer.setSeriesShapesVisible(0, true);
    renderer.setSeriesPaint(0, Color.BLUE);
    renderer.setSeriesStroke(0, new BasicStroke(2.0f)); 
    renderer.setSeriesShape(0, new Ellipse2D.Double(-3, -3, 6, 6)); 

   
    NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
    xAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
    xAxis.setTickLabelsVisible(true);
    xAxis.setTickMarksVisible(true);
    xAxis.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
    xAxis.setTickLabelFont(new Font("SansSerif", Font.PLAIN, 10));

    chart.setAntiAlias(true);

    
    plot.setBackgroundPaint(Color.WHITE); 
    plot.setDomainGridlinesVisible(false); 
    plot.setRangeGridlinesVisible(false); 

    plot.setAxisOffset(RectangleInsets.ZERO_INSETS); 
    plot.setOutlineVisible(false); 

    plot.setRenderer(renderer);

  
    ChartPanel chartPanel =new RoundedChartPanel(chart);;
    chartPanel.setMouseWheelEnabled(false); 
    chartPanel.setPopupMenu(null);
    chartPanel.setPreferredSize(jPanel7.getSize()); 

    jPanel7.setLayout(new BorderLayout());
    jPanel7.removeAll(); 
    jPanel7.add(chartPanel, BorderLayout.CENTER);
    jPanel7.validate(); 

}

public double getToatalEarning(List<AppartementData> appartements ){
     double earnings= 0.0;
      LocalDate currentDate = LocalDate.now();
        int currentMonth = currentDate.getMonthValue();
        if(currentMonth<1) currentMonth=-1;
       System.out.println("siiiize ; :"  + appartements.size() );
    for (Map.Entry<ContractData, Integer> entry : ContratTableHandler.ContratsByMonth(currentMonth , true).entrySet()) {
             System.out.println("contrat **** : " + entry.getKey().getIdAppartement() +  ":"+ entry.getValue() + "*** ");
            AppartementData appartement= AppartementTableHandler.getAppartement( entry.getKey().getIdAppartement());
            earnings+=(appartement.getPrix()/30)*entry.getValue();
        }
    
     for (Map.Entry<ContractData, Integer> entry : ContratTableHandler.ContratsByMonth(currentMonth , false).entrySet()) {
             System.out.println("contrat **** : " + entry.getKey().getIdAppartement() +  ":"+ entry.getValue() + "*** ");
            AppartementData appartement= AppartementTableHandler.getAppartement( entry.getKey().getIdAppartement());
            earnings+=(appartement.getPrix()/30)*entry.getValue();
        }
   
 
 return earnings ;  
}

public void initPieChar(int nbMonth){
    
    
      Map< Integer ,Integer> contrats = new HashMap<>(); // <id_apprtmnt , counts>
      Map< Integer ,Integer> villes = new HashMap<>(); 
      Map< String ,Integer> dataset = new HashMap<>();
      contrats=ContratTableHandler.contratsByMonth1(nbMonth);
   
      
      for (Map.Entry<Integer, Integer> entry : contrats.entrySet()) {
                     // entry.getValue() / total;
           //contracts.put(idAppartement, apartmentCounts.getOrDefault(idAppartement, 0) + 1)
           int tmpV=AppartementTableHandler.getAppartement(entry.getKey()).getVilleId();
           AppartementTableHandler.getAppartement(entry.getKey()).getVilleId();
           villes.put(tmpV, villes.getOrDefault(tmpV, 0) + 1*entry.getValue());
     
    }
      
         for (Map.Entry<Integer, Integer> entry : villes.entrySet()) {
                     // entry.getValue() / total;
           //contracts.put(idAppartement, apartmentCounts.getOrDefault(idAppartement, 0) + 1)
           String  tmpName=  VilleTableHandler.getVilleNameById(entry.getKey());   // QuartierTableHandler.getquartierNameById(villes.getKey(1));
           
           dataset.put(tmpName, entry.getValue());
          
     
    }
      
      System.out.println(villes);
       System.out.println(dataset);
       jPanel4.removeAll();
       jPanel4.setLayout(new BorderLayout());
       PChartPanel chartPanel = new PChartPanel(dataset);
       jPanel4.add(chartPanel, BorderLayout.CENTER);
       jPanel4.revalidate();
       jPanel4.repaint();
      

}
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}