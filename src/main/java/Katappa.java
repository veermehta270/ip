import java.util.Scanner;

public class Katappa {

    public static final String NAME = "Katappa";
    public static String LINE = "___________________________________________________________";
    private static Task[] tasksList = new Task[100];
    private static int totalTasks = 0;

    private static void markOrUnmark(int index, String command) {
        if(totalTasks == 0) {
            System.out.println("\t" + LINE);
            System.out.println("\t" + "There are no tasks yet My Lord . Please add tasks, I am at your service.");
            System.out.println("\t" + LINE);
        }

        else if((index > totalTasks) || (index < 1)) {
            System.out.println("\t" + LINE);
            System.out.println("\t" + "My Lord, there is no such task yet, please enter a valid task number. I am at your service.");
            System.out.println("\t" + LINE);
        }

        else if(command.equalsIgnoreCase("mark")) {
            Task task = tasksList[index - 1];
            if(task.isDone()) {
                System.out.println("\t" + LINE);
                System.out.println("\t" + "My Lord, the task already has the status of Done!");
                System.out.println("\t" + task);
                System.out.println("\t" + LINE);

            }
            else {
                task.markAsDone();
                System.out.println("\t" + LINE);
                System.out.println("\t" + "Nice! I've marked this task as done:");
                System.out.println("\t" + task);
                System.out.println("\t" + LINE);
            }

        }

        else if(command.equalsIgnoreCase("unmark")) {
            Task task = tasksList[index - 1];

            if(!task.isDone) {
                System.out.println("\t" + LINE);
                System.out.println("\t" + "My Lord, the task already has the status of Not Done!");
                System.out.println("\t" + task);
                System.out.println("\t" + LINE);

            }
            else {
                task.markAsNotDone();
                System.out.println("\t" + LINE);
                System.out.println("\t" + "OK, I've marked this task as not done yet:");
                System.out.println("\t" + " " + task);
                System.out.println("\t" + LINE);
            }

        }


    }

    private static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void printTaskList() {

        if(totalTasks == 0) {
            System.out.println("\t" + LINE);
            System.out.println("\t" + "No tasks yet my Lord. Please add tasks, I am at your service.");
            System.out.println("\t" + LINE);

        }
        else {
            System.out.println("\t" + LINE);
            for (int i = 0; i < totalTasks; i++) {

                System.out.println("\t" + (i + 1) + ". " + tasksList[i]);
            }
            System.out.println("\t" + LINE);
        }

    }

    private static Task classifyTask(String input) {
        String[] inputArray = input.split(" ");


        if(inputArray[0].equalsIgnoreCase("todo")) {
            Todo newTask = new Todo(input.substring(4));
            return newTask;
        }

        else if(inputArray[0].equalsIgnoreCase("deadline")) {
            int descriptionStartIndex = 8;
            int byIndex = input.indexOf("/by");
            Deadline newTask = new Deadline(input.substring(descriptionStartIndex,byIndex), input.substring(byIndex+3));
            return newTask;
        }

        else if(inputArray[0].equalsIgnoreCase("event")) {
            int descriptionStartIndex = 5;
            int fromIndex = input.indexOf("/from");
            int toIndex = input.indexOf("/to");
            Event newTask = new Event(input.substring(descriptionStartIndex,fromIndex), input.substring(fromIndex + 5, toIndex), input.substring(toIndex+3));
            return newTask;
        }

        else {
            return new Task(input);

        }



    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);


        System.out.println("\t" + LINE);
        System.out.println("\t" + "Namaste! My Lord, I'm " + NAME + " your loyal servant");
        System.out.println("\t" + "How can I serve you today?");
        System.out.println("\t" + LINE);

       String input = in.nextLine();


       while((!input.equalsIgnoreCase("bye"))) {

           if (input.isBlank()) {
               System.out.println("\t" + LINE);
               System.out.println("\t" + "My Lord, I do not understand this command, please enter a valid command.");
               System.out.println("\t" + LINE);
               input = in.nextLine();
               continue;

           }


           else if (input.equalsIgnoreCase("list")) {
               printTaskList();
               input = in.nextLine();
               continue;
           } else if (input.split(" ")[0].equalsIgnoreCase("mark")) {

               if (isInteger(input.split(" ")[1])) {
                   markOrUnmark(Integer.parseInt(input.split(" ")[1]), "mark");
                   input = in.nextLine();
                   continue;

               }

           } else if (input.split(" ")[0].equalsIgnoreCase("unmark")) {

               if (isInteger(input.split(" ")[1])) {
                   markOrUnmark(Integer.parseInt(input.split(" ")[1]), "unmark");
                   input = in.nextLine();
                   continue;

               }
           }

           Task newTask = classifyTask(input);

           System.out.println("\t" + LINE);
           System.out.println("\t" + "Got it. I've added this task:");
           System.out.println("\t" + "\t" + newTask);
           System.out.println("\t" + "My Lord, now you have " + (totalTasks + 1) + " tasks in the list.");
           System.out.println("\t" + LINE);
           tasksList[totalTasks] = newTask;
           totalTasks++;
           input = in.nextLine();

       }


        System.out.println("\t" + LINE);
        System.out.println("\t" + "Rest peacefully my Lord, Katappa's sword stays ready for your return.");
        System.out.println("\t" + LINE);

    }
}
