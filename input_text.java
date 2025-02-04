import java.util.Scanner;

public class input_text {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("What is your name? ");
        String name = input.nextLine();
        System.out.printf("Welcome to the class, %s!", name);
        input.close();
    }
}
