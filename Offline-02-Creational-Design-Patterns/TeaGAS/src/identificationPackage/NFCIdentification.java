package identificationPackage;

public class NFCIdentification implements Identification{
    String name;

    public NFCIdentification(){
        name = "NFC Identification";
    }
    @Override
    public String getIdentification() {
        return name;
    }
}
