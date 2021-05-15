package foodPkg.decoratorPkg.drinksDecoratorPkg;

import foodPkg.Food;
import foodPkg.decoratorPkg.PizzaDecorator;

public abstract class DrinksDecorator extends PizzaDecorator {
    public DrinksDecorator(Food newFood) {
        super(newFood);
    }
}
