package Polymorphism;

import java.util.Scanner;
import java.util.ArrayList;

public class main {
    static Animal assign_animal() {
        String choice;
        Scanner input = new Scanner(System.in);
        System.out.println("Create A ");
        System.out.print("Bird[b], Lion[l], Fish[f], Quit[q]: ");
        choice = input.nextLine();

        if (choice.equalsIgnoreCase("b")){
            System.out.print("Name: ");
            String name = input.nextLine();
            return new Bird(name);
        }
        else if (choice.equalsIgnoreCase("l")){
            System.out.print("Name: ");
            String name = input.nextLine();
            return new Lion(name);
        }
        else if (choice.equalsIgnoreCase("f")){
            System.out.print("Name: ");
            String name = input.nextLine();
            return new Fish(name);
        }
        else {
            return null;
        }
    }
    public static void main(String[] args) {
        Animal Animal1= new Animal("Ann");
        Animal animal = new Bird("sam");
        animal.name();

        Scanner input = new Scanner(System.in);
        ArrayList<Animal> animals= new ArrayList<Animal>();

        Animal userin;
        while(true){
            userin = assign_animal();
            if (userin != null){
                animals.add(userin);
            }
            else{
                break;
            }
        }
        for (int i = 0; i < animals.size(); i++){
            animals.get(i).makeSound();
        }


    }
}
