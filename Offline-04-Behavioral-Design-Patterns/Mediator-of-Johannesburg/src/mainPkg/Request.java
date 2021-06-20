package mainPkg;

public class Request {
    Organization organization;
    Service service;

    public Request(Organization organization, Service service) {
        this.organization = organization;
        this.service = service;
    }

    public Organization fromWho(){
        return organization;
    }

    public Service forWhat(){
        return service;
    }
}
