import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class RainbowBoxFunction {
    public static void mainDraw(Graphics graphics) {
        // Create a square drawing function that takes 3 parameters:
        // The square size, the fill color, graphics
        // and draws a square of that size and color to the center of the canvas.
        // Create a loop that fills the canvas with rainbow colored squares (red, orange, yellow, green, blue, indigo, violet).
        int a = 200;
        Color color = Color.red;
        for (int i = 0; i < 7; i++) {

            if (i == 0) {
                color = Color.red;
            }
            if (i == 1) {
                color = Color.orange;
            }
            if (i == 2) {
                color = Color.yellow;
            }
            if (i == 3) {
                color = Color.green;
            }
            if (i == 4) {
                color = Color.blue;
            }
            if (i == 5) {
                color = new Color(75, 0, 130);
            }
            else if (i == 6) {
                color = new Color(50,0, 100);
            }
            drawSquare(a, color, graphics);
            a -= 20;
        }
    }
    public static void drawSquare(int size, Color color, Graphics graphics) {
        graphics.setColor(color);
        graphics.fillRect(WIDTH / 2 - size / 2, HEIGHT / 2 - size / 2, size, size);
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