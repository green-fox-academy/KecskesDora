import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FunctionToCenter {
    public static void mainDraw(Graphics graphics) {
        // Create a function that draws a single line and takes 3 parameters:
        // The x and y coordinates of the line's starting point and the graphics
        // and draws a line from that point to the center of the canvas.
        // Fill the canvas with lines from the edges, every 20 px, to the center.
        drawAllQuarters(graphics);
    }
    public static void drawAllQuarters(Graphics graphics) {
        drawFirstQuarter(graphics);
        drawSecondQuarter(graphics);
        drawThirdQuarter(graphics);
        drawFourthQuarter(graphics);
    }
    public static void drawFirstQuarter(Graphics graphics){
        int a = 0;
        for (int i = 0; i < WIDTH / 20; i++) {
            drawLine(0 + a, 0, graphics);
            a += 20;
            }
        }
    public static void drawSecondQuarter(Graphics graphics){
        int a = 0;
        for (int i = 0; i < HEIGHT / 20; i++) {
            drawLine(WIDTH, 0 + a, graphics);
            a += 20;
        }
    }
    public static  void drawThirdQuarter(Graphics graphics) {
        int a = 0;
        for (int i = 0; i < HEIGHT / 20; i++) {
            drawLine(0 + a, HEIGHT, graphics);
            a += 20;
        }
    }
    public static void drawFourthQuarter(Graphics graphics) {
        int a = 0;
        for (int i = 0; i < HEIGHT / 20; i++) {
            drawLine(0, 0 + a, graphics);
            a += 20;
        }
    }
    public static void drawLine (int x, int y, Graphics graphics) {
        graphics.drawLine(x, y, WIDTH / 2, HEIGHT / 2);
    }

    // Don't touch the code below
    static int WIDTH = 320;
    static int HEIGHT = 320;

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