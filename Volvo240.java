import java.awt.*;

public class Volvo240 extends Car{

    public final static double trimFactor = 1.25;

    public Volvo240(int nrDoors, double enginePower, Color color, String modelName, double currentSpeed, double x, double y) {
        super(nrDoors, enginePower, color, modelName, currentSpeed, x, y, current_direction);
    }

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    @Override
    public void incrementSpeed(double amount) {
        try{
            if (getCurrentSpeed() >= enginePower){
                throw new Exception();
            }
            else{
                currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
            }
        }catch (Exception e){
            currentSpeed = enginePower;
            System.out.println("The speed is maxxed out");
        }
    }
    // Handling deareasing speed
    @Override
    public void decrementSpeed(double amount) {
        try{
            if (getCurrentSpeed() <= 0){
                throw new Exception();
            }else{
                currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
            }

        }catch (Exception e){
            currentSpeed = 0;
            System.out.println("Car is already still");
        }
    }




}
