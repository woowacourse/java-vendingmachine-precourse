package vendingmachine;

import utils.ErrorMessages;
import utils.Parser;

public class Amount {

    private final int money;

    public Amount(String moneyString) {
        validateBlank(moneyString);
        this.money = Parser.convertToInt(moneyString);
    }

    private void validateBlank(String input) {
        if (input.isEmpty()){
            throw new IllegalArgumentException(ErrorMessages.VALIDATE_BLANK.getErrorMessage());
        }
    }
}
