package mainPkg;

public interface Organization {
    void getRequest(Service service);
    Service Serve();
    void sendRequest(Service service);
    String getOrganizationName();
}
