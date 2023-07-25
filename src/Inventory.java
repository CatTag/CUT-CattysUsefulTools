import java.util.Map;
public class Inventory {
    static void list() {
        for (Map.Entry<String, Integer> entry : Vars.inv.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println(key + ": " + value);
        }

    }

    static void add() {
        try {
            Vars.inv.put(Vars.input[2], Integer.parseInt(Vars.input[3]));
            System.out.println("Added " + Vars.input[3] + " " + Vars.input[2] + "!");
        } catch (Exception ignored) {
            System.out.println("Invalid Syntax");
        }
    }

    static void clear() {
        Vars.inv.clear();
    }
    static void create(){
        Vars.inv.put("planks", 0);
        Vars.inv.put("sticks", 0);
        Vars.inv.put("logs", 0);
        Vars.inv.put("stone", 0);
        Vars.inv.put("coal", 0);
        Vars.inv.put("ironOre", 0);
        Vars.inv.put("iron", 0);
    }
}