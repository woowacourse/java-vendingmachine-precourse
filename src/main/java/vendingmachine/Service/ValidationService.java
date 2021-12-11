package vendingmachine.Service;

import vendingmachine.Constant.DomainConstant;
import vendingmachine.Constant.ErrorConstant;

public class ValidationService {

    public void isValidHoldingAmount(String holdingAmount) {
        if (isInteger(holdingAmount)) {
            int input = Integer.parseInt(holdingAmount);
            if (isMoreThanNum(input, DomainConstant.MINIMUM_NUMBER_OF_HOLDING_AMOUNT) && isDividedByNum(input, DomainConstant.HOLDING_AMOUNT_MUST_BE_DIVIDED)) {
                return;
            }
        }
        throw new IllegalArgumentException(ErrorConstant.WrongHoldingAmount);
    }

    private boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private boolean isMoreThanNum(int input, int num) {
        return input >= num;
    }

    private boolean isDividedByNum(int input, int num) {
        return input % num == 0;
    }

}
