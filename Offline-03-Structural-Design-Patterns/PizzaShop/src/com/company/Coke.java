package com.company;

public class Coke extends Drinks{
    @Override
    public String prepareFood() {
        return "Coke";
    }

    @Override
    public double foodPrice() {
        return 30;
    }
}
