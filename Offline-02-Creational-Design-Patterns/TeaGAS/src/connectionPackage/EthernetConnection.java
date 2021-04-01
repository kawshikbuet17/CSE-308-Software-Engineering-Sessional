package connectionPackage;

public class EthernetConnection implements Connection{
    String name;

    public EthernetConnection(){
        name = "Ethernet Connection";
    }
    @Override
    public String getConnection() {
        return name;
    }
}
