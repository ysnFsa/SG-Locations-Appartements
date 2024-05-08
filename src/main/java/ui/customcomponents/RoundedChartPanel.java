/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.customcomponents;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author yassin
 */
public class RoundedChartPanel extends ChartPanel {

    private static final int arcWidth = 30; // Adjust corner curve
    private static final int arcHeight = 30; // Adjust corner curve

    public RoundedChartPanel(JFreeChart chart) {
        super(chart);
        setOpaque(false);
    }
    
    

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Shape clip = g2.getClip();
        g2.setClip(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), arcWidth, arcHeight));
        super.paintComponent(g);
        g2.setClip(clip);
    }
}
