package com.company;

public class User implements IUser{
    public String name;
    private String notifications;

    public User(String name) {
        this.name = name;
        notifications = "";
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
    public String getNotifications(){
        String temp = notifications;
        notifications = "";
        return temp;
    }

    @Override
    public void Update(Stock s) {
        String temp = "Stock " + s.getName() + ", current price = " + s.getPrice();
        notifications+= temp;
    }
}