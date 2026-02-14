package katappa.task;
import katappa.KatappaException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

/**
 * Deadline Class which is a child class of Task, helps store tasks of type deadline with time indicator to complete
 * task
 */
public class Deadline extends Task {

    protected String by;
    protected LocalDateTime deadlineDateTime;

    /**
     * Constructs the instance of deadline class
     * @param description task description
     * @param by Indicator of time by which we should complete the task
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
            this.deadlineDateTime = LocalDateTime.parse(by, formatter);
        } catch (DateTimeParseException e) {
            this.deadlineDateTime = null;
        }
    }

    public String getBy() {
        if (deadlineDateTime == null) {
            return by;
        }
        else {
            DateTimeFormatter storeFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
            return deadlineDateTime.format(storeFmt);
        }
    }

    /**
     * Indicator weather task is due today or not
     * @param today Due date for deadline task
     * @return True if the task is due today
     */
    public boolean isDueToday(LocalDate today ) {
        if (deadlineDateTime == null) {
            return false;
        } else {
            return deadlineDateTime.toLocalDate().equals(today);
        }
    }

    @Override
    public String toString() {
        if (deadlineDateTime == null) {
            return "[D]" + super.toString() + " (by: " + by.trim() + ")";
        }
        else {
            return "[D]" + super.toString() + " (by: " + deadlineDateTime.format(DateTimeFormatter.ofPattern("dd MMM " +
                    "yyyy HH:mm")) +")";
        }
    }


}
