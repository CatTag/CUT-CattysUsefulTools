public class Inventory {
    static void list(){
        System.out.println("Planks: " + Vars.inv.get("planks"));
        System.out.println("Sticks: " + Vars.inv.get("sticks"));
        System.out.println("Logs: " + Vars.inv.get("logs"));
        System.out.println("Stone: " + Vars.inv.get("stone"));
        System.out.println("Coal: " + Vars.inv.get("coal"));
        System.out.println("Iron: " + Vars.inv.get("iron"));
    }
    static void add(){
        try {
            Vars.inv.put(Vars.input[2], Integer.parseInt(Vars.input[3]));
        } catch (Exception ignored) { System.out.println("Invalid Syntax"); }
    }
    static void clear(){
        Vars.inv.clear();
    }
    public static void createInv(){
        Vars.inv.put("planks", 0);
        Vars.inv.put("sticks", 0);
        Vars.inv.put("logs", 0);
        Vars.inv.put("stone", 0);
        Vars.inv.put("coal", 0);
        Vars.inv.put("iron", 0);
    }
}
