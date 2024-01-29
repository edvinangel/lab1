import java.awt.*;

public abstract class Truck extends Car{

    public static double platformAngle = 0;

    public Truck(int nrDoors, double enginePower, Color color, String modelName, double currentSpeed, double x, double y) {
        super(nrDoors, enginePower, color, modelName, currentSpeed, x, y);
    }

    abstract void raisePlatform();

    abstract void lowerPlatform();

    public double getPlatformAngle(){
        return platformAngle;
    }


    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }




}