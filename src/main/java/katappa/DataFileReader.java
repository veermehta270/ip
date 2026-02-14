package katappa;

import katappa.task.Deadline;
import katappa.task.Event;
import katappa.task.Task;
import katappa.task.Todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * Class responsible for reading the data file and creating the taskList with existing data
 */
public class DataFileReader {


    static Path filePath = Paths.get("data","tasks.txt");


    /**
     * @return ArrayList of all the existing tasks, if no tasks exist then gives empty arraylist.
     */
    public ArrayList<Task> readFileData() {
        File f = filePath.toFile();

        if (!f.exists()) {
            return new ArrayList<>();
        }
        ArrayList<Task> listOfTasks = new ArrayList<>();
        try (Scanner s = new Scanner(f)) {
            while (s.hasNextLine()) {
                String line = s.nextLine();
                Task task = processData(line);
                listOfTasks.add(task);
            }
        } catch (FileNotFoundException | KatappaException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return listOfTasks;
    }

    /**
     * @param line Each line in the data file as scanned by the scanner
     * @return Task object defined by the line
     * @throws KatappaException Checks weather the data file is corrupted
     */
    public Task processData(String line) throws KatappaException {
        Task task;
        String[] contents = line.split(";");
        task = switch (contents[0]) {
            case "T" -> new Todo(contents[2]);
            case "D" -> new Deadline(contents[2], contents[3]);
            case "E" -> new Event(contents[2], contents[3], contents[4]);
            default -> throw new KatappaException("Invalid line in data file");
        };
        if (contents[1].equals("[X]")) {
            task.markAsDone();
        }
        return task;
    }

}
