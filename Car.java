import java.awt.*;

public class Car {
    int nrDoors; // Number of doors on the car
    double enginePower; // Engine power of the car
    double currentSpeed; // The current speed of the car
    Color color; // Color of the car
    String modelName; // The car model name

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


}
