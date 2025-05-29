package sandwichProperties;

import static utils.ColorUtils.*;

public enum BreadType {
    WHITE("White", BRIGHT_WHITE + "White" + RESET + " Bread"),
    WHEAT("Wheat", YELLOW + "Wheat" + RESET + " Bread"),
    RYE("Rye", MAGENTA + "Rye" + RESET + " Bread"),
    WRAP("Wrap", GREEN + "Wrap" + RESET);

    private final String plainName;
    private final String displayName;

    BreadType(String plainName, String displayName){
        this.plainName = plainName;
        this.displayName = displayName;
    }

    public String getPlainName(){return plainName;}
    public String getDisplayName(){return displayName;}

    @Override
    public String toString(){return displayName;}
}
