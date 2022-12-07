package vendingmachine.util.validator;

import java.util.Arrays;
import java.util.List;
import vendingmachine.util.ExceptionMessage;

public class ProductsValidator extends Validator {

    @Override
    public void validate(String input) throws IllegalArgumentException {
        List<String> productsInfo = Arrays.asList(input.split(";"));
        validateTotalProductsSize(productsInfo);
        for(String productInfo: productsInfo){
            new ProductValidator().validate(productInfo);
        }
    }

    private static void validateTotalProductsSize(List<String> productsInfo) {
        if (productsInfo.size() < 1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PRODUCTS_INFO_SIZE.getMessage());
        }
    }
}
