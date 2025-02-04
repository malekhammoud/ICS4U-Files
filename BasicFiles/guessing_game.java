package BasicFiles;

import java.util.Scanner;
import java.util.Random;
public class guessing_game {
    public static void main(String[] args) {
        System.out.println("Guess a number between 1 and 100");
        Random rand = new Random();
        int number = rand.nextInt(1,100);
        while (true){
            try{
                System.out.print("Your guess: ");
                Scanner sc = new Scanner(System.in);
                int guess = sc.nextInt();
                if (guess <= 0 || guess >= 100){
                    System.out.println("Invalid input, only numbers between 1 and 100");
                }
                if (guess == number){
                    System.out.println("Congratulations! You guessed it!");
                    break;
                }else if(guess > number){
                    System.out.println("Too high");
                }else if(guess < number){
                    System.out.println("Too low");
                }
            } catch(Exception e){
                System.out.println("Invalid input, only numbers between 1 and 100");
            }
        }
        System.out.println("Thank you for playing this game!");
    }
}
