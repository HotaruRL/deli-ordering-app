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
        ArrayList<String> options = new ArrayList<>();
        options.add(RED + "Continue" + RESET + " to Payment");
        options.add(RED + "Go" + RESET + " back");

        Order currentOrder = orderManager.getCurrentOrder();
        System.out.println(textUtils.headerWithPadding("Current Order", "*", "-", 3));
        orderManager.showCurrentOrder(orderManager.createReceipt(currentOrder));
        int userInput = -1;
        while (userInput != 0) {
            menuUtils.setMenu("Everything looks good?", options, " ", "-", 10);
            userInput = menuUtils.getInt("appropriate number to execute the task");
            switch (userInput) {
                case 1 -> {
                    System.out.println(YELLOW + "You are a lucky customer!\n" + GREEN + "This order is on the house!\n" + RESET + "Enjoy your meal!\n");
                    orderManager.saveReceipt(currentOrder);
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
