package organizationPkg;

import mediatorPkg.Mediator;
import mainPkg.Service;

public class JTRC extends Organization {
    public JTRC(Mediator mediator) {
        super(mediator, new Service("TELECOM"));
    }
}