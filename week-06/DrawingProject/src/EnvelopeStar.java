import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class EnvelopeStar {

    public static void mainDraw(Graphics graphics) {

        graphics.setColor(Color.green);
        int numberOflLines = 10;
        int a = WIDTH / 2 / numberOflLines;
        int b = 0;

        int npoints = 4;
        for (int i = 0; i < 10; i++) {
            int xpoints[] = {WIDTH / 2, WIDTH / 2 + a, WIDTH / 2, WIDTH / 2 -a};
            int ypoints[] = {b, HEIGHT / 2, HEIGHT - b, HEIGHT / 2};
            graphics.drawPolygon(xpoints, ypoints, npoints);
            a += WIDTH / 2 / numberOflLines;
            b += WIDTH / 2 / numberOflLines;
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
