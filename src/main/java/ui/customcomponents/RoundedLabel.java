package ui.customcomponents;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class RoundedLabel extends JLabel {
    private BufferedImage image;
    private int radius; 
    private boolean roundAllCorners;

    /**
     * Constructor for RoundedLabel.
     * @param imagePath Path to the image or resource name ex : Resource : /icons/img.png ; Fullpath : /home/yassin/img.png
     * @param radius Radius for rounded corners
     * @param roundAllCorners If true round all corners...if false only top
     * @param fromResource If true load from resources if false  load from file system.
     */
    public RoundedLabel(String imagePath, int radius, boolean roundAllCorners, boolean fromResource) {
        this.radius = radius;
        this.roundAllCorners = roundAllCorners;
        try {
            if (fromResource) {
            
                InputStream is = getClass().getResourceAsStream(imagePath);
                if (is != null) {
                    image = ImageIO.read(is);
                } else {
                    System.out.println("Resource not found: " + imagePath);
                }
            } else {
                image = ImageIO.read(new File(imagePath));
            }
        } catch (Exception e) {
            System.out.println("Error loading image: " + e.getMessage());
        }
        setOpaque(false);
    }

    private BufferedImage resizeImage(BufferedImage originalImage, int width, int height) {
        Image resultingImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = outputImage.createGraphics();
        g2.drawImage(resultingImage, 0, 0, null);
        g2.dispose();
        return outputImage;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (image != null && (image.getWidth() != getWidth() || image.getHeight() != getHeight())) {
            image = resizeImage(image, getWidth(), getHeight());
           //  image = resizeImage(image, 300, 300);
        }

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Area area;
        if (roundAllCorners) {
            area = new Area(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), radius, radius));
        } else {
            RoundRectangle2D roundedTop = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), radius, radius);
            Rectangle bottomRect = new Rectangle(0, getHeight() - radius / 2, getWidth(), radius / 2);
            area = new Area(roundedTop);
            area.add(new Area(bottomRect));
        }

        g2d.setClip(area);
        g2d.drawImage(image, 0, 0, this);
        g2d.setColor(getForeground());
        g2d.setFont(getFont());
        FontMetrics fm = g2d.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(getText())) / 2;
        int y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
        g2d.drawString(getText(), x, y);
        g2d.dispose();
    }
}
