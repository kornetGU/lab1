import java.awt.*;

public abstract class Car implements Movable {
    int nrDoors;    /** Number of doors on the car */
    double enginePower;    /** Engine power of the car */
    double currentSpeed;    /** The current speed of the car */
    Color color;    /** Color of the car */
    String modelName;     /** The car model name */

    double x = 0.0;    /** Represents the cars current position on the x-axis. */
    double y = 0.0;    /** Represents the cars current position on the y-axis. */
    Direction dir = Direction.FORWARD;    /** Represents the cars current direction. */

    /**
     * Getter method for the nrDoors field.
     * @return the int nrDoors field.
     */
    int getNrDoors(){
        return nrDoors;
    }

    /**
     * Getter method for the enginePower field.
     * @return the double enginePower field.
     */
    double getEnginePower(){
        return enginePower;
    }

    /**
     * Getter method for the currentSpeed field.
     * @return the double currentSpeed field.
     */
    double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * Getter method for the color field.
     * @return the color field of type Color.
     */
    Color getColor(){
        return color;
    }

    /**
     * Setter method for the color field.
     * @param clr a color of type Color.
     */
    void setColor(Color clr){
        color = clr;
    }

    /**
     * Starts the engine and sets it currentSpeed to 0.1.
     */
    void startEngine(){
        currentSpeed = 10;
    }

    /**
     * Stops the engine by setting currentSpeed to 0.
     */
    void stopEngine(){
        currentSpeed = 0;
    }

    abstract double speedFactor();

    /**
     * Moves the car a distance based on its current position, direction and speed.
     * It's current position is represented by x and y on a coordinate system.
     * Prints the position of the car after moving.
     */
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

    /**
     * Sets the current direction after turning left once.
     */
    @Override
    public void turnLeft() {
        switch (dir) {
            case FORWARD -> dir = Direction.LEFT;
            case BACKWARD -> dir = Direction.RIGHT;
            case LEFT -> dir = Direction.BACKWARD;
            case RIGHT -> dir = Direction.FORWARD;
        }
    }

    /**
     * Sets the current direction after turning right once.
     */
    @Override
    public void turnRight() {
        switch (dir) {
            case FORWARD -> dir = Direction.RIGHT;
            case BACKWARD -> dir = Direction.LEFT;
            case LEFT -> dir = Direction.FORWARD;
            case RIGHT -> dir = Direction.BACKWARD;
        }
    }

    /**
     * gas - Increases the cars speed by a given value
     * @param amount - value to gas (Increase the speed) by
     * @throws IllegalArgumentException if amount is > 1 or < 0.
     */
    void gas(double amount) {
        interval(amount);
        currentSpeed = Math.max(0, Math.min(currentSpeed + speedFactor() * amount,enginePower));
        //speedRange(newSpeed);

    }

    /**
     * Brakes the cars speed by a given value
     * @param amount Value to brake (Decrement the speed) by
     * @throws IllegalArgumentException if amount is > 1 or < 0.
     */
    void brake(double amount){
        interval(amount);
        currentSpeed = Math.max(currentSpeed - speedFactor() * amount,0);
       // speedRange(newSpeed);
    }

    /**
     * Checks whether a double is in the interval 0 to 1.
     * @param amount Double to compare with interval
     * @throws IllegalArgumentException if amount is > 1 or < 0.
     */
    public void interval (double amount) {
        if(amount < 0 || amount > 1) {
            throw new IllegalArgumentException("Given amount must be between 0 and 1.");
        }
    }
}
