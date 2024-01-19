import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn;

    public Saab95(int nrDoors, double enginePower, Color color, String modelName, double currentSpeed, double x, double y, int current_direction) {
        super(nrDoors, enginePower, color, modelName, currentSpeed, x, y, current_direction);
        turboOn = false;
    }

    public void setTurboOn(){
        this.turboOn = true;
    }

    public void setTurboOff(){
        this.turboOn = false;
    }

    @Override
    public double speedFactor() {
        double turbo = turboOn ? 1.3 : 1;
        return getEnginePower() * 0.01 * turbo;
    }

    @Override
    public void incrementSpeed(double amount) {
        try{
            if (getCurrentSpeed() >= enginePower){
                throw new Exception();
            }
            else{
                currentSpeed = getCurrentSpeed() + speedFactor() * amount;
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
                currentSpeed = getCurrentSpeed() - speedFactor() * amount;
            }

        }catch (Exception e){
            currentSpeed = 0;
            System.out.println("Car is already still");
        }
    }

}
