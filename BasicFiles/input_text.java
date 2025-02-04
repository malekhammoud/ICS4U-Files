package BasicFiles;

import java.util.Scanner;

public class input_text {
    public static void main(String[] args){
        while(true){
            try{
                Scanner sc = new Scanner(System.in);
                System.out.print("How old are you? ");
                int age =Math.abs(sc.nextInt());
                sc.close();
                switch(age){
                    case 1, 2,3,4 -> {
                        System.out.println("You are old enough to use this program");
                    }
                    case 5, 6,7,8 -> {
                        System.out.println("Wow, your a big boy");
                    }
                    default -> {
                        if (age < 13) System.out.printf("You are a child. And you are %d years old.\n", age );
                        else if (age < 20) System.out.println("You are a teenager.");
                        else System.out.println("You are an adult.");
                    }
                }
                break;
            } catch(Exception e){
                System.out.println("Something went wrong, try again with proper input");
            }
        }
    }
}