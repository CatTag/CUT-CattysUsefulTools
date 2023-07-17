
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
        String[] inv = {"20", "0", "none"};
        //[0 is wood]
        //[1 is sticks]
        //[2 is pic level]

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
                case "craft":
                    try {
                        craft(inv, input);
                    }
                    catch (Exception ignored) {}
            }

        }
        return(inv);
    }
    public static String[] craft(String[] inv, String[] input){
        int wood = Integer.parseInt(inv[0]);
        int sticks = Integer.parseInt(inv[1]);
        String pic = (inv[2]);

        switch (input[1]) {

            case "sticks":
                try {
                    if (Integer.parseInt(input[2]) <= wood / 2) {
                        sticks += Integer.parseInt(input[2]) * 4;
                        wood -= Integer.parseInt(input[2]) * 2;
                    } else {
                        System.out.println("Not enough resources!");
                    }
                    System.out.println("Total Sticks: " + sticks);
                    System.out.println("Total wood: " + wood);
                } catch (Exception Ignored) {}
                break;

            case "pic":
            case "pickaxe":
                if (pic.equals("wood")){
                    System.out.println("You already have a wooden pickaxe");
                }
                try {
                    if (Integer.parseInt(input[2]) <= wood / 3 && Integer.parseInt(input[2]) <= sticks / 2) {
                        sticks -= Integer.parseInt(input[2]) * 2;
                        wood -= Integer.parseInt(input[2]) * 3;
                        pic = "wood";
                    } else {
                        System.out.println("Not enough resources!");
                    }
                    System.out.println("Total Sticks: " + sticks);
                    System.out.println("Total wood: " + wood);
                    System.out.println("Total wood: " + pic);
                } catch (Exception Ignored) {}
                break;

            default:
                break;
        }
        inv[0] = Integer.toString(wood);
        inv[1] = Integer.toString(sticks);
        inv[2] = pic;
        return(inv);
    }
}
