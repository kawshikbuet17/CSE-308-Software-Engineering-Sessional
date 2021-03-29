package connectionPackage;

public class GSMConnection implements Connection{
    String name;

    public GSMConnection(){
        name = "GSM Connection";
    }
    @Override
    public String getConnection() {
        return name;
    }
}
