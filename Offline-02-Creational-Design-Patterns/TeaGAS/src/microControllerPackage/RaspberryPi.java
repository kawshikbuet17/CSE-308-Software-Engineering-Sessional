package microControllerPackage;

public class RaspberryPi implements MicroController{
    String name;

    public RaspberryPi(){
        name = "RaspberryPi";
    }
    @Override
    public String getMicroController() {
        return name;
    }
}
