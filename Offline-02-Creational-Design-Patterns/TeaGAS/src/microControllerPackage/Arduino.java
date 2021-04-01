package microControllerPackage;

public class Arduino implements MicroController{
    String name;

    public Arduino(){
        name = "Arduino";
    }
    @Override
    public String getMicroController() {
        return name;
    }
}
