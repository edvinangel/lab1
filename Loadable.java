import java.util.ArrayList;

public class Loadable {
    private int maxLoad;
    private double x;
    private double y;
    private ArrayList<Car> carsLoaded;
    private int numLoaded;


    public Loadable(int maxLoad, double x, double y){
        this.x = x;
        this.y = y;
        this.maxLoad = maxLoad;

        this.carsLoaded = new ArrayList<Car>();
        this.numLoaded = 0;
    }

    public void setX(double new_x){
        x = new_x;
    }

    public void setY(double new_y){
        y = new_y;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public ArrayList<Car> getCarsLoaded() {
        return carsLoaded;
    }


    public void loadCar(Car car){
        if (maxLoad > (carsLoaded.size() + 1)){
                if (Math.abs(car.getX() - this.getX()) < 5  && Math.abs(car.getY() - this.getY()) < 5){
                    numLoaded += 1;
                    carsLoaded.add(car);
                    System.out.println("Car loaded");
                }else{
                    System.out.println("Car is not close enough");
                }
            }else{
            System.out.println("Max Capacity Reached");
        }

    }

    public void unLoadCar(){
        if (!carsLoaded.isEmpty()){
            Car unloaded_car = carsLoaded.removeLast();
            unloaded_car.setX(x+1);
            unloaded_car.setY(y+1);
            numLoaded -= 1;
        }
    }


    public void moveCars(){
        for (Car car : carsLoaded) {
            car.setX(x);
            car.setY(y);
        }
    }

    public int getNumLoaded(){
        return this.numLoaded;
    }

}
