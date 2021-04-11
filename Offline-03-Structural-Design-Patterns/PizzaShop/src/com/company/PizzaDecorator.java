package com.company;

public abstract class PizzaDecorator implements Food{
    private Food newFood;

    public PizzaDecorator(Food newFood) {
        this.newFood = newFood;
    }

    @Override
    public String prepareFood(){
        return newFood.prepareFood();
    }

    @Override
    public double foodPrice() {
        return newFood.foodPrice();
    }
}
