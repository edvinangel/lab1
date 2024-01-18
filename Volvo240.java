import java.awt.*;

public class Volvo240 extends Car{

    public final static double trimFactor = 1.25;

    public Volvo240(int nrDoors, double enginePower, Color color, String modelName, double currentSpeed, double x, double y, boolean turnLeft, boolean turnRight) {
        super(nrDoors, enginePower, color, modelName, currentSpeed, x, y, turnLeft, turnRight);
    }

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

}
