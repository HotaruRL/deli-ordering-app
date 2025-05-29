package screens;
import utils.OrderManager;

import java.util.ArrayList;
import static utils.ColorUtils.*;

public class SandwichScreen extends Screen{
    int currentItemIndex;

    public SandwichScreen(OrderManager orderManager, int currentItemIndex){
        super(orderManager);
        this.currentItemIndex = currentItemIndex;
    }

    @Override
    public void display() {
        ArrayList<String> signatureOrCustom = new ArrayList<>();
        signatureOrCustom.add(RED + "Custom" + RESET + " Sandwich");
        signatureOrCustom.add(RED + "Signature" + RESET + " Sandwich");
        signatureOrCustom.add(RED + "Go" + RESET + " back");

        int userInput = -1;
        while (userInput != 0) {
            menuUtils.setMenu("Sandwich Ordering Screen",signatureOrCustom,"*","-",3);
            userInput = menuUtils.getInt("your choice");
            switch (userInput) {
                case 1 -> {
                    CustomSandwichScreen customSandwichScreen = new CustomSandwichScreen(orderManager,currentItemIndex);
                    customSandwichScreen.display();
                }
                case 2 -> System.out.println("Signature Sandwich Order Screen\n");
                case 0 -> {return;}
                default -> System.out.println(RED + "Command not found. Please try again!" + RESET + "\n");
            }
            userInput = 0;
        }
    }
}
