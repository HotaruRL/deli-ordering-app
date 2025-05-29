package sandwichProperties.toppings;

abstract public class Topping {
    protected String toppingName;

    public Topping(String toppingName){
        this.toppingName = toppingName;
    }

    public String getToppingName(){return toppingName;};
}
