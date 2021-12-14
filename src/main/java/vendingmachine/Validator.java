package vendingmachine;

import static vendingmachine.ErrorMessage.AMOUNT_FORMAT_ERROR_MESSAGE;
import static vendingmachine.ErrorMessage.AMOUNT_NEGATIVE_ERROR_MESSAGE;
import static vendingmachine.ErrorMessage.AMOUNT_UNIT_ERROR_MESSAGE;
import static vendingmachine.ErrorMessage.CONTAINS_BLANK_ERROR_MESSAGE;
import static vendingmachine.ErrorMessage.PRODUCT_DUPLICATE_ERROR_MESSAGE;
import static vendingmachine.ErrorMessage.PRODUCT_INPUT_FORMAT_ERROR_MESSAGE;
import static vendingmachine.ErrorMessage.PRODUCT_PRICE_ERROR_MESSAGE;
import static vendingmachine.ErrorMessage.PRODUCT_QUANTITY_ERROR_MESSAGE;

import java.util.List;

public class Validator {

    private final static int MINIMUM_PRICE_BOUND = 100;
    private final static int MINIMUM_QUANTITY_BOUND = 1;
    private final static String PRODUCT_INFO_INPUT_FORMAT = "\\[[가-힣a-zA-Z0-9]+,\\d+,\\d+]";
    private final static String NEGATIVE_SIGN = "-";
    private final static String BLANK = " ";

    public void validateMoney(String input) {
        checkContainsBlank(input);
        checkNumberFormat(input);
        checkPositiveNumber(input);
        checkMoneyUnit(input);
    }

    public void validateProductInfosInput(String input) {
        checkContainsBlank(input);
        checkProductInputFormat(input);

        Converter converter = new Converter();
        List<String> names = converter.convertToProductNames(input);
        List<String> prices = converter.convertToProductPrices(input);
        List<String> quantities = converter.convertToProductQuantities(input);

        checkNames(names);
        checkPrices(prices);
        checkQuantities(quantities);
    }

    public void checkProductInputFormat(String input) {
        for (String productInfo : input.split(";")) {
            if (!productInfo.matches(PRODUCT_INFO_INPUT_FORMAT)) {
                throw new IllegalArgumentException(PRODUCT_INPUT_FORMAT_ERROR_MESSAGE.getMessage());
            }
        }
    }

    public void validateProductNameInput(String input) {
        checkContainsBlank(input);
    }

    private void checkNames(List<String> names) {
        checkDuplicatedName(names);
    }

    private void checkPrices(List<String> prices) {
        for (String price : prices) {
            checkPositiveNumber(price);
            checkNumberFormat(price);
            checkMoreThanMinimumPrice(price);
            checkMoneyUnit(price);
        }
    }

    private void checkQuantities(List<String> quantities) {
        for (String quantity : quantities) {
            checkPositiveNumber(quantity);
            checkNumberFormat(quantity);
            checkMoreThanMinimumQuantity(quantity);
        }
    }

    private void checkContainsBlank(String input) {
        if (input.contains(BLANK)) {
            throw new IllegalArgumentException(CONTAINS_BLANK_ERROR_MESSAGE.getMessage());
        }
    }

    private void checkDuplicatedName(List<String> names) {
        long duplicateRemovedSize = names.stream()
            .distinct()
            .count();

        if (names.size() != Integer.parseInt(String.valueOf(duplicateRemovedSize))) {
            throw new IllegalArgumentException(PRODUCT_DUPLICATE_ERROR_MESSAGE.getMessage());
        }
    }

    private void checkPositiveNumber(String input) {
        if (input.contains(NEGATIVE_SIGN)) {
            throw new IllegalArgumentException(AMOUNT_NEGATIVE_ERROR_MESSAGE.getMessage());
        }
    }

    private void checkNumberFormat(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException(AMOUNT_FORMAT_ERROR_MESSAGE.getMessage());
            }
        }
    }

    private void checkMoneyUnit(String input) {
        if (input.charAt(input.length() - 1) != '0') {
            throw new IllegalArgumentException(AMOUNT_UNIT_ERROR_MESSAGE.getMessage());
        }
    }

    private void checkMoreThanMinimumPrice(String input) {
        if (Integer.parseInt(input) < MINIMUM_PRICE_BOUND) {
            throw new IllegalArgumentException(PRODUCT_PRICE_ERROR_MESSAGE.getMessage());
        }
    }

    private void checkMoreThanMinimumQuantity(String input) {
        if (Integer.parseInt(input) < MINIMUM_QUANTITY_BOUND) {
            throw new IllegalArgumentException(PRODUCT_QUANTITY_ERROR_MESSAGE.getMessage());
        }
    }
}
