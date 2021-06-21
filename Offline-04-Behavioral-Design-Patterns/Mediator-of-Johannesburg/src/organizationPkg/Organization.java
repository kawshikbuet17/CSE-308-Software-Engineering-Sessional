package organizationPkg;

import mediatorPkg.Mediator;
import mainPkg.Request;
import mainPkg.Service;

import java.util.LinkedList;
import java.util.Queue;

abstract public class Organization {
    protected Service service;
    protected Queue<Service> pending;
    protected Mediator mediator;
    public Organization(Mediator mediator, Service service){
        this.service = service;
        pending = new LinkedList<>();
        this.mediator = mediator;
    }

    public void getRequest(Service service) {
        pending.add(service);
    }

    public Service whatService() {
        return service;
    }

    public void Serve(){
        pending.remove();
        mediator.notify(service, this);
    }

    public void sendRequest(Service service){
        mediator.addRequest(new Request(this, service));
    }

    public String getOrganizationName(){
        return this.getClass().getSimpleName();
    }
}
