package vendingmachine.utils.validator;

public class HoldingAmountValidator {

    private static final String INPUT_INVALID_NUMBER_OR_EXCEED_MAX_ERROR_MESSAGE = "자판기 보유 금액은 10억 이하의 숫자만 입력할 수 있습니다.";
    private static final String INPUT_EXCEED_MIN_VALUE_ERROR_MESSAGE = "자판기 보유 금액은 0 이상이어야 합니다.";
    private static final String INPUT_NOT_DIVISIBLE_BY_TEN_ERROR_MESSAGE = "자판기 보유 금액의 최소 단위는 10이어야 합니다.";
    private static final int MAX_HOLDING_AMOUNT = 1000000000;
    private static final int MIN_HOLDING_AMOUNT = 0;

    public static int getValidHoldingAmount(final String input) {
        int intInput = NumberValidator.getValidNumber(input, INPUT_INVALID_NUMBER_OR_EXCEED_MAX_ERROR_MESSAGE);
        NumberValidator.validateNotExceedMaxValue(intInput, MAX_HOLDING_AMOUNT,
            INPUT_INVALID_NUMBER_OR_EXCEED_MAX_ERROR_MESSAGE);
        NumberValidator.validateNotExceedMinValue(intInput, MIN_HOLDING_AMOUNT, INPUT_EXCEED_MIN_VALUE_ERROR_MESSAGE);
        NumberValidator.validateDivisibleByTen(intInput, INPUT_NOT_DIVISIBLE_BY_TEN_ERROR_MESSAGE);
        return intInput;
    }
}
