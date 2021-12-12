package vendingmachine.utils.validator;

public class InsertAmountValidator {

    private static final String INPUT_IS_INVALID_NUMBER_OR_EXCEED_MAX_ERROR_MESSAGE = "투입 금액은 10억 이하의 숫자만 입력할 수 있습니다.";
    private static final String INPUT_IS_EXCEED_MIN_ERROR_MESSAGE = "투입 금액은 반드시 0원 이상이어야 합니다.";
    private static final int MAX_INSERT_AMOUNT = 1000000000;
    private static final int MIN_INSERT_AMOUNT = 0;

    public static int getValidInsertAmountValidator(final String input) {
        int intInput = NumberValidator.getValidNumber(input, INPUT_IS_INVALID_NUMBER_OR_EXCEED_MAX_ERROR_MESSAGE);
        NumberValidator.validateNotExceedMaxValue(intInput, MAX_INSERT_AMOUNT,
            INPUT_IS_INVALID_NUMBER_OR_EXCEED_MAX_ERROR_MESSAGE);
        NumberValidator.validateNotExceedMinValue(intInput, MIN_INSERT_AMOUNT, INPUT_IS_EXCEED_MIN_ERROR_MESSAGE);
        return intInput;
    }
}
