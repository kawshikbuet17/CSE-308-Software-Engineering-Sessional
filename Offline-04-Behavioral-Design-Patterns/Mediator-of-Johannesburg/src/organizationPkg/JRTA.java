package organizationPkg;

import mediatorPkg.Mediator;
import mainPkg.Service;

public class JRTA extends Organization {
    public JRTA(Mediator mediator) {
        super(mediator, new Service("TRANSPORT"));
    }
}