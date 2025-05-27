package utils;

import merch.LineItem;
import sandwichProperties.Topping;
import sandwichProperties.toppings.Cheese;
import sandwichProperties.toppings.Meat;

import java.util.ArrayList;
import java.util.HashMap;

public class PricingService {
    private static final String SANDWICH_PRICES_FILE_PATH = "sandwichPrice.csv";
    private static final String DRINK_PRICES_FILE_PATH = "drinkPrice.csv";
    private HashMap<String, HashMap<String, Double>> sandwichPriceChart;
    private HashMap<String, String> drinkPriceChart;
    private final double CHIPS_PRICE = 1.5;
    private FileUtils fileUtils;

    public PricingService(){
        this.fileUtils = new FileUtils();
        loadPrices();
    }

    public void loadPrices(){
        fileUtils = new FileUtils();
        this.sandwichPriceChart = fileUtils.parseMultipleColumns(SANDWICH_PRICES_FILE_PATH);
        this.drinkPriceChart = fileUtils.parse2Columns(DRINK_PRICES_FILE_PATH);
    }

    public double getDrinkPrice(String size){
        return Double.parseDouble(drinkPriceChart.get(size));
    }

    public double getChipsPrice() {
        return CHIPS_PRICE;
    }

    public double getSpecificPrice(String sandwichSize, String priceFor){
        double specificPrice = 0;
        try {
            specificPrice = sandwichPriceChart.get(sandwichSize).get(priceFor);
        } catch (Exception e) {
            System.out.println("Either this size or this specific price is not available!");
        }
        return specificPrice;
    }

    public double getToppingPrice(Topping topping, String sandwichSize, boolean isExtra){
        try {
            sandwichPriceChart.get(sandwichSize);
        } catch (Exception e) {
            System.out.println("This size is not available!");
        }
        if (topping instanceof Meat){
            return isExtra ? getSpecificPrice(sandwichSize,"extraMeat") : getSpecificPrice(sandwichSize,"meat");
        } else if (topping instanceof Cheese) {
            return isExtra ? getSpecificPrice(sandwichSize,"extraCheese") : getSpecificPrice(sandwichSize,"cheese");
        }else {
            return 0;
        }
    }

    public double getSubTotal(ArrayList<LineItem> lineItems){
        double subTotal = 0;
        for (LineItem item : lineItems){
            subTotal += item.calculateUnitPrice();
        }
        return subTotal;
    }
    public double getTotal(double subTotal, double sale_taxes){
        return subTotal * (1 + sale_taxes);
    }
}
