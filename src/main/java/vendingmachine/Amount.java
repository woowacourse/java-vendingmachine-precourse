package vendingmachine;

import utils.ErrorMessages;
import utils.Parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Amount {

    private static final int MINIMUM_MONEY = 100;
    private static final int DIVISIBLE_AMOUNT = 10;
    private static final int ZERO = 0;
    private static final String NUMBER_REG_EXP = "^[0-9]+$";
    private static final Pattern NUMBER = Pattern.compile(NUMBER_REG_EXP);
    private final int money;

    public Amount(String moneyString) {
        validateBlank(moneyString);
        validateIsNumeric(moneyString);
        this.money = Parser.convertToInt(moneyString);
        validateMinimumAmount(money);
        validateDivideByTen(money);
    }

    private void validateBlank(String input) {
        if (input.isEmpty()){
            throw new IllegalArgumentException(ErrorMessages.VALIDATE_BLANK.getErrorMessage());
        }
    }

    private void validateIsNumeric(String input) {
        Matcher matcher = NUMBER.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException(ErrorMessages.VALIDATE_NUMERIC.getErrorMessage());
        }
    }

    private void validateMinimumAmount(int amount) {
        if (amount < MINIMUM_MONEY) {
            throw new IllegalArgumentException(ErrorMessages.VALIDATE_MINIMUM_RANGE.getErrorMessage());
        }
    }

    private void validateDivideByTen(int amount) {
        if (amount % DIVISIBLE_AMOUNT != ZERO){
            throw new IllegalArgumentException(ErrorMessages.VALIDATE_DIVIDE_BY_TEN.getErrorMessage());
        }
    }


}
