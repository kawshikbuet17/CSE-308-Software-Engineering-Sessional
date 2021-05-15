package foodPkg.decoratorPkg.drinksDecoratorPkg;

import foodPkg.Food;
import foodPkg.drinksPkg.Coke;

public class CokeDrinksDecorator extends DrinksDecorator{
    public CokeDrinksDecorator(Food newFood) {
        super(newFood);
    }

    @Override
    public String prepareFood() {
        return super.prepareFood() + " + " + new Coke().prepareFood();
    }

    @Override
    public double foodPrice() {
        return super.foodPrice() + new Coke().foodPrice();
    }
}
