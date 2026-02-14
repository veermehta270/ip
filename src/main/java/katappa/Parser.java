package katappa;

import katappa.task.Todo;
import katappa.task.Deadline;
import katappa.task.Event;
import katappa.task.Task;

public class Parser {

    /**
     * Checks if the user has given a command to close the program
     * @param input Input command of the user
     * @return boolean value indicating whether to switch off program
     */
    public static boolean isSwitchOffCommand(String input) {
        return input.trim().equalsIgnoreCase("bye");
    }

    /**
     * Strips the command type from the input message
     * @param input input message by the user
     * @return command
     */
    public static String getCommandType(String input) {
        return input.split(" ")[0];
    }

    /**
     * Parses the input data and give out the required Task
     * @param type Type of the command (eg. Todo, Deadline, Event)
     * @param input Input text from the user
     * @return Task based on the type of command and input data
     * @throws KatappaException Handles exceptions where either the user has typed a wrong command or not given a
     * proper description
     */
    public static Task parseTask(String type, String input) throws KatappaException {
        try {
            if (type.equalsIgnoreCase("todo")) {
                String description = input.substring(4).trim();
                if (description.isEmpty()) {
                    throw new KatappaException("My lord, please enter the description of the task you want me to add" +
                            " after \"todo\"");
                }
                return new Todo(input.substring(4).trim());
            }

            if (type.equalsIgnoreCase("deadline")) {
                int byIndex = input.indexOf("/by");
                String description = input.substring(8, byIndex).trim();
                if (description.isEmpty()) {
                    throw new KatappaException("My lord, please enter the description of the task you want me to add" +
                            " after \"deadline\"");
                }
                String by = input.substring(byIndex + 3).trim();
                return new Deadline(description, by);
            }

            if (type.equalsIgnoreCase("event")) {
                int fromIndex = input.indexOf("/from");
                int toIndex = input.indexOf("/to");
                String description = input.substring(5, fromIndex).trim();
                if (description.isEmpty()) {
                    throw new KatappaException("My lord, please enter the description of the task you want me to add" +
                            " after \"event\"");
                }
                String from = input.substring(fromIndex + 5, toIndex).trim();
                String to = input.substring(toIndex + 3).trim();
                return new Event(description, from, to);
            }
            throw new KatappaException("My Lord, I do no know what a ' " + type + "' is!");


        } catch (KatappaException e) {
            throw e;
        } catch (Exception e) {
            throw new KatappaException("My Lord, your command for this " + type + " is incomplete!");
        }
    }

    /**
     * If task number is valid, converts it to Integer
     * @param input Input text from the user
     * @return List number as an Integer datatype
     * @throws KatappaException Handles error if task number is out of bounds
     */
    public static int parseIndex(String input) throws KatappaException {
        try {
            String[] parts = input.split(" ");
            return Integer.parseInt(parts[1]);
        } catch (Exception e) {
            throw new KatappaException("My Lord, please specify a valid task number (e.g mark 1)");
        }
    }
}



