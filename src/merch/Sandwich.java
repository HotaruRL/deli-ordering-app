package merch;

import sandwichProperties.BreadType;
import sandwichProperties.SandwichOfSize;

import java.util.List;

public class Sandwich implements Sellable {
    private SandwichOfSize sandwichOfSize;
    private BreadType breadType;
    private List<SelectedTopping> selectedToppings;
    private boolean isToasted;

    public Sandwich(SandwichOfSize sandwichOfSize, BreadType breadType, List<SelectedTopping> selectedToppings, boolean isToasted){
        this.sandwichOfSize = sandwichOfSize;
        this.breadType = breadType;
        this.selectedToppings = selectedToppings;
        this.isToasted = isToasted;
    }

    // getters
    public SandwichOfSize getSandwichOfSize() {return sandwichOfSize;}
    public BreadType getBreadType() {return breadType;}
    public List<SelectedTopping> getSelectedToppings() {return selectedToppings;}
    public boolean isToasted() {return isToasted;}
    // setters
    public void setSandwichOfSize(SandwichOfSize sandwichOfSize) {this.sandwichOfSize = sandwichOfSize;}
    public void setBreadType(BreadType breadType) {this.breadType = breadType;}
    public void setSelectedToppings(List<SelectedTopping> selectedToppings) {this.selectedToppings = selectedToppings;}
    public void setToasted(boolean toasted) {isToasted = toasted;}

    @Override
    public double calculateUnitPrice() {

        return 0;
    }

    @Override
    public void getReceiptDetails() {

    }
}
