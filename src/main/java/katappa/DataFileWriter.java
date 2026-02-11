package katappa;

import katappa.task.Deadline;
import katappa.task.Task;
import katappa.task.Todo;
import katappa.task.Event;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataFileWriter {

    static Path filePath = Paths.get("data","tasks.txt");


    private static void writeToFile(String textToAdd)  {

        try (FileWriter fw = new FileWriter(filePath.toFile())){

            fw.write(textToAdd);
        }
        catch (IOException e) {
            System.out.println("There was an error writing data to the file :" + e.getMessage());
        }
    }

    private String formatTaskString(Task task) {


        String formattedData = "";
        if (task instanceof Todo) {
            formattedData += "T;" + task.getStatusIcon() + ";" + task.getDescription();
        }
        else if (task instanceof Deadline) {
            Deadline deadline = (Deadline) task;
            formattedData += "D;" + deadline.getStatusIcon() + ";" + deadline.getDescription() + ";" + deadline.getBy();
        }

        else {
            Event event = (Event) task;
            formattedData += "E;" + event.getStatusIcon() + ";" + event.getDescription() + ";" + event.getFrom() + ";" +
                    event.getTo();

        }
        return formattedData;



    }

    public void updateTaskData(ArrayList<Task> listOfTasks) {
        StringBuilder sb = new StringBuilder();
        for (Task task : listOfTasks) {
            sb.append(formatTaskString(task)).append(System.lineSeparator());
        }

        writeToFile(sb.toString());
    }
}
