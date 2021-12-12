package vendingmachine.utils.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import vendingmachine.domain.Product;

public class ProductInfoValidator {

    private static final String NVALID_FORMAT_ERROR_MESSAGE = "상품 정보 형식이 올바르지 않습니다. \"[상품명1, 상품 가격1, 상품 수량1];[상품명2, 상품 가격2, 상품 수량2]...\" 형식으로 입력해 주세요.";
    private static final String DROPPED_INFO_ERROR_MESSAGE = "누락된 정보가 있습니다. 상품명, 가격, 수량을 확인해 주세요.";
    private static final String INVALID_NAME_ERROR_MESSAGE = "상품명은 한글, 숫자, 영문으로만 이루어진 이름이어야 합니다.";
    private static final String INVALID_NUMBER_PRICE_ERROR_MESSAGE = "상품 가격은 반드시 10억 이하의 숫자여야 합니다.";
    private static final String LESS_THAN_100_PRICE_ERROR_MESSAGE = "상품 가격은 반드시 100원 이상이어야 합니다.";
    private static final String NOT_DIVISIBLE_BY_10_PRICE_ERROR_MESSAGE = "상품 가격의 최소 단위는 10이어야 합니다.";
    private static final String INVALID_NUMBER_STOCK_ERROR_MESSAGE = "상품 수량은 반드시 10억 이하의 숫자여야 합니다.";
    private static final String NEGATIVE_STOCK_ERROR_MESSAGE = "상품 가격은 반드시 0 이상이어야 합니다.";
    private static final String SEMICOLON_SEPARATION_REGEX = "\\s*;\\s*";
    private static final Pattern PRODUCT_INFO_PATTERN = Pattern.compile(
        "^\\[\\s*(.*)\\s*,\\s*(.*)\\s*,\\s*(.*)\\s*\\]$");
    private static final Pattern PRODUCT_NAME_PATTERN = Pattern.compile("^[가-힣ㄱ-ㅎㅏ-ㅣa-zA-Z0-9]+$");
    private static final int PRODUCT_NAME_INDEX = 1;
    private static final int PRODUCT_PRICE_INDEX = 2;
    private static final int PRODUCT_STOCK_INDEX = 3;
    private static final int MAX_PRICE_AND_STOCK = 1000000000;
    private static final int MIN_PRICE = 100;
    private static final int MIN_STOCK = 0;

    public static List<Product> getValidProductList(final String input) {
        List<Product> productList = new ArrayList<>();
        Arrays.stream(input.split(SEMICOLON_SEPARATION_REGEX))
            .forEach(productInfo -> productList.add(getValidProduct(productInfo)));
        return productList;
    }

    private static Product getValidProduct(final String productInfo) {

        Matcher productInfoMatcher = PRODUCT_INFO_PATTERN.matcher(productInfo);

        if (!productInfoMatcher.matches()) {
            throw new IllegalArgumentException(NVALID_FORMAT_ERROR_MESSAGE);
        }

        String validName = getValidProductName(productInfoMatcher.group(PRODUCT_NAME_INDEX));
        int validPrice = getValidProductPrice(productInfoMatcher.group(PRODUCT_PRICE_INDEX));
        int validStock = getValidProductStock(productInfoMatcher.group(PRODUCT_STOCK_INDEX));

        return new Product(validName, validPrice, validStock);
    }

    private static String getValidProductName(final String name) {
        validateIsNotDropped(name);
        validateName(name);
        return name;
    }

    public static void validateName(String name) {
        if (!PRODUCT_NAME_PATTERN.matcher(name).matches()) {
            throw new IllegalArgumentException(INVALID_NAME_ERROR_MESSAGE);
        }
    }

    private static int getValidProductPrice(final String price) {
        validateIsNotDropped(price);
        int intPrice = NumberValidator.getValidNumber(price, INVALID_NUMBER_PRICE_ERROR_MESSAGE);
        NumberValidator.validateNotExceedMaxValue(intPrice, MAX_PRICE_AND_STOCK,
            INVALID_NUMBER_PRICE_ERROR_MESSAGE);
        NumberValidator.validateNotExceedMinValue(intPrice, MIN_PRICE, LESS_THAN_100_PRICE_ERROR_MESSAGE);
        NumberValidator.validateDivisibleByTen(intPrice, NOT_DIVISIBLE_BY_10_PRICE_ERROR_MESSAGE);
        return intPrice;
    }

    private static int getValidProductStock(final String stock) {
        validateIsNotDropped(stock);
        int intStock = NumberValidator.getValidNumber(stock, INVALID_NUMBER_STOCK_ERROR_MESSAGE);
        NumberValidator.validateNotExceedMaxValue(intStock, MAX_PRICE_AND_STOCK,
            INVALID_NUMBER_STOCK_ERROR_MESSAGE);
        NumberValidator.validateNotExceedMinValue(intStock, MIN_STOCK, NEGATIVE_STOCK_ERROR_MESSAGE);
        return intStock;
    }

    public static void validateIsNotDropped(final String input) {
        if (input.length() == 0) {
            throw new IllegalArgumentException(DROPPED_INFO_ERROR_MESSAGE);
        }
    }
}
