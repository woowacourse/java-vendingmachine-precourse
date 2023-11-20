package utils;

import vendingmachine.Product;
import vendingmachine.Products;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    private static final String NUMBER_REGEX = "^[0-9]+$";
    private static final String ORDER_REGEX = "\\[([^;]+),(\\d+),(\\d+)\\](?:;\\[([^;]+),(\\d+),(\\d+)\\])?;";
    private static final Pattern NUMBER = Pattern.compile(NUMBER_REGEX);
    private static final Pattern ORDER = Pattern.compile(ORDER_REGEX);

    public static void validateBlank(String input) {
        if (input.isEmpty()){
            throw new IllegalArgumentException(ErrorMessages.VALIDATE_BLANK.getErrorMessage());
        }
    }

    public static void validateIsNumeric(String input) {
        Matcher matcher = NUMBER.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException(ErrorMessages.VALIDATE_NUMERIC.getErrorMessage());
        }
    }

    public static void validateIsOrderFormat(String input) {
        Matcher matcher = ORDER.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException(ErrorMessages.VALIDATE_ORDER_FORMAT.getErrorMessage());
        }
    }

    public static void validatePurchaseProductExist(Products products , String input) {
        Map<String, Product> productMap = products.getProductMap();
        for (String savedName : productMap.keySet()) {
            if (savedName.equals(input)) {
                return;
            }
        }
        throw new IllegalArgumentException(ErrorMessages.VALIDATE_EXIST_NAME.getErrorMessage());
    }
}
