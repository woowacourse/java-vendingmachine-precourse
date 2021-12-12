package vendingmachine.utils.validator;

public class HoldingMoneyValidator {

    public static final String HOLDING_MONEY_NOT_A_VALID_NUMBER = "[ERROR] 자판기 보유 금액은 10억 이하의 숫자만 입력할 수 있습니다.";
    public static final int MAX_HOLDING_MONEY = 1000000000;

    public static int getValidHoldingMoney(final String input) {
        int intInput = NumberValidator.getValidNumber(input, HOLDING_MONEY_NOT_A_VALID_NUMBER);
        NumberValidator.validateNotExceedMaxValue(intInput, MAX_HOLDING_MONEY, HOLDING_MONEY_NOT_A_VALID_NUMBER);
    }
}
