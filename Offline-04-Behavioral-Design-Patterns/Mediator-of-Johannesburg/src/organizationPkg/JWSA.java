package organizationPkg;

import mediatorPkg.Mediator;
import mainPkg.Service;

public class JWSA extends Organization{
    public JWSA(Mediator mediator) {
        super(mediator, new Service("WATER"));
    }
}