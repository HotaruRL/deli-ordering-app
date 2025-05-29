package sandwichProperties.toppings;

public class Sides extends Topping{
    private String name;

    public Sides(String name) {
        super(name);
        this.name = name;
    }

    public void setName(String name) {this.name = name;}

    @Override
    public String getToppingName() {
        return this.name;
    }
}
