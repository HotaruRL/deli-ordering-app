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
    private int quantity;
    private PricingService pricingService;
    private String isCustomizing;

    public Sandwich(int quantity){
        this.quantity = quantity;
    }
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
    public int getQuantity() {return quantity;}
    public String getIsCustomizing() {return isCustomizing;}

    // setters
    public void setSandwichSize(String sandwichSize) {this.sandwichSize = sandwichSize;}
    public void setBreadType(BreadType breadType) {this.breadType = breadType;}
    public void setSelectedToppings(ArrayList<SelectedTopping> selectedToppings) {this.selectedToppings = selectedToppings;}
    public void setToasted(boolean toasted) {isToasted = toasted;}
    public void setQuantity(int quantity) {this.quantity = quantity;}
    public void setIsCustomizing(String isCustomizing) {this.isCustomizing = isCustomizing;}

    @Override
    public double getPrice() {
        pricingService = new PricingService();
        double price = 0.0;
        // get the base price of the sandwich base on size
        price += pricingService.getSpecificPrice(this.sandwichSize,"basePrice");
        // add the applicable toppings' prices
        for (SelectedTopping selectedTopping : this.selectedToppings){
            Topping topping = selectedTopping.getTopping();
            boolean isExtra = selectedTopping.isExtra();
            price += pricingService.getToppingPrice(topping, this.sandwichSize, isExtra);
        }
        // if there's multiple exact sandwich, price * quantity
        return price * this.quantity;
    }

    @Override
    public double getUnitPrice(){
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

    public ArrayList<String> getAdditionDetails(boolean forReceipt){
        ArrayList<String> details = new ArrayList<>();
        if (forReceipt) {
            details.add(String.format("Bread: %s", this.breadType.getPlainName()));
        }else {
            details.add(String.format("Bread: %s", this.breadType.getDisplayName()));
        }
        details.add(String.format("Toasted: %s", this.isToasted ? "Yes" : "No"));
        details.add("Toppings:");
        for (SelectedTopping topping : this.selectedToppings){
            if (topping.getTopping() instanceof Cheese){
                details.add(String.format("- cheese: %s", topping.getDisplayName()));
            }else {
                details.add(String.format("- %s", topping.getDisplayName()));
            }
        }
        return details;
    }

    public void addTopping(SelectedTopping topping){
        this.selectedToppings.add(topping);
    }
}
