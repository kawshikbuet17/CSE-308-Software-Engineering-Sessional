package foodPkg.decoratorPkg.appentizerDecoratorPkg;

import foodPkg.appentizerPkg.FrenchFries;
import foodPkg.Food;

public class FrenchFryAppentizerDecorator extends AppentizerDecorator{
    public FrenchFryAppentizerDecorator(Food newFood) {
        super(newFood);
    }
    @Override
    public String prepareFood() {
        return super.prepareFood() + " + "+ new FrenchFries().prepareFood();
    }

    @Override
    public double foodPrice() {
        return super.foodPrice() + new FrenchFries().foodPrice();
    }
}
