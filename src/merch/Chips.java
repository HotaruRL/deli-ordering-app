package merch;

import utils.PricingService;

public class Chips implements LineItem {
    private String chipName;
    private int quantity;
    private PricingService pricingService;
    private String isCustomizing;

    public Chips(){}
    public Chips(String chipName){
        this.chipName = chipName;
    }

    // getters
    public String getChipName() {return chipName;}
    public int getQuantity() {return quantity;}
    public String getIsCustomizing() {return isCustomizing;}
    // setters
    public void setChipName(String chipName) {this.chipName = chipName;}
    public void setQuantity(int quantity) {this.quantity = quantity;}
    public void setIsCustomizing(String isCustomizing) {this.isCustomizing = isCustomizing;}

    @Override
    public double getPrice() {
        pricingService = new PricingService();
        return pricingService.calculateChipsPrice(this.quantity);
    }

    @Override
    public double getUnitPrice() {
        pricingService = new PricingService();
        return pricingService.calculateChipsPrice();
    }

    @Override
    public String getReceiptDetails() {
        return String.format("Chips: %s", this.chipName);
    }
}
