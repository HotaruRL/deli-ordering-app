package sandwichProperties;

abstract public class Topping {
    String toppingName;

    protected abstract double getToppingPrice(SandwichOfSize sandwichOfSize, boolean isExtra);
}
