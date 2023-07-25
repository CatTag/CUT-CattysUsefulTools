public class Craft {
    public static void craft() {
        try {

            int planks = Vars.inv.get("planks");
            int sticks = Vars.inv.get("sticks");
            int logs = Vars.inv.get("logs");
            int stone = Vars.inv.get("stone");
            int coal = Vars.inv.get("coal");
            int ironOre = Vars.inv.get("ironOre");

            boolean furnace = Vars.furnace;
            String pic = Vars.picLevel;

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
                    } catch (Exception ignored) {
                    }
                }
                case "pic", "pickaxe" -> {
                    if (Vars.input[2].equals("wood")) {
                        if (pic.equals("wood")) {
                            System.out.println("You already have a wooden pickaxe");

                        } else {
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
                    } else if (Vars.input[2].equals("stone")) {
                        if (pic.equals("stone")) {
                            System.out.println("you already have a stone pic");
                        } else {
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
                    } catch (Exception ignored) {
                    }
                }
                case "furnace" -> {
                    if (!furnace) {
                        if (stone >= 8)
                        {
                            furnace = true;
                            stone -= 8;
                            System.out.println("Furnace: " + furnace);
                            System.out.println("Stone: " + stone);
                        } else {
                            System.out.println("Not enough resources!");
                        }
                    } else {
                        System.out.println("You already have a furnace!");
                    }
                }


                default -> {
                }
            }
            Vars.inv.put("planks", planks);
            Vars.inv.put("sticks", sticks);
            Vars.inv.put("logs", logs);
            Vars.inv.put("stone", stone);
            Vars.inv.put("coal", coal);
            Vars.inv.put("ironOre", ironOre);

            Vars.furnace = furnace;
            Vars.picLevel = pic;
        } catch (Exception ignored){}
    }
}