package foodPkg.decoratorPkg.appentizerDecoratorPkg;

import foodPkg.Food;
import foodPkg.decoratorPkg.PizzaDecorator;

public abstract class AppentizerDecorator extends PizzaDecorator {
    public AppentizerDecorator(Food newFood) {
        super(newFood);
    }
}
