import java.util.Scanner;
import java.util.Random;
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


        Inventory.createInv();


        Scanner n = new Scanner(System.in);
        System.out.print("what is your username: ");
        name = n.nextLine();


        //noinspection InfiniteLoopStatement
        while (true) {
            System.out.print(name + ": ");
            in = s.nextLine();
            Vars.input = in.trim().split("\\s+");


            switch (Vars.input[0]) {
                case "craft" -> {
                    try {
                        Craft.craft();
                    } catch (Exception ignored) {}
                }
                case "mine" -> {
                    try {
                        mine();
                    } catch (Exception ignored) {}
                }
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



    public static void mine() {
        Random r = new Random();

        int ore;
        int y = Integer.parseInt(Vars.input[1]);

        int planks = Vars.inv.get("planks");
        int sticks = Vars.inv.get("sticks");
        int logs = Vars.inv.get("logs");
        int stone = Vars.inv.get("stone");
        int coal = Vars.inv.get("coal");
        int iron = Vars.inv.get("iron");

        String pic = Vars.picLevel;

        if (y >= 64) {
            logs += r.nextInt(10)+1;
            System.out.println("Total logs: " + logs);
        } else
            //noinspection ConstantValue
            if (y < 64 && !pic.equals("none")){
            stone += r.nextInt(20)+1;
            System.out.println("Total stone: " + stone);
            ore = r.nextInt(2);
            if (ore == 1){
                coal += r.nextInt(5)+5;
                System.out.println("Total coal: " + coal);
            }
            if (y <= 45){
                ore = r.nextInt(3);
                //noinspection ConstantValue
                if (ore == 1 && !(pic.equals("wood") | pic.equals("none"))){
                    iron += r.nextInt(2)+3;
                    System.out.println("Total iron: " + iron);
                } else if (ore == 1) {
                    if (Vars.firstPicPrompt){
                        System.out.println("You need a stone or higher tier pic to mine iron!");
                        System.out.println("Note: you can still mine at this Y level you just wont get any iron");
                        Vars.firstPicPrompt = false;
                    } else {
                        System.out.println(r.nextInt(2)+3);
                    }

                }
            }
        } else {System.out.println("You need a pic to mine below ground!");}


        Vars.inv.put("planks", planks);
        Vars.inv.put("sticks", sticks);
        Vars.inv.put("logs", logs);
        Vars.inv.put("stone", stone);
        Vars.inv.put("coal", coal);
        Vars.inv.put("iron", iron);


    }
}