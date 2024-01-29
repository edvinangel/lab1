import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn;

    public Saab95(int nrDoors, double enginePower, Color color, String modelName, double currentSpeed, double x, double y) {
        super(nrDoors, enginePower, color, modelName, currentSpeed, x, y);
        turboOn = false;
    }

    public void setTurboOn(){
        this.turboOn = true;
    }

    public void setTurboOff(){
        this.turboOn = false;
    }

    @Override
    public double speedFactor() {
        double turbo = turboOn ? 1.3 : 1;
        return getEnginePower() * 0.01 * turbo;
    }

}
