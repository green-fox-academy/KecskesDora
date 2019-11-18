package Sharpie;

public class Main {
    public static void main(String[] args) {
        Sharpie sharpie1 = new Sharpie("red", 2.5f);
        Sharpie sharpie2 = new Sharpie("blue", 3.4f);

        sharpie1.use();
        System.out.println(sharpie1.inkAmount);
        for (int i = 0; i < 10; i++) {
            sharpie2.use();
        }
        System.out.println(sharpie2.inkAmount);
    }
}
