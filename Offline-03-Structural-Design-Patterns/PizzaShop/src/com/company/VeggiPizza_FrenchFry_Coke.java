package com.company;

public class VeggiPizza_FrenchFry_Coke extends PizzaDecorator{
    FrenchFries frenchFries;
    Coke coke;

    public VeggiPizza_FrenchFry_Coke(Food newFood) {
        super(newFood);
        frenchFries = new FrenchFries();
        coke = new Coke();
    }

    public String prepareFood(){
        return super.prepareFood()+" + "+frenchFries.prepareFood()+" + "+coke.prepareFood();
    }

    public double foodPrice(){
        return super.foodPrice()+frenchFries.foodPrice()+coke.foodPrice();
    }
}
