package merch;

import sandwichProperties.*;
import sandwichProperties.toppings.Cheese;
import sandwichProperties.toppings.Topping;
import utils.PricingService;

import java.util.ArrayList;

public class Sandwich implements LineItem {
    private String sandwichSize;
    private BreadType breadType;
    private ArrayList<SelectedTopping> selectedToppings;
    private boolean isToasted;
    private PricingService pricingService;
    private String isCustomizing;

    public Sandwich(){}
    public Sandwich(String sandwichSize, BreadType breadType, ArrayList<SelectedTopping> selectedToppings, boolean isToasted){
        this.sandwichSize = sandwichSize;
        this.breadType = breadType;
        this.selectedToppings = selectedToppings;
        this.isToasted = isToasted;
    }

    // getters
    public String getSandwichSize() {return sandwichSize;}
    public BreadType getBreadType() {return breadType;}
    public ArrayList<SelectedTopping> getSelectedToppings() {return selectedToppings;}
    public boolean isToasted() {return isToasted;}
    public String getIsCustomizing() {return isCustomizing;}

    // setters
    public void setSandwichSize(String sandwichSize) {this.sandwichSize = sandwichSize;}
    public void setBreadType(BreadType breadType) {this.breadType = breadType;}
    public void setSelectedToppings(ArrayList<SelectedTopping> selectedToppings) {this.selectedToppings = selectedToppings;}
    public void setToasted(boolean toasted) {isToasted = toasted;}
    public void setIsCustomizing(String isCustomizing) {this.isCustomizing = isCustomizing;}

    public void addTopping(SelectedTopping topping){
        this.selectedToppings.add(topping);
    }
    @Override
    public double calculatePrice() {
        pricingService = new PricingService();
        double unitPrice = 0.0;
        // get the base price of the sandwich base on size
        unitPrice += pricingService.getSpecificPrice(this.sandwichSize,"basePrice");
        // add the applicable toppings' prices
        for (SelectedTopping selectedTopping : this.selectedToppings){
            Topping topping = selectedTopping.getTopping();
            boolean isExtra = selectedTopping.isExtra();
            unitPrice += pricingService.getToppingPrice(topping, this.sandwichSize, isExtra);
        }
        return unitPrice;
    }

    @Override
    public String getReceiptDetails() {
        return String.format("Custom Sandwich (%s\")", this.sandwichSize);
    }

    public ArrayList<String> getAdditionDetails(){
        ArrayList<String> details = new ArrayList<>();
        String indent = "   ";
        details.add(String.format(indent + "Bread: %s", this.breadType.getDisplayName()));
        details.add(String.format(indent + "Toasted: %s", this.isToasted ? "Yes" : "No"));
        details.add(indent + "Toppings:");
        for (SelectedTopping topping : this.selectedToppings){
            if (topping.getTopping() instanceof Cheese){
                details.add(String.format(indent + "- cheese: %s", topping.getDisplayName()));
            }else {
                details.add(String.format(indent + "- %s", topping.getDisplayName()));
            }
        }
        return details;
    }
}
