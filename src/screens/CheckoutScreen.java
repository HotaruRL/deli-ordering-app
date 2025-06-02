package screens;

import utils.Order;
import utils.OrderManager;
import utils.TextUtils;

import java.util.ArrayList;

import static utils.ColorUtils.*;

public class CheckoutScreen extends Screen {
    private TextUtils textUtils;

    public CheckoutScreen(OrderManager orderManager) {
        super(orderManager);
        this.textUtils = new TextUtils();
    }

    @Override
    public void display() {
        ArrayList<String> list = optionsList.getCheckoutScreenList();

        Order currentOrder = orderManager.getCurrentOrder();
        System.out.println(textUtils.headerWithPadding("Current Order", "*", "-", 3));
        orderManager.showCurrentOrder(orderManager.createReceipt(currentOrder));
        int userInput = -1;
        while (userInput != 0) {
            menuUtils.setMenu("Everything looks good?", list, " ", "-", 10);
            userInput = menuUtils.getInt("appropriate number to execute the task");
            switch (userInput) {
                case 1 -> {
                    System.out.println(YELLOW + "You are a lucky customer!\n" + GREEN + "This order is on the house!\n" + RESET + "Enjoy your meal!\n");
                    orderManager.saveReceipt(currentOrder);
                    String receiptName = orderManager.getReceiptName(currentOrder);
                    System.out.printf(MAGENTA+"The receipt has been successfully saved to IdeaProjects\\deli-ordering-app\\receipts as %s\n"+RESET, receiptName);
                    userInput = 0;
                }
                case 0 -> {
                    return;
                }
                default -> System.out.println(RED + "Command not found. Please try again!" + RESET + "\n");
            }
        }
        // flag currentDrink done with customizing to exit outermost while loop
        currentOrder.setIsCustomizing("done");
    }
}
