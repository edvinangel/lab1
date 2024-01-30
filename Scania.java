import java.awt.*;

public class Scania extends Truck{

    private static double width = 3;
    private static double length = 10;

    private static double maxAngle = 70;

    public Scania(int nrDoors, double enginePower, Color color, String modelName, double currentSpeed, double x, double y) {
        super(nrDoors, enginePower, color, modelName, currentSpeed, x, y);
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getLength() {
        return length;
    }

    public void raisePlatform(){
        if (currentSpeed == 0){
            platformAngle = Math.min(platformAngle += 5, maxAngle);
        }else{
            System.out.println("Cant raise platform when currentSpeed > 0");
        }
    }

    public void lowerPlatform(){
        if (currentSpeed == 0){
            platformAngle = Math.max(platformAngle -=5, 0);
        }else{
            System.out.println("Cant lower platform when currentSpeed > 0");
        }
    }




}