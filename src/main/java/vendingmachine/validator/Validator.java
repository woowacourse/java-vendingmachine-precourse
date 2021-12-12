package vendingmachine.validator;

public class Validator {
    private static final String ERROR = "[ERROR] ";
    private static final String NOT_NUMBER_EXCEPTION = ERROR + "숫자를 입력하셔야 합니다.";
    private static final String NEGATIVE_NUMBER_EXCEPTION = ERROR + "음수를 입력하시면 안 됩니다.";
    private static final String HAS_ONES_NUMBER_EXCEPTION = ERROR + "1원 단위는 입력하시면 안 됩니다.";

    public static void validateTotalMoneyInput(String input) {
        int intInput = validateTotalMoneyInputType(input);
        validateTotalMoneyNotNegative(intInput);
        validateTotalMoneyNotHaveOnes(intInput);
    }

    private static int validateTotalMoneyInputType(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_NUMBER_EXCEPTION);
        }
    }

    private static void validateTotalMoneyNotNegative(int intInput) {
        if (intInput < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_EXCEPTION);
        }
    }

    private static void validateTotalMoneyNotHaveOnes(int intInput) {
        if (intInput%10 > 0) {
            throw new IllegalArgumentException(HAS_ONES_NUMBER_EXCEPTION);
        }
    }
}
