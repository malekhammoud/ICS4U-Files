package Polymorphism;

public class Animal {
    String name;
    public Animal(String name){
        //ethods move(), eat(), and makeSound().
        this.name = "The "+name;
    }
    /*
    Override the move() method in each subclass to describe how each animal moves.
    Override the makeSound() method in each subclass to make a specific sound for each animal.
    Override the eat() method in each subclass to describe what each animal eats.
     */
    public void name(){
        System.out.println(this.name);
    }
    public void move(int steps){
        System.out.println("Crawling " + steps + " steps");
    }
    public void eat(String food){
        System.out.println("Munching on the " + food);
    }
    public void makeSound(){
        System.out.println("<loud animal Sound>");
    }
}
