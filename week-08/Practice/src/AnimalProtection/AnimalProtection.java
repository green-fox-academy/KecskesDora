package AnimalProtection;

public class AnimalProtection {
    public static void main(String[] args) {
        AnimalShelter animalShelter = new AnimalShelter();

        animalShelter.addAdopter("Jani");
        animalShelter.addAdopter("Joli");
        animalShelter.addAdopter("Mari");
        animalShelter.addAdopter("Kati");

        animalShelter.rescue(new Cat("Cica"));
        animalShelter.rescue(new Cat("Kormi"));
        animalShelter.rescue(new Dog("Lili"));
        animalShelter.rescue(new Dog("Picur"));
        animalShelter.rescue(new Parrot("Lóri"));
        animalShelter.rescue(new Parrot("Pityu"));

        System.out.println(animalShelter);

        animalShelter.heal();
        animalShelter.heal();
        animalShelter.heal();
        System.out.println(animalShelter);

        System.out.println(animalShelter.findNewOwner());
        System.out.println(animalShelter);
    }
}
