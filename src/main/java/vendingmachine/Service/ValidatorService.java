package vendingmachine.Service;

import vendingmachine.Constant.ErrorConstant;

public class ValidatorService {

    public void isValidHoldingAmount(String holdingAmount) {
        if (isInteger(holdingAmount) && isInRange(Integer.parseInt(holdingAmount))) {
            return;
        }
        throw new IllegalArgumentException(ErrorConstant.WrongHoldingAmount);
    }

    private boolean isInteger(String holdingAmount) {
        try {
            Integer.parseInt(holdingAmount);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private boolean isInRange(int holdingAmount) {
        return (holdingAmount >= 0 && holdingAmount % 10 == 0);
    }

}
