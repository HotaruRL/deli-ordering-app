package screens;

import merch.Sandwich;
import sandwichProperties.SelectedTopping;
import sandwichProperties.toppings.*;
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
        ArrayList<String> toppingTypeList = new ArrayList<>();
        toppingTypeList.add("Meat");
        toppingTypeList.add("Cheese");
        toppingTypeList.add("Other Toppings");
        toppingTypeList.add("Sauce");
        toppingTypeList.add("Sides");
        HashMap<String, ArrayList<String>> toppingChart = menuUtils.getToppingChart();

        int step = 3;
        for (String type : toppingTypeList) {
            ArrayList<String> list = toppingChart.get(type);
            list.add(String.format(RED + "Done" + RESET + " with adding %s", type));

            int userInput = -1;
            while (userInput != 0) {
                menuUtils.setMenu(String.format("%d. %s Options", step, type), list, " ", "-", 10);
                userInput = menuUtils.getInt("your choice");
                if (userInput == 0) {
                    break;
                } else if (userInput > 0 && userInput < list.size()) {
                    String selectedToppingName = list.get(userInput - 1);
                    Topping currentTopping = null;
                    // convert string to Topping Object
                    switch (type) {
                        case "Meat" -> currentTopping = new Meat(selectedToppingName);
                        case "Cheese" -> currentTopping = new Cheese(selectedToppingName);
                        case "Other Toppings" -> currentTopping = new OtherToppings(selectedToppingName);
                        case "Sauce" -> currentTopping = new Sauce(selectedToppingName);
                        case "Sides" -> currentTopping = new Sides(selectedToppingName);
                    }
                    SelectedTopping selectedTopping = new SelectedTopping(currentTopping, false);

                    // check if the list doesn't exist
                    if (currentSandwich.getSelectedToppings() == null) {
                        currentSandwich.setSelectedToppings(new ArrayList<>());
                        currentSandwich.addTopping(selectedTopping);
                        System.out.printf(GREEN + "%s has been successfully added!\n" + RESET, selectedTopping.getDisplayName());

                        // check if topping already added
                    } else if (currentTopping != null) {
                        SelectedTopping existingMatch = null;
                        for (int i = 0; i < currentSandwich.getSelectedToppings().size(); i++) {
                            SelectedTopping st = currentSandwich.getSelectedToppings().get(i);

                            if (st.getTopping().getToppingName().equalsIgnoreCase(selectedToppingName)) {
                                existingMatch = st;
                                break;
                            }
                        }
                        if (existingMatch != null) {
                            // if already added, ask if guest wants to add extra
                            if (!existingMatch.isExtra()) {
                                ArrayList<String> addExtra = new ArrayList<>();
                                addExtra.add(String.format(RED + "Add" + RESET + " Extra" + BLUE + " %s" + RESET, selectedToppingName));
                                addExtra.add(RED + "Skip" + RESET);
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
                            currentSandwich.addTopping(selectedTopping);
                            System.out.printf(GREEN + "%s has been successfully added!\n" + RESET, selectedTopping.getDisplayName());
                        }
                    } else {
                        System.out.println(RED + "Command not found. Please try again!" + RESET + "\n");
                    }
                }else if (userInput >= list.size()) {
                    System.out.println(RED + "Command not found. Please try again!" + RESET + "\n");
                }
            }
            // only update step number once user is done with a section, so that each topping type has a static number in front
            step++;
        }
        getSandwichToasted();
    }

    public void getSandwichToasted(){
        ArrayList<String> toasted = new ArrayList<>();
        toasted.add(RED + "Toast" + RESET + " It");
        toasted.add(RED + "DON'T" + RESET + " Toast It");

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
        menuUtils.confirmAdd(currentSandwich);
        currentSandwich.setIsCustomizing("done");
    }
}