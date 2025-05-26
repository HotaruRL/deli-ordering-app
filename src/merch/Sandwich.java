package merch;

import sandwichProperties.*;
import utils.PricingService;

import java.util.ArrayList;

public class Sandwich implements LineItem {
    private String sandwichSize;
    private BreadType breadType;
    private ArrayList<SelectedTopping> selectedToppings;
    private boolean isToasted;
    private PricingService pricingService;

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
    // setters
    public void setSandwichSize(String sandwichSize) {this.sandwichSize = sandwichSize;}
    public void setBreadType(BreadType breadType) {this.breadType = breadType;}
    public void setSelectedToppings(ArrayList<SelectedTopping> selectedToppings) {this.selectedToppings = selectedToppings;}
    public void setToasted(boolean toasted) {isToasted = toasted;}

    @Override
    public double calculateUnitPrice() {
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
    public void getReceiptDetails() {

    }
}
