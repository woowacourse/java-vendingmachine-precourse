package vendingmachine.utils;

public class StringUtils {
    public static boolean isNumeric(String string) {
        return string.chars().allMatch(Character::isDigit);
    }

    public static boolean isEmpty(String string) {
        return string == null || string.equals("");
    }
}
