import java.awt.*;

public class Scania extends Truck {

    private final double platformRaiseAngle = 5;
    private double platformAngle;

    public Scania(int nrDoors, double enginePower, Color color, String modelName, double currentSpeed, double x, double y) {
        super(nrDoors, enginePower, color, modelName, currentSpeed, x, y);
        this.platformAngle = 0;

    }

    public double getPlatformAngle(){
        return this.platformAngle;
    }



    @Override
    public void move() {
        if (this.getPlatformAngle() != 0) {
            System.out.println("Can only move when platform angle is zero");
        } else {
            super.move();

        }}

        public void lowerPlatform(){
            if (currentSpeed != 0) {
                System.out.println("Car cannot move when lowering platform");
            } else {
                platformAngle = Math.max(this.platformAngle -= 5, 0);
            }
        }

        public void raisePlatform(){
            if (currentSpeed != 0) {
                System.out.println("Car cannot move when raising platform");
            } else {
                platformAngle = Math.min(this.platformAngle += 5, 70);
            }
        }
    }





