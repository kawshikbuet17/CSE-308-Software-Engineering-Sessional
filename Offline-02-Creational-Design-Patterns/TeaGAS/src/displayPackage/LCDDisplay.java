package displayPackage;

public class LCDDisplay implements Display{
    String displayName;

    public LCDDisplay() {
        this.displayName = "LCD";
    }

    @Override
    public String getDisplay() {
        return displayName;
    }
}
