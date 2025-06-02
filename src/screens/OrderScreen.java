package screens;

import merch.Chips;
import merch.Drink;
import merch.Sandwich;
import utils.Order;
import utils.OrderManager;

import java.util.ArrayList;

import static utils.ColorUtils.*;

public class OrderScreen extends Screen {
    public Order currentOrder;

    public OrderScreen(OrderManager orderManager, Order currentOrder) {
        super(orderManager);
        this.currentOrder = currentOrder;
    }

    @Override
    public void display() {
        ArrayList<String> list = optionsList.getOrderScreenList();

        int userInput = -1;
        while (userInput != 0) {
            menuUtils.setMenu("Order Screen", list, "*", "-", 3);
            userInput = menuUtils.getInt("appropriate number to execute the task");
            switch (userInput) {
                case 1 -> {
                    orderManager.getCurrentOrder().addItem(new Sandwich(1));
                    int currentItemIndex = menuUtils.getIndexOfLastItem(orderManager.getCurrentOrder().getLineItems());
                    SandwichScreen sandwichScreen = new SandwichScreen(orderManager, currentItemIndex);
                    sandwichScreen.display();
                }
                case 2 -> {
                    orderManager.getCurrentOrder().addItem(new Drink());
                    int currentItemIndex = menuUtils.getIndexOfLastItem(orderManager.getCurrentOrder().getLineItems());
                    DrinkScreen drinkScreen = new DrinkScreen(orderManager, currentItemIndex);
                    drinkScreen.display();
                }
                case 3 -> {
                    orderManager.getCurrentOrder().addItem(new Chips());
                    int currentItemIndex = menuUtils.getIndexOfLastItem(orderManager.getCurrentOrder().getLineItems());
                    ChipsScreen chipsScreen = new ChipsScreen(orderManager, currentItemIndex);
                    chipsScreen.display();
                }
                case 4 -> {
                    CheckoutScreen checkoutScreen = new CheckoutScreen(orderManager);
                    checkoutScreen.display();
                }
                case 0 -> {
                    return;
                }
                default -> System.out.println(RED + "Command not found. Please try again!" + RESET + "\n");
            }
            if (currentOrder.getIsCustomizing() != null) {
                userInput = 0;
            }
        }
    }
}
