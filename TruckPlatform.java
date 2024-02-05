public class TruckPlatform extends Platform{

    private final double maxAngle;

    private double platformAngle;


    public TruckPlatform(boolean loadable, double platformAngle, double maxAngle){
        super(loadable);
        this.platformAngle = platformAngle;
        this.maxAngle = maxAngle;
    }


    @Override
    public void raisePlatform(){
            if (loadable){
            platformAngle = Math.min(this.platformAngle += 5, maxAngle);
            }
    }

    @Override
    public void lowerPlatform(){
        if (!loadable){
        platformAngle = Math.max(this.platformAngle -= 5, 0);
        }
    }


    public double getPlatformAngle(){
        return platformAngle;
    }


}

