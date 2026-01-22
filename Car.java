import java.awt.*;

public abstract class Car implements Movable {
    int nrDoors; // Number of doors on the car
    double enginePower; // Engine power of the car
    double currentSpeed; // The current speed of the car
    Color color; // Color of the car
    String modelName; // The car model name

    private double x = 0;
    private double y = 0;
    private Direction dir; // 1 vänster 0 rakt fram -1 till höger? om 1 y * currentSpeed 1 sec?

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
        x  += currentSpeed;
    }
}
