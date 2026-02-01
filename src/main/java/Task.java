public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        isDone = false;
    }

    public boolean isDone() {
        return isDone;
    }

    public String getDescription() {
        return description;
    }

    public void markAsDone() {
        isDone = true;
    }


    public void markAsNotDone() {
        isDone = false;
    }

    public String getStatusIcon() {
        if (isDone) {
            return "[X]";
        } else {
            return "[ ]";
        }
    }

    @Override
    public String toString() {
        return getStatusIcon() + " " + getDescription().trim();
    }

}