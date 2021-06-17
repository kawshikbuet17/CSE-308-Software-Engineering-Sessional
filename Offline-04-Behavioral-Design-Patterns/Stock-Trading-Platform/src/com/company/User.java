package com.company;

public class User implements IUser{
    private String name;

    public User(String name) {
        this.name = name;
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
    public void Update(String s, double d) {
        System.out.println("Stock " + s + ", current price = " + String.valueOf(d));
    }

}