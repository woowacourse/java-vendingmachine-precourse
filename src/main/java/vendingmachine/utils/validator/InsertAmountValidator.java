package vendingmachine.utils.validator;

public class InsertAmountValidator {

    private static final String INPUT_IS_NOT_A_VALID_NUMBER_OR_EXCEED_MAX = "투입 금액은 10억 이하의 숫자만 입력할 수 있습니다.";

    public static int getValidInsertAmountValidator(final String input) {
        int intInput = NumberValidator.getValidNumber(input, INPUT_IS_NOT_A_VALID_NUMBER_OR_EXCEED_MAX);
        return intInput;
    }
}
