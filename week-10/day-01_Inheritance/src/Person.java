public class Person {
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
}
