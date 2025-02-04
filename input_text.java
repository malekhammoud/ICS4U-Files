import java.util.Scanner;

public class input_text {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("How old are you? ");
        int age = sc.nextInt();
        sc.close();
        if (age < 13) System.out.println("You are a child.");
        else if (age < 20) System.out.println("You are a teenager.");
        else System.out.println("You are an adult.");
    }

}
