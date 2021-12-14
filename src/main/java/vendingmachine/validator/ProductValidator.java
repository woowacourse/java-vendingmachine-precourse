package vendingmachine.validator;

import static vendingmachine.constant.ErrorMessage.NOT_MATCHED_REGEX_ERROR_MESSAGE;

public class ProductValidator {
    public static void checkProduct(String product) {
        if (!product.matches("\\[.+,\\d+,\\d+\\]")) {
            throw new IllegalArgumentException(NOT_MATCHED_REGEX_ERROR_MESSAGE);
        }
    }
}
