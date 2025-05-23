package sandwichProperties;

public enum BreadType {
    WHITE("White Bread"),
    WHEAT("Wheat Bread"),
    RYE("Rye Bread"),
    WRAP("Wrap");

    private final String displayName;

    BreadType(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){return displayName;}
    public String toString(){return displayName;}
}
