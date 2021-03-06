import com.sun.corba.se.impl.orbutil.graph.Graph;
import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class SquareGrid {
    public static void mainDraw(Graphics graphics) {

        Graphics2D g2= (Graphics2D) graphics;
        drawSquareFractal(0, 0, WIDTH, 4, g2);
    }

    public static void drawSquareFractal(int x, int y, int size, int level, Graphics2D graphics) {
        if (level == 0) return;

        graphics.setStroke(new BasicStroke((float) Math.pow(level, 2)));

        drawSquare(x, y, size, graphics);

        drawSquareFractal(x , y, size / 2, level - 1, graphics);
        drawSquareFractal(x + size / 2, y, size / 2, level - 1, graphics);
        drawSquareFractal(x, y + size / 2, size / 2, level - 1, graphics);
        drawSquareFractal(x + size / 2, y + size / 2, size / 2, level - 1, graphics);
    }

        public static void drawBiggerPattern(int x, int y, int size, Graphics graphics) {

        drawSquare(x, y, size, graphics);

        drawSquare(x , y, size / 2, graphics);
        drawSquare(x + size / 2, y, size / 2, graphics);
        drawSquare(x, y + size / 2, size / 2, graphics);
        drawSquare(x + size / 2, y + size / 2, size / 2, graphics);
    }

    public static void drawSquare(int x, int y, int size, Graphics graphics) {

        //Color color = new Color((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256));
        //graphics.setColor(color);
        graphics.drawRect(0 + size / 4, 0 + size / 4, size / 2, size / 2);
    }

    static int WIDTH = 600;
    static int HEIGHT = 600;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Drawing");
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        SquareGrid.ImagePanel panel = new SquareGrid.ImagePanel();
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


