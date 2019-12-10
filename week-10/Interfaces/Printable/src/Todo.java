public class Todo implements Printable{
    private String task;
    private String priority;
    private boolean isDone;

    public Todo (String task, String priority) {
        this.task = task;
        this.priority = priority;
    }

    @Override
    public void printAllFields() {
        System.out.println(this.task + " | " + this.priority + " | " + this.isDone);
    }
}
