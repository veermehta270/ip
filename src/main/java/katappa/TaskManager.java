package katappa;

import katappa.task.Task;
import java.util.ArrayList;


/**
 * Manages all the tasks, helps add, update, list and delete the tasks, uses ArrayList<Task> to store all the tasks
 */
public class TaskManager {

    private ArrayList<Task> taskList;
    private DataFileWriter fileWriter;


    protected TaskManager(ArrayList<Task> listOfTasks) {
        taskList = listOfTasks;
        fileWriter = new DataFileWriter();
    }

    protected TaskManager() {
        taskList = new ArrayList<>();
        fileWriter = new DataFileWriter();

    }

    /**
     * @param task Add task to the taskList and updates the data storage
     */
    public void addTask(Task task) {
        taskList.add(task);

        fileWriter.updateTaskData(taskList);
    }

    /**
     * @return Total number of tasks in the list
     */
    public int getTotalTasks() {

        return taskList.size();
    }

    /**
     * Helps mark the task as Done
     * @param inputIndex Index of the task that is to be marked
     * @throws KatappaException Handles invalid index numbers
     */
    public void markTaskAsDone(int inputIndex) throws KatappaException {

        validateIndex(inputIndex);

        Task task = taskList.get(inputIndex - 1);
        if (task.isDone()) {
            throw new KatappaException("My Lord, this task is already marked as done!");
        }

        task.markAsDone();
        fileWriter.updateTaskData(taskList);


    }

    /**
     * Helps mark the task as Done
     * @param inputIndex Index of the task that is to be marked
     * @throws KatappaException Handles invalid index numbers
     */
    public void markTaskAsNotDone(int inputIndex) throws KatappaException {

        validateIndex(inputIndex);

        Task task = taskList.get(inputIndex - 1);
        if (!task.isDone()) {
            throw new KatappaException("My Lord, this task is already marked as not done!");
        }

        task.markAsNotDone();
        fileWriter.updateTaskData(taskList);


    }

    /**
     * Deletes the task from the list
     * @param deleteIndex index of the task to be deleted
     * @return deleted Task
     * @throws KatappaException Handles invalid indexes
     */
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

    /**
     * @return List of all the tasks
     */
    public ArrayList<Task> getTaskList() {

        return taskList;
    }

    public Task getTask(int index) {

        return taskList.get(index - 1);
    }

    /**
     * @param textToFind The text which should be in the description of the task
     * @return Array list of tasks with textToFind in the description
     */
    public ArrayList<Task> tasksWithText(String textToFind) {
        ArrayList<Task> tasksWithTextToFind = new ArrayList<>();
        for(Task task : taskList) {
            if (task.description.contains(textToFind)) {
                tasksWithTextToFind.add(task);
            }
        }
        return tasksWithTextToFind;
    }
}
