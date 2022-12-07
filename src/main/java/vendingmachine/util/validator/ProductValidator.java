package vendingmachine.util.validator;

import java.util.Arrays;
import java.util.List;
import vendingmachine.util.Constants;
import vendingmachine.util.ExceptionMessage;
import vendingmachine.util.Util;

public class ProductValidator extends Validator {

    public static final int CORRECT_SIZE = 3;
    public static final int MIN_PRICE = 100;

    @Override
    public void validate(String input) throws IllegalArgumentException {
        List<String> productInfo = formatProductInfo(input);
        validateInfoSize(productInfo);
        validateProductPrice(productInfo);
        validateProductQuantity(productInfo);
    }

    private static List<String> formatProductInfo(String input) {
        return splitByComma(Util.removeDelimiters(Util.removeSpace(input)));
    }


    private static List<String> splitByComma(String input) {
        return Arrays.asList(Util.removeSpace(input).split(","));
    }

    private void validateProductQuantity(List<String> productInfo) {
        String productQuantity = productInfo.get(Constants.PRODUCT_QUANTITY_INDEX.getValue());
        validateNumeric(productQuantity);
        validateRange(productQuantity);
    }

    private void validateProductPrice(List<String> productInfo) {
        String productPrice = productInfo.get(Constants.PRODUCT_PRICE_INDEX.getValue());
        validateNumeric(productPrice);
        validateRange(productPrice);
        validatePriceRange(productPrice);
        validateUnit(productPrice);
    }

    private static void validatePriceRange(String productPrice) {
        if (Integer.parseInt(productPrice) < MIN_PRICE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PRODUCT_PRICE_RANGE.getMessage());
        }
    }

    private static void validateInfoSize(List<String> productInfo) {
        if (productInfo.size() != CORRECT_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PRODUCT_INFO.getMessage());
        }
    }

}
