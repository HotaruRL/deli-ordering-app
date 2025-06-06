package merch;

import utils.PricingService;

public class Drink implements LineItem {
    private String drinkName;
    private String size;
    private int quantity;
    private PricingService pricingService;
    private String isCustomizing;

    public Drink(){}
    public Drink(String drinkName, String size) {
        this.drinkName = drinkName;
        this.size = size;
    }

    // getters
    public String getDrinkName() {return drinkName;}
    public String getSize() {return size;}
    public int getQuantity() {return quantity;}
    public String getIsCustomizing() {return isCustomizing;}
    // setters
    public void setDrinkName(String drinkName) {this.drinkName = drinkName;}
    public void setSize(String size) {this.size = size;}
    public void setQuantity(int quantity) {this.quantity = quantity;}
    public void setIsCustomizing(String isCustomizing) {this.isCustomizing = isCustomizing;}

    @Override
    public double getPrice() {
        pricingService = new PricingService();
        return pricingService.calculateDrinkPrice(this.size, this.quantity);
    }

    @Override
    public double getUnitPrice() {
        pricingService = new PricingService();
        return pricingService.calculateDrinkPrice(this.size);
    }

    @Override
    public String getReceiptDetails() {
        return String.format("%s (%s)", this.drinkName, this.size);
    }
}
