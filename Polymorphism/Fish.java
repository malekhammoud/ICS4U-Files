package Polymorphism;

public class Fish extends Animal {
    public Fish(String name) {
        super(name);
    }
    public void move(int steps){
        System.out.println("Swimming " + steps + " meters");
    }
    public void eat(String food){
        System.out.println("Nibleing the " + food);
    }
    public void makeSound(){
        System.out.println("Bloop bloop bloop....");
    }

}
