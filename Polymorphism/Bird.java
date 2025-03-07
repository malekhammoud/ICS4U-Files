package Polymorphism;

import javax.xml.namespace.QName;

public class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }
    public void move(int steps){
        System.out.println("Flying " + steps + " flaps");
    }
    public void eat(String food){
        System.out.println("Pecking on the " + food);
    }
    public void makeSound(){
        System.out.println("Chirp, chirp, chirp...");
    }

}
