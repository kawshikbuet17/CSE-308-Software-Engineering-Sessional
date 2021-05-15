package foodPkg.pizzaPkg;

public class VeggiPizza extends Pizza{
    @Override
    public String prepareFood() {
        return "Veggi Pizza";
    }

    @Override
    public double foodPrice() {
        return 400;
    }
}
