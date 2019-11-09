import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class StarryNight {
    public static void mainDraw(Graphics graphics) {
        // Draw the night sky:
        //  - The background should be black
        //  - The stars can be small squares
        //  - The stars should have random positions on the canvas
        //  - The stars should have random color (some shade of grey)

        graphics.setColor(Color.black);
        graphics.fillRect(0,0, WIDTH, HEIGHT);

        for (int i = 0; i < 1000; i++) {
            drawStar(graphics);
        }
        }

    public static void drawStar(Graphics graphics){

        graphics.setColor(new Color(105 + (int)(Math.random() * 116),
                                    105 + (int)(Math.random() * 116),
                                    105 + (int)(Math.random() * 116)));
        graphics.fillRect((int)(Math.random() * WIDTH), (int)(Math.random() * HEIGHT), 1, 1);
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