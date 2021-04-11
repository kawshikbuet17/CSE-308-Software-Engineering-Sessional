package com.company;

public class VeggiPizza_OrionRings extends PizzaDecorator{
    OnionRings onionRings;

    public VeggiPizza_OrionRings(Food newFood) {
        super(newFood);
        onionRings = new OnionRings();
    }

    public String prepareFood(){
        return super.prepareFood()+" + "+onionRings.prepareFood();
    }

    public double foodPrice(){
        return super.foodPrice()+onionRings.foodPrice();
    }
}
