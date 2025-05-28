package screens;

import utils.MenuUtils;

import java.util.ArrayList;

import static utils.ColorUtils.*;

public class OrderScreen extends Screen{
    private MenuUtils menuUtils;

    public OrderScreen(){
        this.menuUtils = new MenuUtils();
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
            menuUtils.setMenu("Order Screen", options);
            userInput = menuUtils.parseInt(menuUtils.getValidatedInputString("appropriate number to execute the task"));
            switch (userInput) {
                case 1 -> System.out.println("Sandwich Order Screen\n");
                case 2 -> System.out.println("Drink Order Screen\n");
                case 3 -> System.out.println("Chips Order Screen\n");
                case 4 -> System.out.println("Checkout Screen\n");
                case 0 -> {return;}
                default -> System.out.println(RED + "Command not found. Please try again!" + RESET + "\n");
            }
        }
    }
}
