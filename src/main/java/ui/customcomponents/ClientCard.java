package ui.customcomponents;

import com.nezukoRent.database.UserData;
import com.nezukoRent.managment.ListAppartements;
import com.nezukoRent.managment.Login;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClientCard extends RoundJPanel {
    private Login loginFrame;
    private JLabel userIcon;
    private JLabel fullNameLabel;
    private JLabel dateOfJoinLabel;
    private JLabel numberOfRentsLabel;
    private JPanel informationPanel;
    
    public ClientCard(int radius,Login loginFrame,UserData userInfo) {
        super(radius);
        this.loginFrame = loginFrame;
        String fullName = userInfo.getFirstName() + " " + userInfo.getLastName();
        String dateOfJoin = "2023/12/12";
        int numberOfRents = 10;
        
        setOpaque(false);
        this.setLayout(new CardLayout(15,15));
        
        JPanel container = new JPanel(new BorderLayout());
        
        Font textLarge = new Font("Liberation Sans",1,14);
        Font textSmall = new Font("Liberation Sans",1,12);
        
        this.userIcon = new JLabel("");
        this.userIcon.setIcon(scaleImageIcon(new ImageIcon(getClass().getResource("/icons/user.png")),70,50));
        userIcon.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        userIcon.setPreferredSize(new Dimension(90,100));
        
        this.informationPanel = new JPanel(new BorderLayout());
        
        JPanel panel1 = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(new BorderLayout());
        
        this.fullNameLabel = new JLabel(fullName);
        this.fullNameLabel.setFont(textLarge);
        JPanel panel11 = new JPanel(new FlowLayout(FlowLayout.RIGHT,15,0));
        
        JLabel editIcon = new JLabel(scaleImageIcon(new ImageIcon(getClass().getResource("/icons/edit.png")),30,30));
        JLabel plusIcon = new JLabel(scaleImageIcon(new ImageIcon(getClass().getResource("/icons/add_32inactive32.png")),30,30));
        JLabel deleteIcon = new JLabel(scaleImageIcon(new ImageIcon(getClass().getResource("/icons/wast_basket.png")),28,28));
        
        editIcon.setSize(new Dimension(30,30));
        plusIcon.setSize(new Dimension(30,30));
        deleteIcon.setSize(new Dimension(28,28));
        
        editIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        plusIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        // add event Handler to Plus ICON
        plusIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                assignAppartementMouseClicked(evt,userInfo.getId());
            }
        });
        
        panel11.add(editIcon);
        panel11.add(plusIcon);
        panel11.add(deleteIcon);
        panel11.setBackground(new Color(218,212,212));
        
        panel1.add(fullNameLabel,BorderLayout.WEST);
        panel1.add(panel11,BorderLayout.EAST);
        panel1.setBackground(new Color(218,212,212));
        
        
        this.dateOfJoinLabel = new JLabel("member since : " + dateOfJoin);
        this.dateOfJoinLabel.setFont(textSmall);
        this.numberOfRentsLabel = new JLabel("active rents : " + numberOfRents);
        this.numberOfRentsLabel.setFont(textSmall);
        
        panel2.add(numberOfRentsLabel,BorderLayout.WEST);
        panel2.add(dateOfJoinLabel,BorderLayout.EAST);
        panel2.setBackground(new Color(218,212,212));
        
        informationPanel.add(panel1,BorderLayout.NORTH);
        informationPanel.add(panel2,BorderLayout.SOUTH);
        informationPanel.setBackground(new Color(218,212,212));
        
        container.add(userIcon,BorderLayout.WEST);
        container.add(informationPanel,BorderLayout.CENTER);
        container.setBackground(new Color(218,212,212));
        
        
        
        add(container);
        this.setBackground(new Color(218,212,212));
        this.setPreferredSize(new Dimension(450,95));
        this.setMaximumSize(new Dimension(450,95));
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder());
    }
    private void assignAppartementMouseClicked(java.awt.event.MouseEvent evt,int clientId) {                                      
        ListAppartements desAppartements = new ListAppartements(this.loginFrame,clientId);
        JDialog overlayDialog = new JDialog(this.loginFrame, "Assigne appartement", Dialog.ModalityType.APPLICATION_MODAL);
        overlayDialog.setContentPane(desAppartements);
        overlayDialog.setSize(950, 623);
        overlayDialog.setLocationRelativeTo(this.loginFrame);
        overlayDialog.setVisible(true);

    }                                     
    private static ImageIcon scaleImageIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
}

