import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestAssertions{

    @Test
    public void asset_car_equal_doors(){
        Car car1 = new Car(2, 100, Color.black, "Zebra", 3, 7,0, false, false);
        assertEquals(2, car1.getNrDoors());
    }

    @Test
    public void assert_volvo_equal_doors(){
        Car Volvo = new Volvo240(4, 100, Color.red, "Volvo240", 0, 1,2,false,false);
        assertEquals(4, Volvo.getNrDoors());
    }

    @Test
    public void assert_saab_equal_doors(){
        Car saab = new Saab95(2, 100, Color.red, "Saab95", 0, 1,2,false,false);
        assertEquals(2, saab.getNrDoors());
    }

    @Test
    public void testTurboOnAndOff() {
        Saab95 saab = new Saab95(4, 200, Color.blue, "Saab95", 0, 0, 0, false, false);

        // No turbo should give a speedFactor of 2.0
        assertEquals(2.0, saab.speedFactor(), 0.001);

        // Turn on the turbo, should give a higher speed factor
        saab.setTurboOn();
        assertEquals(2.6, saab.speedFactor(), 0.001);

        // Turn off the turbo
        saab.setTurboOff();
        assertEquals(2.0, saab.speedFactor(), 0.001);
    }

    @Test
    public void testChangeColor() {
        Saab95 saab = new Saab95(4, 200, Color.blue, "Saab95", 0, 0, 0, false, false);

        // Color bljue
        assertEquals(Color.blue, saab.getColor());
        // Color now black
        saab.setColor(Color.black);
        assertEquals(Color.black, saab.getColor());
    }



    @Test
    public void testCurrentSpeed() {
        Saab95 saab = new Saab95(4, 200, Color.blue, "Saab95", 0, 0, 0, false, false);
        saab.startEngine();
        double expectedSpeed = 0.1;
        assertEquals(expectedSpeed, saab.getCurrentSpeed(), 0.1);
    }


    @Test
    public void test_change_in_pos(){
        Car car = new Car(4, 200, Color.blue, "Car", 10, 0, 0, false, false);
        car.move();
        System.out.println("Initial Speed: " + car.getCurrentSpeed());
        List<Double> coordinateList = new ArrayList<>();
        coordinateList.add(10.0);
        coordinateList.add(0.0);
        List<Double> CarCords = new ArrayList<>();
        CarCords.add(car.getY());
        CarCords.add(car.getX());

        assertEquals(coordinateList, CarCords );

    }

    @Test
    public void test_change_in_pos_saab(){
        Saab95 saab95 = new Saab95(4, 200, Color.blue, "Saab95", 10, 0, 0, false, false);
        saab95.move();
        System.out.println("Initial Speed: " + saab95.getCurrentSpeed());
        List<Double> coordinateList = new ArrayList<>();
        coordinateList.add(10.0);
        coordinateList.add(0.0);
        List<Double> SaabCords = new ArrayList<>();
        SaabCords.add(saab95.getY());
        SaabCords.add(saab95.getX());

        assertEquals(coordinateList, SaabCords );
    }

    @Test
    public void test_gas_works(){
        Volvo240 volvo = new Volvo240(4, 100, Color.red, "Volvo240", 0, 0,0,false,false);
        volvo.gas(0.5);
        assertEquals(0.5, volvo.getCurrentSpeed(), 0.2); // Litte over due to trimfactor
    }

    @Test
    public void test_brake_works(){
        Volvo240 volvo = new Volvo240(4, 100, Color.red, "Volvo240", 5, 0,0,false,false);
        volvo.brake(0.5);
        assertEquals(4.5, volvo.getCurrentSpeed(), 0.2); // Litte over due to trimfactor
    }

    @Test
    public void test_gas_works_normal_car(){
        Car car = new Car(4, 100, Color.red, "Volvo240", 0, 0,0,false,false);
        car.startEngine();
        car.gas(0.5);
        assertEquals(0.6, car.getCurrentSpeed(), 0.001); // 0.6 since starting the car makes speed 0.1
    }

    @Test
    public void test_coordinates_car(){
        Car car = new Car(4, 100, Color.red, "Volvo240", 0, 10,20,false,false);
        List<Double> coordinateList = new ArrayList<>();
        coordinateList.add(car.getX());
        coordinateList.add(car.getY());
        List<Double> TestCords = new ArrayList<>();
        TestCords.add(10.0);
        TestCords.add(20.0);
        assertEquals(TestCords, coordinateList);

    }

    @Test
    public void car_should_not_gas_over_1(){
        Car car = new Car(4, 100, Color.red, "Volvo240", 10, 10,20,false,false);
        car.gas(2);
        assertEquals(10, car.getCurrentSpeed(), 0.0001);
        // Should print "Car cannot gas that much"
    }

    @Test
    public void car_should_not_brake_over_1(){
        Car car = new Car(4, 100, Color.red, "Volvo240", 10, 10,20,false,false);
        car.brake(2);
        assertEquals(10, car.getCurrentSpeed(), 0.0001);
        // Should print "Car cannot brake that much"
    }

    @Test
    public void car_speed_should_not_exceed_enginePower(){
        Car car = new Car(4, 100, Color.red, "Volvo240", 99.5, 10,20,false,false);
        car.gas(0.9);
        assertEquals(100, car.getCurrentSpeed(), 0.0001); // Caps out at 100 because of "min" statement
    }

    @Test
    public void TestLeft(){
        Car car = new Car(4, 100, Color.red, "Volvo240", 0, 10,20,false,false);
        car.turnLeft();
        boolean left = true;
        assertEquals(left, car.getTurnLeft()); // Caps out at 100 because of "min" statement
    }
    @Test
    public void TestRight(){
        Car car = new Car(4, 100, Color.red, "Volvo240", 0, 10,20,false,false);
        car.turnRight();
        boolean right = true;
        assertEquals(right, car.getTurnRight()); // Caps out at 100 because of "min" statement
    }


}