import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestCarTransport {

    @Test
    public void testLoadCars(){

        CarTransport transport = new CarTransport(2, 500, Color.black, "Transport", 0, 7,0, 10);
        Saab95 saab = new Saab95(2, 100, Color.black, "Saab95", 10, 7,0);
        transport.lowerPlatform();
        List<Car> carList = new ArrayList<>();
        carList.add(saab);
        transport.loadCar(saab);
        assertEquals(carList, transport.load.getCarsLoaded());
    }

    @Test
    public void testUnloadCars(){

        CarTransport transport = new CarTransport(2, 500, Color.black, "Transport", 0, 7,0, 10);
        Saab95 saab = new Saab95(2, 100, Color.black, "Saab95", 10, 7,0);
        transport.lowerPlatform();
        List<Car> carList = new ArrayList<>();
        carList.add(saab);
        transport.loadCar(saab);
        assertEquals(carList, transport.load.getCarsLoaded());

        carList.removeLast(); // Töm båda listorna
        transport.unloadCar();
        assertEquals(carList,transport.load.getCarsLoaded());
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

    @Test
    public void testCapacity(){
        CarTransport transport = new CarTransport(2, 500, Color.black, "Transport", 0, 7,0, 1);
        Saab95 saab = new Saab95(2, 100, Color.black, "Saab95", 10, 7,0);
        Saab95 saab1 = new Saab95(2, 100, Color.black, "Saab95", 10, 7,0);
        transport.lowerPlatform();
        transport.loadCar(saab); // Should return car loaded
        transport.loadCar(saab1); // Should return max capacity reached
    }

    @Test
    public void testSizeToBig(){
        CarTransport transport = new CarTransport(2, 500, Color.black, "Transport", 0, 7,0, 1);
        Scania scania= new Scania(2, 100, Color.black, "Scania", 10, 7,0);
        transport.lowerPlatform();
        transport.loadCar(scania); // Should say that size is too big
    }

    @Test
    public void testNotCloseEnough(){
        CarTransport transport = new CarTransport(2, 500, Color.black, "Transport", 0, 15,0, 10);
        Saab95 saab = new Saab95(2, 100, Color.black, "Saab95", 10, 7,0);
        transport.lowerPlatform();
        transport.loadCar(saab); // Should return that it is not closed enough
    }



    @Test
    public void testNumLoaded(){
        CarTransport transport = new CarTransport(2, 500, Color.black, "Transport", 0, 15,0, 10);
        Saab95 saab = new Saab95(2, 100, Color.black, "Saab95", 10, 15,0);
        transport.lowerPlatform();
        transport.loadCar(saab);


        assertEquals( 1 , transport.load.getNumLoaded(), 0.001);
        transport.unloadCar();
        assertEquals( 0 , transport.load.getNumLoaded(), 0.001);
    }

}
