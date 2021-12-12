package vendingmachine.utils.validator;

public class HoldingMoneyValidator {

    public static final String INPUT_IS_NOT_A_VALID_NUMBER_OR_EXCEED_MAX = "자판기 보유 금액은 10억 이하의 숫자만 입력할 수 있습니다.";
    public static final String INPUT_EXCEED_MIN_VALUE = "자판기 보유 금액은 0 이상이어야 합니다.";
    public static final String INPUT_NOT_DIVISIBLE_BY_TEN = "자판기 보유 금액의 최소 단위는 10이어야 합니다.";
    public static final int MAX_HOLDING_MONEY = 1000000000;
    public static final int MIN_HOLDING_MONEY = 0;

    public static int getValidHoldingMoney(final String input) {
        int intInput = NumberValidator.getValidNumber(input, INPUT_IS_NOT_A_VALID_NUMBER_OR_EXCEED_MAX);
        NumberValidator.validateNotExceedMaxValue(intInput, MAX_HOLDING_MONEY,
            INPUT_IS_NOT_A_VALID_NUMBER_OR_EXCEED_MAX);
        NumberValidator.validateNotExceedMinValue(intInput, MIN_HOLDING_MONEY,
            INPUT_IS_NOT_A_VALID_NUMBER_OR_EXCEED_MAX);
        NumberValidator.validateDivisibleByTen(intInput, INPUT_NOT_DIVISIBLE_BY_TEN);
        return intInput;
    }
}
