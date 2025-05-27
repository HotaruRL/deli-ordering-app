package utils;

public class TextUtils {
    private static final int LINE_WIDTH = 40;
    private static final String SPACE = " ";

    TextUtils(){}

    public String createPattern(String chars, int repetition){
        StringBuilder output = new StringBuilder();
        while (output.length() < repetition && output.length() < LINE_WIDTH){
            output.append(chars);
        }
        return output.toString();
    }

    public String centerTextWithPadding(String text, String patternChars, int paddingLength){
        int spaceBothSides = LINE_WIDTH - text.length();
        int space1Side = spaceBothSides / 2;
        String padding = createPattern(patternChars, paddingLength);
        String spacing = createPattern(SPACE, space1Side - paddingLength);
        if (text.length() >= LINE_WIDTH){
            return text;
        }
        return padding + spacing + text + spacing + padding;
    }

    public String centerText(String text){
        int spaceBothSides = LINE_WIDTH - text.length();
        int space1Side = spaceBothSides / 2;
        String spacing = createPattern(SPACE, space1Side);
        if (text.length() >= LINE_WIDTH){
            return text;
        }
        return spacing + text + spacing;
    }

    public String header(String headerName, String patternChars, int paddingLength){
        StringBuilder output = new StringBuilder();
        output.append(createPattern(patternChars, LINE_WIDTH));
        output.append(centerTextWithPadding(headerName, patternChars, paddingLength));
        output.append(createPattern(patternChars, LINE_WIDTH));
        return output.toString();
    }
    public String header(String headerName, String patternChars){
        StringBuilder output = new StringBuilder();
        output.append(createPattern(patternChars, LINE_WIDTH));
        output.append(centerText(headerName));
        output.append(createPattern(patternChars, LINE_WIDTH));
        return output.toString();
    }
}
