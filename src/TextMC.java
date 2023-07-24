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
                        craft();
                    } catch (Exception ignored) {
                    }
                }
                case "mine" -> {
                    try {
                        mine();
                    } catch (Exception ignored) {
                    }
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
    public static void craft(){

        int planks = Integer.parseInt(Vars.inv[0]);
        int sticks = Integer.parseInt(Vars.inv[1]);
        String pic = Vars.picLevel;
        int logs = Integer.parseInt(Vars.inv[3]);
        int stone = Integer.parseInt(Vars.inv[4]);
        int coal = Integer.parseInt(Vars.inv[5]);
        int iron = Integer.parseInt(Vars.inv[6]);
        boolean furnace = Vars.furnace;


        switch (Vars.input[1]) {
            case "sticks" -> {
                try {
                    if (Integer.parseInt(Vars.input[2]) <= planks / 2) {
                        sticks += Integer.parseInt(Vars.input[2]) * 4;
                        planks -= Integer.parseInt(Vars.input[2]) * 2;
                    } else {
                        System.out.println("Not enough resources!");
                    }
                    System.out.println("Total Sticks: " + sticks);
                    System.out.println("Total wood: " + planks);
                } catch (Exception ignored) {}
            }
            case "pic", "pickaxe" -> {
                if (Vars.input[2].equals("wood")){
                    if (pic.equals("wood")) {
                        System.out.println("You already have a wooden pickaxe");

                    }
                    else {
                        if (planks >= 3 && sticks >= 2) {
                            sticks -= 2;
                            planks -= 3;
                            pic = "wood";
                            System.out.println("Total Sticks: " + sticks);
                            System.out.println("Total planks: " + planks);
                            System.out.println("Pic level: " + pic);
                        } else {
                            System.out.println("Not enough resources!");
                        }
                    }
                } else
                    if (Vars.input[2].equals("stone")){
                    if (pic.equals("stone")) {
                        System.out.println("you already have a stone pic");
                    }
                    else{
                        if (stone >= 3 && sticks >= 2) {
                            sticks -= 2;
                            stone -= 3;
                            pic = "stone";
                        } else {
                            System.out.println("Not enough resources!");
                        }
                    }
                }
            }
            case "planks" -> {
                try {
                    if (Integer.parseInt(Vars.input[2]) <= logs) {
                        logs -= Integer.parseInt(Vars.input[2]);
                        planks += Integer.parseInt(Vars.input[2]) * 4;
                        System.out.println("Total logs: " + logs);
                        System.out.println("Total planks: " + planks);
                    } else {
                        System.out.println("Not enough resources!");
                    }
                } catch (Exception ignored) {}
            }
            case "furnace" -> {
                if (!furnace) {
                    if (stone >= 8) {
                        furnace = true;
                        stone -= 8;
                        System.out.println("Furnace: " + furnace);
                        System.out.println("Stone: " + stone);
                    } else { System.out.println("Not enough resources!");}
                } else { System.out.println("You already have a furnace!");}
            }


            default -> {
            }
        }
        Vars.inv[0] = Integer.toString(planks);
        Vars.inv[1] = Integer.toString(sticks);
        Vars.inv[2] = pic;
        Vars.inv[3] = Integer.toString(logs);
        Vars.inv[4] = Integer.toString(stone);
        Vars.inv[5] = Integer.toString(coal);
        Vars.inv[6] = Integer.toString(iron);
        Vars.inv[7] = Boolean.toString(furnace);
    }



    public static void mine() {
        Random r = new Random();
        int ore;
        int y = Integer.parseInt(Vars.input[1]);
        String pic = Vars.picLevel;
        int logs = Integer.parseInt(Vars.inv[3]);
        int stone = Integer.parseInt(Vars.inv[4]);
        int coal = Integer.parseInt(Vars.inv[5]);
        int iron = Integer.parseInt(Vars.inv[6]);


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
        Vars.inv[3] = Integer.toString(logs);
        Vars.inv[4] = Integer.toString(stone);
        Vars.inv[5] = Integer.toString(coal);


    }
}