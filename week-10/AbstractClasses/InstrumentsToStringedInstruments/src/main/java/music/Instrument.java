package main.java.music;

public abstract class Instrument {
    protected String name;

    public Instrument(String name) {
        this.name = name;
    }

    protected abstract void play();
}

