package vendingmachine.domain;

public class Validation {
    private final int ZERO = 0;
    private final int DIVISOR = 10;
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    private void throwException(String errorMessage) {
        this.errorMessage = errorMessage;
        throw new IllegalArgumentException();
    }

    private void checkEmptyInput(String input) {

        if (input.trim().length() == ZERO) {
            throwException(ErrorMessage.EMPTY_INPUT);
        }

    }

    private void checkBalanceOnlyNumber(String balance) {

        if (!balance.matches(Text.REGEX_NUMBER)) {
            throwException(ErrorMessage.BALANCE_NOT_NUMBER);
        }

    }

    private void checkBalanceRange(String balance) {

        if (Integer.parseInt(balance) % DIVISOR != ZERO) {
            throwException(ErrorMessage.BALANCE_RANGE);
        }

    }

    public void isValidBalanceInput(String balance) {
        checkEmptyInput(balance);
        checkBalanceOnlyNumber(balance);
        checkBalanceRange(balance);
    }
}
