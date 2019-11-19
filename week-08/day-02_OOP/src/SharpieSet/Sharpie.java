package SharpieSet;

public class Sharpie {
    String color;
    float width;
    float inkAmount;

    public Sharpie () {
        this.inkAmount = 100;
    }

    public Sharpie (String color) {
        this.color = color;
        this.width = 2.5f;
        this.inkAmount = 100;
    }

    public void use() {
        inkAmount--;
    }
    @Override
    public String toString() {
        return color;
    }
}

