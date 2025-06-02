package screens;
import merch.Sandwich;
import utils.OrderManager;

import java.util.ArrayList;
import static utils.ColorUtils.*;

public class SandwichScreen extends Screen{
    int currentItemIndex;
    Sandwich currentSandwich;

    public SandwichScreen(OrderManager orderManager, int currentItemIndex){
        super(orderManager);
        this.currentItemIndex = currentItemIndex;
        this.currentSandwich = getCurrentSandwich(currentItemIndex);
    }

    public Sandwich getCurrentSandwich(int currentItemIndex){
        return (Sandwich) orderManager.getCurrentOrder().getLineItems().get(currentItemIndex);
    }

    @Override
    public void display() {
        ArrayList<String> list = optionsList.getSandwichScreenList();

        int userInput = -1;
        while (userInput != 0) {
            menuUtils.setMenu("Sandwich Ordering Screen",list,"*","-",3);
            userInput = menuUtils.getInt("your choice");
            switch (userInput) {
                case 1 -> {
                    CustomSandwichScreen customSandwichScreen = new CustomSandwichScreen(orderManager, currentItemIndex);
                    customSandwichScreen.display();
                }
                case 2 -> {
                    SignatureSandwichScreen signatureSandwichScreen = new SignatureSandwichScreen(orderManager, currentItemIndex);
                    signatureSandwichScreen.display();
                }
                case 0 -> {return;}
                default -> System.out.println(RED + "Command not found. Please try again!" + RESET + "\n");
            }
            if (currentSandwich.getIsCustomizing() != null){
                userInput = 0;
            }
        }
    }
}
