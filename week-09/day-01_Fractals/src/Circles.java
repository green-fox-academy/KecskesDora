import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Circles {

    public static void mainDraw(Graphics graphics) {

        drawCircleFractal(0, 0, 600, 4, graphics);

    }

    public static void drawCircleFractal(int x, int y, int size, int level, Graphics graphics) {
        if (level == 0) return;

        drawCirclePattern(x, y, size, graphics);
        drawCircleFractal(x + size / 4, y,size / 2, level - 1, graphics);
        drawCircleFractal(x + size / 32, y + size / 8 * 3, size / 2, level - 1, graphics);
        drawCircleFractal(x + size / 2 - size / 32, y + size / 8 * 3, size / 2, level -1, graphics);
    }
     // ez nem is kell:
    /*public static void drawBiggerPattern(int x, int y, int size, Graphics graphics) {
        drawCirclePattern(x + size / 4, y, size / 2, graphics);
        drawCirclePattern(x + size / 32, y + size / 8 * 3, size / 2, graphics);
        drawCirclePattern(x + size / 2 - size / 32,y + size / 8 * 3, size / 2, graphics );
    }*/

    public static void drawCirclePattern(int x, int y, int size, Graphics graphics) {
        //draw big circle
        graphics.drawOval(x, y, size, size);
        //draw little circles, ez sem kell:
        //graphics.drawOval(x + size / 4, y, size / 2, size / 2);
        //graphics.drawOval(x + size / 32, y + size / 8 * 3,size / 2, size / 2);
        //graphics.drawOval(x + size / 2 - size / 32, y + size / 8 * 3, size / 2, size / 2);
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
