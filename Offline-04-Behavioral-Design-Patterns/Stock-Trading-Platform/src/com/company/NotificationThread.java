package com.company;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class NotificationThread extends Thread{
    @Override
    public void run(){
        while (true){
            try{
                ContinuousNotification();
                Scanner sc = new Scanner(System.in);
                String input;
                input = sc.nextLine();
                String []arr = input.split("\\ ");
                if(arr[0].equalsIgnoreCase("I")){
                    IncreasePrice(arr);
                }
                else if(arr[0].equalsIgnoreCase("D")){
                    DecreasePrice(arr);
                }
                else if(arr[0].equalsIgnoreCase("C")){
                    ChangeCount(arr);
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void IncreasePrice(String[] arr) throws IOException {
        for(int i = 0; i< Server.stocks.size(); i++){
            if(Server.stocks.get(i).getName().equalsIgnoreCase(arr[1])){
                Server.stocks.get(i).IncreasePrice(Double.parseDouble(arr[2]));

            }
        }
    }
    public void DecreasePrice(String[] arr) throws IOException {
        for(int i = 0; i< Server.stocks.size(); i++){
            if(Server.stocks.get(i).getName().equalsIgnoreCase(arr[1])){
                Server.stocks.get(i).DecreasePrice(Double.parseDouble(arr[2]));
            }
        }
    }

    public void ChangeCount(String[] arr) throws IOException {
        for(int i = 0; i< Server.stocks.size(); i++){
            if(Server.stocks.get(i).getName().equalsIgnoreCase(arr[1])){
                Server.stocks.get(i).ChangeCount(Integer.parseInt(arr[2]));
            }
        }
    }

    public void ContinuousNotification() throws IOException {
        for(int j = 0; j< Server.connectionSockets.size(); j++){
            String notification = Server.users.get(j).getNotifications();
            if(notification.length() != 0){
                System.out.println(notification);
                DataOutputStream outToClientEach = new DataOutputStream(Server.connectionSockets.get(j).getOutputStream());
                outToClientEach.writeBytes(notification);
            }
        }
    }
}
