package ui.customcomponents;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClientCard extends JPanel {
    private JLabel userIcon;
    private JLabel fullNameLabel;
    private JLabel dateOfJoinLabel;
    private JLabel numberOfRentsLabel;
    private JPanel informationPanel;
    
    public ClientCard() {
        String fullName = "ISMAIL ER-RAMDANY";
        String dateOfJoin = "2023/12/12";
        int numberOfRents = 10;
        
        setOpaque(false);
        this.setLayout(new CardLayout(15,15));
        
        JPanel container = new JPanel(new BorderLayout());
        
        this.userIcon = new JLabel("");
        this.userIcon.setIcon(new ImageIcon("C:\\Users\\INFODAK\\Documents\\NetBeansProjects\\J2eeProject\\src\\main\\resources\\icons8-user-50.png"));
        userIcon.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        userIcon.setPreferredSize(new Dimension(70,50));
        
        this.informationPanel = new JPanel(new BorderLayout());
        
        JPanel panel1 = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(new BorderLayout());
        
        this.fullNameLabel = new JLabel(fullName);
        this.fullNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        JPanel panel11 = new JPanel(new FlowLayout());
        
        JLabel editIcon = new JLabel(scaleImageIcon(new ImageIcon("C:\\Users\\INFODAK\\Documents\\NetBeansProjects\\J2eeProject\\src\\main\\resources\\icons8-edit-50.png"),30,30));
        JLabel plusIcon = new JLabel(scaleImageIcon(new ImageIcon("C:\\Users\\INFODAK\\Documents\\NetBeansProjects\\J2eeProject\\src\\main\\resources\\icons8-plus-50.png"),30,30));
        JLabel deleteIcon = new JLabel(scaleImageIcon(new ImageIcon("C:\\Users\\INFODAK\\Documents\\NetBeansProjects\\J2eeProject\\src\\main\\resources\\icons8-trash-64.png"),30,30));
        
        editIcon.setSize(new Dimension(30,30));
        plusIcon.setSize(new Dimension(30,30));
        deleteIcon.setSize(new Dimension(30,30));
        
        editIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        plusIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        
        panel11.add(editIcon);
        panel11.add(plusIcon);
        panel11.add(deleteIcon);
        panel11.setBackground(new Color(218,212,212));
        
        panel1.add(fullNameLabel,BorderLayout.WEST);
        panel1.add(panel11,BorderLayout.EAST);
        panel1.setBackground(new Color(218,212,212));
        
        
        this.dateOfJoinLabel = new JLabel("member since : " + dateOfJoin);
        this.dateOfJoinLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));
        this.numberOfRentsLabel = new JLabel("active rents : " + numberOfRents);
        this.numberOfRentsLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));
        
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
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int arcSize = 20; 
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, width, height, arcSize, arcSize);
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, width - 1, height - 1, arcSize, arcSize);
    }
    private static ImageIcon scaleImageIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
}
