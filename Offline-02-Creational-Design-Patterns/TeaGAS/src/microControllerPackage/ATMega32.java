package microControllerPackage;

public class ATMega32 implements MicroController{
    String name;

    public ATMega32(){
        name = "ATMega32";
    }
    @Override
    public String getMicroController() {
        return name;
    }
}
