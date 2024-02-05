import java.awt.*;

public class Truck extends Car{


    public final static Size size = Size.LARGE;


    public Truck(int nrDoors, double enginePower, Color color, String modelName, double currentSpeed, double x, double y) {
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

    public void lowerPlatform(){
        if (currentSpeed != 0){
            System.out.println("Car cannot move when lowering platform");
        }else{
            this.truckPlatform.lowerPlatform();}
    }

    public void raisePlatform(){
        if (currentSpeed != 0){
            System.out.println("Car cannot move when raising platform");
        }else{
            truckPlatform.raisePlatform();}
    }
}
