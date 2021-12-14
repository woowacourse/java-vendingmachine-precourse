package vendingmachine.validator;

import static vendingmachine.constant.ErrorMessage.NOT_MATCHED_REGEX_ERROR_MESSAGE;
import static vendingmachine.constant.SystemMessage.PRODUCT_VALIDATION_REGEX;

public class ProductValidator {
    public static void checkProduct(String product) {
        if (!product.matches(PRODUCT_VALIDATION_REGEX)) {
            throw new IllegalArgumentException(NOT_MATCHED_REGEX_ERROR_MESSAGE);
        }
    }
}
