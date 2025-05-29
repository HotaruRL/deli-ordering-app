package utils;

import merch.LineItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

import static utils.ColorUtils.*;

public class MenuUtils {
    private static final String TOPPINGS_LIST_FILE_PATH = "internalUse\\toppingList.csv";
    private FileUtils fileUtils;
    private TextUtils textUtils;
    private Scanner scanner;

    public MenuUtils(){
        this.fileUtils = new FileUtils();
        this.textUtils = new TextUtils();
        this.scanner = new Scanner(System.in);
    }

    public int getIndexOfLastItem(ArrayList<LineItem> list){
        return list.size() - 1;
    }

    public HashMap<String, ArrayList<String>> getToppingChart(){
        return fileUtils.loadList(TOPPINGS_LIST_FILE_PATH);
    }

    public ArrayList<String> getToppingTypeList(){
        ArrayList<String> toppingTypeList = new ArrayList<>();
        for (HashMap.Entry<String, ArrayList<String>> entry : fileUtils.loadList(TOPPINGS_LIST_FILE_PATH).entrySet()) {
            String type = entry.getKey();
            toppingTypeList.add(type);
        }
        return toppingTypeList;
    }

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

    public String getString(String fieldName){
        String userInput = "";
        while (userInput.isEmpty()) {
            System.out.printf("Please enter the %s: ", fieldName);
            userInput = scanner.nextLine().trim();
        }
        return userInput;
    }

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
