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
                System.out.println("\t" + " " + task.getStatusIcon() + " " + task.getDescription());
                System.out.println("\t" + LINE);

            }
            else {
                task.markAsDone();
                System.out.println("\t" + LINE);
                System.out.println("\t" + "Nice! I've marked this task as done:");
                System.out.println("\t" + " " + task.getStatusIcon() + " " + task.getDescription());
                System.out.println("\t" + LINE);
            }

        }

        else if(command.equalsIgnoreCase("unmark")) {
            Task task = tasksList[index - 1];

            if(!task.isDone) {
                System.out.println("\t" + LINE);
                System.out.println("\t" + "My Lord, the task already has the status of Not Done!");
                System.out.println("\t" + " " + task.getStatusIcon() + " " + task.getDescription());
                System.out.println("\t" + LINE);

            }
            else {
                task.markAsNotDone();
                System.out.println("\t" + LINE);
                System.out.println("\t" + "OK, I've marked this task as not done yet:");
                System.out.println("\t" + " " + task.getStatusIcon() + " " + task.getDescription());
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

                System.out.println("\t" + (i + 1) + ". " + tasksList[i].getStatusIcon() + " " + tasksList[i].getDescription());
            }
            System.out.println("\t" + LINE);
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

           if (input.equalsIgnoreCase("list")) {
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



           System.out.println("\t" + LINE);
           System.out.println("\t" + "Added: " + input);
           System.out.println("\t" + LINE);
           tasksList[totalTasks] = new Task(input);
           totalTasks++;
           input = in.nextLine();

       }


        System.out.println("\t" + LINE);
        System.out.println("\t" + "Rest peacefully my Lord, Katappa's sword stays ready for your return.");
        System.out.println("\t" + LINE);

    }
}
