import java.awt.*;

public class Truck extends Car{
    public final static Size size = Size.LARGE;

    public TruckPlatform truckPlatform;

    public Truck(int nrDoors, double enginePower, Color color, String modelName, double currentSpeed, double x, double y) {
        super(nrDoors, enginePower, color, modelName, currentSpeed, x, y);

        this.truckPlatform = new TruckPlatform(false, 0, 70, this);
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    @Override
    public void move(){
        if (truckPlatform.getPlatformAngle() != 0){
            System.out.println("Can only move when platform angle is zero");
        }else{
            double new_x = this.getX() + this.getXDirection() * currentSpeed;
            double new_y = this.getY() + this.getYDirection() * currentSpeed;

            this.setX(new_x);
            this.setY(new_y);
        }


    }

    @Override
    protected Size getSize() {
        return size;
    }
    
}