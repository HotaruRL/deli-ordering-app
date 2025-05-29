package utils;

import merch.LineItem;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private final double SALE_TAXES = 0.10; // 10%
    private int orderID;
    private ArrayList<LineItem> lineItems;
    private LocalDateTime orderDateTime;
    private PricingService pricingService;
    private String isCustomizing;

    public Order(int orderID, LocalDateTime orderDateTime, ArrayList<LineItem> lineItems){
        this.orderID = orderID;
        this.orderDateTime = orderDateTime;
        this.lineItems = lineItems;
    }

    // getters
    public double getSALE_TAXES() {return SALE_TAXES;}
    public double getSALE_TAXESToDisplay() {return SALE_TAXES * 100;}
    public int getOrderID() {return this.orderID;}
    public ArrayList<LineItem> getLineItems() {return lineItems;}
    public LocalDateTime getOrderDateTime() {return this.orderDateTime;}
    public String getIsCustomizing() {return isCustomizing;}
    // setters
    public void setIsCustomizing(String isCustomizing) {this.isCustomizing = isCustomizing;}

    public double getSubTotalPrice(){
        pricingService = new PricingService();
        return pricingService.calculateSubTotal(this.lineItems);
    }

    public double getTotalPrice(){
        pricingService = new PricingService();
        return pricingService.calculateTotal(getSubTotalPrice(),SALE_TAXES);
    }

    public void addItem(LineItem item){
        this.lineItems.add(item);
    }
}
