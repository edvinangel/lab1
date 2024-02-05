import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;

public class CarTransport extends Truck implements Loadable2<Car>{

    // har två plattformar
    public Platform platform;

    private ArrayList<Car> carsLoaded; // private
    private int maxCapacity;


    public CarTransport(int nrDoors, double enginePower, Color color, String modelName, double currentSpeed, double x, double y, int maxCapacity) {
        super(nrDoors, enginePower, color, modelName, currentSpeed, x, y);
        this.maxCapacity = maxCapacity;

        this.platform = new Platform(false);
        this.carsLoaded = new ArrayList<Car>();
        this.numLoaded = 0;

    }


    @Override
    public void move(){
        if (this.platform.loadable) {
            double new_x = this.getX() + this.getXDirection() * currentSpeed;
            double new_y = this.getY() + this.getYDirection() * currentSpeed;

            this.setX(new_x);
            this.setY(new_y);

            this.moveCars();

        }else{
        System.out.println("Can not move when platform is lowered");
        }

    }

    public ArrayList<Car> getCarsLoaded() {
        return carsLoaded;
    }


    @Override
    public void loadCar(Car car) {
        if (platform.loadable) {
            if ((car.getSize() == Size.MEDIUM || car.getSize() == Size.SMALL)) {
                if (maxCapacity > (carsLoaded.size() + 1)){
                    if (Math.abs(car.getX() - this.getX()) < 5  && Math.abs(car.getY() - this.getY()) < 5){

                        carsLoaded.add(car);
                        System.out.println("Car loaded");
                    }else{
                        System.out.println("Car is not close enough");
                    }
                }else{
                    System.out.println("Max Capacity Reached");
                }
            } else {
                System.out.println("Car is too big to be loaded");
            }
        } else {
            System.out.println("Platform is not in the right position");
        }
    }

    @Override
    public Car unloadCar(Car car){
        if (this.getCurrentSpeed() == 0){
            if (!carsLoaded.isEmpty()){
                Car unloaded_car = carsLoaded.removeLast();
                unloaded_car.setX(this.getX()+1);
                unloaded_car.setY(this.getY()+1);
                numLoaded -= 1;
                return unloaded_car;
            }
        }else{
            System.out.println("You need to be still to unload car");
            return null;
        }
        return null;
    }




    public void moveCars(){ // Testa noga
        for (Car car : carsLoaded) {
            car.setX(this.getX());
            car.setY(this.getY());
        }
    }


    public void lowerPlatform(){
        if (currentSpeed != 0){
            System.out.println("Car cannot move when lowering platform");
        }else{
            platform.lowerPlatform();}
    }

    public void raisePlatform(){
        if (currentSpeed != 0){
            System.out.println("Car cannot move when raising platform");
        }else{
            platform.raisePlatform();}
    }
}


