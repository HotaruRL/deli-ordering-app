package utils;

import java.util.ArrayList;
import java.util.Scanner;

import static utils.ColorUtils.BLUE;
import static utils.ColorUtils.RESET;

public class MenuUtils {
    private TextUtils textUtils;
    private Scanner scanner;

    public MenuUtils(){
        this.textUtils = new TextUtils();
        this.scanner = new Scanner(System.in);
    }

    public void setMenu(ArrayList<String> options){
        int optionNumber = 1;
        StringBuilder output = new StringBuilder();
        String header = textUtils.headerWithPadding("Home Screen","*","-",3);
        output.append(header).append("\n");
        for (String s : options){
            if (!s.equals(options.getLast())){
                output.append(String.format("%-10s[" + BLUE + "%d" + RESET + "] %s", "",optionNumber, s)).append("\n");
            }else {
                output.append(String.format("%-10s[" + BLUE + "%d" + RESET + "] %s", "", 0, s)).append("\n");
            }
        }
        System.out.println(output);
    }

    public String getValidatedInputString (String fieldName){
        String userInput;
        while (true) {
            System.out.printf("Please enter the %s: ", fieldName);
            userInput = scanner.nextLine().trim();
            if (!userInput.isEmpty()) {
                break;
            }else {
                System.out.printf("\n%s cannot be blank. Please hit [Enter] to try again!", fieldName);
            }
        }
        return userInput;
    }

    public Integer parseInt(String input){
        Integer userInput = null;
        while (userInput == null) {
            try {
                userInput = Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("The input is not a valid number! Error: " + e.toString());
            }
        }
        return userInput;
    }

    public Double parseDouble(String input) {
        Double userInput = null;
        while (userInput == null){
            try {
                userInput = Double.parseDouble(input);
            } catch (Exception e) {
                System.out.println("The input is not a valid number! Error: " + e.toString());
            }
        }
        return userInput;
    }

}
