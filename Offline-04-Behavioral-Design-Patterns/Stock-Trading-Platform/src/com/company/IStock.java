package com.company;

public interface IStock {
    String getName();
    int getCount();
    double getPrice();
    void IncreasePrice(double d);
    void DecreasePrice(double d);
    void ChangeCount(int i);
    void Register(User u);
    void UnRegister(User u);
    void NofifySubscribers(double updatedValue);
}
