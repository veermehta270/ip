import java.util.Scanner;

public class Katappa {

    public static final String NAME = "Katappa";
    public static String LINE = "___________________________________________________________";

    public static void printBoxed(String message) {
        String line = "===========================================================";
        System.out.println("\t" + line);
        System.out.println("\t║ " + message);
        System.out.println("\t" + line);
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);


        System.out.println("\t" + LINE);
        System.out.println("\t" + "Namaste! My Lord, I'm " + NAME + " your loyal servant");
        System.out.println("\t" + "How can I serve you today?");
        System.out.println("\t" + LINE);

       String input = in.nextLine();


       while((!input.equalsIgnoreCase("bye"))) {
           System.out.println("\t" + LINE);
           System.out.println("\t" + input);
           System.out.println("\t" + LINE);
           input = in.nextLine();
       }

        System.out.println("\t" + LINE);
        System.out.println("\t" + "Rest peacefully my Lord, Katappa's sword stays ready for your return.");
        System.out.println("\t" + LINE);

    }
}
