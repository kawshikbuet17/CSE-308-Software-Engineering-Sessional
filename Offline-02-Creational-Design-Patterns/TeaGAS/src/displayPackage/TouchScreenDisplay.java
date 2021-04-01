package displayPackage;

public class TouchScreenDisplay implements Display{
    String displayName;

    public TouchScreenDisplay() {
        this.displayName = "Touch Screen Display";
    }

    @Override
    public String getDisplay() {
        return displayName;
    }
}
