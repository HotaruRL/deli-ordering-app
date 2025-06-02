package utils;

import merch.LineItem;
import merch.Sandwich;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

import static utils.ColorUtils.*;

public class OrderManager {
    private Order order;
    private ArrayList<Order> orders = new ArrayList<>();
    private LocalTime openingTime = LocalTime.of(6, 59);
    private LocalTime closingTime = LocalTime.of(17, 00);
    private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private FileUtils fileUtils;
    private TextUtils textUtils;
    private OptionsList optionsList;
    private MenuUtils menuUtils;
    private static final String SHOP_INFO_FILE_PATH = "internalUse\\shopInfo.csv";

    public OrderManager() {
        this.fileUtils = new FileUtils();
        this.textUtils = new TextUtils();
        this.optionsList = new OptionsList();
        this.menuUtils = new MenuUtils();
    }

    public boolean isOrderTimeValid(LocalTime orderTime) {
        if (orderTime.isAfter(openingTime) && orderTime.isBefore(closingTime)) {
            return true;
        }
        return false;
    }

    // assuming the store opens everyday
    public LocalDateTime orderForLater(){
        LocalTime currentTime = LocalTime.now();
        LocalTime orderTime;
        LocalDate today = LocalDate.now();
        LocalDate orderDate;

        if (currentTime.isAfter(closingTime)){
            orderDate = today;
        } else {
            orderDate = today.plusDays(1);
        }

        while (true) {
            try {
                String userInput = menuUtils.getString("time for your order");
                orderTime = LocalTime.parse(userInput, timeFormatter);
                if (isOrderTimeValid(orderTime)) {
                    break;
                }else {
                    System.out.printf(RED+"\nOrder time must be within our business hours of %s - %s\n"+RESET,
                            openingTime.plusMinutes(1).format(timeFormatter),
                            closingTime.format(timeFormatter));
                }
            } catch (Exception e) {
                System.out.printf(RED + "\nInvalid time format. Please try again using HH:mm format (e.g. 09:00 or 14:30\n" + RESET);
            }
        }
        return LocalDateTime.of(orderDate, orderTime);
    }

    public LocalDateTime getOrderInBusinessHours() {
//        LocalTime now = LocalTime.of(17,01); // for testing
        LocalTime now = LocalTime.now();
        LocalDateTime orderDateTime = LocalDateTime.now();
        ArrayList<String> list = optionsList.getFutureOrderScreenList();

        if (!isOrderTimeValid(now)) {
            int userInput = -1;
            while (userInput != 0) {
                System.out.println(String.format(RED + "Our store is NOT open yet. Would you like to place order for a future time?\n"+RESET));
                menuUtils.setMenu("Order for Later?", list, " ", "-", 10);
                userInput = menuUtils.getInt("appropriate number to execute the task");
                switch (userInput) {
                    case 1 -> {
                        orderDateTime = orderForLater();
                        System.out.printf(YELLOW + "\nYour order is set for %s\n" + RESET, orderDateTime.format(dateTimeFormatter));
                        userInput = 0;
                    }
                    case 0 -> {
                        System.out.println(RED+"Order Cancelled\n"+MAGENTA+"See you again!"+RESET);
//                        orderDateTime = LocalDateTime.of(LocalDate.now(), now); // for testing different time
                    }
                    default -> System.out.println(RED + "Command not found. Please try again!" + RESET + "\n");
                }
            }
        }
        return orderDateTime;
    }

    public void createNewOrder(LocalDateTime orderTime) {
        int orderID = this.orders.size() + 1;
        this.order = new Order(orderID, LocalDateTime.now(), new ArrayList<LineItem>());
        this.orders.add(this.order);
    }

    public Order getCurrentOrder() {
        return this.order;
    }

    public void showCurrentOrder(String receipt) {
        System.out.println("\n" + receipt + "\n");
    }

    public String createReceipt(Order order) {
        StringBuilder receipt = new StringBuilder();
        int LINE_WIDTH = 60;
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
        for (LineItem item : order.getLineItems()) {
            String itemDescription = item.getReceiptDetails();
            String itemPrice = String.format("$%.2f", item.getPrice());
            String itemUnitPrice = String.format("$%.2f/ea", item.getUnitPrice());
            String itemQuantity = String.format("  x%d", item.getQuantity());

            // to calculate the space between description and price
            int itemNumberLength = (itemNumber + ". ").length();
            int descriptionLength = itemNumberLength + itemDescription.length();
            int priceLength = itemPrice.length();
            int spaceNeeded = LINE_WIDTH - (descriptionLength + priceLength);
            // make sure to have at least 1 space between description and price
            if (spaceNeeded < 1) {
                spaceNeeded = 1;
            }

            receipt.append(String.format("%d. %s%s\n",
                    itemNumber++,
                    itemDescription,
                    SPACE.repeat(spaceNeeded)));

            // to calculate the space between unit price + quantity and price
            String indent = SPACE.repeat(itemNumberLength);
            int unitPriceLength = itemUnitPrice.length();
            int quantityLength = itemQuantity.length();
            int spaceNeeded2 = LINE_WIDTH - (itemNumberLength + unitPriceLength + quantityLength + priceLength);
            receipt.append(String.format("%s%s%s%s%s\n",
                    indent,
                    itemUnitPrice,
                    itemQuantity,
                    SPACE.repeat(spaceNeeded2),
                    itemPrice));

            // if item is a sandwich, add additional details
            if (item instanceof Sandwich) {
                for (String detail : ((Sandwich) item).getAdditionDetails(true)) {
                    if (detail == null) {
                        continue;
                    }
                    receipt.append(indent).append(detail).append("\n");
                }
            }
            // add a line break after each line item
            receipt.append("\n");
        }

        // summary
        receipt.append(SEPARATOR).append("\n");
        receipt.append(String.format("Subtotal: %.2f", order.getSubTotalPrice())).append("\n");
        receipt.append(String.format("Taxes: %.1f%%", order.getSALE_TAXESToDisplay())).append("\n");
        receipt.append(SEPARATOR).append("\n");
        receipt.append(String.format("TOTAL: %.2f", order.getTotalPrice())).append("\n");
        receipt.append(SEPARATOR).append("\n\n");

        // footer
        receipt.append(textUtils.centerText("Thank you for your order!")).append("\n");
        receipt.append(BORDER).append("\n");

        return receipt.toString();
    }

    public void saveReceipt(Order order) {
        fileUtils.writeToFile(order.getOrderDateTime(), createReceipt(order));
    }

    public String getReceiptName(Order order) {
        return fileUtils.getFileName(order.getOrderDateTime());
    }
}
