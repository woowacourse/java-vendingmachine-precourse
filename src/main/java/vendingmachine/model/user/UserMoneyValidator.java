package vendingmachine.model.user;

import vendingmachine.util.Message;
import vendingmachine.util.exception.MoneyValidator;

public class UserMoneyValidator extends MoneyValidator {

    public UserMoneyValidator(String money) {
        moneyValid(money);
    }

    @Override
    public void moneyValid(String money) {
        if (!isNumeric(money)) {
            throw new IllegalArgumentException(Message.USER_MONEY_STRING_ERROR);
        }
        if (!isUnitSplit(toInt(money))) {
            throw new IllegalArgumentException(Message.USER_MONEY_UNIT_ERROR);
        }
    }
}
