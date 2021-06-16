package com.company;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }
    public void Subscribe(Stock s){
        s.Register(this);
    }
    public void UnSubscribe(Stock s){
        s.UnRegister(this);
    }
    public void Update(String s, double d){
        System.out.println("Stock " + s + ", current price = " + String.valueOf(d));
    }
}
