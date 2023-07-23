public class Inventory {
    static void list(){
        System.out.println("Planks: "+Vars.inv[0]);
        System.out.println("Sticks: "+Vars.inv[1]);

        System.out.println("Logs: "+Vars.inv[3]);
        System.out.println("Stone: "+Vars.inv[4]);
        System.out.println("Coal: "+Vars.inv[5]);
        System.out.println("Iron: "+Vars.inv[6]);
    }
    static void add(){
        int item = Integer.parseInt(Vars.inv[Integer.parseInt(Vars.input[3])]);
        item += Integer.parseInt(Vars.input[2]);
        Vars.inv[Integer.parseInt(Vars.input[3])] = Integer.toString(item);
    }
    static void clear(){

    }
}
