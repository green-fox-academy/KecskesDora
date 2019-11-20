package PostIt;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        PostIt PostIt1 = new PostIt(Color.orange, "Idea 1", Color.blue);
        System.out.println(PostIt1.backGroundColor + PostIt1.text + PostIt1.textColor);

        PostIt PostIt2 = new PostIt(Color.pink, "Awesome", Color.black);
        System.out.println(PostIt2.backGroundColor + PostIt2.text+ PostIt2.textColor);

        PostIt PostIt3 = new PostIt(Color.yellow, "Superb", Color.green);
        System.out.println(PostIt3.backGroundColor + PostIt3.text + PostIt3.textColor);
    }
}
