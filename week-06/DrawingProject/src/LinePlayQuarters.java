import javax.swing.*;
import javax.swing.text.Highlighter;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LinePlayQuarters {

    public static void mainDraw(Graphics graphics) {
        int numberOfLines = 15;
        int divider = 4;

        drawGreenLines(numberOfLines, divider, graphics);
        drawPurpleLines(numberOfLines, divider, graphics);

    }
        public static void drawGreenLines(int numberOfLines, int divider, Graphics graphics) {

            graphics.setColor(Color.green);
            int distance = HEIGHT / (numberOfLines + 1) / divider;
            int a = 0;
            int b = 0;
            for (int k = 1; k <= divider; k++) {
                for (int j = 1; j <= divider; j++) {
                    for (int i = 1; i < numberOfLines; i++) {
                        graphics.drawLine(a, distance + b, distance + a, HEIGHT / divider + b);
                        distance += HEIGHT / numberOfLines / divider;
                    }
                    a += WIDTH / divider;
                    distance = HEIGHT / (numberOfLines + 1) / divider;
                }
                b += HEIGHT / divider;
                a = 0;
            }
        }
        public static void drawPurpleLines ( int numberOfLines, int divider, Graphics graphics) {

            graphics.setColor(new Color(50, 0, 50));
            int distance = WIDTH / (numberOfLines + 1) / divider;
            int a = 0;
            int b = 0;
            for (int k = 1; k <= divider; k++) {
                for (int j = 1; j <= divider; j++) {
                    for (int i = 0; i < numberOfLines - 1; i++) {
                        graphics.drawLine(distance + a, 0 + b, WIDTH / divider + a, distance + b);
                        distance += WIDTH / numberOfLines / divider;
                    }
                    a += WIDTH / divider;
                    distance = WIDTH / (numberOfLines + 1) / divider;
                }
                b += HEIGHT / divider;
                a = 0;
            }
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

