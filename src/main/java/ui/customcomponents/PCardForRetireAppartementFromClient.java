/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.customcomponents;

import com.nezukoRent.database.AppartementData;
import com.nezukoRent.managment.ListAppartements;
import com.nezukoRent.managment.Login;
import java.awt.BorderLayout;

/**
 *
 * @author INFODAK
 */
public class PCardForRetireAppartementFromClient extends RoundJPanel {
    private Login loginFrame;
    private int clientId;
    private AppartementData appartement;
    private ListAppartements listAppartements;

    public PCardForRetireAppartementFromClient(Login LoginFrame,int clientId,AppartementData appartement,ListAppartements listAppartements) {
        
        super(30);
        this.loginFrame = LoginFrame;
        this.clientId = clientId;
        this.appartement = appartement;
        this.listAppartements = listAppartements;
        initComponents();
        initListCard();
     
    }
    private void initComponents() {

        jPanel1 = new RoundedPanel(30);
        jLabel1 =  new RoundedLabel("/icons/appr.jpg", 30,false , true);
        jPanel2 = new RoundedPanel(30);
        jPanel3 = new RoundedPanel(30);
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(228, 211, 231));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 214, 237));

        jLabel1.setBackground(new java.awt.Color(255, 214, 218));
        jLabel1.setIconTextGap(0);

        jPanel2.setBackground(new java.awt.Color(255, 214, 237));

        jPanel3.setBackground(new java.awt.Color(255, 214, 237));

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        jLabel6.setIconTextGap(1);

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        jLabel8.setIconTextGap(1);

        jLabel9.setBackground(new java.awt.Color(242, 208, 234));
        jLabel9.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        jLabel9.setIconTextGap(1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(23, 23, 23))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 333, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 79, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    public void initListCard(){
        int contratID = this.appartement.getContratId();
        PFooterForRetireAppertementToClient pc = new PFooterForRetireAppertementToClient(this.loginFrame,clientId,this.appartement,contratID,listAppartements);
        jPanel2.setLayout(new BorderLayout()); 
        jPanel2.remove(jPanel3);
        jPanel2.add(pc, BorderLayout.SOUTH);
        jPanel2.revalidate();
        jPanel2.repaint();
    }

    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6; // prix Label
    private javax.swing.JLabel jLabel7; // surface Label
    private javax.swing.JLabel jLabel8; // nombre de chambre label
    private javax.swing.JLabel jLabel9; // Ville Label
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
}
