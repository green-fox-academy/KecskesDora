public class Mentor extends Person{
    public String level;

    public Mentor(String name, int age, String gender, String level) {
        super(name, age, gender);
        this.level = level;
    }

    public Mentor() {
        super();
        this.level = "intermediate";
    }

    @Override
    public void getGoal() {
        System.out.println("\nMy goal is: Educate brilliant junior software developers.");
    }

    @Override
    public void introduce() {
        super.introduce();
        System.out.printf(", %s mentor.", this.level);
    }
}

