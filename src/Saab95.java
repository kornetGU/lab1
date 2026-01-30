import java.awt.*;

class Saab95 extends Car  {

    private boolean turboOn;    /** Indicates whether turbo is active */

    /**
     * Constructor to initialize the state of the Saab95.
     */
    public Saab95(){
        super(2,125,Color.red,"Saab95");
        turboOn = false;
        stopEngine();
    }

    /**
     * Sets turboOn to 'true'.
     */
    private void setTurboOn(){
	    turboOn = true;
    }

    /**
     * Sets turboOn to 'false'.
     */
    private void setTurboOff(){
	    turboOn = false;
    }

    /**
     * Calculates the speedfactor based on turbo and enginepower.
     * @return The calculated speedfactor.
     */
    @Override
    double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
}
