package mainPkg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class JCC extends Mediator {
    List<Organization> organizationList;
    List<Queue<Request>> pending;

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
            if(request.service.getServiceName().equalsIgnoreCase(organizationList.get(i).Serve().getServiceName())){
                organizationList.get(i).getRequest(new Service(request.service.getServiceName()));
                pending.get(i).add(request);
                break;
            }
        }
    }

    public void notification(Service service, Organization organization){
        for(int i=0; i<organizationList.size(); i++){
            if(service.getServiceName().equalsIgnoreCase(organizationList.get(i).Serve().getServiceName())){
                System.out.println(organizationList.get(i).getOrganizationName()+" serves the request of "+pending.get(i).peek().fromWho());
                pending.get(i).remove();
            }
        }
    }
}
