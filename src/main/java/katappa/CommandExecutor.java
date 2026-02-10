package katappa;

import katappa.task.Task;

import java.util.ArrayList;

public class CommandExecutor {
    /**
     * Analyzes and executes the command and calls other respective classes as required.
     * @param commandType Type of the command (eg. Todo, Deadline, Event).
     * @param input Complete text input of the user.
     * @param taskManager TaskManager object for execution of commands
     * @param ui User interface object for execution of commands
     * @return Text output to be printed
     * @throws KatappaException Handles exceptions
     */
    public static String execute(String commandType, String input, TaskManager taskManager, Ui ui) throws KatappaException {

        switch (commandType.toLowerCase()) {
        case "todo":
            //Fallthrough
        case "deadline":
            //Fallthrough
        case "event":
            Task newTask = Parser.parseTask(commandType, input);

            taskManager.addTask(newTask);

            return "As you command, My Lord. I have added:\n" + "    " + newTask + "\n" + "    " + "Now you have " +
                    taskManager.getTotalTasks() + " tasks.";

        case "list":
            ArrayList<Task> allTasks = taskManager.getTaskList();
            int count = taskManager.getTotalTasks();
            return ui.printTaskList(allTasks, count);

        case "mark":
            int markIndex = Parser.parseIndex(input);
            taskManager.markTaskAsDone(markIndex);
            Task markedTask = taskManager.getTask(markIndex);
            return "Nice! I've marked this task as done:\n" +"    "+  markedTask;

        case "unmark":
            int unmarkIndex = Parser.parseIndex(input);
            taskManager.markTaskAsNotDone(unmarkIndex);
            Task unmarkedTask = taskManager.getTask(unmarkIndex);
            return "OK, I've marked this task as not done yet:\n" + "    " + unmarkedTask;

        case "delete":
            int deleteIndex = Parser.parseIndex(input);
            Task deletedTask = taskManager.deleteTask(deleteIndex);
            return "OK, I have deleted the task : \n" +"    " + deletedTask + "\nNow you have " +
                    taskManager.getTotalTasks() + " tasks.";

        case "bye":
            return "Rest peacefully my Lord, katappa.Katappa's sword stays ready\n" + "    " +"for your return.";


        default:
            throw new KatappaException("I am confused, My Lord. What is '" + commandType + "'?");
        }
    }
}