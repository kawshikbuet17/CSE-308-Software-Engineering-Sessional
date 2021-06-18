package com.company;

import java.util.Scanner;

public class ServerThreadForWrite extends Thread{

    public void run() {
        String notifications;
        while(true){
            try {
                Scanner sc = new Scanner(System.in);
                String input = sc.nextLine();
                String []inputs = input.split("\\ ");
                for(int i = 0; i< Server.stocks.size(); i++){
                    if(inputs[1].equalsIgnoreCase(Server.stocks.get(i).getName())){
                        if(inputs[0].equalsIgnoreCase("I")){
                            Server.stocks.get(i).IncreasePrice(Double.parseDouble(inputs[2]));
                            notifications = "I er notification";//currentUser.getNotifications();
                            System.out.println(notifications);
//                            outToClient.writeBytes(notifications);
                        }
                        else if(inputs[0].equalsIgnoreCase("D")){
                            Server.stocks.get(i).DecreasePrice(Double.parseDouble(inputs[2]));
                            notifications = "D er notification";//currentUser.getNotifications();
                            System.out.println(notifications);
//                            outToClient.writeBytes(notifications);
                        }
                        else if(inputs[0].equalsIgnoreCase("C")){
                            Server.stocks.get(i).ChangeCount(Integer.parseInt(inputs[2]));
                            notifications = "C er notification";//currentUser.getNotifications();
                            System.out.println(notifications);
//                            outToClient.writeBytes(notifications);
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Something went wrong");
                e.printStackTrace();
            }
        }
    }
}
