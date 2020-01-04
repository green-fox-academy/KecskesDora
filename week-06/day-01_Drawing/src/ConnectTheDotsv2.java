import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ConnectTheDotsv2 {
    public static void mainDraw(Graphics graphics) {
        // Create a function that takes 2 parameters:
        // An array of {x, y} points and graphics
        // and connects them with green lines.
        // Connect these to get a box: {{10, 10}, {290,  10}, {290, 290}, {10, 290}}
        // Connect these: {{50, 100}, {70, 70}, {80, 90}, {90, 90}, {100, 70},
        // {120, 100}, {85, 130}, {50, 100}}

        graphics.setColor(Color.green);
        int[][] polygon1 = {
                {10, 10},
                {290, 10},
                {290, 290},
                {10, 290},
        };
        int[][] polygon2 = {{50, 100}, {70, 70},
                {80, 90}, {90, 90}, {100, 70},
                {120, 100}, {85, 130}, {50, 100}};

        int xPoints[] = {polygon1[0][0], polygon1[1][0], polygon1[2][0], polygon1[3][0]};
        int yPoints[] = {polygon1[0][1], polygon1[1][1], polygon1[2][1], polygon1[3][1]};
        graphics.drawPolygon(xPoints, yPoints, polygon1.length);

    //ez nem jó még:
        for (int i = 0; i < polygon2.length; i++) {
            List<Integer> x2Points = new ArrayList<>();
            x2Points.add(i, polygon2[i][0]);
            List<Integer> y2Points = new ArrayList<>();
            y2Points.add(i, polygon2[i][1]);
            System.out.println(y2Points);
            //graphics.drawPolygon(x2Points, y2Points, polygon2.length);

        }
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