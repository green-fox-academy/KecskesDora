public class GardenApp {
    public static void main(String[] args) {
        Garden cityPark = new Garden();

        Flower yellow = new Flower("yellow");
        cityPark.addPlant(yellow);
        Flower blue = new Flower("blue");
        cityPark.addPlant(blue);
        Tree purple = new Tree("purple");
        cityPark.addPlant(purple);
        Tree orange = new Tree("orange");
        cityPark.addPlant(orange);

        cityPark.state();
        cityPark.water(40);
        cityPark.water(70);
    }
}
