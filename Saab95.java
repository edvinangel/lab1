import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.FixedWidth;

import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn;
    private static final double width = 1.5;

    private static final double length = 5;

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

    public double getWidth(){
        return width;
    }

    public double getLength(){
        return length;
    }


    @Override
    public double speedFactor() {
        double turbo = turboOn ? 1.3 : 1;
        return getEnginePower() * 0.01 * turbo;
    }

}
