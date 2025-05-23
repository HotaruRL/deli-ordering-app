package merch;

public class Chips implements Sellable{
    private String chipName;
    private final double chipPrice = 1.5;

    public Chips(String chipName){
        this.chipName = chipName;
    }

    // getters
    public String getChipName() {return chipName;}
    public double getChipPrice() {return chipPrice;}
    // setters
    public void setChipName(String chipName) {this.chipName = chipName;}

    @Override
    public double calculateUnitPrice() {
        return this.chipPrice;
    }

    @Override
    public void getReceiptDetails() {

    }
}
