package vendingmachine.util.validator;

import java.util.Arrays;
import java.util.List;
import vendingmachine.util.ExceptionMessage;

public class ProductsValidator extends Validator {

    public static final int MIN_PRODUCT_NUMBER = 1;
    public static final String SEMI_COLON_REGEX = ";";

    @Override
    public void validate(String input) throws IllegalArgumentException {
        List<String> productsInfo = Arrays.asList(splitBySemiColon(input));
        validateTotalProductsSize(productsInfo);
        productsInfo.stream().forEach(productInfo -> new ProductValidator().validate(productInfo));
    }

    private static String[] splitBySemiColon(String input) {
        return input.split(SEMI_COLON_REGEX);
    }

    private static void validateTotalProductsSize(List<String> productsInfo) {
        if (productsInfo.size() < MIN_PRODUCT_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PRODUCTS_INFO_SIZE.getMessage());
        }
    }
}
