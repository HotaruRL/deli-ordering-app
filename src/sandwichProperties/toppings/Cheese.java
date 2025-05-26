package sandwichProperties.toppings;

import sandwichProperties.Topping;

public class Cheese extends Topping {
    private String cheeseName;

    public Cheese(String cheeseName) {
        this.cheeseName = cheeseName;
    }

    public void setCheeseName(String cheeseName) {this.cheeseName = cheeseName;}

    @Override
    protected String getToppingName() {
        return this.cheeseName;
    }
}
