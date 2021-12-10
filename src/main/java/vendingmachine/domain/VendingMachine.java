package vendingmachine.domain;

import vendingmachine.utils.ExceptionMessages;
import vendingmachine.utils.RegularExpressions;


public class VendingMachine {

    private String money;

    public VendingMachine(final String inputMachineMoney) {
        validateMoney(inputMachineMoney);
        this.money = inputMachineMoney;
    }

    protected void validateMoney(final String inputMachineMoney) {
        if (!isNaturalNumber(inputMachineMoney)) {
            throw new IllegalArgumentException(ExceptionMessages.ERROR_MESSAGE_INPUT_MONEY_NUMBER.getErrorMessage());
        }
    }

    protected boolean isNaturalNumber(final String inputMachineMoney) {
        return inputMachineMoney.matches(RegularExpressions.MACHINE_HAVE_MONEY_REGULAR_EXPRESSION.getRegularExpression());
    }

}
