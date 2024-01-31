import java.awt.*;

public class Volvo240 extends Car{


    public final static double trimFactor = 1.25;
    private static final double width = 1.8;

    private static final double length = 4.8;

    public Volvo240(int nrDoors, double enginePower, Color color, String modelName, double currentSpeed, double x, double y) {
        super(nrDoors, enginePower, color, modelName, currentSpeed, x, y);
    }

    public double getWidth(){
        return width;
    }

    public double getLength(){
        return length;
    }

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}