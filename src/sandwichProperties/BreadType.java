package sandwichProperties;

import static utils.ColorUtils.*;

public enum BreadType {
    WHITE(BRIGHT_WHITE + "White" + RESET + " Bread"),
    WHEAT(YELLOW + "Wheat" + RESET + " Bread"),
    RYE(MAGENTA + "Rye" + RESET + " Bread"),
    WRAP(GREEN + "Wrap" + RESET);

    private final String displayName;

    BreadType(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){return displayName;}
    public String toString(){return displayName;}
}
