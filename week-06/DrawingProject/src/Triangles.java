import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Triangles {
    public static void mainDraw(Graphics graphics) {
        int a = 50;
        drawTriangle(a, graphics);

    }
    public static void drawTriangle(int a, Graphics graphics) {
        int x = WIDTH / 2;
        int y = HEIGHT / 2;
        //graphics.drawPolygon(200, 200, 3);

        graphics.drawLine(x, y, x + a, y);
        //graphics.drawLine((x + a), y, x + a / 2, y - (double)(Math.sqrt(3));
        //graphics.drawLine(x + a / 2, y - (double)(Math.sqrt(3), x, y));
    }

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
