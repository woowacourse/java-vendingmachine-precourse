package vendingmachine;

public class Validation {
    private final static String REGEX ="[0-9]+";

    public static void checkOnlyNumber(String input) {
        if(!input.matches(REGEX)) {
            throw new IllegalArgumentException();
        }
    }

    public static void isPositiveNumber(int num) {
        if(num < 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void isDivideTen(int num) {
        if(num % 10 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
