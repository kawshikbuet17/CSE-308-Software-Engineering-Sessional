package com.company;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class NotificationThread extends Thread{
    Socket connectionSocket;
    User currentUser;
    public NotificationThread(Socket connectionSocket, User currentUser){
        this.connectionSocket = connectionSocket;
        this.currentUser = currentUser;
    }
    @Override
    public void run(){
        while (true){
            String notifications = currentUser.getNotifications();
            if(!notifications.equalsIgnoreCase("")){
                try {
                    DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
                    outToClient.writeBytes(notifications);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
