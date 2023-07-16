import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String in;
        int i;
        System.out.println("\n\n#=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=#");
        System.out.println("        Hello this is CUT or Cattys Useful Tools!        ");
        System.out.println(" This program contains a lot of random tools and things. ");
        System.out.println("          Type help to see a list of commands.           ");
        System.out.println("#=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=#\n");

        while (true) {
            System.out.print("Command: ");
            in = s.nextLine();
            String[] input = in.trim().split("\\s+");


            switch (input[0]) {
                case "exit":
                    try {
                        i = Integer.parseInt(input[1]);
                        s.close();
                        System.exit(i);
                    } catch (Exception all) {
                        s.close();
                        System.exit(0); }
                case "help":
                    back.help(input);

                case "pythag":
                    back.pythag();

                case "mc":
                    textmc.main(null);
            }
        }
    }
}