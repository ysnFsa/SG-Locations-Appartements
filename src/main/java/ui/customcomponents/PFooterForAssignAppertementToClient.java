package ui.customcomponents;

import com.nezukoRent.database.AppartementData;
import com.nezukoRent.database.QuartierTableHandler;
import com.nezukoRent.database.VilleTableHandler;
import com.nezukoRent.managment.Assignrent;
import com.nezukoRent.managment.Login;
import java.awt.Dialog;
import javax.swing.JDialog;

/**
 *
 * @author INFODAK
 */
public class PFooterForAssignAppertementToClient extends RoundedPanel {
    private Login LoginFrame;
    private int clientId;
    private AppartementData appartement;
    /**
     * Creates new form PcardFooter
     */
    public PFooterForAssignAppertementToClient() {
        super(30);
        initComponents();
    }
    public PFooterForAssignAppertementToClient(Login LoginFrame,int clientId,AppartementData appartement) {
        super(30);
        this.LoginFrame = LoginFrame;
        this.clientId = clientId;
        this.appartement = appartement;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(237, 234, 230));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add_inactive_ysn.png"))); // NOI18N
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        jLabel5.setText("Ville: " + VilleTableHandler.getVilleNameById(this.appartement.getVilleId()));
        jLabel5.setIconTextGap(1);

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        jLabel4.setText("quartier: " + QuartierTableHandler.getquartierNameById(this.appartement.getQuartierId()));
        jLabel4.setIconTextGap(1);

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        jLabel2.setText("Prix: " + this.appartement.getPrix() + "DH");
        jLabel2.setIconTextGap(1);

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        jLabel3.setText("Surface: "+this.appartement.getSurface()+"m²");

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        jLabel6.setText(this.appartement.getType());
        jLabel6.setIconTextGap(1);

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        jLabel7.setText("chambre: " + this.appartement.getChambres());
        jLabel7.setIconTextGap(1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(28, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))))
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Assignrent assignToClientForum = new Assignrent(clientId,this.appartement.getId() , this.LoginFrame);
        JDialog overlayDialog = new JDialog(this.LoginFrame, "info de client", Dialog.ModalityType.APPLICATION_MODAL);
        overlayDialog.setContentPane(assignToClientForum);
        overlayDialog.setSize(950, 623);
        overlayDialog.setLocationRelativeTo(this.LoginFrame);
        overlayDialog.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
}
