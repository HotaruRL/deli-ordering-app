package sandwichProperties.toppings;

import sandwichProperties.Topping;

public class Meat extends Topping {
    private String meatName;

    public Meat(String meatName) {
        this.meatName = meatName;
    }

    public void setMeatName(String meatName) {this.meatName = meatName;}

    @Override
    protected String getToppingName() {
        return this.meatName;
    }
}
