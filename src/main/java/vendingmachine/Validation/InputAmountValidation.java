package vendingmachine.Validation;

import vendingmachine.Constant.DomainConstant;
import vendingmachine.Constant.ErrorConstant;

public class InputAmountValidation {
    CommonValidation common = new CommonValidation();

    public void isValidInputAmount(String inputAmount) {
        if (checkBasic(inputAmount) && checkCondition(Integer.parseInt(inputAmount))) {
            return;
        }
        throw new IllegalArgumentException(ErrorConstant.WRONG_INPUT_AMOUNT);
    }

    private boolean checkBasic(String inputAmount) {
        return common.isExist(inputAmount) && common.isInteger(inputAmount);
    }

    private boolean checkCondition(int inputAmount) {
        return common.isMoreThanNum(inputAmount, DomainConstant.MINIMUM_NUMBER_OF_INPUT_AMOUNT);
    }
}
