package katappa;

import katappa.task.Deadline;
import katappa.task.Event;
import katappa.task.Task;
import katappa.task.Todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class DataFileReader {

    public static String DATA_FILE_PATH = "data/katappa.txt";


    public ArrayList<Task> readFileData() {
        File f = new File(DATA_FILE_PATH);

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
