package main.java.music;

public abstract class StringedInstrument extends Instrument {
    private int numberOfStrings;

    public StringedInstrument(String name, int numberOfStrings){
        super(name);
        this.numberOfStrings = numberOfStrings;
    }

    protected abstract void sound();

    @Override
    public void play() {
        System.out.print(this.name + ", a " + this.numberOfStrings + "-stringed instrument that goes ");
        this.sound();
    }
}

