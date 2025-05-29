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
        ArrayList<String> breadType = new ArrayList<>();
        breadType.add(BreadType.WHITE.getDisplayName());
        breadType.add(BreadType.WHEAT.getDisplayName());
        breadType.add(BreadType.RYE.getDisplayName());
        breadType.add(BreadType.WRAP.getDisplayName());
        breadType.add(RED + "Go" + RESET + " back");

        int userInput = -1;
        while (userInput != 0) {
            menuUtils.setMenu("1. Choose a Bread Type", breadType, " ", "-", 10);
            userInput = menuUtils.getInt("your selection");
            switch (userInput) {
                case 1 -> {
                    System.out.println("You chose "+ BreadType.WHITE.getDisplayName() + "\n");
                    currentSandwich.setBreadType(BreadType.WHITE);
                }
                case 2 -> {
                    System.out.println("You chose "+ BreadType.WHEAT.getDisplayName() + "\n");
                    currentSandwich.setBreadType(BreadType.WHEAT);
                }
                case 3 -> {
                    System.out.println("You chose "+ BreadType.RYE.getDisplayName() + "\n");
                    currentSandwich.setBreadType(BreadType.RYE);
                }
                case 4 -> {
                    System.out.println("You chose "+ BreadType.WRAP.getDisplayName() + "\n");
                    currentSandwich.setBreadType(BreadType.WRAP);
                }
                case 0 -> {return;}
                default -> System.out.println(RED + "Command not found. Please try again!" + RESET + "\n");
            }
            getSandwichSize();
        }
    }

    public void getSandwichSize(){
        ArrayList<String> sizeOptions = new ArrayList<>();
        sizeOptions.add(RED + "4\"" + RESET + " Small");
        sizeOptions.add(RED + "8\"" + RESET + " Medium");
        sizeOptions.add(RED + "12\"" + RESET + " Large");
        sizeOptions.add(RED + "Go" + RESET + " back");
        ToppingScreen toppingScreen = new ToppingScreen(orderManager, currentSandwich);
        int userInput = -1;
        while (userInput != 0) {
            menuUtils.setMenu("2. Choose a Size", sizeOptions, " ", "-", 10);
            userInput = menuUtils.getInt("your selection");
            switch (userInput) {
                case 1 -> {
                    System.out.println("You chose 4\" Small \n");
                    currentSandwich.setSandwichSize("4");
                }
                case 2 -> {
                    System.out.println("You chose 8\" Medium \n");
                    currentSandwich.setSandwichSize("8");
                }
                case 3 -> {
                    System.out.println("You chose 12\" Large \n");
                    currentSandwich.setSandwichSize("12");
                }
                case 0 -> {return;}
                default -> System.out.println(RED + "Command not found. Please try again!" + RESET + "\n");
            }
            toppingScreen.display();
        }
    }

}
