package screens;

import static utils.ColorUtils.*;

import utils.MenuUtils;

import java.util.ArrayList;

public class HomeScreen extends Screen{
    private MenuUtils menuUtils;
    private OrderScreen orderScreen;

    public HomeScreen(){
        this.menuUtils = new MenuUtils();
        this.orderScreen = new OrderScreen();
    }
    @Override
    public void display() {
        ArrayList<String> options = new ArrayList<>();
        options.add(RED + "New" + RESET + " Order");
        options.add(RED + "Exit" + RESET);

        int userInput = -1;
        while (userInput != 0) {
            menuUtils.setMenu("Home Screen", options);
            userInput = menuUtils.parseInt(menuUtils.getValidatedInputString("appropriate number to execute the task"));
            switch (userInput) {
                case 1 -> orderScreen.display();
                case 0 -> System.out.println(MAGENTA + "Thank you for using this app! See you again!" + RESET + "\n");
                default -> System.out.println(RED + "Command not found. Please try again!" + RESET + "\n");
            }
        }
    }
}
