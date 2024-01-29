import java.awt.*;
import java.math.BigDecimal;

public abstract class Car implements Moveable {
    private int nrDoors;
    public final double enginePower; //Change to public to access in Car models
    private Color color;
    private String modelName;
    public double currentSpeed; // Change to public to access in Car models
    private double x;
    private double y;
    private boolean turnLeft, turnRight; // private för att dölja för användning
    private int current_direction;

    public Car(int nrDoors, double enginePower, Color color, String modelName, double currentSpeed, double x, double y) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.currentSpeed = currentSpeed;
        this.x = x;
        this.y = y;
        this.current_direction = 90; // Set a default starting direction
    } // Måste skapa konstruktorn själv

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

    public abstract double speedFactor();

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }


    @Override
    public void turnLeft() {
        current_direction = (current_direction + 90) % 360;
    }

    @Override
    public void turnRight() {
        current_direction = (current_direction - 90 + 360) % 360;// Turn right by 90 degrees
    }

    public boolean getTurnLeft(){
        return turnLeft;
    }

    public boolean getTurnRight(){
        return turnRight;
    }

    @Override
    public void move(){
        double deltaX = Math.cos(Math.toRadians(current_direction)) * currentSpeed;
        double deltaY = Math.sin(Math.toRadians(current_direction)) * currentSpeed;

        BigDecimal roundedDeltaX = new BigDecimal(deltaX).setScale(7, BigDecimal.ROUND_HALF_UP);
        BigDecimal roundedDeltaY = new BigDecimal(deltaY).setScale(7, BigDecimal.ROUND_HALF_UP);

        x += roundedDeltaX.doubleValue();
        y += roundedDeltaY.doubleValue();
    }

    public void incrementSpeed(double amount) {
        if (getCurrentSpeed() >= enginePower) {
            currentSpeed = enginePower;
            System.out.println("The speed is maxed out");
        } else {
            currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
        }
    }

    // Handling decreasing speed
    public void decrementSpeed(double amount) {
        if (getCurrentSpeed() <= 0) {
            currentSpeed = 0;
            System.out.println("Car is already still");
        } else {
            currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
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

    public int getDirection(){
        return current_direction;
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
