package mainPkg;

public class JRTA implements Organization{
     Service service;
    public JRTA(){
        service = new Service("TRANSPORT");
    }


    @Override
    public void getRequest(Service service) {

    }

    @Override
    public Service Serve() {
        return service;
    }

    @Override
    public void sendRequest(Service service) {

    }

    @Override
    public String getOrganizationName() {
        return "JTRA";
    }
}
