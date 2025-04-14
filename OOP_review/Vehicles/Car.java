package OOP_review.Vehicles;

public class Car extends Vehicle {


    @Override
    void startEngin() {
        System.out.println("Car Engine is running");
    }

    @Override
    void stopEngin() {
        System.out.println("Car Engine is stopped");

    }
}
