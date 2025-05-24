package sandwichProperties.toppings;

import sandwichProperties.SizeSpecificPriceInfo;
import sandwichProperties.Topping;

public class Meat extends Topping {
    private String meatName;

    public Meat(String meatName) {
        this.meatName = meatName;
    }

    public String getMeatName() {return meatName;}
    public void setMeatName(String meatName) {this.meatName = meatName;}

    @Override
    protected double getToppingPrice(SizeSpecificPriceInfo sizeSpecificPriceInfo, boolean isExtra) {

        return 0;
    }
}
