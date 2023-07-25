public class Smelt {
    public static void smelt() {
        try {

            int ironOre = Vars.inv.get("ironOre");
            int coal = Vars.inv.get("coal");
            switch (Vars.input[1]) {
                case "iron" -> {
                        if (coal >= Integer.parseInt(Vars.input[2]) && ironOre >= Integer.parseInt(Vars.input[2])) {
                            ironOre += Integer.parseInt(Vars.input[2]);
                            coal -= Integer.parseInt(Vars.input[2]);
                        } else {
                            System.out.println("Not enough resources!");
                        }
                }
                default -> System.out.println("Not a ore!");
            }
            Vars.inv.put("ironOre", ironOre);
            Vars.inv.put("coal", coal);
        } catch (Exception ignored){}
    }
}
