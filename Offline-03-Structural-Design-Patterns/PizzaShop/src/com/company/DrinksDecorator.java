package com.company;

public class DrinksDecorator extends PizzaDecorator{

    public DrinksDecorator(Food newFood) {
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
