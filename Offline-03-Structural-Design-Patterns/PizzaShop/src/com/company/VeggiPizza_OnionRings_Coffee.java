package com.company;

public class VeggiPizza_OnionRings_Coffee extends PizzaDecorator{
    OnionRings onionRings;
    Coffee coffee;

    public VeggiPizza_OnionRings_Coffee(Food newFood) {
        super(newFood);
        onionRings = new OnionRings();
        coffee = new Coffee();
    }

    public String prepareFood(){
        return super.prepareFood()+" + "+onionRings.prepareFood()+" + "+coffee.prepareFood();
    }

    public double foodPrice(){
        return super.foodPrice()+onionRings.foodPrice()+coffee.foodPrice();
    }
}
