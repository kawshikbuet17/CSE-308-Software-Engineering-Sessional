package foodPkg.drinksPkg;

public class Coffee extends Drinks{
    @Override
    public String prepareFood() {
        return "Coffee";
    }

    @Override
    public double foodPrice() {
        return 50;
    }
}
