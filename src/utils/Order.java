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

    public Order(int orderID, LocalDateTime orderDateTime, ArrayList<LineItem> lineItems){
        this.orderID = orderID;
        this.orderDateTime = orderDateTime;
        this.lineItems = lineItems;
    }

    public double getSALE_TAXES() {return SALE_TAXES;}
    public double getSALE_TAXESToDisplay() {return SALE_TAXES * 100;}
    public int getOrderID() {return this.orderID;}
    public ArrayList<LineItem> getLineItems() {return lineItems;}
    public LocalDateTime getOrderDateTime() {return this.orderDateTime;}

    public double getSubTotalPrice(){
        pricingService = new PricingService();
        return pricingService.getSubTotal(this.lineItems);
    }

    public double getTotalPrice(){
        pricingService = new PricingService();
        return pricingService.getTotal(getSubTotalPrice(),SALE_TAXES);
    }

    public void addItem(LineItem item){
        this.lineItems.add(item);
    }
}
