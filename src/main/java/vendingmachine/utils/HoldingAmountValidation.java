package vendingmachine.utils;

import vendingmachine.Constant.DomainConstant;
import vendingmachine.Constant.ErrorConstant;

public class HoldingAmountValidation {

    CommonValidation common = new CommonValidation();

    public void isValidHoldingAmount(String holdingAmount) {
        if (checkBasic(holdingAmount) && checkCondition(Integer.parseInt(holdingAmount))){
            return;
        }
        throw new IllegalArgumentException(ErrorConstant.WrongHoldingAmount);
    }

    public boolean checkBasic(String holdingAmount){
        return (common.isExist(holdingAmount) && common.isInteger(holdingAmount));
    }

    private boolean checkCondition(int holdingAmount){
        return (common.isMoreThanNum(holdingAmount, DomainConstant.MINIMUM_NUMBER_OF_HOLDING_AMOUNT)
                && common.isDividedByNum(holdingAmount, DomainConstant.HOLDING_AMOUNT_MUST_BE_DIVIDED));
    }
}
