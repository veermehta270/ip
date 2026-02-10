package katappa;

import katappa.task.Task;
import java.util.ArrayList;

public class TaskManager {

    public static int MAX_NUMBER_OF_TASKS = 100;
    private ArrayList<Task> taskList = new ArrayList<>();


    public void addTask(Task task) {
        taskList.add(task);
    }

    public int getTotalTasks() {
        return taskList.size();
    }

    public void markTaskAsDone(int inputIndex) throws KatappaException {

        validateIndex(inputIndex);

        Task task = taskList.get(inputIndex - 1);
        if (task.isDone()) {
            throw new KatappaException("My Lord, this task is already marked as done!");
        }

        task.markAsDone();

    }

    public void markTaskAsNotDone(int inputIndex) throws KatappaException {

        validateIndex(inputIndex);

        Task task = taskList.get(inputIndex - 1);
        if (!task.isDone()) {
            throw new KatappaException("My Lord, this task is already marked as not done!");
        }

        task.markAsNotDone();

    }

    public Task deleteTask(int deleteIndex) throws KatappaException {

        validateIndex(deleteIndex);
        return taskList.remove(deleteIndex - 1);
    }

    /**
     * Checks if the given index falls in the range of number of current tasks
     * @param inputIndex Index given by user
     * @throws KatappaException Exception to handle invalid indexes
     */
    private void validateIndex(int inputIndex) throws KatappaException {
        if (taskList.isEmpty()) {
            throw new KatappaException("There are no tasks yet My Lord. Please add tasks.");
        }
        if (inputIndex <= 0 || inputIndex > taskList.size()) {
            throw new KatappaException(
                    "My Lord, task number " + inputIndex + " is out of range. You have " + taskList.size() + " tasks.");
        }
    }

    public ArrayList<Task> getTaskList() {

        return taskList;
    }

    public Task getTask(int index) {

        return taskList.get(index - 1);
    }
}
