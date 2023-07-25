import java.util.Random;

public class Mine {
    public static void mine() {
        try {
            Random r = new Random();

            int ore;
            int y = Integer.parseInt(Vars.input[1]);

            int planks = Vars.inv.get("planks");
            int sticks = Vars.inv.get("sticks");
            int logs = Vars.inv.get("logs");
            int stone = Vars.inv.get("stone");
            int coal = Vars.inv.get("coal");
            int ironOre = Vars.inv.get("ironOre");

            String pic = Vars.picLevel;

            if (y >= 64) {
                logs += r.nextInt(10) + 1;
                System.out.println("Total logs: " + logs);
            } else
                //noinspection ConstantValue
                if (y < 64 && !pic.equals("none")) {
                    stone += r.nextInt(20) + 1;
                    System.out.println("Total stone: " + stone);
                    ore = r.nextInt(2);
                    if (ore == 1) {
                        coal += r.nextInt(5) + 5;
                        System.out.println("Total coal: " + coal);
                    }
                    if (y <= 45) {
                        ore = r.nextInt(3);
                        //noinspection ConstantValue
                        if (ore == 1 && !(pic.equals("wood") | pic.equals("none"))) {
                            ironOre += r.nextInt(2) + 3;
                            System.out.println("Total iron: " + ironOre);
                        } else if (ore == 1) {
                            if (Vars.firstPicPrompt) {
                                System.out.println("You need a stone or higher tier pic to mine iron!");
                                System.out.println("Note: you can still mine at this Y level you just wont get any iron");
                                Vars.firstPicPrompt = false;
                            } else {
                                System.out.println(r.nextInt(2) + 3);
                            }

                        }
                    }
                } else {
                    System.out.println("You need a pic to mine below ground!");
                }


            Vars.inv.put("planks", planks);
            Vars.inv.put("sticks", sticks);
            Vars.inv.put("logs", logs);
            Vars.inv.put("stone", stone);
            Vars.inv.put("coal", coal);
            Vars.inv.put("ironOre", ironOre);


        } catch (Exception ignored){}
    }
}
