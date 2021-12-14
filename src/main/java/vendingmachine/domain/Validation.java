package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.StringTokenizer;

public class Validation {
    private final int ZERO = 0;
    private final int FIRST = 1;
    private final int DIVISOR = 10;
    private final int MIN_PRICE = 100;
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

    private void checkItemNameOnlySpace(String item) {
        String name = getItemElement(Text.REGEX_ITEM_NAME, item);

        if (name.trim().length() == ZERO) {
            throwException(ErrorMessage.ITEM_NAME_ONLY_SPACE);
        }

    }

    private void checkItemNameSpacePosition(String item) {
        String name = getItemElement(Text.REGEX_ITEM_NAME, item);

        if (name.trim().length() != name.length()) {
            throwException(ErrorMessage.ITEM_NAME_SPACE_POSITION);
        }

    }

    private void checkItemNameOverlap(String itemInput) {
        List<String> names = new ArrayList<>();
        StringTokenizer items = getItemToken(itemInput);

        while (items.hasMoreTokens()) {
            String name = getItemElement(Text.REGEX_ITEM_NAME, items.nextToken());

            if (names.contains(name)) {
                throwException(ErrorMessage.ITEM_NAME_OVERLAP);
            }

            names.add(name);
        }

    }

    private void checkItemPriceNumber(String item) {
        String price = getItemElement(Text.REGEX_ITEM_PRICE, item);

        if (!price.matches(Text.REGEX_NUMBER)) {
            throwException(ErrorMessage.ITEM_PRICE_NOT_NUMBER);
        }

    }

    private void checkItemPriceRange(String item) {
        int price = Integer.parseInt(getItemElement(Text.REGEX_ITEM_PRICE, item));

        if (price < MIN_PRICE || price % DIVISOR != ZERO) {
            throwException(ErrorMessage.ITEM_PRICE_RANGE);
        }

    }

    private void checkItemStockForm(String item) {
        String stock = getItemElement(Text.REGEX_ITEM_STOCK, item);

        if (!stock.matches(Text.REGEX_NUMBER) || Integer.parseInt(stock) == ZERO) {
            throwException(ErrorMessage.ITEM_STOCK_FORM);
        }

    }

    private void checkItemInformation(String itemInput) {
        StringTokenizer items = getItemToken(itemInput);

        while (items.hasMoreTokens()) {
            String item = items.nextToken();

            checkItemNameOnlySpace(item);
            checkItemNameSpacePosition(item);
            checkItemPriceNumber(item);
            checkItemPriceRange(item);
            checkItemStockForm(item);
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
        checkItemInformation(itemInput);
        checkItemNameOverlap(itemInput);
    }
}
