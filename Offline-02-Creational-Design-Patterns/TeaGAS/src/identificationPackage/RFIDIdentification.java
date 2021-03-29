package identificationPackage;

public class RFIDIdentification implements Identification{
    String name;

    public RFIDIdentification(){
        name = "RFID Identification";
    }
    @Override
    public String getIdentification() {
        return name;
    }
}
