package main.java.music;

public class ElectricGuitar extends StringedInstrument{

    private static String name = "Electric Guitar";
    private static int numberOfStrings = 6;

    public ElectricGuitar() {
        super(name, numberOfStrings);
    }

    public ElectricGuitar(int numberOfStrings) {
        super(name, numberOfStrings);
    }

    @Override
    public void sound() {
        System.out.print("Twang\n");
    }
}
