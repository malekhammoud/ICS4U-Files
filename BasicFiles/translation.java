package BasicFiles;

import java.util.Scanner;

public class translation {
    /**
     * translates from a number to spanish
     * @param number
     * @return String word
     */
    public static String translate(int number){
        String[] spanishnums= {"", "uno", "dos","tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez"};
        return spanishnums[number];

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int number = sc.nextInt();
        System.out.println("Translated number: " + translate(number));

    }
}
