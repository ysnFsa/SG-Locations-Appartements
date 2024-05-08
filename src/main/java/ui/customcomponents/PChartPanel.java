/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.customcomponents;

/**
 *
 * @author yassin
 */
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class PChartPanel extends JPanel {
    private Map<String, Integer> data;
    private final int margin = 20;
    private int colorIndex= 0;

    public PChartPanel(Map<String, Integer> data) {
        this.data = new HashMap<>(data); // Make a copy of the data
        setOpaque(false); // Make panel transparent
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawPieChart(g);
        drawLegend(g);
    }

    private void drawPieChart(Graphics g) {
        colorIndex=0;
        int total = data.values().stream().mapToInt(Integer::intValue).sum();
        int startAngle = 0;
        // Calculate the size to be the minimum of width and height of the panel minus margins
        int size = Math.min(getWidth(), getHeight()) - 4 * margin; // Adjust the size to have margins
        // Calculate x and y to center the chart
        int x = (getWidth() - size) / 2;
        int y = (getHeight() - size) / 2 - margin; // Adjust y to consider the legend below

        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            float percentage = (float) entry.getValue() / total;
            int angle = (int) (percentage * 360);

            g.setColor(getColor(entry.getKey()));
            g.fillArc(x, y, size, size, startAngle, angle);
            startAngle += angle;
        }
    }

    private void drawLegend(Graphics g) {
        colorIndex=0;
        int x = margin;
        int y = getHeight() - 2 * margin; // Position for legend
        int width = 20; // Width of color box
        int height = 10; // Height of color box
        int labelMargin = 5;

        for (String key : data.keySet()) {
            g.setColor(getColor(key));
            g.fillRect(x, y, width, height);
            g.setColor(Color.BLACK);
            g.drawString(key, x + width + labelMargin, y + height);

            x += width + labelMargin + g.getFontMetrics().stringWidth(key) + 10; // Adjust x for next legend
        }
    }

    private Color getColor(String name) {
        
        colorIndex++;
        switch (colorIndex) {
            case 1: return Color.BLUE;
            case 2: return Color.RED;
            case 3: return Color.ORANGE;
            case 5: return  Color.DARK_GRAY;
            case 4: return Color.YELLOW;
            default: return Color.GRAY;
        }
    }
}
