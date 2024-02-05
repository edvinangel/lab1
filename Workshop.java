import java.util.ArrayList;

public class Workshop<A extends Car> implements Loadable<A> {

    private int maxLoad;
    public ArrayList<A> loadedCars;
    private double x;
    private double y;
    private String name; // ta bort
    private int currentLoad;


    public Workshop(int maxLoad, int currentLoad,  String name, double x, double y) {
        this.maxLoad = maxLoad;
        this.currentLoad = currentLoad;
        this.name = name;
        this.x = x;
        this.y = y;

        this.loadedCars = new ArrayList<A>();
    }


    @Override
    public void loadCar(A car){
        if (currentLoad < maxLoad){
                this.loadedCars.add(car);
                currentLoad += 1;
                System.out.println("Car loaded");

            }else{
                System.out.println("Max capacity is reached");
            }
        }


        @Override
    public A unloadCar(A car){
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
