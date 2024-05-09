/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nezukoRent.managment;

/**
 *
 * @author yassin
 */

import com.nezukoRent.database.VilleTableHandler;
import com.nezukoRent.database.VilleData;
import java.awt.Component;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import ui.customcomponents.RoundedButton;
public class Ville extends javax.swing.JPanel {
 DefaultListModel<VilleData> model = new DefaultListModel<>();

    /**
     * Creates new form Quartier
     */
    public Ville() {
        initComponents();
        RenderJlist();
 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new RoundedButton("" , 30);
        jPanel1 = new javax.swing.JPanel();
        jButton3 = new RoundedButton("" , 30);
        jButton2 = new RoundedButton("" , 30);

        setBackground(new java.awt.Color(237, 241, 244));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel1.setText("Villes");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jList1);
        displayVilles();

        jButton1.setBackground(new java.awt.Color(109, 145, 129));
        jButton1.setFont(new java.awt.Font("Meera", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Ajouter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(237, 241, 244));

        jButton3.setBackground(new java.awt.Color(255, 68, 121));
        jButton3.setFont(new java.awt.Font("Meera", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Effacer tout");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(109, 181, 154));
        jButton2.setFont(new java.awt.Font("Meera", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Supprimer");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jButton2)
                .addGap(27, 27, 27)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // VilleTableHandler.addVille(jTextField1.getText());
        // model.addElement(jTextField1.getText());
        
              String villeName = jTextField1.getText().trim(); 

            if (!villeName.isEmpty()) {
               
                int id = VilleTableHandler.addVille(villeName);
                if (id != -1) {
              
                    VilleData newVille = new VilleData(id, villeName);
                    model.addElement(newVille);  
                    jList1.ensureIndexIsVisible(model.getSize() - 1); 
                    jTextField1.setText(""); 
                } else {
                  
                    JOptionPane.showMessageDialog(null, "Failed to add new Ville.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
        
                JOptionPane.showMessageDialog(null, "Ville name cannot be empty.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        
      
          
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
          int selectedIndex = jList1.getSelectedIndex();
            if (selectedIndex != -1) {
                VilleData selectedVille = model.getElementAt(selectedIndex);
                boolean success = VilleTableHandler.deleteVille(selectedVille.getId());
                if (success) {
                    model.removeElementAt(selectedIndex);
                    JOptionPane.showMessageDialog(null, "Ville deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to delete the Ville.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
               
                JOptionPane.showMessageDialog(null, "Please select a Ville to delete.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
       if(JOptionPane.showConfirmDialog(null, "Are you sure you want to clear table Ville?", "Confirmation", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
        
        if( VilleTableHandler.ClearVille()){
            JOptionPane.showMessageDialog(null, "Ville deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE); 
            model.clear();
        }else{
         JOptionPane.showMessageDialog(null, "Failed to clear table Ville.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
       }
        

    }//GEN-LAST:event_jButton3ActionPerformed

    
private void displayVilles() {
    
    try {
        List<VilleData> villes = VilleTableHandler.getAllVilles(); 
        model.clear(); 

        for (VilleData ville : villes) {
            model.addElement(ville); 
        }

        jList1.setModel(model);
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error loading cities: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

private void RenderJlist(){

       jList1.setCellRenderer(new DefaultListCellRenderer() {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof VilleData) {
            setText(((VilleData) value).getName());
        }
        return this;
    }
});
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<VilleData> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
