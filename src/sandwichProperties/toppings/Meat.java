package sandwichProperties.toppings;

import sandwichProperties.SandwichOfSize;
import sandwichProperties.Topping;

public class Meat extends Topping {
    private String meatName;

    public Meat(String meatName) {
        this.meatName = meatName;
    }

    public String getMeatName() {return meatName;}
    public void setMeatName(String meatName) {this.meatName = meatName;}

    @Override
    protected double getToppingPrice(SandwichOfSize sandwichOfSize, boolean isExtra) {
        return 0;
    }
}
