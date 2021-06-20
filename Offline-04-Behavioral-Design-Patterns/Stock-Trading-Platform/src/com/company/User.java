package com.company;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class User implements IUser{
    public String name;
    private String notifications;
    private Socket connectionSocket;

    public User(String name, Socket connectionSocket) {
        this.name = name;
        notifications = "";
        this.connectionSocket = connectionSocket;
    }

    public String getName(){
        return name;
    }
    @Override
    public void Subscribe(Stock s) {
        s.Register(this);
    }

    @Override
    public void UnSubscribe(Stock s) {
        s.UnRegister(this);
    }

    @Override
    public void Update(Stock s) {
        notifications = "Stock " + s.getName() + ", current price = " + s.getPrice();
//        System.out.println(notifications);
        try {
            PrintWriter outToClientEach = new PrintWriter(connectionSocket.getOutputStream());
            outToClientEach.println(notifications);
            outToClientEach.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}