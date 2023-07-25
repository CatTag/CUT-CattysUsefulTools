import java.util.Scanner;
public class TextMC {
    public static void mcMain() {
        System.out.println("#=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=#");
        System.out.println("|This is my take on a text based kind of crap minecraft clone.|");
        System.out.println("|                          Have fun!                          |");
        System.out.println("|            Type help to show a list of commands.            |");
        System.out.println("|           Note: there is no save system currently           |");
        System.out.println("#=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=#");

        Scanner s = new Scanner(System.in);
        String in;
        String name;


        Scanner n = new Scanner(System.in);
        System.out.print("what is your username: ");
        name = n.nextLine();


        //noinspection InfiniteLoopStatement
        while (true) {
            System.out.print(name + ": ");
            in = s.nextLine();
            Vars.input = in.trim().split("\\s+");


            switch (Vars.input[0]) {

                case "craft" -> Craft.craft();
                case "mine" -> Mine.mine();
                case "smelt" -> Smelt.smelt();

                case "inv" -> {
                    switch (Vars.input[1]) {
                        case "list" -> Inventory.list();
                        case "add" -> Inventory.add();
                        case "clear" -> Inventory.clear();
                    }
                }
                case "close" -> Main.main(null);
            }
        }
    }
}