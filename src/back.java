public class back {
    static void help(String[] input) {
        try {
            if (input[1].equals("help")) {
                System.out.println("Page: help for help");
                System.out.println("This is the help menu\nIt shows the command in lowercase plain text then any posable arguments in {}");
                System.out.println("eg. exit {exit code}");
                System.out.println("    /\\command  /\\argument in this case what code it exits with");
            } else if (input[1].equals("1")) {
                System.out.println("Page: 1");
                System.out.println("Type help help to get more help");
                System.out.println("exit {exit code}");
                System.out.println("help {page}");
                System.out.println("Page 1 of 1");
            }
        }
        catch (Exception all){
            System.out.println("Page: 1");
            System.out.println("Type help help to get more help");
            System.out.println("exit {exit code}");
            System.out.println("help {page}");
            System.out.println("pythag {+ or -} {A/C} {B/A}");
            System.out.println("Page 1 of 1");
        }
    }
    static void pythag(String[] abc){
        if (abc[1].equals("+")) {
            try {
                double a = Double.parseDouble(abc[2]);
                double b = Double.parseDouble(abc[3]);
                System.out.println("C: " + Math.round(Math.sqrt(a * a + b * b) * 100) / 100);
            } catch (Exception all) { System.out.println(("A or B are NaN")); }
        }
        else{
            try{
                double c = Double.parseDouble(abc[2]);
                double b = Double.parseDouble(abc[3]);
                System.out.println("C: " + Math.round(Math.sqrt(c*c-b*b)*100)/100);
            } catch (Exception all){ System.out.println(("C or B are NaN")); }
        }
    }
}
