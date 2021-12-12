package vendingmachine.utils.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import vendingmachine.domain.Product;

public class ProductInfoValidator {

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

        String validName = getValidProductName(productInfoMatcher.group(PRODUCT_NAME_INDEX));
        int validPrice = getValidProductPrice(productInfoMatcher.group(PRODUCT_PRICE_INDEX));
        int validStock = getValidProductStock(productInfoMatcher.group(PRODUCT_STOCK_INDEX));

        return new Product(validName, validPrice, validStock);
    }

    private static String getValidProductName(final String name) { // TODO implement Exception cases
        return name;
    }

    private static int getValidProductPrice(final String price) { // TODO implement Exception cases
        return NumberValidator.getValidNumber(price, "");
    }

    private static int getValidProductStock(final String stock) { // TODO implement Exception cases
        return NumberValidator.getValidNumber(stock, "");
    }
}
