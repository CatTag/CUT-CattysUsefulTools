import java.util.Scanner;

public class back {
    static void help(String[] input) {
        try {
            if (input[1].equals("help")) {
                System.out.println("Page: help for help");
                System.out.println("This is the help menu\nIt shows the command in lowercase plain text then any posable arguments in {}");
                System.out.println("eg. exit {exit code}");
                System.out.println("    /\\command  /\\argument in this case what code it exits with");
            } else if (input[1].equals("1")) {
                System.out.println("Page: 1");
                System.out.println("Type help help to get more help");
                System.out.println("exit {exit code}");
                System.out.println("help {page}");
                System.out.println("Page 1 of 1");
            }
        }
        catch (Exception all){
            System.out.println("Page: 1");
            System.out.println("Type help help to get more help");
            System.out.println("exit {exit code}");
            System.out.println("help {page}");
            System.out.println("Page 1 of 1");
        }
    }
    static void pythag(){
        double a;
        double b;
        Scanner s = new Scanner(System.in);
        String input;
        do {
            System.out.print("+ or - ");
            System.out.println("+-");
            input = s.nextLine();
        } while (!(input.equals("+") | input.equals("-")));
        switch (input) {
            case "+":
                while (true) {
                    System.out.println("A: ");
                    try {
                        a = Double.parseDouble(s.nextLine().trim());
                        break;
                    }  catch (Exception ignored) {}}
                while (true) {
                    System.out.println("B: ");
                    try {
                        b = Double.parseDouble(s.nextLine().trim());
                        break;
                    } catch(Exception ignored){}}
                System.out.println("C: " + Math.round(Math.sqrt(a*a+b*b)*100)/100);
                break;

            case "-":
                while (true) {
                    System.out.println("C: ");
                    try {
                        a = Double.parseDouble(s.nextLine().trim());
                        break;
                    }  catch (Exception ignored) {}}
                while (true) {
                    System.out.println("A/B: ");
                    try {
                        b = Double.parseDouble(s.nextLine().trim());
                        break;
                    } catch(Exception ignored){}}
                System.out.println("B/A: " + Math.round(Math.sqrt(a*a-b*b)*100)/100);
                break;
        }
    }
}
