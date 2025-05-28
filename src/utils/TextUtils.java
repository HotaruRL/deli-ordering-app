package utils;

public class TextUtils {
    private static final int LINE_WIDTH = 60;
    private static final String SPACE = " ";

    public TextUtils(){}

    public String createPattern(String chars, int totalLength){
        StringBuilder output = new StringBuilder();
        // 2nd condition to make sure last addition doesn't make the output length longer than totalLength
        while (output.length() <= totalLength && (output.length() + chars.length()) <= totalLength){
            output.append(chars);
        }
        return output.toString();
    }

    public String centerTextWithPadding(String text, String paddingChars, int paddingLength1Side){
        String padding = createPattern(paddingChars, paddingLength1Side);
        int spacingLength = (int) Math.floor((LINE_WIDTH - text.length() - (padding.length() * 2)) / 2);
        String spacingLeft = createPattern(SPACE, spacingLength);
        String spacingRight = createPattern(SPACE, spacingLength);
        String output = padding + spacingLeft + text + spacingRight + padding;
        // trim/fill
        int numberCharsOff = LINE_WIDTH - output.length();
        if (numberCharsOff > 0 && ((numberCharsOff % 2) == 0)){ // need fill both sides
            spacingLeft = createPattern(SPACE, spacingLength + 1);
            spacingRight = createPattern(SPACE, spacingLength + 1);
        } else if (numberCharsOff > 0 && ((numberCharsOff % 2) != 0)) { // need fill 1 side
            spacingLeft = createPattern(SPACE, spacingLength + 1);
        } else if (numberCharsOff < 0 && ((numberCharsOff % 2) == 0)) { // need trim both side
            spacingLeft = createPattern(SPACE, spacingLength - 1);
            spacingRight = createPattern(SPACE, spacingLength - 1);
        } else if (numberCharsOff < 0 && ((numberCharsOff % 2) != 0)) { // need trim 1 side
            spacingLeft = createPattern(SPACE, spacingLength - 1);
        }
        return padding + spacingLeft + text + spacingRight + padding;
    }

    public String centerText(String text){
        int spacingLength = (int) Math.floor((LINE_WIDTH - text.length()) / 2);
        String spacingLeft = createPattern(SPACE, spacingLength);
        String spacingRight = createPattern(SPACE, spacingLength);
        String output = spacingLeft + text + spacingRight;
        // trim/fill
        int numberCharsOff = LINE_WIDTH - output.length();
        if (numberCharsOff > 0 && ((numberCharsOff % 2) == 0)){ // need fill both sides
            spacingLeft = createPattern(SPACE, spacingLength + 1);
            spacingRight = createPattern(SPACE, spacingLength + 1);
        } else if (numberCharsOff > 0 && ((numberCharsOff % 2) != 0)) { // need fill 1 side
            spacingLeft = createPattern(SPACE, spacingLength + 1);
        } else if (numberCharsOff < 0 && ((numberCharsOff % 2) == 0)) { // need trim both side
            spacingLeft = createPattern(SPACE, spacingLength - 1);
            spacingRight = createPattern(SPACE, spacingLength - 1);
        } else if (numberCharsOff < 0 && ((numberCharsOff % 2) != 0)) { // need trim 1 side
            spacingLeft = createPattern(SPACE, spacingLength - 1);
        }
        return spacingLeft + text + spacingRight;
    }

    public String headerWithPadding(String headerName, String bordersChars, String paddingChars, int paddingLength1Side){
        StringBuilder output = new StringBuilder();
        String borderRow = createPattern(bordersChars, LINE_WIDTH);
        String middleRow = centerTextWithPadding(headerName, paddingChars, paddingLength1Side);
        output.append(borderRow).append("\n");
        output.append(middleRow).append("\n");
        output.append(borderRow).append("\n");
        return output.toString();
    }

    public String header(String headerName, String bordersChars){
        StringBuilder output = new StringBuilder();
        String borderRow = createPattern(bordersChars, LINE_WIDTH);
        output.append(borderRow).append("\n");
        output.append(centerText(headerName)).append("\n");
        output.append(borderRow).append("\n");
        return output.toString();
    }
}
