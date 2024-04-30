package ui.customcomponents;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.border.EmptyBorder;

public class CardPanel extends JPanel {
    private JLabel imageLabel;
    private ImageIcon originalImage;
    private int lastWidth = -1;

    public CardPanel(ImageIcon image, String titleText, String descriptionText) {
        this.originalImage = image; 
        setLayout(new BorderLayout(5, 5));
        setOpaque(false);
        setPreferredSize(new Dimension(100, 200));
        setMinimumSize(new Dimension(60, 180));
        setMaximumSize(new Dimension(100, 200));

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        add(imageLabel, BorderLayout.CENTER);

        JLabel titleLabel = new JLabel(titleText);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setBorder(new EmptyBorder(10, 10, 0, 10));

        JLabel descriptionLabel = new JLabel(descriptionText);
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        descriptionLabel.setBorder(new EmptyBorder(5, 10, 10, 10));

        JPanel infoPanel = new JPanel(new BorderLayout());
        infoPanel.setOpaque(false);
        infoPanel.add(titleLabel, BorderLayout.NORTH);
        infoPanel.add(descriptionLabel, BorderLayout.CENTER);

        add(infoPanel, BorderLayout.SOUTH);

        setImage(image);
    }

    private void setImage(ImageIcon image) {
        if (image != null) {
            Image img = image.getImage();
            if (img != null) {
                int width = this.getWidth() > 0 ? this.getWidth() : image.getIconWidth();
                int height = 180; 
                Image scaledImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                BufferedImage roundedImage = getRoundedImage(scaledImage, width, height);
                imageLabel.setIcon(new ImageIcon(roundedImage));
            } else {
                System.out.println("Couldn't load the img");
            }
        } else {
            System.out.println("Img is null");
        }
    }

    private BufferedImage getRoundedImage(Image image, int width, int height) {
        BufferedImage output = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = output.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setClip(new RoundRectangle2D.Double(0, 0, width, height, 20, 20));
        g2.drawImage(image, 0, 0, width, height, null);
        g2.dispose();

        return output;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        g2.dispose();
    }
}
