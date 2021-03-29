package displayPackage;

public class LEDDisplay implements Display{
    String displayName;

    public LEDDisplay() {
        this.displayName = "LED Display";
    }

    @Override
    public String getDisplay() {
        return displayName;
    }
}
