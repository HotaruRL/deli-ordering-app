package screens;

import merch.Sandwich;
import sandwichProperties.SelectedTopping;
import utils.OrderManager;

import java.util.ArrayList;
import java.util.HashMap;

import static utils.ColorUtils.*;

public class ToppingScreen extends Screen {
    Sandwich currentSandwich;

    public ToppingScreen(OrderManager orderManager, Sandwich currentSandwich) {
        super(orderManager);
        this.currentSandwich = currentSandwich;
    }


    @Override
    public void display() {
        // list of topping types as keys to get the list of options for such types + names for menu
        ArrayList<String> toppingTypeList = optionsList.getToppingTypeList();
        // get Hashmap of topping types and their list of options
        HashMap<String, ArrayList<String>> toppingChart = menuUtils.getToppingChart();

        // step number to add in front of each topping type
        int step = 3;

        // go through the topping types one by one
        for (String type : toppingTypeList) {
            // get the list of options from the current topping type
            ArrayList<String> list = toppingChart.get(type);
            // add the option to move to the next topping type
            list.add(String.format(RED + "Done" + RESET + " with adding %s", type));

            // create menu for the current topping type and a list of its options
            // process user input
            // only move on to the next topping type when user is done with the current type
            // TODO: fix auto moving on to next type when choosing the option that has already had an extra added
            // TODO: check the else and else-if at the end
            int userInput = -1;
            while (userInput != 0) {
                //create menu
                menuUtils.setMenu(String.format("%d. %s Options", step, type), list, " ", "-", 10);
                // prompt to get user input
                userInput = menuUtils.getInt("your choice");
                // user is done with current type
                if (userInput == 0) {
                    break;
                // input is within range of options
                } else if (userInput > 0 && userInput < list.size()) {
                    String selectedToppingName = list.get(userInput - 1); // index of selected option is less than 1 the number shown

                    SelectedTopping selectedTopping = menuUtils.convertToSelectedTopping(type, selectedToppingName);
                    // check if the sandwich's list of SelectedToppings has been created or not
                    // if not create it and add the new selectedTopping above onto the list
                    if (currentSandwich.getSelectedToppings() == null) {
                        currentSandwich.setSelectedToppings(new ArrayList<>());
                        currentSandwich.addTopping(selectedTopping);
                        System.out.printf(GREEN + "%s has been successfully added!\n" + RESET, selectedTopping.getDisplayName());
                    } else{
                        // list of SelectedToppings has been created
                        // empty object of the possibly existed SelectedTopping
                        SelectedTopping existingMatch = null;
                        // go through each SelectedTopping that currentSandwich has
                        for (int i = 0; i < currentSandwich.getSelectedToppings().size(); i++) {
                            // SelectedTopping currently picked on to compare
                            SelectedTopping st = currentSandwich.getSelectedToppings().get(i);
                            // Compare + if found already existed set it to empty object created above + stop looking, comparing
                            if (st.getTopping().getToppingName().equalsIgnoreCase(selectedToppingName)) {
                                existingMatch = st;
                                break;
                            }
                        }
                        // if found already existed
                        if (existingMatch != null) {
                            // if it is not already EXTRA, ask if guest wants to add extra
                            if (!existingMatch.isExtra()) {
                                // get options for the prompt
                                ArrayList<String> addExtra = optionsList.promptAddExtra(selectedToppingName);

                                userInput = -1;
                                while (userInput != -2) {
                                    menuUtils.setMenu("Add Extra Topping?", addExtra, " ", "-", 10);
                                    System.out.printf(BLUE + "'%s' is already added. Would you like to make it extra?%n" + RESET, selectedToppingName);
                                    userInput = menuUtils.getInt("your selection");
                                    switch (userInput) {
                                        case 1 -> {
                                            existingMatch.setExtra(true);
                                            currentSandwich.addTopping(selectedTopping);
                                            System.out.printf(GREEN + "%s has been successfully added!\n" + RESET, selectedTopping.getDisplayName());
                                            userInput = -2;
                                        }
                                        case 0 ->{
                                            System.out.printf(RED + "%s has been skipped!\n" + RESET, selectedToppingName);
                                            userInput = -2;
                                        }
                                        default -> System.out.println(RED + "Command not found. Please try again!" + RESET + "\n");
                                    }
                                }
                            } else {
                                // It exists and IS ALREADY extra.
                                System.out.printf(BLUE + "'%s' is already added as extra.\n" + RESET, selectedToppingName);
                            }
                        } else {
                            // It is NOT already existed. Add it
                            currentSandwich.addTopping(selectedTopping);
                            System.out.printf(GREEN + "%s has been successfully added!\n" + RESET, selectedTopping.getDisplayName());
                        }
                    }
                }else if (userInput >= list.size()) { // input is out of range
                    System.out.println(RED + "Command not found. Please try again!" + RESET + "\n");
                }
            }
            // only update step number once user is done with a section, so that each topping type has a static number in front
            step++;
        }
        getSandwichToasted();
    }

    public void getSandwichToasted(){
        ArrayList<String> toasted = optionsList.getToastedScreenList();

        int userInput = -1;
        while (userInput != -2) {
            menuUtils.setMenu("8. Toast the Bread?",toasted," ","-",10);
            userInput = menuUtils.getInt("your selection");
            switch (userInput) {
                case 1 -> {
                    currentSandwich.setToasted(true);
                    userInput = -2;
                }
                case 0 -> {
                    currentSandwich.setToasted(false);
                    userInput = -2;
                }
                default -> System.out.println(RED + "Command not found. Please try again!" + RESET + "\n");
            }
        }
        menuUtils.showDetails(currentSandwich);
        System.out.println(String.format(GREEN+"\nThe item above has been successfully added to your order!\n"+RESET));
        currentSandwich.setIsCustomizing("done");
    }
}