public class CommandExecutor {

    public static String execute(String commandType,
                                 String input,
                                 TaskManager taskManager,
                                 Ui ui) throws KatappaException {

        switch (commandType.toLowerCase()) {
        case "todo":
            //Fallthrough
        case "deadline":
            //Fallthrough
        case "event":
            Task newTask = Parser.parseTask(commandType, input);

            taskManager.addTask(newTask);

            return "As you command, My Lord. I have added:\n\t" + newTask + "\n\tNow you have " +
                    taskManager.getTotalTasks() + " tasks.";

        case "list":
            Task[] allTasks = taskManager.getTaskList();
            int count = taskManager.getTotalTasks();
            return ui.printTaskList(allTasks, count);

        case "mark":
            int markIndex = Parser.parseIndex(input);
            taskManager.markTaskAsDone(markIndex);
            Task markedTask = taskManager.getTask(markIndex);
            return "Nice! I've marked this task as done:\n\t" + markedTask;

        case "unmark":
            int unmarkIndex = Parser.parseIndex(input);
            taskManager.markTaskAsNotDone(unmarkIndex);
            Task unmarkedTask = taskManager.getTask(unmarkIndex);
            return "OK, I've marked this task as not done yet:\n\t" + unmarkedTask;

        case "bye":
            return "Rest peacefully my Lord, Katappa's sword stays ready\n" + "\tfor your return.";


        default:
            throw new KatappaException("I am confused, My Lord. What is '" + commandType + "'?");
        }
    }
}