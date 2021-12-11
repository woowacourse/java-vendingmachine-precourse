package vendingmachine.utils;

public class Validator {

    private static final String NUMBER_FORMAT_ERROR_MSG = "[ERROR] 금액(수량)은 숫자여야 합니다.";
    private static final String NON_POSITIVE_ERROR_MSG = "[ERROR] 금액(수량)은 0 이상이어야 합니다.";

    public static void assertNumberFormat(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MSG);
        }
    }

    public static void assertPositive(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(NON_POSITIVE_ERROR_MSG);
        }
    }
}
