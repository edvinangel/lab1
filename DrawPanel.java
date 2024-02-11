import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize

    HashMap<Car, BufferedImage> carImageMap = new HashMap<>();
    HashMap<Workshop, BufferedImage> workShopImageMap = new HashMap<>();

    // To keep track of a single car's position


    // TODO: Make this general for all cars


    void moveit(Car car) {
        car.move();
    }



    public void loadCarImages(ArrayList<Car> cars) {
        for (Car car : cars) {
            int x_cord = 0;
            try{
                BufferedImage image = ImageIO.read(getClass().getResourceAsStream("pics/" + car.getModelName() + ".jpg"));
                if (image != null){
                    carImageMap.put(car, image);
            }
    } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void loadWorkshopImages(ArrayList<Workshop<Volvo240>> shop) {
        for (Workshop workshop : shop) {
            try{
                BufferedImage image = ImageIO.read(getClass().getResourceAsStream("pics/" + workshop.getName() + ".jpg"));
                if (image != null){
                    workShopImageMap.put(workshop, image);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }




    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.yellow);
    }



    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        carImageMap.forEach((car, image) -> {
            g.drawImage(image, car.getX(), car.getY(), null);
        });

        workShopImageMap.forEach((workshop, image) -> {
            g.drawImage(image, workshop.getX(), workshop.getY(), null);
        });

    }
}
