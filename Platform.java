public class Platform {

    public boolean loadable;



    public Platform(boolean loadable){
        this.loadable = false;

    };

    public void raisePlatform(){
            if (!loadable ){
                System.out.println("Platform already raised");
            }else{
            loadable = false;
            }
        }

    public void lowerPlatform(){
            if (loadable){
                System.out.println("Platform already lowered");
            }else{
            loadable=true;
            }
    };




}



