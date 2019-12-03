import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Hexagon {
    public static void mainDraw(Graphics graphics) {

        drawHexagonFractal(0, 40, WIDTH / 2, 5, graphics);
    }

    public static void drawHexagonFractal(int x, int y, int size, int level, Graphics graphics) {
        if (level == 0) return;

        drawHexagon(x, y, size, graphics);

        drawHexagonFractal(x + size / 3 , y , size / 3, level - 1, graphics);
        drawHexagonFractal(x + size, y , size / 3,level - 1, graphics);
        drawHexagonFractal(x , y + 2 * (int) (Math.sqrt(3) / 2 * size / 3), size / 3,level - 1, graphics);
        drawHexagonFractal(x + size / 3 * 4, y + 2 * (int) (Math.sqrt(3) / 2 * size / 3), size / 3,level - 1, graphics);
        drawHexagonFractal(x + size / 3 , y + 4 * (int) (Math.sqrt(3) / 2 * size / 3) , size / 3, level - 1, graphics);
        drawHexagonFractal(x + size, y + 4 * (int) (Math.sqrt(3) / 2 * size / 3) , size / 3,level - 1, graphics);
    }

    public static void drawHexagon(int x, int y, int size, Graphics graphics) {

        Color color = new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
        graphics.setColor(color);

        int xPoints[] = {x + size / 2, x + size / 2 * 3, x + size * 2, x + size / 2 * 3, x + size / 2, x};
        int yPoints[] = {y, y, y + (int)(Math.sqrt(3) / 2 * size), y + (int)(Math.sqrt(3) / 2 * size) * 2,
                                y + (int)(Math.sqrt(3) / 2 * size) * 2, y + (int)(Math.sqrt(3) / 2 * size)};

        graphics.drawPolygon(xPoints, yPoints, 6);
    }

    static int WIDTH = 600;
    static int HEIGHT = 600;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Drawing");
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Hexagon.ImagePanel panel = new Hexagon.ImagePanel();
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
