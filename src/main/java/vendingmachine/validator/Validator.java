package vendingmachine.validator;

public class Validator {
    private static String ERROR = "[ERROR] ";
    private static String NOT_NUMBER_EXCEPTION = ERROR + "숫자를 입력하셔야 합니다.";

    public static void validateTotalMoneyInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_NUMBER_EXCEPTION);
        }
    }
}
