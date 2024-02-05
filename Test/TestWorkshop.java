import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class TestWorkshop {

    @Test
    public void testWorkShopCapacity() {
        Workshop<Saab95> workshop = new Workshop<>(2, 0, "Workshop1", 5, 5);
        workshop.addAllowedTypes(Volvo240);
        Saab95 saab = new Saab95(2, 100, Color.black, "Saab95", 10, 5, 5);
        Volvo240 volvo = new Volvo240(2, 100, Color.black, "Saab95", 10, 5, 5);

        Saab95 saab1 = new Saab95(2, 100, Color.black, "Saab95", 10, 5, 5);
        Saab95 saab2 = new Saab95(2, 100, Color.black, "Saab95", 10, 5, 5);

        workshop.recieveCar(saab);
        workshop.recieveCar(volvo);
        workshop.recieveCar(saab1);
        workshop.recieveCar(saab2); // capacity reached
    }

    @Test
    public void testWorkShopReturnCar() {
        Workshop workshop = new Workshop(10, 0, "Workshop1", 5, 5);
        workshop.addAllowedTypes("Saab95");
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
    public void testWorkshopType(){

        Workshop<Saab95> workshop = new Workshop<>(2, 0, "Workshop1", 5, 5);
        Saab95 saab = new Saab95(2, 100, Color.black, "Saab95", 10, 5, 5);
        Volvo240 volvo = new Volvo240(2, 100, Color.black, "Volvo240", 3, 7,0);

        workshop.recieveCar(saab);
        workshop.recieveCar(volvo);

    }
}
