package sandwichProperties;

public class SandwichOfSize {
    private String size;
    private double breadPrice;
    private double meatPrice;
    private double extraMeatPrice;
    private double cheesePrice;
    private double extraCheesePrice;

    SandwichOfSize(
            String size,
            double breadPrice,
            double meatPrice,
            double extraMeatPrice,
            double cheesePrice,
            double extraCheesePrice
            ){
        this.size = size;
        this.breadPrice = breadPrice;
        this.meatPrice = meatPrice;
        this.extraMeatPrice = extraMeatPrice;
        this.cheesePrice = cheesePrice;
        this.extraCheesePrice = extraCheesePrice;
    }

    // getters
    public String getSize() {return size;}
    public double getBreadPrice() {return breadPrice;}
    public double getMeatPrice() {return meatPrice;}
    public double getExtraMeatPrice() {return extraMeatPrice;}
    public double getCheesePrice() {return cheesePrice;}
    public double getExtraCheesePrice() {return extraCheesePrice;}
    // setters
    public void setSize(String size) {this.size = size;}
    public void setBreadPrice(double breadPrice) {this.breadPrice = breadPrice;}
    public void setMeatPrice(double meatPrice) {this.meatPrice = meatPrice;}
    public void setExtraMeatPrice(double extraMeatPrice) {this.extraMeatPrice = extraMeatPrice;}
    public void setCheesePrice(double cheesePrice) {this.cheesePrice = cheesePrice;}
    public void setExtraCheesePrice(double extraCheesePrice) {this.extraCheesePrice = extraCheesePrice;}
}
