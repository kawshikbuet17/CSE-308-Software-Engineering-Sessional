package controllerPackage;

public class TouchController implements Controller{
    String name;

    public TouchController(){
        name = "Touch Control";
    }
    @Override
    public String getController() {
        return name;
    }
}
