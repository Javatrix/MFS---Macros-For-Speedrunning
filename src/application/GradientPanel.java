package application;

import javax.swing.*;
import java.awt.*;

public class GradientPanel extends JPanel {

    public static int VERTICAL = 0;
    public static int HORIZONTAL = 1;
    public static int DIAGONAL_UP = 2;
    public static int DIAGONAL_DOWN = 3;

    private Color color1, color2;
    private int dir;

    public GradientPanel(Color color1, Color color2, int dir) {
        this.color1 = color1;
        this.color2 = color2;
        this.dir = dir;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        GradientPaint gradient;

        if (dir == HORIZONTAL)
            gradient = new GradientPaint(0, getHeight() / 2, color1, getWidth(), getHeight() / 2, color2);
        else if (dir == VERTICAL)
            gradient = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
        else if (dir == DIAGONAL_UP)
            gradient = new GradientPaint(0, 0, color1, getWidth(), getHeight(), color2);
        else
            gradient = new GradientPaint(0, getHeight(), color1, getWidth(), 0, color2);

        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }

    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }
}
