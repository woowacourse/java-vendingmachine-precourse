package vendingmachine;

import java.util.ArrayList;
import java.util.Arrays;

public class Utils {

    private static int MIN_VALUE = 100;

    public static ArrayList splitString(String inputString) {
        String[] splits = inputString.replace("[","").replace("]","").split(";");
        return new ArrayList<String>(Arrays.asList(splits));
    }

    public static void validateNumber(String str) {
        if (!str.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자여야 합니다.");
        }
    }

    public static void validatePositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("0보다 커야합니다.");
        }
    }

    public static void validateOvervalue(int number) {
        if (number < MIN_VALUE) {
            throw new IllegalArgumentException("상품의 가격은 최소 " + MIN_VALUE + "원 이상이어야 합니다.");
        }
    }
}
