import java.util.Scanner;

public class Katappa {

    public static final String NAME = "Katappa";
    public static String LINE = "___________________________________________________________";
    private static String[] tasksList = new String[100];
    private static int totalTasks = 0;

    private static void printTaskList() {

        if(totalTasks == 0) {
            System.out.println("\t" + LINE);
            System.out.println("\t" + "No tasks yet master. Please add tasks, I am at your service.");
            System.out.println("\t" + LINE);

        }

        for(int i = 0; i < totalTasks; i++) {
            System.out.println("\t" + LINE);
            System.out.println("\t" + (i + 1) + ". " + tasksList[i]);
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

           if(input.equalsIgnoreCase("list")) {
               printTaskList();
               input = in.nextLine();
               continue;
           }

           System.out.println("\t" + LINE);
           System.out.println("\t" + "Added: " + input);
           System.out.println("\t" + LINE);
           tasksList[totalTasks] = input;
           totalTasks++;
           input = in.nextLine();
       }

        System.out.println("\t" + LINE);
        System.out.println("\t" + "Rest peacefully my Lord, Katappa's sword stays ready for your return.");
        System.out.println("\t" + LINE);

    }
}
