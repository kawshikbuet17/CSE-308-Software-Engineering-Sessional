package organizationPkg;

import mediatorPkg.Mediator;
import mainPkg.Service;

public class JPDC extends Organization {
    public JPDC(Mediator mediator) {
        super(mediator, new Service("POWER"));
    }
}