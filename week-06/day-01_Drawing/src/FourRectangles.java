import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FourRectangles {

    public static void mainDraw(Graphics graphics){
        // draw four different size and color rectangles.
        // avoid code duplication.
        int a = 45;
        int b = 10;
        int c = 70;
        int d = 20;

        for (int i = 1; i <= 4; i++) {
            drawRectangles(i * a, i * b, i * c, i * d, graphics);
        }
        //with random numbers:
        for (int i = 0; i < 4; i++) {
            drawRectangles(((int) (Math.random() * WIDTH/2)),
                    ((int) (Math.random() * HEIGHT/2)),
                    ((int) (Math.random() * WIDTH/2)),
                    ((int) (Math.random() * HEIGHT/2)),
                    graphics);
        }
    }
    public static void drawRectangles(int x, int y, int w, int h, Graphics graphics) {
        graphics.setColor(new Color((int) (Math.random() * 256),
                                    (int) (Math.random() * 256),
                                    (int) (Math.random() * 256)));
        graphics.fillRect(x, y, w, h);
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