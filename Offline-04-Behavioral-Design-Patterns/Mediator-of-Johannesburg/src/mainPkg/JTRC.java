package mainPkg;

public class JTRC implements Organization{
    Service service;
    public JTRC(){
        service = new Service("TELECOM");
    }

    @Override
    public void getRequest(Service service) {

    }

    @Override
    public Service Serve() {
        return null;
    }

    @Override
    public void sendRequest(Service service) {

    }

    @Override
    public String getOrganizationName() {
        return "JTRC";
    }
}
