package mediatorPkg;

import mainPkg.Request;
import mainPkg.Service;
import organizationPkg.Organization;

abstract public class Mediator {
    public abstract void addOrganization(Organization organization);
    public abstract void addRequest(Request request);
    public abstract void notify(Service service, Organization organization);
}
