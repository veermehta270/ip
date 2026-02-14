package katappa;

import katappa.task.Task;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Responsible for reading the input commands and printing all the outputs in the terminal in a specific formatted way
 */
public class Ui {


    public static final String NAME = "katappa.Katappa";
    public static final String LINE = "    =====================================";
    public static final String SPECIAL_LINE = "+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+";

    private final Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * @return Command inputted by the user
     */
    public String readCommand() {
        return scanner.nextLine().trim();
    }

    /**
     * @param message Print output in specific formatted way
     */
    public void printInBox(String message) {
        System.out.println(LINE);
        System.out.println("    " + message);
        System.out.println(LINE);
    }

    /**
     * Display the form welcome message at start of the chatbot
     */
    public void showWelcomeMessage() {
        String welcome = "Namaste! My Lord, I'm " + NAME + ", your loyal servant.\n" + "    " +
                "My sword and my service are yours. How shall I assist you today?";
        printInBox(welcome);
    }

    /**
     * @param result This is useful for katappa.CommandExecutor to call
     */
    public void showResult(String result) {
        printInBox(result);
    }


    /**
     * Prints the list of all tasks with numbers and proper format
     * @param allTasks ArrayList of all the tasks in the data
     * @param count Total number of tasks
     * @return Formatted string
     */
    public String printTaskList(ArrayList<Task> allTasks, int count) {
        if (count == 0) {
            return "The scroll is empty, My Lord. No tasks found.";
        }

        String listMessage = "Here are the tasks in your scroll, My Lord:\n";

        for (int i = 0; i < count; i++) {
            // Add the task line: e.g., "1. [T][ ] read book"
            listMessage += "    " + (i + 1) + ". " + allTasks.get(i);

            // Only add a newline if it's NOT the last task
            if (i < count - 1) {
                listMessage += "\n";
            }
        }

        return listMessage;
    }


}