package Polymorphism;

public class Lion extends Animal {
    public Lion(String name) {
        super(name);
    }
    public void move(int steps){
        System.out.println("Gently stepping " + steps + " steps");
    }
    public void eat(String food){
        System.out.println("Ripping the" + food);
    }
    public void makeSound(){
        System.out.println("RAWARR!!!");
    }

}
