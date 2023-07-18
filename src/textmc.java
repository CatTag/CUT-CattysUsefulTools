import java.net.InterfaceAddress;
import java.util.Scanner;
import java.util.Random;
public class textmc {
    public static void main(String[] args){
        System.out.println("#=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=#");
        System.out.println("|This is my take on a text based kind of crap minecraft clone.|");
        System.out.println("|                          Have fun!                          |");
        System.out.println("|            Type help to show a list of commands.            |");
        System.out.println("|           Note: there is no save system currently           |");
        System.out.println("#=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=#");
        //String[] inv = inv.start;
        String[] inv = {"0", "0", "none", "0", "0", "0", "0", "false"};
        //[0] planks
        //[1] sticks
        //[2] pic level
        //[3] logs
        //[4] stone
        //[5] coal
        //[6] iron
        //[7] furnace (bool)


        plains(inv);

    }

    public static String[] plains(String[] inv){

        Scanner s = new Scanner(System.in);
        String in;
        String[] input;
        boolean running = true;

        while (running) {
            System.out.print("Plains: ");
            in = s.nextLine();
            input = in.trim().split("\\s+");


            switch (input[0]) {
                case "craft" -> {
                    try {
                        craft(inv, input);
                    } catch (Exception ignored) {
                    }
                }
                case "mine" -> {
                    try {
                        mine(inv, input);
                    } catch (Exception ignored) {}}
                case "inv" -> {
                    if (input[1].equals("list")){
                        inv.list(inv);
                    } else if (input[1].equals("add")) {
                        inv.add(inv, input);
                    } else if (input[1].equals("clear")){
                        inv.clear(inv, input);
                    }
                }

            }

        }
        return(inv);
    }
    public static String[] craft(String[] inv, String[] input){

        int planks = Integer.parseInt(inv[0]);
        int sticks = Integer.parseInt(inv[1]);
        String pic = (inv[2]);
        int logs = Integer.parseInt(inv[3]);
        int stone = Integer.parseInt(inv[4]);
        int coal = Integer.parseInt(inv[5]);
        int iron = Integer.parseInt(inv[6]);
        boolean furnace = Boolean.parseBoolean(inv[7]);


        switch (input[1]) {
            case "sticks" -> {
                try {
                    if (Integer.parseInt(input[2]) <= planks / 2) {
                        sticks += Integer.parseInt(input[2]) * 4;
                        planks -= Integer.parseInt(input[2]) * 2;
                    } else {
                        System.out.println("Not enough resources!");
                    }
                    System.out.println("Total Sticks: " + sticks);
                    System.out.println("Total wood: " + planks);
                } catch (Exception ignored) {}
            }
            case "pic", "pickaxe" -> {
                if (input[1].equals("wood")){
                    if (pic.equals("wood")) {
                        System.out.println("You already have a wooden pickaxe");

                    }
                    else {
                        if (planks >= 3 && sticks >= 2) {
                            sticks -= 2;
                            planks -= 3;
                            pic = "wood";
                        } else {
                            System.out.println("Not enough resources!");
                        }
                        System.out.println("Total Sticks: " + sticks);
                        System.out.println("Total planks: " + planks);
                        System.out.println("Pic level: " + pic);
                    }
                } else if (input[1].equals("stone")){
                    if (stone >= 3 && sticks >= 2) {
                        sticks -= 2;
                        stone -= 3;
                    }
                }
            }
            case "planks" -> {
                if (Integer.parseInt(input[1]) <= Integer.parseInt(inv[3])) {
                    logs -= Integer.parseInt(input[1]);
                    planks += Integer.parseInt(inv[1]) * 4;
                    System.out.println("Total logs: " + logs);
                    System.out.println("Total planks: " + planks);
                } else {
                    System.out.println("Not enough resources!");
                }
            }
            default -> {
            }
        }
        inv[0] = Integer.toString(planks);
        inv[1] = Integer.toString(sticks);
        inv[2] = pic;
        inv[3] = Integer.toString(logs);
        inv[4] = Integer.toString(stone);
        inv[5] = Integer.toString(coal);
        inv[6] = Integer.toString(iron);
        return(inv);
    }



    public static  String[] mine(String[] inv, String[] input) {
        Random r = new Random();
        int ore;

        int y = Integer.parseInt(input[1]);

        String pic = inv[2];
        int logs = Integer.parseInt(inv[3]);
        int stone = Integer.parseInt(inv[4]);
        int coal = Integer.parseInt(inv[5]);
        int iron = Integer.parseInt(inv[6]);


        if (y > 64) {
            logs += r.nextInt(10)+1;
        } else if (y <= 64){
            stone =+ r.nextInt(20)+1;
            ore = r.nextInt(2);
            if (ore == 1){
                coal =+ r.nextInt(5)+5;
            }
            if (y <= 45){
                ore = r.nextInt(3);
                if (ore == 1 && !(pic != "wood" | pic != "none")){
                    iron =+ r.nextInt(2)+3;
                } else if (ore == 1){
                    System.out.println("You need a stone or higher tier pic to mine iron!");

                }
            }
        }
        inv[3] = Integer.toString(logs);
        inv[4] = Integer.toString(stone);
        inv[5] = Integer.toString(coal);

        System.out.println("Total Logs: " + logs);

        return(inv);
    }
}
