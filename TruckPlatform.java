public class TruckPlatform extends Platform{

    private double maxAngle;

    private double platformAngle;

    private Truck truck;

    public TruckPlatform(boolean loadable, double platformAngle, double maxAngle, Truck truck){
        super(loadable, truck);
        this.platformAngle = platformAngle;
        this.maxAngle = maxAngle;
    }


    @Override
    public void raisePlatform(){
        if (truck.currentSpeed == 0){
            platformAngle = Math.min(platformAngle += 5, maxAngle);
        }else{
            System.out.println("Cant raise platform when currentSpeed > 0");
        }
    }

    @Override
    public void lowerPlatform(){
        if (truck.currentSpeed == 0){
            platformAngle = Math.max(platformAngle -=5, 0);
        }else{
            System.out.println("Cant lower platform when currentSpeed > 0");
        }
    }


    public double getPlatformAngle(){
        return platformAngle;
    }


}

