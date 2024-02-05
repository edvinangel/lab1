import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class TestScania {

    @Test
    public void testPlatform(){
        Scania scania = new Scania(2, 500, Color.black, "Scania", 0, 7,0);
        scania.truckPlatform.raisePlatform();
        assertEquals(scania.truckPlatform.getPlatformAngle(), 5, 0.0001);
    }

    @Test
    public void testPlatformError(){
        Scania scania = new Scania(2, 500, Color.black, "Scania", 0, 7,0);
        scania.truckPlatform.raisePlatform();
    }

}


