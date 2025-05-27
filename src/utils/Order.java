package utils;

import merch.LineItem;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private final double SALE_TAXES = 0.10; // 10%
    private ArrayList<LineItem> lineItems;
    private LocalDateTime orderDateTime;
    private PricingService pricingService;

    public Order(ArrayList<LineItem> lineItems, LocalDateTime orderDateTime){
        this.lineItems = lineItems;
        this.orderDateTime = orderDateTime;
    }

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
