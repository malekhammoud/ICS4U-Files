package OOP_review.Vehicles;

public class Motorcycle extends Vehicle {
    @Override
    void startEngin() {
        System.out.println("MotorCycle Engine is started");
    }

    @Override
    void stopEngin() {
        System.out.println("Motorcycle Engine is stopped");
    }
}
