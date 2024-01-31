import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;

public class CarTransport extends Truck {

    private static final double width = 4;

    private static final double length = 15;

    private int maxCapacity;

    private boolean platformPosition;

    private int numLoaded;

    private ArrayList<Car> carsLoaded;

    private Platform platform;


    public CarTransport(int nrDoors, double enginePower, Color color, String modelName, double currentSpeed, double x, double y, int maxCapacity) {
        super(nrDoors, enginePower, color, modelName, currentSpeed, x, y);
        this.maxCapacity = maxCapacity;
        this.platformPosition = false;
        this.numLoaded = 0;
        this.carsLoaded = new ArrayList<>();

        this.platform = new Platform(false, this);
    }


    @Override
    public void move(){
        if (this.platform.loadable == true) {
            double new_x = this.getX() + this.getXDirection() * currentSpeed;
            double new_y = this.getY() + this.getYDirection() * currentSpeed;

            this.setX(new_x);
            this.setY(new_y);


            for (Car car : carsLoaded) {
                car.setX(new_x);
                car.setY(new_y);
            }
        }else{
        System.out.println("Can not move when platform is lowered");
        }

    }

    public void loadCar(Car cars){
        if (maxCapacity > numLoaded && platformPosition){
            if (cars.getWidth() < 2.5 && cars.getLength() < 6){
                if (Math.abs(cars.getX() - this.getX()) < 5  && Math.abs(cars.getY() - this.getY()) < 5){
                    numLoaded += 1;
                    carsLoaded.add(cars);
                    System.out.println("Car loaded");
                }else{
                    System.out.println("Car is not close enough");
                }
            }else{
                System.out.println("Car size is too big");
            }
        }else{
            System.out.println("Max Capacity Reached");
        }
    }

    public void unloadCar(){
        if (!carsLoaded.isEmpty()){
            Car car = carsLoaded.removeLast();
            numLoaded -= 1;
            car.setX(this.getX() + 1);
            car.setY(this.getY() + 1);
        }else{
            System.out.println("You have unloaded all cars");
        }
    }

    public ArrayList<Car> getCarsLoaded(){
        return this.carsLoaded;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getLength() {
        return length;
    }


    public int getNumLoaded(){
        return this.numLoaded;
    }

}
