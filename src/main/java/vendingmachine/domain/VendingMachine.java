package vendingmachine.domain;

import java.util.List;

import vendingmachine.utils.ExceptionMessages;
import vendingmachine.utils.RegularExpressions;

public class VendingMachine {

    private List<Product> productList;
    private String money;

    public VendingMachine(final String inputMachineMoney) {
        validateMoney(inputMachineMoney);
        this.money = inputMachineMoney;
    }

    protected void validateMoney(final String inputMachineMoney) {
        if (!isNumber(inputMachineMoney)) {
            throw new IllegalArgumentException(ExceptionMessages.ERROR_MESSAGE_INPUT_MONEY.getErrorMessage());
        }
    }

    protected boolean isNumber(final String inputMachineMoney) {
        return inputMachineMoney.matches(RegularExpressions.MACHINE_HAVE_MONEY_REGULAR_EXPRESSION.getRegularExpression());
    }

}
