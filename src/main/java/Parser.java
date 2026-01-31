public class Parser {


    public static boolean isSwitchOffCommand(String input) {
        return input.trim().equalsIgnoreCase("bye");
    }

    public static String getCommandType(String input) {
        return input.split(" ")[0];
    }

    public static Task parseTask(String type, String input) throws KatappaException {
        try {
            if (type.equalsIgnoreCase("todo")) {
                return new Todo(input.substring(4).trim());
            }

            if (type.equalsIgnoreCase("deadline")) {
                int byIndex = input.indexOf("/by");
                String description = input.substring(8, byIndex).trim();
                String by = input.substring(byIndex + 3).trim();
                return new Deadline(description, by);
            }

            if (type.equalsIgnoreCase("event")) {
                int fromIndex = input.indexOf("/from");
                int toIndex = input.indexOf("/to");
                String description = input.substring(5, fromIndex).trim();
                String from = input.substring(fromIndex + 5, toIndex).trim();
                String to = input.substring(toIndex + 3).trim();
                return new Event(description, from, to);
            }


        } catch (Exception e) {
            throw new KatappaException("My Lord, your command for this " + type + " is incomplete!");
        }
        return new Task(input);
    }

    public static int parseIndex(String input) throws KatappaException {
        try {
            String[] parts = input.split(" ");
            return Integer.parseInt(parts[1]);
        } catch (Exception e) {
            throw new KatappaException("My Lord, please specify a valid task number (e.g mark 1)");
        }
    }
}



