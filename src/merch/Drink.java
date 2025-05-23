package merch;

import utils.FileUtils;
import java.util.HashMap;

public class Drink implements Sellable {
    private String priceChart = "drinkPrice.csv";
    private String drinkName;
    private String size;
    private final FileUtils fileUtils = new FileUtils();

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
        HashMap<String, Double> priceMap = fileUtils.readPriceWithHeader(priceChart);
        return priceMap.get(this.size);
    }

    @Override
    public void getReceiptDetails() {

    }
}
