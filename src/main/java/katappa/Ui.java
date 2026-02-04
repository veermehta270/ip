package katappa;

import katappa.task.Task;

import java.util.Scanner;

public class Ui {

    // These are constants, so we use 'static final' and Uppercase
    public static final String NAME = "katappa.Katappa";
    public static final String LINE = "    =====================================";
    public static final String SPECIAL_LINE = "+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+";

    private final Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    public String readCommand() {
        return scanner.nextLine().trim();
    }

    public void printInBox(String message) {
        System.out.println(LINE);
        System.out.println("    " + message);
        System.out.println(LINE);
    }

    public void showWelcomeMessage() {
        String welcome = "Namaste! My Lord, I'm " + NAME + ", your loyal servant.\n" + "    " +
                "My sword and my service are yours. How shall I assist you today?";
        printInBox(welcome);
    }

    // This is useful for your katappa.CommandExecutor to call!
    public void showResult(String result) {
        printInBox(result);
    }


    public String printTaskList(Task[] allTasks, int count) {
        if (count == 0) {
            return "The scroll is empty, My Lord. No tasks found.";
        }

        String listMessage = "Here are the tasks in your scroll, My Lord:\n";

        for (int i = 0; i < count; i++) {
            // Add the task line: e.g., "1. [T][ ] read book"
            listMessage += "    " + (i + 1) + ". " + allTasks[i];

            // Only add a newline if it's NOT the last task
            if (i < count - 1) {
                listMessage += "\n";
            }
        }

        return listMessage;
    }


}