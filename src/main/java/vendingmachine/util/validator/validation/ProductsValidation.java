package vendingmachine.util.validator.validation;

import vendingmachine.util.validator.CommonValidator;
import vendingmachine.util.validator.ProductsInfoValidator;

import static vendingmachine.util.validator.error.Error.*;

public class ProductsValidation {

    public static void verifyProductsInput(String userInput) {
        CommonValidator.isNull(userInput,
                () -> new IllegalArgumentException(FOUND_NULL.getMessage()));

        ProductsInfoValidator.verifySeparator(userInput,
                () -> new IllegalArgumentException(INPUT_SEPARATOR_NOT_ACCEPT.getMessage()));
        ProductsInfoValidator.verifyRegex(userInput,
                () -> new IllegalArgumentException(INPUT_REGEX_NOT_ACCEPT.getMessage()));
        ProductsInfoValidator.verifyDuplicateProductName(userInput,
                () -> new IllegalArgumentException(INPUT_PRODUCT_NAME_HAS_DUPLICATED.getMessage()));
    }

    public static void verifyProductInputIsNull(String productName) {
        CommonValidator.isNull(productName,
                () -> new IllegalArgumentException(INPUT_HAS_NULL.getMessage()));
    }
}
