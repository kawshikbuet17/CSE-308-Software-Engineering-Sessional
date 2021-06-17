package com.company;

public interface IStock {
    void Register(User u);
    void UnRegister(User u);
    void NofifySubscribers(double updatedValue);
}
