import java.awt.*;

public class Car implements Moveable {
    private final int nrDoors;
    private final double enginePower;
    private Color color;
    private String modelName;
    private double currentSpeed;
    private double x;
    private double y;
    private boolean turnLeft, turnRight;

    public Car(int nrDoors, double enginePower, Color color, String modelName, double currentSpeed, double x, double y, boolean turnLeft, boolean turnRight){
        this.nrDoors= nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.currentSpeed= currentSpeed;
        this.x = x;
        this.y = y;
        this.turnLeft = turnLeft;
        this.turnRight = turnRight;
    }

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }
    public double speedFactor() {
        return 1; //  overridden in the subclasses
    }


    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }


    @Override
    public void turnLeft(){
        turnLeft = true;
        turnRight = false;
    }

    @Override
    public void turnRight(){
        turnRight = true;
        turnLeft = false;
    }

    public boolean getTurnLeft(){
        return turnLeft;
    }

    public boolean getTurnRight(){
        return turnRight;
    }
    @Override
    public void move(){
        if (turnRight){
            x += currentSpeed;
            y += currentSpeed;
        }
        else if (turnLeft){
            x -= currentSpeed;
            y += currentSpeed;
        }
        else{
            y += currentSpeed;
        }
    }

    //Handling incraesing speed and error messages
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


    public void brake(double amount){
        try{
        if (amount <= 0 || amount > 1) {
            throw new Exception();
        } else {
            decrementSpeed(amount);
        }
        }catch(Exception e){
            System.out.println("Car cannot brake that much");
        }
    }

    public void gas(double amount){
        try{
            if (amount <= 0 || amount > 1) {
                throw new Exception();
            } else {
                incrementSpeed(amount);
            }
        }catch (Exception e){
            System.out.println("Car cannot gas that much");
        }

    }





}
