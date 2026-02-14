package katappa;
import java.io.File;
import java.io.IOException;

/**
 * Main class, runs the main chatbot program from here
 */
public class Katappa {

    private static TaskManager taskManager;
    private static Ui ui;

    public static void main(String[] args) {

        startUp();
        runLoopUntilExit();

    }

    /**
     * Initializes the data storage file and the Ui class. Gives the starting greeting message
     */
    private static void startUp() {
        File f = DataFileWriter.filePath.toFile();

        try {
            if(f.getParentFile() != null) {
                f.getParentFile().mkdirs();
            }

            if (f.exists()) {
                DataFileReader reader = new DataFileReader();
                taskManager = new TaskManager(reader.readFileData());
            } else {
                f.createNewFile();
                taskManager = new TaskManager();
            }
        } catch (IOException e) {
            System.out.println("Could not initialize save file");
        }

        ui = new Ui();
        ui.showWelcomeMessage();
    }

    /**
     * Runs the main loop, reads, runs, parses the user input and gives out the result.
     */
    private static void runLoopUntilExit() {
        boolean isExit = false;
        while (!isExit) {
            String input = ui.readCommand();

            String result = runCommand(input);

            ui.showResult(result);

            isExit = Parser.isSwitchOffCommand(input);

        }
    }

    /**
     * Runs the command given by the user and gives appropriate result
     * @param input Command given by the user
     * @return The output message given to the user as a result of their input command
     */
    private static String runCommand(String input) {
        try {
            String commandType = Parser.getCommandType(input);
            return CommandExecutor.execute(commandType, input, taskManager, ui);
        } catch (KatappaException e) {
            return e.getMessage();
        }
    }


}
