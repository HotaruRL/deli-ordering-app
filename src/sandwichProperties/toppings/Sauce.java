package sandwichProperties.toppings;

public class Sauce extends Topping{
    private String name;

    public Sauce(String name) {
        super(name);
        this.name = name;
    }

    public void setName(String name) {this.name = name;}

    @Override
    public String getToppingName() {
        return this.name;
    }
}
