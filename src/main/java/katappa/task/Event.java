package katappa.task;

/**
 * Event Class which is a child class of Task, helps store tasks of type events with duration data
 */
public class Event extends Task {

    protected String from;
    protected String to;

    /**
     * Constructs the instance of Event class
     * @param description Description of the event
     * @param from Indicator of starting time of the event
     * @param to Indicator of ending time of the event
     */
    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from.trim() + " to: " + to.trim() + ")";
    }
}
