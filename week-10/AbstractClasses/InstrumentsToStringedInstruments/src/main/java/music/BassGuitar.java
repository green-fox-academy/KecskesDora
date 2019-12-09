package main.java.music;

public class BassGuitar extends StringedInstrument {

    private static String name = "Bass Guitar";
    private static int numberOfStrings = 4;

    public BassGuitar() {
        super(name, numberOfStrings);
    }

    public BassGuitar(int numberOfStrings) {
        super(name, numberOfStrings);
    }

    @Override
    public void sound() {
        System.out.print("Duum-duum-duum\n");
    }
}

