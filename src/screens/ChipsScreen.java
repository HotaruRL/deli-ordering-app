package screens;

import merch.Chips;
import utils.OrderManager;

import java.util.ArrayList;

import static utils.ColorUtils.*;

public class ChipsScreen extends Screen {
    int currentItemIndex;
    Chips currentChip;
    boolean isGoBack = false;

    public ChipsScreen(OrderManager orderManager, int currentItemIndex) {
        super(orderManager);
        this.currentItemIndex = currentItemIndex;
        this.currentChip = getCurrentChip(currentItemIndex);
    }

    public Chips getCurrentChip(int currentItemIndex) {
        return (Chips) orderManager.getCurrentOrder().getLineItems().get(currentItemIndex);
    }

    @Override
    public void display() {
        // load the chips list
        ArrayList<String> chipsList = menuUtils.getChipsList();
        // add the option to go back
        chipsList.add(RED + "Go" + RESET + " back");

        int userInput = -1;
        while (userInput != 0) {
            //reset flag
            isGoBack = false;
            //create menu
            menuUtils.setMenu("1. Chips Options", chipsList, " ", "-", 10);
            // prompt to get user input
            userInput = menuUtils.getInt("your selection");
            // user wants to go back
            if (userInput == 0) {
                return;
                // input is within range of options
            } else if (userInput > 0 && userInput < chipsList.size()) {
                String selectedChips = chipsList.get(userInput - 1);
                // set the currentChip object's name with the selected name
                currentChip.setChipName(selectedChips);
                System.out.printf(GREEN + "%s has been selected!\n" + RESET, currentChip.getChipName());
                chooseChipQuantity();
                if (isGoBack) {
                    continue;
                }
            } else {
                System.out.println(RED + "Invalid option. Please try again!" + RESET);
            }
            if (currentChip.getIsCustomizing() != null) {
                userInput = 0;
            }
        }
        menuUtils.showDetails(currentChip);
        System.out.println(String.format(GREEN + "\nThe item above has been successfully added to your order!\n" + RESET));
    }

    public void chooseChipQuantity() {
        int maxQuantity = 30;

        ArrayList<String> drinkQuantity = new ArrayList<>();
        drinkQuantity.add("Just" + RED + " 01" + RESET + " Bag");
        drinkQuantity.add("Give me" + RED + " 02" + RESET + " Bags");
        drinkQuantity.add(RED + "Enter" + RESET + " Custom Amount");
        drinkQuantity.add(RED + "Go" + RESET + " back");

        int userInput = -1;
        while (userInput != 0) {
            menuUtils.setMenu("2. Chips Quantity Options", drinkQuantity, " ", "-", 10);
            userInput = menuUtils.getInt("your choice");
            switch (userInput) {
                case 1 -> {
                    currentChip.setQuantity(1);
                    userInput = 0;
                }
                case 2 -> {
                    currentChip.setQuantity(2);
                    userInput = 0;
                }
                case 3 -> {
                    int quantity = -1;
                    int userIn = -1;
                    while (userIn != 0) {
                        userIn = menuUtils.getInt(String.format("your quantity (1 - %d)", maxQuantity));
                        quantity = userIn;
                        if (userIn == 0) {
                            return;
                        } else if (0 < quantity && quantity < maxQuantity) {
                            currentChip.setQuantity(quantity);
                            userIn = 0;
                        } else {
                            System.out.printf(RED + "Invalid quantity.\nPlease enter amount from 1 to %d !" + RESET + "\n%n", maxQuantity);
                        }
                    }
                    userInput = 0;
                }
                case 0 -> {
                    return;
                }
                default -> System.out.println(RED + "Invalid option. Please try again!" + RESET + "\n");
            }
        }
        // flag currentDrink done with customizing to exit outermost while loop
        currentChip.setIsCustomizing("done");
    }
}

