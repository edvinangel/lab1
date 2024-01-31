import java.awt.*;

public class Scania extends Truck{

    private static double width = 3;
    private static double length = 10;

    public Scania(int nrDoors, double enginePower, Color color, String modelName, double currentSpeed, double x, double y) {
        super(nrDoors, enginePower, color, modelName, currentSpeed, x, y);

    }


    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }


}