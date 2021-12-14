package vendingmachine.utils;

public class StringFormatUtils {

    public static String trimBothEnds(String fullString) {
        return fullString.substring(1, fullString.length() - 1);
    }
}
