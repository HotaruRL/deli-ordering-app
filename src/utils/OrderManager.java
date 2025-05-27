package utils;

import java.time.LocalTime;
import java.util.HashMap;

public class OrderManager {
    private LocalTime openingTime = LocalTime.of(6,59);
    private LocalTime closingTime = LocalTime.of(17,00);
    private FileUtils fileUtils;
    private static final String SHOP_INFO_FILE_PATH = "shopInfo.csv";

    OrderManager(){
        this.fileUtils = new FileUtils();
    }

    public boolean isStoreOpened(LocalTime orderTime){
        boolean isOpen = false;
        if (orderTime.isAfter(openingTime) && orderTime.isBefore(closingTime)){
            isOpen = true;
        }
        return isOpen;
    }

    public String createReceipt(Order order){
        StringBuilder receipt = new StringBuilder();

        // header
        HashMap<String, String> shopInfo = fileUtils.parse2Columns(SHOP_INFO_FILE_PATH);
        receipt.append()

        return receipt.toString();
    }

    public void saveOrder(Order order){
        fileUtils.createFile(order.getOrderDateTime());
        fileUtils.writeToFile(order.getOrderDateTime(),createReceipt(order));
    }
}
