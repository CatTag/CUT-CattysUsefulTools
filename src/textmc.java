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
        Scanner s = new Scanner(System.in);
        String input;
        int health = 20;

        plains(health);
    }
    public static String[] plains(int health){
        String[] r = {Integer.toString(health)};
        String in;
        String[] input;

        int wood = 0;
        int sticks = 0;//test

        Scanner s = new Scanner(System.in);
        System.out.print("Plains: ");
        in = s.nextLine();
        input = in.trim().split("\\s+");


        switch (input[0]){
            case "wood>sticks":
               sticks += (Integer.parseInt(input[1])*2);
               System.out.println("Total Sticks: " + sticks);
               System.out.println("Total wood: " + wood);
        }


        return(r);
    }
}
