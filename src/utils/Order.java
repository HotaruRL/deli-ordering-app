package utils;

import merch.LineItem;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private ArrayList<LineItem> lineItems;
    private LocalDateTime orderDateTime;

    public Order(){}

    public double getTotalPrice(){
        return 0;
    }

    public void addItem(){}
}
