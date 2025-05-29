package utils;

import merch.LineItem;
import merch.Sandwich;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static utils.ColorUtils.*;

public class MenuUtils {
    private static final String DRINKS_LIST_FILE_PATH = "internalUse\\drinkFlavor.csv";
    private static final String TOPPINGS_LIST_FILE_PATH = "internalUse\\toppingList.csv";
    private FileUtils fileUtils;
    private TextUtils textUtils;
    private Scanner scanner;

    public MenuUtils(){
        this.fileUtils = new FileUtils();
        this.textUtils = new TextUtils();
        this.scanner = new Scanner(System.in);
    }

    // show confirmation with the added item's details
    public void confirmAdd(LineItem item){
        StringBuilder confirmation = new StringBuilder();
        int LINE_WIDTH = 40;
        String SPACE = " ";

        String itemDescription = item.getReceiptDetails();
        String itemPrice = String.format("$%.2f", item.calculateUnitPrice());

        // to calculate the space between description and price
        int descriptionLength = itemDescription.length();
        int priceLength = itemPrice.length();
        int spaceNeeded = LINE_WIDTH - (descriptionLength + priceLength);
        // make sure to have at least 1 space between description and price
        if (spaceNeeded < 1){
            spaceNeeded = 1;
        }

        confirmation.append(String.format("%s%s%s\n",
                itemDescription,
                SPACE.repeat(spaceNeeded),
                itemPrice));

        // if item is a sandwich, add additional details
        if (item instanceof Sandwich){
            for (String detail : ((Sandwich) item).getAdditionDetails()){
                if (detail == null){
                    continue;
                }
                confirmation.append(detail).append("\n");
            }
        }
        // add a line break after each line item
        confirmation.append("\n");

        System.out.println(String.format(GREEN+"\nThe following item has been successfully added to your order!\n"+RESET+confirmation));
    }

    // get the index of newly added item for the purpose of getting correct item to modify
    public int getIndexOfLastItem(ArrayList<LineItem> list){
        return list.size() - 1;
    }

    // create an ArrayList of drink flavors
    public ArrayList<String> getDrinkList(){
        return fileUtils.parse1Line(DRINKS_LIST_FILE_PATH);
    }

    // create a hashmap of topping types and their list of options
    public HashMap<String, ArrayList<String>> getToppingChart(){
        return fileUtils.loadList(TOPPINGS_LIST_FILE_PATH);
    }

    // create an ArrayList of just topping types from the hashmap of types and their list of options
    public ArrayList<String> getToppingTypeList(){
        ArrayList<String> toppingTypeList = new ArrayList<>();
        for (HashMap.Entry<String, ArrayList<String>> entry : fileUtils.loadList(TOPPINGS_LIST_FILE_PATH).entrySet()) {
            String type = entry.getKey();
            toppingTypeList.add(type);
        }
        return toppingTypeList;
    }

    // create a menu with options autopopulated and numbered from an ArrayList (the last item is numbered with [0])
    public void setMenu(String menuName, ArrayList<String> options, String bordersChars, String paddingChars, int paddingLength){
        int optionNumber = 1;
        StringBuilder output = new StringBuilder();
        String header = textUtils.headerWithPadding(menuName,bordersChars,paddingChars,paddingLength);
        output.append(header).append("\n");
        for (String s : options){
            if (!s.equals(options.getLast())){
                output.append(String.format("%-10s[" + BLUE + "%d" + RESET + "] %s", "",optionNumber, s)).append("\n");
                optionNumber++;
            }else {
                output.append(String.format("%-10s[" + BLUE + "%d" + RESET + "] %s", "", 0, s)).append("\n");
            }
        }
        System.out.println(output);
    }

    // prompt the user to enter a value for the provided fieldName and check if the input is empty or not
    public String getString(String fieldName){
        String userInput = "";
        while (userInput.isEmpty()) {
            System.out.printf("Please enter the %s: ", fieldName);
            userInput = scanner.nextLine().trim();
        }
        return userInput;
    }

    // user the getString to prompt the user to enter a value
    // parse the string input into an Integer + reprompt if user input cannot be parsed
    public Integer getInt(String fieldName){
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
        while (userInput == null){
            String text = getString(fieldName);
            try {
                userInput = Double.parseDouble(text);
            } catch (Exception e) {
                System.out.println(RED + "Invalid Input! Please try again!" + RESET);
            }
        }
        return userInput;
    }

}
