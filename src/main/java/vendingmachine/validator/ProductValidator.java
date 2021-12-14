package vendingmachine.validator;

import vendingmachine.domain.product.Products;

import static vendingmachine.constant.ErrorMessage.*;
import static vendingmachine.constant.SystemMessage.PRODUCT_VALIDATION_REGEX;

public class ProductValidator {
    public static void checkProduct(String product) {
        if (!product.matches(PRODUCT_VALIDATION_REGEX)) {
            throw new IllegalArgumentException(NOT_MATCHED_REGEX_ERROR_MESSAGE);
        }
    }

    public static void checkProductName(String productName) {
        if (productName.length() == 0) {
            throw new IllegalArgumentException(BLANK_NAME_ERROR_MESSAGE);
        }
    }

    public static void checkProductContain(Products products, String name) {
        if (!products.hasProduct(name)) {
            throw new IllegalArgumentException(NOT_CONTAINED_PRODUCTS_ERROR_MESSAGE);
        }
    }
}
