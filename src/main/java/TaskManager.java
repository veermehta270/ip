public class TaskManager {

    public static int MAX_NUMBER_OF_TASKS = 100;
    private Task[] taskList = new Task[MAX_NUMBER_OF_TASKS];
    private int totalTasks = 0;


    public void addTask(Task task) {
        taskList[totalTasks] = task;
        totalTasks++;
    }

    public int getTotalTasks() {
        return totalTasks;
    }

    public void markTaskAsDone(int inputIndex) throws KatappaException {

        validateIndex(inputIndex);

        Task task = taskList[inputIndex - 1];
        if (task.isDone()) {
            throw new KatappaException("My Lord, this task is already marked as done!");
        }

        task.markAsDone();

    }

    public void markTaskAsNotDone(int inputIndex) throws KatappaException {

        validateIndex(inputIndex);

        Task task = taskList[inputIndex - 1];
        if (!task.isDone()) {
            throw new KatappaException("My Lord, this task is already marked as not done!");
        }

        task.markAsNotDone();

    }

    private void validateIndex(int inputIndex) throws KatappaException {
        if (totalTasks == 0) {
            throw new KatappaException("There are no tasks yet My Lord. Please add tasks.");
        }
        if (inputIndex <= 0 || inputIndex > totalTasks) {
            throw new KatappaException(
                    "My Lord, task number " + inputIndex + " is out of range. You have " + totalTasks + " tasks.");
        }
    }

    public Task[] getTaskList() {
        return taskList;
    }

    public Task getTask(int index) {
        return taskList[index - 1];
    }
}
