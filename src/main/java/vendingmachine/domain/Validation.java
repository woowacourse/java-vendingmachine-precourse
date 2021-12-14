package vendingmachine.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.StringTokenizer;

public class Validation {
    private final int ZERO = 0;
    private final int FIRST = 1;
    private final int DIVISOR = 10;
    private String errorMessage;

    public String getErrorMessage() {
        return ErrorMessage.ERROR + errorMessage;
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

    public StringTokenizer getItemToken(String itemInput) {
        return new StringTokenizer(itemInput, Text.SEMICOLON);
    }

    public String getItemElement(String REGEX, String item) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(item);
        matcher.find();

        return matcher.group(FIRST);
    }

    private void checkItemInputForm(String itemInput) {
        int lastIndex = itemInput.length() - 1;

        if (itemInput.charAt(ZERO) == Text.SEMICOLON.charAt(ZERO)
                || itemInput.charAt(lastIndex) == Text.SEMICOLON.charAt(ZERO)) {
            throwException(ErrorMessage.ITEM_INPUT_FORM);
        }

    }

    private void checkItemInformationForm(String itemInput) {
        StringTokenizer items = getItemToken(itemInput);

        while (items.hasMoreTokens()) {

            if (!items.nextToken().matches(Text.REGEX_ITEM_FORM)) {
                throwException(ErrorMessage.ITEM_INPUT_FORM);
            }

        }

    }

    public void isValidBalanceInput(String balance) {
        checkEmptyInput(balance);
        checkBalanceOnlyNumber(balance);
        checkBalanceRange(balance);
    }

    public void isValidItemInput(String itemInput) {
        checkEmptyInput(itemInput);
        checkItemInputForm(itemInput);
        checkItemInformationForm(itemInput);
    }
}
