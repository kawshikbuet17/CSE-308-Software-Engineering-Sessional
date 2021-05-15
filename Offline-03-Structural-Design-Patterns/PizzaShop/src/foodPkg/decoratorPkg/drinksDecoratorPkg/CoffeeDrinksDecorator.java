package foodPkg.decoratorPkg.drinksDecoratorPkg;

import foodPkg.Food;
import foodPkg.drinksPkg.Coffee;

public class CoffeeDrinksDecorator extends DrinksDecorator{
    public CoffeeDrinksDecorator(Food newFood) {
        super(newFood);
    }
    @Override
    public String prepareFood() {
        return super.prepareFood() + " + " + new Coffee().prepareFood();
    }

    @Override
    public double foodPrice() {
        return super.foodPrice() + new Coffee().foodPrice();
    }
}
