package vendingmachine.util;

public class Util {

    public static String removeSpace(String input) {
        return input.replaceAll(" ", "");
    }

    public static String removeDelimiters(String input) {
        return input.replace("[", "").replace("]", "");
    }
    private Util() {
    }
}
