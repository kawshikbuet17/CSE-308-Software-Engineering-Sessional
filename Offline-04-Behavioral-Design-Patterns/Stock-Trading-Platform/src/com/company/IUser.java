package com.company;

public interface IUser {
    void Subscribe(Stock s);
    void UnSubscribe(Stock s);
    void Update(String s, double d);
}
