//Create a Sponsor class that has the same fields and methods as the Person class, and has the following additional
//
//fields:
//company: name of the company
//hiredStudents: number of students hired
//method:
//introduce(): "Hi, I'm name, a age year old gender who represents company and hired hiredStudents students so far."
//hire(): increase hiredStudents by 1
//getGoal(): prints out "Hire brilliant junior software developers."
//The Sponsor class has the following constructors:
//
//Sponsor(name, age, gender, company): beside the given parameters, it sets hiredStudents to 0
//Sponsor(): sets name to Jane Doe, age to 30, gender to female, company to Google and hiredStudents to 0

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

    public void hire() {
        this.hiredStudents++;
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
}
