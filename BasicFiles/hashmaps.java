package BasicFiles;

import java.util.*;
public class hashmaps {
    public static void main(String[] args) {
        // Create a HashMap object called capitalCities
        HashMap<String, ArrayList<String>> students= new HashMap<String, ArrayList<String>>();
        /*
        HashMap<String, String> capitalCities = new HashMap<String, String>();
        // Add keys and values (Country, City)
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");

        capitalCities.remove("England");
        for (String city: capitalCities.values()) {
            System.out.println(city);
        }
         */
        Scanner input = new Scanner(System.in);
        String name = "y";
        String data;
        while (true) {
            System.out.println("Input Student name q to quit: ");
            name = input.nextLine();
            if (name.equals("q")) {
                break;
            }
            ArrayList<String> courses =  new ArrayList<String>();
            while (true){
                System.out.println("Enter Course: ");
                data = input.nextLine();
                if (data.equals("q")) {
                    break;
                }
                courses.add(data);
            }
            students.put(name, courses);
        }
        System.out.println(" ");
        for (ArrayList<String> i: students.values()) {
            for (String cours : i) {
                System.out.println(cours);
            }
        }
    }

}
