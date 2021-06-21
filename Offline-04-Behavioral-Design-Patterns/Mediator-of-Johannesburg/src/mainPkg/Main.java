package mainPkg;

import mediatorPkg.JCC;
import mediatorPkg.Mediator;
import organizationPkg.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Organization []organization;
        Mediator mediator;
        String []Services = {"WATER", "ENERGY", "TRANSPORT", "TELECOM", "SERVE"};
        String []Orgs = {"JWSA", "JPDC", "JRTA", "JTRC"};

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if(input.equalsIgnoreCase("Init")){
            mediator = new JCC();
            organization = new Organization[4];
            organization[0] = new JWSA(mediator);
            organization[1] = new JPDC(mediator);
            organization[2] = new JRTA(mediator);
            organization[3] = new JTRC(mediator);

            for(int i=0; i<4; i++){
                mediator.addOrganization(organization[i]);
            }
            System.out.println("All four services are initiated through mediator");

            while (sc.hasNextLine()){
                input = sc.nextLine();
                String[] arr = input.split("\\ ");

                for(int i=0; i<Orgs.length; i++){
                    if(arr[0].equalsIgnoreCase(Orgs[i])){
                        //System.out.println(arr[0] + i);
                        for(int j=0; j<Services.length; j++){
                            if(arr[1].equalsIgnoreCase(Services[j])){
                                //System.out.println(arr[1]+j);
                                if(j != 4){
                                    organization[i].sendRequest(new Service(Services[j]));
                                }
                                else if(j==4){
                                    organization[i].Serve();
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
