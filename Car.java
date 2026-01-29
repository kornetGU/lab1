import java.awt.*;

public abstract class Car implements Movable {
    int nrDoors; // Number of doors on the car
    double enginePower; // Engine power of the car
    double currentSpeed; // The current speed of the car
    Color color; // Color of the car
    String modelName; // The car model name

    private double x = 0.0;
    private double y = 0.0;
    private Direction dir = Direction.FORWARD; //

    // all future cars will also need to declare these fields

    int getNrDoors(){
        return nrDoors;
    }
    double getEnginePower(){
        return enginePower;
    }
    double getCurrentSpeed(){
        return currentSpeed;
    }
    Color getColor(){
        return color;
    }
    void setColor(Color clr){
        color = clr;
    }
    void startEngine(){
        currentSpeed = 0.1;
    }
    void stopEngine(){
        currentSpeed = 0;
    }

    abstract double speedFactor();
    abstract void incrementSpeed(double amount);
    abstract void decrementSpeed(double amount);

    @Override
    public void move() {
        switch (dir) {
            case FORWARD -> x += currentSpeed;
            case BACKWARD -> x -= currentSpeed;
            case LEFT -> y += currentSpeed;
            case RIGHT -> y -= currentSpeed;
        }
        System.out.println("coordinates after moving:\n x: " + x + " y: " + y);
    }

    @Override
    public void turnLeft() {
        switch (dir) {
            case FORWARD -> dir = Direction.LEFT;
            case BACKWARD -> dir = Direction.RIGHT;
            case LEFT -> dir = Direction.BACKWARD;
            case RIGHT -> dir = Direction.FORWARD;
        }
    }

    @Override
    public void turnRight() {
        switch (dir) {
            case FORWARD -> dir = Direction.RIGHT;
            case BACKWARD -> dir = Direction.LEFT;
            case LEFT -> dir = Direction.FORWARD;
            case RIGHT -> dir = Direction.BACKWARD;
        }
    }
}
