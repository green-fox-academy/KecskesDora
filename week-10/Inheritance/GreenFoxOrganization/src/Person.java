//Create a Person class with the following fields:
//
//name: the name of the person
//age: the age of the person (whole number)
//gender: the gender of the person (male / female)
//And the following methods:
//
//introduce(): prints out "Hi, I'm name, a age year old gender."
//getGoal(): prints out "My goal is: Live for the moment!"
//And the following constructors:
//
//Person(name, age, gender)
//Person(): sets name to Jane Doe, age to 30, gender to female

public class Person implements Cloneable{
    private String name;
    private int age;
    private String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Person() {
        this.name = "Jane Doe";
        this.age = 30;
        this.gender = "female";
    }

    public void introduce() {
        System.out.printf("Hi, I'm %s, a %d year old %s", this.name, this.age, this.gender);
    }

    public void getGoal() {
        System.out.println("\nMy goal is: Live for the moment!");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        String name = this.name;
        return name;
    }
}
