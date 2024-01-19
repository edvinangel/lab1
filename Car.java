import java.awt.*;

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

    public Car(int nrDoors, double enginePower, Color color, String modelName, double currentSpeed, double x, double y, int current_direction){
        this.nrDoors= nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.currentSpeed= currentSpeed;
        this.x = x;
        this.y = y;
        this.current_direction = 90;
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
        if (current_direction == 360 ||current_direction ==  -360){
            current_direction = 0;
        }else{
            current_direction += 90; // Turn left by 90 degrees

        }
    }

    @Override
    public void turnRight() {
        if (current_direction == (360) ||current_direction ==  -360){
            current_direction = 0;
        }else{
            current_direction -= 90; // Turn right by 90 degrees

        }
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

        x += deltaX;
        y += deltaY;
    }

    public abstract void incrementSpeed(double amount);

    public abstract void decrementSpeed(double amount);


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
