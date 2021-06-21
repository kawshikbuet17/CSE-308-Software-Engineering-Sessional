package userPkg;

import stockPkg.Stock;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class User implements IUser{
    private String name;
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
    public void Update(Stock s, String msg) {
        notifications = "Stock " + s.getName() + " "+ msg + ", Current Count = " + s.getCount() + ", Current Price = " + s.getPrice();
        try {
            PrintWriter outToClientEach = new PrintWriter(connectionSocket.getOutputStream());
            outToClientEach.println(notifications);
            outToClientEach.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}