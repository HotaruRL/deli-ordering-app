package screens;

import merch.Chips;
import merch.Drink;
import merch.Sandwich;
import utils.OrderManager;

import java.util.ArrayList;
import static utils.ColorUtils.*;

public class OrderScreen extends Screen{

    public OrderScreen(OrderManager orderManager){
        super(orderManager);

    }

    @Override
    public void display() {

        ArrayList<String> options = new ArrayList<>();
        options.add(RED + "Add" + RESET + " Sandwich");
        options.add(RED + "Add" + RESET + " Drink");
        options.add(RED + "Add" + RESET + " Chips");
        options.add(RED + "Checkout" + RESET);
        options.add(RED + "Cancel" + RESET + " Order");
        int userInput = -1;
        while (userInput != 0) {
            menuUtils.setMenu("Order Screen",options,"*","-",3);
            userInput = menuUtils.getInt("appropriate number to execute the task");
            switch (userInput) {
                case 1 -> {
                    orderManager.getCurrentOrder().addItem(new Sandwich());
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
                case 4 -> System.out.println("Checkout Screen\n");
                case 0 -> {return;}
                default -> System.out.println(RED + "Command not found. Please try again!" + RESET + "\n");
            }
        }
    }
}
