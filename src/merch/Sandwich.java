package merch;

import sandwichProperties.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Sandwich implements Sellable {
    private Enum<SandwichSize> sandwichSize;
    private BreadType breadType;
    private ArrayList<SelectedTopping> selectedToppings;
    private boolean isToasted;

    public Sandwich(Enum<SandwichSize> sandwichSize, BreadType breadType, ArrayList<SelectedTopping> selectedToppings, boolean isToasted){
        this.sandwichSize = sandwichSize;
        this.breadType = breadType;
        this.selectedToppings = selectedToppings;
        this.isToasted = isToasted;
    }

    // getters
    public Enum<SandwichSize> getSandwichOfSize() {return sandwichSize;}
    public BreadType getBreadType() {return breadType;}
    public ArrayList<SelectedTopping> getSelectedToppings() {return selectedToppings;}
    public boolean isToasted() {return isToasted;}
    // setters
    public void setSandwichOfSize(Enum<SandwichSize> sizeSpecificPriceInfo) {this.sandwichSize = sizeSpecificPriceInfo;}
    public void setBreadType(BreadType breadType) {this.breadType = breadType;}
    public void setSelectedToppings(ArrayList<SelectedTopping> selectedToppings) {this.selectedToppings = selectedToppings;}
    public void setToasted(boolean toasted) {isToasted = toasted;}

    @Override
    public double calculateUnitPrice() {
        double subTotal = 0;
        return subTotal;
    }

    @Override
    public void getReceiptDetails() {

    }
}
