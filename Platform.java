public class Platform {

    public boolean loadable;
    private Truck truck;

    public Platform(boolean loadable, Truck truck){
        this.loadable = false;
        this.truck = truck;

    };

    public void raisePlatform(){
        if (truck.currentSpeed != 0){
            System.out.println("Need to be still to raise platform");
        }else{
            if (!loadable ){
                System.out.println("Platform already raised");
            }else{
            loadable = false;
            }
        }
    };

    public void lowerPlatform(){
        if (truck.currentSpeed != 0){
            System.out.println("Need to be still to lower platform");
        }else{
            if (loadable){
                System.out.println("Platform already lowered");
            }else{
            loadable=true;
            }
        }

    };




}



