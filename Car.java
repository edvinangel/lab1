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
    private int x_direction, y_direction; // private för att dölja för användning



    public Car(int nrDoors, double enginePower, Color color, String modelName, double currentSpeed, double x, double y) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.currentSpeed = currentSpeed;
        this.x = x;
        this.y = y;
        this.x_direction = 0;
        this.y_direction = 1;
        // Set a default starting direction
    } // Måste skapa konstruktorn själv

    protected int getNrDoors(){
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

    protected abstract double speedFactor();


    public String getModelName(){
        return this.modelName;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }


    public void setX(double new_x){
        x = new_x;
    }

    public void setY(double new_y){
        y = new_y;
    }


    public double getXDirection(){
        return x_direction;
    }

    public double getYDirection(){
        return y_direction;
    }

    @Override
    public void turnLeft() {
        if (x_direction == 0 && y_direction == -1 ){
            x_direction = 1;
            y_direction = 0;
        } else if (x_direction == -1 && y_direction == 0) {
            x_direction = 0;
            y_direction = -1;
        } else if (x_direction == 0 && y_direction == 1) {
            x_direction = -1;
            y_direction = 0;
        } else if (x_direction == 1 && y_direction == 0) {
            x_direction = 0;
            y_direction = 1;

        }


    }

    @Override
    public void turnRight() {
        if (x_direction == 0 && y_direction == -1 ){
            x_direction = -1;
            y_direction = 0;
        } else if (x_direction == -1 && y_direction == 0) {
            x_direction = 0;
            y_direction = 1;
        } else if (x_direction == 0 && y_direction == 1) {
            x_direction = 1;
            y_direction = 0;
        } else if (x_direction == 1 && y_direction == 0) {
            x_direction = 0;
            y_direction = -1;
        }


    }

    @Override
    public void move(){
        x += x_direction * currentSpeed;
        y += y_direction * currentSpeed;
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


    public abstract double getWidth(){};

    public abstract double getLength(){};





}
