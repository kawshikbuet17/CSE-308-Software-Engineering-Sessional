package controllerPackage;

public class ButtonController implements Controller{
    String name;

    public ButtonController() {
        name = "Button Control";
    }

    @Override
    public String getController() {
        return name;
    }
}
