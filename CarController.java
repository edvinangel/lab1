import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.VolatileImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;



public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();

    ArrayList<Workshop<Volvo240>> shops = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();


        cc.cars.add(new Volvo240(4, 200, Color.red, "Volvo240", 0, 0, 0));
        cc.cars.add(new Saab95(2, 300, Color.red, "Saab95", 0, 0, 100));
        cc.cars.add(new Scania(4, 200, Color.black, "Scania", 0, 0, 200));

        cc.shops.add(new Workshop<Volvo240>(10, "VolvoBrand", 0, 400));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);
        cc.frame.drawPanel.loadCarImages(cc.cars);
        cc.frame.drawPanel.loadWorkshopImages(cc.shops);


        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars){
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                if (!((x < -1 || x > 801 ) || (y < -1 || y > 541 ))){
                    frame.drawPanel.moveit(car);

                    shops.forEach((workshop) -> {
                        if (car.getX() == workshop.getX() && car.getY() == workshop.getY()){
                            try{
                                workshop.loadCar((Volvo240) car);
                                car.currentSpeed = 0;
                            }catch (Exception ex){
                                System.out.println("Bruh");
                            }
                        }
                    });
                }else{
                    car.turnLeft();
                    car.turnLeft();
                    frame.drawPanel.moveit(car);
                }
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

}
