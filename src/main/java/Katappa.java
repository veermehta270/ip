import java.util.Scanner;

public class Katappa {

    private static TaskManager taskManager;
    private static Ui ui;

    public static void main(String[] args) {

        startUp();
        runLoopUntilExit(

        );

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
