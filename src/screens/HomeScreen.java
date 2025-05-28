package screens;

import static utils.ColorUtils.*;

import utils.MenuUtils;

import java.util.ArrayList;

public class HomeScreen extends Screen{
    private MenuUtils menuUtils;

    public HomeScreen(){
        this.menuUtils = new MenuUtils();
    }
    @Override
    public void display() {
        ArrayList<String> options = new ArrayList<>();
        options.add("New Order");
        options.add("Exit");

        int userInput = -1;
        while (userInput != 0) {
            menuUtils.setMenu(options);
            userInput = menuUtils.parseInt(menuUtils.getValidatedInputString("appropriate number to execute the task"));
            switch (userInput) {
                case 1 -> System.out.println("Order Screen\n");
                case 0 -> System.out.println(MAGENTA + "Thank you for using this app! See you again!" + RESET + "\n");
                default -> System.out.println(RED + "Command not found. Please try again!" + RESET + "\n");
            }
        }
    }
}
