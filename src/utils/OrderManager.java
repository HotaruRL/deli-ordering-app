package utils;

import merch.LineItem;
import merch.Sandwich;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class OrderManager {
    private LocalTime openingTime = LocalTime.of(6,59);
    private LocalTime closingTime = LocalTime.of(17,00);
    private FileUtils fileUtils;
    private TextUtils textUtils;
    private static final String SHOP_INFO_FILE_PATH = "shopInfo.csv";

    OrderManager(){
        this.fileUtils = new FileUtils();
        this.textUtils = new TextUtils();
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
        int LINE_WIDTH = 40;
        String SEPARATOR = textUtils.createPattern("-", LINE_WIDTH);
        String BORDER = textUtils.createPattern("*", LINE_WIDTH);

        // header
        HashMap<String, String> shopInfo = fileUtils.parse2Columns(SHOP_INFO_FILE_PATH);
        receipt.append(BORDER).append("\n");
        receipt.append(textUtils.centerText(shopInfo.get("Shop Name"))).append("\n");
        receipt.append(textUtils.centerText(shopInfo.get("Address"))).append("\n");
        receipt.append(textUtils.centerText(shopInfo.get("Phone"))).append("\n");
        receipt.append(BORDER).append("\n\n");

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        receipt.append(String.format("Order Date: %s\n", order.getOrderDateTime().format(dateFormatter)));
        receipt.append(String.format("Order Time: %s\n", order.getOrderDateTime().format(timeFormatter)));
        receipt.append(String.format("Order ID: %s\n", order.getOrderID()));

        // items header
        receipt.append(SEPARATOR).append("\n");
        receipt.append("ITEMS\n");
        receipt.append(SEPARATOR).append("\n");

        // items
        int itemNumber = 1;
        String SPACE = " ";
        for (LineItem item : order.getLineItems()){
            String itemDescription = item.getReceiptDetails();
            String itemPrice = String.format("$%.2f", item.calculateUnitPrice());

            // to calculate the space between description and price
            int descriptionLength = (itemNumber + ". ").length() + itemDescription.length();
            int priceLength = itemPrice.length();
            int spaceNeeded = LINE_WIDTH - (descriptionLength + priceLength);
            // make sure to have at least 1 space between description and price
            if (spaceNeeded < 1){
                spaceNeeded = 1;
            }

            receipt.append(String.format("%d. %s%s%s\n",
                    itemNumber++,
                    itemDescription,
                    SPACE.repeat(spaceNeeded),
                    itemPrice));

            // if item is a sandwich, add additional details
            if (item instanceof Sandwich){
                for (String detail : ((Sandwich) item).getAdditionDetails()){
                    receipt.append(detail).append("\n");
                }
            }
            // add a line break after each line item
            receipt.append("\n");
        }

        // summary
        receipt.append(SEPARATOR).append("\n");
        receipt.append(String.format("Subtotal: %.2f", order.getSubTotalPrice()));
        receipt.append(String.format("Taxes: %.1f%%", order.getSALE_TAXESToDisplay()));
        receipt.append(SEPARATOR).append("\n");
        receipt.append(String.format("TOTAL: %.2f", order.getTotalPrice()));
        receipt.append(SEPARATOR).append("\n\n");

        // footer
        receipt.append(textUtils.centerText("Thank you for your order!")).append("\n");
        receipt.append(BORDER).append("\n");

        return receipt.toString();
    }

    public void saveReceipt(Order order){
        fileUtils.createFile(order.getOrderDateTime());
        fileUtils.writeToFile(order.getOrderDateTime(),createReceipt(order));
    }
}
