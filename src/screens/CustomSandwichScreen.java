package screens;

import merch.Sandwich;
import sandwichProperties.BreadType;
import utils.OrderManager;

import java.util.ArrayList;
import static utils.ColorUtils.*;

public class CustomSandwichScreen extends Screen{
    int currentItemIndex;
    Sandwich currentSandwich;

    public CustomSandwichScreen(OrderManager orderManager, int currentItemIndex){
        super(orderManager);
        this.currentItemIndex = currentItemIndex;
        this.currentSandwich = getCurrentSandwich(currentItemIndex);
    }

    public Sandwich getCurrentSandwich(int currentItemIndex){
        return (Sandwich) orderManager.getCurrentOrder().getLineItems().get(currentItemIndex);
    }

    @Override
    public void display() {
        // set sandwich name to custom sandwich if created from scratch
        if (currentSandwich.getSandwichName() == null){
            currentSandwich.setSandwichName("Custom Sandwich");
        }

        ArrayList<String> breadType = optionsList.getBreadScreenList();

        int userInput = -1;
        while (userInput != 0) {
            menuUtils.setMenu("1. Choose a Bread Type", breadType, " ", "-", 10);
            userInput = menuUtils.getInt("your selection");
            switch (userInput) {
                case 1 -> {
                    System.out.println("You chose "+ BreadType.WHITE.getDisplayName() + "\n");
                    currentSandwich.setBreadType(BreadType.WHITE);
                    getSandwichSize();
                }
                case 2 -> {
                    System.out.println("You chose "+ BreadType.WHEAT.getDisplayName() + "\n");
                    currentSandwich.setBreadType(BreadType.WHEAT);
                    getSandwichSize();
                }
                case 3 -> {
                    System.out.println("You chose "+ BreadType.RYE.getDisplayName() + "\n");
                    currentSandwich.setBreadType(BreadType.RYE);
                    getSandwichSize();
                }
                case 4 -> {
                    System.out.println("You chose "+ BreadType.WRAP.getDisplayName() + "\n");
                    currentSandwich.setBreadType(BreadType.WRAP);
                    getSandwichSize();
                }
                case 0 -> {return;}
                default -> System.out.println(RED + "Command not found. Please try again!" + RESET + "\n");
            }
            if (currentSandwich.getIsCustomizing() != null) {
                userInput = 0;
            }
        }
    }

    public void getSandwichSize(){
        ArrayList<String> sizeOptions = optionsList.getSizeScreenList();

        ToppingScreen toppingScreen = new ToppingScreen(orderManager, currentSandwich);
        int userInput = -1;
        while (userInput != 0) {
            menuUtils.setMenu("2. Choose a Size", sizeOptions, " ", "-", 10);
            userInput = menuUtils.getInt("your selection");
            switch (userInput) {
                case 1 -> {
                    System.out.println("You chose 4\" Small \n");
                    currentSandwich.setSandwichSize("4");
                    toppingScreen.display();
                    return;
                }
                case 2 -> {
                    System.out.println("You chose 8\" Medium \n");
                    currentSandwich.setSandwichSize("8");
                    toppingScreen.display();
                    return;
                }
                case 3 -> {
                    System.out.println("You chose 12\" Large \n");
                    currentSandwich.setSandwichSize("12");
                    toppingScreen.display();
                    return;
                }
                case 0 -> {return;}
                default -> System.out.println(RED + "Command not found. Please try again!" + RESET + "\n");
            }
        }
    }
}
