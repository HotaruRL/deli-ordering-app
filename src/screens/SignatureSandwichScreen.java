package screens;

import merch.Sandwich;
import utils.OrderManager;

import java.util.ArrayList;
import java.util.HashMap;

import static utils.ColorUtils.*;

public class SignatureSandwichScreen extends Screen {
    int currentItemIndex;
    Sandwich currentSandwich;

    public SignatureSandwichScreen(OrderManager orderManager, int currentItemIndex) {
        super(orderManager);
        this.currentItemIndex = currentItemIndex;
        this.currentSandwich = getCurrentSandwich(currentItemIndex);
    }

    public Sandwich getCurrentSandwich(int currentItemIndex) {
        return (Sandwich) orderManager.getCurrentOrder().getLineItems().get(currentItemIndex);
    }

    @Override
    public void display() {
        // load the signature sandwich list
        HashMap<String, HashMap<String, String>> signatureSandwichList = menuUtils.getSignatureSandwichChart();
        // get ArrayList of just the sandwich names
        ArrayList<String> sandwichNames = menuUtils.getSandwichName();
        // add the option to go back
        sandwichNames.add(RED + "Go" + RESET + " back");

        // flag to show confirmation if not customize it
        boolean flag = false;

        int userInput = -1;
        while (userInput != 0) {
            //create menu
            menuUtils.setMenu("1. Signature Sandwich Options", sandwichNames, " ", "-", 10);
            // prompt to get user input
            userInput = menuUtils.getInt("your selection");
            // user wants to go back
            if (userInput == 0) {
                return;
                // input is within range of options
            } else if (userInput > 0 && userInput < sandwichNames.size()) {
                String selectedSandwich = sandwichNames.get(userInput - 1); // index of selected option is less than 1 the number shown
                HashMap<String, String> propertiesOnList = signatureSandwichList.get(selectedSandwich); // properties on the list of selected sandwich
                // get sandwich properties from hashmap
                String sandwichSize = propertiesOnList.get("sandwichSize");
                String sandwichBread = propertiesOnList.get("breadType");
                String isToasted = propertiesOnList.get("isToasted");
                String selectedToppings = propertiesOnList.get("selectedToppings");


                // set current Sandwich object's properties
                currentSandwich.setSandwichName(selectedSandwich);
                currentSandwich.setSandwichSize(sandwichSize);
                currentSandwich.setBreadType(menuUtils.convertToBreadType(sandwichBread));
                currentSandwich.setToasted(menuUtils.convertToBoolean(isToasted));
                menuUtils.processToppingList(currentSandwich, selectedToppings);


                System.out.printf(GREEN + "The %s above has been selected!\n" + RESET, currentSandwich.getSandwichName());
                menuUtils.showDetails(currentSandwich);
                ArrayList<String> customize = optionsList.promptCustomize();
                userInput = -1;
                while (userInput != -2) {
                    menuUtils.setMenu("Customize?", customize, " ", "-", 10);
                    System.out.printf(BLUE + "Would you like to customize it?" + RESET);
                    userInput = menuUtils.getInt("your choice");
                    switch (userInput) {
                        case 1 -> {
                            CustomSandwichScreen customSandwichScreen = new CustomSandwichScreen(orderManager, currentItemIndex);
                            customSandwichScreen.display();
                            flag = true;
                            userInput = -2;
                        }
                        case 0 -> {
                            userInput = -2;
                            currentSandwich.setIsCustomizing("done");
                        }
                        default -> System.out.println(RED + "Command not found. Please try again!" + RESET + "\n");
                    }
                }
            } else {
                System.out.println(RED + "Invalid option. Please try again!" + RESET);
            }
            if (currentSandwich.getIsCustomizing() != null) {
                userInput = 0;
            }
        }
        if (!flag) {
            menuUtils.showDetails(currentSandwich);
            System.out.printf(GREEN + "\nThe item above has been successfully added to your order!\n" + RESET);
        }
    }
}
