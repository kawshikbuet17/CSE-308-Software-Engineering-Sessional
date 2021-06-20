package mainPkg;

public class JWSA implements Organization {
    Service service;

    public JWSA() {
        service = new Service("WATER");
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
        return "JWSA";
    }
}
