package foodPkg.decoratorPkg.appentizerDecoratorPkg;

import foodPkg.appentizerPkg.OnionRings;
import foodPkg.Food;

public class OnionRingsAppentizerDecorator extends AppentizerDecorator{
    public OnionRingsAppentizerDecorator(Food newFood) {
        super(newFood);
    }
    @Override
    public String prepareFood() {
        return super.prepareFood() + " + " + new OnionRings().prepareFood();
    }

    @Override
    public double foodPrice() {
        return super.foodPrice() + new OnionRings().foodPrice();
    }
}
