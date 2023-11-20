package utils;

public class Parser {

    private static final String SEMI_COLON = ";";
    public static int convertToInt(String amount){
        int parsedString = Integer.parseInt(amount);
        return parsedString;
    }

    public static void divideSemiColon(String input) {
        String[] parsedInput = input.split(";");
    }
}
