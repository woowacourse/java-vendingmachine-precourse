package vendingmachine.utils;

public class NumberValidator {
    public static boolean validateNumber(String value) {
        for (int i = 0; i < value.length(); i++) {
            if ((int) value.charAt(i) < (int) '0' || ((int) '9' < (int) value.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkDivideTen(String value) {
        return Integer.parseInt(value) % 10 == 0;
    }

    public static boolean validateZeroNumber(String price) {
        return !(price.length() == 1 && (int) price.charAt(0) == (int) '0');
    }
}
