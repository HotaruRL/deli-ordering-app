package utils;

import sandwichProperties.BreadType;

import java.util.ArrayList;

import static utils.ColorUtils.*;
import static utils.ColorUtils.RED;
import static utils.ColorUtils.RESET;

public class OptionsList {

    public ArrayList<String> getHomeScreenList() {
        ArrayList<String> list = new ArrayList<>();
        list.add(RED + "New" + RESET + " Order");
        list.add(RED + "Exit" + RESET);
        return list;
    }

    public ArrayList<String> getFutureOrderScreenList() {
        ArrayList<String> list = new ArrayList<>();
        list.add(RED + "YES," + RESET + " let's continue");
        list.add(RED + "NO," + RESET + " let's exit");
        return list;
    }

    public ArrayList<String> getOrderScreenList() {
        ArrayList<String> list = new ArrayList<>();
        list.add(RED + "Add" + RESET + " Sandwich");
        list.add(RED + "Add" + RESET + " Drink");
        list.add(RED + "Add" + RESET + " Chips");
        list.add(RED + "Checkout" + RESET);
        list.add(RED + "Cancel" + RESET + " Order");
        return list;
    }

    public ArrayList<String> getSandwichScreenList() {
        ArrayList<String> list = new ArrayList<>();
        list.add(RED + "Custom" + RESET + " Sandwich");
        list.add(RED + "Signature" + RESET + " Sandwich");
        list.add(RED + "Go" + RESET + " back");
        return list;
    }

    public ArrayList<String> getBreadScreenList() {
        ArrayList<String> list = new ArrayList<>();
        list.add(BreadType.WHITE.getDisplayName());
        list.add(BreadType.WHEAT.getDisplayName());
        list.add(BreadType.RYE.getDisplayName());
        list.add(BreadType.WRAP.getDisplayName());
        list.add(RED + "Go" + RESET + " back");
        return list;
    }

    public ArrayList<String> getSizeScreenList() {
        ArrayList<String> list = new ArrayList<>();
        list.add(RED + "4\"" + RESET + " Small");
        list.add(RED + "8\"" + RESET + " Medium");
        list.add(RED + "12\"" + RESET + " Large");
        list.add(RED + "Go" + RESET + " back");
        return list;
    }

    public ArrayList<String> getToppingTypeList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Meat");
        list.add("Cheese");
        list.add("Other Toppings");
        list.add("Sauce");
        list.add("Sides");
        return list;
    }

    public ArrayList<String> getToastedScreenList() {
        ArrayList<String> list = new ArrayList<>();
        list.add(RED + "Toast" + RESET + " It");
        list.add(RED + "DON'T" + RESET + " Toast It");
        return list;
    }

    public ArrayList<String> getDrinkSizeScreenList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Size " + RED + "Small" + RESET);
        list.add("Size " + RED + "Medium" + RESET);
        list.add("Size " + RED + "Large" + RESET);
        list.add(RED + "Go" + RESET + " back");
        return list;
    }

    public ArrayList<String> getDrinkQuantityScreenList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Just" + RED + " 01" + RESET);
        list.add("Give me a" + RED + " 6-pack" + RESET);
        list.add(RED + "Enter" + RESET + " Custom Amount");
        list.add(RED + "Go" + RESET + " back");
        return list;
    }

    public ArrayList<String> getChipsQuantityScreenList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Just" + RED + " 01" + RESET + " Bag");
        list.add("Give me" + RED + " 02" + RESET + " Bags");
        list.add(RED + "Enter" + RESET + " Custom Amount");
        list.add(RED + "Go" + RESET + " back");
        return list;
    }

    public ArrayList<String> getCheckoutScreenList() {
        ArrayList<String> list = new ArrayList<>();
        list.add(RED + "Continue" + RESET + " to Payment");
        list.add(RED + "Go" + RESET + " back");
        return list;
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
