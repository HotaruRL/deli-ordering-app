package sandwichProperties.toppings;

public class Meat extends Topping {
    private String name;

    public Meat(String name) {
        super(name);
        this.name = name;
    }

    public void setName(String name) {this.name = name;}

    @Override
    public String getToppingName() {
        return this.name;
    }
}
