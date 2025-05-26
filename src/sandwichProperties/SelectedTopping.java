package sandwichProperties;

public class SelectedTopping {
    private Topping topping;
    private boolean isExtra;

    public SelectedTopping(Topping topping, boolean isExtra) {
        this.topping = topping;
        this.isExtra = isExtra;
    }
    // getters
    public Topping getTopping() {return topping;}
    public boolean isExtra() {return isExtra;}
    // setters
    public void setTopping(Topping topping) {this.topping = topping;}
    public void setExtra(boolean extra) {isExtra = extra;}

    public String getDisplayName(){
        String name = topping.getToppingName();
        if (isExtra){
            return name + " (Extra)";
        }
        return name;
    }
}
