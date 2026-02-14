package katappa.task;

/**
 * Deadline Class which is a child class of Task, helps store tasks of type deadline with time indicator to complete
 * task
 */
public class Deadline extends Task {

    protected String by;

    /**
     * Constructs the instance of deadline class
     * @param description task description
     * @param by Indicator of time by which we should complete the task
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    public String getBy() {
        return by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.trim() + ")";
    }


}
