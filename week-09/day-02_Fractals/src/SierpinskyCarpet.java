import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class SierpinskyCarpet {

    public static void mainDraw(Graphics graphics) {

        drawSquareFractal(0, 0, WIDTH, 5, graphics);
    }

    public static void drawSquareFractal(int x, int y, int size, int level, Graphics graphics) {
        if (level == 0) return;

        drawSquarePattern(x, y, size, graphics);

        drawSquareFractal(x, y, size / 3,level - 1, graphics);
        drawSquareFractal(x + size / 3, y, size / 3, level - 1, graphics);
        drawSquareFractal(x + size / 3 * 2, y, size / 3, level - 1, graphics);

        drawSquareFractal(x , y + size / 3, size / 3, level - 1, graphics);
        drawSquareFractal(x + size / 3 * 2, y + size / 3, size / 3, level - 1, graphics);

        drawSquareFractal(x, y + size / 3 * 2, size / 3, level - 1, graphics);
        drawSquareFractal(x + size / 3, y + size / 3 * 2, size / 3, level - 1, graphics);
        drawSquareFractal(x + size / 3 * 2, y + size / 3 * 2, size / 3, level - 1, graphics);
    }
/*
    public static void drawBiggerPattern(int x, int y, int size, Graphics graphics) {

        drawSquarePattern(x, y, size, graphics);

        drawSquarePattern(x, y, size / 3, graphics);
        drawSquarePattern(x + size / 3, y, size / 3, graphics);
        drawSquarePattern(x + size / 3 * 2, y, size / 3, graphics);

        drawSquarePattern(x , y + size / 3, size / 3, graphics);
        drawSquarePattern(x + size / 3 * 2, y + size / 3, size / 3, graphics);

        drawSquarePattern(x, y + size / 3 * 2, size / 3, graphics);
        drawSquarePattern(x + size / 3, y + size / 3 * 2, size / 3, graphics);
        drawSquarePattern(x + size / 3 * 2, y + size / 3 * 2, size / 3, graphics);
    }*/

    public static void drawSquarePattern(int x, int y, int size, Graphics graphics) {

        Color color = new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
        graphics.setColor(color);
        graphics.fillRect(x + size / 3, y + size / 3, size / 3, size / 3);

    }

    static int WIDTH = 600;
    static int HEIGHT = 600;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Drawing");
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImagePanel panel = new ImagePanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jFrame.add(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.pack();
    }

    static class ImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            mainDraw(graphics);
        }
    }
}
