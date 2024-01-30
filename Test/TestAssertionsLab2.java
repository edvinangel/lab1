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
    public void testWidth(){
        CarTransport transport = new CarTransport(2, 500, Color.black, "Transport", 0, 15,0, 10);
        assertEquals(4, transport.getWidth(), 0.001);

    }

    @Test
    public void testLength(){
        CarTransport transport = new CarTransport(2, 500, Color.black, "Transport", 0, 15,0, 10);
        assertEquals(15, transport.getLength(), 0.001);

    }

    @Test
    public void testNumLoaded(){
        CarTransport transport = new CarTransport(2, 500, Color.black, "Transport", 0, 15,0, 10);
        Saab95 saab = new Saab95(2, 100, Color.black, "Saab95", 10, 15,0);
        transport.lowerPlatform();
        transport.loadCar(saab); // Should return that it is not closed enough


        assertEquals( 1 , transport.getNumLoaded(), 0.001);
        transport.unloadCar();
        assertEquals( 0 , transport.getNumLoaded(), 0.001);
    }


// Workshop tests
    @Test
    public void testWorkShopCapacity() {
        Workshop workshop = new Workshop(2, 0, "Workshop1", 5, 5);
        workshop.setAllowedTypes("Saab95");
        Saab95 saab = new Saab95(2, 100, Color.black, "Saab95", 10, 5, 5);
        Saab95 saab1 = new Saab95(2, 100, Color.black, "Saab95", 10, 5, 5);
        Saab95 saab2 = new Saab95(2, 100, Color.black, "Saab95", 10, 5, 5);

        workshop.recieveCar(saab);
        workshop.recieveCar(saab1);
        workshop.recieveCar(saab2); // capacity reached
    }


    @Test
    public void testWorkShopReturnCar() {
        Workshop workshop = new Workshop(10, 0, "Workshop1", 5, 5);
        workshop.setAllowedTypes("Saab95");
        Saab95 saab = new Saab95(2, 100, Color.black, "Saab95", 10, 5, 5);
        Saab95 saab1 = new Saab95(2, 100, Color.black, "Saab95", 10, 5, 5);
        Saab95 saab2 = new Saab95(2, 100, Color.black, "Saab95", 10, 5, 5);

        workshop.recieveCar(saab);
        workshop.recieveCar(saab1);
        workshop.recieveCar(saab2);

        assertEquals(saab1, workshop.pickUp(saab1));
    }

    @Test
    public void getWorkShopCoordinates() {

        Workshop workshop = new Workshop(10, 0, "Workshop1", 5, 5);
        assertEquals(5, workshop.getX(), 0.001);
        assertEquals(5, workshop.getY(), 0.001);
    }





        @Test
        public void testWorkShopNotAllowedCar() {
            Workshop workshop = new Workshop(2, 0, "Workshop1", 5, 5);
            workshop.setAllowedTypes("Saab95");
            Saab95 saab = new Saab95(2, 100, Color.black, "Saab95", 10, 5, 5);
            Volvo240 volvo = new Volvo240(2, 100, Color.black, "Volvo240", 3, 7,0);

            workshop.recieveCar(volvo);

    }


    @Test
    public void testGetName(){
        Workshop workshop = new Workshop(2, 0, "Workshop1", 5, 5);
        assertEquals("Workshop1", workshop.getName());

    }


    @Test
    public void testGetWidthScania(){
        Scania scania = new Scania(2, 500, Color.black, "Scania", 0, 7,0);
        assertEquals(3, scania.getWidth(), 0.0001);
    }

    @Test
    public void testGetLengthScania(){
        Scania scania = new Scania(2, 500, Color.black, "Scania", 0, 7,0);
        assertEquals(10, scania.getLength(), 0.0001);
    }






}

