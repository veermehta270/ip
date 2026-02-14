package katappa.task;

/**
 * Abstract class, helps implement different types of classes
 */
public abstract class Task {
    /**
     * More detailed information about what the task actually it
     */
    public String description;
    /**
     * Status of the task, wether it is done or not done
     */
    public boolean isDone;

    /**
     * Constructor of the Task Class
     * @param description  description of the task
     */
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

    /**
     * Mark the status of class as Done
     */
    public void markAsDone() {
        isDone = true;
    }

    /**
     * Mark the status of class as Not Done
     */
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