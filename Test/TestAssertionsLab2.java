import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestAssertionsLab2 {

    @Test
    public void testPlatform(){
        Scania scania = new Scania(2, 500, Color.black, "Scania", 0, 7,0);
        scania.raisePlatform();
        assertEquals(scania.getPlatformAngle(), 5, 0.0001);
    }


    @Test
    public void testPlatformError(){
        Scania scania = new Scania(2, 500, Color.black, "Scania", 10, 7,0);
        scania.raisePlatform();
    }


    @Test
    public void testLoadCars(){

        CarTransport transport = new CarTransport(2, 500, Color.black, "Transport", 0, 7,0, 10);
        Saab95 saab = new Saab95(2, 100, Color.black, "Saab95", 10, 7,0);
        transport.lowerPlatform();
        List<Car> carList = new ArrayList<>();
        carList.add(saab);
        transport.loadCar(saab);
        assertEquals(carList, transport.getCarsLoaded());

    }


    @Test
    public void testUnloadCars(){

        CarTransport transport = new CarTransport(2, 500, Color.black, "Transport", 0, 7,0, 10);
        Saab95 saab = new Saab95(2, 100, Color.black, "Saab95", 10, 7,0);
        transport.lowerPlatform();
        List<Car> carList = new ArrayList<>();
        carList.add(saab);
        transport.loadCar(saab);
        assertEquals(carList, transport.getCarsLoaded());


        carList.removeLast(); // Töm båda listorna
        transport.unloadCar();
        assertEquals(carList,transport.getCarsLoaded());

    }

    @Test
    public void testMovement(){

        CarTransport transport = new CarTransport(2, 500, Color.black, "Transport", 0, 7,0, 10);
        Saab95 saab = new Saab95(2, 100, Color.black, "Saab95", 10, 7,0);
        transport.lowerPlatform();
        transport.loadCar(saab);

        transport.startEngine();
        transport.gas(0.5);
        transport.turnRight();

        assertEquals(saab.getX(),transport.getX(), 0.001);
        assertEquals(saab.getY(), transport.getY(), 0.001);

    }








}