package ui.customcomponents;

import com.nezukoRent.database.UserData;
import com.nezukoRent.database.UserTableHandler;
import com.nezukoRent.managment.ListAppartements;
import com.nezukoRent.managment.Login;
import com.nezukoRent.managment.UserForm;
import com.nezukoRent.managment.Users;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ClientCard extends RoundJPanel {   

    private UserData userInfo;
    private Users usersPanel;
    private Login loginFrame;
    private JLabel userIcon;
    private JLabel fullNameLabel;
 //   private JLabel dateOfJoinLabel;
    private JLabel numberOfRentsLabel;
    private JPanel informationPanel;
    
  /*  public ClientCard(int radius, Login loginFrame, UserData userInfo, Users usersPanel) {
        super(radius);
        this.loginFrame = loginFrame;
        this.userInfo = userInfo;
        // Constructor code...
        this.usersPanel = usersPanel;
    }*/
    
    public ClientCard(int radius, Login loginFrame,UserData userInfo,Users usersPanel) {
        super(radius);
        this.loginFrame = loginFrame;
        this.userInfo = userInfo;
        // Constructor code...
        this.usersPanel = usersPanel;
        
        String fullName = userInfo.getFirstName() + " " + userInfo.getLastName();
    //    String dateOfJoin = "2023/12/12";
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
        
        plusIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                assignAppartementMouseClicked(evt,userInfo.getId());
            }
        });
        

        // add event Handler to delete ICON
        deleteIcon.addMouseListener(new java.awt.event.MouseAdapter() {  
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        deleteUserMouseClicked(evt, userInfo);
    
      }
        
    }
        );
        
        // add event Handler to edit ICON
        editIcon.addMouseListener(new java.awt.event.MouseAdapter() {  
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        editMouseClicked(evt, userInfo);
    
      }
        
    }
        );
        
        
        
        
        panel11.add(editIcon);
        panel11.add(plusIcon);
        panel11.add(deleteIcon);
        panel11.setBackground(new Color(218,212,212));
        
        panel1.add(fullNameLabel,BorderLayout.WEST);
        panel1.add(panel11,BorderLayout.EAST);
        panel1.setBackground(new Color(218,212,212));
        
        
    /*    this.dateOfJoinLabel = new JLabel("member since : " + dateOfJoin);
        this.dateOfJoinLabel.setFont(textSmall); */
        this.numberOfRentsLabel = new JLabel("active rents : " + numberOfRents);
        this.numberOfRentsLabel.setFont(textSmall);
        
        panel2.add(numberOfRentsLabel,BorderLayout.WEST);
    //    panel2.add(dateOfJoinLabel,BorderLayout.EAST);
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
    
    private void editMouseClicked(java.awt.event.MouseEvent evt,UserData userInfo) {                                      
        UserForm editClient = new UserForm(this.loginFrame,  userInfo );
        JDialog overlayDialog = new JDialog(this.loginFrame, "Edit User", Dialog.ModalityType.APPLICATION_MODAL);
        overlayDialog.setContentPane(editClient);
        overlayDialog.setSize(600, 700);
        overlayDialog.setLocationRelativeTo(this.loginFrame);
        overlayDialog.setVisible(true);

    }   
    
    private void deleteUserMouseClicked(java.awt.event.MouseEvent evt, UserData userInfo) {
    int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this user?", "Delete User", JOptionPane.YES_NO_OPTION);

    if (result == JOptionPane.YES_OPTION) {
        if (UserTableHandler.deleteUser(userInfo.getId())) {
            // Call the fetchAndUpdateUsers() method directly from the Users class
            usersPanel.fetchAndUpdateUsers();
        } else {
            JOptionPane.showMessageDialog(this, "Error deleting user.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
    
    private List<UserData> fetchUsers() {
        try {
            List<UserData> users = UserTableHandler.getUsers();
            return users;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    
    
    private static ImageIcon scaleImageIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
}

