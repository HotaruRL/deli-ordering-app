package sandwichProperties;

public enum SandwichSize {
    INCH_4("4\""),
    INCH_8("8\""),
    INCH_12("12\"");

    private final String displayName;

    SandwichSize(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){return displayName;}
    public String toString(){return displayName;}
}
