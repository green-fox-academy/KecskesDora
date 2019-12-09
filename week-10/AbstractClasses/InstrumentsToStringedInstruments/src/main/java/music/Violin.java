package main.java.music;

public class Violin extends StringedInstrument {

    private static String name = "Violin";
    private static int numberOfStrings = 4;

    public Violin() {
        super(name, numberOfStrings);
    }

    public Violin(int numberOfStrings) {
        super(name, numberOfStrings);
    }

    @Override
    public void sound() {
        System.out.print("Screech\n");
    }
}
