import java.util.Scanner;

public class Katappa {

    private static TaskManager taskManager;
    private static Ui ui;


    private static Task classifyTask(String input) {
        String[] inputArray = input.split(" ");


        if (inputArray[0].equalsIgnoreCase("todo")) {
            String description = input.substring(4);
            return new Todo(description);
        } else if (inputArray[0].equalsIgnoreCase("deadline")) {
            int descriptionStartIndex = 8;
            int byIndex = input.indexOf("/by");
            String description = input.substring(descriptionStartIndex, byIndex);
            String by = input.substring(byIndex + 3);
            return new Deadline(description, by);
        } else if (inputArray[0].equalsIgnoreCase("event")) {
            int descriptionStartIndex = 5;
            int fromIndex = input.indexOf("/from");
            int toIndex = input.indexOf("/to");
            String description = input.substring(descriptionStartIndex, fromIndex);
            String from = input.substring(fromIndex + 5, toIndex);
            String to = input.substring(toIndex + 3);
            return new Event(description, from, to);
        } else {
            return new Task(input);
        }
    }

    public static void main(String[] args) {

        startUp();
        runLoopUntilExit();

    }


    private static void startUp() {
        taskManager = new TaskManager();
        ui = new Ui();
        ui.showWelcomeMessage();
    }

    private static void runLoopUntilExit() {
        boolean isExit = false;
        while (!isExit) {
            String input = ui.readCommand();

            String result = runCommand(input);

            ui.showResult(result);

            isExit = Parser.isSwitchOffCommand(input);

        }
    }

    private static String runCommand(String input) {
        try {
            String commandType = Parser.getCommandType(input);
            return CommandExecutor.execute(commandType, input, taskManager, ui);
        } catch (KatappaException e) {
            return e.getMessage();
        }
    }


}
