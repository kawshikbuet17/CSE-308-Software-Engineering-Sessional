package connectionPackage;

public class WiFiConnection implements Connection{
    String name;

    public WiFiConnection(){
        name = "WiFi Connection";
    }
    @Override
    public String getConnection() {
        return name;
    }
}
