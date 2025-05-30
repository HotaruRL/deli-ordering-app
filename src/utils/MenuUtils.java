package utils;

import merch.LineItem;
import merch.Sandwich;
import sandwichProperties.BreadType;
import sandwichProperties.SelectedTopping;
import sandwichProperties.toppings.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static utils.ColorUtils.*;

public class MenuUtils {
    private static final String CHIPS_LIST_FILE_PATH = "internalUse\\chipsFlavor.csv";
    private static final String DRINKS_LIST_FILE_PATH = "internalUse\\drinkFlavor.csv";
    private static final String TOPPINGS_LIST_FILE_PATH = "internalUse\\toppingList.csv";
    private static final String SIGNATURE_LIST_FILE_PATH = "internalUse\\signatureSandwichList.csv";
    private FileUtils fileUtils;
    private TextUtils textUtils;
    private Scanner scanner;

    public MenuUtils() {
        this.fileUtils = new FileUtils();
        this.textUtils = new TextUtils();
        this.scanner = new Scanner(System.in);
    }

    // get the index of newly added item for the purpose of getting correct item to modify
    public int getIndexOfLastItem(ArrayList<LineItem> list) {
        return list.size() - 1;
    }

    // create an ArrayList of chips flavors
    public ArrayList<String> getChipsList() {
        return fileUtils.parse1Line(CHIPS_LIST_FILE_PATH);
    }

    // create an ArrayList of drink flavors
    public ArrayList<String> getDrinkList() {
        return fileUtils.parse1Line(DRINKS_LIST_FILE_PATH);
    }

    // create a hashmap of topping types and their list of options
    public HashMap<String, ArrayList<String>> getToppingChart() {
        return fileUtils.loadList(TOPPINGS_LIST_FILE_PATH);
    }

    // create a hashmap of signature sandwiches and their list of options
    public HashMap<String, HashMap<String, String>> getSignatureSandwichChart() {
        return fileUtils.parseMultipleColumns(SIGNATURE_LIST_FILE_PATH);
    }

    // create an ArrayList of just topping types from the hashmap of types and their list of options
    public ArrayList<String> getSandwichName() {
        return fileUtils.getJustKeys(getSignatureSandwichChart());
    }

    public BreadType convertToBreadType(String input) {
        if (input == null) {
            System.out.println(RED + "Input name is null" + RESET);
            return null;
        }
        for (BreadType type : BreadType.values()) {
            if (type.getPlainName().equalsIgnoreCase(input.trim())) {
                return type;
            }
        }
        System.out.println(RED + "No BreadType found for the name: " + RESET + input);
        return null;
    }

    public boolean convertToBoolean(String input) {
        if (input == null) {
            System.out.println(RED + "Input is null. Default return as false" + RESET);
            return false;
        }
        String processedInput = input.trim().toLowerCase();

        return switch (processedInput) {
            case "true", "yes", "y", "1" -> true;
            case "false", "no", "n", "0" -> false;
            default -> {
                System.out.println(RED + "Input is null. Default return as false" + RESET);
                yield false;
            }
        };
    }

    // convert String to SelectedTopping object
    public SelectedTopping convertToSelectedTopping(String toppingType, String toppingName) {
        Topping toppingObject = null; // create an empty Topping object to modify
        // convert empty Topping Object to the appropriate toppingType based on the string name toppingType provided
        // add provided toppingName to its name
        switch (toppingType) {
            case "Meat" -> toppingObject = new Meat(toppingName);
            case "Cheese" -> toppingObject = new Cheese(toppingName);
            case "Other Toppings" -> toppingObject = new OtherToppings(toppingName);
            case "Sauce" -> toppingObject = new Sauce(toppingName);
            case "Sides" -> toppingObject = new Sides(toppingName);
        }
        // convert current topping object into SelectedTopping object (non-extra)
        return new SelectedTopping(toppingObject, false);
    }

    public SelectedTopping findToppingType(String nameToLookUp, HashMap<String, ArrayList<String>> toppingChart) {
        Topping toppingObject = null;
        if (nameToLookUp == null || toppingChart == null) {
            return null;
        }
        String processedName = nameToLookUp.trim().toLowerCase();

        // go through each entry of toppingChart
        for (Map.Entry<String, ArrayList<String>> entry : toppingChart.entrySet()) {
            // get the current Topping Type
            String toppingType = entry.getKey();
            // list of options of current Topping Type
            ArrayList<String> options = entry.getValue();
            // if options list is not empty
            if (options != null) {
                // compare to each option in that list
                for (String option : options) {
                    if (option.trim().toLowerCase().equals(processedName)) {
                        switch (toppingType) {
                            case "Meat" -> toppingObject = new Meat(option);
                            case "Cheese" -> toppingObject = new Cheese(option);
                            case "Other Toppings" -> toppingObject = new OtherToppings(option);
                            case "Sauce" -> toppingObject = new Sauce(option);
                            case "Sides" -> toppingObject = new Sides(option);
                        }
                        return new SelectedTopping(toppingObject, false);
                    }
                }
            }
        }
        // options list is empty or none match
        return null;
    }

    public void processToppingList(Sandwich currentsandwich, String toppings) {
        String[] toppingsList = toppings.trim().split(",");
        currentsandwich.setSelectedToppings(new ArrayList<>());
        for (String topping : toppingsList) {
            SelectedTopping toppingToAdd = findToppingType(topping, getToppingChart());
            currentsandwich.addTopping(toppingToAdd);
        }
    }

    // create a menu with options autopopulated and numbered from an ArrayList (the last item is numbered with [0])
    public void setMenu(String menuName, ArrayList<String> options, String bordersChars, String paddingChars, int paddingLength) {
        int optionNumber = 1;
        StringBuilder output = new StringBuilder();
        String header = textUtils.headerWithPadding(menuName, bordersChars, paddingChars, paddingLength);
        output.append(header).append("\n");
        for (String s : options) {
            if (!s.equals(options.getLast())) {
                output.append(String.format("%-10s[" + BLUE + "%d" + RESET + "] %s", "", optionNumber, s)).append("\n");
                optionNumber++;
            } else {
                output.append(String.format("%-10s[" + BLUE + "%d" + RESET + "] %s", "", 0, s)).append("\n");
            }
        }
        System.out.println(output);
    }

    // prompt the user to enter a value for the provided fieldName and check if the input is empty or not
    public String getString(String fieldName) {
        String userInput = "";
        while (userInput.isEmpty()) {
            System.out.printf("Please enter the %s: ", fieldName);
            userInput = scanner.nextLine().trim();
        }
        return userInput;
    }

    // user the getString to prompt the user to enter a value
    // parse the string input into an Integer + reprompt if user input cannot be parsed
    public Integer getInt(String fieldName) {
        Integer userInput = null;
        while (userInput == null) {
            String text = getString(fieldName);
            try {
                userInput = Integer.parseInt(text);
            } catch (Exception e) {
                System.out.println(RED + "Invalid Input! Please try again!" + RESET);
            }
        }
        return userInput;
    }

    // user the getString to prompt the user to enter a value
    // parse the string input into an Double + reprompt if user input cannot be parsed
    public Double getDouble(String fieldName) {
        Double userInput = null;
        while (userInput == null) {
            String text = getString(fieldName);
            try {
                userInput = Double.parseDouble(text);
            } catch (Exception e) {
                System.out.println(RED + "Invalid Input! Please try again!" + RESET);
            }
        }
        return userInput;
    }

    // show confirmation with the added item's details
    public void showDetails(LineItem item) {
        StringBuilder confirmation = new StringBuilder();
        int LINE_WIDTH = 60;
        String SPACE = " ";
        String itemDescription = item.getReceiptDetails();
        String itemPrice = String.format("$%.2f", item.getPrice());
        String itemUnitPrice = String.format("$%.2f/ea", item.getUnitPrice());
        String itemQuantity = String.format("  x%d", item.getQuantity());

        // to calculate the space between description and price
        int descriptionLength = itemDescription.length();
        int priceLength = itemPrice.length();
        int spaceNeeded = LINE_WIDTH - (descriptionLength + priceLength);
        // make sure to have at least 1 space between description and price
        if (spaceNeeded < 1) {
            spaceNeeded = 1;
        }

        confirmation.append(String.format("%s%s\n",
                itemDescription,
                SPACE.repeat(spaceNeeded)));

        // to calculate the space between unit price + quantity and price
        String indent = SPACE.repeat(3);
        int unitPriceLength = itemUnitPrice.length();
        int quantityLength = itemQuantity.length();
        int spaceNeeded2 = LINE_WIDTH - (unitPriceLength + quantityLength + priceLength);
        confirmation.append(String.format("%s%s%s%s%s\n",
                indent,
                itemUnitPrice,
                itemQuantity,
                SPACE.repeat(spaceNeeded2),
                itemPrice));

        // if item is a sandwich, add additional details
        if (item instanceof Sandwich) {
            for (String detail : ((Sandwich) item).getAdditionDetails(false)) {
                if (detail == null) {
                    continue;
                }
                confirmation.append(indent).append(detail).append("\n");
            }
        }
        // add a line break after each line item
        confirmation.append("\n");

        System.out.println(confirmation);
    }
}
