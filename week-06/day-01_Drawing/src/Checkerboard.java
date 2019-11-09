import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Checkerboard {
    public static void mainDraw(Graphics graphics) {
        // Fill the canvas with a checkerboard pattern.
        drawOddRaws(graphics);
        drawEvenRaws(graphics);
    }


    public static void drawOddRaws(Graphics graphics) {
        int b = 0;
        for (int j = 0; j < 4; j++){
            int a = 0;
            for (int i = 0; i < 4; i++) {
                drawSquare(WIDTH / 8 + a, 0 + b, graphics);
                a += WIDTH / 4;
            }
            b += HEIGHT / 4;
        }
    }
    public static void drawEvenRaws(Graphics graphics) {
        int b = 0;
        for (int j = 0; j < 4; j++) {
            int a = 0;
            for (int i = 1; i < 5; i++) {
                drawSquare(0 + a, HEIGHT / 8 + b, graphics);
                a += WIDTH / 4;
            }
            b += HEIGHT / 4;
        }
    }
    public static void drawSquare(int x, int y, Graphics graphics) {
        graphics.setColor(Color.black);
        graphics.fillRect(x, y, WIDTH / 8, HEIGHT / 8 );
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