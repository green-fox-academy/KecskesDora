public class Sponsor extends Person {
    private String company;
    private int hiredStudents;

    public Sponsor(String name, int age, String gender, String company) {
        super(name, age, gender);
        this.company = company;
        this.hiredStudents = 0;
    }

    public Sponsor() {
        super();
        this.company = "Google";
        this.hiredStudents = 0;
    }

    @Override
    public void introduce() {
        super.introduce();
        System.out.printf(", who represents %s and hired %d students so far.", this.company, this.hiredStudents);
    }

    @Override
    public void getGoal() {
        System.out.println("\nMy goal is: Hire brilliant junior software developers.");
    }

    public void hire() {
        this.hiredStudents++;
    }
}
