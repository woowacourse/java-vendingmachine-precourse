package vendingmachine.utils;
import vendingmachine.domain.ProductList;
import vendingmachine.utils.ExceptionMessage;

import java.util.StringTokenizer;

public class Validator {
    private static final int PRODUCT_INFORMATION_SIZE = 3;
    private static final int DEFAULT = 0;
    private static final int MIN_LIMIT_PRICE = 100;
    private static final int DIVIDED = 10;

    public static void validateNumber(String target){
        if(!target.matches("[0-9]+")) throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER);
    }

    public static void validateProductPrice(String target) {
        if(Integer.parseInt(target) < MIN_LIMIT_PRICE || (Integer.parseInt(target) % DIVIDED) != DEFAULT) throw new IllegalArgumentException(ExceptionMessage.INVALID_PRODUCT_PRICE);
    }

    public static void validateProductInformationIsNull(StringTokenizer stringTokenizer) {
        if(!stringTokenizer.hasMoreTokens()) throw new IllegalArgumentException(ExceptionMessage.NOT_CORRECT_PRODUCT_FORMAT_IS_NULL);
    }

    public static void validateProductInformationSize(int size) {
        if(!(size == PRODUCT_INFORMATION_SIZE)) throw new IllegalArgumentException(ExceptionMessage.NOT_CORRECT_PRODUCT_FORMAT_SIZE);
    }

    public static void validateProductDuplicated(ProductList productList, String productName) {
        if(productList.checkExistUsingName(productName)) throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_PRODUCT);
    }
}
