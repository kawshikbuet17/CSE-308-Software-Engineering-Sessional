package com.company;

public interface IUser {
    void Subscribe(Stock s);
    void UnSubscribe(Stock s);
    String Update(String s, double d);
}
