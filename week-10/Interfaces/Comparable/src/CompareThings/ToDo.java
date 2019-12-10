package CompareThings;

public class ToDo implements Comparable<ToDo>{
    private String description;
    private boolean completed;

    public ToDo(String text, boolean completed) {
        this.description = text;
        this.completed = completed;
    }

    public void complete() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return (completed ? "[x] " : "[ ] ") + this.description;
    }

    @Override
    public int compareTo(ToDo o) {
        int result = Boolean.compare(this.completed, o.completed);
        if (result == 0) {
            result = this.description.compareTo((o.description));
        }
        return result;
    }
}
