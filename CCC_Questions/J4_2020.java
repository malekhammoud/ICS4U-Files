package CCC_Questions;
import java.util.Scanner;
public class J4_2020 {
    /*
    loops thourhg first string:
        checks to see if string starts with b
        removes first litte rof string
     */

    /**
     * comparies of string b is in string a
     * @param a
     * @param b
     * @return boolean
     */
    public static boolean stringin(String a, String b) {
        String temp = a;
        for (int i = 0; i < a.length(); i++) {
            if(temp.startsWith(b)){
                return true;
            }
            temp = temp.substring(1);
        }
        return false;
    }
    public static String shiftString(String a) {
        String temp = a;
        temp = temp.substring(0,1);
        a = a.substring(1);
        a+=temp;
        return a;
    }
    public static void mainloop(String a, String b){
        for (int i = 0; i<a.length(); i++) {
            if (stringin(a,b)){
                System.out.println("yes");
                return;
            }
            b = shiftString(b);
        }
        System.out.println("no");
        return;

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        mainloop(a,b);
    }
}
