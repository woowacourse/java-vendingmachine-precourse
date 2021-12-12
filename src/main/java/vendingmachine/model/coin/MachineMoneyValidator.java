package vendingmachine.model.coin;

import vendingmachine.util.Constant;
import vendingmachine.util.ErrorMessage;
import vendingmachine.util.exception.MoneyValidator;

public class MachineMoneyValidator extends MoneyValidator {
    public MachineMoneyValidator(String money) {
        moneyValid(money);
    }

    @Override
    public void moneyValid(String money) {
        if (!isNumeric(money)) {
            throw new IllegalArgumentException(ErrorMessage.MACHINE_MONEY_STRING_ERROR);
        }
        if (!isRangeValid(toInt(money), Constant.UNIT_VALUE)) {
            throw new IllegalArgumentException(ErrorMessage.MACHINE_MONEY_RANGE_ERROR);
        }
        if (!isUnitSplit(toInt(money))) {
            throw new IllegalArgumentException(ErrorMessage.MACHINE_MONEY_UNIT_ERROR);
        }
    }
}
