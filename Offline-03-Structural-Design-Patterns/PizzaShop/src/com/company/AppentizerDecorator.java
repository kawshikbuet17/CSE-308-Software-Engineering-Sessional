package com.company;

public class AppentizerDecorator extends PizzaDecorator {

    public AppentizerDecorator(Food newFood) {
        super(newFood);
    }

    @Override
    public String prepareFood() {
        return null;
    }

    @Override
    public double foodPrice() {
        return 0;
    }
}
