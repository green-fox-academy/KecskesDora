package Farm;

public class FarmMain {
    public static void main(String[] args) {
        Farm farm = new Farm();

        /*Animal pig = new Animal("pig");
        Animal horse = new Animal("horse");
        Animal duck = new Animal("duck");
        Animal sheep = new Animal("sheep");*/

        farm.breed("pig");
        farm.breed("horse");
        farm.breed("duck");
        farm.breed("sheep");

        farm.breed("sheep");
        System.out.println(farm);
        farm.breed("sheep");

        farm.listOfAnimals.get(2).eat();
        farm.listOfAnimals.get(2).eat();
        farm.listOfAnimals.get(2).eat();
        farm.listOfAnimals.get(1).play();
        System.out.println(farm.listOfAnimals.get(2).hungerValue);
        System.out.println(farm.listOfAnimals.get(1).hungerValue);

        farm.slaughter2();
        System.out.println(farm);
        farm.slaughter();
        System.out.println(farm);
        System.out.println(farm.slot);
    }
}

//Reuse your Animal class
//Create a Farm class
//      it has list of Animals
//      it has slots which defines the number of free places for animals
//      breed() -> creates a new animal if there's place for it
//      slaughter() -> removes the least hungry animal