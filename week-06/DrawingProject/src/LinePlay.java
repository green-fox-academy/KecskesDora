import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LinePlay {
    public static void mainDraw(Graphics graphics) {

        int numberOfLines = 15;
        int distance = HEIGHT / (numberOfLines + 1);

        graphics.setColor(Color.green);
        for (int i = 1; i < numberOfLines; i++) {
            graphics.drawLine(0, distance, distance, HEIGHT);
            distance += HEIGHT / numberOfLines;
        }
        distance = WIDTH / (numberOfLines + 1);

        graphics.setColor(new Color(50,0,50));
        for (int i = 0; i < numberOfLines - 1; i++) {
            graphics.drawLine(distance, 0, WIDTH, distance);
            distance += WIDTH / numberOfLines;
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
