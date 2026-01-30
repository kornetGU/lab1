import java.awt.*;

class Volvo240 extends Car {

    private final static double trimFactor = 1.25;    /** Factor used to adjust value of trim */

    /**
     * Constructor to initialize state of Volvo240.
     */
    public Volvo240(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
    }

    /**
     * Calculates the speedfactor based on trimfactor and enginepower.
     * @return The calculated speedfactor.
     */
    @Override
    double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

}
