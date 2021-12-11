package vendingmachine.util;

import vendingmachine.model.Product;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
    private static final String DIVISOR_PRODUCT_LIST = ";";
    private static final String DIVISOR_PRODUCT = ",";
    private static final int NEGATIVE_NUMBER = -1;
    private static final char OPEN_BRACKET = '[';
    private static final char CLOSE_BRACKET = ']';

    public boolean isStringEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public String[] splitProductInfo(String input) {
        return input.substring(1, input.length() - 1).split(DIVISOR_PRODUCT);
    }

    public String[] splitProductList(String str) {
        return str.split(DIVISOR_PRODUCT_LIST, NEGATIVE_NUMBER);
    }

    public List<Product> convertStringToProductList(String input) {
        return new ArrayList<>();
    }
}
