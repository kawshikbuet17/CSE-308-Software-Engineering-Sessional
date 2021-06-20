package mainPkg;

import java.util.LinkedList;
import java.util.Queue;

public class JPDC implements Organization{
    Service service;
    Queue<Service> pending;
    Mediator mediator;
    public JPDC(Mediator mediator){
        service = new Service("ENERGY");
        pending = new LinkedList<>();
        this.mediator = mediator;
    }

    public void getRequest(Service service) {
        pending.add(service);
    }

    public Service Serve() {
        pending.remove();
        return service;
    }

    public void sendRequest(Service service){
        mediator.addRequest(new Request(this, service));
    }

    @Override
    public String getOrganizationName() {
        return "JPDC";
    }
}
