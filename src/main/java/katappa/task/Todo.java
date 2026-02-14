package katappa.task;

/**
 * Todo Class which is a child class of Task, helps store tasks of type Todo
 */
public class Todo extends Task {

    /**
     * @param description Description of the task
     */
    public Todo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }


}
