package OOP_review;
import java.util.*;

public class translation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int in;
        HashMap<Integer, String> english = new HashMap<Integer, String>(10);
        english.put(1, "One");
        english.put(2, "two");
        english.put(3, "three");
        english.put(4, "four");
        english.put(5, "five");

        while (true){
            try{
                in = sc.nextInt();
                if (english.get(in) == null){
                    System.out.println("Not Found");
                }
                else {
                    System.out.println(english.get(in));
                }
            }catch(Exception e){
                break;
            }
        }

    }
}
