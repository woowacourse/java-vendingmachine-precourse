package vendingmachine.util;

import java.util.Arrays;
import java.util.List;

public class Util {

    public static String removeSpace(String input) {
        return input.replaceAll(" ", "");
    }

    public static String removeDelimiters(String input) {
        return input.replace("[", "").replace("]", "");
    }

    public static List<String> splitByComma(String input) {
        return Arrays.asList(Util.removeSpace(input).split(","));
    }

    public static List<String> formatProductInfo(String input) {
        return Util.splitByComma(Util.removeDelimiters(Util.removeSpace(input)));
    }

    private Util() {
    }
}
