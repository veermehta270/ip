public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public boolean isDone() {
        return this.isDone;
    }

    public String getDescription() {
        return description;
    }

    public void markAsDone() {
        this.isDone = true;
    }


    public void markAsNotDone() {
        this.isDone = false;
    }

    public String getStatusIcon() {
        if(this.isDone) {
            return "[X]";
        }
        else {
            return "[ ]";
        }
    }

    @Override
    public String toString() {
        return this.getStatusIcon() + " " + this.getDescription().trim();
    }


}