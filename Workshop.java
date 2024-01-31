import java.awt.*;
import java.util.ArrayList;

public class Workshop<A extends Car> {

    private int maxLoad;
    private ArrayList<A> allowedTypes;
    private ArrayList<A> loadedCars;
    private double x;
    private double y;
    private String name;
    private int currentLoad;


    public Workshop(int maxLoad, int currentLoad,  String name, double x, double y) {
        this.maxLoad = maxLoad;
        this.currentLoad = currentLoad;
        this.name = name;
        this.x = x;
        this.y = y;

        this.loadedCars = new ArrayList<>();
        this.allowedTypes = new ArrayList<>();
    }

    public void addAllowedTypes(A carType) {
        allowedTypes.add(carType);
    }

    public void recieveCar(A car){
        if (currentLoad < maxLoad){
            if (this.allowedTypes.isEmpty()){
                loadedCars.add(car);
                currentLoad += 1;
                System.out.println("Car loaded");

            } else if (allowedTypes.contains(car.getModelName())) {
                    loadedCars.add(car);
                    currentLoad += 1;
            }else{
                System.out.println("Car type not allowed");
            }
        }
        else{
                System.out.println("Max capacity is reached");
            }

        }

    public Car pickUp(A car){
        if (loadedCars.contains(car)){
            loadedCars.remove(car);
            currentLoad -= 1;
            return car;
        }else{
            System.out.println("Car is not in workshop");
        }
        return null;
    }


    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }

    public String getName(){
        return this.name;
    }

}
