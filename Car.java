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
        double distance = currentSpeed * 10;
        switch(dir) {
            case FORWARD:
                x += distance;
                break;
            case BACKWARD:
                x -= distance;
                break;
            case RIGHT:
                y -= distance;
                break;
            case LEFT:
                y += distance;
                break;
        }
        System.out.println("coordinates after moving:\nx: " + x + ", y: " + y);
    }

    @Override
    public void turnLeft(){
        switch(dir) {
            case FORWARD:
                dir = Direction.LEFT;
                break;
            case BACKWARD:
                dir = Direction.RIGHT;
                break;
            case RIGHT:
                dir = Direction.FORWARD;
                break;
            case LEFT:
                dir = Direction.BACKWARD;
                break;
        }
    }

    @Override
    public void turnRight(){
        switch(dir) {
            case FORWARD:
                dir = Direction.RIGHT;
                break;
            case BACKWARD:
                dir = Direction.LEFT;
                break;
            case RIGHT:
                dir = Direction.BACKWARD;
                break;
            case LEFT:
                dir = Direction.FORWARD;
                break;
        }
    }
}
