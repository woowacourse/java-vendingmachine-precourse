package vendingmachine;

public class StringUtils {
    public static boolean isNumeric(String string) {
        return string.chars().allMatch(Character::isDigit);
    }
}
