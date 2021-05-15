package foodPkg.pizzaPkg;

public class BeefPizza extends Pizza{
    @Override
    public String prepareFood() {
        return "Beef Pizza";
    }

    @Override
    public double foodPrice() {
        return 500;
    }
}
