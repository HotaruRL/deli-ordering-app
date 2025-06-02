package screens;

import utils.OrderManager;

import static utils.ColorUtils.*;

import java.util.ArrayList;

public class HomeScreen extends Screen {
    private OrderScreen orderScreen;

    public HomeScreen(OrderManager orderManager) {
        super(orderManager);
    }

    @Override
    public void display() {
        ArrayList<String> list = optionsList.getHomeScreenList();

        int userInput = -1;
        while (userInput != 0) {
            menuUtils.setMenu("Home Screen", list, "*", "-", 3);
            userInput = menuUtils.getInt("appropriate number to execute the task");
            switch (userInput) {
                case 1 -> {
                    orderManager.createNewOrder();
                    this.orderScreen = new OrderScreen(orderManager, orderManager.getCurrentOrder());
                    orderScreen.display();
                }
                case 0 -> {
                    return;
                }
                default -> System.out.println(RED + "Command not found. Please try again!" + RESET + "\n");
            }
        }
    }
}
