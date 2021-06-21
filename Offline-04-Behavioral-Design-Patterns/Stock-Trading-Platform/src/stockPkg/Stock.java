package stockPkg;

import userPkg.User;

import java.util.ArrayList;
import java.util.List;

public class Stock implements IStock{
    private String name;
    private int count;
    private double price;
    private List<User> subscriber;

    public Stock(String name, int count, double price) {
        subscriber = new ArrayList<User>();
        this.name = name;
        this.count = count;
        this.price = price;
        System.out.println(name + " " + count + " " + price);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void IncreasePrice(double d) {
        this.price += d;
        NofifySubscribers("Price Increased");
    }

    @Override
    public void DecreasePrice(double d) {
        this.price-=d;
        NofifySubscribers("Price Decreased");
    }

    @Override
    public void ChangeCount(int i) {
        this.count = i;
        NofifySubscribers("Count Changed");
    }

    @Override
    public void Register(User u) {
        subscriber.add(u);
    }

    @Override
    public void UnRegister(User u) {
        subscriber.remove(u);
    }

    @Override
    public void NofifySubscribers(String msg) {
        for(int i=0; i< subscriber.size(); i++){
            subscriber.get(i).Update(this, msg);
        }
    }
}