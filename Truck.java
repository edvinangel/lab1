import java.awt.*;

public abstract class Truck extends Car{


    public final static Size size = Size.LARGE;


    public Truck(int nrDoors, double enginePower, Color color, String modelName, double currentSpeed, int x, int y) {
        super(nrDoors, enginePower, color, modelName, currentSpeed, x, y);

    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }


    @Override
    public Size getSize() {
        return size;
    }

    public abstract void lowerPlatform();
    public abstract void raisePlatform();



}
