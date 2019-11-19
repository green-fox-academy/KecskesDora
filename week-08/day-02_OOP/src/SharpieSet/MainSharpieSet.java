package SharpieSet;

public class MainSharpieSet {
    public static void main(String[] args) {
        //Reuse your Sharpie class
        //Create SharpieSet class
        //it contains a list of Sharpie
        //  countUsable() -> sharpie is usable if it has ink in it
        //  removeTrash() -> removes all unusable sharpies
        SharpieSet sharpieSet = new SharpieSet();

        Sharpie redSharpie = new Sharpie ("red");
        Sharpie greenSharpie = new Sharpie ("green");
        Sharpie yellowSharpie = new Sharpie ("yellow");
        Sharpie blueSharpie = new Sharpie ("blue");

        sharpieSet.add(redSharpie);
        sharpieSet.add(greenSharpie);
        sharpieSet.add(yellowSharpie);
        sharpieSet.add(blueSharpie);

        System.out.println(sharpieSet.countUsable());

        for (int i = 0; i < 100; i++) {
            redSharpie.use();
            blueSharpie.use();
        }
        System.out.println(sharpieSet.countUsable());
        System.out.println(sharpieSet);
        sharpieSet.removeTrash();
        System.out.println(sharpieSet);
    }
}
