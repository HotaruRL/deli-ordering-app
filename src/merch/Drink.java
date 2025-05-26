package merch;

import utils.PricingService;

public class Drink implements LineItem {
    private String priceChart = "drinkPrice.csv";
    private String drinkName;
    private String size;
    private PricingService pricingService;

    public Drink(String drinkName, String size) {
        this.drinkName = drinkName;
        this.size = size;
    }

    // getters
    public String getPriceChart() {return priceChart;}
    public String getDrinkName() {return drinkName;}
    public String getSize() {return size;}
    // setters
    public void setPriceChart(String priceChart) {this.priceChart = priceChart;}
    public void setDrinkName(String drinkName) {this.drinkName = drinkName;}
    public void setSize(String size) {this.size = size;}

    @Override
    public double calculateUnitPrice() {
        pricingService = new PricingService();
        return pricingService.getDrinkPrice(this.size);
    }

    @Override
    public void getReceiptDetails() {

    }
}
