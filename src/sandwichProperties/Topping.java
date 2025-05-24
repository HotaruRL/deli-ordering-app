package sandwichProperties;

abstract public class Topping {
    String toppingName;

    protected abstract double getToppingPrice(SizeSpecificPriceInfo sizeSpecificPriceInfo, boolean isExtra);
}
