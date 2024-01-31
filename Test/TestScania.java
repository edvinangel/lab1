import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class TestScania {

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


