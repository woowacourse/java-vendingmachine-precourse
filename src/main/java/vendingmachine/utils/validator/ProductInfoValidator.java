package vendingmachine.utils.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import vendingmachine.domain.Product;

public class ProductInfoValidator {

    public static final String PRODUCT_INVALID_FORMAT_ERROR_MESSAGE = "상품 정보 형식이 올바르지 않습니다. \"[상품명1, 상품 가격1, 상품 수량1];[상품명2, 상품 가격2, 상품 수량2]...\" 형식으로 입력해 주세요.";
    public static final String PRODUCT_DROPPED_INFO_ERROR_MESSAGE = "누락된 정보가 있습니다. 상품명, 가격, 수량을 확인해 주세요.";
    private static final String SEMICOLON_SEPARATION_REGEX = "\\s*;\\s*";
    private static final Pattern PRODUCT_INFO_PATTERN = Pattern.compile(
        "^\\[\\s*(.*)\\s*,\\s*(.*)\\s*,\\s*(.*)\\s*\\]$");
    private static final int PRODUCT_NAME_INDEX = 1;
    private static final int PRODUCT_PRICE_INDEX = 2;
    private static final int PRODUCT_STOCK_INDEX = 3;

    public static List<Product> getValidProductList(final String input) {
        List<Product> productList = new ArrayList<>();
        Arrays.stream(input.split(SEMICOLON_SEPARATION_REGEX))
            .forEach(productInfo -> productList.add(getValidProduct(productInfo)));
        return productList;
    }

    private static Product getValidProduct(final String productInfo) {

        Matcher productInfoMatcher = PRODUCT_INFO_PATTERN.matcher(productInfo);

        if (!productInfoMatcher.matches()) {
            throw new IllegalArgumentException(PRODUCT_INVALID_FORMAT_ERROR_MESSAGE);
        }

        String validName = getValidProductName(productInfoMatcher.group(PRODUCT_NAME_INDEX));
        int validPrice = getValidProductPrice(productInfoMatcher.group(PRODUCT_PRICE_INDEX));
        int validStock = getValidProductStock(productInfoMatcher.group(PRODUCT_STOCK_INDEX));

        return new Product(validName, validPrice, validStock);
    }

    private static String getValidProductName(final String name) { // TODO implement Exception cases
        validateIsNotDropped(name);
        return name;
    }

    private static int getValidProductPrice(final String price) { // TODO implement Exception cases
        validateIsNotDropped(price);
        return NumberValidator.getValidNumber(price, "");
    }

    private static int getValidProductStock(final String stock) { // TODO implement Exception cases
        validateIsNotDropped(stock);
        return NumberValidator.getValidNumber(stock, "");
    }

    private static void validateIsNotDropped(final String input) {
        if (input.length() == 0) {
            throw new IllegalArgumentException(PRODUCT_DROPPED_INFO_ERROR_MESSAGE);
        }
    }
}
