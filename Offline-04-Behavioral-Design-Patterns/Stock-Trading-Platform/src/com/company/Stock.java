package com.company;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private String name;
    private int count;
    private double price;
    List<User> subscriber = new ArrayList<User>();

    public Stock(String name, int count, double price) {
        this.name = name;
        this.count = count;
        this.price = price;
        System.out.println(name + " " + count + " " + price);
    }

    public void Register(User u){
        subscriber.add(u);
        u.Update(name, price);
    }

    public void UnRegister(User u){
        subscriber.remove(u);
    }

    public void NofifySubscribers(double updatedValue){
        for(int i=0; i< subscriber.size(); i++){
            subscriber.get(i).Update(name, updatedValue);
        }
    }
}
