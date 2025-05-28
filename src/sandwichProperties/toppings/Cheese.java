package sandwichProperties.toppings;

public class Cheese extends Topping {
    private String cheeseName;

    public Cheese(String cheeseName) {
        this.cheeseName = cheeseName;
    }

    public void setCheeseName(String cheeseName) {this.cheeseName = cheeseName;}

    @Override
    public String getToppingName() {
        return this.cheeseName;
    }
}
