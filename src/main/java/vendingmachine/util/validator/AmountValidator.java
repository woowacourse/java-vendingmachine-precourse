package vendingmachine.util.validator;

import vendingmachine.util.ErrorMessage;
import vendingmachine.util.constant.InputCondition;
import vendingmachine.util.InputGenerator;

public class AmountValidator implements InputValidator {
    @Override
    public void validate(String input) {
        validateNumber(input);
        int amount = InputGenerator.convertToInteger(input);
        validateAmountRange(amount);
        validateDivideByTen(amount);
    }

    private void validateNumber(String input) {
        if (!input.matches(InputCondition.NUMBER_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_NUMBER.getMessage());
        }
    }

    private void validateAmountRange(int amount) {
        if (amount < InputCondition.AMOUNT_MIN_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_OUT_OF_RANGE_AMOUNT.getMessage());
        }
    }

    private void validateDivideByTen(int amount) {
        if (amount % InputCondition.AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_CANNOT_DIVIDE_BY_TEN.getMessage());
        }
    }
}
