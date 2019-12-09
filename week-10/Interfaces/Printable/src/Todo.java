public class Todo implements Printable{
    private String task;
    private String priority;
    private boolean isDone;

    public Todo (String task, String priority) {
        this.task = task;
        this.priority = priority;
    }

    public String getTask() {
        return task;
    }

    public String getPriority() {
        return priority;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public void printAllFields() {
        System.out.println(getTask() + " | " + getPriority() + " | " + isDone());
    }
}
