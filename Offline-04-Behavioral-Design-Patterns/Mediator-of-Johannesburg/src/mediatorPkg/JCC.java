package mediatorPkg;

import mainPkg.Request;
import mainPkg.Service;
import organizationPkg.Organization;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class JCC extends Mediator {
    private List<Organization> organizationList;
    private List<Queue<Request>> pending;

    public JCC(){
        organizationList = new ArrayList<>();
        pending = new ArrayList<>();
    }

    public void addOrganization(Organization organization){
        organizationList.add(organization);
        Queue<Request> temp = new LinkedList<>();
        pending.add(temp);
    }

    public void addRequest(Request request){
        for(int i=0; i<organizationList.size(); i++){
            if(request.forWhat().getServiceName().equalsIgnoreCase(organizationList.get(i).whatService().getServiceName())){
                organizationList.get(i).getRequest(new Service(request.forWhat().getServiceName()));
                pending.get(i).add(request);
                System.out.println(request.fromWho().getOrganizationName()+" requests for " + request.forWhat().getServiceName() + " service");
                break;
            }
        }
    }

    public void notify(Service service, Organization organization){
        for(int i=0; i<organizationList.size(); i++){
            if(service.getServiceName().equalsIgnoreCase(organizationList.get(i).whatService().getServiceName())){
                System.out.println(organizationList.get(i).getOrganizationName()+" serves the request of "+pending.get(i).peek().fromWho().getOrganizationName());
                pending.get(i).remove();
            }
        }
    }
}
