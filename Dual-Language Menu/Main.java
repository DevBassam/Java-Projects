import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Main {
    final static Scanner  input = new Scanner(System.in);
    public static void main(String[] args) throws Exception{
        // let the user choose which language will be used
        String lang = getLanguage();
        // read the properties file depending on the user's choice
        Properties properties = new Properties();
        BufferedReader br = new BufferedReader(new FileReader("D:\\Intllij Projects\\Java Course Laps\\files\\menu_"+lang+".txt"));
        properties.load(br);
        // show the menu with the chosen language
        showMenu(properties);
        // closing the file for saving resources
        br.close();
    }

    private static void showMenu(Properties p) {
        System.out.println("\t\tMain Course");
        showItems(getTheItems(p,"main_course_items"));
        System.out.println("\t\tSides");
        showItems(getTheItems(p,"sides_items"));
    }
    private static String[][] getTheItems(Properties p, String key) {
        String itemsString = p.getProperty(key);

        // Remove the outer braces and split the string into individual array strings
        String[] itemArrayStrings = itemsString
                .substring(2, itemsString.length() - 2) // Remove the outer curly braces
                .split("},\\{"); // Split at each inner array boundary

        // Create a 2D array to hold the parsed values
        String[][] itemsArray = new String[itemArrayStrings.length][2];

        for (int i = 0; i < itemArrayStrings.length; i++) {
            // Split each inner array string by comma
            itemsArray[i] = itemArrayStrings[i].split("\",\"");
            // Remove the quotes from each element
            itemsArray[i][0] = itemsArray[i][0].replace("\"", "");
            itemsArray[i][1] = itemsArray[i][1].replace("\"", "");
        }

        return itemsArray;
    }
    private static void showItems(String[][] items) {
        System.out.println("+++++++++++++++++++++++++");
        for (String[] item : items){
            System.out.println((item[0]+"\t\t"+item[1]+"$").replaceAll("\"",""));
        }
        System.out.println("+++++++++++++++++++++++++");
    }
    private static String getLanguage() {
        String theLanguage = null;
        char langChoice;
        do {
            System.out.println("++--++ Choose Language ++--++");
            System.out.println("\t1- English\n\t2- اللغة العربية");
            langChoice = input.next().charAt(0);
            switch (langChoice) {
                case '1' -> theLanguage = "en";
                case '2' -> theLanguage = "ar";
                default -> System.out.println("Invalid Input");
            }
        } while (theLanguage == null);
        return theLanguage;
    }
}
