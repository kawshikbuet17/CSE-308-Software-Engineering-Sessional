package com.company;

public class BeefPizza_FrenchFry extends PizzaDecorator{
    FrenchFries frenchFries;

    public BeefPizza_FrenchFry(Food newFood) {
        super(newFood);
        frenchFries = new FrenchFries();
    }

    public String prepareFood(){
        return super.prepareFood()+" + "+frenchFries.prepareFood();
    }

    public double foodPrice(){
        return super.foodPrice()+frenchFries.foodPrice();
    }
}
