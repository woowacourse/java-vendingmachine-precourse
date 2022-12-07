package vendingmachine.util.validator;

import java.util.List;
import vendingmachine.util.Index;
import vendingmachine.util.ExceptionMessage;
import vendingmachine.util.Util;

public class ProductValidator extends Validator {

    public static final int CORRECT_SIZE = 3;
    public static final int MIN_PRICE = 100;

    @Override
    public void validate(String input) throws IllegalArgumentException {
        List<String> productInfo = Util.formatProductInfo(input);
        validateInfoSize(productInfo);
        validateProductPrice(productInfo);
        validateProductQuantity(productInfo);
    }


    private void validateProductQuantity(List<String> productInfo) {
        String productQuantity = productInfo.get(Index.PRODUCT_QUANTITY_INDEX.getIndex());
        validateNumeric(productQuantity);
        validateRange(productQuantity);
    }

    private void validateProductPrice(List<String> productInfo) {
        String productPrice = productInfo.get(Index.PRODUCT_PRICE_INDEX.getIndex());
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
