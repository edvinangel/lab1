import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;

public class CarTransport extends Truck {



    public Platform platform;

    public Loadable load;

    public CarTransport(int nrDoors, double enginePower, Color color, String modelName, double currentSpeed, double x, double y, int maxCapacity) {
        super(nrDoors, enginePower, color, modelName, currentSpeed, x, y);

        this.load = new Loadable(maxCapacity, x, y);
        this.platform = new Platform(false, this);
    }


    @Override
    public void move(){
        if (this.platform.loadable) {
            double new_x = this.getX() + this.getXDirection() * currentSpeed;
            double new_y = this.getY() + this.getYDirection() * currentSpeed;

            this.setX(new_x);
            this.setY(new_y);

            this.load.moveCars();

        }else{
        System.out.println("Can not move when platform is lowered");
        }

    }

    public void loadCar(Car car) {
        if (platform.loadable) {
            if (!(car.getSize() == Size.MEDIUM || car.getSize() == Size.SMALL)) {
                this.load.loadCar(car);
            } else {
                System.out.println("Car is too big to be loaded");
            }
        } else {
            System.out.println("Platform is not in the right position");
        }
    }

    public void unloadCar(){
        if (this.getCurrentSpeed() == 0){
            this.load.unLoadCar();
        }else{
            System.out.println("You need to be still to unload car");
        }
    }

    public void lowerPlatform(){
        this.platform.lowerPlatform();
    }

    public void raisePlatform(){
        this.platform.raisePlatform();
    }



}
