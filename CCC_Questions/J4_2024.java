package CCC_Questions;
import java.util.Scanner;
public class J4_2024 {
    public static boolean checkin(String a,char b){
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) == b){
                return false;
            }
        }
        return true;
    }
    public static int checkinarray(char[] a,char b){
        for (int i = 0; i < a.length; i++) {
            if(a[i] == b){
                return i;
            }
        }
        return 0;
    }
    public static char findchar(String a, String b){
        char[] letters = new char[a.length()];
        int[] count = new int[a.length()];
        for (int i = 0; i < a.length(); i++) {
            if (checkin(b, a.charAt(i))) {
                letters[checkinarray(letters, a.charAt(i))] = a.charAt(i);
                count[checkinarray(letters, a.charAt(i))]++;
            }
        }
        for (int i = 0; i < letters.length; i++) {
            System.out.print(count[i]);
        }
        int index = 0;
        for( int i = 0; i < count.length; i++) {
            if (count[i] > count[index]) {
                index = i;
            }
        }
        return letters[index];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String keys = sc.nextLine();
        String displayed = sc.nextLine();
        char sillykeyout;
        for(int i = 0; i < displayed.length(); i++) {
            if (checkin(keys, displayed.charAt(i))) {
                System.out.println(displayed.charAt(i));
                sillykeyout = displayed.charAt(i);
            }
        }
        int num = keys.length() - displayed.length();
        for(int i = 0; i < keys.length(); i++) {
            if (checkin(displayed, keys.charAt(i))) {
                System.out.println(findchar(keys, displayed));
            }
        }
    }
}
