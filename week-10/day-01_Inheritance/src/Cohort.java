import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Cohort {
    private String name;
    private ArrayList<Student> students;
    private ArrayList<Mentor> mentors;

    public Cohort(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.mentors = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addMentor(Mentor mentor) {
        mentors.add(mentor);
    }

    public void info() {
        System.out.printf("The %s cohort has %d students and %d mentors.", this.name, students.size(), mentors.size());
    }
}
