package screens;

import merch.Drink;
import utils.OrderManager;

import java.util.ArrayList;

import static utils.ColorUtils.*;

public class DrinkScreen extends Screen{
    int currentItemIndex;
    Drink currentDrink;
    boolean isGoBack = false;

    public DrinkScreen(OrderManager orderManager, int currentItemIndex) {
        super(orderManager);
        this.currentItemIndex = currentItemIndex;
        this.currentDrink = getCurrentDrink(currentItemIndex);
    }

    public Drink getCurrentDrink(int currentItemIndex){
        return (Drink) orderManager.getCurrentOrder().getLineItems().get(currentItemIndex);
    }

    @Override
    public void display() {
        // load the drinks list
        ArrayList<String> drinkList = menuUtils.getDrinkList();
        // add the option to go back
        drinkList.add(RED + "Go" + RESET + " back");

        int userInput = -1;
        while (userInput != 0) {
            //reset flag
            isGoBack = false;
            //create menu
            menuUtils.setMenu("1. Drink Flavor Options", drinkList, " ", "-", 10);
            // prompt to get user input
            userInput = menuUtils.getInt("your selection");
            // user wants to go back
            if (userInput == 0) {
                return;
            // input is within range of options
            } else if (userInput > 0 && userInput < drinkList.size()) {
                String selectedDrink = drinkList.get(userInput - 1);
                // set the currentDrink object's name with the selected name
                currentDrink.setDrinkName(selectedDrink);
                System.out.printf(GREEN + "%s has been selected!\n" + RESET, currentDrink.getDrinkName());
                chooseDrinkSize();
                if (isGoBack){
                    continue;
                }
                chooseDrinkQuantity();
            } else {
                System.out.println(RED + "Invalid option. Please try again!" + RESET);
            }
            if (currentDrink.getIsCustomizing() != null){
                userInput = 0;
            }
        }
        menuUtils.showDetails(currentDrink);
        System.out.println(String.format(GREEN+"\nThe item above has been successfully added to your order!\n"+RESET));
    }

    public void chooseDrinkSize(){
        ArrayList<String> drinkSize = optionsList.getDrinkSizeScreenList();


        int userInput = -1;
        while (userInput != 0) {
            menuUtils.setMenu("2. Drink Size Options",drinkSize," ","-",10);
            userInput = menuUtils.getInt("your selection");
            switch (userInput) {
                case 1 -> {
                    currentDrink.setSize("Small");
                    return;
                }
                case 2 -> {
                    currentDrink.setSize("Medium");
                    return;
                }
                case 3 -> {
                    currentDrink.setSize("Large");
                    return;
                }
                case 0 -> {
                    isGoBack = true;
                    return;
                }
                default -> System.out.println(RED + "Invalid option. Please try again!" + RESET + "\n");
            }
        }
        System.out.printf(GREEN + "%s has been selected!\n" + RESET, currentDrink.getSize());
    }

    public void chooseDrinkQuantity(){
        int maxQuantity = 30;
        ArrayList<String> drinkQuantity = optionsList.getDrinkQuantityScreenList();

        int userInput = -1;
        while (userInput != 0) {
            menuUtils.setMenu("3. Drink Quantity Options",drinkQuantity," ","-",10);
            userInput = menuUtils.getInt("your choice");
            switch (userInput) {
                case 1 -> {
                    currentDrink.setQuantity(1);
                    userInput = 0;
                }
                case 2 -> {
                    currentDrink.setQuantity(6);
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
                        }else if (0 < quantity && quantity< maxQuantity) {
                            currentDrink.setQuantity(quantity);
                            userIn = 0;
                        } else {
                            System.out.printf(RED + "Invalid quantity.\nPlease enter amount from 1 to %d !" + RESET + "\n%n", maxQuantity);
                        }
                    }
                    userInput = 0;
                }
                case 0 -> {return;}
                default -> System.out.println(RED + "Invalid option. Please try again!" + RESET + "\n");
            }
        }
        // flag currentDrink done with customizing to exit outermost while loop
        currentDrink.setIsCustomizing("done");
    }
}