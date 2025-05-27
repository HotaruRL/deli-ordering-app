package merch;

import utils.PricingService;

public class Chips implements LineItem {
    private String chipName;
    private PricingService pricingService;

    public Chips(String chipName){
        this.chipName = chipName;
    }

    // getters
    public String getChipName() {return chipName;}
    // setters
    public void setChipName(String chipName) {this.chipName = chipName;}

    @Override
    public double calculateUnitPrice() {
        pricingService = new PricingService();
        return pricingService.getChipsPrice();
    }

    @Override
    public String getReceiptDetails() {
        return this.chipName;
    }
}
