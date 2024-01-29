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


}