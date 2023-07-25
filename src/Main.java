import java.util.Scanner;
import java.time.Instant;
public class Main {
    public static void main(String[] args) throws InterruptedException{
        Scanner s = new Scanner(System.in);
        String in;
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
                case "exit" -> {
                    try {
                        s.close();
                        System.exit(Integer.parseInt(input[1]));
                    } catch (Exception all) {
                        s.close();
                        System.exit(0);
                    }
                }
                case "help" -> Background.help();
                case "pythag" -> Background.pythag();
                case "mc" -> TextMC.mcMain();
                case "test" -> test();
            }
        }
    }
    static void test() throws InterruptedException{
        int i = Integer.parseInt(Vars.input[1]);
        double start = Instant.now().toEpochMilli();
        while(i>0){i--;}
        double end = Instant.now().toEpochMilli();
        System.out.println("It took " + (end - start)/100 + " seconds!");
    }
}