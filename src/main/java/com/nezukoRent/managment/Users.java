package com.nezukoRent.managment;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.icons.FlatSearchIcon;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import ui.customcomponents.ClientCard;
import ui.customcomponents.Header;


public class Users extends javax.swing.JPanel {
    private static Color backgroundColor = new Color(237,241,244);
    private JPanel header;  
    private JPanel jpanel1,jPanel1_1,jPanel1_2;
    private JPanel jPanel1_1_1;
    private JLabel goBackIcon,appartementsLabel,usersLabel,analyticsLabel;
    private JTextField searchTextField;
    private JLabel settingIcon;
    private JPanel mainPanel,jpanel2,filterPanel,sortPanel,buttonsPanel;
    private JButton[] filterBtns;
    private JLabel sortLabel;
    private JPanel addBtnPanel;
    private JButton addBtn;
    private JPanel usersContainer;
    private JScrollPane scrollPanel;
    private JPanel usersGridPanel;
    private JPanel scrollPanelContainer;
    
    public Users() {
        initComponents();
        // START USERS JPANEL
        this.setLayout(new BorderLayout());
        
        // START HEADER 
        header = new Header();
        header.setBackground(backgroundColor);
        header.setLayout(new CardLayout(20,0));
        
        jpanel1 = new javax.swing.JPanel();
        jpanel1.setBackground(backgroundColor);
        jpanel1.setPreferredSize(new java.awt.Dimension(903, 45));
        jpanel1.setLayout(new BorderLayout());
        jpanel1.setSize(getWidth(), 50);
        
        // START JPANEL 1_1
        jPanel1_1 = new JPanel();
        
        // start JPANEL 1_1_1
        jPanel1_1_1 = new JPanel(new FlowLayout(FlowLayout.LEADING,15,0));
        jPanel1_1_1.setBackground(backgroundColor);
        
        goBackIcon = new JLabel();
        goBackIcon.setIcon(new ImageIcon(getClass().getResource("/left-arrow.png")));
        goBackIcon.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        
        appartementsLabel = new JLabel();
        appartementsLabel.setFont(new Font("Segoe UI", 1, 16));
        appartementsLabel.setForeground(new Color(192, 192, 192));
        appartementsLabel.setText("Appartements");
        appartementsLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        usersLabel = new JLabel();
        usersLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); 
        usersLabel.setText("Users");
        usersLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        analyticsLabel = new JLabel();
        analyticsLabel.setFont(new Font("Segoe UI", 1, 16));
        analyticsLabel.setForeground(new Color(192, 192, 192));
        analyticsLabel.setText("Analytics");
        analyticsLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        jPanel1_1_1.add(goBackIcon);
        jPanel1_1_1.add(appartementsLabel);
        jPanel1_1_1.add(usersLabel);
        jPanel1_1_1.add(analyticsLabel);
        
        // END JPANEL 1_1_1
        jPanel1_1.add(jPanel1_1_1);
        // END JPANEL 1_1
        // START JPANEL 1_2
        
        jPanel1_2 = new JPanel();
        searchTextField = new javax.swing.JTextField();
        searchTextField.setMargin(new java.awt.Insets(4, 30, 4, 2));
        searchTextField.setPreferredSize(new java.awt.Dimension(180, 30));
        searchTextField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT,"Search");
        FlatSearchIcon searchIcon = new FlatSearchIcon();
        searchTextField.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, searchIcon);
        
        settingIcon = new JLabel();
        settingIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        settingIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/settings.png"))); 
        settingIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        jPanel1_2.setLayout(new FlowLayout(FlowLayout.CENTER,20,5));
        jPanel1_2.setBackground(backgroundColor);
        jPanel1_2.add(searchTextField);
        jPanel1_2.add(settingIcon);
        
        // END JPANEL 1_2
        
        jpanel1.add(jPanel1_1, BorderLayout.WEST);
        jpanel1.add(jPanel1_2, BorderLayout.EAST);
        
        header.add(jpanel1, BorderLayout.CENTER);
        // END HEADER
        // START MAIN 
        mainPanel = new JPanel(new CardLayout(35, 5));
        mainPanel.setBackground(backgroundColor);
        
        jpanel2 = new JPanel(new BorderLayout());
        // START FILTER
        filterPanel = new javax.swing.JPanel();
        filterPanel.setBackground(backgroundColor);
        filterPanel.setLayout(new BorderLayout());
        
        // START SORT PANEL
        sortPanel = new javax.swing.JPanel();
        sortPanel.setPreferredSize(new Dimension(340, 78));
        sortPanel.setLayout(new BorderLayout());
        
        // label 
        sortLabel = new JLabel();
        sortLabel.setFont(new java.awt.Font("Segoe UI", 1, 15));
        sortLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sortLabel.setText("Sort : ");
        sortLabel.setPreferredSize(new Dimension(42, 20));
        // buttons : 
        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,25,0));
        GroupLayout buttonsPanelLayout = new GroupLayout(buttonsPanel);
        buttonsPanel.setLayout(buttonsPanelLayout);
        
        filterBtns = new JButton[3];
        String[] btnsText = {"A - Z","Date","Active Rents"};
        
        for (int i = 0 ; i < filterBtns.length ; i++) {
            filterBtns[i] = new JButton();
            JButton btn = filterBtns[i];
            btn.setBackground(i == 0 ? new Color(0,0,0) : new Color(109, 145, 129));
            btn.setFont(new Font("Segoe UI", 1, 12)); 
            btn.setForeground(new Color(255, 255, 255));
            btn.setText(btnsText[i]);
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        // COPY PAST CODE HA HAY BOY
        buttonsPanelLayout.setHorizontalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(filterBtns[0])
                .addGap(15, 15, 15)
                .addComponent(filterBtns[1])
                .addGap(15, 15, 15)
                .addComponent(filterBtns[2])
                .addGap(0, 68, Short.MAX_VALUE))
        );
        buttonsPanelLayout.setVerticalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsPanelLayout.createSequentialGroup()
                .addGroup(buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterBtns[0], javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterBtns[1], javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterBtns[2], javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        sortPanel.add(sortLabel, BorderLayout.WEST);
        sortPanel.add(buttonsPanel, BorderLayout.SOUTH);
        sortPanel.setBackground(backgroundColor);
        // END SORT PANEL
        // START ADD BTN PANEL
        addBtnPanel = new JPanel(new CardLayout(20, 20));
        addBtnPanel.setBackground(backgroundColor);
        
        addBtn = new JButton();
        addBtn.setBackground(new Color(109, 145, 129));
        addBtn.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        addBtn.setForeground(new Color(255, 255, 255));
        addBtn.setText("+");
        addBtn.setBorder(null);
        addBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addBtn.setPreferredSize(new Dimension(52, 52));
        addBtnPanel.add(addBtn);
        // END ADD BTN PANEL
        
        filterPanel.add(sortPanel, BorderLayout.WEST);
        filterPanel.add(addBtnPanel, BorderLayout.EAST);
        // END FILTER
        // START USERS CARDS PANEL
        /*usersContainer = new JPanel(new CardLayout(0,25)); // PANEL 12
        usersContainer.setBackground(backgroundColor);
        
        scrollPanelContainer = new JPanel(new CardLayout()); // PANEL 13
        scrollPanelContainer.setBackground(backgroundColor);
        
        scrollPanel = new JScrollPane();
        scrollPanel.setBackground(backgroundColor);
        usersGridPanel = new JPanel();
        usersGridPanel.setBackground(backgroundColor);
        int numberOfClients = 10;
        int numberOfCols = 2;
        int division = numberOfClients / numberOfCols;
        int numberOfRows = numberOfClients % numberOfCols != 0 ? division + 1 : division;
        for (int i = 0 ; i < numberOfClients ; i++) {
            usersGridPanel.add(new ClientCard());
        }
        usersGridPanel.setLayout(new GridLayout(numberOfRows,numberOfCols,20,20));
        scrollPanel.setViewportView(usersGridPanel);
        scrollPanelContainer.add(scrollPanel,"Card 2");
        usersContainer.add(scrollPanelContainer,"Card 2");*/
        usersContainer = new JPanel(new CardLayout(0,15)); // PANEL 12
        usersContainer.setBackground(backgroundColor);
        
        scrollPanel = new JScrollPane();
        scrollPanel.setBackground(backgroundColor);
        
        scrollPanelContainer = new JPanel(new CardLayout(10,10)); // PANEL 13
        scrollPanelContainer.setBackground(backgroundColor);
        
        usersGridPanel = new JPanel();
        usersGridPanel.setBackground(backgroundColor);
        int numberOfClients = 10;
        int numberOfCols = 2;
        int division = numberOfClients / numberOfCols;
        int numberOfRows = numberOfClients % numberOfCols != 0 ? division + 1 : division;
        for (int i = 0 ; i < numberOfClients ; i++) {
            usersGridPanel.add(new ClientCard());
        }
        usersGridPanel.setLayout(new GridLayout(numberOfRows,numberOfCols,20,20));
        scrollPanelContainer.add(usersGridPanel,"Card 2");
        scrollPanel.setViewportView(scrollPanelContainer);
        usersContainer.add(scrollPanel,"Card 2");
        // END SUSERS CARDS PANEL
        jpanel2.add(filterPanel, BorderLayout.NORTH);
        jpanel2.add(usersContainer,BorderLayout.CENTER);
        mainPanel.add(jpanel2);
        // END MAIN
        this.add(header,BorderLayout.NORTH);
        this.add(mainPanel,BorderLayout.CENTER);
        // END USERS JPANEL
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    // End of variables declaration                   
}
