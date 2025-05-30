package utils;

import java.util.ArrayList;

import static utils.ColorUtils.*;
import static utils.ColorUtils.RED;
import static utils.ColorUtils.RESET;

public class OptionsList {

    public ArrayList<String> getToppingTypeList() {
        ArrayList<String> toppingTypeList = new ArrayList<>();
        toppingTypeList.add("Meat");
        toppingTypeList.add("Cheese");
        toppingTypeList.add("Other Toppings");
        toppingTypeList.add("Sauce");
        toppingTypeList.add("Sides");
        return toppingTypeList;
    }

    public ArrayList<String> promptAddExtra(String selectedToppingName){
        ArrayList<String> addExtra = new ArrayList<>();
        addExtra.add(String.format(RED + "Add" + RESET + " Extra" + BLUE + " %s" + RESET, selectedToppingName));
        addExtra.add(RED + "Skip" + RESET);
        return addExtra;
    }

    public ArrayList<String> promptCustomize(){
        ArrayList<String> customize = new ArrayList<>();
        customize.add(String.format(RED + "Yes!" + RESET + " Let's" + BLUE + " customize it" + RESET));
        customize.add(RED + "No!" + RESET + " I like it that way");
        return customize;
    }
}
