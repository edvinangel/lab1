import java.awt.*;

public class Scania extends Truck{

    public TruckPlatform truckPlatform;


    public Scania(int nrDoors, double enginePower, Color color, String modelName, double currentSpeed, double x, double y) {
        super(nrDoors, enginePower, color, modelName, currentSpeed, x, y);
        this.truckPlatform = new TruckPlatform(false, 0, 70);

    }
    @Override
    public void move(){
        if (this.truckPlatform.getPlatformAngle() != 0){
            System.out.println("Can only move when platform angle is zero");
        }else{
            super.move();

        }
    }




